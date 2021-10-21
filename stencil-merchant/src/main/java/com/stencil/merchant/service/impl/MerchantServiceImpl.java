package com.stencil.merchant.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.chen.stencil.mbg.model.Merchant;
import com.chen.stencil.mbg.mapper.MerchantMapper;
import com.chen.stencil.security.util.JwtTokenUtil;
import com.stencil.merchant.domain.MerchantDetails;
import com.stencil.merchant.exception.Asserts;
import com.stencil.merchant.service.IMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-14
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements IMerchantService {


    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantServiceImpl.class);

    @Autowired
    MerchantMapper merchantMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Merchant merchant = merchantMapper.selectOne(Wrappers.<Merchant>lambdaQuery().eq(Merchant::getUsername, username));
        if (merchant != null) {

            return new MerchantDetails(merchant);
        }

        throw new UsernameNotFoundException("账号不存在，重新登录");

    }

    @Override
    public void register(String username, String password, String code) {


        //查询是否已有该用户
        Merchant admin = merchantMapper.selectOne(Wrappers.<Merchant>lambdaQuery().eq(Merchant::getUsername, username));
        if (admin != null) {
            Asserts.fail("该用户已经存在");
        }
        if (!code.equals("123")) {
            Asserts.fail("邀请码错误");
        }
        //创建用户
        Merchant createAdmin = new Merchant();

        createAdmin.setUsername(username);

        createAdmin.setPassword(passwordEncoder.encode(password));
        createAdmin.setCreateTime(LocalDateTime.now());
        createAdmin.setInvite(code);
        createAdmin.setMomey(BigDecimal.valueOf(0));
        createAdmin.setStatus(1);
        merchantMapper.insert(createAdmin);


    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public Merchant getCurrentAdmin() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        MerchantDetails adminDetails = (MerchantDetails) auth.getPrincipal();
        return adminDetails.getMerchant();
    }

}
