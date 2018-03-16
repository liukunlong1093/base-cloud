package com.mes.system.manager;
import java.util.*;
import com.mes.system.dto.FunctionApiRelDTO;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager]    
  * 类名称:		[FunctionApiRelManager]  
  * 类描述:		[功能接口关系管理处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface FunctionApiRelManager {
	/**
	 * 根据功能接口关系标识获取功能接口关系
	 * @param id 功能接口关系标识
	 * @return 功能接口关系对象
	 */
	 FunctionApiRelDTO getFunctionApiRelById(Long id);

	/**
	 * 根据条件获取功能接口关系列表
	 * @param condition 查询条件
	 * @return 功能接口关系列表
	 */
	 List<FunctionApiRelDTO> getFunctionApiRelList(Map<String, Object> condition);

	/**
	 * 保存功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 新增成功条数
	 */
	 long saveFunctionApiRel(FunctionApiRelDTO functionApiRelDTO);

	/**
	 * 更新功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 更新成功条数
	 */
	 long updateFunctionApiRel(FunctionApiRelDTO functionApiRelDTO);

	/**
	 * 根据功能接口关系标识删除功能接口关系
	 * @param id 功能接口关系标识
	 * @return 删除成功条数
	 */
	 long  deleteFunctionApiRelById(Long id);

	/**
	 * 批量保存功能接口关系
	 * @param  functionApiRelList 功能接口关系数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveFunctionApiRel(List<FunctionApiRelDTO> functionApiRelList);
}
