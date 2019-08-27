package com.pixel.pgback.service.impl;

import com.pixel.pgback.entity.Candidate;
import com.pixel.pgback.mapper.CandidateMapper;
import com.pixel.pgback.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/5/9 21:46
 * @Description:
 */
@Service
public class ICandidateServiceImpl implements ICandidateService {
    private final CandidateMapper mapper;

    @Autowired
    public ICandidateServiceImpl(CandidateMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Candidate selectById(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public String queryStatus(String username) {
        return mapper.selectStatus(username);
    }

    @Override
    public int batchSave(List<Candidate> records) {
        return mapper.batchInsert(records);
    }
}
