package com.pixel.pgback.entity;

import java.util.Date;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.entity
 * @Author: zhouzw
 * @CreateTime: 2019/8/18 16:10
 * @Description: 招聘团队选择时间
 */
public class RecruitingChoseTime {
    private Integer id;
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
