package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pixel.pgback.entity.Candidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.mapper
 * @Author: zhouzw
 * @CreateTime: 2019/5/28 18:15
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CandidateMapperTest {
    @Autowired
    private CandidateMapper mapper;

    @Test
    public void test() {
        Wrapper<Candidate> wrapper = Wrappers.query();
        ((QueryWrapper<Candidate>) wrapper).eq("interview_area", "GZ");
        System.out.println(mapper.selectList(wrapper) + "\n");
        System.out.println(mapper.selectList(null) + "\n");
    }
}