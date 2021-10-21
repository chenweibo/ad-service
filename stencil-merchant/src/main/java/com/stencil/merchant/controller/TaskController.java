package com.stencil.merchant.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.stencil.common.response.CommonResult;
import com.chen.stencil.mbg.model.Merchant;
import com.chen.stencil.mbg.model.Shop;
import com.stencil.merchant.domain.MyPage;
import com.stencil.merchant.dto.RegisterParams;
import com.stencil.merchant.dto.TaskParams;
import com.stencil.merchant.service.ITaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    ITaskService taskService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList(@RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {


        return CommonResult.success("");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody @Valid TaskParams taskParams) {

        taskService.CreateTask(taskParams);

        return CommonResult.success(null, "注册成功");
    }

}
