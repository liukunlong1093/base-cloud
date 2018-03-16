package com.mes.system.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.OperateTypeDTO;
import com.mes.system.service.OperateTypeService;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[OperateTypeServiceFallback]  
  * 类描述:		[权限操作类型业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class OperateTypeServiceFallback implements OperateTypeService {
/**
	 * 根据权限操作类型标识获取权限操作类型
	 * @param id 权限操作类型标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<OperateTypeDTO> getOperateTypeById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据权限操作类型标识获取权限操作类型服务不可用.");
	}

	/**
	 * 根据条件获取权限操作类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<OperateTypeDTO>> getOperateTypeList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取权限操作类型列表服务不可用.");
	}

	/**
	 * 保存权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveOperateType(OperateTypeDTO operateTypeDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存权限操作类型服务不可用.");
	}
	
	/**
	 * 更新权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateOperateType(OperateTypeDTO operateTypeDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新权限操作类型服务不可用.");
	}

	/**
	 * 根据权限操作类型标识删除权限操作类型
	 * @param id 权限操作类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteOperateTypeById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据权限操作类型标识删除权限操作类型服务不可用.");
	}

	/**
	 * 批量保存权限操作类型
	 * @param operateTypeDAOList 权限操作类型对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSaveOperateType(List<OperateTypeDTO> operateTypeList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存权限操作类型服务不可用.");
	 }
}
