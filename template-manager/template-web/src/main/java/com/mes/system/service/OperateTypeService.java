package com.mes.system.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.OperateTypeDTO;
import com.mes.system.service.fallback.OperateTypeServiceFallback;

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
@FeignClient(value = "info-app", fallback = OperateTypeServiceFallback.class)
public interface OperateTypeService {

	/**
	 * 根据权限操作类型标识获取权限操作类型
	 * @param id 权限操作类型标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/operateType/getOperateTypeById")
	ServiceResponse<OperateTypeDTO> getOperateTypeById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取权限操作类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/operateType/getOperateTypeList")
	ServiceResponse<List<OperateTypeDTO>> getOperateTypeList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/operateType/saveOperateType")
	ServiceResponse<?> saveOperateType(@RequestBody OperateTypeDTO operateTypeDTO);

	/**
	 * 更新权限操作类型
	 * @param operateTypeDTO 权限操作类型对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/operateType/updateOperateType")
	ServiceResponse<?> updateOperateType(@RequestBody OperateTypeDTO operateTypeDTO);

	/**
	 * 根据权限操作类型标识删除权限操作类型
	 * @param id 权限操作类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/operateType/deleteOperateTypeById")
	ServiceResponse<?> deleteOperateTypeById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存权限操作类型
	 * @param operateTypeList 权限操作类型对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/operateType/batchSaveOperateType")
	ServiceResponse<?> batchSaveOperateType(@RequestBody List<OperateTypeDTO> operateTypeList);
}
