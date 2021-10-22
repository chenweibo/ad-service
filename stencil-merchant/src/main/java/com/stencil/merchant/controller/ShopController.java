package com.stencil.merchant.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.stencil.common.response.CommonResult;
import com.chen.stencil.mbg.model.Merchant;
import com.chen.stencil.mbg.model.Shop;
import com.stencil.merchant.domain.MyPage;
import com.stencil.merchant.dto.CreateShopParam;
import com.stencil.merchant.service.impl.MerchantServiceImpl;
import com.stencil.merchant.service.impl.ShopServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    MerchantServiceImpl merchantService;
    @Autowired
    ShopServiceImpl shopService;

    @ApiOperation(value = "")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList(@RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        Merchant merchant = merchantService.getCurrentAdmin();

        QueryWrapper<Shop> queryWrapper = new QueryWrapper();
        queryWrapper.eq("merchant_id",merchant.getId());
        MyPage<Shop> page = new MyPage<>(pageNum , pageSize);

        return CommonResult.success(shopService.page(page,queryWrapper));
    }

    @ApiOperation(value = "")
    @RequestMapping(value = "/myshop", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMyShop() {

        Merchant merchant = merchantService.getCurrentAdmin();

        QueryWrapper<Shop> queryWrapper = new QueryWrapper();
        queryWrapper.eq("merchant_id",merchant.getId()).eq("is_check",1);

        return CommonResult.success(shopService.list(queryWrapper));
    }



    @ApiOperation("创建店铺")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody CreateShopParam createShopParam) {

        Merchant merchant = merchantService.getCurrentAdmin();
        Shop shop = new Shop();
        BeanUtils.copyProperties(createShopParam, shop);
        shop.setCreatedTime(LocalDateTime.now());
        shop.setIsCheck(0);
        shop.setShopTelephone(merchant.getUsername());
        shop.setMerchantId(merchant.getId());

        shopService.save(shop);

        return CommonResult.success("创建成功");
    }

    @RequestMapping(value = "/getShopInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getShopInfo(@PathVariable Long id) {

        Merchant merchant = merchantService.getCurrentAdmin();
        QueryWrapper<Shop> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id).eq("merchant_id",merchant.getId());


        return CommonResult.success(shopService.getOne(queryWrapper));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody CreateShopParam createShopParam) {

        Merchant merchant = merchantService.getCurrentAdmin();
        QueryWrapper<Shop> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id).eq("merchant_id",merchant.getId());
        Shop shop = shopService.getOne(queryWrapper);
        BeanUtils.copyProperties(createShopParam, shop);
        shop.setIsCheck(0);
        shop.setUpdatedTime(LocalDateTime.now());
        shop.setId(id);

        shopService.updateById(shop);

        return CommonResult.success("更新成功");
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {

        Merchant merchant = merchantService.getCurrentAdmin();
        QueryWrapper<Shop> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id).eq("merchant_id",merchant.getId());
        shopService.remove(queryWrapper);

        return CommonResult.success("删除成功");
    }
}
