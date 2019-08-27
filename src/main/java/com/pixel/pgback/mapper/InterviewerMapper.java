package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.Interviewer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InterviewerMapper extends BaseMapper<Interviewer> {
    /**
     * 更新
     *
     * @param interviewer
     * @return
     */
    int updatePreferredCity(Interviewer interviewer);

    /**
     * 检查是否已注册
     *
     * @param email
     * @return
     */
    Interviewer selectRegister(String email);

    /**
     * 查询所有符合条件的面试官
     *
     * @param params
     * @return
     */
    List<Map> selectAllInterviewer(Map params);

    /**
     * 批量插入
     *
     * @param records
     * @return
     */
    int batchInsert(List<Interviewer> records);

    List<Interviewer> mySelectBatchIds(List<Integer> ids);

    int uadateBatchArea(@Param("area") String area, @Param("ids") List<Integer> ids);
}