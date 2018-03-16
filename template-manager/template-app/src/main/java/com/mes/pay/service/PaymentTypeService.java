package com.mes.pay.service;

import java.util.*;
import com.mes.pay.dto.PaymentTypeDTO;
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
public interface PaymentTypeService {
	/**
	 * 根据支付类型标识获取支付类型
	 * @param id 支付类型标识
	 * @return 支付类型对象
	 */
	 PaymentTypeDTO getPaymentTypeById(Long id);
	

	/**
	 * 根据条件获取支付类型列表
	 * @param condition 查询条件
	 * @return 支付类型列表
	 */
	 List<PaymentTypeDTO> getPaymentTypeList(Map<String, Object> condition);

	/**
	 * 保存支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 新增后的支付类型对象
	 */
	 PaymentTypeDTO savePaymentType(PaymentTypeDTO paymentTypeDTO);
	
	/**
	 * 更新支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 更新后的支付类型对象
	 */
	 PaymentTypeDTO updatePaymentType(PaymentTypeDTO paymentTypeDTO);


	/**
	 * 根据支付类型标识删除支付类型
	 * @param id 支付类型标识
	 * @return 删除成功条数
	 */
	 long  deletePaymentTypeById(String id);
	

	/**
	 * 批量保存支付类型
	 * @param  paymentTypeList 支付类型数据集合
	 * @return 新增成功条数
	 */
	 long batchSavePaymentType(List<PaymentTypeDTO> paymentTypeList);
}
