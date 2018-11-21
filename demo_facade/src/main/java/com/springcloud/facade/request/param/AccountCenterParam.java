package com.springcloud.facade.request.param;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.facade.request.data.BaseAccountCenterParamData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author: laiweigeng
 * @Date: 2018/11/14 21:32
 */

@ApiModel(value="账户中心请求实体")
public class AccountCenterParam<T extends BaseAccountCenterParamData> extends BaseParam implements Serializable {

	private static final long serialVersionUID = 2577861726278804291L;

	public AccountCenterParam() {
		super();
	}
	@Getter
	@Setter
	@Valid
	@ApiModelProperty(value="data实体，根据接口类型区分" ,required=true)
	private T data;

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
