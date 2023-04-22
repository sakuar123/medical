package com.sakura.medical.common.enums;

import com.sakura.medical.common.enums.base.IMessageConstant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 李七夜
 * JsonResult出去的状态码
 */
@Getter
@AllArgsConstructor
public enum EnumJsonResultMsg implements IMessageConstant {

    //正常响应的状态码
    OK(200, "ok"),
    //发生异常响应的状态码
    ERROR(500, "系统异常"),

    //==================代表用户行为的状态码======================//
    USER_NOT_LOGIN(101, "请先登录!"),
    USER_NAME_OR_PWD_ERROR(102, "用户名或密码错误!"),
    USET_NO_AUTHOR(103, "无权限!"),
    USER_BAD(105, "用户不存在或已被冻结"),
    USER_EXITS(106, "该手机号已经被注册了,请换个手机号注册"),
    USER_NOT_EXITS(107, "未注册，请先注册"),
    USER_TOKEN_ERR(108, "非法的token,请重新登录!"),
    USER_IS_EXTIS(109, "用户已存在,请勿重复添加!"),
    USER_EMAIL_IS_EMPTIY(111, "邮箱未开通,请先申请账户!"),
    USER_PHONE_BAD(112, "手机号不存在或已被冻结"),
    USER_NO_QX(113, "无权限"),
    USER_TOKEN_TIME(114, "token已失效,请重新登录"),
    USER_CAPTCHA_BAD(115, "验证码错误或已过期!"),
    USER_LOGIN(116, "会话已过期,请重新登录!"),
    ;
    private int code;
    private String message;

    public static EnumJsonResultMsg build(String message) {
        EnumJsonResultMsg.ERROR.message = message;
        return EnumJsonResultMsg.ERROR;
    }

    public static void main(String[] args) {
        System.out.println(build("123123").getMessage());
    }

}
