package com.pixel.pgback.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.mapper
 * @Author: zhouzw
 * @CreateTime: 2019/6/22 19:38
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RecruitingMapperTest {
    @Autowired
    private RecruitingMapper mapper;

    @Test
    public void test1(){
        System.out.println(mapper.selectList(null));
    }

}