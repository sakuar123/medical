package com.sakura.medical.web.controller.hospital;


import java.util.List;

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
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.DepartmentInfo;
import com.sakura.medical.service.DepartmentInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 科室管理 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-14
 */
@RestController
@Api(tags = "科室管理控制器")
@RequestMapping("/medical/department-info")
public class DepartmentInfoController {

    @Autowired
    private DepartmentInfoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "单个")
    public DepartmentInfo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/")
    @ApiOperation(value = "列表")
    public Page<DepartmentInfo> search(Pageable pageable,
            @RequestParam(value = "keyWorld", required = false) String keyWorld) {
        return service.search(new Page<>(pageable.getPageNumber(), pageable.getPageSize()), keyWorld);
    }

    @PostMapping("/")
    @ApiOperation(value = "新增")
    public Boolean create(@RequestBody DepartmentInfo entity) {
        return service.create(entity);
    }

    @PutMapping("/")
    @ApiOperation(value = "修改")
    public Boolean modify(@RequestBody DepartmentInfo entity) {
        return service.modify(entity);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public Boolean remove(@PathVariable Integer id) {
        return service.remove(id);
    }

    @GetMapping("/getDepartmentInfo")
    @ApiOperation(value = "获取")
    public List<PageData> getDepartmentInfo() {
        return service.getDepartmentInfo();
    }
}

