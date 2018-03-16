package com.mes.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.core.utils.StringUtils;
import com.mes.system.dto.FunctionApiRelDTO;
import com.mes.system.dto.FunctionDTO;
import com.mes.system.manager.FunctionApiRelManager;
import com.mes.system.manager.FunctionManager;
import com.mes.system.service.FunctionService;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.service.impl]    
 * 类名称:		[FunctionServiceImpl]  
 * 类描述:		[系统功能业务处理类]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月21日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月21日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionManager functionManager;

	@Autowired
	private FunctionApiRelManager functionApiRelManager;

	/**
	 * 根据系统功能标识获取系统功能
	 * @param id 系统功能标识
	 * @return 系统功能对象
	 */
	@Override
	public FunctionDTO getFunctionById(Long id) {
		FunctionDTO functionDTO = functionManager.getFunctionById(id);
		return functionDTO;
	}

	/**
	 * 根据条件获取系统功能列表
	 * @param condition 查询条件
	 * @return 系统功能列表
	 */
	@Override
	public List<FunctionDTO> getFunctionList(Map<String, Object> condition) {
		List<FunctionDTO> functionList = functionManager.getFunctionList(condition);
		return functionList;
	}

	/**
	 * 保存系统功能
	 * @param functionDTO 系统功能对象
	 * @return 新增后的系统功能对象
	 */
	@Override
	public FunctionDTO saveFunction(FunctionDTO functionDTO) {
		functionDTO.setCreateTime(new Date());
		functionManager.saveFunction(functionDTO);
		return functionDTO;
	}

	/**
	 * 更新系统功能
	 * @param functionDTO 系统功能对象
	 * @return 更新后的系统功能对象
	 */
	@Override
	public FunctionDTO updateFunction(FunctionDTO functionDTO) {
		functionDTO.setUpdateTime(new Date());
		functionManager.updateFunction(functionDTO);
		return functionDTO;
	}

	/**
	 * 根据系统功能标识删除系统功能
	 * @param id 系统功能标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteFunctionById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				functionManager.deleteFunctionById(StringUtils.getAsLong(idStr, 0L));
			}
		}
		return result;
	}

	/**
	 * 批量保存系统功能
	 * @param  functionList 系统功能数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveFunction(List<FunctionDTO> functionList) {
		long result = 0;
		result = functionManager.batchSaveFunction(functionList);
		return result;
	}

	/**
	 * 根据功能接口关系标识获取功能接口关系
	 * @param id 功能接口关系标识
	 * @return 功能接口关系对象
	 */
	@Override
	public FunctionApiRelDTO getFunctionApiRelById(Long id) {
		FunctionApiRelDTO functionApiRelDTO = functionApiRelManager.getFunctionApiRelById(id);
		return functionApiRelDTO;
	}

	/**
	 * 根据条件获取功能接口关系列表
	 * @param condition 查询条件
	 * @return 功能接口关系列表
	 */
	@Override
	public List<FunctionApiRelDTO> getFunctionApiRelList(Map<String, Object> condition) {
		List<FunctionApiRelDTO> functionApiRelList = functionApiRelManager.getFunctionApiRelList(condition);
		return functionApiRelList;
	}

	/**
	 * 保存功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 新增后的功能接口关系对象
	 */
	@Override
	public FunctionApiRelDTO saveFunctionApiRel(FunctionApiRelDTO functionApiRelDTO) {
		functionApiRelDTO.setCreateTime(new Date());
		functionApiRelManager.saveFunctionApiRel(functionApiRelDTO);
		return functionApiRelDTO;
	}

	/**
	 * 更新功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 更新后的功能接口关系对象
	 */
	@Override
	public FunctionApiRelDTO updateFunctionApiRel(FunctionApiRelDTO functionApiRelDTO) {
		functionApiRelDTO.setUpdateTime(new Date());
		functionApiRelManager.updateFunctionApiRel(functionApiRelDTO);
		return functionApiRelDTO;
	}

	/**
	 * 根据功能接口关系标识删除功能接口关系
	 * @param id 功能接口关系标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteFunctionApiRelById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				functionApiRelManager.deleteFunctionApiRelById(StringUtils.getAsLong(idStr, 0L));
			}
		}
		return result;
	}

	/**
	 * 批量保存功能接口关系
	 * @param  functionApiRelList 功能接口关系数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveFunctionApiRel(List<FunctionApiRelDTO> functionApiRelList) {
		long result = 0;
		result = functionApiRelManager.batchSaveFunctionApiRel(functionApiRelList);
		return result;
	}

}