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
import com.sakura.medical.common.utils.ObjectTools;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.HospitalInsideNavigation;
import com.sakura.medical.entity.HospitalNavigationInfo;
import com.sakura.medical.mapper.HospitalInsideNavigationMapper;
import com.sakura.medical.mapper.HospitalNavigationInfoMapper;
import com.sakura.medical.service.HospitalInsideNavigationService;
import com.sakura.medical.service.HospitalNavigationInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 医院导航信息表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-11
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class HospitalNavigationInfoServiceImpl extends
        ServiceImpl<HospitalNavigationInfoMapper, HospitalNavigationInfo> implements HospitalNavigationInfoService {

    @Autowired
    private HospitalNavigationInfoMapper hospitalNavigationInfoMapper;
    @Autowired
    private HospitalInsideNavigationMapper hospitalInsideNavigationMapper;
    @Autowired
    private HospitalInsideNavigationService hospitalInsideNavigationService;


    @Override
    public HospitalNavigationInfo get(Integer id) {
        HospitalNavigationInfo result = hospitalNavigationInfoMapper.selectById(id);
        List<HospitalInsideNavigation> hospitalInsideNavigationList = hospitalInsideNavigationMapper.selectList(
                new LambdaQueryWrapper<HospitalInsideNavigation>().eq(HospitalInsideNavigation::getHospitalId, id));
        result.setHospitalInsideNavigationList(hospitalInsideNavigationList);
        return result;
    }

    @Override
    public Page<HospitalNavigationInfo> search(Page<HospitalNavigationInfo> page, String keyWorld) {
        LambdaQueryWrapper<HospitalNavigationInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ObjectTools.isNotBlank(keyWorld)) {
            lambdaQueryWrapper.like(HospitalNavigationInfo::getHospitalName, keyWorld);
        }
        return hospitalNavigationInfoMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public Boolean create(HospitalNavigationInfo hospitalNavigationInfo) {
        try {
            saveBatch(Lists.newArrayList());
            hospitalNavigationInfoMapper.insert(hospitalNavigationInfo);
            hospitalNavigationInfo.getHospitalInsideNavigationList().forEach(hospitalInsideNavigation -> {
                hospitalInsideNavigation.setHospitalId(hospitalNavigationInfo.getId());
            });
            hospitalInsideNavigationService.saveBatch(hospitalNavigationInfo.getHospitalInsideNavigationList());
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增院区失败", e);
            throw new ErrorException("新增院区失败");
        }
    }

    @Override
    public Boolean modify(HospitalNavigationInfo hospitalNavigationInfo) {
        try {
            hospitalNavigationInfoMapper.updateById(hospitalNavigationInfo);
            if (ObjectTools.isBlank(hospitalNavigationInfo.getHospitalInsideNavigationList())) {
                hospitalInsideNavigationService.remove(new LambdaQueryWrapper<HospitalInsideNavigation>()
                        .eq(HospitalInsideNavigation::getHospitalId, hospitalNavigationInfo.getId()));
                return Boolean.TRUE;
            }
            hospitalInsideNavigationService.saveOrUpdateBatch(hospitalNavigationInfo.getHospitalInsideNavigationList());
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改院区失败", e);
            throw new ErrorException("修改院区失败");
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            hospitalNavigationInfoMapper.deleteById(id);
            hospitalInsideNavigationService.remove(new LambdaQueryWrapper<HospitalInsideNavigation>()
                    .eq(HospitalInsideNavigation::getHospitalId, id));
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除院区失败", e);
            throw new ErrorException("删除院区失败");
        }
    }

    @Override
    public List<PageData> getHospitalNavigationInfo() {
        List<HospitalNavigationInfo> list = hospitalNavigationInfoMapper.selectList(new LambdaQueryWrapper<>());
        List<PageData> result = Lists.newArrayList();
        list.forEach(hospitalNavigationInfo -> {
            PageData pageData = new PageData();
            pageData.put("hospitalId", hospitalNavigationInfo.getId());
            pageData.put("hospitalName", hospitalNavigationInfo.getHospitalName());
            result.add(pageData);
        });
        return result;
    }
}
