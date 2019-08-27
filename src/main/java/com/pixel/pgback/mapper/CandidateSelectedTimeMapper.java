package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.CandidateSelectedTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CandidateSelectedTimeMapper extends BaseMapper<CandidateSelectedTime> {
    /**
     * MBG生成插入方法
     *
     * @param record
     * @return
     */
    int insertSelective(CandidateSelectedTime record);

    /**
     * insert方法，同一候选人所选时间
     *
     * @param username      候选人用户名
     * @param interviewType 面试类型
     * @param times         所选时间
     * @return 受影响行数
     */
    int insertTimes(@Param("username") String username, @Param("interviewType") String interviewType, @Param("times") List times);

    /**
     * 批量插入，用于文件上传导入
     *
     * @param records 所有候选人所有时间
     * @return 受影响行数
     */
    int batchInsert(List<CandidateSelectedTime> records);
}