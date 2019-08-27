package com.pixel.pgback.mapper;

import com.pixel.pgback.entity.CandidateSelectedTime;
import com.pixel.pgback.entity.InterviewerSelectedDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.mapper
 * @Author: zhouzw
 * @CreateTime: 2019/5/23 15:51
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class InterviewerSelectedDateMapperTest {
    @Autowired
    private InterviewerSelectedDateMapper mapper;
    @Autowired
    private CandidateSelectedTimeMapper candidateSelectedTimeMapper;

    @Test
    public void test() {
        InterviewerSelectedDate interviewerSelectedDate = mapper.selectById(29);
        CandidateSelectedTime candidateSelectedTime = candidateSelectedTimeMapper.selectById("9");
        System.out.println(interviewerSelectedDate.toString());
        System.out.println(candidateSelectedTime.toString());
        Date d1 = interviewerSelectedDate.getSelectedDate();
        Date d2 = candidateSelectedTime.getSelectedTime();
        System.out.println(d1.compareTo(d2));
    }
}