package com.mes.pay.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.pay.dto.PaymentTypeDTO;
import com.mes.pay.manager.PaymentTypeManager;
import com.mes.pay.service.PaymentTypeService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.service.impl]    
  * 类名称:		[PaymentTypeServiceImpl]  
  * 类描述:		[支付类型业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("paymentTypeService")
public class PaymentTypeServiceImpl implements PaymentTypeService {
	@Autowired
	private PaymentTypeManager paymentTypeManager;
	
	/**
	 * 根据支付类型标识获取支付类型
	 * @param id 支付类型标识
	 * @return 支付类型对象
	 */
	@Override
	public PaymentTypeDTO getPaymentTypeById(Long id){
		PaymentTypeDTO paymentTypeDTO = paymentTypeManager.getPaymentTypeById(id);
		return paymentTypeDTO;
	}
	

	/**
	 * 根据条件获取支付类型列表
	 * @param condition 查询条件
	 * @return 支付类型列表
	 */
	@Override
	public List<PaymentTypeDTO> getPaymentTypeList(Map<String, Object> condition){
		List<PaymentTypeDTO> paymentTypeList = paymentTypeManager.getPaymentTypeList(condition);
		return paymentTypeList;
	}

	/**
	 * 保存支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 新增后的支付类型对象
	 */
	@Override
	public PaymentTypeDTO savePaymentType(PaymentTypeDTO paymentTypeDTO){
	    paymentTypeDTO.setCreateTime(new Date());
		paymentTypeManager.savePaymentType(paymentTypeDTO);
		return paymentTypeDTO;
	}
	
	/**
	 * 更新支付类型
	 * @param paymentTypeDTO 支付类型对象
	 * @return 更新后的支付类型对象
	 */
	@Override
	public PaymentTypeDTO updatePaymentType(PaymentTypeDTO paymentTypeDTO){
		paymentTypeDTO.setUpdateTime(new Date());
		paymentTypeManager.updatePaymentType(paymentTypeDTO);
		return paymentTypeDTO;
	}


	/**
	 * 根据支付类型标识删除支付类型
	 * @param id 支付类型标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deletePaymentTypeById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				paymentTypeManager.deletePaymentTypeById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存支付类型
	 * @param  paymentTypeList 支付类型数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePaymentType(List<PaymentTypeDTO> paymentTypeList){
		long result = 0;
		result = paymentTypeManager.batchSavePaymentType(paymentTypeList);
		return result;
	}

	

}