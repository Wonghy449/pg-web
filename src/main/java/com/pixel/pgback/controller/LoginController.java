package com.pixel.pgback.controller;

import com.pixel.pgback.common.Constants;
import com.pixel.pgback.common.Result;
import com.pixel.pgback.common.util.ResultUtil;
import com.pixel.pgback.entity.Login;
import com.pixel.pgback.service.ILoginService;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
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
 * @CreateTime: 2019/5/21 22:06
 * @Description: 登录controller
 * <p>
 * /login/all
 * in:{
 * "identity":"",
 * "username":"",
 * "password":""
 * }
 * out:{
 * "resultCode":"",
 * "resultMessage":"",
 * "data":{
 * "identity":""登录身份
 * }
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 目前未使用
 * /login/candidate
 * in:{
 * "username":"",
 * "password":""
 * }
 * <p>
 * <p>
 * <p>
 * /login/employee
 * in:{
 * "username":"",
 * "password":""
 * }
 * out:{
 * "resultCode":"",
 * "resultMessage":"",
 * "data":{
 * "identity":""登录身份
 * }
 * }
 * <p>
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class);

    private final ILoginService loginService;

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/all")
    public Result login(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("登录信息：" + params.toString());
//        String identity = MapUtils.getString(params, "identity");
        try {
//            Map loginInfo = loginService.employeeLogin(params);
//            if (Constants.LOGIN_IDENTITY_CANDIDATE.equals(identity) && loginService.candidateLogin(params)) {
//                result = ResultUtil.getResultForSuccess();
//                result.setData(new HashMap<String, String>(1) {
//                    {
//                        put("identity", Constants.IDENTITY_CANDIDATE);
//                    }
//                });
//            } else if (Constants.LOGIN_IDENTITY_RECRUITING.equals(identity) && null != loginInfo) {
//                result = ResultUtil.getResultForSuccess();
//                result.setData(new HashMap<String, String>(1) {
//                    {
//                        put("identity", "Interviewer".equals(MapUtils.getString(loginInfo, "identity")) ?
//                                Constants.IDENTITY_INTERVIEWER : Constants.IDENTITY_RECRUITING);
//                    }
//                });
//            } else {
//                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
//                result.setResultMessage("登录失败，请检查输入信息");
//            }
            Login login = loginService.login(params);
            if (null == login) {
                result.setResultCode(Constants.RESULT_CODE_BAD_REQUEST);
                result.setResultMessage("登录失败，请检查输入信息");
            } else {
                result.setResultCode(Constants.RESULT_CODE_SUCCESS);
                result.setResultMessage(Constants.RESULT_MESSAGE_SUCCESS);
                result.setData(login);
            }
        } catch (Exception e) {
            logger.error("Exception : /login/all", e);
        }
        return result;
    }

    @PostMapping("/candidate")
    public Result candidateLogin(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("候选人登录信息：" + params.toString());
        try {
            boolean succeed = loginService.candidateLogin(params);
            if (succeed) {
                result = ResultUtil.getResultForSuccess();
            } else {
                result.setResultMessage("登录失败，请检查输入是否有误");
            }
        } catch (Exception e) {
            logger.error("Exception: /login/candidate : ", e);
        }
        return result;
    }

    @PostMapping("/employee")
    public Result employeeLogin(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("员工登录信息：" + params.toString());
        try {
            Map succeed = loginService.employeeLogin(params);
            if (StringUtils.isNotEmpty(MapUtils.getString(succeed, "id"))) {
                result = ResultUtil.getResultForSuccess();
                result.setData(succeed);
            } else {
                result.setResultMessage("登录失败，请检查输入是否有误");
            }
        } catch (Exception e) {
            logger.error("Exception: /login/employee : ", e);
        }
        return result;
    }
}
