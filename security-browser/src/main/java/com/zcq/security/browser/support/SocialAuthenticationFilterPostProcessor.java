package com.zcq.security.browser.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * 社交认证过滤器后处理器
 */
public interface SocialAuthenticationFilterPostProcessor {

    void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
