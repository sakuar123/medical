package com.sakura.medical.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ProfessionalTitleInfo;
import com.sakura.medical.service.ProfessionalTitleInfoService;

import io.swagger.annotations.ApiOperation;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/4/9 16:07
 */
@RestController
public class TestController {

    @Autowired
    private ProfessionalTitleInfoService service;


}
