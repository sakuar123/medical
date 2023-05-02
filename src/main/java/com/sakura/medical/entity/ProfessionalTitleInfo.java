package com.sakura.medical.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sakura.medical.common.utils.DateUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 职称信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-09
 */
@Getter
@Setter
@Builder
@TableName("professional_title_info")
@ApiModel(value = "ProfessionalTitleInfo对象", description = "职称信息表")
public class ProfessionalTitleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("职称名称")
    @TableField("professional_title_name")
    private String professionalTitleName;

    @ApiModelProperty("挂号费")
    @TableField("registration_fee")
    private BigDecimal registrationFee;

    @ApiModelProperty("职称描述")
    @TableField("professional_title_desc")
    private String professionalTitleDesc;

    @ApiModelProperty("职称状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    @JsonFormat(pattern = DateUtils.SECOND_DATE_PATTERN)
    private LocalDateTime createDate;


}
