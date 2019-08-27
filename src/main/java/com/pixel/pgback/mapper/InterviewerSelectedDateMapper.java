package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.InterviewerSelectedDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterviewerSelectedDateMapper extends BaseMapper<InterviewerSelectedDate> {
    int insertSelective(InterviewerSelectedDate record);

    int insertTime(@Param("id") Integer id, @Param("times") List times);
}