package com.pixel.pgback.service.impl;

import com.pixel.pgback.entity.CandidateSelectedTime;
import com.pixel.pgback.mapper.CandidateSelectedTimeMapper;
import com.pixel.pgback.service.ICandidateChooseTimeService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/5/23 16:25
 * @Description:
 */
@Service
public class ICandidateChooseTimeServiceImpl implements ICandidateChooseTimeService {
    @Autowired
    private CandidateSelectedTimeMapper mapper;

    @Override
    public int chooseTime(Map params) {
        String username = MapUtils.getString(params, "username");
        String interviewType = MapUtils.getString(params, "interviewType");
        List<Date> times = (List<Date>) MapUtils.getObject(params, "choseTime");
        return mapper.insertTimes(username, interviewType, times);
    }

    @Override
    public int batchSave(List<CandidateSelectedTime> records) {
        return 0;
    }
}
