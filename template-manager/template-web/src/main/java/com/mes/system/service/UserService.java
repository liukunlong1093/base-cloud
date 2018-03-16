package com.mes.system.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.UserDTO;
import com.mes.system.service.fallback.UserServiceFallback;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[UserService]  
  * 类描述:		[用户业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月15日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月15日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = UserServiceFallback.class)
public interface UserService {

	/**
	 * 根据用户标识获取用户
	 * @param id 用户标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/user/getUserById")
	ServiceResponse<UserDTO> getUserById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/user/getUserList")
	ServiceResponse<List<UserDTO>> getUserList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存用户
	 * @param userDTO 用户对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/user/saveUser")
	ServiceResponse<?> saveUser(@RequestBody UserDTO userDTO);

	/**
	 * 更新用户
	 * @param userDTO 用户对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/user/updateUser")
	ServiceResponse<?> updateUser(@RequestBody UserDTO userDTO);

	/**
	 * 根据用户标识删除用户
	 * @param id 用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/user/deleteUserById")
	ServiceResponse<?> deleteUserById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存用户
	 * @param userList 用户对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/user/batchSaveUser")
	ServiceResponse<?> batchSaveUser(@RequestBody List<UserDTO> userList);
}
