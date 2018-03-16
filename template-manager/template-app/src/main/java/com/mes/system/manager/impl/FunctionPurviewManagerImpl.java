package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.FunctionPurviewManager;
import com.mes.system.dao.FunctionPurviewMapper;
import com.mes.system.dto.FunctionPurviewDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[FunctionPurviewManagerImpl]  
  * 类描述:		[功能权限管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("functionPurviewManager")
public class FunctionPurviewManagerImpl implements FunctionPurviewManager {
	@Autowired
	private FunctionPurviewMapper functionPurviewMapper;


	/**
	 * 根据功能权限标识获取功能权限
	 * @param id 功能权限标识
	 * @return 功能权限对象
	 */
	@Override
	public FunctionPurviewDTO getFunctionPurviewById(Long id){
		return functionPurviewMapper.getFunctionPurviewById(id);
	}

	/**
	 * 根据条件获取功能权限列表
	 * @param condition 查询条件
	 * @return 功能权限列表
	 */
	@Override
	public List<FunctionPurviewDTO> getFunctionPurviewList(Map<String, Object> condition){
		return functionPurviewMapper.getFunctionPurviewList(condition);
	}

	/**
	 * 保存功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveFunctionPurview(FunctionPurviewDTO functionPurviewDTO){
		return functionPurviewMapper.saveFunctionPurview(functionPurviewDTO);
	}

	/**
	 * 更新功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateFunctionPurview(FunctionPurviewDTO functionPurviewDTO){
		return functionPurviewMapper.updateFunctionPurview(functionPurviewDTO);
	}

	/**
	 * 根据功能权限标识删除功能权限
	 * @param id 功能权限标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteFunctionPurviewById(Long id){
		return functionPurviewMapper.deleteFunctionPurviewById(id);
	}

	/**
	 * 批量保存功能权限
	 * @param  functionPurviewList 功能权限数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveFunctionPurview(List<FunctionPurviewDTO> functionPurviewList){
		return functionPurviewMapper.batchSaveFunctionPurview(functionPurviewList);
	}
	
	/**
	 * 根据权限对象标识删除功能权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	@Override
	public long deleteFunctionPurviewBySecId(String secId){
		return functionPurviewMapper.deleteFunctionPurviewBySecId(secId);
	}
}
