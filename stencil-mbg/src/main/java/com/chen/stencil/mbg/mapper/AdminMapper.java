package com.chen.stencil.mbg.mapper;

import com.chen.stencil.mbg.model.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-14
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
