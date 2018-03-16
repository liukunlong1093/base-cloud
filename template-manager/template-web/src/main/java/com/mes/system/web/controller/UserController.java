package com.mes.system.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.UserDTO;
import com.mes.system.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.web.controller]    
  * 类名称:		[UserController]  
  * 类描述:		[用户控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月15日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月15日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", description = "用户管理")
public class UserController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	UserService userService;

	/**
	 * 根据用户标识获取用户
	 * @param id 用户标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据用户标识获取用户", httpMethod = "GET", notes = "根据用户标识获取用户详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "用户标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getUserById")
	public ServiceResponse<UserDTO> getUserById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return userService.getUserById(id);
	}

	/**
	 * 根据条件获取用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取用户列表", httpMethod = "GET", notes = "根据条件获取用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "用户标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "name", value = "用户名(登录帐号)", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pwd", value = "密码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "fullname", value = "真实名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sex", value = "性别(0男1女)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "status", value = "状态(0启用,1停用)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "birthday", value = "生日", required = false, dataType = "Date", paramType = "query"), @ApiImplicitParam(name = "comment", value = "说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getUserList")
	public ServiceResponse<List<UserDTO>> getUserList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return userService.getUserList(condition);
	}

	/**
	 * 保存用户
	 * @param userDTO 用户数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存用户", httpMethod = "POST", notes = "保存用户信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "用户数据传输对象", required = true, dataType = "UserDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveUser")
	public ServiceResponse<?> saveUser(@RequestBody UserDTO userDTO) {
		return userService.saveUser(userDTO);
	}

	/**
	 * 更新用户
	 * @param userDTO 用户数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新用户", httpMethod = "POST", notes = "更新用户信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "用户数据传输对象", required = true, dataType = "UserDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateUser")
	public ServiceResponse<?> updateUser(@RequestBody UserDTO userDTO) {
		return userService.updateUser(userDTO);
	}

	/**
	 * 根据用户标识删除用户
	 * @param id 用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据用户标识删除用户", httpMethod = "GET", notes = "根据用户标识删除用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "用户标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteUserById")
	public ServiceResponse<?> deleteUserById(@RequestParam(value = "id") String id) {
		return userService.deleteUserById(id);
	}

	/**
	 * 批量保存用户
	 * @param userDAOList 用户数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存用户", httpMethod = "POST", notes = "批量保存用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "用户数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveUser")
	public ServiceResponse<?> batchSaveUser(@RequestBody List<UserDTO> userList) {
		return userService.batchSaveUser(userList);
	}
}
