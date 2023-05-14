package com.sakura.medical.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.DepartmentInfo;
import com.sakura.medical.mapper.DepartmentInfoMapper;
import com.sakura.medical.service.DepartmentInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 科室管理 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-14
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentInfoServiceImpl extends ServiceImpl<DepartmentInfoMapper, DepartmentInfo> implements
        DepartmentInfoService {

    @Autowired
    private DepartmentInfoMapper departmentInfoMapper;

    @Override
    public DepartmentInfo get(Integer id) {
        return departmentInfoMapper.selectById(id);
    }

    @Override
    public Page<DepartmentInfo> search(Page<DepartmentInfo> page, String keyWorld) {
        Page<DepartmentInfo> result = departmentInfoMapper.search(page, keyWorld);
        List<DepartmentInfo> list = result.getRecords();
        Map<Integer, List<DepartmentInfo>> map = list.stream()
                .collect(Collectors.groupingBy(DepartmentInfo::getParentId));
        list.forEach(departmentInfo -> departmentInfo.setChildDepartmentInfo(map.get(departmentInfo.getId())));
        result.setRecords(list.stream().filter(departmentInfo -> departmentInfo.getParentId().equals(0)).collect(
                Collectors.toList()));
        return result;
    }

    @Override
    public Boolean create(DepartmentInfo departmentInfo) {
        try {
            departmentInfoMapper.insert(departmentInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增科室异常", e);
            throw new ErrorException("新增科室失败");
        }
    }

    @Override
    public Boolean modify(DepartmentInfo departmentInfo) {
        try {
            departmentInfoMapper.updateById(departmentInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改科室异常", e);
            throw new ErrorException("修改科室异常");
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            departmentInfoMapper.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除科室异常", e);
            throw new ErrorException("删除科室异常");
        }
    }

    @Override
    public List<PageData> getDepartmentInfo() {
        List<DepartmentInfo> departmentInfoList = departmentInfoMapper.selectList(new LambdaQueryWrapper<>());
        List<PageData> result = Lists.newArrayList();
        departmentInfoList.forEach(departmentInfo -> {
            PageData pageData = new PageData();
            pageData.put("departmentId", departmentInfo.getId());
            pageData.put("departmentName", departmentInfo.getDepartmentName());
            result.add(pageData);
        });
        return result;
    }
}
