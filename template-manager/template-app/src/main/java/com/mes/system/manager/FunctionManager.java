package com.mes.system.manager;
import java.util.*;
import com.mes.system.dto.FunctionDTO;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager]    
  * 类名称:		[FunctionManager]  
  * 类描述:		[系统功能管理处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface FunctionManager {
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
	 * @return 新增成功条数
	 */
	 long saveFunction(FunctionDTO functionDTO);

	/**
	 * 更新系统功能
	 * @param functionDTO 系统功能对象
	 * @return 更新成功条数
	 */
	 long updateFunction(FunctionDTO functionDTO);

	/**
	 * 根据系统功能标识删除系统功能
	 * @param id 系统功能标识
	 * @return 删除成功条数
	 */
	 long  deleteFunctionById(Long id);

	/**
	 * 批量保存系统功能
	 * @param  functionList 系统功能数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveFunction(List<FunctionDTO> functionList);
}
