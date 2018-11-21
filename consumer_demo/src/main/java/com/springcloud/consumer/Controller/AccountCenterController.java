package com.springcloud.consumer.Controller;

import com.springcloud.consumer.service.IUserRegistService;
import com.springcloud.facade.request.data.UserRegistParamData;
import com.springcloud.facade.request.param.AccountCenterParam;
import com.springcloud.facade.response.AccountCenterResponse;
import com.springcloud.facade.response.result.UserRegistResult;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Set;

/**
 * @author: laiweigeng
 * @Date: 2018/11/14 22:48
 */
@Controller
@RequestMapping("/accountcenter")
public class AccountCenterController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IUserRegistService userRegistService;
    @ResponseBody
    @RequestMapping(value = "/regist",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public AccountCenterResponse<UserRegistResult> regist( @RequestBody AccountCenterParam<UserRegistParamData> registInfo){
        logger.info("consumer_demo:入参{}",registInfo);
        Set<Map.Entry<String, Object>> set =  MDC.getMap().entrySet();
        for(Map.Entry<String, Object> entry : set){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        return userRegistService.regist(registInfo);
    }
}
