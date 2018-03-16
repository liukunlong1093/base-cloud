package com.mes.system.service;

import java.util.*;
import com.mes.system.dto.OperateTypeDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[OperateTypeService]  
  * 类描述:		[权限操作类型业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface OperateTypeService {
	/**
	 * 根据权限操作类型标识获取权限操作类型
	 * @param id 权限操作类型标识
	 * @return 权限操作类型对象
	 */
	 OperateTypeDTO getOperateTypeById(Long id);
	

	/**
	 * 根据条件获取权限操作类型列表
	 * @param condition 查询条件
	 * @return 权限操作类型列表
	 */
	 List<OperateTypeDTO> getOperateTypeList(Map<String, Object> condition);

	/**
	 * 保存权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 新增后的权限操作类型对象
	 */
	 OperateTypeDTO saveOperateType(OperateTypeDTO operateTypeDTO);
	
	/**
	 * 更新权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 更新后的权限操作类型对象
	 */
	 OperateTypeDTO updateOperateType(OperateTypeDTO operateTypeDTO);


	/**
	 * 根据权限操作类型标识删除权限操作类型
	 * @param id 权限操作类型标识
	 * @return 删除成功条数
	 */
	 long  deleteOperateTypeById(String id);
	

	/**
	 * 批量保存权限操作类型
	 * @param  operateTypeList 权限操作类型数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveOperateType(List<OperateTypeDTO> operateTypeList);
}
