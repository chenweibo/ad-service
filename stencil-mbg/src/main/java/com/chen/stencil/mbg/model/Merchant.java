package com.chen.stencil.mbg.model;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chen
 * @since 2021-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Merchant对象", description="")
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String icon;

    private String email;

    private String nickName;

    private LocalDateTime createTime;

    private LocalDateTime loginTime;

    private Integer status;


}
