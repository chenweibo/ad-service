package com.chen.stencil.mbg.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
 * @since 2021-10-14
 */
@Getter
@Setter
@TableName("z")
@ApiModel(value = "Z对象", description = "")
public class Z implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("dd")
    private String dd;


}
