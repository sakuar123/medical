package com.sakura.medical.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sakura.medical.common.utils.DateUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 消息公告信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-13
 */
@Getter
@Setter
@Builder
@TableName("announcement_info")
@ApiModel(value = "AnnouncementInfo对象", description = "消息公告信息表")
public class AnnouncementInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("消息标题")
    @TableField("announcement_title")
    private String announcementTitle;

    @ApiModelProperty("上传人")
    @TableField("upload_person")
    private String uploadPerson;

    @ApiModelProperty("公告内容")
    @TableField("announcement_content")
    private String announcementContent;

    @ApiModelProperty("公告状态")
    @TableField("announcement_status")
    private Integer announcementStatus;

    @ApiModelProperty("上传时间时间")
    @TableField("upload_date")
    @JsonFormat(pattern = DateUtils.DAY_DATE_PATTERN)
    private LocalDateTime uploadDate;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    @JsonFormat(pattern = DateUtils.SECOND_DATE_PATTERN)
    private LocalDateTime createDate;


}
