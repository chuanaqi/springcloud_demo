package com.springcloud.registecenter;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: laiweigeng
 * @Date: 2018/11/14 21:32
 */
@EnableEurekaServer
@EnableTurbine
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
@EnableZuulProxy
public class RegistCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistCenterApplication.class, args);
	}

	@Bean
	public RegistServlet getRegistServlet(){
		return new RegistServlet();
	}

	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.addUrlMappings("/turbine.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}



}
