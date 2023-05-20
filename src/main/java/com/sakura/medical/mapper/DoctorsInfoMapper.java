package com.sakura.medical.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.DoctorsInfo;

/**
 * <p>
 * 医生信息表 Mapper 接口
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-15
 */
@Mapper
public interface DoctorsInfoMapper extends BaseMapper<DoctorsInfo> {

    Page<PageData> search(Page<PageData> page, @Param("pageData") PageData pageData);

}
