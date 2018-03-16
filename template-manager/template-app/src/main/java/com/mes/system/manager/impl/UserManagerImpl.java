package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.UserManager;
import com.mes.system.dao.UserMapper;
import com.mes.system.dto.UserDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[UserManagerImpl]  
  * 类描述:		[用户管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月15日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月15日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("userManager")
public class UserManagerImpl implements UserManager {
	@Autowired
	private UserMapper userMapper;


	/**
	 * 根据用户标识获取用户
	 * @param id 用户标识
	 * @return 用户对象
	 */
	@Override
	public UserDTO getUserById(Long id){
		return userMapper.getUserById(id);
	}

	/**
	 * 根据条件获取用户列表
	 * @param condition 查询条件
	 * @return 用户列表
	 */
	@Override
	public List<UserDTO> getUserList(Map<String, Object> condition){
		return userMapper.getUserList(condition);
	}

	/**
	 * 保存用户
	 * @param userDTO 用户对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveUser(UserDTO userDTO){
		return userMapper.saveUser(userDTO);
	}

	/**
	 * 更新用户
	 * @param userDTO 用户对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateUser(UserDTO userDTO){
		return userMapper.updateUser(userDTO);
	}

	/**
	 * 根据用户标识删除用户
	 * @param id 用户标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteUserById(Long id){
		return userMapper.deleteUserById(id);
	}

	/**
	 * 批量保存用户
	 * @param  userList 用户数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveUser(List<UserDTO> userList){
		return userMapper.batchSaveUser(userList);
	}
}
