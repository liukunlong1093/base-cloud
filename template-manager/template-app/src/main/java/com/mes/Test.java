package com.mes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mes.core.cache.impl.RediseCacheManagerImpl;
import com.mes.core.utils.RequestCheckUtils;

public class Test {
	private static final Logger logger = LoggerFactory.getLogger(RediseCacheManagerImpl.class);
	public static void main(String[] args) {
		xxx();
	}
	
	public static void xxx(){
		String a = "sdfdsf";
		assert a != null;
		try {
			RequestCheckUtils.checkRangeValue(23L, 11L, 22L, "年龄");
		} catch (Exception e) {
		   logger.error("xxx() params key:xxx,value:yyy_"+e.getMessage(),e);
		}
	}
}
