package com.pixel.pgback.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.pixel.pgback.entity.CandidateSelectedTime;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.common.listener
 * @Author: zhouzw
 * @CreateTime: 2019/6/26 21:30
 * @Description: 面试者时间解析listener
 */
public class CandidateTimeExcelListener extends AnalysisEventListener<CandidateSelectedTime> {
    List<CandidateSelectedTime> data = new ArrayList<>(100);

    @Override
    public void invoke(CandidateSelectedTime object, AnalysisContext context) {
        data.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<CandidateSelectedTime> getData() {
        return data;
    }
}
