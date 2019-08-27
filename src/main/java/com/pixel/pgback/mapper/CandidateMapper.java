package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.Candidate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CandidateMapper extends BaseMapper<Candidate> {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Candidate selectById(Integer id);

    /**
     * 注册校验
     *
     * @param email
     * @param phone
     * @return
     */
    Integer selectRegister(@Param("email") String email, @Param("phone") String phone);

    /**
     * 查询状态
     *
     * @param username
     * @return
     */
    String selectStatus(String username);

    /**
     * 批量插入
     *
     * @param records
     * @return
     */
    int batchInsert(List<Candidate> records);
}