package com.pixel.pgback.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.pixel.pgback.entity.Interviewer;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.common.listener
 * @Author: zhouzw
 * @CreateTime: 2019/6/9 18:37
 * @Description: 员工excel解析监听器
 */
public class InterviewerExcelListener extends AnalysisEventListener<Interviewer> {
    private List<Interviewer> data = new ArrayList<>(100);

    @Override
    public void invoke(Interviewer object, AnalysisContext context) {
        data.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

    public List<Interviewer> getData() {
        return data;
    }
}
