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
import com.mes.pay.dto.PaymentMethodDTO;
import com.mes.pay.service.PaymentMethodService;

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
  * 类名称:		[PaymentMethodController]  
  * 类描述:		[支付方式控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/paymentMethod")
@Api(value = "paymentMethodController", description = "支付方式管理")
public class PaymentMethodController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	PaymentMethodService paymentMethodService;

	/**
	 * 根据支付方式标识获取支付方式
	 * @param id 支付方式标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据支付方式标识获取支付方式", httpMethod = "GET", notes = "根据支付方式标识获取支付方式详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "支付方式标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPaymentMethodById")
	public ServiceResponse<PaymentMethodDTO> getPaymentMethodById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return paymentMethodService.getPaymentMethodById(id);
	}

	/**
	 * 根据条件获取支付方式列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取支付方式列表", httpMethod = "GET", notes = "根据条件获取支付方式列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "支付方式标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "支付接口编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "payTypeId", value = "支付类型标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "payTypeName", value = "支付类型名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "aliases", value = "支付方式别名", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "name", value = "支付方式名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "comment", value = "支付方式说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "logo", value = "支付方式logo", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "configInfo", value = "参数信息(json格式)", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "isHidden", value = "是否隐藏", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPaymentMethodList")
	public ServiceResponse<List<PaymentMethodDTO>> getPaymentMethodList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return paymentMethodService.getPaymentMethodList(condition);
	}

	/**
	 * 保存支付方式
	 * @param paymentMethodDTO 支付方式数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存支付方式", httpMethod = "POST", notes = "保存支付方式信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "paymentMethodDTO", value = "支付方式数据传输对象", required = true, dataType = "PaymentMethodDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/savePaymentMethod")
	public ServiceResponse<?> savePaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) {
		return paymentMethodService.savePaymentMethod(paymentMethodDTO);
	}

	/**
	 * 更新支付方式
	 * @param paymentMethodDTO 支付方式数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新支付方式", httpMethod = "POST", notes = "更新支付方式信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "paymentMethodDTO", value = "支付方式数据传输对象", required = true, dataType = "PaymentMethodDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updatePaymentMethod")
	public ServiceResponse<?> updatePaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) {
		return paymentMethodService.updatePaymentMethod(paymentMethodDTO);
	}

	/**
	 * 根据支付方式标识删除支付方式
	 * @param id 支付方式标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据支付方式标识删除支付方式", httpMethod = "GET", notes = "根据支付方式标识删除支付方式")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "支付方式标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deletePaymentMethodById")
	public ServiceResponse<?> deletePaymentMethodById(@RequestParam(value = "id") String id) {
		return paymentMethodService.deletePaymentMethodById(id);
	}

	/**
	 * 批量保存支付方式
	 * @param paymentMethodDAOList 支付方式数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存支付方式", httpMethod = "POST", notes = "批量保存支付方式")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "支付方式数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSavePaymentMethod")
	public ServiceResponse<?> batchSavePaymentMethod(@RequestBody List<PaymentMethodDTO> paymentMethodList) {
		return paymentMethodService.batchSavePaymentMethod(paymentMethodList);
	}
}
