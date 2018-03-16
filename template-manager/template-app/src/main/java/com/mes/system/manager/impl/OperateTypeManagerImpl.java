package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.OperateTypeManager;
import com.mes.system.dao.OperateTypeMapper;
import com.mes.system.dto.OperateTypeDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[OperateTypeManagerImpl]  
  * 类描述:		[权限操作类型管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("operateTypeManager")
public class OperateTypeManagerImpl implements OperateTypeManager {
	@Autowired
	private OperateTypeMapper operateTypeMapper;


	/**
	 * 根据权限操作类型标识获取权限操作类型
	 * @param id 权限操作类型标识
	 * @return 权限操作类型对象
	 */
	@Override
	public OperateTypeDTO getOperateTypeById(Long id){
		return operateTypeMapper.getOperateTypeById(id);
	}

	/**
	 * 根据条件获取权限操作类型列表
	 * @param condition 查询条件
	 * @return 权限操作类型列表
	 */
	@Override
	public List<OperateTypeDTO> getOperateTypeList(Map<String, Object> condition){
		return operateTypeMapper.getOperateTypeList(condition);
	}

	/**
	 * 保存权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveOperateType(OperateTypeDTO operateTypeDTO){
		return operateTypeMapper.saveOperateType(operateTypeDTO);
	}

	/**
	 * 更新权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateOperateType(OperateTypeDTO operateTypeDTO){
		return operateTypeMapper.updateOperateType(operateTypeDTO);
	}

	/**
	 * 根据权限操作类型标识删除权限操作类型
	 * @param id 权限操作类型标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteOperateTypeById(Long id){
		return operateTypeMapper.deleteOperateTypeById(id);
	}

	/**
	 * 批量保存权限操作类型
	 * @param  operateTypeList 权限操作类型数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveOperateType(List<OperateTypeDTO> operateTypeList){
		return operateTypeMapper.batchSaveOperateType(operateTypeList);
	}
}
