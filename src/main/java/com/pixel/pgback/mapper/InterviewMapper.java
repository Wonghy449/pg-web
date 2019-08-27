package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.Interview;

public interface InterviewMapper extends BaseMapper<Interview> {
    int insertSelective(Interview record);
}