package com.mes.system.service.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.FunctionApiRelDTO;
import com.mes.system.dto.FunctionDTO;
import com.mes.system.service.FunctionService;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[FunctionServiceFallback]  
  * 类描述:		[系统功能业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class FunctionServiceFallback implements FunctionService {
	/**
		 * 根据系统功能标识获取系统功能
		 * @param id 系统功能标识
		 * @return 服务响应对象
		 */
	@Override
	public ServiceResponse<FunctionDTO> getFunctionById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据系统功能标识获取系统功能服务不可用.");
	}

	/**
	 * 根据条件获取系统功能列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<FunctionDTO>> getFunctionList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取系统功能列表服务不可用.");
	}

	/**
	 * 保存系统功能
	 * @param functionDTO 系统功能对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveFunction(FunctionDTO functionDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存系统功能服务不可用.");
	}

	/**
	 * 更新系统功能
	 * @param functionDTO 系统功能对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateFunction(FunctionDTO functionDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新系统功能服务不可用.");
	}

	/**
	 * 根据系统功能标识删除系统功能
	 * @param id 系统功能标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteFunctionById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据系统功能标识删除系统功能服务不可用.");
	}

	/**
	 * 批量保存系统功能
	 * @param functionDAOList 系统功能对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveFunction(List<FunctionDTO> functionList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存系统功能服务不可用.");
	}

	/**
	 * 根据功能接口关系标识获取功能接口关系
	 * @param id 功能接口关系标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<FunctionApiRelDTO> getFunctionApiRelById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据功能接口关系标识获取功能接口关系服务不可用.");
	}

	/**
	 * 根据条件获取功能接口关系列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<FunctionApiRelDTO>> getFunctionApiRelList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取功能接口关系列表服务不可用.");
	}

	/**
	 * 保存功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveFunctionApiRel(FunctionApiRelDTO functionApiRelDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存功能接口关系服务不可用.");
	}

	/**
	 * 更新功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateFunctionApiRel(FunctionApiRelDTO functionApiRelDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新功能接口关系服务不可用.");
	}

	/**
	 * 根据功能接口关系标识删除功能接口关系
	 * @param id 功能接口关系标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteFunctionApiRelById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据功能接口关系标识删除功能接口关系服务不可用.");
	}

	/**
	 * 批量保存功能接口关系
	 * @param functionApiRelDAOList 功能接口关系对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveFunctionApiRel(List<FunctionApiRelDTO> functionApiRelList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存功能接口关系服务不可用.");
	}
}
