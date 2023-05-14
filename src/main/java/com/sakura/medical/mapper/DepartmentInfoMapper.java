package com.sakura.medical.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.entity.DepartmentInfo;

/**
 * <p>
 * 科室管理 Mapper 接口
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-14
 */
@Mapper
public interface DepartmentInfoMapper extends BaseMapper<DepartmentInfo> {

    Page<DepartmentInfo> search(Page<DepartmentInfo> page, @Param("keyWorld")String keyWorld);

}
