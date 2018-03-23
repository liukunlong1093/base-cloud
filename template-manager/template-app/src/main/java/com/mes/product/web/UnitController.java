package com.mes.product.web;

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
import com.mes.product.dto.UnitDTO;
import com.mes.product.service.UnitService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.product.web]    
  * 类名称:		[UnitController]  
  * 类描述:		[包装单位控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月03日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月03日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/product")
public class UnitController extends BaseController {
	@Autowired
	private UnitService unitService;

	/**
	 * 根据包装单位标识获取包装单位
	 * @param id 包装单位标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据包装单位标识获取包装单位", httpMethod = "GET", notes = "根据包装单位标识获取包装单位详细信息")
	@ApiImplicitParam(name = "id", value = "包装单位标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getUnitById")
	public ServiceResponse<UnitDTO> getUnitById(@RequestParam Long id) {
		UnitDTO  unitDTO = unitService.getUnitById(id);
		return ServiceResponse.handleSuccess(unitDTO);
	}

	/**
	 * 根据条件获取包装单位列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取包装单位列表", httpMethod = "GET", notes = "根据条件获取包装单位列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "单位标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "单位编码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "value", value = "单位值", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "createTime", value = "创建时间", required = false, dataType = "Date", paramType = "query"), @ApiImplicitParam(name = "createBy", value = "创建人", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "createName", value = "创建人名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "updateTime", value = "更新时间", required = false, dataType = "Date", paramType = "query"), @ApiImplicitParam(name = "updateBy", value = "更新人", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "updateName", value = "更新人名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getUnitList")
	public ServiceResponse<List<UnitDTO>> getUnitList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<UnitDTO> unitList = unitService.getUnitList(condition);
		PageInfo<UnitDTO> pageInfo = new PageInfo<UnitDTO>(unitList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存包装单位
	 * @param unitDTO 包装单位对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存包装单位", httpMethod = "POST", notes = "保存包装单位信息")
	@ApiImplicitParam(name = "unitDTO", value = "包装单位对象", required = true, dataType = "UnitDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveUnit")
	public ServiceResponse<?> saveUnit(@RequestBody UnitDTO unitDTO) {
		unitService.saveUnit(unitDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新包装单位
	 * @param unitDTO 包装单位对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新包装单位", httpMethod = "POST", notes = "更新包装单位信息")
	@ApiImplicitParam(name = "unitDTO", value = "包装单位对象", required = true, dataType = "UnitDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateUnit")
	public ServiceResponse<?> updateUnit(@RequestBody UnitDTO unitDTO) {
		unitService.updateUnit(unitDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据包装单位标识删除包装单位
	 * @param id 包装单位标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据包装单位标识删除包装单位", httpMethod = "GET", notes = "根据包装单位标识删除包装单位")
	@ApiImplicitParam(name = "id", value = "包装单位标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteUnitById")
	public ServiceResponse<?> deleteUnitById(@RequestParam(value = "id") Long id) {
		unitService.deleteUnitById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存包装单位
	 * @param unitDAOList 包装单位对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存包装单位", httpMethod = "POST", notes = "批量保存包装单位信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveUnit")
	public ServiceResponse<?> batchSaveUnit(@RequestBody List<UnitDTO> unitList) {
		unitService.batchSaveUnit(unitList);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新包装单位
	 * @param unitDTO 包装单位对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新包装单位", httpMethod = "POST", notes = "更新包装单位信息")
	@ApiImplicitParam(name = "unitDTO", value = "包装单位对象", required = true, dataType = "UnitDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateUnitTest")
	public ServiceResponse<?> updateUnit(@RequestParam(value = "id") Long id, @RequestBody UnitDTO unitDTO) {
		unitService.updateUnit(unitDTO);
		return ServiceResponse.handleSuccess();
	}
}
