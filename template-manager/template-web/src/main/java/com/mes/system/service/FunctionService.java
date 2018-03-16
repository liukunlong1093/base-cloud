package com.mes.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.FunctionApiRelDTO;
import com.mes.system.dto.FunctionDTO;
import com.mes.system.service.fallback.FunctionServiceFallback;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[FunctionService]  
  * 类描述:		[系统功能业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = FunctionServiceFallback.class)
public interface FunctionService {

	/**
	 * 根据系统功能标识获取系统功能
	 * @param id 系统功能标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/function/getFunctionById")
	ServiceResponse<FunctionDTO> getFunctionById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取系统功能列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/function/getFunctionList")
	ServiceResponse<List<FunctionDTO>> getFunctionList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存系统功能
	 * @param functionDTO 系统功能对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/function/saveFunction")
	ServiceResponse<?> saveFunction(@RequestBody FunctionDTO functionDTO);

	/**
	 * 更新系统功能
	 * @param functionDTO 系统功能对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/function/updateFunction")
	ServiceResponse<?> updateFunction(@RequestBody FunctionDTO functionDTO);

	/**
	 * 根据系统功能标识删除系统功能
	 * @param id 系统功能标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/function/deleteFunctionById")
	ServiceResponse<?> deleteFunctionById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存系统功能
	 * @param functionList 系统功能对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/function/batchSaveFunction")
	ServiceResponse<?> batchSaveFunction(@RequestBody List<FunctionDTO> functionList);

	/**
	 * 根据功能接口关系标识获取功能接口关系
	 * @param id 功能接口关系标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/functionApiRel/getFunctionApiRelById")
	ServiceResponse<FunctionApiRelDTO> getFunctionApiRelById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取功能接口关系列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/functionApiRel/getFunctionApiRelList")
	ServiceResponse<List<FunctionApiRelDTO>> getFunctionApiRelList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/functionApiRel/saveFunctionApiRel")
	ServiceResponse<?> saveFunctionApiRel(@RequestBody FunctionApiRelDTO functionApiRelDTO);

	/**
	 * 更新功能接口关系
	 * @param functionApiRelDTO 功能接口关系对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/functionApiRel/updateFunctionApiRel")
	ServiceResponse<?> updateFunctionApiRel(@RequestBody FunctionApiRelDTO functionApiRelDTO);

	/**
	 * 根据功能接口关系标识删除功能接口关系
	 * @param id 功能接口关系标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/functionApiRel/deleteFunctionApiRelById")
	ServiceResponse<?> deleteFunctionApiRelById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存功能接口关系
	 * @param functionApiRelList 功能接口关系对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/functionApiRel/batchSaveFunctionApiRel")
	ServiceResponse<?> batchSaveFunctionApiRel(@RequestBody List<FunctionApiRelDTO> functionApiRelList);
}
