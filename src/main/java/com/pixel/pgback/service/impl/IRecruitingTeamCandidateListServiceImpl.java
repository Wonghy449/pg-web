package com.pixel.pgback.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pixel.pgback.entity.Candidate;
import com.pixel.pgback.mapper.CandidateMapper;
import com.pixel.pgback.service.IRecruitingTeamCandidateListService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/6/2 16:20
 * @Description:
 */
@Service
public class IRecruitingTeamCandidateListServiceImpl implements IRecruitingTeamCandidateListService {
    private final CandidateMapper mapper;

    @Autowired
    public IRecruitingTeamCandidateListServiceImpl(CandidateMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Candidate> allCandidate(Map params) {
        String interviewArea = MapUtils.getString(params, "area");
        Wrapper<Candidate> wrapper = Wrappers.query();
        ((QueryWrapper<Candidate>) wrapper).eq("expected_interview_city", interviewArea);
        List<Candidate> candidateList = mapper.selectList(wrapper);
        return candidateList;
    }

    @Override
    public int choseCandidate(Map params) {
        String area = MapUtils.getString(params, "area");
        List<Integer> ids = (List<Integer>) MapUtils.getObject(params, "ids");
        UpdateWrapper<Candidate> wrapper = Wrappers.update();
        wrapper.in("id", ids);
        int affectedRows = mapper.update(new Candidate() {
            {
                setInterviewArea(area);
            }
        }, wrapper);
        return affectedRows;
    }

    @Override
    public List<Candidate> selectedCandidate(Map params) {
        String area = MapUtils.getString(params, "area");
        QueryWrapper<Candidate> wrapper = Wrappers.query();
        wrapper.eq("interview_area", area);
        return mapper.selectList(wrapper);
    }
}
