package com.mes.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.common.exception.enums.ServiceExceptionEnums;
import com.mes.core.exception.ServiceException;
import com.mes.core.utils.StringUtils;
import com.mes.system.bean.SessionUser;
import com.mes.system.dto.OrgDTO;
import com.mes.system.dto.OrgUserRelDTO;
import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostUserRelDTO;
import com.mes.system.manager.OrgManager;
import com.mes.system.manager.OrgUserRelManager;
import com.mes.system.manager.PostManager;
import com.mes.system.manager.PostUserRelManager;
import com.mes.system.service.OrgService;
import com.mes.system.service.SessionUserService;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.service.impl]    
 * 类名称:		[OrgServiceImpl]  
 * 类描述:		[组织机构业务处理类]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月18日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月18日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
@Service("orgService")
public class OrgServiceImpl implements OrgService {
	private static final Logger logger = LoggerFactory.getLogger(OrgServiceImpl.class);
	@Autowired
	private OrgManager orgManager;

	@Autowired
	private OrgUserRelManager orgUserRelManager;

	@Autowired
	private PostManager postManager;

	@Autowired
	private PostUserRelManager postUserRelManager;
	
	@Autowired
	private SessionUserService sessionUserService;

	/**
	 * 根据组织机构标识获取组织机构
	 * @param id 组织机构标识
	 * @return 组织机构对象
	 */
	@Override
	public OrgDTO getOrgById(Long id) {
		OrgDTO orgDTO = orgManager.getOrgById(id);
		return orgDTO;
	}

	/**
	 * 根据条件获取组织机构列表
	 * @param condition 查询条件
	 * @return 组织机构列表
	 */
	@Override
	public List<OrgDTO> getOrgList(Map<String, Object> condition) {
		List<OrgDTO> orgList = orgManager.getOrgList(condition);
		return orgList;
	}

	/**
	 * 保存组织机构
	 * @param orgDTO 组织机构对象
	 * @return 新增后的组织机构对象
	 */
	@Override
	public OrgDTO saveOrg(OrgDTO orgDTO) {
		orgDTO.setCreateTime(new Date());
		orgManager.saveOrg(orgDTO);
		return orgDTO;
	}

	/**
	 * 更新组织机构
	 * @param orgDTO 组织机构对象
	 * @return 更新后的组织机构对象
	 */
	@Override
	public OrgDTO updateOrg(OrgDTO orgDTO) {
		orgDTO.setUpdateTime(new Date());
		orgManager.updateOrg(orgDTO);
		return orgDTO;
	}

	/**
	 * 根据组织机构标识删除组织机构
	 * @param id 组织机构标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteOrgById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			Map<String, Object> orgCondition = new HashMap<String, Object>(16);
			Map<String, Object> postCondition = new HashMap<String, Object>(16);
			Map<String, Object> orgUserRelCondition = new HashMap<String, Object>(16);
			for (String idStr : ids) {
				Long orgId = StringUtils.getAsLong(idStr, 0L);
				if (orgId > 0) {
					orgCondition.clear();
					orgCondition.put("parentId", id);
					List<OrgDTO> orgList = orgManager.getOrgList(orgCondition);
					if (orgList != null && orgList.size() > 0) {
						throw new ServiceException(ServiceExceptionEnums.ORG_EXIST_SUBNODES);
					}

					postCondition.clear();
					postCondition.put("orgId", id);
					List<PostDTO> postPage = postManager.getPostList(postCondition);
					if (postPage != null && postPage.size() > 0) {
						throw new ServiceException(ServiceExceptionEnums.ORG_EXIST_POST);
					}

					orgUserRelCondition.clear();
					orgUserRelCondition.put("orgId", id);
					List<OrgUserRelDTO> orgUserRelPage = orgUserRelManager.getOrgUserRelList(orgUserRelCondition);
					if (orgUserRelPage != null && orgUserRelPage.size() > 0) {
						throw new ServiceException(ServiceExceptionEnums.ORG_EXIST_USER);
					}
					orgManager.deleteOrgById(orgId);
				}

			}
		}
		return result;
	}

	/**
	 * 批量保存组织机构
	 * @param  orgList 组织机构数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveOrg(List<OrgDTO> orgList) {
		long result = 0;
		result = orgManager.batchSaveOrg(orgList);
		return result;
	}

	/**
	 * 根据组织用户标识获取组织用户
	 * @param id 组织用户标识
	 * @return 组织用户对象
	 */
	@Override
	public OrgUserRelDTO getOrgUserRelById(Long id) {
		OrgUserRelDTO orgUserRelDTO = orgUserRelManager.getOrgUserRelById(id);
		return orgUserRelDTO;
	}

	/**
	 * 根据条件获取组织用户列表
	 * @param condition 查询条件
	 * @return 组织用户列表
	 */
	@Override
	public List<OrgUserRelDTO> getOrgUserRelList(Map<String, Object> condition) {
		List<OrgUserRelDTO> orgUserRelList = orgUserRelManager.getOrgUserRelList(condition);
		return orgUserRelList;
	}

	/**
	 * 保存组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 新增后的组织用户对象
	 */
	@Override
	public OrgUserRelDTO saveOrgUserRel(OrgUserRelDTO orgUserRelDTO) {
		orgUserRelDTO.setCreateTime(new Date());
		orgUserRelManager.saveOrgUserRel(orgUserRelDTO);
		return orgUserRelDTO;
	}

	/**
	 * 更新组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 更新后的组织用户对象
	 */
	@Override
	public OrgUserRelDTO updateOrgUserRel(OrgUserRelDTO orgUserRelDTO) {
		orgUserRelDTO.setUpdateTime(new Date());
		orgUserRelManager.updateOrgUserRel(orgUserRelDTO);
		return orgUserRelDTO;
	}

	/**
	 * 根据组织用户标识删除组织用户
	 * @param id 组织用户标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteOrgUserRelById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				Long orgUserRelId = StringUtils.getAsLong(idStr, 0L);
				Map<String, Object> postCondition = new HashMap<String, Object>(16);
				Map<String, Object> postUserRelCondition = new HashMap<String, Object>(16);
				if (orgUserRelId > 0) {
					OrgUserRelDTO orgUserRelDTO = orgUserRelManager.getOrgUserRelById(orgUserRelId);
					postCondition.clear();
					postCondition.put("orgId", orgUserRelDTO.getOrgId());
					List<PostDTO> postList = postManager.getPostList(postCondition);
					if (postList != null && postList.size() > 0) {
						for (PostDTO postDTO : postList) {
							postUserRelCondition.clear();
							postUserRelCondition.put("postId", postDTO.getId());
							List<PostUserRelDTO> postUserRelList = postUserRelManager.getPostUserRelList(postUserRelCondition);
							if (postUserRelList != null && postUserRelList.size() > 0) {
								throw new ServiceException(ServiceExceptionEnums.ORG_USER_EXIST_USER);
							}
						}
					}
					orgUserRelManager.deleteOrgUserRelById(orgUserRelId);
				}
			}
		}
		return result;
	}

	/**
	 * 批量保存组织用户
	 * @param  orgUserRelList 组织用户数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveOrgUserRel(List<OrgUserRelDTO> orgUserRelList) {
		long result = 0;
		result = orgUserRelManager.batchSaveOrgUserRel(orgUserRelList);
		return result;
	}
	
	/**
	 * 获取组织机构树列表
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 组织机构树列表
	 */
	@Override
	public List<OrgDTO> getOrgTree(Long userId, Long parentId){
		List<OrgDTO> rsList = new ArrayList<OrgDTO>();
		Long rootId=(parentId==null)?0L:parentId;
		SessionUser su = sessionUserService.getSessionUser(userId);
		List<OrgDTO> orgList = getOrgList(new HashMap<String, Object>(16));
		if(orgList!=null && orgList.size()>0){
			long adminId=999999L;
			if (adminId != su.getId()) {
				List<Long> cn = su.getCNs();
				if (cn != null && cn.size() > 0) {
					OrgDTO orderInfoDTO =getOrgById(cn.get(0));
					if (cn.size() > 1) {
						logger.error("系统管理用户:" + su.getName() + "属于两个部门.现取默认部门" + orderInfoDTO.getName());
					}
					constructOrgTreeDesc(orderInfoDTO.getId(), orgList, rsList);
					constructOrgTreeAsc(orderInfoDTO.getId(), orgList, rsList);
				} else {
					logger.error("请把" + su.getName() + "放在该下面相应部门用户下面!");
				}
			} else {
				constructOrgTreeAsc(rootId, orgList, rsList);
			}
			
		}
		return rsList;
	}
	
	/**
	 * 从某一个节点正向递归
	 * @param rootId  节点ID
	 * @param orgList 所有的组织机构集合
	 * @param rsList  返回处理后的组织信息
	 */
	private void constructOrgTreeAsc(long rootId, List<OrgDTO> orgList, List<OrgDTO> rsList) {
		for (int i = 0; i < orgList.size(); i++) {
			OrgDTO orgDTO = (OrgDTO) orgList.get(i);
			if (orgDTO.getParentId() == rootId) {
				rsList.add(orgDTO);
				constructOrgTreeAsc(orgDTO.getId(), orgList, rsList);
			}
		}
	}

	/**
	 * 从某一个节点逆向递归
	 * @param pid 节点ID
	 * @param orgList 所有的组织机构集合
	 * @param rsList  返回处理后的组织信息
	 */
	private void constructOrgTreeDesc(long pid, List<OrgDTO> orgList, List<OrgDTO> rsList) {
		for (int i = 0; i < orgList.size(); i++) {
			OrgDTO orgDTO = (OrgDTO) orgList.get(i);
			if (pid == orgDTO.getId()) {
				rsList.add(orgDTO);
				constructOrgTreeDesc(orgDTO.getParentId(), orgList, rsList);
			}
		}
	}


}