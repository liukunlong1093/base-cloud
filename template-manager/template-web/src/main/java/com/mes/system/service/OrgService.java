package com.mes.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.OrgDTO;
import com.mes.system.dto.OrgUserRelDTO;
import com.mes.system.service.fallback.OrgServiceFallback;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[OrgService]  
  * 类描述:		[组织机构业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = OrgServiceFallback.class)
public interface OrgService {

	/**
	 * 根据组织机构标识获取组织机构
	 * @param id 组织机构标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/getOrgById")
	ServiceResponse<OrgDTO> getOrgById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取组织机构列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/getOrgList")
	ServiceResponse<List<OrgDTO>> getOrgList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存组织机构
	 * @param orgDTO 组织机构对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/saveOrg")
	ServiceResponse<?> saveOrg(@RequestBody OrgDTO orgDTO);

	/**
	 * 更新组织机构
	 * @param orgDTO 组织机构对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/updateOrg")
	ServiceResponse<?> updateOrg(@RequestBody OrgDTO orgDTO);

	/**
	 * 根据组织机构标识删除组织机构
	 * @param id 组织机构标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/deleteOrgById")
	ServiceResponse<?> deleteOrgById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存组织机构
	 * @param orgList 组织机构对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/batchSaveOrg")
	ServiceResponse<?> batchSaveOrg(@RequestBody List<OrgDTO> orgList);

	/**
	 * 根据组织用户标识获取组织用户
	 * @param id 组织用户标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/getOrgUserRelById")
	ServiceResponse<OrgUserRelDTO> getOrgUserRelById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取组织用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/getOrgUserRelList")
	ServiceResponse<List<OrgUserRelDTO>> getOrgUserRelList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/saveOrgUserRel")
	ServiceResponse<?> saveOrgUserRel(@RequestBody OrgUserRelDTO orgUserRelDTO);

	/**
	 * 更新组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/updateOrgUserRel")
	ServiceResponse<?> updateOrgUserRel(@RequestBody OrgUserRelDTO orgUserRelDTO);

	/**
	 * 根据组织用户标识删除组织用户
	 * @param id 组织用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/deleteOrgUserRelById")
	ServiceResponse<?> deleteOrgUserRelById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存组织用户
	 * @param orgUserRelList 组织用户对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/batchSaveOrgUserRel")
	ServiceResponse<?> batchSaveOrgUserRel(@RequestBody List<OrgUserRelDTO> orgUserRelList);

	/**
	 * 获取组织机构树列表
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/org/getOrgTree")
	ServiceResponse<List<OrgDTO>> getOrgTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "parentId") Long parentId);
}
