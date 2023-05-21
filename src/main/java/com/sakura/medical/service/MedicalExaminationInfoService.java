package com.sakura.medical.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ComboTypeInfo;
import com.sakura.medical.entity.MedicalExaminationInfo;

/**
 * <p>
 * 体检项目信息表 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-21
 */
public interface MedicalExaminationInfoService extends IService<MedicalExaminationInfo> {

    MedicalExaminationInfo get(Integer id);

    Page<PageData> search(Page<PageData> page, String keyWorld);

    List<PageData> getMedicalComboInfo();

    Boolean create(MedicalExaminationInfo medicalExaminationInfo);

    Boolean modify(MedicalExaminationInfo medicalExaminationInfo);

    Boolean remove(Integer id);
}
