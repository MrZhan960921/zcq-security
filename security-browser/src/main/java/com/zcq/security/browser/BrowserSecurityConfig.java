package com.zcq.security.browser;

import com.zcq.security.browser.authentication.ImoocAuthenctiationFailureHandler;
import com.zcq.security.browser.authentication.ImoocAuthenticationSuccessHandler;
import com.zcq.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: zcq
 * @Date: 2019/4/9 11:32
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 验证错误处理器
     */
    @Autowired
    private ImoocAuthenctiationFailureHandler imoocAuthenctiationFailureHandler;

    /**
     * 验证成功处理器
     */
    @Autowired
    private ImoocAuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    /**
     * 设置加密解密算法
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                        http.formLogin()
                                .loginPage("/authentication/require")
                                .loginProcessingUrl("/authentication/form")
                                .successHandler(imoocAuthenticationSuccessHandler)
                                .failureHandler(imoocAuthenctiationFailureHandler)
                                .and()
                                .authorizeRequests()
                                .antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage()).permitAll() //对于这个页面请求不需要身份认证，对于登录页面不需要身份验证。
                                .anyRequest()
                                .authenticated()
                                .and()
                                .csrf().disable();

    }
}
