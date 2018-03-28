package com.mes.core.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
/**
 * 
  * 项目名称:	[common-core]
  * 包:	        [com.mes.core.config]    
  * 类名称:		[RedisObjectSerializer]  
  * 类描述:		[Redis对象序列化]
  * 创建人:		[liukl]   
  * 创建时间:	[2017年8月10日 上午11:48:23]   
  * 修改人:		[liukl]   
  * 修改时间:	[2017年8月10日 上午11:48:23]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {
	private Converter<Object, byte[]> serializer = new SerializingConverter();
	private Converter<byte[], Object> deserializer = new DeserializingConverter();
	static final byte[] EMPTY_ARRAY = new byte[0];

	public Object deserialize(byte[] bytes) {
		if (isEmpty(bytes)) {
			return null;
		}
		try {
			return deserializer.convert(bytes);
		} catch (Exception ex) {
			throw new SerializationException("Cannot deserialize", ex);
		}
	}

	public byte[] serialize(Object object) {
		if (object == null) {
			return EMPTY_ARRAY;
		}
		try {
			return serializer.convert(object);
		} catch (Exception ex) {
			return EMPTY_ARRAY;
		}
	}

	private boolean isEmpty(byte[] data) {
		return (data == null || data.length == 0);
	}
}
