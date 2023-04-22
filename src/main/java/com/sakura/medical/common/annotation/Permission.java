package com.sakura.medical.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sakura.medical.common.enums.EnumPermission;

/**
 * @author 李七夜
 * Created by 李七夜 on 2021/12/25 20:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

    boolean noLogin() default false;

    EnumPermission[] permission() default {};
}
