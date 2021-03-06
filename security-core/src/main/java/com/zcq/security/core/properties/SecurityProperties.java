package com.zcq.security.core.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "earthchen.security")
public class SecurityProperties {

    /**
     * 浏览器端配置
     */
    private BrowserProperties browser = new BrowserProperties();


    /**
     * 验证码配置
     */
    private ValidateCodeProperties validateCode = new ValidateCodeProperties();

    /**
     * 社交登录相关配置
     */
    private SocialProperties social = new SocialProperties();

    public ValidateCodeProperties getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(ValidateCodeProperties validateCode) {
        this.validateCode = validateCode;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }
}
