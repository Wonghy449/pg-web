package com.pixel.pgback.service;

import com.pixel.pgback.entity.Candidate;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/6/2 16:15
 * @Description: 招聘团队候选人名单service
 */
public interface IRecruitingTeamCandidateListService {
    /**
     * 所有候选人
     *
     * @param params 招聘区域
     * @return
     */
    List<Candidate> allCandidate(Map params);

    /**
     * 选择候选人
     *
     * @param params
     * @return
     */
    int choseCandidate(Map params);

    /**
     * 已选候选人
     *
     * @param params
     * @return
     */
    List<Candidate> selectedCandidate(Map params);
}
