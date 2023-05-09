package com.sakura.medical.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sakura.medical.entity.ArticleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 健康百科信息表 Mapper 接口
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-09
 */
@Mapper
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {

}
