package com.sakura.medical.service;

import java.util.List;

import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.RegionInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 区域 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-13
 */
public interface RegionInfoService extends IService<RegionInfo> {

    List<RegionInfo> getRegion();

}
