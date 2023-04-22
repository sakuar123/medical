package com.sakura.medical.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/3/25 20:05
 */
@Getter
@AllArgsConstructor
public enum EnumProjectLevel {
    CITY(1, "市级"),
    PROVINCE(2, "省级"),
    COUNTRY(3, "国家级"),
    ;
    private Integer code;
    private String value;
}
