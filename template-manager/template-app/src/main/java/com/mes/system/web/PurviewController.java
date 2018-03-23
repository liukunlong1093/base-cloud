package com.mes.system.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.mes.core.controller.BaseController;
import com.mes.core.pojos.ServiceResponse;
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
  * 包:	        [com.mes.system.web]    
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
public class PurviewController extends BaseController {
	@Autowired
	private PurviewService purviewService;

	/**
	 * 根据菜单权限标识获取菜单权限
	 * @param id 菜单权限标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据菜单权限标识获取菜单权限", httpMethod = "GET", notes = "根据菜单权限标识获取菜单权限详细信息")
	@ApiImplicitParam(name = "id", value = "菜单权限标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMenuPurviewById")
	public ServiceResponse<MenuPurviewDTO> getMenuPurviewById(@RequestParam(value = "id") Long id) {
		MenuPurviewDTO menuPurviewDTO = purviewService.getMenuPurviewById(id);
		return ServiceResponse.handleSuccess(menuPurviewDTO);
	}

	/**
	 * 根据条件获取菜单权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取菜单权限列表", httpMethod = "GET", notes = "根据条件获取菜单权限列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secId", value = "权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secName", value = "权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "menuId", value = "菜单主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMenuPurviewList")
	public ServiceResponse<List<MenuPurviewDTO>> getMenuPurviewList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<MenuPurviewDTO> menuPurviewList = purviewService.getMenuPurviewList(condition);
		PageInfo<MenuPurviewDTO> pageInfo = new PageInfo<MenuPurviewDTO>(menuPurviewList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存菜单权限", httpMethod = "POST", notes = "保存菜单权限信息")
	@ApiImplicitParam(name = "menuPurviewDTO", value = "菜单权限对象", required = true, dataType = "MenuPurviewDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveMenuPurview")
	public ServiceResponse<?> saveMenuPurview(@RequestBody MenuPurviewDTO menuPurviewDTO) {
		purviewService.saveMenuPurview(menuPurviewDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新菜单权限", httpMethod = "POST", notes = "更新菜单权限信息")
	@ApiImplicitParam(name = "menuPurviewDTO", value = "菜单权限对象", required = true, dataType = "MenuPurviewDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateMenuPurview")
	public ServiceResponse<?> updateMenuPurview(@RequestBody MenuPurviewDTO menuPurviewDTO) {
		purviewService.updateMenuPurview(menuPurviewDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据菜单权限标识删除菜单权限
	 * @param id 菜单权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据菜单权限标识删除菜单权限", httpMethod = "GET", notes = "根据菜单权限标识删除菜单权限")
	@ApiImplicitParam(name = "id", value = "菜单权限标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteMenuPurviewById")
	public ServiceResponse<?> deleteMenuPurviewById(@RequestParam(value = "id") String id) {
		purviewService.deleteMenuPurviewById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存菜单权限
	 * @param menuPurviewDAOList 菜单权限对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存菜单权限", httpMethod = "POST", notes = "批量保存菜单权限信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveMenuPurview")
	public ServiceResponse<?> batchSaveMenuPurview(@RequestBody List<MenuPurviewDTO> menuPurviewList) {
		purviewService.batchSaveMenuPurview(menuPurviewList);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据功能权限标识获取功能权限
	 * @param id 功能权限标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据功能权限标识获取功能权限", httpMethod = "GET", notes = "根据功能权限标识获取功能权限详细信息")
	@ApiImplicitParam(name = "id", value = "功能权限标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getFunctionPurviewById")
	public ServiceResponse<FunctionPurviewDTO> getFunctionPurviewById(@RequestParam(value = "id") Long id) {
		FunctionPurviewDTO functionPurviewDTO = purviewService.getFunctionPurviewById(id);
		return ServiceResponse.handleSuccess(functionPurviewDTO);
	}

	/**
	 * 根据条件获取功能权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取功能权限列表", httpMethod = "GET", notes = "根据条件获取功能权限列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secId", value = "权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secName", value = "权限对象SEC名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "menuId", value = "菜单主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionId", value = "系统功能标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionCode", value = "系统功能CODE", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getFunctionPurviewList")
	public ServiceResponse<List<FunctionPurviewDTO>> getFunctionPurviewList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<FunctionPurviewDTO> functionPurviewList = purviewService.getFunctionPurviewList(condition);
		PageInfo<FunctionPurviewDTO> pageInfo = new PageInfo<FunctionPurviewDTO>(functionPurviewList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存功能权限", httpMethod = "POST", notes = "保存功能权限信息")
	@ApiImplicitParam(name = "functionPurviewDTO", value = "功能权限对象", required = true, dataType = "FunctionPurviewDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveFunctionPurview")
	public ServiceResponse<?> saveFunctionPurview(@RequestBody FunctionPurviewDTO functionPurviewDTO) {
		purviewService.saveFunctionPurview(functionPurviewDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新功能权限", httpMethod = "POST", notes = "更新功能权限信息")
	@ApiImplicitParam(name = "functionPurviewDTO", value = "功能权限对象", required = true, dataType = "FunctionPurviewDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateFunctionPurview")
	public ServiceResponse<?> updateFunctionPurview(@RequestBody FunctionPurviewDTO functionPurviewDTO) {
		purviewService.updateFunctionPurview(functionPurviewDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据功能权限标识删除功能权限
	 * @param id 功能权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据功能权限标识删除功能权限", httpMethod = "GET", notes = "根据功能权限标识删除功能权限")
	@ApiImplicitParam(name = "id", value = "功能权限标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteFunctionPurviewById")
	public ServiceResponse<?> deleteFunctionPurviewById(@RequestParam(value = "id") String id) {
		purviewService.deleteFunctionPurviewById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存功能权限
	 * @param functionPurviewDAOList 功能权限对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存功能权限", httpMethod = "POST", notes = "批量保存功能权限信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveFunctionPurview")
	public ServiceResponse<?> batchSaveFunctionPurview(@RequestBody List<FunctionPurviewDTO> functionPurviewList) {
		purviewService.batchSaveFunctionPurview(functionPurviewList);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据数据权限标识获取数据权限
	 * @param id 数据权限标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据数据权限标识获取数据权限", httpMethod = "GET", notes = "根据数据权限标识获取数据权限详细信息")
	@ApiImplicitParam(name = "id", value = "数据权限标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDataPurviewById")
	public ServiceResponse<DataPurviewDTO> getDataPurviewById(@RequestParam(value = "id") Long id) {
		DataPurviewDTO dataPurviewDTO = purviewService.getDataPurviewById(id);
		return ServiceResponse.handleSuccess(dataPurviewDTO);
	}

	/**
	 * 根据条件获取数据权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取数据权限列表", httpMethod = "GET", notes = "根据条件获取数据权限列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secId", value = "权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "secName", value = "权限对象SEC名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "menuId", value = "菜单主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionId", value = "系统功能标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "functionCode", value = "系统功能标识", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "rangeSecId", value = "范围权限对象SEC", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "rangeSecName", value = "范围权限对象SEC名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDataPurviewList")
	public ServiceResponse<List<DataPurviewDTO>> getDataPurviewList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<DataPurviewDTO> dataPurviewList = purviewService.getDataPurviewList(condition);
		PageInfo<DataPurviewDTO> pageInfo = new PageInfo<DataPurviewDTO>(dataPurviewList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存数据权限", httpMethod = "POST", notes = "保存数据权限信息")
	@ApiImplicitParam(name = "dataPurviewDTO", value = "数据权限对象", required = true, dataType = "DataPurviewDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveDataPurview")
	public ServiceResponse<?> saveDataPurview(@RequestBody DataPurviewDTO dataPurviewDTO) {
		purviewService.saveDataPurview(dataPurviewDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新数据权限", httpMethod = "POST", notes = "更新数据权限信息")
	@ApiImplicitParam(name = "dataPurviewDTO", value = "数据权限对象", required = true, dataType = "DataPurviewDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateDataPurview")
	public ServiceResponse<?> updateDataPurview(@RequestBody DataPurviewDTO dataPurviewDTO) {
		purviewService.updateDataPurview(dataPurviewDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据数据权限标识删除数据权限
	 * @param id 数据权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据数据权限标识删除数据权限", httpMethod = "GET", notes = "根据数据权限标识删除数据权限")
	@ApiImplicitParam(name = "id", value = "数据权限标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteDataPurviewById")
	public ServiceResponse<?> deleteDataPurviewById(@RequestParam(value = "id") String id) {
		purviewService.deleteDataPurviewById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存数据权限
	 * @param dataPurviewDAOList 数据权限对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存数据权限", httpMethod = "POST", notes = "批量保存数据权限信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveDataPurview")
	public ServiceResponse<?> batchSaveDataPurview(@RequestBody List<DataPurviewDTO> dataPurviewList) {
		purviewService.batchSaveDataPurview(dataPurviewList);
		return ServiceResponse.handleSuccess();
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
	public ServiceResponse<?> batchSavePurview(@RequestParam(value = "userId") Long userId, @RequestParam(value = "secDataJson") String secDataJson, @RequestParam(value = "prviewFucntionDataJson") String prviewFucntionDataJson, @RequestParam(value = "rangeSecDataJson") String rangeSecDataJson) {
		return ServiceResponse.handleSuccess(purviewService.batchSavePurview(userId, secDataJson, prviewFucntionDataJson, rangeSecDataJson));
	}

	/**
	 * 根据条件获取系统权限对象树
	 * @param userId 用户标识
	 * @param pvSql 数据权限SQL
	 * @return 服务响应对象
	 */
	@RequestMapping("/getPurviewSecTree")
	public ServiceResponse<List<PurviewSecTreeDTO>> getPurviewSecTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "pvSql") String pvSql) {
		List<PurviewSecTreeDTO> list = purviewService.getPurviewSecTree(userId, pvSql);
		return ServiceResponse.handleSuccess(list);
	}

	/**
	 * 根据条件获取系统权限功能树
	 * @param condition 用户标识
	 * @param condition 权限对象标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/getPurviewFucntionTree")
	public ServiceResponse<List<PurviewFunctionTreeDTO>> getPurviewFucntionTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "secId", required = false) String secId) {
		return ServiceResponse.handleSuccess(purviewService.getPurviewFucntionTree(userId, secId));
	}

	/**
	 * 根据条件获取系统权限范围对象树
	 * @param userId 用户标识
	 * @param secId  权限资源对象
	 * @param pvSql  数据权限SQL
	 * @return 服务响应对象
	 */
	@RequestMapping("/getPurviewRangeSecTree")
	public ServiceResponse<List<PurviewSecTreeDTO>> getPurviewRangeSecTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "secId", required = false) String secId, @RequestParam(value = "pvSql") String pvSql) {
		return ServiceResponse.handleSuccess(purviewService.getPurviewRangeSecTree(userId, secId, pvSql));
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
		return ServiceResponse.handleSuccess(purviewService.checkPurview(userId, apiUrl));
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
		return ServiceResponse.handleSuccess(purviewService.checkFunctionPurview(userId, functionCode));
	}
}
