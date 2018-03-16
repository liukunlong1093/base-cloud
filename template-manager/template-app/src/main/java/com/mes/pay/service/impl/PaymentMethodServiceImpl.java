package com.mes.pay.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.pay.dto.PaymentMethodDTO;
import com.mes.pay.manager.PaymentMethodManager;
import com.mes.pay.service.PaymentMethodService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.service.impl]    
  * 类名称:		[PaymentMethodServiceImpl]  
  * 类描述:		[支付方式业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("paymentMethodService")
public class PaymentMethodServiceImpl implements PaymentMethodService {
	@Autowired
	private PaymentMethodManager paymentMethodManager;
	
	/**
	 * 根据支付方式标识获取支付方式
	 * @param id 支付方式标识
	 * @return 支付方式对象
	 */
	@Override
	public PaymentMethodDTO getPaymentMethodById(Long id){
		PaymentMethodDTO paymentMethodDTO = paymentMethodManager.getPaymentMethodById(id);
		return paymentMethodDTO;
	}
	

	/**
	 * 根据条件获取支付方式列表
	 * @param condition 查询条件
	 * @return 支付方式列表
	 */
	@Override
	public List<PaymentMethodDTO> getPaymentMethodList(Map<String, Object> condition){
		List<PaymentMethodDTO> paymentMethodList = paymentMethodManager.getPaymentMethodList(condition);
		return paymentMethodList;
	}

	/**
	 * 保存支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 新增后的支付方式对象
	 */
	@Override
	public PaymentMethodDTO savePaymentMethod(PaymentMethodDTO paymentMethodDTO){
	    paymentMethodDTO.setCreateTime(new Date());
		paymentMethodManager.savePaymentMethod(paymentMethodDTO);
		return paymentMethodDTO;
	}
	
	/**
	 * 更新支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 更新后的支付方式对象
	 */
	@Override
	public PaymentMethodDTO updatePaymentMethod(PaymentMethodDTO paymentMethodDTO){
		paymentMethodDTO.setUpdateTime(new Date());
		paymentMethodManager.updatePaymentMethod(paymentMethodDTO);
		return paymentMethodDTO;
	}


	/**
	 * 根据支付方式标识删除支付方式
	 * @param id 支付方式标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deletePaymentMethodById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				paymentMethodManager.deletePaymentMethodById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存支付方式
	 * @param  paymentMethodList 支付方式数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePaymentMethod(List<PaymentMethodDTO> paymentMethodList){
		long result = 0;
		result = paymentMethodManager.batchSavePaymentMethod(paymentMethodList);
		return result;
	}

	

}