package com.pixel.pgback.service;

import com.pixel.pgback.entity.Recruiting;

import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/6/26 21:57
 * @Description: recruiting service
 */
public interface IRecruitingService {
    /**
     * 批量保存，用于excel文件解析之后入库
     *
     * @param records
     * @return
     */
    int batchSave(List<Recruiting> records);
}
