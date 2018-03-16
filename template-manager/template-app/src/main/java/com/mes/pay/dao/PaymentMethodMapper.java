package com.mes.pay.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.mes.pay.dto.PaymentMethodDTO;
/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.dao]    
  * 类名称:		[UserMapper]  
  * 类描述:		[支付方式数据映射接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Mapper
public interface PaymentMethodMapper {
	/**
	 * 根据支付方式标识获取支付方式
	 * @param id 支付方式标识
	 * @return 支付方式对象
	 */
	 PaymentMethodDTO getPaymentMethodById(Long id);

	/**
	 * 根据条件获取支付方式列表
	 * @param condition 查询条件
	 * @return 支付方式列表
	 */
	 List<PaymentMethodDTO> getPaymentMethodList(Map<String, Object> condition);

	/**
	 * 保存支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 新增成功条数
	 */
	 long savePaymentMethod(PaymentMethodDTO paymentMethodDTO);

	/**
	 * 更新支付方式
	 * @param paymentMethodDTO 支付方式对象
	 * @return 更新成功条数
	 */
	 long updatePaymentMethod(PaymentMethodDTO paymentMethodDTO);

	/**
	 * 根据支付方式标识删除支付方式
	 * @param id 支付方式标识
	 * @return 删除成功条数
	 */
	 long  deletePaymentMethodById(Long id);

	/**
	 * 批量保存支付方式
	 * @param  paymentMethodList 支付方式数据集合
	 * @return 新增成功条数
	 */
	 long batchSavePaymentMethod(List<PaymentMethodDTO> paymentMethodList);

}
