package com.mes.pay.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.pay.manager.PaymentMethodManager;
import com.mes.pay.dao.PaymentMethodMapper;
import com.mes.pay.dto.PaymentMethodDTO;
/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.manager.impl]    
  * 类名称:		[PaymentMethodManagerImpl]  
  * 类描述:		[支付方式管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("paymentMethodManager")
public class PaymentMethodManagerImpl implements PaymentMethodManager {
	@Autowired
	private PaymentMethodMapper paymentMethodMapper;


	/**
	 * 根据支付方式标识获取支付方式
	 * @param id 支付方式标识
	 * @return 支付方式对象
	 */
	@Override
	public PaymentMethodDTO getPaymentMethodById(Long id){
		return paymentMethodMapper.getPaymentMethodById(id);
	}

	/**
	 * 根据条件获取支付方式列表
	 * @param condition 查询条件
	 * @return 支付方式列表
	 */
	@Override
	public List<PaymentMethodDTO> getPaymentMethodList(Map<String, Object> condition){
		return paymentMethodMapper.getPaymentMethodList(condition);
	}

	/**
	 * 保存支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 新增成功条数
	 */
	@Override
	public long savePaymentMethod(PaymentMethodDTO paymentMethodDTO){
		return paymentMethodMapper.savePaymentMethod(paymentMethodDTO);
	}

	/**
	 * 更新支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 更新成功条数
	 */
	@Override
	public long updatePaymentMethod(PaymentMethodDTO paymentMethodDTO){
		return paymentMethodMapper.updatePaymentMethod(paymentMethodDTO);
	}

	/**
	 * 根据支付方式标识删除支付方式
	 * @param id 支付方式标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deletePaymentMethodById(Long id){
		return paymentMethodMapper.deletePaymentMethodById(id);
	}

	/**
	 * 批量保存支付方式
	 * @param  paymentMethodList 支付方式数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePaymentMethod(List<PaymentMethodDTO> paymentMethodList){
		return paymentMethodMapper.batchSavePaymentMethod(paymentMethodList);
	}
}
