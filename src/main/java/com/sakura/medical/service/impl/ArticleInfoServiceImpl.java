package com.sakura.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.CommonsUtil;
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

    //因为本地项目没服务器,只能用随机的固定图片了
    private final String[] articleThumbnailFiles =
            {"https://dg-fd.zol-img.com.cn/t_s208x130/g6/M00/0D/0E/ChMkKWEcb1KIZYfEAABuJdxANt8AAS4WgKr7MwAAG49573.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g4/M01/04/09/Cg-4y1TthaKILoSaACCX4-br1qAAAVgtQHS6Z0AIJf7476.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g4/M03/0A/01/Cg-4WVS3Q36ILhfGAAvMITHC4DMAASvIwAAAAAAC8w5065.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g4/M00/0F/02/Cg-4zFT5Wj-IQxAKABhgu3KD_twAAWK_ANBmYUAGGDT047.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g3/M08/0F/01/Cg-4V1RIZXuIDjyiAA1CsLoDDeMAAQZywLcqgEADULI711.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g5/M00/02/05/ChMkJ1bKycKIKa4wABQAhQVNp3oAALISQAAAAAAFACd273.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g4/M01/04/09/Cg-4y1TthaKILoSaACCX4-br1qAAAVgtQHS6Z0AIJf7476.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g3/M03/09/0B/Cg-4WFQ7OouIOs0nAAwPypdXxSMAAQEQgL1m38ADA_i999.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg",
                    "https://desk-fd.zol-img.com.cn/t_s208x130c5/g5/M00/02/04/ChMkJ1bKyEyIMaKUAAhskHwWGqUAALIAAM2KsIACGyo249.jpg"
            };

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
            articleInfo.setArticleThumbnail(articleThumbnailFiles[CommonsUtil.getRandomNumber(1).intValue()]);
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
