package com.mes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Administrator
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// 为当前包路径
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any()).build();
	}

	/**
	 * 构建 api文档的详细信息函数
	 * @return api详细信息
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title("BASE-WEB 接口文档")
				// 创建人
				//.contact(new Contact("liukl", "http://www.messsoft.com.cn", "liukl@messoft.com.cn"))
				// 版本号
				//.version("1.0")
				// 描述
				.description("BASE-WEB的服务提供者接口,主要供后端开发人员查看").build();
	}
}