package com.sakura.medical.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 套餐类型信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-20
 */
@Getter
@Setter
@Builder
@TableName("combo_type_info")
@ApiModel(value = "ComboTypeInfo对象", description = "套餐类型信息表")
public class ComboTypeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("类型名称")
    @TableField("combo_name")
    private String comboName;

    @ApiModelProperty("套餐描述")
    @TableField("combo_desc")
    private String comboDesc;

    @ApiModelProperty("套餐状态")
    @TableField("combo_state")
    private Integer comboState;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;


}
