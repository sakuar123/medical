package com.sakura.medical.web.controller.hospital;


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
import com.sakura.medical.entity.ArticleInfo;
import com.sakura.medical.service.ArticleInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 健康百科信息表 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-09
 */
@RestController
@Api(tags = "健康百科控制管理器")
@RequestMapping("/medical/article-info")
public class ArticleInfoController {

    @Autowired
    private ArticleInfoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "单个")
    public ArticleInfo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/")
    @ApiOperation(value = "列表")
    public Page<ArticleInfo> search(Pageable pageable, String keyWorld) {
        return service.search(new Page<>(pageable.getPageNumber(), pageable.getPageSize()), keyWorld);
    }

    @PostMapping("/")
    @ApiOperation(value = "新增")
    public Boolean create(@RequestBody ArticleInfo articleInfo) {
        return service.create(articleInfo);
    }

    @PutMapping("/")
    @ApiOperation(value = "修改")
    public Boolean modify(@RequestBody ArticleInfo articleInfo) {
        return service.modify(articleInfo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public Boolean remove(@PathVariable Integer id) {
        return service.remove(id);
    }

}

