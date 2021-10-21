package com.stencil.merchant.controller;


import com.chen.stencil.common.response.CommonResult;
import com.chen.stencil.mbg.model.Admin;
import com.chen.stencil.mbg.model.Merchant;
import com.stencil.merchant.dto.LoginParams;
import com.stencil.merchant.dto.RegisterParams;
import com.stencil.merchant.dto.UpdatePassword;
import com.stencil.merchant.service.IMerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "管理员登录注册管理")
@RequestMapping("/sso")
public class MerchantController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private IMerchantService merchantService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @ApiOperation("管理员注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody @Valid RegisterParams registerParams) {
        merchantService.register(registerParams.getUsername(), registerParams.getPassword(),registerParams.getCode());
        return CommonResult.success(null, "注册成功");
    }

    @ApiOperation("管理员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody @Valid LoginParams loginParams) {
        String token = merchantService.login(loginParams.getUsername(), loginParams.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取管理员信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        Merchant admin = merchantService.getCurrentAdmin();
        admin.setPassword("");
        return CommonResult.success(admin);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestBody @Valid UpdatePassword updatePassword) {


        Merchant admin = merchantService.getCurrentAdmin();
        admin.setPassword(passwordEncoder.encode(updatePassword.getPassword()));
        merchantService.updateById(admin);
        return CommonResult.success(null, "密码修改成功");
    }


}
