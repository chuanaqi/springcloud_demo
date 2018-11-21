package com.springcloud.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.facade.request.data.UserRegistParamData;
import com.springcloud.facade.request.param.AccountCenterParam;
import com.springcloud.facade.response.AccountCenterResponse;
import com.springcloud.facade.response.result.UserRegistResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author: laiweigeng
 * @Date: 2018/11/14 23:04
 */
@Service
public class UserRegistServiceHystrixImpl implements IUserRegistService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 用户注册
     * @param registInfo
     * @return
     */

    public AccountCenterResponse<UserRegistResult> regist(AccountCenterParam<UserRegistParamData> registInfo) {
        logger.error("用户注册超时进入熔断逻辑");
        AccountCenterResponse<UserRegistResult> accountCenterResponse = new AccountCenterResponse<UserRegistResult>();
        accountCenterResponse.setReturnCode("0001");
        accountCenterResponse.setReturnMessage("超时熔断");
        logger.error("用户注册接口返回报文：{}",accountCenterResponse);
        return accountCenterResponse;
    }
}
