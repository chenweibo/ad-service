package com.chen.stencil.mbg.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2021-10-19
 */
@Getter
@Setter
@TableName("merchant_momey_log")
@ApiModel(value = "MerchantMomeyLog对象", description = "")
public class MerchantMomeyLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("merchant_id")
    private Integer merchantId;

    @TableField("pay")
    private BigDecimal pay;

    @TableField("current_momey")
    private BigDecimal currentMomey;

    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("0为减1为加")
    @TableField("plus_minus")
    private Integer plusMinus;

    @TableField("note")
    private String note;

    @TableField("shop_id")
    private Integer shopId;

    @TableField("order_id")
    private Integer orderId;

    @TableField("task_id")
    private Integer taskId;

    @TableField("shop_name")
    private String shopName;


}
