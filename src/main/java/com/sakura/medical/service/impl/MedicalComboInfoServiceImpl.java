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
import com.sakura.medical.common.utils.CommonsUtil;
import com.sakura.medical.common.utils.ObjectTools;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.MedicalComboInfo;
import com.sakura.medical.entity.MedicalExaminationInfo;
import com.sakura.medical.mapper.MedicalComboInfoMapper;
import com.sakura.medical.service.MedicalComboInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 体检套餐信息表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-21
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MedicalComboInfoServiceImpl extends ServiceImpl<MedicalComboInfoMapper, MedicalComboInfo> implements
        MedicalComboInfoService {

    @Autowired
    private MedicalComboInfoMapper mapper;

    private String msg = "体检套餐";

    @Override
    public MedicalComboInfo get(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<PageData> search(Page<PageData> page, PageData pageData) {
        return mapper.search(page, pageData);
    }

    @Override
    public Boolean create(MedicalComboInfo medicalComboInfo) {
        String[] imgs = {
                "https://meinian-mall.oss-cn-shanghai.aliyuncs.com/pic/d3826132-c27d-482b-b3c4-dd1c648dae72.jpg",
                "https://meinian-mall.oss-cn-shanghai.aliyuncs.com/pic/c820b9de-e73a-4887-b4d7-f620c3c51e2e.jpg",
                "https://meinian-mall.oss-cn-shanghai.aliyuncs.com/pic/7cbe7d40-149a-4964-adf7-7dd8c57a3fd8.jpg",
                "https://meinian-mall.oss-cn-shanghai.aliyuncs.com/pic/c39206fe-9c09-46f0-9813-b19143c33013.jpg",
                "https://meinian-mall.oss-cn-shanghai.aliyuncs.com/pic/3e6c5f27-9215-430c-85d7-ba24c22c21fa.jpg",
                "https://meinian-mall.oss-cn-shanghai.aliyuncs.com/pic/93155b35-8ca8-48b0-a575-b7b1cbcf696f.jpg",
                "https://meinian-mall.oss-cn-shanghai.aliyuncs.com/pic/e2ef8f3d-982d-43e6-96f1-daad52b80413.jpg",
                "https://meinian-mall.oss-cn-shanghai.aliyuncs.com/pic/8885deaa-85b5-4ad5-8368-5d6d7ecc8e07.jpg"};
        while (true) {
            Long index = CommonsUtil.getRandomNumber(1);
            String img = imgs[index.intValue() - 1];
            if (ObjectTools.isNotBlank(img)) {
                medicalComboInfo.setComboImg(img);
                break;
            }
        }
        try {
            mapper.insert(medicalComboInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增" + msg + "异常", e);
            throw new ErrorException("新增" + msg + "失败");
        }
    }

    @Override
    public Boolean modify(MedicalComboInfo medicalComboInfo) {
        try {
            mapper.updateById(medicalComboInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改" + msg + "异常", e);
            throw new ErrorException("修改" + msg + "失败");
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            mapper.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除" + msg + "异常", e);
            throw new ErrorException("删除" + msg + "失败");
        }
    }
}
