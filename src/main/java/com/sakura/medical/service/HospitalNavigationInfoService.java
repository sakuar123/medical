package com.sakura.medical.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.entity.ArticleInfo;
import com.sakura.medical.entity.HospitalNavigationInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 医院导航信息表 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-11
 */
public interface HospitalNavigationInfoService extends IService<HospitalNavigationInfo> {

    HospitalNavigationInfo get(Integer id);

    Page<HospitalNavigationInfo> search(Page<HospitalNavigationInfo> page, String keyWorld);

    Boolean create(HospitalNavigationInfo hospitalNavigationInfo);

    Boolean modify(HospitalNavigationInfo hospitalNavigationInfo);

    Boolean remove(Integer id);
}
