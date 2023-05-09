package com.sakura.medical.service;

import java.util.List;

import com.sakura.medical.common.dto.PermissionsInfoDto;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.PermissionsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限集合表 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-05
 */
public interface PermissionsInfoService extends IService<PermissionsInfo> {

    PageData getPermissions(Integer roleId);

    List<PermissionsInfoDto> getPermissionList();

    Boolean create(PermissionsInfo permissionsInfo);

    Boolean modify(PermissionsInfo permissionsInfo);

    Boolean remove(Integer id);

    void setPermission(Integer roleId);

    void init();

}
