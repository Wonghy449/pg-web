package com.pixel.pgback.service.impl;

import com.pixel.pgback.entity.Recruiting;
import com.pixel.pgback.mapper.RecruitingMapper;
import com.pixel.pgback.service.IRecruitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/6/26 21:59
 * @Description:
 */
@Service
public class IRecruitingServiceImpl implements IRecruitingService {
    private final RecruitingMapper mapper;

    @Autowired
    public IRecruitingServiceImpl(RecruitingMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int batchSave(List<Recruiting> records) {
        return mapper.batchInsert(records);
    }
}
