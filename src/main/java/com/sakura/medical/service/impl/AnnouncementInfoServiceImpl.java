package com.sakura.medical.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.ObjectTools;
import com.sakura.medical.entity.AnnouncementInfo;
import com.sakura.medical.mapper.AnnouncementInfoMapper;
import com.sakura.medical.service.AnnouncementInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 消息公告信息表 服务实现类
 * </p>
 * @author 李七夜
 * @since 2023-04-13
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class AnnouncementInfoServiceImpl extends ServiceImpl<AnnouncementInfoMapper, AnnouncementInfo> implements
        AnnouncementInfoService {

    @Autowired
    private AnnouncementInfoMapper mapper;

    @Override
    public AnnouncementInfo get(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<AnnouncementInfo> search(String announcementTitle, Page<AnnouncementInfo> page) {
        LambdaQueryWrapper<AnnouncementInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectTools.isNotBlank(announcementTitle)) {
            queryWrapper.like(AnnouncementInfo::getAnnouncementTitle, announcementTitle);
        }
        queryWrapper.orderByDesc(AnnouncementInfo::getId);
        return mapper.selectPage(page, queryWrapper);
    }

    @Override
    public Boolean create(AnnouncementInfo announcementInfo) {
        try {
            return this.save(announcementInfo);
        } catch (Exception e) {
            log.error("新增公告失败", e);
            throw new ErrorException("新增公告失败");
        }
    }

    @Override
    public Boolean update(AnnouncementInfo announcementInfo) {
        try {
            return this.updateById(announcementInfo);
        } catch (Exception e) {
            log.error("修改公告失败", e);
            throw new ErrorException("修改公告失败");
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            return this.removeById(id);
        } catch (Exception e) {
            log.error("删除公告失败", e);
            throw new ErrorException("删除公告失败");
        }
    }
}
