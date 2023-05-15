package com.sakura.medical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.ObjectTools;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ProfessionalTitleInfo;
import com.sakura.medical.mapper.ProfessionalTitleInfoMapper;
import com.sakura.medical.service.ProfessionalTitleInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 职称信息表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-09
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ProfessionalTitleInfoServiceImpl extends
        ServiceImpl<ProfessionalTitleInfoMapper, ProfessionalTitleInfo> implements ProfessionalTitleInfoService {

    @Autowired
    private ProfessionalTitleInfoMapper professionalTitleInfoMapper;

    @Override
    public ProfessionalTitleInfo get(Integer id) {
        return professionalTitleInfoMapper.selectById(id);
    }

    @Override
    public Page<ProfessionalTitleInfo> search(PageData pageData, Pageable pageable) {
        Page page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
        //queryWrapper组装查询where条件
        LambdaQueryWrapper<ProfessionalTitleInfo> queryWrapper = new LambdaQueryWrapper<>();
        String professionalTitleName = pageData.getString("professionalTitleName");
        if (ObjectTools.isNotBlank(professionalTitleName)) {
            queryWrapper.like(ProfessionalTitleInfo::getProfessionalTitleName, professionalTitleName);
        }
        return professionalTitleInfoMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Boolean create(ProfessionalTitleInfo professionalTitleInfo) {
        try {
            this.save(professionalTitleInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增职称失败", e);
            throw new ErrorException("新增职称失败");
        }
    }

    @Override
    public Boolean update(ProfessionalTitleInfo professionalTitleInfo) {
        try {
            professionalTitleInfoMapper.updateById(professionalTitleInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改职称失败", e);
            throw new ErrorException("修改职称失败");
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            professionalTitleInfoMapper.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除职称失败", e);
            throw new ErrorException("删除职称失败");
        }
    }

    @Override
    public List<PageData> getProfessionalTitleInfo() {
        List<ProfessionalTitleInfo> professionalTitleInfoList = professionalTitleInfoMapper
                .selectList(new LambdaQueryWrapper<>());
        List<PageData> result = Lists.newArrayList();
        professionalTitleInfoList.forEach(professionalTitleInfo -> {
            PageData pageData = new PageData();
            pageData.put("professionalTitleInfoId", professionalTitleInfo.getId());
            pageData.put("professionalTitleInfoName", professionalTitleInfo.getProfessionalTitleName());
            result.add(pageData);
        });
        return result;
    }
}
