package com.pixel.pgback.service;

import java.text.ParseException;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.service
 * @Author: zhouzw
 * @CreateTime: 2019/6/20 17:07
 * @Description: 面试官选择时间Service
 */
public interface IInterviewerChooseTimeService {

    /**
     * 面试官选择时间
     *
     * @param params 用户名，已选时间
     * @return 影响行数
     * @throws ParseException
     */
    int chooseTime(Map params) throws ParseException;
}
