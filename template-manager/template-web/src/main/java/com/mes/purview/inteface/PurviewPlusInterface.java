package com.mes.purview.inteface;

import java.util.HashMap;

/**
 * 
  * 
  * 项目名称:  [base-web]
  * 包:        [com.mes.sys.purview.inteface]    
  * 类名称:    [PurviewPlusInterface]  
  * 类描述:    [外接类权限接口]
  * 创建时间:  [2013-11-19 下午3:56:30]   
  * 修改时间:  [2013-11-19 下午3:56:30]   
  * 修改备注:  [说明本次修改内容]  
  * 版本:      [v1.0]   
  *
 */
public interface PurviewPlusInterface {

	/** 设置传递的上下文信息. */
	public void setContext(HashMap<Object, Object> context);

	/**
	 * 返回SQL语句.
	 */
	public String getSQL();

}
