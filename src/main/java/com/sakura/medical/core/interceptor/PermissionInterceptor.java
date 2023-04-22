package com.sakura.medical.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sakura.medical.common.utils.ObjectTools;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 李七夜
 * 权限拦截器
 * Created by 李七夜 on 2020/8/25 16:28
 */
@Slf4j
public class PermissionInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 在请求接口之前,登录拦截器之后,校验用户的权限,根据用户请求的url判断是包含该权限
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (ObjectTools.isNotBlank(request.getAttribute("noLogin"))) {
            return true;
        }
        return true;
    }

    /**
     * 试图渲染之后,添加用户行为日志
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
