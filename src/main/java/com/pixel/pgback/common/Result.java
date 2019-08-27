package com.pixel.pgback.common;

import java.io.Serializable;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.common
 * @Author: zhouzw
 * @CreateTime: 2019/5/10 15:34
 * @Description: 返回结果
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -6555520400381003085L;
    private int resultCode;
    private String resultMessage;
    private T data;

    public Result() {
    }

    public Result(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", resultMessage='" + resultMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
