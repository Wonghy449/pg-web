package com.pixel.pgback.service;

import com.alibaba.fastjson.JSON;
import com.pixel.pgback.entity.Candidate;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/5/9 22:21
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ICandidateServiceTest {
    private static Logger logger = Logger.getLogger(ICandidateServiceTest.class);
    @Autowired
    private ICandidateService candidateService;

    @Test
    public void test() {
        Candidate candidate = candidateService.selectById(1);
        logger.info(JSON.toJSONString(candidate));
    }



}