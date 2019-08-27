package com.pixel.pgback.service;

import com.pixel.pgback.entity.Candidate;

import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/5/9 21:42
 * @Description: Candidate Service Interface
 */
public interface ICandidateService {
    /**
     * 测试用
     *
     * @param id
     * @return
     */
    Candidate selectById(Integer id);

    /**
     * 查询候选人状态
     *
     * @param username
     * @return
     */
    String queryStatus(String username);

    /**
     * 批量保存
     *
     * @param records
     * @return
     */
    int batchSave(List<Candidate> records);
}
