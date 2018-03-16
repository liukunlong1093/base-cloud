package com.mes.pay.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.pay.dto.PaymentTypeDTO;
import com.mes.pay.service.PaymentTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.web.controller]    
  * 类名称:		[PaymentTypeController]  
  * 类描述:		[支付类型控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/paymentType")
@Api(value = "paymentTypeController", description = "支付类型管理")
public class PaymentTypeController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	PaymentTypeService paymentTypeService;

	/**
	 * 根据支付类型标识获取支付类型
	 * @param id 支付类型标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据支付类型标识获取支付类型", httpMethod = "GET", notes = "根据支付类型标识获取支付类型详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "支付类型标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPaymentTypeById")
	public ServiceResponse<PaymentTypeDTO> getPaymentTypeById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return paymentTypeService.getPaymentTypeById(id);
	}

	/**
	 * 根据条件获取支付类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取支付类型列表", httpMethod = "GET", notes = "根据条件获取支付类型列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "支付类型标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "name", value = "", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "type", value = "0 PC,1手机", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isHidden", value = "是否隐藏", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "comment", value = "备注说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPaymentTypeList")
	public ServiceResponse<List<PaymentTypeDTO>> getPaymentTypeList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return paymentTypeService.getPaymentTypeList(condition);
	}

	/**
	 * 保存支付类型
	 * @param paymentTypeDTO 支付类型数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存支付类型", httpMethod = "POST", notes = "保存支付类型信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "paymentTypeDTO", value = "支付类型数据传输对象", required = true, dataType = "PaymentTypeDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/savePaymentType")
	public ServiceResponse<?> savePaymentType(@RequestBody PaymentTypeDTO paymentTypeDTO) {
		return paymentTypeService.savePaymentType(paymentTypeDTO);
	}

	/**
	 * 更新支付类型
	 * @param paymentTypeDTO 支付类型数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新支付类型", httpMethod = "POST", notes = "更新支付类型信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "paymentTypeDTO", value = "支付类型数据传输对象", required = true, dataType = "PaymentTypeDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updatePaymentType")
	public ServiceResponse<?> updatePaymentType(@RequestBody PaymentTypeDTO paymentTypeDTO) {
		return paymentTypeService.updatePaymentType(paymentTypeDTO);
	}

	/**
	 * 根据支付类型标识删除支付类型
	 * @param id 支付类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据支付类型标识删除支付类型", httpMethod = "GET", notes = "根据支付类型标识删除支付类型")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "支付类型标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deletePaymentTypeById")
	public ServiceResponse<?> deletePaymentTypeById(@RequestParam(value = "id") String id) {
		return paymentTypeService.deletePaymentTypeById(id);
	}

	/**
	 * 批量保存支付类型
	 * @param paymentTypeDAOList 支付类型数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存支付类型", httpMethod = "POST", notes = "批量保存支付类型")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "支付类型数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSavePaymentType")
	public ServiceResponse<?> batchSavePaymentType(@RequestBody List<PaymentTypeDTO> paymentTypeList) {
		return paymentTypeService.batchSavePaymentType(paymentTypeList);
	}
}
