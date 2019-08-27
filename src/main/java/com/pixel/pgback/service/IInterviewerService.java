package com.pixel.pgback.service;

import com.pixel.pgback.entity.Interviewer;

import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/6/9 19:42
 * @Description: Interviewer Service
 */
public interface IInterviewerService {

    /**
     * 批量保存，用于excel文件解析之后数据入库。
     *
     * @param records
     * @return
     */
    int batchSave(List<Interviewer> records);
}
