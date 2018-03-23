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
import com.mes.system.dto.OperateTypeDTO;
import com.mes.system.service.OperateTypeService;
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
  * 类名称:		[OperateTypeController]  
  * 类描述:		[权限操作类型控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/operateType")
@Api(value = "OperateTypeController", description = "权限操作类型管理")
public class OperateTypeController extends BaseController {
	@Autowired
	private OperateTypeService operateTypeService;

	/**
	 * 根据权限操作类型标识获取权限操作类型
	 * @param id 权限操作类型标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据权限操作类型标识获取权限操作类型", httpMethod = "GET", notes = "根据权限操作类型标识获取权限操作类型详细信息")
	@ApiImplicitParam(name = "id", value = "权限操作类型标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOperateTypeById")
	public ServiceResponse<OperateTypeDTO> getOperateTypeById(@RequestParam(value="id") Long id) {
		OperateTypeDTO operateTypeDTO = operateTypeService.getOperateTypeById(id);
		return ServiceResponse.handleSuccess(operateTypeDTO);
	}

	/**
	 * 根据条件获取权限操作类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取权限操作类型列表", httpMethod = "GET", notes = "根据条件获取权限操作类型列表")
	@ApiImplicitParams({ 
						@ApiImplicitParam(name = "id", value = "操作类型标识", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "code", value = "操作类型编号", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "name", value = "操作类型名称", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "comment", value = "操作类型说明", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), 
																														@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), 
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") 
	})
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOperateTypeList")
	public ServiceResponse<List<OperateTypeDTO>> getOperateTypeList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<OperateTypeDTO> operateTypeList = operateTypeService.getOperateTypeList(condition);
		PageInfo<OperateTypeDTO> pageInfo = new PageInfo<OperateTypeDTO>(operateTypeList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存权限操作类型", httpMethod = "POST", notes = "保存权限操作类型信息")
	@ApiImplicitParam(name = "operateTypeDTO", value = "权限操作类型对象", required = true, dataType = "OperateTypeDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveOperateType")
	public ServiceResponse<?> saveOperateType(@RequestBody OperateTypeDTO operateTypeDTO) {
		operateTypeService.saveOperateType(operateTypeDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新权限操作类型", httpMethod = "POST", notes = "更新权限操作类型信息")
	@ApiImplicitParam(name = "operateTypeDTO", value = "权限操作类型对象", required = true, dataType = "OperateTypeDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateOperateType")
	public ServiceResponse<?> updateOperateType(@RequestBody OperateTypeDTO operateTypeDTO) {
		operateTypeService.updateOperateType(operateTypeDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据权限操作类型标识删除权限操作类型
	 * @param id 权限操作类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据权限操作类型标识删除权限操作类型", httpMethod = "GET", notes = "根据权限操作类型标识删除权限操作类型")
	@ApiImplicitParam(name = "id", value = "权限操作类型标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteOperateTypeById")
	public ServiceResponse<?> deleteOperateTypeById(@RequestParam(value="id") String id) {
		operateTypeService.deleteOperateTypeById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存权限操作类型
	 * @param operateTypeDAOList 权限操作类型对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存权限操作类型", httpMethod = "POST", notes = "批量保存权限操作类型信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveOperateType")
	public ServiceResponse<?> batchSaveOperateType(@RequestBody List<OperateTypeDTO> operateTypeList) {
		operateTypeService.batchSaveOperateType(operateTypeList);
		return ServiceResponse.handleSuccess();
	}
}
