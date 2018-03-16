package com.mes.system.service;

import java.util.List;

import com.mes.system.bean.SessionUser;

public interface SessionUserService {
	/**
	 * 根据条件获取用户会话信息
	 * @param userId 用户标识
	 * @return 用户会话信息对象
	 */
	public SessionUser getSessionUser(long userId);
	
	/**
	 * 获取用户的所有身份字符串集合
	 * @param su 用户会话信息数据传输对象
	 * @return 用户的所有身份字符串集合
	 */
	public List<String> getUserAllSFStr(SessionUser su);
}
