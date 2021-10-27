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
 * @since 2021-10-22
 */
@Getter
@Setter
@TableName("merchant")
@ApiModel(value = "Merchant对象", description = "")
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("icon")
    private String icon;

    @TableField("email")
    private String email;

    @TableField("nick_name")
    private String nickName;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("login_time")
    private LocalDateTime loginTime;

    @TableField("status")
    private Integer status;

    @TableField("invite")
    private String invite;

    @TableField("momey")
    private BigDecimal momey;

    @TableField("is_back")
    private Integer isBack;

}
