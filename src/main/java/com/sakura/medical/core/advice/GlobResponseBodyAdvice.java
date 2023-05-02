package com.sakura.medical.core.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSON;
import com.sakura.medical.common.utils.JsonResult;

/**
 * @author 李七夜
 * 处理请求成功后统一返回处理类
 * 加上需要扫描的包
 * Created by 李七夜 on 2023/2/28 14:39
 */
@ControllerAdvice(basePackages = "com.sakura.medical.web.controller")
public class GlobResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 是否开启功能
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 处理返回结果
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {
        return JSON.toJSON(JsonResult.success(o));
    }
}
