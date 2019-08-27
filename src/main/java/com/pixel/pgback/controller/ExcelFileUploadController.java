package com.pixel.pgback.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.pixel.pgback.common.Constants;
import com.pixel.pgback.common.Result;
import com.pixel.pgback.common.listener.CandidateExcelListener;
import com.pixel.pgback.common.listener.CandidateTimeExcelListener;
import com.pixel.pgback.common.listener.InterviewerExcelListener;
import com.pixel.pgback.common.listener.RecruitingExcelListener;
import com.pixel.pgback.common.util.ResultUtil;
import com.pixel.pgback.entity.Candidate;
import com.pixel.pgback.entity.CandidateSelectedTime;
import com.pixel.pgback.entity.Interviewer;
import com.pixel.pgback.entity.Recruiting;
import com.pixel.pgback.service.ICandidateService;
import com.pixel.pgback.service.IInterviewerService;
import com.pixel.pgback.service.IRecruitingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.controller
 * @Author: zhouzw
 * @CreateTime: 2019/6/8 14:33
 * @Description: 上传excel文件controller
 */
@RestController
@RequestMapping("/recruiting")
public class ExcelFileUploadController {
    private static Logger logger = Logger.getLogger(ExcelFileUploadController.class);
    /**
     * 候选人文件路径
     */
    private static final String CANDIDATE_FILE_PATH = "E:/fileUploadTest/candidate.xlsx";
    /**
     * 面试官文件路径
     */
    private static final String INTERVIEWER_FILE_PATH = "E:/fileUploadTest/interviewer.xlsx";
    /**
     * 招聘团队文件路径
     */
    private static final String RECRUITING_FILE_PATH = "E:/fileUploadTest/recruiting.xlsx";
    /**
     * 候选人时间文件路径
     */
    private static final String CANDIDATE_TIME_FILE_PATH = "E:/fileUploadTest/candidateTime.xlsx";
    private final ICandidateService candidateService;
    private final IInterviewerService interviewerService;
    private final IRecruitingService recruitingService;

    @Autowired
    public ExcelFileUploadController(ICandidateService candidateService, IInterviewerService interviewerService, IRecruitingService recruitingService) {
        this.candidateService = candidateService;
        this.interviewerService = interviewerService;
        this.recruitingService = recruitingService;
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("candidate") MultipartFile candidateFile,
                         @RequestParam("interviewer") MultipartFile interviewerFile,
                         @RequestParam("recruiting") MultipartFile recruitingFile
    ) {
//        @RequestParam("candidateTime") MultipartFile candidateTimeFile
        Result result = ResultUtil.getResultForFail(null);
        try {
            if (null != candidateFile && null != interviewerFile && null != recruitingFile) {
                logger.info("招聘团队上传excel信息：" + "\n" +
                        "Candidate File Name : " + candidateFile.getOriginalFilename() + "\n" +
                        "Interviewer File Name : " + interviewerFile.getOriginalFilename() + "\n" +
                        "Recruiting File Name : " + recruitingFile.getOriginalFilename());
                List<Candidate> candidateList = candidateExcelProcess(candidateFile.getInputStream());
//                List<CandidateSelectedTime> candidateTimeList = candidateTimeExcelProcess(candidateTimeFile.getInputStream());
                List<Interviewer> interviewerList = interviewerExcelProcess(interviewerFile.getInputStream());
                List<Recruiting> recruitingList = recruitingExcelProcess(recruitingFile.getInputStream());
                int candidateRows = candidateService.batchSave(candidateList);
                int candidateTimeRows;
                int interviewerRows = interviewerService.batchSave(interviewerList);
                int recruitingRows = recruitingService.batchSave(recruitingList);
                logger.info("记录数：" +
                        "Candidate : " + candidateRows + "," +
                        "Interviewer : " + interviewerRows + "," +
                        "Recruiting Team : " + recruitingRows);
                if (candidateRows != 0 && interviewerRows != 0 && recruitingRows != 0) {
                    result = ResultUtil.getResultForSuccess(new HashMap<String, Integer>(3) {
                        {
                            put("Candidate Num", candidateRows);
                            put("Interviewer Num", interviewerRows);
                            put("Recruiting Num", recruitingRows);
                        }
                    });
                } else {
                    result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                    result.setResultMessage("解析失败，请稍后重试");
                }
                candidateFile.transferTo(new File(CANDIDATE_FILE_PATH));
                interviewerFile.transferTo(new File(INTERVIEWER_FILE_PATH));
                recruitingFile.transferTo(new File(RECRUITING_FILE_PATH));
            } else {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("文件上传错误，请稍后重试");
            }

        } catch (IOException e) {
            logger.error("Exception : /recruiting/upload ", e);
        }
        return result;
    }


    private List<Candidate> candidateExcelProcess(InputStream stream) {
        try {
            CandidateExcelListener listener = new CandidateExcelListener();
            ExcelReader reader = new ExcelReader(stream, ExcelTypeEnum.XLSX, null, listener);
            reader.read(new Sheet(1, 1, Candidate.class));
            return listener.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<CandidateSelectedTime> candidateTimeExcelProcess(InputStream stream) {
        try {
            CandidateTimeExcelListener listener = new CandidateTimeExcelListener();
            ExcelReader reader = new ExcelReader(stream, ExcelTypeEnum.XLSX, null, listener);
//            reader.read(new Sheet(1, 1, CandidateSelectedTime.class));
            return listener.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Interviewer> interviewerExcelProcess(InputStream stream) {
        try {
            InterviewerExcelListener listener = new InterviewerExcelListener();
            ExcelReader reader = new ExcelReader(stream, ExcelTypeEnum.XLSX, null, listener);
            reader.read(new Sheet(1, 1, Interviewer.class));
            return listener.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Recruiting> recruitingExcelProcess(InputStream stream) {
        try {
            RecruitingExcelListener listener = new RecruitingExcelListener();
            ExcelReader reader = new ExcelReader(stream, ExcelTypeEnum.XLSX, null, listener);
            reader.read(new Sheet(1, 1, Recruiting.class));
            return listener.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping("/uploadtest")
    public String uploadTest(@RequestParam("candidate") MultipartFile candidateFile,
                             @RequestParam("interviewer") MultipartFile interviewerFile,
                             @RequestParam("recruiting") MultipartFile recruitingFile) throws IOException {
        String candidateFilePath = "E:/fileUploadTest/candidate.xlsx";
        String interviewerFilePath = "E:/fileUploadTest/interviewer.xlsx";
        String recruitingFilePath = "E:/fileUploadTest/recruiting.xlsx";
        candidateFile.transferTo(new File(candidateFilePath));
        interviewerFile.transferTo(new File(interviewerFilePath));
        recruitingFile.transferTo(new File(recruitingFilePath));
        return null;
    }
}
