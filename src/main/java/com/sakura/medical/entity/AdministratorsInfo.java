package com.sakura.medical.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 管理员信息表
 * </p>
 * @author 李七夜
 * @since 2023-04-12
 */
@Getter
@Setter
@Builder
@TableName("administrators_info")
@ApiModel(value = "AdministratorsInfo对象", description = "管理员信息表")
public class AdministratorsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField("administrator_name")
    private String administratorName;

    @ApiModelProperty("账号")
    @TableField("administrator_account")
    private String administratorAccount;

    @ApiModelProperty("所属角色")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("手机号码")
    @TableField("administrator_phone")
    private String administratorPhone;

    @ApiModelProperty("密码")
    @TableField("administrator_password")
    private String administratorPassword;

    @ApiModelProperty("密码盐")
    @TableField("administrator_password_salt")
    private String administratorPasswordSalt;

    @ApiModelProperty("用户状态")
    @TableField("administrator_status")
    private Integer administratorStatus;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;


}
