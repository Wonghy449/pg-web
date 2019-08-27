package com.pixel.pgback.common.util;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.util
 * @Author: zhouzw
 * @CreateTime: 2019/6/9 15:07
 * @Description: 解析excel测试
 */
public class ExcelTest {
    @Test
    public void testEmployee() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("E:\\fileUploadTest\\interviewer.xlsx");
        try {
            ExcelListener listener = new ExcelListener();
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
//            reader.read(new Sheet(1, 1, Interviewer.class));
            System.out.println(listener.getData().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCandidate() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("E:\\fileUploadTest\\candidate.xlsx");
        try {
            CandidateExcelListener listener = new CandidateExcelListener();
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
//            reader.read(new Sheet(1, 1, Candidate.class));
            System.out.println(listener.getData().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
