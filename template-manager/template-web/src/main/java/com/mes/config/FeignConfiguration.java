package com.mes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mes.core.exception.FeignErrorDecoder;

import feign.codec.ErrorDecoder;
/**
 * Feign相关配置
 * @author Administrator
 *
 */
@Configuration
public class FeignConfiguration {
	@Bean
	public ErrorDecoder errorDecoder(){
		return new FeignErrorDecoder();
	}
}
