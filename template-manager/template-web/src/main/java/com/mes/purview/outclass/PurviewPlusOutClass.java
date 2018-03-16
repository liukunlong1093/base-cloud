package com.mes.purview.outclass;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.mes.purview.inteface.PurviewPlusInterface;
import com.mes.system.bean.SessionUser;

/**
 * 
  * 
  * 项目名称:  [base-web]
  * 类名称:    [PurviewPlusOutClass]  
  * 类描述:    [权限外接类的抽象定义实现]
  * 修改备注:  [说明本次修改内容]  
  * 版本:      [v1.0]   
  *
 */
public abstract class PurviewPlusOutClass implements PurviewPlusInterface {
	/** 定义上下文信息. */
	protected HashMap<Object, Object> context = new HashMap<Object, Object>();

	/** 定义当前请求值. */
	protected HttpServletRequest req;

	/** 当前用户信息*/
	protected SessionUser su;

	/**
	 * 默认返回为空的sql语句
	 */
	@Override
	public String getSQL() {
		return "";
	}

	/**
	 * 设置上下文信息
	 */
	@Override
	public void setContext(HashMap<Object, Object> context) {
		su = (SessionUser) context.get("su");
		this.context = context;
	}

}
