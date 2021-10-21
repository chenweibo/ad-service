package com.stencil.merchant.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.stencil.common.response.CommonResult;
import com.chen.stencil.mbg.mapper.MerchantMomeyLogMapper;
import com.chen.stencil.mbg.model.Merchant;
import com.chen.stencil.mbg.model.MerchantMomeyLog;
import com.stencil.merchant.domain.MyPage;
import com.stencil.merchant.service.impl.MerchantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/finance")
public class MomeyController {

    @Autowired
    MerchantMomeyLogMapper merchantMomeyLogMapper;
    @Autowired
    MerchantServiceImpl merchantService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMoneyList(@RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        Merchant merchant = merchantService.getCurrentAdmin();

        QueryWrapper<MerchantMomeyLog> queryWrapper = new QueryWrapper();
        queryWrapper.eq("merchant_id",merchant.getId());
        queryWrapper.orderByDesc("create_time");
        MyPage<MerchantMomeyLog> page = new MyPage<>(pageNum , pageSize);

        return CommonResult.success(merchantMomeyLogMapper.selectPage(page,queryWrapper));

    }
}
