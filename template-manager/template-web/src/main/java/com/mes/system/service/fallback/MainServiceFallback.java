package com.mes.system.service.fallback;

import org.springframework.stereotype.Component;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.bean.SessionUser;
import com.mes.system.service.MainService;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[UserServiceFallback]  
  * 类描述:		[后台登录及框架页面业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月15日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月15日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class MainServiceFallback implements MainService {
	
	/**
	 * 系统用户登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 用户会话信息对象
	 */
	@Override
	public ServiceResponse<SessionUser> login(String name,String pwd){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "系统用户登录服务不可用.");
	}
	
}
