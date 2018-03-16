package com.mes.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.DomainDTO;
import com.mes.system.dto.DomainUserRelDTO;
import com.mes.system.service.fallback.DomainServiceFallback;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[DomainService]  
  * 类描述:		[群组业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = DomainServiceFallback.class)
public interface DomainService {

	/**
	 * 根据群组标识获取群组
	 * @param id 群组标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/getDomainById")
	ServiceResponse<DomainDTO> getDomainById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取群组列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/getDomainList")
	ServiceResponse<List<DomainDTO>> getDomainList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存群组
	 * @param domainDTO 群组对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/saveDomain")
	ServiceResponse<DomainDTO> saveDomain(@RequestBody DomainDTO domainDTO);

	/**
	 * 更新群组
	 * @param domainDTO 群组对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/updateDomain")
	ServiceResponse<?> updateDomain(@RequestBody DomainDTO domainDTO);

	/**
	 * 根据群组标识删除群组
	 * @param id 群组标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/deleteDomainById")
	ServiceResponse<?> deleteDomainById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存群组
	 * @param domainList 群组对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/batchSaveDomain")
	ServiceResponse<?> batchSaveDomain(@RequestBody List<DomainDTO> domainList);

	/**
	 * 根据群组用户成员标识获取群组用户成员
	 * @param id 群组用户成员标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/getDomainUserRelById")
	ServiceResponse<DomainUserRelDTO> getDomainUserRelById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取群组用户成员列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/getDomainUserRelList")
	ServiceResponse<List<DomainUserRelDTO>> getDomainUserRelList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/saveDomainUserRel")
	ServiceResponse<?> saveDomainUserRel(@RequestBody DomainUserRelDTO domainUserRelDTO);

	/**
	 * 更新群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/updateDomainUserRel")
	ServiceResponse<?> updateDomainUserRel(@RequestBody DomainUserRelDTO domainUserRelDTO);

	/**
	 * 根据群组用户成员标识删除群组用户成员
	 * @param id 群组用户成员标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/deleteDomainUserRelById")
	ServiceResponse<?> deleteDomainUserRelById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存群组用户成员
	 * @param domainUserRelList 群组用户成员对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/domain/batchSaveDomainUserRel")
	ServiceResponse<?> batchSaveDomainUserRel(@RequestBody List<DomainUserRelDTO> domainUserRelList);
}
