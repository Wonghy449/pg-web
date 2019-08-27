package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.Recruiting;

import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.mapper
 * @Author: zhouzw
 * @CreateTime: 2019/6/22 19:37
 * @Description: recruiting mapper
 */
public interface RecruitingMapper extends BaseMapper<Recruiting> {

    /**
     * 批量插入
     *
     * @param records
     * @return
     */
    int batchInsert(List<Recruiting> records);

    /**
     * 注册检查，查询是否有对应email
     *
     * @param email
     * @return
     */
    Recruiting selectRegister(String email);
}
