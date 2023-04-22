package com.sakura.medical.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/3/25 20:05
 */
@Getter
@AllArgsConstructor
public enum EnumProjectFundStatus {
    SUBMIT(0, "待提交"),
    EXAMINE(1, "待审核"),
    SUCCESS(2, "已通过"),
    REJECT(-1, "已驳回"),
    ;
    private Integer code;
    private String value;
}
