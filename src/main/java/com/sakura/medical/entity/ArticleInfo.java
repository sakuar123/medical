package com.sakura.medical.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 健康百科信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-09
 */
@Getter
@Setter
@TableName("article_info")
@ApiModel(value = "ArticleInfo对象", description = "健康百科信息表")
public class ArticleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("文章标题")
    @TableField("article_title")
    private String articleTitle;

    @ApiModelProperty("文章略缩图")
    @TableField("article_thumbnail")
    private String articleThumbnail;

    @TableField(exist = false)
    private File articleThumbnailFile;

    @ApiModelProperty("文章作者")
    @TableField("article_author")
    private String articleAuthor;

    @ApiModelProperty("文章内容")
    @TableField("article_content")
    private String articleContent;

    @ApiModelProperty("文章状态")
    @TableField("article_state")
    private Integer articleState;

    @ApiModelProperty("文章上传时间")
    @TableField("article_upload_time")
    private LocalDateTime articleUploadTime;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;


}
