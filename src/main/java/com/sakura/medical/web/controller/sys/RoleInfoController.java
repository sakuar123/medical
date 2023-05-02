package com.sakura.medical.web.controller.sys;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.annotation.Permission;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.RoleInfo;
import com.sakura.medical.service.RoleInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-10
 */
@RestController
@Api(tags = "角色信息控制器")
@RequestMapping("/medical/role-info")
public class RoleInfoController {


    @Autowired
    private RoleInfoService service;

    @GetMapping("/{id}")
    @Permission()
    @ApiOperation(value = "单个")
    public RoleInfo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/")
    @Permission()
    @ApiOperation(value = "列表")
    public Page search(String roleName, Pageable pageable) {
        return service.search(roleName, pageable);
    }

    @PostMapping("/")
    @Permission()
    @ApiOperation(value = "新增")
    public Boolean create(@RequestBody RoleInfo entity) {
        return service.create(entity);
    }

    @PutMapping("/")
    @Permission()
    @ApiOperation(value = "修改")
    public Boolean update(@RequestBody RoleInfo entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    @Permission()
    @ApiOperation(value = "删除")
    public Boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping("/roleList")
    @Permission
    @ApiOperation(value = "角色集合")
    public List<PageData> roleList() {
        return service.roleList();
    }
}

