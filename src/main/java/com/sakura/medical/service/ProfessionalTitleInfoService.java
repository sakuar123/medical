package com.sakura.medical.service;

import org.springframework.data.domain.Pageable;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ProfessionalTitleInfo;

/**
 * <p>
 * 职称信息表 服务类
 * </p>
 * @author 李七夜
 * @since 2023-04-09
 */
public interface ProfessionalTitleInfoService extends IService<ProfessionalTitleInfo> {

    ProfessionalTitleInfo get(Integer id);

    Page<ProfessionalTitleInfo> search(PageData pageData, Pageable pageable);

    Boolean create(ProfessionalTitleInfo professionalTitleInfo);

    Boolean update(ProfessionalTitleInfo professionalTitleInfo);

    Boolean delete(Integer id);

}
