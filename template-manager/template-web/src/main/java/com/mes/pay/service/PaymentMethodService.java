package com.mes.pay.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.pay.dto.PaymentMethodDTO;
import com.mes.pay.service.fallback.PaymentMethodServiceFallback;

/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.service]    
  * 类名称:		[PaymentMethodService]  
  * 类描述:		[支付方式业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = PaymentMethodServiceFallback.class)
public interface PaymentMethodService {

	/**
	 * 根据支付方式标识获取支付方式
	 * @param id 支付方式标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentMethod/getPaymentMethodById")
	ServiceResponse<PaymentMethodDTO> getPaymentMethodById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取支付方式列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentMethod/getPaymentMethodList")
	ServiceResponse<List<PaymentMethodDTO>> getPaymentMethodList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentMethod/savePaymentMethod")
	ServiceResponse<?> savePaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO);

	/**
	 * 更新支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentMethod/updatePaymentMethod")
	ServiceResponse<?> updatePaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO);

	/**
	 * 根据支付方式标识删除支付方式
	 * @param id 支付方式标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentMethod/deletePaymentMethodById")
	ServiceResponse<?> deletePaymentMethodById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存支付方式
	 * @param paymentMethodList 支付方式对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentMethod/batchSavePaymentMethod")
	ServiceResponse<?> batchSavePaymentMethod(@RequestBody List<PaymentMethodDTO> paymentMethodList);
}
