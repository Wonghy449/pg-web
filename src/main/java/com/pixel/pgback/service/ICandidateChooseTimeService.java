package com.pixel.pgback.service;

import com.pixel.pgback.entity.CandidateSelectedTime;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/5/23 16:23
 * @Description: 候选人选择面试时段service
 */
public interface ICandidateChooseTimeService {
    /**
     * 候选人选择面试时间
     *
     * @param params 用户名，已选时间
     * @return 受影响行数
     */
    int chooseTime(Map params);

    /**
     * 批量插入
     *
     * @param records 已选时间
     * @return 受影响行数
     */
    int batchSave(List<CandidateSelectedTime> records);
}
