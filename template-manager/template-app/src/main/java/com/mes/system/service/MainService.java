package com.mes.system.service;

import com.mes.system.bean.SessionUser;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[MainService]  
  * 类描述:		[后台登录及框架页面业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月15日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月15日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface MainService {

	/**
	 * 系统用户登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 用户会话信息数据传输对象
	 */
	SessionUser login(String name, String pwd);

}
