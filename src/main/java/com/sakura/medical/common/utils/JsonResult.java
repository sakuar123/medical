package com.sakura.medical.common.utils;


import com.alibaba.fastjson.JSON;
import com.sakura.medical.common.enums.EnumJsonResultMsg;
import com.sakura.medical.common.enums.base.IMessageConstant;
import com.sakura.medical.common.exception.ErrorException;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回给前端的Json容器工具
 * @author 李七夜
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> {

    @ApiModelProperty(value = "返回码", required = true)
    private Integer code;
    @ApiModelProperty(value = "返回码说明", required = true)
    private String message;
    @ApiModelProperty(value = "返回数据", required = true)
    private T data;

    public static JsonResult<Boolean> success() {
        return success(Boolean.TRUE);
    }

    public static <T> JsonResult<T> success(T data) {
        return of(EnumJsonResultMsg.OK, data);
    }

    public static <T> JsonResult<T> error(String message) {
        return (JsonResult<T>) of(EnumJsonResultMsg.build(message), Boolean.FALSE);
    }

    public static <T> JsonResult<T> error(IMessageConstant constant) {
        return of(constant, null);
    }

    public static <T> JsonResult<T> error(IMessageConstant constant, T data) {
        return of(constant, data);
    }

    public static <T> JsonResult<T> of(IMessageConstant constant, T data) {
        return of(constant.getCode(), constant.getMessage(), data);
    }

    public static <T> JsonResult<T> of(Integer code, String message, T data) {
        return new JsonResult<>(code, message, data);
    }

    public static <T> JsonResult<T> of(ErrorException e) {
        return new JsonResult<>(e.getCode(), e.getMsg(), null);
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
