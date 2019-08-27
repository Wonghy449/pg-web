package com.pixel.pgback.service;

import com.pixel.pgback.entity.Login;

import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/5/21 22:09
 * @Description: 登录service
 */
public interface ILoginService {
    /**
     * 候选人登录
     *
     * @param loginInfo 登录信息：账号，密码
     * @return 登录结果
     */
    boolean candidateLogin(Map loginInfo);

    /**
     * 员工登录
     *
     * @param loginInfo 登录信息：工号或邮箱，密码
     * @return 登录结果, 包含登陆结果和身份
     */
    Map employeeLogin(Map loginInfo);

    /**
     * 登录，现在不再需要前台传入登录身份，后台可以自动识别
     * @param loginInfo
     * @return
     */
    Login login(Map loginInfo);
}

