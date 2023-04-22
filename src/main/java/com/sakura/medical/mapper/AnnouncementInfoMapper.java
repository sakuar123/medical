package com.sakura.medical.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sakura.medical.entity.AnnouncementInfo;

/**
 * <p>
 * 消息公告信息表 Mapper 接口
 * </p>
 * @author 李七夜
 * @since 2023-04-13
 */
@Mapper
public interface AnnouncementInfoMapper extends BaseMapper<AnnouncementInfo> {

}
