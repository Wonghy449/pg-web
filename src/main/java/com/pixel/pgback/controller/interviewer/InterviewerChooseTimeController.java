package com.pixel.pgback.controller.interviewer;

import com.pixel.pgback.common.Result;
import com.pixel.pgback.common.util.ResultUtil;
import com.pixel.pgback.entity.RecruitingChoseTime;
import com.pixel.pgback.mapper.RecruitingChoseTimeMapper;
import com.pixel.pgback.service.IInterviewerChooseTimeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.controller.interviewer
 * @Author: zhouzw
 * @CreateTime: 2019/6/20 17:05
 * @Description: 面试官选择时间Controller
 * interviewer/choosetime
 * in:{
 * "username":"",
 * "choseTime":[] 时间格式：yyyy-MM-dd 0401/0402
 * }
 */
@RestController
@RequestMapping("/interviewer")
public class InterviewerChooseTimeController {
    private static Logger logger = Logger.getLogger(InterviewerChooseTimeController.class);

    private final IInterviewerChooseTimeService service;
    private final RecruitingChoseTimeMapper recruitingChoseTimeMapper;


    @Autowired
    public InterviewerChooseTimeController(IInterviewerChooseTimeService service, RecruitingChoseTimeMapper recruitingChoseTimeMapper) {
        this.service = service;
        this.recruitingChoseTimeMapper = recruitingChoseTimeMapper;
    }

    @RequestMapping("/choosetime")
    public Result chooseTime(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("面试官时间选择信息：" + params.toString());
        try {
            int affectedRows = service.chooseTime(params);
            if (affectedRows != 0) {
                result = ResultUtil.getResultForSuccess();
                result.setData(new HashMap<String, Integer>(1) {
                    {
                        put("recordNum", affectedRows);
                    }
                });
            }
        } catch (Exception e) {
            logger.error("Exception: interviewer/choosetime", e);
        }
        return result;
    }

    @RequestMapping("/recruitingchosetime")
    public Result recruitingChoseTime(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        try {
            List<RecruitingChoseTime> choseTimes = recruitingChoseTimeMapper.selectList(null);
            result = ResultUtil.getResultForSuccess(choseTimes);
        } catch (Exception e) {
            logger.error("Exception: interviewer/choosetime", e);
        }
        return result;
    }
}
