package com.mes.system.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.dto.OperateTypeDTO;
import com.mes.system.manager.OperateTypeManager;
import com.mes.system.service.OperateTypeService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.impl]    
  * 类名称:		[OperateTypeServiceImpl]  
  * 类描述:		[权限操作类型业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("operateTypeService")
public class OperateTypeServiceImpl implements OperateTypeService {
	@Autowired
	private OperateTypeManager operateTypeManager;
	
	/**
	 * 根据权限操作类型标识获取权限操作类型
	 * @param id 权限操作类型标识
	 * @return 权限操作类型对象
	 */
	@Override
	public OperateTypeDTO getOperateTypeById(Long id){
		OperateTypeDTO operateTypeDTO = operateTypeManager.getOperateTypeById(id);
		return operateTypeDTO;
	}
	

	/**
	 * 根据条件获取权限操作类型列表
	 * @param condition 查询条件
	 * @return 权限操作类型列表
	 */
	@Override
	public List<OperateTypeDTO> getOperateTypeList(Map<String, Object> condition){
		List<OperateTypeDTO> operateTypeList = operateTypeManager.getOperateTypeList(condition);
		return operateTypeList;
	}

	/**
	 * 保存权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 新增后的权限操作类型对象
	 */
	@Override
	public OperateTypeDTO saveOperateType(OperateTypeDTO operateTypeDTO){
	    operateTypeDTO.setCreateTime(new Date());
		operateTypeManager.saveOperateType(operateTypeDTO);
		return operateTypeDTO;
	}
	
	/**
	 * 更新权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 更新后的权限操作类型对象
	 */
	@Override
	public OperateTypeDTO updateOperateType(OperateTypeDTO operateTypeDTO){
		operateTypeDTO.setUpdateTime(new Date());
		operateTypeManager.updateOperateType(operateTypeDTO);
		return operateTypeDTO;
	}


	/**
	 * 根据权限操作类型标识删除权限操作类型
	 * @param id 权限操作类型标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteOperateTypeById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				operateTypeManager.deleteOperateTypeById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存权限操作类型
	 * @param  operateTypeList 权限操作类型数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveOperateType(List<OperateTypeDTO> operateTypeList){
		long result = 0;
		result = operateTypeManager.batchSaveOperateType(operateTypeList);
		return result;
	}

	

}