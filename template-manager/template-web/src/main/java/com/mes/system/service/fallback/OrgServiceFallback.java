package com.mes.system.service.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.OrgDTO;
import com.mes.system.dto.OrgUserRelDTO;
import com.mes.system.service.OrgService;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[OrgServiceFallback]  
  * 类描述:		[组织机构业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class OrgServiceFallback implements OrgService {
	/**
		 * 根据组织机构标识获取组织机构
		 * @param id 组织机构标识
		 * @return 服务响应对象
		 */
	@Override
	public ServiceResponse<OrgDTO> getOrgById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据组织机构标识获取组织机构服务不可用.");
	}

	/**
	 * 根据条件获取组织机构列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<OrgDTO>> getOrgList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取组织机构列表服务不可用.");
	}

	/**
	 * 保存组织机构
	 * @param orgDTO 组织机构对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveOrg(OrgDTO orgDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存组织机构服务不可用.");
	}

	/**
	 * 更新组织机构
	 * @param orgDTO 组织机构对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateOrg(OrgDTO orgDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新组织机构服务不可用.");
	}

	/**
	 * 根据组织机构标识删除组织机构
	 * @param id 组织机构标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteOrgById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据组织机构标识删除组织机构服务不可用.");
	}

	/**
	 * 批量保存组织机构
	 * @param orgDAOList 组织机构对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveOrg(List<OrgDTO> orgList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存组织机构服务不可用.");
	}

	/**
	 * 根据组织用户标识获取组织用户
	 * @param id 组织用户标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<OrgUserRelDTO> getOrgUserRelById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据组织用户标识获取组织用户服务不可用.");
	}

	/**
	 * 根据条件获取组织用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<OrgUserRelDTO>> getOrgUserRelList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取组织用户列表服务不可用.");
	}

	/**
	 * 保存组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveOrgUserRel(OrgUserRelDTO orgUserRelDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存组织用户服务不可用.");
	}

	/**
	 * 更新组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateOrgUserRel(OrgUserRelDTO orgUserRelDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新组织用户服务不可用.");
	}

	/**
	 * 根据组织用户标识删除组织用户
	 * @param id 组织用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteOrgUserRelById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据组织用户标识删除组织用户服务不可用.");
	}

	/**
	 * 批量保存组织用户
	 * @param orgUserRelDAOList 组织用户对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveOrgUserRel(List<OrgUserRelDTO> orgUserRelList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存组织用户服务不可用.");
	}

	/**
	 * 获取组织机构树列表
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<OrgDTO>> getOrgTree(Long userId, Long parentId) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "获取组织机构树列表服务不可用.");
	}
}
