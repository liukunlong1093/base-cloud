package com.mes.core.cache;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * 
  * 项目名称:	[mes-core]
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
public interface RediseCacheManager {
	/**
	 * 获取Redise模板对象
	 * @return Redise模板对象
	 */
	RedisTemplate<String, Object> getRedisTemplate();
	
	/**
	 * 设置字符串
	 * @param key 字符串键
	 * @param value	字符串值
	 * @return <code>true</code>成功 <code>false</code>失败
	 */
	boolean set(String key, String value);

	/**
	 * 设置字符串
	 * @param key 字符串键
	 * @param value	字符串值
	 * @param expiry 失效时间单位毫秒 当<code>expiry</code>大于等于1000毫秒启用失效时间否者永不过期
	 * @return <code>true</code>成功 <code>false</code>失败
	 */
	boolean set(String key, String value, long expiry);

	/**
	 * 获取字符串
	 * @param key 字符串键
	 * @return 返回缓存字符串信息
	 */
	String get(String key);

	/**
	 * 设置对象
	 * @param key 字符串键
	 * @param object 对象
	 * @return <code>true</code>成功 <code>false</code>失败
	 */
	boolean setObject(String key, Object object);

	/**
	 * 设置字符串
	 * @param key 字符串键
	 * @param object 对象
	 * @param expiry 失效时间单位毫秒 当<code>expiry</code>大于等于1000毫秒启用失效时间否者永不过期
	 * @return <code>true</code>成功 <code>false</code>失败
	 */
	boolean setObject(String key, Object object, long expiry);

	/**
	 * 获取对象
	 * @param key 字符串键
	 * @return 返回缓存对象信息
	 */
	Object getObject(String key);
}
