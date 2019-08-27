package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.Distribution;

public interface DistributionMapper extends BaseMapper<Distribution> {
    int insertSelective(Distribution record);
}