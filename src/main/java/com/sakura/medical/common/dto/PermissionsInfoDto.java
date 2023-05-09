package com.sakura.medical.common.dto;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/5/5 21:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionsInfoDto {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("父权限ID")
    private Integer pId;

    @ApiModelProperty("权限签名")
    private String permissionSign;

    @ApiModelProperty("权限备注")
    private String permissionDesc;

    @ApiModelProperty("权限集合")
    private List<PermissionsInfoDto> permissionsInfoList;

}
