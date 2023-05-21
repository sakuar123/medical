package com.sakura.medical.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ComboTypeInfo;

/**
 * <p>
 * 套餐类型信息表 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-20
 */
public interface ComboTypeInfoService extends IService<ComboTypeInfo> {

    ComboTypeInfo get(Integer id);

    List<PageData> getComboType();

    Page<ComboTypeInfo> search(Page<ComboTypeInfo> page);

    Boolean create(ComboTypeInfo comboTypeInfo);

    Boolean modify(ComboTypeInfo comboTypeInfo);

    Boolean remove(Integer id);

}
