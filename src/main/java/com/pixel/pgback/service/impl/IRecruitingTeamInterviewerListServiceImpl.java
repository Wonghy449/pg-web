package com.pixel.pgback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pixel.pgback.common.util.MailUtil;
import com.pixel.pgback.entity.Interviewer;
import com.pixel.pgback.entity.RecruitingChoseTime;
import com.pixel.pgback.mapper.InterviewerMapper;
import com.pixel.pgback.mapper.RecruitingChoseInterviewerMapper;
import com.pixel.pgback.mapper.RecruitingChoseTimeMapper;
import com.pixel.pgback.service.IRecruitingTeamInterviewerListService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/5/25 14:51
 * @Description:
 */
@Service
public class IRecruitingTeamInterviewerListServiceImpl implements IRecruitingTeamInterviewerListService {
    private final InterviewerMapper interviewerMapper;
    private final RecruitingChoseInterviewerMapper choseInterviewerMapper;
    private final RecruitingChoseTimeMapper recruitingChoseTimeMapper;

    @Autowired
    public IRecruitingTeamInterviewerListServiceImpl(InterviewerMapper interviewerMapper, RecruitingChoseInterviewerMapper choseInterviewerMapper, RecruitingChoseTimeMapper recruitingChoseTimeMapper) {
        this.interviewerMapper = interviewerMapper;
        this.choseInterviewerMapper = choseInterviewerMapper;
        this.recruitingChoseTimeMapper = recruitingChoseTimeMapper;
    }

    @Override
    public List allInterviewer(Map params) {
        List<Map> list = interviewerMapper.selectAllInterviewer(params);
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int chooseInterviewer(Map params) throws Exception {
        String area = MapUtils.getString(params, "area");
        List<Integer> ids = (List<Integer>) MapUtils.getObject(params, "ids");
        List<String> times = (List<String>) MapUtils.getObject(params, "times");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String s : times) {
            RecruitingChoseTime choseTime = new RecruitingChoseTime();
            choseTime.setTime(sdf.parse(s));
            recruitingChoseTimeMapper.insert(choseTime);
        }

        List<Interviewer> interviewers = interviewerMapper.mySelectBatchIds(ids);
        StringBuffer emails = new StringBuffer();
        for (Interviewer interviewer : interviewers) {
            String email = interviewer.getEmail();
            emails.append(email);
            emails.append(",");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("邀请您参加以下时间的面试：");
        for (String time : times) {
            sb.append("    " + time);
        }
        sb.append("<a href=\"http://192.168.43.168/login.html\">请登录后选择面试时间。</a>");
        MailUtil.sendMailText("面试邀请", sb.toString(), emails.toString());
        return interviewerMapper.uadateBatchArea(area, ids);
    }

    @Override
    public List<Interviewer> selectedInterviewer(Map params) {
        String area = MapUtils.getString(params, "area");
        QueryWrapper<Interviewer> wrapper = Wrappers.query();
        wrapper.eq("interview_area", area);
        return interviewerMapper.selectList(wrapper);
    }
}
