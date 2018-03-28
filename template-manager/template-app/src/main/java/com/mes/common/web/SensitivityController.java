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
import com.mes.common.dto.SensitivityDTO;
import com.mes.common.service.SensitivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.web]    
  * 类名称:		[SensitivityController]  
  * 类描述:		[敏感词控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/sensitivity")
@Api(value = "SensitivityController", description = "敏感词管理")
public class SensitivityController extends BaseController {
	@Autowired
	private SensitivityService sensitivityService;

	/**
	 * 根据敏感词标识获取敏感词
	 * @param id 敏感词标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据敏感词标识获取敏感词", httpMethod = "GET", notes = "根据敏感词标识获取敏感词详细信息")
	@ApiImplicitParam(name = "id", value = "敏感词标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getSensitivityById")
	public ServiceResponse<SensitivityDTO> getSensitivityById(@RequestParam(value="id") Long id) {
		SensitivityDTO sensitivityDTO = sensitivityService.getSensitivityById(id);
		return ServiceResponse.handleSuccess(sensitivityDTO);
	}

	/**
	 * 根据条件获取敏感词列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取敏感词列表", httpMethod = "GET", notes = "根据条件获取敏感词列表")
	@ApiImplicitParams({ 
						@ApiImplicitParam(name = "id", value = "", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "content", value = "敏感内容", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "replacement", value = "替换内容", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), 
																														@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), 
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") 
	})
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getSensitivityList")
	public ServiceResponse<List<SensitivityDTO>> getSensitivityList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<SensitivityDTO> sensitivityList = sensitivityService.getSensitivityList(condition);
		PageInfo<SensitivityDTO> pageInfo = new PageInfo<SensitivityDTO>(sensitivityList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存敏感词", httpMethod = "POST", notes = "保存敏感词信息")
	@ApiImplicitParam(name = "sensitivityDTO", value = "敏感词对象", required = true, dataType = "SensitivityDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveSensitivity")
	public ServiceResponse<?> saveSensitivity(@RequestBody SensitivityDTO sensitivityDTO) {
		sensitivityService.saveSensitivity(sensitivityDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新敏感词", httpMethod = "POST", notes = "更新敏感词信息")
	@ApiImplicitParam(name = "sensitivityDTO", value = "敏感词对象", required = true, dataType = "SensitivityDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateSensitivity")
	public ServiceResponse<?> updateSensitivity(@RequestBody SensitivityDTO sensitivityDTO) {
		sensitivityService.updateSensitivity(sensitivityDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据敏感词标识删除敏感词
	 * @param id 敏感词标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据敏感词标识删除敏感词", httpMethod = "GET", notes = "根据敏感词标识删除敏感词")
	@ApiImplicitParam(name = "id", value = "敏感词标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteSensitivityById")
	public ServiceResponse<?> deleteSensitivityById(@RequestParam(value="id") String id) {
		sensitivityService.deleteSensitivityById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存敏感词
	 * @param sensitivityDAOList 敏感词对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存敏感词", httpMethod = "POST", notes = "批量保存敏感词信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveSensitivity")
	public ServiceResponse<?> batchSaveSensitivity(@RequestBody List<SensitivityDTO> sensitivityList) {
		sensitivityService.batchSaveSensitivity(sensitivityList);
		return ServiceResponse.handleSuccess();
	}
}
