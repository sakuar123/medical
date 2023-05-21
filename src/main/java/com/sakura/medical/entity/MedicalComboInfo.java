package com.sakura.medical.entity;

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
 * 体检套餐信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-21
 */
@Getter
@Setter
@TableName("medical_combo_info")
@ApiModel(value = "MedicalComboInfo对象", description = "体检套餐信息表")
public class MedicalComboInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("套餐名称")
    @TableField("combo_name")
    private String comboName;

    @ApiModelProperty("套餐图片")
    @TableField("combo_img")
    private String comboImg;

    @TableField(exist = false)
    private String comboImgFile;

    @ApiModelProperty("套餐类型")
    @TableField("combo_type_id")
    private Integer comboTypeId;

    @ApiModelProperty("所属院区")
    @TableField("hospital_id")
    private Integer hospitalId;

    @ApiModelProperty("套餐项目")
    @TableField("medical_examination_id")
    private String medicalExaminationId;

    @ApiModelProperty("项目价格")
    @TableField("combo_price")
    private BigDecimal comboPrice;

    @ApiModelProperty("套餐介绍")
    @TableField("combo_desc")
    private String comboDesc;

    @ApiModelProperty("注意事项")
    @TableField("combo_note")
    private String comboNote;

    @ApiModelProperty("套餐状态")
    @TableField("combo_state")
    private Integer comboState;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;


}
