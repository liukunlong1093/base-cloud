package com.mes.pay.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.pay.dto.PaymentTypeDTO;
import com.mes.pay.service.PaymentTypeService;
/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.service.fallback]    
  * 类名称:		[PaymentTypeServiceFallback]  
  * 类描述:		[支付类型业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class PaymentTypeServiceFallback implements PaymentTypeService {
/**
	 * 根据支付类型标识获取支付类型
	 * @param id 支付类型标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<PaymentTypeDTO> getPaymentTypeById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据支付类型标识获取支付类型服务不可用.");
	}

	/**
	 * 根据条件获取支付类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<PaymentTypeDTO>> getPaymentTypeList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取支付类型列表服务不可用.");
	}

	/**
	 * 保存支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> savePaymentType(PaymentTypeDTO paymentTypeDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存支付类型服务不可用.");
	}
	
	/**
	 * 更新支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updatePaymentType(PaymentTypeDTO paymentTypeDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新支付类型服务不可用.");
	}

	/**
	 * 根据支付类型标识删除支付类型
	 * @param id 支付类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deletePaymentTypeById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据支付类型标识删除支付类型服务不可用.");
	}

	/**
	 * 批量保存支付类型
	 * @param paymentTypeDAOList 支付类型对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSavePaymentType(List<PaymentTypeDTO> paymentTypeList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存支付类型服务不可用.");
	 }
}
