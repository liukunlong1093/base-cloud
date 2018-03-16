package com.mes.pay.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.pay.manager.PaymentTypeManager;
import com.mes.pay.dao.PaymentTypeMapper;
import com.mes.pay.dto.PaymentTypeDTO;
/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.manager.impl]    
  * 类名称:		[PaymentTypeManagerImpl]  
  * 类描述:		[支付类型管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("paymentTypeManager")
public class PaymentTypeManagerImpl implements PaymentTypeManager {
	@Autowired
	private PaymentTypeMapper paymentTypeMapper;


	/**
	 * 根据支付类型标识获取支付类型
	 * @param id 支付类型标识
	 * @return 支付类型对象
	 */
	@Override
	public PaymentTypeDTO getPaymentTypeById(Long id){
		return paymentTypeMapper.getPaymentTypeById(id);
	}

	/**
	 * 根据条件获取支付类型列表
	 * @param condition 查询条件
	 * @return 支付类型列表
	 */
	@Override
	public List<PaymentTypeDTO> getPaymentTypeList(Map<String, Object> condition){
		return paymentTypeMapper.getPaymentTypeList(condition);
	}

	/**
	 * 保存支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 新增成功条数
	 */
	@Override
	public long savePaymentType(PaymentTypeDTO paymentTypeDTO){
		return paymentTypeMapper.savePaymentType(paymentTypeDTO);
	}

	/**
	 * 更新支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 更新成功条数
	 */
	@Override
	public long updatePaymentType(PaymentTypeDTO paymentTypeDTO){
		return paymentTypeMapper.updatePaymentType(paymentTypeDTO);
	}

	/**
	 * 根据支付类型标识删除支付类型
	 * @param id 支付类型标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deletePaymentTypeById(Long id){
		return paymentTypeMapper.deletePaymentTypeById(id);
	}

	/**
	 * 批量保存支付类型
	 * @param  paymentTypeList 支付类型数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePaymentType(List<PaymentTypeDTO> paymentTypeList){
		return paymentTypeMapper.batchSavePaymentType(paymentTypeList);
	}
}
