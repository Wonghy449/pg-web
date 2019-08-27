package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.RecruitingChoseInterviewer;

import java.util.List;

public interface RecruitingChoseInterviewerMapper extends BaseMapper<RecruitingChoseInterviewer> {
    /**
     * mbg生成插入
     *
     * @param record
     * @return
     */
    int insertSelective(RecruitingChoseInterviewer record);

    /**
     * 批量插入
     *
     * @param records
     * @return
     */
    int insertBatch(List<RecruitingChoseInterviewer> records);

    /**
     * 根据面试区域查询面试官id
     *
     * @param area
     * @return
     */
    List<Integer> selectIdsByArea(String area);
}