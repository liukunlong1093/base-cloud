package com.mes.system.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.UserDTO;
import com.mes.system.service.UserService;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[UserServiceFallback]  
  * 类描述:		[用户业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月15日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月15日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class UserServiceFallback implements UserService {
	/**
		 * 根据用户标识获取用户
		 * @param id 用户标识
		 * @return 服务响应对象
		 */
	@Override
	public ServiceResponse<UserDTO> getUserById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据用户标识获取用户服务不可用.");
	}

	/**
	 * 根据条件获取用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<UserDTO>> getUserList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取用户列表服务不可用.");
	}

	/**
	 * 保存用户
	 * @param userDTO 用户对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveUser(UserDTO userDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存用户服务不可用.");
	}

	/**
	 * 更新用户
	 * @param userDTO 用户对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateUser(UserDTO userDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新用户服务不可用.");
	}

	/**
	 * 根据用户标识删除用户
	 * @param id 用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteUserById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据用户标识删除用户服务不可用.");
	}

	/**
	 * 批量保存用户
	 * @param userList 用户对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveUser(List<UserDTO> userList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存用户服务不可用.");
	}
}
