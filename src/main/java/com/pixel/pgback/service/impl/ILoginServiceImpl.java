package com.pixel.pgback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pixel.pgback.entity.Login;
import com.pixel.pgback.mapper.LoginCandidateMapper;
import com.pixel.pgback.mapper.LoginEmployeeMapper;
import com.pixel.pgback.mapper.LoginMapper;
import com.pixel.pgback.service.ILoginService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/5/21 23:05
 * @Description:
 */
@Service
public class ILoginServiceImpl implements ILoginService {
    private final LoginCandidateMapper loginCandidateMapper;
    private final LoginEmployeeMapper loginEmployeeMapper;

    @Autowired
    private LoginMapper mapper;

    @Autowired
    public ILoginServiceImpl(LoginCandidateMapper loginCandidateMapper, LoginEmployeeMapper loginEmployeeMapper) {
        this.loginCandidateMapper = loginCandidateMapper;
        this.loginEmployeeMapper = loginEmployeeMapper;
    }

    @Override
    public boolean candidateLogin(Map loginInfo) {
        String username = MapUtils.getString(loginInfo, "username");
        String password = MapUtils.getString(loginInfo, "password");
        Integer loginCandidateId = loginCandidateMapper.selectLogin(username, password);
        return null != loginCandidateId;
    }

    @Override
    public Map employeeLogin(Map loginInfo) {
        Map result;
        String username = MapUtils.getString(loginInfo, "username");
        String password = MapUtils.getString(loginInfo, "password");
        result = loginEmployeeMapper.selectLogin(username, password);
        return result;
    }

    @Override
    public Login login(Map loginInfo) {
        String username = MapUtils.getString(loginInfo, "username");
        String password = MapUtils.getString(loginInfo, "password");
        QueryWrapper<Login> wrapper = Wrappers.query();
        wrapper.eq("username", username);
        wrapper.eq("password", password);
        return mapper.selectOne(wrapper);
    }
}
