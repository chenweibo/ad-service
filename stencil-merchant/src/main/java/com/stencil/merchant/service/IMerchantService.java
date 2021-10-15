package com.stencil.merchant.service;

import com.chen.stencil.mbg.model.Admin;
import com.chen.stencil.mbg.model.Merchant;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chen
 * @since 2021-10-14
 */
public interface IMerchantService extends IService<Merchant> {

    UserDetails loadUserByUsername(String username);

    @Transactional
    void register(String username, String password,String code);

    /**
     * 登录后获取token
     */
    String login(String username, String password);


    Merchant getCurrentAdmin();



}
