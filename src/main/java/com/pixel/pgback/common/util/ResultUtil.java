package com.pixel.pgback.common.util;

import com.pixel.pgback.common.Constants;
import com.pixel.pgback.common.Result;
import org.apache.commons.lang3.StringUtils;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.util
 * @Author: zhouzw
 * @CreateTime: 2019/5/10 15:36
 * @Description: 返回结果工具类
 */
public class ResultUtil {

    /**
     * 生成成功返回对象，无数据
     *
     * @return
     */
    public static Result getResultForSuccess() {
        Result result = new Result();
        result.setResultCode(Constants.RESULT_CODE_SUCCESS);
        result.setResultMessage(Constants.RESULT_MESSAGE_SUCCESS);
        return result;
    }

    /**
     * 生成成功返回对象，有数据
     *
     * @param data 返回数据
     * @return
     */
    public static Result getResultForSuccess(Object data) {
        Result result = new Result();
        result.setResultCode(Constants.RESULT_CODE_SUCCESS);
        result.setResultMessage(Constants.RESULT_MESSAGE_SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 生成失败返回对象
     *
     * @param resultMessage 返回信息
     * @return
     */
    public static Result getResultForFail(String resultMessage) {
        Result result = new Result();
        result.setResultCode(Constants.RESULT_CODE_SERVER_ERROR);
        //不为空且不能由空白符组成
        if (StringUtils.isBlank(resultMessage)) {
            resultMessage = Constants.RESULT_MESSAGE_FAIL;
        }
        result.setResultMessage(resultMessage);
        return result;
    }
}
