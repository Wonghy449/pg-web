package com.pixel.pgback.controller.candidate;

import com.pixel.pgback.common.Result;
import com.pixel.pgback.service.ICandidateChooseTimeService;
import com.pixel.pgback.common.util.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.controller
 * @Author: zhouzw
 * @CreateTime: 2019/5/23 16:12
 * @Description: 候选人选择面试时段controller
 * /candidate/choosetime
 * in:{
 *     "username":"",
 *     "interviewType":"",
 *     "choseTime":[],时间格式：yyyy-MM-dd HH:mm:ss
 * }
 */
@RestController
@RequestMapping("/candidate")
public class CandidateChooseTimeController {
    private static Logger logger = Logger.getLogger(CandidateChooseTimeController.class);

    private final ICandidateChooseTimeService service;

    @Autowired
    public CandidateChooseTimeController(ICandidateChooseTimeService service) {
        this.service = service;
    }

    @PostMapping("/choosetime")
    public Result chooseTime(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("候选人选择面试时段信息 ：" + params.toString());
        try {
            int infectedRows = service.chooseTime(params);
            if (infectedRows != 0) {
                result = ResultUtil.getResultForSuccess();
            }
        } catch (Exception e) {
            logger.error("Exception: /candidate/choosetime : " , e);
        }
        return result;
    }
}
