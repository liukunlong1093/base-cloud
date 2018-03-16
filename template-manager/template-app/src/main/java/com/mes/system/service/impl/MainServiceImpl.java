package com.mes.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.common.exception.enums.ServiceExceptionEnums;
import com.mes.core.exception.ServiceException;
import com.mes.core.utils.MD5Utils;
import com.mes.core.utils.RequestCheckUtils;
import com.mes.system.bean.SessionUser;
import com.mes.system.dto.UserDTO;
import com.mes.system.manager.UserManager;
import com.mes.system.service.MainService;
import com.mes.system.service.SessionUserService;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.service.impl]    
 * 类名称:		[UserServiceImpl]  
 * 类描述:		[后台登录及框架页面业务处理类]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月15日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月15日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
@Service("mainService")
public class MainServiceImpl implements MainService {
	@Autowired
	private UserManager userManager;
	@Autowired
	private SessionUserService sessionUserService;

	/**
	 * 系统用户登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 用户对象
	 */
	@Override
	public SessionUser login(String name, String pwd) {
		pwd = MD5Utils.sign(pwd);
		RequestCheckUtils.checkNotEmpty(name, "用户名");
		RequestCheckUtils.checkNotEmpty(pwd, "密码");

		Map<String, Object> userCondition = new HashMap<String, Object>(16);
		userCondition.put("name", name);
		List<UserDTO> userList = userManager.getUserList(userCondition);
		if (userList == null || userList.size() == 0) {
			throw new ServiceException(ServiceExceptionEnums.MAIN_USERNAME_NOT_EXIST);
		}
		UserDTO userDTO = userList.get(0);
		if (userDTO.getStatus() == 1L) {
			throw new ServiceException(ServiceExceptionEnums.MAIN_USERNAME_IS_DISABLED);
		}
		if (!pwd.equals(userDTO.getPwd())) {
			throw new ServiceException(ServiceExceptionEnums.MAIN_WRONG_PASSWORD);
		}
		return sessionUserService.getSessionUser(userDTO.getId());
	}

}