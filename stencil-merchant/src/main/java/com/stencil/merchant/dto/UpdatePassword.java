package com.stencil.merchant.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdatePassword {


    @NotEmpty
    @ApiModelProperty(value = "密码")
    private String password;
}
