package com.sakura.medical.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.service.AdministratorsInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/4/30 12:30
 */
@RestController
@Api(tags = "用户管理器")
public class LoginController {

    @Autowired
    private AdministratorsInfoService administratorsInfoService;

    @PostMapping("/login")
    @ApiOperation(value = "登录接口")
    public PageData login(String accout, String password) {
        return administratorsInfoService.login(accout, password);
    }

}
