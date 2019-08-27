package com.pixel.pgback.controller.recruiting;

import com.pixel.pgback.common.Constants;
import com.pixel.pgback.common.Result;
import com.pixel.pgback.entity.Interviewer;
import com.pixel.pgback.service.IRecruitingTeamInterviewerListService;
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
 * @BelongsPackage: com.pixel.pgback.controller
 * @Author: zhouzw
 * @CreateTime: 2019/5/24 17:51
 * @Description: 招聘团队候选人名单controller
 * /recruiting/allinterviewer:
 * 没有查询条件时，将对应字段置为null，查询所有即为：{}
 * in{
 * "name":
 * "level":[],
 * "location":[]
 * }
 * out{
 * "resultCode":"",
 * "resultMessage":"",
 * "data":[
 * {
 * "name":"",
 * "phone":"",
 * "email":"",
 * "level":"",
 * "location":"",
 * "date":"",
 * "preferredCity":""
 * },
 * {
 * <p>
 * }
 * ]
 * }
 * <p>
 * /recruiting/chooseinterviewer
 * in:{
 * area:""招聘区域
 * ids:[]已选面试官id
 * times:[]已选时间
 * }
 * <p>
 * /recruiting/selectedinterviewer
 * in{
 * area:""
 * }
 */
@RestController
@RequestMapping("/recruiting")
public class RecruitingTeamInterviewerListController {
    private static Logger logger = Logger.getLogger(RecruitingTeamInterviewerListController.class);

    private final IRecruitingTeamInterviewerListService service;

    @Autowired
    public RecruitingTeamInterviewerListController(IRecruitingTeamInterviewerListService service) {
        this.service = service;
    }

    @PostMapping("/allinterviewer")
    public Result alInterviewer(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("招聘团队所有面试官名单信息：" + params.toString());
        try {
            List allInterviewer = service.allInterviewer(params);
            if (null == allInterviewer) {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("查询失败");
            } else {
                result = ResultUtil.getResultForSuccess(allInterviewer);
            }
        } catch (Exception e) {
            logger.error("Exception : /recruiting/allinterviewer : ", e);
        }
        return result;
    }

    @PostMapping("/chooseinterviewer")
    public Result chooseInterviewer(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("招聘团队选择面试官信息：" + params.toString());
        try {
            int affectedRows = service.chooseInterviewer(params);
            if (affectedRows != 0) {
                result = ResultUtil.getResultForSuccess(new HashMap<String, Integer>(1) {
                    {
                        put("affectedRows", affectedRows);
                    }
                });
            } else {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("请检查输入信息");
            }
        } catch (Exception e) {
            logger.error("Exception : /recruiting/chooseinterviewer : ", e);
        }
        return result;
    }

    @PostMapping("/selectedinterviewer")
    public Result selectedInterviewer(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("招聘团队已选面试官信息：" + params.toString());
        try {
            List<Interviewer> interviewers = service.selectedInterviewer(params);
            if (null != interviewers) {
                result = ResultUtil.getResultForSuccess(interviewers);
            } else {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("请检查输入信息");
            }
        } catch (Exception e) {
            logger.error("Exception : /recruiting/selectedinterviewer : ", e);
        }
        return result;
    }
}
