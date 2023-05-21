package com.sakura.medical.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.MedicalExaminationInfo;
import com.sakura.medical.mapper.MedicalExaminationInfoMapper;
import com.sakura.medical.service.MedicalExaminationInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 体检项目信息表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-21
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MedicalExaminationInfoServiceImpl extends
        ServiceImpl<MedicalExaminationInfoMapper, MedicalExaminationInfo> implements MedicalExaminationInfoService {

    @Autowired
    private MedicalExaminationInfoMapper mapper;

    @Override
    public MedicalExaminationInfo get(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<PageData> search(Page<PageData> page, String keyWorld) {
        return mapper.search(page, keyWorld);
    }

    @Override
    public List<PageData> getMedicalComboInfo() {
        List<PageData> result = Lists.newArrayList();
        List<MedicalExaminationInfo> list = mapper.selectList(new LambdaQueryWrapper<>());
        for (MedicalExaminationInfo medicalExaminationInfo : list) {
            PageData pageData = new PageData();
            pageData.put("medicalExaminationId", medicalExaminationInfo.getId());
            pageData.put("medicalExaminationName", medicalExaminationInfo.getExaminationName());
            result.add(pageData);
        }
        return result;
    }

    @Override
    public Boolean create(MedicalExaminationInfo medicalExaminationInfo) {
        try {
            mapper.insert(medicalExaminationInfo);
            updateProjectCode(medicalExaminationInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增体检项目失败", e);
            throw new ErrorException("新增体检项目失败");
        }
    }

    @Override
    public Boolean modify(MedicalExaminationInfo medicalExaminationInfo) {
        try {
            mapper.updateById(medicalExaminationInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改体检项目失败", e);
            throw new ErrorException("修改体检项目失败");
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            mapper.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除体检项目失败", e);
            throw new ErrorException("删除体检项目失败");
        }
    }

    private void updateProjectCode(MedicalExaminationInfo medicalExaminationInfo) {
        String projectCode = medicalExaminationInfo.getProjectCode();
        if (medicalExaminationInfo.getId() < 10) {
            medicalExaminationInfo
                    .setProjectCode(StringUtils.join(projectCode, "000", medicalExaminationInfo.getId()));
        } else if (medicalExaminationInfo.getId() >= 10) {
            medicalExaminationInfo
                    .setProjectCode(StringUtils.join(projectCode, "00", medicalExaminationInfo.getId()));
        } else if (medicalExaminationInfo.getId() >= 100) {
            medicalExaminationInfo
                    .setProjectCode(StringUtils.join(projectCode, "0", medicalExaminationInfo.getId()));
        }
        this.modify(medicalExaminationInfo);
    }
}
