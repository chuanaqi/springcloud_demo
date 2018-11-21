package com.springcloud.facade.request.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value="基础请求实体")
public abstract class BaseParam implements Serializable {


    private static final long serialVersionUID = -1449773394786630903L;

    public BaseParam() {
        super();
    }

    /**
     * 来源系统
     */
    @NotNull(message = "系统来源不能为空")
    @ApiModelProperty(value="系统来源" ,required=true)
    private String fromSys;
    /**
     * 交易流水号
     */
    @NotNull(message = "请求流水不能为空")
    @ApiModelProperty(value="请求流水" ,required=true)
    private String transId;
    /**
     * 交易时间
     */
    private String transTime;


}
