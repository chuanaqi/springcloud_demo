package com.springcloud.zuul.fallback;
import com.alibaba.fastjson.JSONObject;
import com.springcloud.facade.response.AccountCenterResponse;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author: laiweigeng
 * @Date: 2018/11/16 16:49
 */

@Component
public class AccountServiceFallbackProvider implements FallbackProvider {


    public String getRoute() {
        return "ACCOUNT-SERVICE";
    }

    public ClientHttpResponse fallbackResponse(String s, Throwable throwable) {
        System.out.println("异常信息："+throwable.getCause().getCause().getMessage());
        return new ClientHttpResponse() {
            private Throwable throwable;
            public ClientHttpResponse setThrowable(Throwable throwable){
                this.throwable = throwable;
                return this;
            }
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            public void close() {

            }

            public InputStream getBody() throws IOException {
                AccountCenterResponse<JSONObject> accountCenterResponse = new AccountCenterResponse<JSONObject>(new JSONObject(),"0001","熔断处理");
                if(throwable != null && "Connection timed out".equals(throwable.getCause().getCause().getMessage())){
                    accountCenterResponse.setReturnCode("9999");
                }
                return new ByteArrayInputStream(accountCenterResponse.toString().getBytes());
            }

            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        }.setThrowable(throwable);
    }

}
