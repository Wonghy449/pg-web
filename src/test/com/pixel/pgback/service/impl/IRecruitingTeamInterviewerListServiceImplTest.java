package com.pixel.pgback.service.impl;

import com.pixel.pgback.entity.RecruitingChoseInterviewer;
import com.pixel.pgback.mapper.RecruitingChoseInterviewerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service.impl
 * @Author: zhouzw
 * @CreateTime: 2019/5/31 17:35
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class IRecruitingTeamInterviewerListServiceImplTest {
    @Autowired
    private RecruitingChoseInterviewerMapper mapper;

    @Test
    public void chooseInterviewer() {
        String area = "Test";
        List<Integer> ids = new ArrayList<Integer>(5) {
            {
                add(1);
                add(3);
                add(4);
            }
        };
        List<RecruitingChoseInterviewer> records = new ArrayList<>(3);
        for (Integer id : ids) {
            RecruitingChoseInterviewer record = new RecruitingChoseInterviewer();
            record.setInterviewerId(id);
            record.setInterviewArea(area);
            records.add(record);
        }
        System.out.println(mapper.insertBatch(records));
    }

    @Test
    public void selectedInterviewer() {
        String area = "Test";
        System.out.println(mapper.selectIdsByArea(area) + "\n" + "#####################");
    }
}