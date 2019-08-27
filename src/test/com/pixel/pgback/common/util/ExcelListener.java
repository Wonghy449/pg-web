package com.pixel.pgback.common.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.pixel.pgback.entity.Interviewer;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.util
 * @Author: zhouzw
 * @CreateTime: 2019/6/9 15:19
 * @Description: ExcelListener
 */
public class ExcelListener extends AnalysisEventListener<Interviewer> {
    private List<Interviewer> data = new ArrayList<>(100);

    @Override
    public void invoke(Interviewer o, AnalysisContext analysisContext) {
        data.add(o);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<Interviewer> getData() {
        return data;
    }
}
