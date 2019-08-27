package com.pixel.pgback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pixel.pgback.common.Constants;
import com.pixel.pgback.entity.Login;
import com.pixel.pgback.mapper.InterviewerSelectedDateMapper;
import com.pixel.pgback.mapper.LoginMapper;
import com.pixel.pgback.service.IInterviewerChooseTimeService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/6/20 17:12
 * @Description:
 */
@Service
public class IInterviewerChooseTimeServiceImpl implements IInterviewerChooseTimeService {
    private final InterviewerSelectedDateMapper mapper;
    private final LoginMapper loginMapper;

    @Autowired
    public IInterviewerChooseTimeServiceImpl(InterviewerSelectedDateMapper mapper, LoginMapper loginMapper) {
        this.mapper = mapper;
        this.loginMapper = loginMapper;
    }

    @Override
    public int chooseTime(Map params) throws ParseException {
        String username = MapUtils.getString(params, "username");
        List<String> times = (List<String>) MapUtils.getObject(params, "choseTime");
        QueryWrapper<Login> wrapper = Wrappers.query();
        wrapper.eq("username", username);
        Login login = loginMapper.selectOne(wrapper);
        if (null != login) {
            Integer userId = login.getUserId();
            List<Date> choseTimes = new ArrayList<>(10);
            for (String time : times) {
                String[] strings = time.split(" ");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = strings[0];
                String type = strings[1];
                if (Constants.INTERVIEWER_TIME_MORNING.equals(type)) {
                    Date time09 = sdf.parse(date + " " + Constants.INTERVIEW_TIME_09);
                    Date time10 = sdf.parse(date + " " + Constants.INTERVIEW_TIME_10);
                    Date time11 = sdf.parse(date + " " + Constants.INTERVIEW_TIME_11);
                    choseTimes.add(time09);
                    choseTimes.add(time10);
                    choseTimes.add(time11);
                } else if (Constants.INTERVIEWER_TIME_AFTERNOON.equals(type)) {
                    Date time13 = sdf.parse(date + " " + Constants.INTERVIEW_TIME_13);
                    Date time14 = sdf.parse(date + " " + Constants.INTERVIEW_TIME_14);
                    Date time15 = sdf.parse(date + " " + Constants.INTERVIEW_TIME_15);
                    Date time16 = sdf.parse(date + " " + Constants.INTERVIEW_TIME_16);
                    choseTimes.add(time13);
                    choseTimes.add(time14);
                    choseTimes.add(time15);
                    choseTimes.add(time16);
                } else {
                    return 0;
                }
            }
            return mapper.insertTime(userId, choseTimes);
        }
        return 0;
    }
}
