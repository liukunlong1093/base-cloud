package com.mes.pay.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.pay.dto.PaymentMethodDTO;
import com.mes.pay.service.PaymentMethodService;
/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.service.fallback]    
  * 类名称:		[PaymentMethodServiceFallback]  
  * 类描述:		[支付方式业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class PaymentMethodServiceFallback implements PaymentMethodService {
/**
	 * 根据支付方式标识获取支付方式
	 * @param id 支付方式标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<PaymentMethodDTO> getPaymentMethodById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据支付方式标识获取支付方式服务不可用.");
	}

	/**
	 * 根据条件获取支付方式列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<PaymentMethodDTO>> getPaymentMethodList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取支付方式列表服务不可用.");
	}

	/**
	 * 保存支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> savePaymentMethod(PaymentMethodDTO paymentMethodDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存支付方式服务不可用.");
	}
	
	/**
	 * 更新支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updatePaymentMethod(PaymentMethodDTO paymentMethodDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新支付方式服务不可用.");
	}

	/**
	 * 根据支付方式标识删除支付方式
	 * @param id 支付方式标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deletePaymentMethodById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据支付方式标识删除支付方式服务不可用.");
	}

	/**
	 * 批量保存支付方式
	 * @param paymentMethodDAOList 支付方式对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSavePaymentMethod(List<PaymentMethodDTO> paymentMethodList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存支付方式服务不可用.");
	 }
}
