package com.mes;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.mes.filter.AccessFilter;
import com.mes.filter.DidiFilterProcessor;
import com.mes.filter.ErrorFilter;
import com.netflix.zuul.FilterProcessor;

@EnableZuulProxy
@SpringCloudApplication
public class InfoZuulApplication {

	public static void main(String[] args) {
		FilterProcessor.setProcessor(new DidiFilterProcessor());
		SpringApplication.run(InfoZuulApplication.class, args);
	}

//	@Bean
//	public AccessFilter accessFilter() {
//		return new AccessFilter();
//	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}
