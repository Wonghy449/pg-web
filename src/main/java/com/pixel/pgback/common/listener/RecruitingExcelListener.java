package com.pixel.pgback.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.pixel.pgback.entity.Recruiting;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.common.listener
 * @Author: zhouzw
 * @CreateTime: 2019/6/22 19:48
 * @Description: 招聘团队excel解析监听
 */
public class RecruitingExcelListener extends AnalysisEventListener<Recruiting> {
    private List<Recruiting> data = new ArrayList<>(100);

    @Override
    public void invoke(Recruiting object, AnalysisContext context) {
        data.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<Recruiting> getData() {
        return data;
    }
}
