package com.sakura.medical.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakura.medical.common.annotation.Permission;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.service.ProfessionalTitleInfoService;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/4/9 16:07
 */
@RestController
public class TestController {

    @Autowired
    private ProfessionalTitleInfoService service;

    @GetMapping("/t1")
    @Permission(noLogin = true)
    public Boolean t1() {
        return Boolean.TRUE;
    }


    @GetMapping("/t2")
    @Permission(noLogin = true)
    public Boolean t2() {
        throw new ErrorException("出错了!");
    }

}
