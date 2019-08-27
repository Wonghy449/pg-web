package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.Contribution;

public interface ContributionMapper extends BaseMapper<Contribution> {
    int insertSelective(Contribution record);
}