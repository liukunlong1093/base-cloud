package com.mes.common.web;
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
import com.mes.common.dto.ConfigDTO;
import com.mes.common.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.web]    
  * 类名称:		[ConfigController]  
  * 类描述:		[配置控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/config")
@Api(value = "ConfigController", description = "配置管理")
public class ConfigController extends BaseController {
	@Autowired
	private ConfigService configService;

	/**
	 * 根据配置标识获取配置
	 * @param id 配置标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据配置标识获取配置", httpMethod = "GET", notes = "根据配置标识获取配置详细信息")
	@ApiImplicitParam(name = "id", value = "配置标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getConfigById")
	public ServiceResponse<ConfigDTO> getConfigById(@RequestParam(value="id") Long id) {
		ConfigDTO configDTO = configService.getConfigById(id);
		return ServiceResponse.handleSussess(configDTO);
	}

	/**
	 * 根据条件获取配置列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取配置列表", httpMethod = "GET", notes = "根据条件获取配置列表")
	@ApiImplicitParams({ 
						@ApiImplicitParam(name = "id", value = "表主键", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "name", value = "配置名称", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "value", value = "配置值", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "type", value = "配置类型(已业务区分)", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "comment", value = "配置说明", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), 
																														@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), 
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") 
	})
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getConfigList")
	public ServiceResponse<List<ConfigDTO>> getConfigList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<ConfigDTO> configList = configService.getConfigList(condition);
		PageInfo<ConfigDTO> pageInfo = new PageInfo<ConfigDTO>(configList);
		return ServiceResponse.handleSussess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存配置
	 * @param configDTO 配置对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存配置", httpMethod = "POST", notes = "保存配置信息")
	@ApiImplicitParam(name = "configDTO", value = "配置对象", required = true, dataType = "ConfigDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveConfig")
	public ServiceResponse<?> saveConfig(@RequestBody ConfigDTO configDTO) {
		configService.saveConfig(configDTO);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 更新配置
	 * @param configDTO 配置对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新配置", httpMethod = "POST", notes = "更新配置信息")
	@ApiImplicitParam(name = "configDTO", value = "配置对象", required = true, dataType = "ConfigDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateConfig")
	public ServiceResponse<?> updateConfig(@RequestBody ConfigDTO configDTO) {
		configService.updateConfig(configDTO);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 根据配置标识删除配置
	 * @param id 配置标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据配置标识删除配置", httpMethod = "GET", notes = "根据配置标识删除配置")
	@ApiImplicitParam(name = "id", value = "配置标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteConfigById")
	public ServiceResponse<?> deleteConfigById(@RequestParam(value="id") String id) {
		configService.deleteConfigById(id);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 批量保存配置
	 * @param configDAOList 配置对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存配置", httpMethod = "POST", notes = "批量保存配置信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveConfig")
	public ServiceResponse<?> batchSaveConfig(@RequestBody List<ConfigDTO> configList) {
		configService.batchSaveConfig(configList);
		return ServiceResponse.handleSussess();
	}
}
