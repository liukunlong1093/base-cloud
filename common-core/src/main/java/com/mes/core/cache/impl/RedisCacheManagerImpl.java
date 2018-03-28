package com.mes.core.cache.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.mes.core.cache.RedisCacheManager;

/**
 * 
  * 项目名称:	[common-core]
  * 包:	        [com.mes.core.cache]    
  * 类名称:		[RediseCacheManager]  
  * 类描述:		[一句话描述该类的功能]
  * 创建人:		[liukl]   
  * 创建时间:	[2017年8月10日 上午11:50:48]   
  * 修改人:		[liukl]   
  * 修改时间:	[2017年8月10日 上午11:50:48]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("redisCacheManager")
public class RedisCacheManagerImpl implements RedisCacheManager {
	private static final Logger logger = LoggerFactory.getLogger(RedisCacheManagerImpl.class);

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	/**
	 * 获取Redise模板对象
	 * @return Redise模板对象
	 */
	@Override
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	/**
	 * 设置字符串
	 * @param key 字符串键
	 * @param value	字符串值
	 * @return <code>true</code>成功 <code>false</code>失败
	 */
	@Override
	public boolean set(String key, String value) {
		boolean flag = false;
		try {
			redisTemplate.opsForValue().set(key, value);
			flag = true;
		} catch (Exception e) {
			logger.error("set(String key, String value) params key:" + key + ",value:" + value + "_" + e.getMessage(), e);
		}

		return flag;
	}

	/**
	 * 设置字符串
	 * @param key 字符串键
	 * @param value	字符串值
	 * @param expiry 失效时间单位毫秒 当<code>expiry</code>大于等于1000毫秒启用失效时间否者永不过期
	 * @return <code>true</code>成功 <code>false</code>失败
	 */
	@Override
	public boolean set(String key, String value, long expiry) {
		boolean flag = false;
		try {
			redisTemplate.opsForValue().set(key, value, expiry, TimeUnit.MILLISECONDS);
			flag = true;
		} catch (Exception e) {
			logger.error("set(String key, String value) params key:" + key + ",value:" + value + "_" + e.getMessage(), e);
		}
		return flag;
	}

	/**
	 * 获取字符串
	 * @param key 字符串键
	 * @return 返回缓存字符串信息
	 */
	@Override
	public String get(String key) {
		return (String) redisTemplate.opsForValue().get(key);
	}

	/**
	 * 设置对象
	 * @param key 字符串键
	 * @param object 对象
	 * @return <code>true</code>成功 <code>false</code>失败
	 */
	@Override
	public boolean setObject(String key, Object object) {
		boolean flag = false;
		try {
			redisTemplate.opsForValue().set(key, object);
			flag = true;
		} catch (Exception e) {
			logger.error("set(String key, String value) params key:" + key + ",value:" + object.toString() + "_" + e.getMessage(), e);
		}

		return flag;
	}

	/**
	 * 设置字符串
	 * @param key 字符串键
	 * @param object 对象
	 * @param expiry 失效时间单位毫秒 当<code>expiry</code>大于等于1000毫秒启用失效时间否者永不过期
	 * @return <code>true</code>成功 <code>false</code>失败
	 */
	@Override
	public boolean setObject(String key, Object object, long expiry) {
		boolean flag = false;
		try {
			redisTemplate.opsForValue().set(key, object, expiry, TimeUnit.MILLISECONDS);
			flag = true;
		} catch (Exception e) {
			logger.error("set(String key, String value) params key:" + key + ",value:" + object.toString() + "_" + e.getMessage(), e);
		}
		return flag;
	}

	/**
	 * 获取对象
	 * @param key 字符串键
	 * @return 返回缓存对象信息
	 */
	@Override
	public Object getObject(String key) {
		return redisTemplate.opsForValue().get(key);
	}
}
