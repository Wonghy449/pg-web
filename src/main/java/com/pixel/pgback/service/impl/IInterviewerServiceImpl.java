package com.pixel.pgback.service.impl;

import com.pixel.pgback.entity.Interviewer;
import com.pixel.pgback.mapper.InterviewerMapper;
import com.pixel.pgback.service.IInterviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/6/9 19:43
 * @Description:
 */
@Service
public class IInterviewerServiceImpl implements IInterviewerService {
    private final InterviewerMapper mapper;

    @Autowired
    public IInterviewerServiceImpl(InterviewerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int batchSave(List<Interviewer> records) {
        return mapper.batchInsert(records);
    }
}
