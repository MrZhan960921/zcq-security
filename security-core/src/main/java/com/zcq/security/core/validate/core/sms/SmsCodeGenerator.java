package com.zcq.security.core.validate.core.sms;


import com.zcq.security.core.properties.SecurityProperties;
import com.zcq.security.core.validate.core.ValidateCode;
import com.zcq.security.core.validate.core.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getValidateCode().getSmsCode().getLength());
        return new ValidateCode(code, securityProperties.getValidateCode().getSmsCode().getExpireIn());
    }


    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
