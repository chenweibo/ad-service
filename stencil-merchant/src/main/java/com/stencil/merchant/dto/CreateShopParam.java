package com.stencil.merchant.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreateShopParam implements Serializable {

    @TableField("shop_type")
    private Integer shopType;

    @TableField("taobao_name")
    private String taobaoName;

    @TableField("taobao_leader")
    private String taobaoLeader;

    @TableField("shop_img")
    private String shopImg;

}
