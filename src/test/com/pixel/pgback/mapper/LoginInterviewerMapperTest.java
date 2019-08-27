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
 * @CreateTime: 2019/5/23 13:32
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LoginInterviewerMapperTest {
    @Autowired
    private LoginEmployeeMapper mapper;

    @Test
    public void selectLogin() {
        System.out.println(mapper.selectLogin("111","1111"));
        System.out.println(mapper.selectLogin("111@111.com","1111"));
    }
}