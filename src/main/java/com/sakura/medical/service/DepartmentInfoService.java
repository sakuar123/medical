package com.sakura.medical.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.DepartmentInfo;

/**
 * <p>
 * 科室管理 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-14
 */
public interface DepartmentInfoService extends IService<DepartmentInfo> {

    DepartmentInfo get(Integer id);

    Page<DepartmentInfo> search(Page<DepartmentInfo> page, String keyWorld);

    Boolean create(DepartmentInfo departmentInfo);

    Boolean modify(DepartmentInfo departmentInfo);

    Boolean remove(Integer id);

    List<PageData> getDepartmentInfo();

}
