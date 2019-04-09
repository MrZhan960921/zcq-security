package com.zcq.security.browser;

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
            .and()
            // 对请求授权配置：注意方法名的含义，能联想到一些
            .authorizeRequests()
            .anyRequest()
            // 对任意请求都必须是已认证才能访问
            .authenticated();


    }
}
