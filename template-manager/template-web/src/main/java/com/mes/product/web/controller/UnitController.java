package com.mes.product.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.product.dto.UnitDTO;
import com.mes.product.service.UnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.product.web.controller]    
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
@Api(value = "unitController", description = "包装单位管理")
public class UnitController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	UnitService unitService;

	/**
	 * 根据包装单位标识获取包装单位
	 * @param id 包装单位标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据包装单位标识获取包装单位", httpMethod = "GET", notes = "根据包装单位标识获取包装单位详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "包装单位标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = ServiceResponse.class) })
	@RequestMapping("/getUnitById")
	public ServiceResponse<UnitDTO> getUnitById(@RequestParam Long id) {
		System.out.println(request.getHeader("token"));
		return unitService.getUnitById(id);
	}

	/**
	 * 根据条件获取包装单位列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取包装单位列表", httpMethod = "GET", notes = "根据条件获取包装单位列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "单位标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "单位编码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "value", value = "单位值", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "createTime", value = "创建时间", required = false, dataType = "Date", paramType = "query"), @ApiImplicitParam(name = "createBy", value = "创建人", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "createName", value = "创建人名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "updateTime", value = "更新时间", required = false, dataType = "Date", paramType = "query"), @ApiImplicitParam(name = "updateBy", value = "更新人", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "updateName", value = "更新人名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@RequestMapping("/getUnitList")
	public ServiceResponse<List<UnitDTO>> getUnitList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return unitService.getUnitList(condition);
	}

	/**
	 * 保存包装单位
	 * @param unitDTO 包装单位数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存包装单位", httpMethod = "POST", notes = "保存包装单位信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "unitDTO", value = "包装单位数据传输对象", required = true, dataType = "UnitDTO", paramType = "body") })
	@RequestMapping("/saveUnit")
	public ServiceResponse<?> saveUnit(@RequestBody UnitDTO unitDTO) {
		return unitService.saveUnit(unitDTO);
	}

	/**
	 * 更新包装单位
	 * @param unitDTO 包装单位数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新包装单位", httpMethod = "POST", notes = "更新包装单位信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "unitDTO", value = "包装单位数据传输对象", required = true, dataType = "UnitDTO", paramType = "body") })
	@RequestMapping("/updateUnit")
	public ServiceResponse<?> updateUnit(@RequestBody UnitDTO unitDTO) {
		return unitService.updateUnit(unitDTO);
	}

	/**
	 * 根据包装单位标识删除包装单位
	 * @param id 包装单位标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据包装单位标识删除包装单位", httpMethod = "GET", notes = "根据包装单位标识删除包装单位")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "包装单位标识", required = true, dataType = "String", paramType = "query") })
	@RequestMapping("/deleteUnitById")
	public ServiceResponse<?> deleteUnitById(@RequestParam Long id) {
		return unitService.deleteUnitById(id);
	}

	/**
	 * 批量保存包装单位
	 * @param unitDAOList 包装单位数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存包装单位", httpMethod = "POST", notes = "批量保存包装单位")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header")})
	@RequestMapping("/batchSaveUnit")
	public ServiceResponse<?> batchSaveUnit(@RequestBody List<UnitDTO> userDAOList) {
		return unitService.batchSaveUnit(userDAOList);
	}
}
