package com.mes.common.exception.enums;

import com.mes.core.exception.ExceptionEnums;

public enum ServiceExceptionEnums implements ExceptionEnums {

	/**
	 * 1-100      系统级别异常
	 * 501-750 业务级别异常
	 * 501-550 后台系统异常代码
	 * 551-600 会员系统异常代码
	 * 601-750 支付系统异常代码
	 */
	 MAIN_USERNAME_NOT_EXIST(501, "用户名不存在."),
	 MAIN_USERNAME_IS_DISABLED(502,"用户名已禁用."),
	 MAIN_WRONG_PASSWORD(503,"密码错误."),
	 ORG_EXIST_SUBNODES(501, "部门下面存在子节点."),
	 ORG_EXIST_POST(502,"部门下面存在岗位."),
	 ORG_EXIST_USER(503,"部门下面存在用户."),
	 ORG_USER_EXIST_USER(504,"组织用户已经被当前岗位成员引用."),
	 ERROR_KEY(500, "服务异常.");

	/** 错误码 */
	public int code;

	/** 错误消息*/
	public String message;

	private ServiceExceptionEnums(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
