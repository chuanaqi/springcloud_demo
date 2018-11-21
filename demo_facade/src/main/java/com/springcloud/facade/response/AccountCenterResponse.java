package com.springcloud.facade.response;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: laiweigeng
 * @Date: 2018/11/14 21:32
 */
@Data
public class AccountCenterResponse<T> extends ResponseBase implements Serializable {


    private static final long serialVersionUID = 2210919032128043313L;

    public AccountCenterResponse() {
        super();
    }

    /**
     *
     * @param data
     * @param retCode
     * @param retMessage
     */
    public AccountCenterResponse(T data,String retCode,String retMessage) {
        super();
        this.setReturnCode(retCode);
        this.setReturnMessage(retMessage);
        this.data = data;
    }

    /**
     * 认证数据
     */
    private T data = null;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
