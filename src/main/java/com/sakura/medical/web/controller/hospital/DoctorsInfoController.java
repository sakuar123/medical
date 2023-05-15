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
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.DoctorsInfo;
import com.sakura.medical.service.DoctorsInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 医生信息表 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-15
 */
@RestController
@Api(tags = "医生信息前端控制器")
@RequestMapping("/medical/doctors-info")
public class DoctorsInfoController {

    @Autowired
    private DoctorsInfoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "单个")
    public DoctorsInfo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("")
    @ApiOperation(value = "医生标签")
    public List<PageData> getDoctorLables() {
        return service.getDoctorLables();
    }

    @GetMapping("/")
    @ApiOperation(value = "列表")
    public Page<PageData> search(Pageable pageable, HttpServletRequest request) {
        return service.search(new Page<>(pageable.getPageNumber(), pageable.getPageSize()), new PageData(request));
    }

    @PostMapping("/")
    @ApiOperation(value = "新增")
    public Boolean create(@RequestBody DoctorsInfo entity) {
        return service.create(entity);
    }

    @PutMapping("/")
    @ApiOperation(value = "修改")
    public Boolean modify(@RequestBody DoctorsInfo entity) {
        return service.modify(entity);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public Boolean remove(@PathVariable Integer id) {
        return service.remove(id);
    }

}

