package com.sakura.medical.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 科室管理
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-14
 */
@Getter
@Setter
@TableName("department_info")
@ApiModel(value = "DepartmentInfo对象", description = "科室管理")
public class DepartmentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("上级科室")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty("所属院区")
    @TableField("hospital_id")
    private Integer hospitalId;

    @TableField(exist = false)
    private String hospitalName;

    @ApiModelProperty("科室位置")
    @TableField("department_address")
    private String departmentAddress;

    @ApiModelProperty("科室名称")
    @TableField("department_name")
    private String departmentName;

    @ApiModelProperty("科室状态")
    @TableField("department_state")
    private Integer departmentState;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;

    @TableField(exist = false)
    private List<DepartmentInfo> childDepartmentInfo;

}
