package com.springcloud.facade.request.data;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: laiweigeng
 * @Date: 2018/11/14 21:32
 */
@Data
@ApiModel(value="用户注册请求实体")
public class UserRegistParamData extends BaseAccountCenterParamData {
    @NotNull(message = "姓名不能为空")
    @ApiModelProperty(value="姓名" ,required=true)
    private String name;
    @NotNull(message = "身份证号不能为空")
    @ApiModelProperty(value="身份证号" ,required=true)
    private String idCard;
    @NotNull(message = "手机号不能为空")
    @ApiModelProperty(value="手机号" ,required=true)
    private String mobile;
    @NotNull(message = "银行卡不能为空")
    @ApiModelProperty(value="银行卡" ,required=true)
    private String bankCard;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
