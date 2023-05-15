package com.sakura.medical.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.DoctorsInfo;

/**
 * <p>
 * 医生信息表 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-15
 */
public interface DoctorsInfoService extends IService<DoctorsInfo> {

    DoctorsInfo get(Integer id);

    Page<PageData> search(Page<PageData> page, PageData pageData);

    Boolean create(DoctorsInfo doctorsInfo);

    Boolean modify(DoctorsInfo doctorsInfo);

    Boolean remove(Integer id);

    List<PageData> getDoctorLables();

}
