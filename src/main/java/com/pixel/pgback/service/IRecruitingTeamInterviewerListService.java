package com.pixel.pgback.service;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/5/24 17:57
 * @Description: 招聘团队面试官service
 */
public interface IRecruitingTeamInterviewerListService {

    /**
     * 查询所有面试官
     *
     * @param params 查询条件
     * @return 符合条件面试官列表
     */
    List allInterviewer(Map params);

    /**
     * 选择面试官
     *
     * @param params 面试官id及招聘团队人员用户名
     * @return
     */
    int chooseInterviewer(Map params) throws Exception;

    /**
     * 查询已选择面试官
     *
     * @param params
     * @return
     */
    List selectedInterviewer(Map params);

}
