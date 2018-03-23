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
import com.mes.common.dto.AreaDTO;
import com.mes.common.service.AreaService;
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
  * 类名称:		[AreaController]  
  * 类描述:		[区域控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/area")
@Api(value = "AreaController", description = "区域管理")
public class AreaController extends BaseController {
	@Autowired
	private AreaService areaService;

	/**
	 * 根据区域标识获取区域
	 * @param id 区域标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据区域标识获取区域", httpMethod = "GET", notes = "根据区域标识获取区域详细信息")
	@ApiImplicitParam(name = "id", value = "区域标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getAreaById")
	public ServiceResponse<AreaDTO> getAreaById(@RequestParam(value="id") Long id) {
		AreaDTO areaDTO = areaService.getAreaById(id);
		return ServiceResponse.handleSuccess(areaDTO);
	}

	/**
	 * 根据条件获取区域列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取区域列表", httpMethod = "GET", notes = "根据条件获取区域列表")
	@ApiImplicitParams({ 
						@ApiImplicitParam(name = "id", value = "主键标识", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "parentId", value = "父主键标识", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "level", value = "层级", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "isDel", value = "是否删除0-否,1-是", required = false, dataType = "Long", paramType = "query"), 
																														@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), 
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") 
	})
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getAreaList")
	public ServiceResponse<List<AreaDTO>> getAreaList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<AreaDTO> areaList = areaService.getAreaList(condition);
		PageInfo<AreaDTO> pageInfo = new PageInfo<AreaDTO>(areaList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存区域
	 * @param areaDTO 区域对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存区域", httpMethod = "POST", notes = "保存区域信息")
	@ApiImplicitParam(name = "areaDTO", value = "区域对象", required = true, dataType = "AreaDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveArea")
	public ServiceResponse<?> saveArea(@RequestBody AreaDTO areaDTO) {
		areaService.saveArea(areaDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新区域
	 * @param areaDTO 区域对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新区域", httpMethod = "POST", notes = "更新区域信息")
	@ApiImplicitParam(name = "areaDTO", value = "区域对象", required = true, dataType = "AreaDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateArea")
	public ServiceResponse<?> updateArea(@RequestBody AreaDTO areaDTO) {
		areaService.updateArea(areaDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据区域标识删除区域
	 * @param id 区域标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据区域标识删除区域", httpMethod = "GET", notes = "根据区域标识删除区域")
	@ApiImplicitParam(name = "id", value = "区域标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteAreaById")
	public ServiceResponse<?> deleteAreaById(@RequestParam(value="id") String id) {
		areaService.deleteAreaById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存区域
	 * @param areaList 区域对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存区域", httpMethod = "POST", notes = "批量保存区域信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveArea")
	public ServiceResponse<?> batchSaveArea(@RequestBody List<AreaDTO> areaList) {
		areaService.batchSaveArea(areaList);
		return ServiceResponse.handleSuccess();
	}
}
