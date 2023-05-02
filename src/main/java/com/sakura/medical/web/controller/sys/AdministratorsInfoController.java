package com.sakura.medical.web.controller.sys;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.annotation.Permission;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.AdministratorsInfo;
import com.sakura.medical.service.AdministratorsInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 管理员信息表 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-12
 */
@RestController
@Api(tags = "管理员信息控制器")
@RequestMapping("/medical/administrators-info")
public class AdministratorsInfoController {

    @Autowired
    private AdministratorsInfoService service;

    @GetMapping("/{id}")
    @Permission
    @ApiOperation(value = "单个")
    public AdministratorsInfo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/")
    @Permission
    @ApiOperation(value = "列表")
    public Page<PageData> search(String roleName, Pageable pageable) {
        Page<PageData> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
        return service.search(roleName, page);
    }

    @PostMapping("/")
    @Permission
    @ApiOperation(value = "新增")
    public Boolean create(@RequestBody AdministratorsInfo entity) {
        return service.insert(entity);
    }

    @PostMapping("/updatePwd")
    @ApiOperation(value = "修改密码")
    public Boolean updatePwd(@RequestParam("newPassword") String newPassword, HttpServletRequest request) {
        return service.updatePwd(newPassword, new PageData(request));
    }

    @PutMapping("/")
    @Permission
    @ApiOperation(value = "修改")
    public Boolean update(@RequestBody AdministratorsInfo entity) {
        return service.modify(entity);
    }

    @DeleteMapping("/{id}")
    @Permission
    @ApiOperation(value = "删除")
    public Boolean delete(@PathVariable Integer id) {
        return service.remove(id);
    }

}

