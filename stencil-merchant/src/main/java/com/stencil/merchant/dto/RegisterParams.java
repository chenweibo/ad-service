package com.stencil.merchant.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterParams {

    @NotEmpty
    @Size(min = 11, max = 11, message = "手机号码长度不正确")
    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "手机号格式错误")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码")
    private String password;

    @NotEmpty
    @ApiModelProperty(value = "密码")
    private String code;
}
