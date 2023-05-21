package com.sakura.medical.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.MedicalExaminationInfo;

/**
 * <p>
 * 体检项目信息表 Mapper 接口
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-21
 */
@Mapper
public interface MedicalExaminationInfoMapper extends BaseMapper<MedicalExaminationInfo> {

    Page<PageData> search(Page<PageData> page, @Param("keyWorld") String keyWorld);

}
