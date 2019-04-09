package com.zcq.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    /**
     * 验证码实现方法接口
     * @param request
     * @return
     */
    ImageCode generate(ServletWebRequest request);

}