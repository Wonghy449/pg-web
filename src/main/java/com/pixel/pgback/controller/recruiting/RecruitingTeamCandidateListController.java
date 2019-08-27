package com.pixel.pgback.controller.recruiting;

import com.pixel.pgback.common.Constants;
import com.pixel.pgback.common.Result;
import com.pixel.pgback.entity.Candidate;
import com.pixel.pgback.service.IRecruitingTeamCandidateListService;
import com.pixel.pgback.common.util.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.controller.recruiting
 * @Author: zhouzw
 * @CreateTime: 2019/6/2 16:14
 * @Description: 招聘团队候选人名单controller,入参计划改为username原为interviewArea，未完成
 * /recruiting/allcandidate
 * in{
 * "username":"",
 * }
 * out{}
 * <p>
 * /recruiting/choosecandidate
 * in{
 * "username":"",
 * "ids":[]
 * }
 * out{}
 * <p>
 * /recruiting/selectedcandidate
 * in{
 * "username":"",
 * }
 * out{}
 */
@RestController
@RequestMapping("/recruiting")
public class RecruitingTeamCandidateListController {
    private static Logger logger = Logger.getLogger(RecruitingTeamCandidateListController.class);

    private final IRecruitingTeamCandidateListService service;


    @Autowired
    public RecruitingTeamCandidateListController(IRecruitingTeamCandidateListService service) {
        this.service = service;
    }

    @PostMapping("/allcandidate")
    public Result allCandidate(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("招聘团队所有候选人信息：" + params.toString());
        try {
            List<Candidate> candidateList = service.allCandidate(params);
            if (null != candidateList) {
                result = ResultUtil.getResultForSuccess(candidateList);
            } else {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("未查询到记录，请检查入参是否有误");
            }
        } catch (Exception e) {
            logger.error("Exception : /recruiting/allcandidate : ", e);
        }
        return result;
    }

    @PostMapping("/choosecandidate")
    public Result chooseCandidate(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("招聘团队选择候选人信息：" + params.toString());
        try {
            int affectedRows = service.choseCandidate(params);
            if (affectedRows != 0) {
                result = ResultUtil.getResultForSuccess(new HashMap<String, Integer>(1) {
                    {
                        put("affectedRows", affectedRows);
                    }
                });
            } else {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("请检查入参");
            }
        } catch (Exception e) {
            logger.error("Exception : /recruiting/choosecandidate : ", e);
        }
        return result;
    }

    @PostMapping("/selectedcandidate")
    public Result selectedCandidate(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("招聘团队已选候选人信息：" + params.toString());
        try {
            List<Candidate> candidateList = service.selectedCandidate(params);
            if (null != candidateList) {
                result = ResultUtil.getResultForSuccess(candidateList);
            } else {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("未查询到记录，请检查入参是否有误");
            }
        } catch (Exception e) {
            logger.error("Exception : /recruiting/selectedcandidate : ", e);
        }
        return result;
    }
}
