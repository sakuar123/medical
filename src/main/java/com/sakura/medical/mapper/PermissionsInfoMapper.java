package com.sakura.medical.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sakura.medical.entity.PermissionsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 权限集合表 Mapper 接口
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-05
 */
@Mapper
public interface PermissionsInfoMapper extends BaseMapper<PermissionsInfo> {

}
