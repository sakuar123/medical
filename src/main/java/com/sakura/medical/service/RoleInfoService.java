package com.sakura.medical.service;

import org.springframework.data.domain.Pageable;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.RoleInfo;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 * @author 李七夜
 * @since 2023-04-10
 */
public interface RoleInfoService extends IService<RoleInfo> {

    RoleInfo get(Integer id);

    Page<PageData> search(String roleName, Pageable pageable);

    Boolean create(RoleInfo roleInfo);

    Boolean update(RoleInfo roleInfo);

    Boolean delete(Integer id);

}
