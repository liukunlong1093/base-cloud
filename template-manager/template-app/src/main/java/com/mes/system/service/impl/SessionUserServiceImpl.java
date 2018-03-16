package com.mes.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.core.utils.StringUtils;
import com.mes.system.bean.SessionUser;
import com.mes.system.dto.DataPurviewDTO;
import com.mes.system.dto.DomainUserRelDTO;
import com.mes.system.dto.OrgUserRelDTO;
import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostUserRelDTO;
import com.mes.system.dto.UserDTO;
import com.mes.system.service.DomainService;
import com.mes.system.service.OrgService;
import com.mes.system.service.PostService;
import com.mes.system.service.PurviewService;
import com.mes.system.service.SessionUserService;
import com.mes.system.service.UserService;

@Service("sessionUserService")
public class SessionUserServiceImpl implements SessionUserService {
	@Autowired
	private UserService userService;

	@Autowired
	private OrgService orgService;

	@Autowired
	private PostService postService;

	@Autowired
	private DomainService domainService;

	@Autowired
	private PurviewService purviewService;

	/**
	 * 根据条件获取用户会话信息
	 * @param userId 用户标识
	 * @return 用户会话信息对象
	 */
	@Override
	public SessionUser getSessionUser(long userId) {
		Map<String, Object> condition = new HashMap<String, Object>(16);
		/** 单位标识*/
		List<Long> oUs = new ArrayList<Long>();

		/** 部门标识*/
		List<Long> cNs = new ArrayList<Long>();

		/** 岗位标识*/
		List<Long> postIds = new ArrayList<Long>();

		/** 岗位类型标识*/
		List<Long> postTypeIds = new ArrayList<Long>();

		/** 用户群组标识*/
		List<Long> domainIds = new ArrayList<Long>();
		UserDTO userDTO = userService.getUserById(userId);
		condition.clear();
		condition.put("userId", userId);
		List<OrgUserRelDTO> orgUserRelList = orgService.getOrgUserRelList(condition);
		// 初始化部门跟单位
		initOrg(orgUserRelList, oUs, cNs);
		List<PostUserRelDTO> postUserRelList = postService.getPostUserRelList(condition);
		Map<Long, Long> postTypeMap = new HashMap<Long, Long>(16);
		if (postUserRelList != null && postUserRelList.size() > 0) {
			for (PostUserRelDTO postUserRelDTO : postUserRelList) {
				postIds.add(postUserRelDTO.getPostId());
				PostDTO postDTO = postService.getPostById(postUserRelDTO.getPostId());
				postTypeMap.put(postDTO.getPostTypeId(), postDTO.getPostTypeId());
			}
		}
		if (postTypeMap != null && postTypeMap.size() > 0) {
			for (Long key : postTypeMap.keySet()) {
				postTypeIds.add(postTypeMap.get(key));
			}
		}
		List<DomainUserRelDTO> domainUserRelList = domainService.getDomainUserRelList(condition);
		if (domainUserRelList != null && domainUserRelList.size() > 0) {
			for (DomainUserRelDTO domainUserRelDTO : domainUserRelList) {
				domainIds.add(domainUserRelDTO.getDomainId());
			}
		}
		SessionUser su = new SessionUser();
		su.setId(userId);
		su.setName(userDTO.getName());
		su.setFullname(userDTO.getFullname());
		su.setOUs(oUs);
		su.setCNs(cNs);
		su.setPostIds(postIds);
		su.setPostTypeIds(postTypeIds);
		su.setDomainIds(domainIds);

		// 获取当前人其他数据的权限身份集合.便于构造权限SQL 数据格式为:MAP<菜单ID,该菜单下的权限身份集合>
		// 1.获取到当前人具有的数据权限
		// 2.进一步筛选中当前人那个模块 可以看那些范围对象数据
		// 3.转化为当前人的那个模块可以看那些人的数据
		Map<Long, List<Long>> otherDataPvCreaterIdMap = new HashMap<Long, List<Long>>(16);
		List<String> allUserSF = getUserAllSFStr(su);
		Map<String, Object> dataPurviewCondition = new HashMap<String, Object>(16);
		dataPurviewCondition.put("secIds", allUserSF);
		List<DataPurviewDTO> dataPurviewList = purviewService.getDataPurviewList(dataPurviewCondition);
		Map<Long, List<String>> menuDataPurviewMap = new HashMap<Long, List<String>>(16);
		if (dataPurviewList != null && dataPurviewList.size() > 0) {
			for (DataPurviewDTO dataPurviewDTO : dataPurviewList) {
				long menuId = dataPurviewDTO.getMenuId();
				if (menuDataPurviewMap.containsKey(menuId)) {
					menuDataPurviewMap.get(menuId).add(dataPurviewDTO.getRangeSecId());
				} else {
					List<String> rangSecIdList = new ArrayList<String>();
					rangSecIdList.add(dataPurviewDTO.getRangeSecId());
					menuDataPurviewMap.put(menuId, rangSecIdList);
				}
			}
		}
		if (menuDataPurviewMap != null && menuDataPurviewMap.size() > 0) {
			for (Map.Entry<Long, List<String>> entry : menuDataPurviewMap.entrySet()) {
				otherDataPvCreaterIdMap.put(entry.getKey(), getUserIdBySecList(entry.getValue()));
			}
		}
		su.setOtherDataPvCreaterIdMap(otherDataPvCreaterIdMap);
		return su;
	}

	/**
	 * 获取用户的所有身份字符串集合
	 * @param su 用户会话信息数据传输对象
	 * @return 用户的所有身份字符串集合
	 */
	@Override
	public List<String> getUserAllSFStr(SessionUser su) {
		List<String> arraylist = new ArrayList<String>();
		arraylist.add("U" + su.getId());
		List<Long> postIds = su.getPostIds();
		if (postIds != null && postIds.size() > 0) {
			for (int i = 0, len = postIds.size(); i < len; i++) {
				arraylist.add("P" + StringUtils.trim(postIds.get(i)));
			}
		}
		List<Long> postTypeIds = su.getPostTypeIds();
		if (postTypeIds != null && postTypeIds.size() > 0) {
			for (int i = 0, len = postTypeIds.size(); i < len; i++) {
				arraylist.add("T" + StringUtils.trim(postTypeIds.get(i)));
			}
		}
		List<Long> domainIds = su.getDomainIds();
		if (domainIds != null && domainIds.size() > 0) {
			for (int i = 0, len = domainIds.size(); i < len; i++) {
				arraylist.add("D" + StringUtils.trim(domainIds.get(i)));
			}
		}
		List<Long> cns = su.getCNs();
		List<Long> ous = su.getOUs();
		if (cns != null && cns.size() > 0) {
			for (int i = 0, len = cns.size(); i < len; i++) {
				arraylist.add("O" + StringUtils.trim(cns.get(i)));
			}
		}
		if (ous != null && ous.size() > 0) {
			for (int i = 0, len = ous.size(); i < len; i++) {
				arraylist.add("O" + StringUtils.trim(ous.get(i)));
			}
		}
		return arraylist;
	}

	private void initOrg(List<OrgUserRelDTO> orgList, List<Long> ouList, List<Long> cnList) {
		if (orgList != null && orgList.size() > 0) {
			for (OrgUserRelDTO orgUserRelDTO : orgList) {
				if (0 == orgUserRelDTO.getOrgId()) {
					ouList.add(orgUserRelDTO.getOrgId());
				} else {
					cnList.add(orgUserRelDTO.getOrgId());
				}
			}
		}
	}

	/**
	 * 获取SEC集合中包含的所有用户
	 * @param secId(带标识区分的ID)
	 * @param secType (标识类型)
	 * @return
	 */
	public List<Long> getUserIdBySecList(List<String> secList) {
		List<Long> rsList = new ArrayList<Long>();
		Map<String, Object> condition = new HashMap<String, Object>(16);
		if (secList != null && secList.size() > 0) {
			for (String secId : secList) {
				if (secId.contains("O")) {
					condition.clear();
					condition.put("orgId", secId.replace("O", ""));
					List<OrgUserRelDTO> orgUserRelList = orgService.getOrgUserRelList(condition);
					if (orgUserRelList != null && orgUserRelList.size() > 0) {
						for (OrgUserRelDTO orgUserRelDTO : orgUserRelList) {
							rsList.add(orgUserRelDTO.getUserId());
						}
					}
				} else if (secId.contains("U")) {
					rsList.add(StringUtils.getAsLong(secId.replace("U", "")));
				} else if (secId.contains("P")) {
					condition.clear();
					condition.put("postId", secId.replace("P", ""));
					List<PostUserRelDTO> postUserRelList = postService.getPostUserRelList(condition);
					if (postUserRelList != null && postUserRelList.size() > 0) {
						for (PostUserRelDTO postUserRelDTO : postUserRelList) {
							rsList.add(postUserRelDTO.getUserId());
						}
					}
				} else if (secId.contains("T")) {
					condition.clear();
					condition.put("postTypeId", secId.replace("T", ""));
					List<PostDTO> postList = postService.getPostList(condition);
					if (postList != null && postList.size() > 0) {
						for (PostDTO postDTO : postList) {
							condition.clear();
							condition.put("postId", postDTO.getId());
							List<PostUserRelDTO> postUserRelList = postService.getPostUserRelList(condition);
							if (postUserRelList != null && postUserRelList.size() > 0) {
								for (PostUserRelDTO postUserRelDTO : postUserRelList) {
									rsList.add(postUserRelDTO.getUserId());
								}
							}
						}
					}
				} else if (secId.contains("D")) {
					condition.clear();
					condition.put("domainId", secId.replace("D", ""));
					List<DomainUserRelDTO> domainUserRelList = domainService.getDomainUserRelList(condition);
					if (domainUserRelList != null && domainUserRelList.size() > 0) {
						for (DomainUserRelDTO domainUserRelDTO : domainUserRelList) {
							rsList.add(domainUserRelDTO.getUserId());
						}
					}

				}
			}
		}
		removeDuplicate(rsList);
		return rsList;

	}

	/**
	 * 取出list集合重复项
	 * @param list
	 */
	private void removeDuplicate(List<Long> list) {
		HashSet<Long> h = new HashSet<Long>(list);
		list.clear();
		list.addAll(h);
	}
}
