package com.mes.system.service;

import java.util.List;
import java.util.Map;

import com.mes.system.dto.OrgDTO;
import com.mes.system.dto.OrgUserRelDTO;

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
public interface OrgService {
	/**
	 * 根据组织机构标识获取组织机构
	 * @param id 组织机构标识
	 * @return 组织机构对象
	 */
	OrgDTO getOrgById(Long id);

	/**
	 * 根据条件获取组织机构列表
	 * @param condition 查询条件
	 * @return 组织机构列表
	 */
	List<OrgDTO> getOrgList(Map<String, Object> condition);

	/**
	 * 保存组织机构
	 * @param orgDTO 组织机构对象
	 * @return 新增后的组织机构对象
	 */
	OrgDTO saveOrg(OrgDTO orgDTO);

	/**
	 * 更新组织机构
	 * @param orgDTO 组织机构对象
	 * @return 更新后的组织机构对象
	 */
	OrgDTO updateOrg(OrgDTO orgDTO);

	/**
	 * 根据组织机构标识删除组织机构
	 * @param id 组织机构标识
	 * @return 删除成功条数
	 */
	long deleteOrgById(String id);

	/**
	 * 批量保存组织机构
	 * @param  orgList 组织机构数据集合
	 * @return 新增成功条数
	 */
	long batchSaveOrg(List<OrgDTO> orgList);

	/**
	 * 根据组织用户标识获取组织用户
	 * @param id 组织用户标识
	 * @return 组织用户对象
	 */
	OrgUserRelDTO getOrgUserRelById(Long id);

	/**
	 * 根据条件获取组织用户列表
	 * @param condition 查询条件
	 * @return 组织用户列表
	 */
	List<OrgUserRelDTO> getOrgUserRelList(Map<String, Object> condition);

	/**
	 * 保存组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 新增后的组织用户对象
	 */
	OrgUserRelDTO saveOrgUserRel(OrgUserRelDTO orgUserRelDTO);

	/**
	 * 更新组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 更新后的组织用户对象
	 */
	OrgUserRelDTO updateOrgUserRel(OrgUserRelDTO orgUserRelDTO);

	/**
	 * 根据组织用户标识删除组织用户
	 * @param id 组织用户标识
	 * @return 删除成功条数
	 */
	long deleteOrgUserRelById(String id);

	/**
	 * 批量保存组织用户
	 * @param  orgUserRelList 组织用户数据集合
	 * @return 新增成功条数
	 */
	long batchSaveOrgUserRel(List<OrgUserRelDTO> orgUserRelList);
	
	/**
	 * 获取组织机构树列表
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 组织机构树列表
	 */
	List<OrgDTO> getOrgTree(Long userId, Long parentId);
}
