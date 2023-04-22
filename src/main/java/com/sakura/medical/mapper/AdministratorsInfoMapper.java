package com.sakura.medical.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.AdministratorsInfo;

/**
 * <p>
 * 管理员信息表 Mapper 接口
 * </p>
 * @author 李七夜
 * @since 2023-04-12
 */
@Mapper
public interface AdministratorsInfoMapper extends BaseMapper<AdministratorsInfo> {

    Page<PageData> search(@Param("administratorName") String administratorName, Page page);

}
