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
 * 权限集合表
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-05
 */
@Getter
@Setter
@TableName("permissions_info")
@ApiModel(value = "PermissionsInfo对象", description = "权限集合表")
public class PermissionsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("父权限ID")
    @TableField("p_id")
    private Integer pId;

    @ApiModelProperty("权限签名")
    @TableField("permission_sign")
    private String permissionSign;

    @ApiModelProperty("权限备注")
    @TableField("permission_desc")
    private String permissionDesc;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;

    @TableField(exist = false)
    private List<PermissionsInfo> permissionsInfoList;


}
