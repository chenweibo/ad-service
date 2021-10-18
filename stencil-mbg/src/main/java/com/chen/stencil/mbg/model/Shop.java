package com.chen.stencil.mbg.model;

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
 * 
 * </p>
 *
 * @author chen
 * @since 2021-10-18
 */
@Getter
@Setter
@TableName("shop")
@ApiModel(value = "Shop对象", description = "")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("shop_type")
    private Integer shopType;

    @TableField("taobao_name")
    private String taobaoName;

    @TableField("taobao_leader")
    private String taobaoLeader;

    @TableField("shop_img")
    private String shopImg;

    @TableField("is_check")
    private Integer isCheck;

    @TableField("note")
    private String note;

    @TableField("shop_telephone")
    private String shopTelephone;

    @TableField("created_time")
    private LocalDateTime createdTime;

    @TableField("merchant_id")
    private Integer merchantId;

    @TableField("updated_time")
    private LocalDateTime updatedTime;


}
