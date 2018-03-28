package com.mes.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 项目名称:	[common-core]
 * 包:	        [com.mes.core.config]
 * 类名称:		[RedisConfig]
 * 类描述:		[Redis相关配置]
 * 创建人:		[liukl]
 * 创建时间:	[2017年8月10日 上午11:48:53]
 * 修改人:		[liukl]
 * 修改时间:	[2017年8月10日 上午11:48:53]
 * 修改备注:	[说明本次修改内容]
 * 版本:		[v1.0]
 */
@Configuration
public class RedisConfig {
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();

        jedisConnectionFactory.setPassword(password);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate <String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate <String, Object> template = new RedisTemplate <String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
