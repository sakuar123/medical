package com.sakura.medical.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 医院内部导航
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-11
 */
@Getter
@Setter
@TableName("hospital_inside_navigation")
@ApiModel(value = "HospitalInsideNavigation对象", description = "医院内部导航")
public class HospitalInsideNavigation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("医院id")
    @TableField("hospital_id")
    private Integer hospitalId;

    @ApiModelProperty("医院楼层")
    @TableField("hospital_floor")
    private String hospitalFloor;

    @ApiModelProperty("楼层索引")
    @TableField("hospital_floor_index")
    private String hospitalFloorIndex;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;


}
