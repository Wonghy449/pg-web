package com.pixel.pgback.service;

import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/5/21 19:25
 * @Description: 注册service
 */
public interface IRegisterService {
    /**
     * 候选人注册
     *
     * @param registerInfo 候选人注册信息
     * @return 注册结果
     */
    boolean candidateRegister(Map registerInfo);


    /**
     * 面试官，招聘团队注册
     *
     * @param registerInfo 员工注册信息
     * @return 注册结果
     */
    boolean employeeRegister(Map registerInfo);
}
