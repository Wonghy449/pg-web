package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.LoginCandidate;
import org.apache.ibatis.annotations.Param;

public interface LoginCandidateMapper extends BaseMapper<LoginCandidate> {
    int insertSelective(LoginCandidate record);

    int selectCountByCandidateId(Integer candidateId);

    Integer selectLogin(@Param("username") String username, @Param("password") String password);
}