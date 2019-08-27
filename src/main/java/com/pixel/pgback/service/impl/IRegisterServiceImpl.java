package com.pixel.pgback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pixel.pgback.common.Constants;
import com.pixel.pgback.entity.Administrator;
import com.pixel.pgback.entity.Interviewer;
import com.pixel.pgback.entity.Login;
import com.pixel.pgback.entity.Recruiting;
import com.pixel.pgback.mapper.*;
import com.pixel.pgback.service.IRegisterService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/5/21 19:31
 * @Description:注册service实现
 */
@Service
@SuppressWarnings("unchecked")
public class IRegisterServiceImpl implements IRegisterService {
    private final CandidateMapper candidateMapper;
    private final InterviewerMapper interviewerMapper;
    private final RecruitingMapper recruitingMapper;
    private final AdministratorMapper administratorMapper;
    private final LoginMapper loginMapper;

    @Autowired
    public IRegisterServiceImpl(CandidateMapper candidateMapper, InterviewerMapper interviewerMapper, RecruitingMapper recruitingMapper, AdministratorMapper administratorMapper, LoginMapper loginMapper) {
        this.candidateMapper = candidateMapper;
        this.interviewerMapper = interviewerMapper;
        this.recruitingMapper = recruitingMapper;
        this.administratorMapper = administratorMapper;
        this.loginMapper = loginMapper;
    }

    @Override
    public boolean candidateRegister(Map registerInfo) {
        String email = MapUtils.getString(registerInfo, "email");
        String phone = MapUtils.getString(registerInfo, "phone");
        String username = MapUtils.getString(registerInfo, "username");
        String password = MapUtils.getString(registerInfo, "password");
        Integer candidateId = candidateMapper.selectRegister(email, phone);
        if (null == candidateId) {
            return false;
        } else {
            QueryWrapper<Login> wrapper = Wrappers.query();
            wrapper.eq("user_id", candidateId);
            int count = loginMapper.selectCount(wrapper);
            if (count == 0) {
                Login login = new Login();
                login.setUserId(candidateId);
                login.setIdentity(Constants.IDENTITY_CANDIDATE);
                login.setUsername(username);
                login.setPassword(password);
                loginMapper.insert(login);
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean employeeRegister(Map registerInfo) {
        String email = MapUtils.getString(registerInfo, "email");
        String password = MapUtils.getString(registerInfo, "password");
        Interviewer interviewer = interviewerMapper.selectRegister(email);
        Recruiting recruiting = recruitingMapper.selectRegister(email);
        Administrator admin = administratorMapper.selectRegister(email);
        QueryWrapper idWrapper = Wrappers.query();
        if (null == interviewer && null == recruiting && null == admin) {
            return false;
        } else if (null != interviewer && null != recruiting) {
            idWrapper.in("user_id", interviewer.getId(), recruiting.getId());
            int count = loginMapper.selectCount(idWrapper);
            if (count == 0) {
                Login login = new Login();
                login.setUserId(interviewer.getId());
                login.setIdentity(Constants.IDENTITY_REANDIN);
                login.setUsername(email);
                login.setPassword(password);
                loginMapper.insert(login);
                return true;
            }
            return false;
        } else if (null != interviewer) {
            idWrapper.eq("user_id", interviewer.getId());
            int count = loginMapper.selectCount(idWrapper);
            if (count == 0) {
                Login login = new Login();
                login.setUserId(interviewer.getId());
                login.setIdentity(Constants.IDENTITY_INTERVIEWER);
                login.setUsername(email);
                login.setPassword(password);
                loginMapper.insert(login);
                return true;
            }
            return false;
        } else if (null != recruiting) {
            idWrapper.eq("user_id", recruiting.getId());
            int count = loginMapper.selectCount(idWrapper);
            if (count == 0) {
                Login login = new Login();
                login.setUserId(recruiting.getId());
                login.setIdentity(Constants.IDENTITY_RECRUITING);
                login.setUsername(email);
                login.setPassword(password);
                loginMapper.insert(login);
                return true;
            }
            return false;
        } else if (null != admin) {
            idWrapper.eq("user_id", admin.getId());
            int count = loginMapper.selectCount(idWrapper);
            if (count == 0) {
                Login login = new Login();
                login.setUserId(admin.getId());
                login.setIdentity(admin.getPrivilege());
                login.setUsername(email);
                login.setPassword(password);
                loginMapper.insert(login);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
