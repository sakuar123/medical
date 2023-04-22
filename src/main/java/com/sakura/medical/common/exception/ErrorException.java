package com.sakura.medical.common.exception;


import com.sakura.medical.common.enums.EnumJsonResultMsg;
import com.sakura.medical.common.enums.base.IMessageConstant;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by 李七夜 on 2020/5/13 11:07
 * 自定义的异常类
 * @author 李七夜
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ErrorException extends RuntimeException {

    private static final long serialVersionUID = -7677230804556063870L;

    private Integer code;

    private String msg;

    private Boolean data = Boolean.FALSE;

    public ErrorException() {
        super();
    }

    public ErrorException(String message) {
        super(message);
        this.msg = message;
        this.code = EnumJsonResultMsg.ERROR.getCode();
    }

    public ErrorException(IMessageConstant iMessageConstant) {
        this.code = iMessageConstant.getCode();
        this.msg = iMessageConstant.getMessage();
    }

    public ErrorException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
