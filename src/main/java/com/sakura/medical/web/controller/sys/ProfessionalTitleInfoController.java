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
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.annotation.Permission;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ProfessionalTitleInfo;
import com.sakura.medical.service.ProfessionalTitleInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 职称信息表 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-09
 */
@RestController
@Api(tags = "职称信息控制器")
@RequestMapping("/medical/professional-title-info")
public class ProfessionalTitleInfoController {

    @Autowired
    private ProfessionalTitleInfoService service;

    @GetMapping("/{id}")
    @Permission
    @ApiOperation(value = "单个")
    public ProfessionalTitleInfo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/")
    @Permission
    @ApiOperation(value = "列表")
    public Page search(HttpServletRequest request, Pageable pageable) {
        return service.search(new PageData(request), pageable);
    }

    @PostMapping("/")
    @Permission
    @ApiOperation(value = "新增")
    public Boolean create(@RequestBody ProfessionalTitleInfo entity) {
        return service.create(entity);
    }

    @PutMapping("/")
    @Permission
    @ApiOperation(value = "修改")
    public Boolean update(@RequestBody ProfessionalTitleInfo entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    @Permission
    @ApiOperation(value = "删除")
    public Boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

}

