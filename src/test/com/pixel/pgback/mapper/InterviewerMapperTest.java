package com.pixel.pgback.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.mapper
 * @Author: zhouzw
 * @CreateTime: 2019/5/25 16:11
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class InterviewerMapperTest {
    @Autowired
    private InterviewerMapper mapper;

    @Test
    public void selectAllInterviewer() {
        Map<String, Object> params = new HashMap<>(10);
        List<String> date = new ArrayList<>(10);
        date.add("Oct 11");
        date.add("Oct 14");
        List<String> level = new ArrayList<>(2);
        level.add("Director");
        String interviewType = "Screen Interview";
        List<String> location = new ArrayList<>(10);
        location.add("GZ");
        params.put("date", date);
//        params.put("level", level);
//        params.put("interviewType", interviewType);
//        params.put("location", location);
        System.out.println(mapper.selectAllInterviewer(params));
    }

    @Test
    public void selectBatchIds() {
        System.out.println(mapper.selectBatchIds(Arrays.asList(1, 3, 4)));
        System.out.println("##############################################");
    }
}