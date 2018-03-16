package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.FunctionApiRelManager;
import com.mes.system.dao.FunctionApiRelMapper;
import com.mes.system.dto.FunctionApiRelDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[FunctionApiRelManagerImpl]  
  * 类描述:		[功能接口关系管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("functionApiRelManager")
public class FunctionApiRelManagerImpl implements FunctionApiRelManager {
	@Autowired
	private FunctionApiRelMapper functionApiRelMapper;


	/**
	 * 根据功能接口关系标识获取功能接口关系
	 * @param id 功能接口关系标识
	 * @return 功能接口关系对象
	 */
	@Override
	public FunctionApiRelDTO getFunctionApiRelById(Long id){
		return functionApiRelMapper.getFunctionApiRelById(id);
	}

	/**
	 * 根据条件获取功能接口关系列表
	 * @param condition 查询条件
	 * @return 功能接口关系列表
	 */
	@Override
	public List<FunctionApiRelDTO> getFunctionApiRelList(Map<String, Object> condition){
		return functionApiRelMapper.getFunctionApiRelList(condition);
	}

	/**
	 * 保存功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveFunctionApiRel(FunctionApiRelDTO functionApiRelDTO){
		return functionApiRelMapper.saveFunctionApiRel(functionApiRelDTO);
	}

	/**
	 * 更新功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateFunctionApiRel(FunctionApiRelDTO functionApiRelDTO){
		return functionApiRelMapper.updateFunctionApiRel(functionApiRelDTO);
	}

	/**
	 * 根据功能接口关系标识删除功能接口关系
	 * @param id 功能接口关系标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteFunctionApiRelById(Long id){
		return functionApiRelMapper.deleteFunctionApiRelById(id);
	}

	/**
	 * 批量保存功能接口关系
	 * @param  functionApiRelList 功能接口关系数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveFunctionApiRel(List<FunctionApiRelDTO> functionApiRelList){
		return functionApiRelMapper.batchSaveFunctionApiRel(functionApiRelList);
	}
}
