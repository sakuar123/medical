package com.sakura.medical.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.ArticleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 健康百科信息表 服务类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-09
 */
public interface ArticleInfoService extends IService<ArticleInfo> {

    ArticleInfo get(Integer id);

    Page<ArticleInfo> search(Page<ArticleInfo> page, String keyWorld);

    Boolean create(ArticleInfo articleInfo);

    Boolean modify(ArticleInfo articleInfo);

    Boolean remove(Integer id);

}
