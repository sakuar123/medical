package com.sakura.medical.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/5/15 21:30
 */
@Getter
@AllArgsConstructor
public enum EnumDoctorLables {
    肝功能(1, "肝功能"),
    肾功能(2, "肾功能"),
    心脑血管(3, "心脑血管"),
    泌尿学科(4, "泌尿学科"),
    心脏病(5, "心脏病"),
    尿毒症(6, "尿毒症"),
    糖尿病(7, "糖尿病"),
    肾病(8, "肾病"),
    ;
    private Integer code;
    private String value;
}
