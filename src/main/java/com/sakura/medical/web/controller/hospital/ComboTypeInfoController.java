package com.sakura.medical.web.controller.hospital;


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
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ComboTypeInfo;
import com.sakura.medical.service.ComboTypeInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 套餐类型信息表 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-20
 */
@RestController
@Api(tags = "套餐类型信息前端控制器")
@RequestMapping("/medical/combo-type-info")
public class ComboTypeInfoController {

    @Autowired
    private ComboTypeInfoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "单个")
    public ComboTypeInfo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/getComboType")
    public List<PageData> getComboType() {
        return service.getComboType();
    }

    @GetMapping("/")
    @ApiOperation(value = "列表")
    public Page<ComboTypeInfo> search(Pageable pageable) {
        return service.search(new Page<>(pageable.getPageNumber(), pageable.getPageSize()));
    }

    @PostMapping("/")
    @ApiOperation(value = "新增")
    public Boolean create(@RequestBody ComboTypeInfo entity) {
        return service.create(entity);
    }

    @PutMapping("/")
    @ApiOperation(value = "修改")
    public Boolean modify(@RequestBody ComboTypeInfo entity) {
        return service.modify(entity);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public Boolean remove(@PathVariable Integer id) {
        return service.remove(id);
    }

}

