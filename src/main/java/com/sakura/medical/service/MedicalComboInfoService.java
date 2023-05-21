package com.sakura.medical.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.MedicalComboInfo;

/**
 * <p>
 * 体检套餐信息表 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-21
 */
public interface MedicalComboInfoService extends IService<MedicalComboInfo> {

    MedicalComboInfo get(Integer id);

    Page<PageData> search(Page<PageData> page, PageData pageData);

    Boolean create(MedicalComboInfo medicalComboInfo);

    Boolean modify(MedicalComboInfo medicalComboInfo);

    Boolean remove(Integer id);

}
