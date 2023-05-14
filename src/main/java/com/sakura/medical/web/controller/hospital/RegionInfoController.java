package com.sakura.medical.web.controller.hospital;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakura.medical.common.annotation.Permission;
import com.sakura.medical.entity.RegionInfo;
import com.sakura.medical.service.RegionInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 区域 前端控制器
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-13
 */
@RestController
@Api(tags = "区域前端控制器")
@RequestMapping("/medical/region-info")
public class RegionInfoController {

    @Autowired
    private RegionInfoService regionInfoService;

    @Permission
    @GetMapping("/")
    @ApiOperation(value = "获取所有的区域信息")
    public List<RegionInfo> getRegion() {
        return regionInfoService.getRegion();
    }

}

