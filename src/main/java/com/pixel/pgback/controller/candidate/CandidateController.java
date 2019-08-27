package com.pixel.pgback.controller.candidate;

import com.pixel.pgback.common.Constants;
import com.pixel.pgback.common.Result;
import com.pixel.pgback.entity.Candidate;
import com.pixel.pgback.service.ICandidateService;
import com.pixel.pgback.common.util.ResultUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.controller
 * @Author: zhouzw
 * @CreateTime: 2019/5/9 22:29
 * @Description: Candidate Controller
 * /candidate/querystatus
 * in{
 * "username":""
 * }
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private static Logger logger = Logger.getLogger(CandidateController.class);
    @Autowired
    private ICandidateService candidateService;

    @PostMapping("/querystatus")
    public Result queryStatus(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("候选人查询状态信息：" + params.toString());
        String username = MapUtils.getString(params, "username");
        try {
            String status = candidateService.queryStatus(username);
            if (StringUtils.isNotBlank(status)) {
                result = ResultUtil.getResultForSuccess(new HashMap<String, String>(1) {
                    {
                        put("status", status);
                    }
                });
            } else {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("未查询到相关信息");
            }
        } catch (Exception e) {
            logger.error("Exception : /candidate/querystatus " , e);
        }
        return result;
    }

    @PostMapping("select")
    public Result selectById(@RequestBody Map params) {
        Integer id = MapUtils.getInteger(params, "id");
        logger.info("Candidate selectById param: id=" + id + params.toString());
        Result result = ResultUtil.getResultForFail(null);
        try {
            Candidate candidate = candidateService.selectById(id);
            if (null == candidate) {
                result.setResultMessage("不存在相关记录");
                logger.info("Candidate selectById candidate=null");
            } else {
                logger.info("Candidate selectById candidate=" + candidate.toString());
                result = ResultUtil.getResultForSuccess(candidate);
            }
        } catch (Exception e) {
            result.setResultMessage("诶呀出异常了");
            logger.error("Exception", e);
        }
        return result;
    }

}