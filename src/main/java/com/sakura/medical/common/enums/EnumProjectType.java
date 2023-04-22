package com.sakura.medical.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/3/13 21:15
 */
@Getter
@AllArgsConstructor
public enum EnumProjectType {

    SCIENCE_TECHNOLOGY(1, "科技"),
    COMMERCIAL_AFFAIRS(2, "商务"),
    DEVELOPMENT_REFORM(3, "发改"),
    MIIT(4, "工信"),
    ;
    private Integer cold;
    private String value;

}
