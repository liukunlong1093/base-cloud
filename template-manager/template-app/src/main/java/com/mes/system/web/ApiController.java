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
import com.mes.system.dto.ApiDTO;
import com.mes.system.service.ApiService;
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
  * 类名称:		[ApiController]  
  * 类描述:		[应用程序接口控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/api")
@Api(value = "ApiController", description = "应用程序接口管理")
public class ApiController extends BaseController {
	@Autowired
	private ApiService apiService;

	/**
	 * 根据应用程序接口标识获取应用程序接口
	 * @param id 应用程序接口标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据应用程序接口标识获取应用程序接口", httpMethod = "GET", notes = "根据应用程序接口标识获取应用程序接口详细信息")
	@ApiImplicitParam(name = "id", value = "应用程序接口标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getApiById")
	public ServiceResponse<ApiDTO> getApiById(@RequestParam(value="id") Long id) {
		ApiDTO apiDTO = apiService.getApiById(id);
		return ServiceResponse.handleSuccess(apiDTO);
	}

	/**
	 * 根据条件获取应用程序接口列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取应用程序接口列表", httpMethod = "GET", notes = "根据条件获取应用程序接口列表")
	@ApiImplicitParams({ 
						@ApiImplicitParam(name = "id", value = "系统接口标识", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "name", value = "接口名称", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "projectId", value = "项目标识", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "projectName", value = "项目名称", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "moduleId", value = "模块标识", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "moduleName", value = "模块名称", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "url", value = "接口地址", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "comment", value = "系统接口说明", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), 
																														@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), 
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") 
	})
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getApiList")
	public ServiceResponse<List<ApiDTO>> getApiList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<ApiDTO> apiList = apiService.getApiList(condition);
		PageInfo<ApiDTO> pageInfo = new PageInfo<ApiDTO>(apiList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存应用程序接口", httpMethod = "POST", notes = "保存应用程序接口信息")
	@ApiImplicitParam(name = "apiDTO", value = "应用程序接口对象", required = true, dataType = "ApiDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveApi")
	public ServiceResponse<?> saveApi(@RequestBody ApiDTO apiDTO) {
		apiService.saveApi(apiDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新应用程序接口", httpMethod = "POST", notes = "更新应用程序接口信息")
	@ApiImplicitParam(name = "apiDTO", value = "应用程序接口对象", required = true, dataType = "ApiDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateApi")
	public ServiceResponse<?> updateApi(@RequestBody ApiDTO apiDTO) {
		apiService.updateApi(apiDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据应用程序接口标识删除应用程序接口
	 * @param id 应用程序接口标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据应用程序接口标识删除应用程序接口", httpMethod = "GET", notes = "根据应用程序接口标识删除应用程序接口")
	@ApiImplicitParam(name = "id", value = "应用程序接口标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteApiById")
	public ServiceResponse<?> deleteApiById(@RequestParam(value="id") String id) {
		apiService.deleteApiById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存应用程序接口
	 * @param apiDAOList 应用程序接口对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存应用程序接口", httpMethod = "POST", notes = "批量保存应用程序接口信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveApi")
	public ServiceResponse<?> batchSaveApi(@RequestBody List<ApiDTO> apiList) {
		apiService.batchSaveApi(apiList);
		return ServiceResponse.handleSuccess();
	}
}
