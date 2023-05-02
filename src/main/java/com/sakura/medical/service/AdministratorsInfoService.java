package com.sakura.medical.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.AdministratorsInfo;

/**
 * <p>
 * 管理员信息表 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-12
 */
public interface AdministratorsInfoService extends IService<AdministratorsInfo> {


    AdministratorsInfo get(Integer id);

    Page<PageData> search(String account, Page page);

    Boolean insert(AdministratorsInfo administratorsInfo);

    Boolean modify(AdministratorsInfo administratorsInfo);

    Boolean remove(Integer id);

    Boolean updatePwd(String newPassword, PageData pageData);

    PageData login(String accout, String password);
}
