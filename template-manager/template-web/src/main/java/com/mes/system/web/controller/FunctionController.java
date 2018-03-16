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
import com.mes.system.dto.FunctionApiRelDTO;
import com.mes.system.dto.FunctionDTO;
import com.mes.system.service.FunctionService;

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
  * 类名称:		[FunctionController]  
  * 类描述:		[系统功能控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/function")
@Api(value = "functionController", description = "系统功能管理")
public class FunctionController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	FunctionService functionService;

	/**
	 * 根据系统功能标识获取系统功能
	 * @param id 系统功能标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据系统功能标识获取系统功能", httpMethod = "GET", notes = "根据系统功能标识获取系统功能详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "系统功能标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getFunctionById")
	public ServiceResponse<FunctionDTO> getFunctionById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return functionService.getFunctionById(id);
	}

	/**
	 * 根据条件获取系统功能列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取系统功能列表", httpMethod = "GET", notes = "根据条件获取系统功能列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "系统功能标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "系统功能编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "menuId", value = "菜单ID", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "operationTypeId", value = "操作类型ID", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "name", value = "系统功能名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "comment", value = "系统功能说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getFunctionList")
	public ServiceResponse<List<FunctionDTO>> getFunctionList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return functionService.getFunctionList(condition);
	}

	/**
	 * 保存系统功能
	 * @param functionDTO 系统功能数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存系统功能", httpMethod = "POST", notes = "保存系统功能信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "functionDTO", value = "系统功能数据传输对象", required = true, dataType = "FunctionDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveFunction")
	public ServiceResponse<?> saveFunction(@RequestBody FunctionDTO functionDTO) {
		return functionService.saveFunction(functionDTO);
	}

	/**
	 * 更新系统功能
	 * @param functionDTO 系统功能数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新系统功能", httpMethod = "POST", notes = "更新系统功能信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "functionDTO", value = "系统功能数据传输对象", required = true, dataType = "FunctionDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateFunction")
	public ServiceResponse<?> updateFunction(@RequestBody FunctionDTO functionDTO) {
		return functionService.updateFunction(functionDTO);
	}

	/**
	 * 根据系统功能标识删除系统功能
	 * @param id 系统功能标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据系统功能标识删除系统功能", httpMethod = "GET", notes = "根据系统功能标识删除系统功能")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "系统功能标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteFunctionById")
	public ServiceResponse<?> deleteFunctionById(@RequestParam(value = "id") String id) {
		return functionService.deleteFunctionById(id);
	}

	/**
	 * 批量保存系统功能
	 * @param functionDAOList 系统功能数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存系统功能", httpMethod = "POST", notes = "批量保存系统功能")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "系统功能数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveFunction")
	public ServiceResponse<?> batchSaveFunction(@RequestBody List<FunctionDTO> functionList) {
		return functionService.batchSaveFunction(functionList);
	}

	/**
	 * 根据功能接口关系标识获取功能接口关系
	 * @param id 功能接口关系标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据功能接口关系标识获取功能接口关系", httpMethod = "GET", notes = "根据功能接口关系标识获取功能接口关系详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "功能接口关系标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getFunctionApiRelById")
	public ServiceResponse<FunctionApiRelDTO> getFunctionApiRelById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return functionService.getFunctionApiRelById(id);
	}

	/**
	 * 根据条件获取功能接口关系列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取功能接口关系列表", httpMethod = "GET", notes = "根据条件获取功能接口关系列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "功能接口标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionId", value = "功能标识", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "apiId", value = "接口标识", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getFunctionApiRelList")
	public ServiceResponse<List<FunctionApiRelDTO>> getFunctionApiRelList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return functionService.getFunctionApiRelList(condition);
	}

	/**
	 * 保存功能接口关系
	 * @param functionApiRelDTO 功能接口关系数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存功能接口关系", httpMethod = "POST", notes = "保存功能接口关系信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "functionApiRelDTO", value = "功能接口关系数据传输对象", required = true, dataType = "FunctionApiRelDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveFunctionApiRel")
	public ServiceResponse<?> saveFunctionApiRel(@RequestBody FunctionApiRelDTO functionApiRelDTO) {
		return functionService.saveFunctionApiRel(functionApiRelDTO);
	}

	/**
	 * 更新功能接口关系
	 * @param functionApiRelDTO 功能接口关系数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新功能接口关系", httpMethod = "POST", notes = "更新功能接口关系信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "functionApiRelDTO", value = "功能接口关系数据传输对象", required = true, dataType = "FunctionApiRelDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateFunctionApiRel")
	public ServiceResponse<?> updateFunctionApiRel(@RequestBody FunctionApiRelDTO functionApiRelDTO) {
		return functionService.updateFunctionApiRel(functionApiRelDTO);
	}

	/**
	 * 根据功能接口关系标识删除功能接口关系
	 * @param id 功能接口关系标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据功能接口关系标识删除功能接口关系", httpMethod = "GET", notes = "根据功能接口关系标识删除功能接口关系")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "功能接口关系标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteFunctionApiRelById")
	public ServiceResponse<?> deleteFunctionApiRelById(@RequestParam(value = "id") String id) {
		return functionService.deleteFunctionApiRelById(id);
	}

	/**
	 * 批量保存功能接口关系
	 * @param functionApiRelDAOList 功能接口关系数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存功能接口关系", httpMethod = "POST", notes = "批量保存功能接口关系")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "功能接口关系数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveFunctionApiRel")
	public ServiceResponse<?> batchSaveFunctionApiRel(@RequestBody List<FunctionApiRelDTO> functionApiRelList) {
		return functionService.batchSaveFunctionApiRel(functionApiRelList);
	}
}
