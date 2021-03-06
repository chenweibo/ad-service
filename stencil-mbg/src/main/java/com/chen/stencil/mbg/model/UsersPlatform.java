package com.chen.stencil.mbg.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 第三方登录表
 * </p>
 *
 * @author chen
 * @since 2020-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UsersPlatform对象", description="第三方登录表")
public class UsersPlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer usersId;

    @ApiModelProperty(value = "平台id")
    private String platformId;

    @ApiModelProperty(value = "平台access_token")
    private String platformToken;

    @ApiModelProperty(value = "平台类型 0:未知,1:facebook,2:google,3:wechat,4:qq,5:weibo,6:twitter")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
