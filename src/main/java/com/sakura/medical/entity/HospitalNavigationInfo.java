package com.sakura.medical.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 医院导航信息表
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-11
 */
@Getter
@Setter
@TableName("hospital_navigation_info")
@ApiModel(value = "HospitalNavigationInfo对象", description = "医院导航信息表")
public class HospitalNavigationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("院区名称")
    @TableField("hospital_name")
    private String hospitalName;

    @ApiModelProperty("联系电话")
    @TableField("hospital_telephone")
    private String hospitalTelephone;

    @ApiModelProperty("公交")
    @TableField("transit")
    private String transit;

    @ApiModelProperty("院区地址")
    @TableField("hospital_address")
    private String hospitalAddress;

    @ApiModelProperty("院区状态")
    @TableField("hospital_state")
    private Integer hospitalState;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;

    @TableField(exist = false)
    private List<HospitalInsideNavigation> hospitalInsideNavigationList;


}
