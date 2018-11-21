package com.springcloud.facade.response;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
/**
 * @author: laiweigeng
 * @Date: 2018/11/14 21:32
 */
public class ResponseBase implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回码 成功0000
     */
    private String returnCode;
    /**
     * 返回消息
     */
    private String returnMessage;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

}
