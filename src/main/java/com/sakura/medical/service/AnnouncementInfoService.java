package com.sakura.medical.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.medical.entity.AnnouncementInfo;
import com.sakura.medical.entity.ProfessionalTitleInfo;

/**
 * <p>
 * 消息公告信息表 服务类
 * </p>
 * @author 李七夜
 * @since 2023-04-13
 */
public interface AnnouncementInfoService extends IService<AnnouncementInfo> {

    AnnouncementInfo get(Integer id);

    Page<AnnouncementInfo> search(String announcementTitle, Page<AnnouncementInfo> page);

    Boolean create(AnnouncementInfo announcementInfo);

    Boolean update(AnnouncementInfo announcementInfo);

    Boolean delete(Integer id);

}
