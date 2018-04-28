package com.mes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
  * 项目名称:	[base-web]
  * 包:	        [com.mes]    
  * 类名称:		[BaseWebApplication]  
  * 类描述:		[一句话描述该类的功能]
  * 创建人:		[liukl]   
  * 创建时间:	[2017年7月21日 上午11:40:21]   
  * 修改人:		[liukl]   
  * 修改时间:	[2017年7月21日 上午11:40:21]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableCaching
public class InfoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoWebApplication.class, args);
	}

	/**
	 * LoadBalanced 注解表明restTemplate使用LoadBalancerClient执行请求
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		return template;
	}

}
