package com.sakura.medical.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by 李七夜 on 2020/5/14 15:43
 *
 * @author 李七夜
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EnumPermission {
    //用户管理
    SYS_USER_INFO(1, "sys_user_info", "用户管理"),
    SYS_USER_INFO_ADD(2, "sys_user_info_add", "新增用户"),
    SYS_USER_INFO_EDIT(3, "sys_user_info_edit", "修改用户"),
    SYS_USER_INFO_DEL(4, "sys_user_info_del", "删除用户"),
    //角色管理
    SYS_ROLE_INFO(5, "sys_role_info", "角色管理"),
    SYS_ROLE_INFO_ADD(6, "sys_role_info_add", "新增角色"),
    SYS_ROLE_INFO_EDIT(7, "sys_role_info_edit", "修改角色"),
    SYS_ROLE_INFO_DEL(8, "sys_role_info_del", "删除角色"),
    //部门管理
    SYS_DEPARTMENT_INFO(9, "sys_department_info", "角色管理"),
    SYS_DEPARTMENT_INFO_ADD(10, "sys_department_info_add", "新增角色"),
    SYS_DEPARTMENT_INFO_EDIT(11, "sys_department_info_edit", "修改角色"),
    SYS_DEPARTMENT_INFO_DEL(12, "sys_department_info_del", "删除角色"),
    //仓库管理
    SYS_WARE_HOUSE_INFO(13, "sys_ware_house_info", "角色管理"),
    SYS_WARE_HOUSE_INFO_ADD(14, "sys_ware_house_info_add", "新增角色"),
    SYS_WARE_HOUSE_INFO_EDIT(15, "sys_ware_house_info_edit", "修改角色"),
    SYS_WARE_HOUSE_INFO_DEL(16, "sys_ware_house_info_del", "删除角色"),
    ;

    /**
     * 编号
     */
    private Integer cold;
    /**
     * 权限签名
     */
    private String sign;
    /**
     * 权限描述
     */
    private String desc;
}
