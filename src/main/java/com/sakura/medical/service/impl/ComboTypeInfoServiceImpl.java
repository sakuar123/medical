package com.sakura.medical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ComboTypeInfo;
import com.sakura.medical.mapper.ComboTypeInfoMapper;
import com.sakura.medical.service.ComboTypeInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 套餐类型信息表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-20
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ComboTypeInfoServiceImpl extends ServiceImpl<ComboTypeInfoMapper, ComboTypeInfo> implements
        ComboTypeInfoService {

    @Autowired
    private ComboTypeInfoMapper comboTypeInfoMapper;

    @Override
    public ComboTypeInfo get(Integer id) {
        return comboTypeInfoMapper.selectById(id);
    }

    @Override
    public List<PageData> getComboType() {
        LambdaQueryWrapper<ComboTypeInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ComboTypeInfo::getComboState, 0);
        List<ComboTypeInfo> comboTypeInfoList = comboTypeInfoMapper.selectList(queryWrapper);
        List<PageData> result = Lists.newArrayList();
        comboTypeInfoList.forEach(comboTypeInfo -> {
            PageData pageData = new PageData();
            pageData.put("comboId", comboTypeInfo.getId());
            pageData.put("comboName", comboTypeInfo.getComboName());
            result.add(pageData);
        });
        return result;
    }

    @Override
    public Page<ComboTypeInfo> search(Page<ComboTypeInfo> page) {
        return comboTypeInfoMapper.selectPage(page, new LambdaQueryWrapper<>());
    }

    @Override
    public Boolean create(ComboTypeInfo comboTypeInfo) {
        try {
            comboTypeInfoMapper.insert(comboTypeInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增套餐类型失败", e);
            throw new ErrorException("新增套餐类型失败");
        }
    }

    @Override
    public Boolean modify(ComboTypeInfo comboTypeInfo) {
        try {
            comboTypeInfoMapper.updateById(comboTypeInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改套餐类型失败", e);
            throw new ErrorException("修改套餐类型失败");
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            comboTypeInfoMapper.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除套餐类型失败", e);
            throw new ErrorException("删除套餐类型失败");
        }
    }
}
