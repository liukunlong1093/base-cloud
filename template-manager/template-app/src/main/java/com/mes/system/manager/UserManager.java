package com.mes.system.manager;

import java.util.*;
import com.mes.system.dto.UserDTO;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.manager]    
 * 类名称:		[UserManager]  
 * 类描述:		[用户管理处理接口]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月15日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月15日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
public interface UserManager {
	/**
	 * 根据用户标识获取用户
	 * @param id 用户标识
	 * @return 用户对象
	 */
	UserDTO getUserById(Long id);

	/**
	 * 根据条件获取用户列表
	 * @param condition 查询条件
	 * @return 用户列表
	 */
	List<UserDTO> getUserList(Map<String, Object> condition);

	/**
	 * 保存用户
	 * @param userDTO 用户对象
	 * @return 新增成功条数
	 */
	long saveUser(UserDTO userDTO);

	/**
	 * 更新用户
	 * @param userDTO 用户对象
	 * @return 更新成功条数
	 */
	long updateUser(UserDTO userDTO);

	/**
	 * 根据用户标识删除用户
	 * @param id 用户标识
	 * @return 删除成功条数
	 */
	long deleteUserById(Long id);

	/**
	 * 批量保存用户
	 * @param  userList 用户数据集合
	 * @return 新增成功条数
	 */
	long batchSaveUser(List<UserDTO> userList);
}
