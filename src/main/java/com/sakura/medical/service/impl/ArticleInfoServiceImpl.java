package com.sakura.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.ObjectTools;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ArticleInfo;
import com.sakura.medical.mapper.ArticleInfoMapper;
import com.sakura.medical.service.ArticleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 健康百科信息表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-09
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public ArticleInfo get(Integer id) {
        return articleInfoMapper.selectById(id);
    }

    @Override
    public Page<ArticleInfo> search(Page<ArticleInfo> page, String keyWorld) {
        LambdaQueryWrapper<ArticleInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectTools.isNotBlank(keyWorld)) {
            queryWrapper.like(ArticleInfo::getArticleTitle, keyWorld);
        }
        return articleInfoMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Boolean create(ArticleInfo articleInfo) {
        try {
            articleInfoMapper.insert(articleInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增文章失败", e);
            throw new ErrorException("新增文章失败");
        }
    }

    @Override
    public Boolean modify(ArticleInfo articleInfo) {
        try {
            articleInfoMapper.updateById(articleInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改文章失败", e);
            throw new ErrorException("修改文章失败");
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            articleInfoMapper.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除文章失败", e);
            throw new ErrorException("删除文章失败");
        }
    }
}
