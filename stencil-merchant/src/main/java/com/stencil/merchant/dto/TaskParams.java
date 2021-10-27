package com.stencil.merchant.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class TaskParams  implements Serializable {


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

    @TableField("total")
    private Integer total;


}
