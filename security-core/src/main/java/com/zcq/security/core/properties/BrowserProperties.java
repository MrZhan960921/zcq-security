package com.zcq.security.core.properties;


public class BrowserProperties {

    /**
     * 登录页
     */
    private String loginPage = "/imooc-signIn.html";

    /**
     * 注册页
     */
    private String registerPage = "/imooc-signUp.html";
    /**
     * 登录响应类型
     */
    private LoginResponseType loginType = LoginResponseType.JSON;

    /**
     * 记住我时间秒数
     */
    private int rememberMeSeconds = 3600;
    /**
     * session配置
     */
    private SessionProperties session = new SessionProperties();
    /**
     * 退出成功时跳转的url，如果配置了，则跳到指定的url，如果没配置，则返回json数据。
     */
    private String signOutUrl;

    public String getSignOutUrl() {
        return signOutUrl;
    }

    public void setSignOutUrl(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }



    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getRegisterPage() {
        return registerPage;
    }

    public void setRegisterPage(String registerPage) {
        this.registerPage = registerPage;
    }
}
