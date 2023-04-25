package com.gutjahr.funcionario.config;

import com.gutjahr.funcionario.dto.ResponseDTO;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ResponseDTOResolver implements HandlerMethodArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1,
                                  NativeWebRequest arg2, WebDataBinderFactory arg3) throws Exception {
        return new ResponseDTO().setSuccess(true);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter != null && parameter.getParameterType().equals(ResponseDTO.class);
    }
}
