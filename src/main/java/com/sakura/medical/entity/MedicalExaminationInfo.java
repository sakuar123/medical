package com.sakura.medical.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 体检项目信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-21
 */
@Getter
@Setter
@TableName("medical_examination_info")
@ApiModel(value = "MedicalExaminationInfo对象", description = "体检项目信息表")
public class MedicalExaminationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属套餐")
    @TableField("combo_id")
    private Integer comboId;

    @ApiModelProperty("项目编码")
    @TableField("project_code")
    private String projectCode;

    @ApiModelProperty("项目名称")
    @TableField("examination_name")
    private String examinationName;

    @ApiModelProperty("项目价格")
    @TableField("examination_price")
    private BigDecimal examinationPrice;

    @ApiModelProperty("项目介绍")
    @TableField("examination_desc")
    private String examinationDesc;

    @ApiModelProperty("注意事项")
    @TableField("examination_note")
    private String examinationNote;

    @ApiModelProperty("项目状态")
    @TableField("examination_state")
    private Integer examinationState;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;


}
