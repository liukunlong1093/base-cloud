package com.mes.system.manager;

import java.util.*;
import com.mes.system.dto.FunctionPurviewDTO;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.manager]    
 * 类名称:		[FunctionPurviewManager]  
 * 类描述:		[功能权限管理处理接口]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月21日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月21日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
public interface FunctionPurviewManager {
	/**
	 * 根据功能权限标识获取功能权限
	 * @param id 功能权限标识
	 * @return 功能权限对象
	 */
	FunctionPurviewDTO getFunctionPurviewById(Long id);

	/**
	 * 根据条件获取功能权限列表
	 * @param condition 查询条件
	 * @return 功能权限列表
	 */
	List<FunctionPurviewDTO> getFunctionPurviewList(Map<String, Object> condition);

	/**
	 * 保存功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 新增成功条数
	 */
	long saveFunctionPurview(FunctionPurviewDTO functionPurviewDTO);

	/**
	 * 更新功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 更新成功条数
	 */
	long updateFunctionPurview(FunctionPurviewDTO functionPurviewDTO);

	/**
	 * 根据功能权限标识删除功能权限
	 * @param id 功能权限标识
	 * @return 删除成功条数
	 */
	long deleteFunctionPurviewById(Long id);

	/**
	 * 批量保存功能权限
	 * @param  functionPurviewList 功能权限数据集合
	 * @return 新增成功条数
	 */
	long batchSaveFunctionPurview(List<FunctionPurviewDTO> functionPurviewList);

	/**
	 * 根据权限对象标识删除功能权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	long deleteFunctionPurviewBySecId(String secId);
}
