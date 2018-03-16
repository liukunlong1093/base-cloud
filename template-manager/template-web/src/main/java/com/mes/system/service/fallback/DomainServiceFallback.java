package com.mes.system.service.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.DomainDTO;
import com.mes.system.dto.DomainUserRelDTO;
import com.mes.system.service.DomainService;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[DomainServiceFallback]  
  * 类描述:		[群组业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class DomainServiceFallback implements DomainService {
	/**
		 * 根据群组标识获取群组
		 * @param id 群组标识
		 * @return 服务响应对象
		 */
	@Override
	public ServiceResponse<DomainDTO> getDomainById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据群组标识获取群组服务不可用.");
	}

	/**
	 * 根据条件获取群组列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<DomainDTO>> getDomainList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取群组列表服务不可用.");
	}

	/**
	 * 保存群组
	 * @param domainDTO 群组对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<DomainDTO> saveDomain(DomainDTO domainDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存群组服务不可用.");
	}

	/**
	 * 更新群组
	 * @param domainDTO 群组对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateDomain(DomainDTO domainDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新群组服务不可用.");
	}

	/**
	 * 根据群组标识删除群组
	 * @param id 群组标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteDomainById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据群组标识删除群组服务不可用.");
	}

	/**
	 * 批量保存群组
	 * @param domainDAOList 群组对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveDomain(List<DomainDTO> domainList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存群组服务不可用.");
	}

	/**
	 * 根据群组用户成员标识获取群组用户成员
	 * @param id 群组用户成员标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<DomainUserRelDTO> getDomainUserRelById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据群组用户成员标识获取群组用户成员服务不可用.");
	}

	/**
	 * 根据条件获取群组用户成员列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<DomainUserRelDTO>> getDomainUserRelList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取群组用户成员列表服务不可用.");
	}

	/**
	 * 保存群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveDomainUserRel(DomainUserRelDTO domainUserRelDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存群组用户成员服务不可用.");
	}

	/**
	 * 更新群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateDomainUserRel(DomainUserRelDTO domainUserRelDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新群组用户成员服务不可用.");
	}

	/**
	 * 根据群组用户成员标识删除群组用户成员
	 * @param id 群组用户成员标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteDomainUserRelById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据群组用户成员标识删除群组用户成员服务不可用.");
	}

	/**
	 * 批量保存群组用户成员
	 * @param domainUserRelDAOList 群组用户成员对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveDomainUserRel(List<DomainUserRelDTO> domainUserRelList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存群组用户成员服务不可用.");
	}
}
