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
import com.mes.system.bean.SessionUser;
import com.mes.system.dto.DataPurviewDTO;
import com.mes.system.dto.FunctionPurviewDTO;
import com.mes.system.dto.MenuPurviewDTO;
import com.mes.system.dto.PurviewFunctionTreeDTO;
import com.mes.system.dto.PurviewSecTreeDTO;
import com.mes.system.service.PurviewService;

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
  * 类名称:		[PurviewController]  
  * 类描述:		[权限控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/purview")
@Api(value = "PurviewController", description = "权限管理")
public class PurviewController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	PurviewService purviewService;

	/**
	 * 根据菜单权限标识获取菜单权限
	 * @param id 菜单权限标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据菜单权限标识获取菜单权限", httpMethod = "GET", notes = "根据菜单权限标识获取菜单权限详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "菜单权限标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMenuPurviewById")
	public ServiceResponse<MenuPurviewDTO> getMenuPurviewById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return purviewService.getMenuPurviewById(id);
	}

	/**
	 * 根据条件获取菜单权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取菜单权限列表", httpMethod = "GET", notes = "根据条件获取菜单权限列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secId", value = "权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secName", value = "权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "menuId", value = "菜单主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMenuPurviewList")
	public ServiceResponse<List<MenuPurviewDTO>> getMenuPurviewList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return purviewService.getMenuPurviewList(condition);
	}

	/**
	 * 保存菜单权限
	 * @param menuPurviewDTO 菜单权限数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存菜单权限", httpMethod = "POST", notes = "保存菜单权限信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "menuPurviewDTO", value = "菜单权限数据传输对象", required = true, dataType = "MenuPurviewDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveMenuPurview")
	public ServiceResponse<?> saveMenuPurview(@RequestBody MenuPurviewDTO menuPurviewDTO) {
		return purviewService.saveMenuPurview(menuPurviewDTO);
	}

	/**
	 * 更新菜单权限
	 * @param menuPurviewDTO 菜单权限数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新菜单权限", httpMethod = "POST", notes = "更新菜单权限信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "menuPurviewDTO", value = "菜单权限数据传输对象", required = true, dataType = "MenuPurviewDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateMenuPurview")
	public ServiceResponse<?> updateMenuPurview(@RequestBody MenuPurviewDTO menuPurviewDTO) {
		return purviewService.updateMenuPurview(menuPurviewDTO);
	}

	/**
	 * 根据菜单权限标识删除菜单权限
	 * @param id 菜单权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据菜单权限标识删除菜单权限", httpMethod = "GET", notes = "根据菜单权限标识删除菜单权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "菜单权限标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteMenuPurviewById")
	public ServiceResponse<?> deleteMenuPurviewById(@RequestParam(value = "id") String id) {
		return purviewService.deleteMenuPurviewById(id);
	}

	/**
	 * 批量保存菜单权限
	 * @param menuPurviewDAOList 菜单权限数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存菜单权限", httpMethod = "POST", notes = "批量保存菜单权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "菜单权限数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveMenuPurview")
	public ServiceResponse<?> batchSaveMenuPurview(@RequestBody List<MenuPurviewDTO> menuPurviewList) {
		return purviewService.batchSaveMenuPurview(menuPurviewList);
	}

	/**
	 * 根据功能权限标识获取功能权限
	 * @param id 功能权限标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据功能权限标识获取功能权限", httpMethod = "GET", notes = "根据功能权限标识获取功能权限详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "功能权限标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getFunctionPurviewById")
	public ServiceResponse<FunctionPurviewDTO> getFunctionPurviewById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return purviewService.getFunctionPurviewById(id);
	}

	/**
	 * 根据条件获取功能权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取功能权限列表", httpMethod = "GET", notes = "根据条件获取功能权限列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secId", value = "权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secName", value = "权限对象SEC名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "menuId", value = "菜单主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionId", value = "系统功能标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionCode", value = "系统功能CODE", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getFunctionPurviewList")
	public ServiceResponse<List<FunctionPurviewDTO>> getFunctionPurviewList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return purviewService.getFunctionPurviewList(condition);
	}

	/**
	 * 保存功能权限
	 * @param functionPurviewDTO 功能权限数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存功能权限", httpMethod = "POST", notes = "保存功能权限信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "functionPurviewDTO", value = "功能权限数据传输对象", required = true, dataType = "FunctionPurviewDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveFunctionPurview")
	public ServiceResponse<?> saveFunctionPurview(@RequestBody FunctionPurviewDTO functionPurviewDTO) {
		return purviewService.saveFunctionPurview(functionPurviewDTO);
	}

	/**
	 * 更新功能权限
	 * @param functionPurviewDTO 功能权限数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新功能权限", httpMethod = "POST", notes = "更新功能权限信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "functionPurviewDTO", value = "功能权限数据传输对象", required = true, dataType = "FunctionPurviewDTO", paramType = "body") })
	@RequestMapping("/updateFunctionPurview")
	public ServiceResponse<?> updateFunctionPurview(@RequestBody FunctionPurviewDTO functionPurviewDTO) {
		return purviewService.updateFunctionPurview(functionPurviewDTO);
	}

	/**
	 * 根据功能权限标识删除功能权限
	 * @param id 功能权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据功能权限标识删除功能权限", httpMethod = "GET", notes = "根据功能权限标识删除功能权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "功能权限标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@RequestMapping("/deleteFunctionPurviewById")
	public ServiceResponse<?> deleteFunctionPurviewById(@RequestParam(value = "id") String id) {
		return purviewService.deleteFunctionPurviewById(id);
	}

	/**
	 * 批量保存功能权限
	 * @param functionPurviewDAOList 功能权限数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存功能权限", httpMethod = "POST", notes = "批量保存功能权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "功能权限数据传输对象", required = true, dataType = "List", paramType = "body") })
	@RequestMapping("/batchSaveFunctionPurview")
	public ServiceResponse<?> batchSaveFunctionPurview(@RequestBody List<FunctionPurviewDTO> functionPurviewList) {
		return purviewService.batchSaveFunctionPurview(functionPurviewList);
	}

	/**
	 * 根据数据权限标识获取数据权限
	 * @param id 数据权限标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据数据权限标识获取数据权限", httpMethod = "GET", notes = "根据数据权限标识获取数据权限详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "数据权限标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = ServiceResponse.class) })
	@RequestMapping("/getDataPurviewById")
	public ServiceResponse<DataPurviewDTO> getDataPurviewById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return purviewService.getDataPurviewById(id);
	}

	/**
	 * 根据条件获取数据权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取数据权限列表", httpMethod = "GET", notes = "根据条件获取数据权限列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secId", value = "权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secName", value = "权限对象SEC名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "menuId", value = "菜单主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionId", value = "系统功能标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionCode", value = "系统功能标识", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "rangeSecId", value = "范围权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "rangeSecName", value = "范围权限对象SEC名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@RequestMapping("/getDataPurviewList")
	public ServiceResponse<List<DataPurviewDTO>> getDataPurviewList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return purviewService.getDataPurviewList(condition);
	}

	/**
	 * 保存数据权限
	 * @param dataPurviewDTO 数据权限数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存数据权限", httpMethod = "POST", notes = "保存数据权限信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "dataPurviewDTO", value = "数据权限数据传输对象", required = true, dataType = "DataPurviewDTO", paramType = "body") })
	@RequestMapping("/saveDataPurview")
	public ServiceResponse<?> saveDataPurview(@RequestBody DataPurviewDTO dataPurviewDTO) {
		return purviewService.saveDataPurview(dataPurviewDTO);
	}

	/**
	 * 更新数据权限
	 * @param dataPurviewDTO 数据权限数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新数据权限", httpMethod = "POST", notes = "更新数据权限信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "dataPurviewDTO", value = "数据权限数据传输对象", required = true, dataType = "DataPurviewDTO", paramType = "body") })
	@RequestMapping("/updateDataPurview")
	public ServiceResponse<?> updateDataPurview(@RequestBody DataPurviewDTO dataPurviewDTO) {
		return purviewService.updateDataPurview(dataPurviewDTO);
	}

	/**
	 * 根据数据权限标识删除数据权限
	 * @param id 数据权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据数据权限标识删除数据权限", httpMethod = "GET", notes = "根据数据权限标识删除数据权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "数据权限标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@RequestMapping("/deleteDataPurviewById")
	public ServiceResponse<?> deleteDataPurviewById(@RequestParam(value = "id") String id) {
		return purviewService.deleteDataPurviewById(id);
	}

	/**
	 * 批量保存数据权限
	 * @param dataPurviewDAOList 数据权限数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存数据权限", httpMethod = "POST", notes = "批量保存数据权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "数据权限数据传输对象", required = true, dataType = "List", paramType = "body") })
	@RequestMapping("/batchSaveDataPurview")
	public ServiceResponse<?> batchSaveDataPurview(@RequestBody List<DataPurviewDTO> dataPurviewList) {
		return purviewService.batchSaveDataPurview(dataPurviewList);
	}

	/**
	 * 批量保存数据权限
	 * @param secDataJson 权限对象Json字符串
	 * @param prviewFucntionDataJson 权限功能Json字符串
	 * @param rangeSecDataJson 范围权限对象Json字符串
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存权限", httpMethod = "POST", notes = "批量保存权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "数据权限数据传输对象", required = true, dataType = "List", paramType = "body") })
	@RequestMapping("/batchSavePurview")
	public ServiceResponse<?> batchSavePurview(@RequestParam(value = "secDataJson") String secDataJson, @RequestParam(value = "prviewFucntionDataJson") String prviewFucntionDataJson, @RequestParam(value = "rangeSecDataJson") String rangeSecDataJson) {
		return purviewService.batchSavePurview(999999L, secDataJson, prviewFucntionDataJson, rangeSecDataJson);
	}

	/**
	 * 根据条件获取系统权限对象树
	 * @param userId 用户标识
	 * @param pvSql 数据权限SQL
	 * @return 系统权限对象树
	 */
	@RequestMapping("/getPurviewSecTree")
	public List<PurviewSecTreeDTO> getPurviewSecTree() {
		return purviewService.getPurviewSecTree(999999L, "").getData();
	}

	/**
	 * 根据条件获取系统权限功能树
	 * @param condition 用户标识
	 * @param condition 权限对象标识
	 * @return 系统功能对象集合
	 */
	@RequestMapping("/getPurviewFucntionTree")
	public List<PurviewFunctionTreeDTO> getPurviewFucntionTree(@RequestParam(value = "secId", required = false) String secId) {
		return purviewService.getPurviewFucntionTree(999999L, secId).getData();
	}

	/**
	 * 根据条件获取系统权限范围对象树
	 * @param userId 用户标识
	 * @param secId  权限资源对象
	 * @param pvSql  数据权限SQL
	 * @return 系统权限范围对象树
	 */
	@RequestMapping("/getPurviewRangeSecTree")
	public List<PurviewSecTreeDTO> getPurviewRangeSecTree(@RequestParam(value = "secId", required = false) String secId) {
		return purviewService.getPurviewRangeSecTree(999999L, secId, "").getData();
	}

	/***
	 * 校验接口地址是否具有权限
	 * @param userId 用户标识
	 * @param apiUrl 接口地址
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "校验接口地址是否具有权限", httpMethod = "GET", notes = "校验接口地址是否具有权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "userId", value = "用户标识", required = true, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "apiUrl", value = "接口地址", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/checkPurview")
	public ServiceResponse<Boolean> checkPurview(@RequestParam(value = "userId") Long userId, @RequestParam(value = "apiUrl", required = false) String apiUrl) {
		return purviewService.checkPurview(userId, apiUrl);
	}

	/***
	 * 校验功能编码是否具有功能权限
	 * @param userId 用户标识
	 * @param functionCode 功能编码
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "校验功能编码是否具有功能权限", httpMethod = "GET", notes = "校验功能编码是否具有功能权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "userId", value = "用户标识", required = true, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionCode", value = "功能编码", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/checkFunctionPurview")
	public ServiceResponse<Boolean> checkFunctionPurview(@RequestParam(value = "userId") Long userId, @RequestParam(value = "functionCode", required = false) String functionCode) {
		SessionUser su = SessionUser.getSessionUser(request);
		System.out.println(su.toString());
		return purviewService.checkFunctionPurview(userId, functionCode);
	}
}
