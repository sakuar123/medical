package com.sakura.medical.entity;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 医生信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-15
 */
@Getter
@Setter
@TableName("doctors_info")
@ApiModel(value = "DoctorsInfo对象", description = "医生信息表")
public class DoctorsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("医生名称")
    @TableField("doctor_name")
    private String doctorName;

    @ApiModelProperty("医生头像")
    @TableField("doctor_img")
    private String doctorImg;

    @TableField(exist = false)
    private File doctorImgFile;

    @ApiModelProperty("所属院区")
    @TableField("hospital_id")
    private Integer hospitalId;

    @ApiModelProperty("所属科室")
    @TableField("department_id")
    private Integer departmentId;

    @ApiModelProperty("医生职称")
    @TableField("professional_id")
    private Integer professionalId;

    @ApiModelProperty("医生标签")
    @TableField("doctor_lable")
    private String doctorLable;

    @ApiModelProperty("挂号费")
    @TableField("registration_fee")
    private BigDecimal registrationFee;

    @ApiModelProperty("诊察费")
    @TableField("examination_fee")
    private BigDecimal examinationFee;

    @ApiModelProperty("医生简介")
    @TableField("doctor_desc")
    private String doctorDesc;

    @ApiModelProperty("医生状态")
    @TableField("doctor_state")
    private Integer doctorState;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;


}
