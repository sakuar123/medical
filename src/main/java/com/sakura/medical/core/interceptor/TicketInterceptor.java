package com.sakura.medical.core.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.cors.reactive.PreFlightRequestHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.sakura.medical.common.annotation.Permission;
import com.sakura.medical.common.enums.EnumJsonResultMsg;
import com.sakura.medical.common.utils.Assert;
import com.sakura.medical.common.utils.CommonConstant;
import com.sakura.medical.common.utils.JwtUtil;
import com.sakura.medical.common.utils.ObjectTools;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by 李七夜 on 2020/5/14 15:49
 * 登录校验拦截器
 *
 * @author 李七夜
 */
@Slf4j
public class TicketInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //axios在发起请求的时候,会请求两次,第一次是判断接口能不能请求,所以如果是ResourceHttpRequestHandler类型的直接返回就跨域了
        if (handler instanceof HandlerMethod) {
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
            Claims claims = JwtUtil.parseJwt(userToken);
            Assert.isTrue(ObjectTools.isNotBlank(claims), EnumJsonResultMsg.USER_LOGIN);
            //从缓存中取出token,判断是否过期
            String redisKey = StringUtils.join(CommonConstant.REDIS_USER_KEY, claims.get("id"));
            String redisToken = redisTemplate.opsForValue().get(redisKey);
            Assert.isTrue(ObjectTools.isNotBlank(redisToken), EnumJsonResultMsg.USER_TOKEN_TIME);
            //判断下缓存里的token是不是跟传进来的一样
            Assert.isTrue(userToken.equals(redisToken), EnumJsonResultMsg.USER_TOKEN_ERR);
            //将userId放到request内置参数中,方便后面方法获取
            request.setAttribute("userId", claims.get("id"));
            request.setAttribute("roleId", claims.get("roleId"));
            return true;
        }
        return true;
    }
}
