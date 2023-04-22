package com.sakura.medical.core.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sakura.medical.common.annotation.Permission;
import com.sakura.medical.common.enums.EnumJsonResultMsg;
import com.sakura.medical.common.utils.Assert;
import com.sakura.medical.common.utils.ObjectTools;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by 李七夜 on 2020/5/14 15:49
 * 登录校验拦截器
 * @author 李七夜
 */
@Slf4j
public class TicketInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //获取当前方法上的指定注解,判断是否需要登录
        Permission permission = method.getAnnotation(Permission.class);
        if (permission != null && permission.noLogin()) {
            request.setAttribute("noLogin", true);
            return true;
        }
        //从请求头中获取登录的token,如果没有传入直接返回提示用户登录
        String userToken = request.getHeader("token");
        Assert.isTrue(ObjectTools.isNotBlank(userToken), EnumJsonResultMsg.USER_NOT_LOGIN);

        //解密JWT,如果解密失败,直接返回提示用户

        //从缓存中取出token,判断是否过期

        //判断下缓存里的token是不是跟传进来的一样

        //将userId放到request内置参数中,方便后面方法获取

        return true;
    }
}
