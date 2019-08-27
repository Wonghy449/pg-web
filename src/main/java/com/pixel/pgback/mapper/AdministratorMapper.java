package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.Administrator;

public interface AdministratorMapper extends BaseMapper<Administrator> {
    /**
     * 注册检查，查询是否有对应email
     *
     * @param email
     * @return
     */
    Administrator selectRegister(String email);
}