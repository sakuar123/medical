package com.sakura.medical.web.controller.sys;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakura.medical.common.annotation.Permission;
import com.sakura.medical.common.dto.PermissionsInfoDto;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.service.PermissionsInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 权限集合表 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-05
 */
@RestController
@Api("权限管理前端控制器")
@RequestMapping("/medical/permissions-info")
public class PermissionsInfoController {

    @Autowired
    private PermissionsInfoService service;

    @GetMapping("/getPermissions/{roleId}")
    @Permission()
    @ApiOperation(value = "单个")
    public PageData getPermissions(@PathVariable Integer roleId) {
        return service.getPermissions(roleId);
    }

    @GetMapping("/getPermissionList")
    @Permission()
    @ApiOperation(value = "列表")
    public List<PermissionsInfoDto> getPermissionList() {
        return service.getPermissionList();
    }

}

