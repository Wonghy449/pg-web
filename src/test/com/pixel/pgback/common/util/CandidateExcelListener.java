package com.pixel.pgback.common.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.pixel.pgback.entity.Candidate;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.util
 * @Author: zhouzw
 * @CreateTime: 2019/6/9 18:26
 * @Description: CandidateExcelListener
 */
public class CandidateExcelListener extends AnalysisEventListener<Candidate> {
    private List<Candidate> data = new ArrayList<>(100);

    @Override
    public void invoke(Candidate object, AnalysisContext context) {
        data.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<Candidate> getData() {
        return data;
    }
}
