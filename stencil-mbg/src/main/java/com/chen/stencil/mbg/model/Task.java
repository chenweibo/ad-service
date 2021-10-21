package com.chen.stencil.mbg.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author chen
 * @since 2021-10-21
 */
@Getter
@Setter
@TableName("task")
@ApiModel(value = "Task对象", description = "")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("shop_id")
    private Integer shopId;

    @TableField("shop_name")
    private String shopName;

    @TableField("task_type")
    private Integer taskType;

    @TableField("back_type")
    private Integer backType;

    @TableField("task_content")
    private String taskContent;

    @TableField("product_url")
    private String productUrl;

    @TableField("product_name")
    private String productName;

    @TableField("product_img")
    private String productImg;

    @TableField("price")
    private BigDecimal price;

    @TableField("count")
    private Integer count;

    @TableField("start_time")
    private String startTime;

    @TableField("end_time")
        private String endTime;

    @TableField("run_type")
    private Integer runType;

    @TableField("is_tbk")
    private Integer isTbk;

    @TableField("extra")
    private String extra;

    @TableField("task_name")
    private String taskName;

    @TableField("created_time")
    private LocalDateTime createdTime;

    @TableField("updated_time")
    private LocalDateTime updatedTime;

    @TableField("status")
    private Integer status;

    @TableField("version")
    @Version
    private Integer version;


}
