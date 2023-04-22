package com.sakura.medical.common.utils;

/**
 * Created by 李七夜 on 2020/5/8 19:25
 * 公共常量枚举
 * @author 李七夜
 */
public class CommonConstant {

    private CommonConstant() {

    }

    //============redis相关=============//
    //redis存放用户登录信息
    public static final String REDIS_USER_KEY = "REDIS_USER_KEY:";
    //redis:用户权限信息
    public static final String REDIS_LOGIN_NAME = "REDIS_LOGIN_NAME:";
    //redis:用户权限信息
    public static final String REDIS_LOGIN_EMAIL = "REDIS_LOGIN_EMAIL:";
    //redis:用户权限信息
    public static final String REDIS_PERMISSION = "REDIS_PERMISSION:";
}
