package com.mes.pay.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.pay.dto.PaymentTypeDTO;
import com.mes.pay.service.fallback.PaymentTypeServiceFallback;

/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.service]    
  * 类名称:		[PaymentTypeService]  
  * 类描述:		[支付类型业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = PaymentTypeServiceFallback.class)
public interface PaymentTypeService {

	/**
	 * 根据支付类型标识获取支付类型
	 * @param id 支付类型标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentType/getPaymentTypeById")
	ServiceResponse<PaymentTypeDTO> getPaymentTypeById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取支付类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentType/getPaymentTypeList")
	ServiceResponse<List<PaymentTypeDTO>> getPaymentTypeList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentType/savePaymentType")
	ServiceResponse<?> savePaymentType(@RequestBody PaymentTypeDTO paymentTypeDTO);

	/**
	 * 更新支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentType/updatePaymentType")
	ServiceResponse<?> updatePaymentType(@RequestBody PaymentTypeDTO paymentTypeDTO);

	/**
	 * 根据支付类型标识删除支付类型
	 * @param id 支付类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentType/deletePaymentTypeById")
	ServiceResponse<?> deletePaymentTypeById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存支付类型
	 * @param paymentTypeList 支付类型对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/paymentType/batchSavePaymentType")
	ServiceResponse<?> batchSavePaymentType(@RequestBody List<PaymentTypeDTO> paymentTypeList);
}
