package com.mes.common.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.DataDictionaryDTO;
import com.mes.common.service.DataDictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.web.controller]    
  * 类名称:		[DataDictionaryController]  
  * 类描述:		[数据字典控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/dataDictionary")
@Api(value = "dataDictionaryController", description = "数据字典管理")
public class DataDictionaryController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	DataDictionaryService dataDictionaryService;

	/**
	 * 根据数据字典标识获取数据字典
	 * @param id 数据字典标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据数据字典标识获取数据字典", httpMethod = "GET", notes = "根据数据字典标识获取数据字典详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "数据字典标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDataDictionaryById")
	public ServiceResponse<DataDictionaryDTO> getDataDictionaryById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return dataDictionaryService.getDataDictionaryById(id);
	}

	/**
	 * 根据条件获取数据字典列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取数据字典列表", httpMethod = "GET", notes = "根据条件获取数据字典列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "ID编号", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "业务编码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "name", value = "业务名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "parentCode", value = "所属编码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "isEdit", value = "是否可修改(0:否  1:是)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isValid", value = "是否有效(0:否  1:是)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDefault", value = "是否默认(0:否  1:是)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "comment", value = "说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序字段", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDataDictionaryList")
	public ServiceResponse<List<DataDictionaryDTO>> getDataDictionaryList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return dataDictionaryService.getDataDictionaryList(condition);
	}

	/**
	 * 保存数据字典
	 * @param dataDictionaryDTO 数据字典数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存数据字典", httpMethod = "POST", notes = "保存数据字典信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "dataDictionaryDTO", value = "数据字典数据传输对象", required = true, dataType = "DataDictionaryDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveDataDictionary")
	public ServiceResponse<?> saveDataDictionary(@RequestBody DataDictionaryDTO dataDictionaryDTO) {
		return dataDictionaryService.saveDataDictionary(dataDictionaryDTO);
	}

	/**
	 * 更新数据字典
	 * @param dataDictionaryDTO 数据字典数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新数据字典", httpMethod = "POST", notes = "更新数据字典信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "dataDictionaryDTO", value = "数据字典数据传输对象", required = true, dataType = "DataDictionaryDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateDataDictionary")
	public ServiceResponse<?> updateDataDictionary(@RequestBody DataDictionaryDTO dataDictionaryDTO) {
		return dataDictionaryService.updateDataDictionary(dataDictionaryDTO);
	}

	/**
	 * 根据数据字典标识删除数据字典
	 * @param id 数据字典标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据数据字典标识删除数据字典", httpMethod = "GET", notes = "根据数据字典标识删除数据字典")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "数据字典标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteDataDictionaryById")
	public ServiceResponse<?> deleteDataDictionaryById(@RequestParam(value = "id") String id) {
		return dataDictionaryService.deleteDataDictionaryById(id);
	}

	/**
	 * 批量保存数据字典
	 * @param dataDictionaryDAOList 数据字典数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存数据字典", httpMethod = "POST", notes = "批量保存数据字典")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "数据字典数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveDataDictionary")
	public ServiceResponse<?> batchSaveDataDictionary(@RequestBody List<DataDictionaryDTO> dataDictionaryList) {
		return dataDictionaryService.batchSaveDataDictionary(dataDictionaryList);
	}

	/**
	 * 批量更新数据字典
	 * @param dataDictionaryDAOList 数据字典对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量更新数据字典", httpMethod = "POST", notes = "批量更新数据字典信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchUpdateDataDictionary")
	public ServiceResponse<?> batchUpdateDataDictionary(@RequestBody List<DataDictionaryDTO> dataDictionaryList) {
		return dataDictionaryService.batchUpdateDataDictionary(dataDictionaryList);
	}
}
