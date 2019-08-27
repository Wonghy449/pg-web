package com.pixel.pgback.controller;

import com.pixel.pgback.common.Result;
import com.pixel.pgback.service.IRegisterService;
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
 * @CreateTime: 2019/5/21 19:56
 * @Description: 注册controller
 * /register/candidate
 * in:{
 *     "username":"",
 *     "password":"",
 *     "email":"",
 *     "phone":"",
 * }
 *
 *
 * /register/employee
 * in:{
 *     "email":"",
 *     "password":"",
 * }
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    private static Logger logger = Logger.getLogger(RegisterController.class);

    private final IRegisterService registerService;

    @Autowired
    public RegisterController(IRegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/candidate")
    public Result candidateRegister(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("候选人注册信息：" + params.toString());
        try {
            boolean succeed = registerService.candidateRegister(params);
            if (succeed) {
                result = ResultUtil.getResultForSuccess();
            } else {
                result.setResultMessage("注册失败，请检查输入信息是否有误或是否已注册");
            }
        } catch (Exception e) {
            logger.error("Exception: /register/candidate : ", e);
        }
        return result;
    }

    @PostMapping("/employee")
    public Result employeeRegister(@RequestBody Map params) {
        Result result = ResultUtil.getResultForFail(null);
        logger.info("员工注册信息：" + params.toString());
        try {
            boolean succeed = registerService.employeeRegister(params);
            if (succeed) {
                result = ResultUtil.getResultForSuccess();
            } else {
                result.setResultMessage("注册失败，请检查输入信息是否有误或是否已注册");
            }
        } catch (Exception e) {
            logger.error("Exception: /register/employee : ", e);
        }
        return result;
    }
}
