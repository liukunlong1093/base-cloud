package com.mes.system.service;

import java.util.List;
import java.util.Map;

import com.mes.system.dto.FunctionApiRelDTO;
import com.mes.system.dto.FunctionDTO;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[FunctionService]  
  * 类描述:		[系统功能业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface FunctionService {
	/**
	 * 根据系统功能标识获取系统功能
	 * @param id 系统功能标识
	 * @return 系统功能对象
	 */
	FunctionDTO getFunctionById(Long id);

	/**
	 * 根据条件获取系统功能列表
	 * @param condition 查询条件
	 * @return 系统功能列表
	 */
	List<FunctionDTO> getFunctionList(Map<String, Object> condition);

	/**
	 * 保存系统功能
	 * @param functionDTO 系统功能对象
	 * @return 新增后的系统功能对象
	 */
	FunctionDTO saveFunction(FunctionDTO functionDTO);

	/**
	 * 更新系统功能
	 * @param functionDTO 系统功能对象
	 * @return 更新后的系统功能对象
	 */
	FunctionDTO updateFunction(FunctionDTO functionDTO);

	/**
	 * 根据系统功能标识删除系统功能
	 * @param id 系统功能标识
	 * @return 删除成功条数
	 */
	long deleteFunctionById(String id);

	/**
	 * 批量保存系统功能
	 * @param  functionList 系统功能数据集合
	 * @return 新增成功条数
	 */
	long batchSaveFunction(List<FunctionDTO> functionList);

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
	 * @return 新增后的功能接口关系对象
	 */
	FunctionApiRelDTO saveFunctionApiRel(FunctionApiRelDTO functionApiRelDTO);

	/**
	 * 更新功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 更新后的功能接口关系对象
	 */
	FunctionApiRelDTO updateFunctionApiRel(FunctionApiRelDTO functionApiRelDTO);

	/**
	 * 根据功能接口关系标识删除功能接口关系
	 * @param id 功能接口关系标识
	 * @return 删除成功条数
	 */
	long deleteFunctionApiRelById(String id);

	/**
	 * 批量保存功能接口关系
	 * @param  functionApiRelList 功能接口关系数据集合
	 * @return 新增成功条数
	 */
	long batchSaveFunctionApiRel(List<FunctionApiRelDTO> functionApiRelList);
}
