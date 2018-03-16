package com.mes.system.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.dto.UserDTO;
import com.mes.system.manager.UserManager;
import com.mes.system.service.UserService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.impl]    
  * 类名称:		[UserServiceImpl]  
  * 类描述:		[用户业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月15日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月15日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserManager userManager;
	
	/**
	 * 根据用户标识获取用户
	 * @param id 用户标识
	 * @return 用户对象
	 */
	@Override
	public UserDTO getUserById(Long id){
		UserDTO userDTO = userManager.getUserById(id);
		return userDTO;
	}
	

	/**
	 * 根据条件获取用户列表
	 * @param condition 查询条件
	 * @return 用户列表
	 */
	@Override
	public List<UserDTO> getUserList(Map<String, Object> condition){
		List<UserDTO> userList = userManager.getUserList(condition);
		return userList;
	}

	/**
	 * 保存用户
	 * @param userDTO 用户对象
	 * @return 新增后的用户对象
	 */
	@Override
	public UserDTO saveUser(UserDTO userDTO){
		userManager.saveUser(userDTO);
		return userDTO;
	}
	
	/**
	 * 更新用户
	 * @param userDTO 用户对象
	 * @return 更新后的用户对象
	 */
	@Override
	public UserDTO updateUser(UserDTO userDTO){
		userManager.updateUser(userDTO);
		return userDTO;
	}


	/**
	 * 根据用户标识删除用户
	 * @param id 用户标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteUserById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				userManager.deleteUserById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存用户
	 * @param  userList 用户数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveUser(List<UserDTO> userList){
		long result = 0;
		result = userManager.batchSaveUser(userList);
		return result;
	}

	

}