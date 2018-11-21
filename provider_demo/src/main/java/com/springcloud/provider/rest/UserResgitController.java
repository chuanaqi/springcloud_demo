package com.springcloud.provider.rest;

import com.springcloud.facade.UserRegistFacade;
import com.springcloud.facade.request.param.AccountCenterParam;
import com.springcloud.facade.request.data.UserRegistParamData;
import com.springcloud.facade.response.AccountCenterResponse;
import com.springcloud.facade.response.result.UserRegistResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author: laiweigeng
 * @Date: 2018/11/14 21:32
 */
@RestController

@Api(value = "UserResgitController|一个用来测试swagger注解的控制器")
public class UserResgitController implements UserRegistFacade {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 用户注册接口
	 * @param registInfo
	 * @return
	 */
	@ApiOperation(value="用户注册", notes="test")
	public AccountCenterResponse<UserRegistResult> regist(@RequestBody AccountCenterParam<UserRegistParamData> registInfo) {
		logger.info("账户中心-个人注册接口入参：{}",registInfo);
		UserRegistResult userRegistResult = new UserRegistResult();
		userRegistResult.setAccountNumber("1111");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new AccountCenterResponse<UserRegistResult>(userRegistResult,"0000","SUCCESS");
	}
}
