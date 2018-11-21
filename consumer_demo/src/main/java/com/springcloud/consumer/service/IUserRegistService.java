package com.springcloud.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.facade.UserRegistFacade;
import com.springcloud.facade.request.data.UserRegistParamData;
import com.springcloud.facade.request.param.AccountCenterParam;
import com.springcloud.facade.response.AccountCenterResponse;
import com.springcloud.facade.response.result.UserRegistResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: laiweigeng
 * @Date: 2018/11/14 23:02
 */
@FeignClient(value = "ACCOUNT-SERVICE", fallback = UserRegistServiceHystrixImpl.class)
public interface IUserRegistService {
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    AccountCenterResponse<UserRegistResult> regist(AccountCenterParam<UserRegistParamData> registInfo);
}
