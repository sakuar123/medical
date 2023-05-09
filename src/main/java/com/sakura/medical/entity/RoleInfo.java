package com.sakura.medical.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sakura.medical.common.utils.DateUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-10
 */
@Getter
@Setter
@TableName("role_info")
@ApiModel(value = "RoleInfo对象", description = "角色信息表")
public class RoleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty("角色描述")
    @TableField("role_desc")
    private String roleDesc;

    @ApiModelProperty("权限集合")
    @TableField("permissions")
    private String permissions;

    @ApiModelProperty("角色状态")
    @TableField("role_status")
    private Integer roleStatus;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    @JsonFormat(pattern = DateUtils.SECOND_DATE_PATTERN)
    private LocalDateTime createDate;


}
