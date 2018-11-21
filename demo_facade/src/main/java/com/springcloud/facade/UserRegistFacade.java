package com.springcloud.facade;

import com.springcloud.facade.request.param.AccountCenterParam;
import com.springcloud.facade.request.data.UserRegistParamData;
import com.springcloud.facade.response.AccountCenterResponse;
import com.springcloud.facade.response.result.UserRegistResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: laiweigeng
 * @Date: 2018/11/14 14:45
 */
public interface UserRegistFacade {
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    AccountCenterResponse<UserRegistResult> regist(AccountCenterParam<UserRegistParamData> registInfo);
}
