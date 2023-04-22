package com.sakura.medical.web.controller.sys;


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
import com.sakura.medical.entity.AnnouncementInfo;
import com.sakura.medical.service.AnnouncementInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 消息公告信息表 前端控制器
 * </p>
 * @author 李七夜
 * @since 2023-04-13
 */
@RestController
@Api("消息公告前端控制器")
@RequestMapping("/medical/announcement-info")
public class AnnouncementInfoController {

    @Autowired
    private AnnouncementInfoService service;

    @GetMapping("/{id}")
    @Permission(noLogin = true)
    @ApiOperation(value = "单个")
    public AnnouncementInfo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/")
    @Permission(noLogin = true)
    @ApiOperation(value = "列表")
    public Page<AnnouncementInfo> search(String announcementTitle, Pageable pageable) {
        Page<AnnouncementInfo> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
        return service.search(announcementTitle, page);
    }

    @PostMapping("/")
    @Permission(noLogin = true)
    @ApiOperation(value = "新增")
    public Boolean create(@RequestBody AnnouncementInfo entity) {
        return service.create(entity);
    }


    @PutMapping("/")
    @Permission(noLogin = true)
    @ApiOperation(value = "修改")
    public Boolean update(@RequestBody AnnouncementInfo entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    @Permission(noLogin = true)
    @ApiOperation(value = "删除")
    public Boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

}

