package com.mes.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mes.core.utils.StringUtils;
import com.mes.system.bean.SessionUser;
import com.mes.system.dto.DataPurviewDTO;
import com.mes.system.dto.DomainDTO;
import com.mes.system.dto.FunctionApiRelDTO;
import com.mes.system.dto.FunctionDTO;
import com.mes.system.dto.FunctionPurviewDTO;
import com.mes.system.dto.MenuDTO;
import com.mes.system.dto.MenuPurviewDTO;
import com.mes.system.dto.OrgDTO;
import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostTypeDTO;
import com.mes.system.dto.PurviewFunctionTreeDTO;
import com.mes.system.dto.PurviewSecTreeDTO;
import com.mes.system.dto.UserDTO;
import com.mes.system.manager.DataPurviewManager;
import com.mes.system.manager.FunctionPurviewManager;
import com.mes.system.manager.MenuPurviewManager;
import com.mes.system.service.DomainService;
import com.mes.system.service.FunctionService;
import com.mes.system.service.MenuService;
import com.mes.system.service.OrgService;
import com.mes.system.service.PostService;
import com.mes.system.service.PostTypeService;
import com.mes.system.service.PurviewService;
import com.mes.system.service.SessionUserService;
import com.mes.system.service.UserService;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.service.impl]    
 * 类名称:		[PurviewServiceImpl]  
 * 类描述:		[权限业务处理类]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月21日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月21日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
@Service("purviewService")
public class PurviewServiceImpl implements PurviewService {
	private static final Logger logger = LoggerFactory.getLogger(OrgServiceImpl.class);
	@Autowired
	private MenuPurviewManager menuPurviewManager;

	@Autowired
	private FunctionPurviewManager functionPurviewManager;

	@Autowired
	private DataPurviewManager dataPurviewManager;

	@Autowired
	private UserService userService;

	@Autowired
	private OrgService orgService;

	@Autowired
	private PostService postService;

	@Autowired
	private PostTypeService postTypeService;

	@Autowired
	private DomainService domainService;

	@Autowired
	private SessionUserService sessionUserService;

	@Autowired
	private FunctionService functionService;

	@Autowired
	private MenuService menuService;

	/**
	 * 根据菜单权限标识获取菜单权限
	 * @param id 菜单权限标识
	 * @return 菜单权限对象
	 */
	@Override
	public MenuPurviewDTO getMenuPurviewById(Long id) {
		MenuPurviewDTO menuPurviewDTO = menuPurviewManager.getMenuPurviewById(id);
		return menuPurviewDTO;
	}

	/**
	 * 根据条件获取菜单权限列表
	 * @param condition 查询条件
	 * @return 菜单权限列表
	 */
	@Override
	public List<MenuPurviewDTO> getMenuPurviewList(Map<String, Object> condition) {
		List<MenuPurviewDTO> menuPurviewList = menuPurviewManager.getMenuPurviewList(condition);
		return menuPurviewList;
	}

	/**
	 * 保存菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 新增后的菜单权限对象
	 */
	@Override
	public MenuPurviewDTO saveMenuPurview(MenuPurviewDTO menuPurviewDTO) {
		menuPurviewDTO.setCreateTime(new Date());
		menuPurviewManager.saveMenuPurview(menuPurviewDTO);
		return menuPurviewDTO;
	}

	/**
	 * 更新菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 更新后的菜单权限对象
	 */
	@Override
	public MenuPurviewDTO updateMenuPurview(MenuPurviewDTO menuPurviewDTO) {
		menuPurviewDTO.setUpdateTime(new Date());
		menuPurviewManager.updateMenuPurview(menuPurviewDTO);
		return menuPurviewDTO;
	}

	/**
	 * 根据菜单权限标识删除菜单权限
	 * @param id 菜单权限标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteMenuPurviewById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				menuPurviewManager.deleteMenuPurviewById(StringUtils.getAsLong(idStr, 0L));
			}
		}
		return result;
	}

	/**
	 * 据权限对象标识删除菜单权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	@Override
	public long deleteMenuPurviewBySecId(String secId) {
		return 0;
	}

	/**
	 * 批量保存菜单权限
	 * @param  menuPurviewList 菜单权限数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveMenuPurview(List<MenuPurviewDTO> menuPurviewList) {
		long result = 0;
		result = menuPurviewManager.batchSaveMenuPurview(menuPurviewList);
		return result;
	}

	/**
	 * 根据功能权限标识获取功能权限
	 * @param id 功能权限标识
	 * @return 功能权限对象
	 */
	@Override
	public FunctionPurviewDTO getFunctionPurviewById(Long id) {
		FunctionPurviewDTO functionPurviewDTO = functionPurviewManager.getFunctionPurviewById(id);
		return functionPurviewDTO;
	}

	/**
	 * 根据条件获取功能权限列表
	 * @param condition 查询条件
	 * @return 功能权限列表
	 */
	@Override
	public List<FunctionPurviewDTO> getFunctionPurviewList(Map<String, Object> condition) {
		List<FunctionPurviewDTO> functionPurviewList = functionPurviewManager.getFunctionPurviewList(condition);
		return functionPurviewList;
	}

	/**
	 * 保存功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 新增后的功能权限对象
	 */
	@Override
	public FunctionPurviewDTO saveFunctionPurview(FunctionPurviewDTO functionPurviewDTO) {
		functionPurviewDTO.setCreateTime(new Date());
		functionPurviewManager.saveFunctionPurview(functionPurviewDTO);
		return functionPurviewDTO;
	}

	/**
	 * 更新功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 更新后的功能权限对象
	 */
	@Override
	public FunctionPurviewDTO updateFunctionPurview(FunctionPurviewDTO functionPurviewDTO) {
		functionPurviewDTO.setUpdateTime(new Date());
		functionPurviewManager.updateFunctionPurview(functionPurviewDTO);
		return functionPurviewDTO;
	}

	/**
	 * 根据功能权限标识删除功能权限
	 * @param id 功能权限标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteFunctionPurviewById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				functionPurviewManager.deleteFunctionPurviewById(StringUtils.getAsLong(idStr, 0L));
			}
		}
		return result;
	}

	/**
	 * 根据权限对象标识删除功能权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	@Override
	public long deleteFunctionPurviewBySecId(String secId) {
		return 0;
	}

	/**
	 * 批量保存功能权限
	 * @param  functionPurviewList 功能权限数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveFunctionPurview(List<FunctionPurviewDTO> functionPurviewList) {
		long result = 0;
		result = functionPurviewManager.batchSaveFunctionPurview(functionPurviewList);
		return result;
	}

	/**
	 * 根据数据权限标识获取数据权限
	 * @param id 数据权限标识
	 * @return 数据权限对象
	 */
	@Override
	public DataPurviewDTO getDataPurviewById(Long id) {
		DataPurviewDTO dataPurviewDTO = dataPurviewManager.getDataPurviewById(id);
		return dataPurviewDTO;
	}

	/**
	 * 根据条件获取数据权限列表
	 * @param condition 查询条件
	 * @return 数据权限列表
	 */
	@Override
	public List<DataPurviewDTO> getDataPurviewList(Map<String, Object> condition) {
		List<DataPurviewDTO> dataPurviewList = dataPurviewManager.getDataPurviewList(condition);
		return dataPurviewList;
	}

	/**
	 * 保存数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 新增后的数据权限对象
	 */
	@Override
	public DataPurviewDTO saveDataPurview(DataPurviewDTO dataPurviewDTO) {
		dataPurviewDTO.setCreateTime(new Date());
		dataPurviewManager.saveDataPurview(dataPurviewDTO);
		return dataPurviewDTO;
	}

	/**
	 * 更新数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 更新后的数据权限对象
	 */
	@Override
	public DataPurviewDTO updateDataPurview(DataPurviewDTO dataPurviewDTO) {
		dataPurviewDTO.setUpdateTime(new Date());
		dataPurviewManager.updateDataPurview(dataPurviewDTO);
		return dataPurviewDTO;
	}

	/**
	 * 根据数据权限标识删除数据权限
	 * @param id 数据权限标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteDataPurviewById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				dataPurviewManager.deleteDataPurviewById(StringUtils.getAsLong(idStr, 0L));
			}
		}
		return result;
	}

	/**
	 * 批量保存数据权限
	 * @param  dataPurviewList 数据权限数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveDataPurview(List<DataPurviewDTO> dataPurviewList) {
		long result = 0;
		result = dataPurviewManager.batchSaveDataPurview(dataPurviewList);
		return result;
	}

	/**
	 * 批量保存权限
	 * @param userId 用户标识
	 * @param secDataJson 权限对象SEC数据JSON字符串数组
	 * @param prviewFucntionDataJson 权限功能数据JSON字符串数组
	 * @param rangeSecDataJson 范围权限对象SEC数据JSON字符串数组
	 * @return <code>0<code>保存成功
	 */
	@Override
	@SuppressWarnings("unchecked")
	public long batchSavePurview(Long userId, String secDataJson, String prviewFucntionDataJson, String rangeSecDataJson) {
		long result = 0;
		SessionUser su = sessionUserService.getSessionUser(userId);
		/** 选中的权限身份SEC集合需要递归求出所有权限身份节点*/
		Map<String, Object> secDataMap = JSON.parseObject(secDataJson, Map.class);
		List<Map<String, Object>> secDataListMap = new ArrayList<Map<String, Object>>();
		secDataListMap.add(secDataMap);

		/** 选中的权限功能集合*/
		List<Map<String, Object>> purviewFucntionDataListMap = JSON.parseObject(prviewFucntionDataJson, List.class);

		/** 选中的权限身份范围SEC集合*/
		List<Map<String, Object>> rangeSecDataListMap = JSON.parseObject(rangeSecDataJson, List.class);

		/** 菜单权限批量新增对象*/
		List<MenuPurviewDTO> menuPurviewList = new ArrayList<MenuPurviewDTO>();

		/** 功能权限批量新增对象*/
		List<FunctionPurviewDTO> functionPurviewList = new ArrayList<FunctionPurviewDTO>();

		/** 数据权限批量新增对象*/
		List<DataPurviewDTO> dataPurviewList = new ArrayList<DataPurviewDTO>();
		if (secDataListMap != null && secDataListMap.size() > 0 && purviewFucntionDataListMap != null && purviewFucntionDataListMap.size() > 0) {
			for (Map<String, Object> secMap : secDataListMap) {
				String secId = StringUtils.trim(secMap.get("secId"));
				String secName = StringUtils.trim(secMap.get("secName"));
				menuPurviewManager.deleteMenuPurviewBySecId(secId);
				functionPurviewManager.deleteFunctionPurviewBySecId(secId);
				dataPurviewManager.deleteDataPurviewBySecId(secId);
				for (Map<String, Object> purviewFunctionMap : purviewFucntionDataListMap) {
					String menuId = StringUtils.trim(purviewFunctionMap.get("menuId"));
					MenuPurviewDTO menuPurviewDTO = new MenuPurviewDTO();
					menuPurviewDTO.setTitle("");
					menuPurviewDTO.setSecId(secId);
					menuPurviewDTO.setSecName(secName);
					menuPurviewDTO.setMenuId(StringUtils.getAsLong(menuId));
					menuPurviewDTO.setCreateBy(su.getId());
					menuPurviewDTO.setCreateName(su.getFullname());
					menuPurviewList.add(menuPurviewDTO);
					String functionJsonStr = StringUtils.trim(purviewFunctionMap.get("functions"));
					List<Map<String, Object>> fucntionListMap = JSON.parseObject(functionJsonStr, List.class);
					if (fucntionListMap != null && fucntionListMap.size() > 0) {
						for (Map<String, Object> functionMap : fucntionListMap) {
							boolean checked = (Boolean) functionMap.get("checked");
							String functionId = StringUtils.trim(functionMap.get("id"));
							String functionCode = StringUtils.trim(functionMap.get("code"));
							if (checked) {
								FunctionPurviewDTO functionPurviewDTO = new FunctionPurviewDTO();
								functionPurviewDTO.setTitle("");
								functionPurviewDTO.setSecId(secId);
								functionPurviewDTO.setSecName(secName);
								functionPurviewDTO.setMenuId(StringUtils.getAsLong(menuId));
								functionPurviewDTO.setFunctionId(StringUtils.getAsLong(functionId));
								functionPurviewDTO.setFunctionCode(functionCode);
								functionPurviewDTO.setCreateBy(su.getId());
								functionPurviewDTO.setCreateName(su.getName());
								functionPurviewList.add(functionPurviewDTO);
							}

						}
					}
					if (rangeSecDataListMap != null && rangeSecDataListMap.size() > 0) {
						for (Map<String, Object> rangeSecMap : rangeSecDataListMap) {
							String rangeSecId = StringUtils.trim(rangeSecMap.get("secId"));
							if (rangeSecId.indexOf("OP") > 0) {
								continue;
							}
							String rangeSecName = StringUtils.trim(rangeSecMap.get("secName"));
							DataPurviewDTO dataPurviewDTO = new DataPurviewDTO();
							dataPurviewDTO.setTitle("");
							dataPurviewDTO.setSecId(secId);
							dataPurviewDTO.setSecName(secName);
							dataPurviewDTO.setMenuId(StringUtils.getAsLong(menuId));
							dataPurviewDTO.setRangeSecId(rangeSecId);
							dataPurviewDTO.setRangeSecName(rangeSecName);
							dataPurviewDTO.setCreateBy(su.getId());
							dataPurviewDTO.setCreateName(su.getName());
							dataPurviewList.add(dataPurviewDTO);
						}
					}

				}
			}
		}
		/** 菜单权限批量授权开始*/
		if (menuPurviewList != null && menuPurviewList.size() > 0) {
			batchSaveMenuPurview(menuPurviewList);
		}
		/** 菜单权限批量授权结束*/
		/** 功能权限批量授权开始*/
		if (functionPurviewList != null && functionPurviewList.size() > 0) {
			batchSaveFunctionPurview(functionPurviewList);
		}
		/** 功能权限批量授权结束*/
		/** 数据权限批量授权开始*/
		if (dataPurviewList != null && dataPurviewList.size() > 0) {
			batchSaveDataPurview(dataPurviewList);
		}
		return result;
	}

	/**
	 * 根据权限对象标识删除数据权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	@Override
	public long deleteDataPurviewBySecId(String secId) {
		return 0;
	}

	/**
	 * 根据条件获取系统权限组织机构树
	 * @param condition 查询条件
	 * @return 系统权限组织树
	 */
	public List<OrgDTO> getPurviewOrgTree(Map<String, Object> condition) {
		Long rootId = StringUtils.getAsLong(StringUtils.trim(condition.get("rootId")));
		Long createBy = StringUtils.getAsLong(StringUtils.trim(condition.get("createBy")));
		Map<String, Object> sessionUserCondition = new HashMap<String, Object>(16);
		sessionUserCondition.put("id", createBy);
		SessionUser su = sessionUserService.getSessionUser(createBy);
		Map<String, Object> orgCondition = new HashMap<String, Object>(16);
		List<OrgDTO> orgList = orgService.getOrgList(orgCondition);
		List<OrgDTO> rsList = new ArrayList<OrgDTO>();
		long adminId=999999L;
		if (su.getId() != adminId) {
			List<Long> cNs = su.getCNs();
			if (cNs != null && cNs.size() > 0) {
				OrgDTO orgDTO = orgService.getOrgById(cNs.get(0));
				if (cNs.size() > 1) {
					logger.error("系统管理用户:" + su.getName() + "属于两个部门.现取默认部门" + orgDTO.getName());
				}
				constructOrgTreeDesc(orgDTO.getId(), orgList, rsList);
				constructOrgTreeAsc(orgDTO.getId(), orgList, rsList);
			} else {
				logger.error("请把" + su.getName() + "放在该下面相应部门用户下面!");
			}
		} else {
			constructOrgTreeAsc(rootId, orgList, rsList);
		}
		return rsList;
	}

	/**
	 * 从某一个节点正向递归
	 * @param rootId  节点ID
	 * @param orgList 所有的组织机构集合
	 * @param rsList  返回处理后的组织信息
	 */
	public void constructOrgTreeAsc(long rootId, List<OrgDTO> orgList, List<OrgDTO> rsList) {
		if (orgList != null && orgList.size() > 0) {
			for (OrgDTO orgDTO : orgList) {
				if (orgDTO.getParentId() == rootId) {
					rsList.add(orgDTO);
					constructOrgTreeAsc(orgDTO.getId(), orgList, rsList);
				}
			}
		}
	}

	/**
	 * 从某一个节点逆向递归
	 * @param pid 节点ID
	 * @param orgList 所有的组织机构集合
	 * @param rsList  返回处理后的组织信息
	 */
	public void constructOrgTreeDesc(long pid, List<OrgDTO> orgList, List<OrgDTO> rsList) {
		if (orgList != null && orgList.size() > 0) {
			for (OrgDTO orgDTO : orgList) {
				if (pid == orgDTO.getId()) {
					rsList.add(orgDTO);
					constructOrgTreeDesc(orgDTO.getParentId(), orgList, rsList);
				}
			}
		}
	}

	/**
	 * 根据条件获取系统权限对象树
	 * @param userId 用户标识
	 * @param pvSql 数据权限SQL
	 * @return 系统权限对象树
	 */
	@Override
	public List<PurviewSecTreeDTO> getPurviewSecTree(Long userId, String pvSql) {
		/** 数据权限控制*/
		List<PurviewSecTreeDTO> rs = new ArrayList<PurviewSecTreeDTO>();
		PurviewSecTreeDTO rootPurviewSecTreeDTO = new PurviewSecTreeDTO();
		rootPurviewSecTreeDTO.setSecId("0");
		rootPurviewSecTreeDTO.setSecName("权限对象");
		rootPurviewSecTreeDTO.setParentSecId("-1");
		rs.add(rootPurviewSecTreeDTO);
		Map<String, Object> orgCondition = new HashMap<String, Object>(16);
		orgCondition.put("rootId", "0");
		orgCondition.put("createBy", userId);
		List<OrgDTO> orgList = getPurviewOrgTree(orgCondition);
		if (orgList != null && orgList.size() > 0) {
			for (OrgDTO orgDTO : orgList) {
				PurviewSecTreeDTO orgSecTreeDTO = new PurviewSecTreeDTO();
				orgSecTreeDTO.setSecId("O" + orgDTO.getId());
				orgSecTreeDTO.setSecName(orgDTO.getName());
				if (orgDTO.getId() == 1) {
					orgSecTreeDTO.setSecName("组织部门");
					orgSecTreeDTO.setParentSecId(orgDTO.getParentId() + "");
				} else {
					orgSecTreeDTO.setParentSecId("O" + orgDTO.getParentId());
				}
				rs.add(orgSecTreeDTO);
			}
		}

		/** 已组织ID为key 存储组织岗位数据开始*/
		Map<Long, List<PostDTO>> postMap = new HashMap<Long, List<PostDTO>>(16);
		Map<String, Object> postCondition = new HashMap<String, Object>(16);
		postCondition.put("pv", pvSql);
		List<PostDTO> postList = postService.getPostList(postCondition);
		for (PostDTO postDTO : postList) {
			long orgId = postDTO.getOrgId();
			if (postMap.containsKey(orgId)) {
				postMap.get(orgId).add(postDTO);
			} else {
				List<PostDTO> plist = new ArrayList<PostDTO>();
				plist.add(postDTO);
				postMap.put(orgId, plist);
			}
		}
		/** 已组织ID为key 存储组织岗位数据结束*/

		if (orgList != null && orgList.size() > 0) {
			for (OrgDTO orgDTO : orgList) {
				PurviewSecTreeDTO orgSecTreeDTO = new PurviewSecTreeDTO();
				orgSecTreeDTO.setSecId("OP" + orgDTO.getId());
				orgSecTreeDTO.setSecName(orgDTO.getName());
				if (orgDTO.getId() == 1) {
					orgSecTreeDTO.setSecName("组织岗位");
					orgSecTreeDTO.setParentSecId(orgDTO.getParentId() + "");
				} else {
					orgSecTreeDTO.setParentSecId("OP" + orgDTO.getParentId());
				}
				rs.add(orgSecTreeDTO);
				if (postMap.containsKey(orgDTO.getId())) {
					for (PostDTO postDTO : postMap.get(orgDTO.getId())) {
						PurviewSecTreeDTO orgPostSecTreeDTO = new PurviewSecTreeDTO();
						orgPostSecTreeDTO.setSecId("P" + postDTO.getId());
						orgPostSecTreeDTO.setSecName(postDTO.getName());
						orgPostSecTreeDTO.setParentSecId("OP" + orgDTO.getId());
						rs.add(orgPostSecTreeDTO);
					}
				}
			}
		}

		PurviewSecTreeDTO rootPostTypePurviewSecTreeDTO = new PurviewSecTreeDTO();
		rootPostTypePurviewSecTreeDTO.setSecId("T-1000000000");
		rootPostTypePurviewSecTreeDTO.setSecName("岗位类型");
		rootPostTypePurviewSecTreeDTO.setParentSecId("0");
		rs.add(rootPostTypePurviewSecTreeDTO);
		Map<String, Object> postTypeCondition = new HashMap<String, Object>(16);
		postTypeCondition.put("pv", pvSql);
		List<PostTypeDTO> postTypeList = postTypeService.getPostTypeList(postTypeCondition);
		if (postTypeList != null && postTypeList.size() > 0) {
			for (PostTypeDTO postTypeDTO : postTypeList) {
				PurviewSecTreeDTO postTypeSecTreeDTO = new PurviewSecTreeDTO();
				postTypeSecTreeDTO.setSecId("T" + postTypeDTO.getId());
				postTypeSecTreeDTO.setSecName(postTypeDTO.getName());
				postTypeSecTreeDTO.setParentSecId("T-1000000000");
				rs.add(postTypeSecTreeDTO);
			}
		}

		PurviewSecTreeDTO rootDomainPurviewSecTreeDTO = new PurviewSecTreeDTO();
		rootDomainPurviewSecTreeDTO.setSecId("D-1000000000");
		rootDomainPurviewSecTreeDTO.setSecName("群组");
		rootDomainPurviewSecTreeDTO.setParentSecId("0");
		rs.add(rootDomainPurviewSecTreeDTO);
		Map<String, Object> domainCondition = new HashMap<String, Object>(16);
		domainCondition.put("pv", pvSql);
		List<DomainDTO> domainList = domainService.getDomainList(domainCondition);
		if (domainList != null && domainList.size() > 0) {
			for (DomainDTO domainDTO : domainList) {
				PurviewSecTreeDTO domainSecTreeDTO = new PurviewSecTreeDTO();
				domainSecTreeDTO.setSecId("D" + domainDTO.getId());
				domainSecTreeDTO.setSecName(domainDTO.getName());
				domainSecTreeDTO.setParentSecId("D-1000000000");
				rs.add(domainSecTreeDTO);
			}
		}

		PurviewSecTreeDTO rootUserPurviewSecTreeDTO = new PurviewSecTreeDTO();
		rootUserPurviewSecTreeDTO.setSecId("U-1000000000");
		rootUserPurviewSecTreeDTO.setSecName("用户");
		rootUserPurviewSecTreeDTO.setParentSecId("0");
		rs.add(rootUserPurviewSecTreeDTO);
		Map<String, Object> userCondition = new HashMap<String, Object>(16);
		userCondition.put("pv", pvSql);
		List<UserDTO> userList = userService.getUserList(userCondition);
		if (userList != null && userList.size() > 0) {
			for (UserDTO userDTO : userList) {
				PurviewSecTreeDTO userSecTreeDTO = new PurviewSecTreeDTO();
				userSecTreeDTO.setSecId("U" + userDTO.getId());
				userSecTreeDTO.setSecName(userDTO.getName());
				userSecTreeDTO.setParentSecId("U-1000000000");
				rs.add(userSecTreeDTO);
			}
		}
		return rs;
	}

	/**
	 * 根据条件获取系统权限功能树
	 * @param userId 用户标识
	 * @param secId 权限对象标识
	 * @return 系统功能对象集合
	 */
	@Override
	public List<PurviewFunctionTreeDTO> getPurviewFucntionTree(Long userId, String secId) {
		List<PurviewFunctionTreeDTO> rs = new ArrayList<PurviewFunctionTreeDTO>();
		PurviewFunctionTreeDTO rootPurviewFunctionTreeDTO = new PurviewFunctionTreeDTO();
		rootPurviewFunctionTreeDTO.setMenuId(0L);
		rootPurviewFunctionTreeDTO.setMenuName("根节点");
		rootPurviewFunctionTreeDTO.setParentMenuId(-1L);
		rs.add(rootPurviewFunctionTreeDTO);
		/** 已菜单ID为建 存储系统功能*/
		Map<Long, List<FunctionDTO>> functoinMap = new HashMap<Long, List<FunctionDTO>>(16);
		Map<String, Object> functionCondition = new HashMap<String, Object>(16);
		List<FunctionDTO> functionList = functionService.getFunctionList(functionCondition);
		for (FunctionDTO functionDTO : functionList) {
			long menuId = functionDTO.getMenuId();
			if (functoinMap.containsKey(menuId)) {
				functoinMap.get(menuId).add(functionDTO);
			} else {
				List<FunctionDTO> flist = new ArrayList<FunctionDTO>();
				flist.add(functionDTO);
				functoinMap.put(menuId, flist);
			}
		}

		/** 用户权限授权树菜单默认选中开始*/
		Map<String, Object> menuPurviewCondition = new HashMap<String, Object>(16);
		List<MenuPurviewDTO> menuPurviewList = new ArrayList<MenuPurviewDTO>();
		Map<Long, Boolean> menuPurviewMap = new HashMap<Long, Boolean>(16);
		if (StringUtils.hasText(secId)) {
			menuPurviewCondition.put("secId", secId);
			menuPurviewList = getMenuPurviewList(menuPurviewCondition);
			for (MenuPurviewDTO menuPurviewDTO : menuPurviewList) {
				menuPurviewMap.put(menuPurviewDTO.getMenuId(), true);
			}
		}
		/** 用户权限授权树功能菜单默认选中结束*/

		/** 用户权限授权树功能默认选中开始*/
		Map<String, Object> functionPurviewCondition = new HashMap<String, Object>(16);
		List<FunctionPurviewDTO> functionPurviewList = new ArrayList<FunctionPurviewDTO>();
		Map<String, Boolean> functoinPurviewMap = new HashMap<String, Boolean>(16);
		if (StringUtils.hasText(secId)) {
			functionPurviewCondition.put("secId", secId);
			functionPurviewList = getFunctionPurviewList(functionPurviewCondition);
			for (FunctionPurviewDTO functionPurviewDTO : functionPurviewList) {
				functoinPurviewMap.put(functionPurviewDTO.getMenuId() + "_" + functionPurviewDTO.getFunctionId(), true);
			}
		}
		/** 用户权限授权树功能默认选中结束*/

		Map<String, Object> menuCondition = new HashMap<String, Object>(16);
		long rootId = 0L;
		menuCondition.put("parentId", rootId);
		menuCondition.put("userId", userId);
		List<MenuDTO> menuList = menuService.getPurviewMenuTree(menuCondition);
		if (menuList != null && menuList.size() > 0) {
			for (int i = 0, len = menuList.size(); i < len; i++) {
				MenuDTO menuDTO = menuList.get(i);
				long id = menuDTO.getId();
				PurviewFunctionTreeDTO purviewFunctionTreeDTO = new PurviewFunctionTreeDTO();
				purviewFunctionTreeDTO.setMenuId(id);
				purviewFunctionTreeDTO.setMenuName(menuDTO.getName());
				purviewFunctionTreeDTO.setParentMenuId(menuDTO.getParentId());

				if (menuPurviewMap.containsKey(menuDTO.getId())) {
					purviewFunctionTreeDTO.setChecked(true);
				} else {
					purviewFunctionTreeDTO.setChecked(false);
				}
				List<Map<String, Object>> pvFunctionList = new ArrayList<Map<String, Object>>();
				if (functoinMap.containsKey(id)) {
					List<FunctionDTO> functionDTOAllList = functoinMap.get(id);
					for (FunctionDTO f : functionDTOAllList) {
						Map<String, Object> functionMap = new LinkedHashMap<String, Object>();
						functionMap.put("id", f.getId());
						functionMap.put("code", f.getCode());
						functionMap.put("action", f.getCode());
						functionMap.put("name", f.getName());

						if (functoinPurviewMap.containsKey(menuDTO.getId() + "_" + f.getId())) {
							functionMap.put("checked", true);
						} else {
							functionMap.put("checked", false);
						}
						pvFunctionList.add(functionMap);
					}
				}
				purviewFunctionTreeDTO.setFunctions(pvFunctionList);
				rs.add(purviewFunctionTreeDTO);
			}
		}
		return rs;
	}

	/**
	 * 根据条件获取系统权限范围对象树
	 * @param userId 用户标识
	 * @param secId  权限资源对象
	 * @param pvSql  数据权限SQL
	 * @return 系统权限范围对象树
	 */
	@Override
	public List<PurviewSecTreeDTO> getPurviewRangeSecTree(Long userId, String secId, String pvSql) {
		String pv = pvSql;
		/** 权限范围对象默认选中开始*/
		Map<String, Object> dataPurviewCondition = new HashMap<String, Object>(16);
		List<DataPurviewDTO> dataPurviewList = new ArrayList<DataPurviewDTO>();
		Map<String, Boolean> dataPurviewMap = new HashMap<String, Boolean>(16);
		if (StringUtils.hasText(secId)) {
			dataPurviewCondition.put("secId", secId);
			dataPurviewList = getDataPurviewList(dataPurviewCondition);
			for (DataPurviewDTO dataPurviewDTO : dataPurviewList) {
				dataPurviewMap.put(dataPurviewDTO.getRangeSecId(), true);
			}
		}
		/** 权限范围对象默认选中结束*/
		Long createBy = userId;
		List<PurviewSecTreeDTO> rs = new ArrayList<PurviewSecTreeDTO>();
		PurviewSecTreeDTO rootPurviewSecTreeDTO = new PurviewSecTreeDTO();
		rootPurviewSecTreeDTO.setSecId("0");
		rootPurviewSecTreeDTO.setSecName("权限对象");
		rootPurviewSecTreeDTO.setParentSecId("-1");
		rs.add(rootPurviewSecTreeDTO);
		Map<String, Object> orgCondition = new HashMap<String, Object>(16);
		orgCondition.put("rootId", "0");
		orgCondition.put("createBy", createBy);
		List<OrgDTO> orgList = getPurviewOrgTree(orgCondition);
		if (orgList != null && orgList.size() > 0) {
			for (OrgDTO orgDTO : orgList) {
				PurviewSecTreeDTO orgSecTreeDTO = new PurviewSecTreeDTO();
				orgSecTreeDTO.setSecId("O" + orgDTO.getId());
				orgSecTreeDTO.setSecName(orgDTO.getName());
				if (orgDTO.getId() == 1) {
					orgSecTreeDTO.setSecName("组织部门");
					orgSecTreeDTO.setParentSecId(orgDTO.getParentId() + "");
				} else {
					orgSecTreeDTO.setParentSecId("O" + orgDTO.getParentId());
				}
				if (dataPurviewMap.containsKey(orgSecTreeDTO.getSecId())) {
					orgSecTreeDTO.setChecked(true);
				} else {
					orgSecTreeDTO.setChecked(false);
				}
				rs.add(orgSecTreeDTO);
			}
		}

		/** 已组织ID为key 存储组织岗位数据开始*/
		Map<Long, List<PostDTO>> postMap = new HashMap<Long, List<PostDTO>>(16);
		Map<String, Object> postCondition = new HashMap<String, Object>(16);
		postCondition.put("pv", pv);
		List<PostDTO> postList = postService.getPostList(postCondition);
		for (PostDTO postDTO : postList) {
			long orgId = postDTO.getOrgId();
			if (postMap.containsKey(orgId)) {
				postMap.get(orgId).add(postDTO);
			} else {
				List<PostDTO> plist = new ArrayList<PostDTO>();
				plist.add(postDTO);
				postMap.put(orgId, plist);
			}
		}
		/** 已组织ID为key 存储组织岗位数据结束*/

		if (orgList != null && orgList.size() > 0) {
			for (OrgDTO orgDTO : orgList) {
				PurviewSecTreeDTO orgSecTreeDTO = new PurviewSecTreeDTO();
				orgSecTreeDTO.setSecId("OP" + orgDTO.getId());
				orgSecTreeDTO.setSecName(orgDTO.getName());
				if (orgDTO.getId() == 1) {
					orgSecTreeDTO.setSecName("组织岗位");
					orgSecTreeDTO.setParentSecId(orgDTO.getParentId() + "");
				} else {
					orgSecTreeDTO.setParentSecId("OP" + orgDTO.getParentId());
				}
				rs.add(orgSecTreeDTO);
				if (postMap.containsKey(orgDTO.getId())) {
					for (PostDTO postDTO : postMap.get(orgDTO.getId())) {
						PurviewSecTreeDTO orgPostSecTreeDTO = new PurviewSecTreeDTO();
						orgPostSecTreeDTO.setSecId("P" + postDTO.getId());
						orgPostSecTreeDTO.setSecName(postDTO.getName());
						orgPostSecTreeDTO.setParentSecId("OP" + orgDTO.getId());
						if (dataPurviewMap.containsKey(orgPostSecTreeDTO.getSecId())) {
							orgPostSecTreeDTO.setChecked(true);
						} else {
							orgPostSecTreeDTO.setChecked(false);
						}
						rs.add(orgPostSecTreeDTO);
					}
				}
			}
		}

		PurviewSecTreeDTO rootPostTypePurviewSecTreeDTO = new PurviewSecTreeDTO();
		rootPostTypePurviewSecTreeDTO.setSecId("T-1000000000");
		rootPostTypePurviewSecTreeDTO.setSecName("岗位类型");
		rootPostTypePurviewSecTreeDTO.setParentSecId("0");
		rs.add(rootPostTypePurviewSecTreeDTO);
		Map<String, Object> postTypeCondition = new HashMap<String, Object>(16);
		postTypeCondition.put("pv", pv);
		List<PostTypeDTO> postTypeList = postTypeService.getPostTypeList(postTypeCondition);
		if (postTypeList != null && postTypeList.size() > 0) {
			for (PostTypeDTO postTypeDTO : postTypeList) {
				PurviewSecTreeDTO postTypeSecTreeDTO = new PurviewSecTreeDTO();
				postTypeSecTreeDTO.setSecId("T" + postTypeDTO.getId());
				postTypeSecTreeDTO.setSecName(postTypeDTO.getName());
				postTypeSecTreeDTO.setParentSecId("T-1000000000");
				if (dataPurviewMap.containsKey(postTypeSecTreeDTO.getSecId())) {
					postTypeSecTreeDTO.setChecked(true);
				} else {
					postTypeSecTreeDTO.setChecked(false);
				}
				rs.add(postTypeSecTreeDTO);
			}
		}

		PurviewSecTreeDTO rootDomainPurviewSecTreeDTO = new PurviewSecTreeDTO();
		rootDomainPurviewSecTreeDTO.setSecId("D-1000000000");
		rootDomainPurviewSecTreeDTO.setSecName("群组");
		rootDomainPurviewSecTreeDTO.setParentSecId("0");
		rs.add(rootDomainPurviewSecTreeDTO);
		Map<String, Object> domainCondition = new HashMap<String, Object>(16);
		domainCondition.put("pv", pv);
		List<DomainDTO> domainList = domainService.getDomainList(domainCondition);
		if (domainList != null && domainList.size() > 0) {
			for (DomainDTO domainDTO : domainList) {
				PurviewSecTreeDTO domainSecTreeDTO = new PurviewSecTreeDTO();
				domainSecTreeDTO.setSecId("D" + domainDTO.getId());
				domainSecTreeDTO.setSecName(domainDTO.getName());
				domainSecTreeDTO.setParentSecId("D-1000000000");
				if (dataPurviewMap.containsKey(domainSecTreeDTO.getSecId())) {
					domainSecTreeDTO.setChecked(true);
				} else {
					domainSecTreeDTO.setChecked(false);
				}
				rs.add(domainSecTreeDTO);
			}
		}

		PurviewSecTreeDTO rootUserPurviewSecTreeDTO = new PurviewSecTreeDTO();
		rootUserPurviewSecTreeDTO.setSecId("U-1000000000");
		rootUserPurviewSecTreeDTO.setSecName("用户");
		rootUserPurviewSecTreeDTO.setParentSecId("0");
		rs.add(rootUserPurviewSecTreeDTO);
		Map<String, Object> userCondition = new HashMap<String, Object>(16);
		userCondition.put("pv", pv);
		List<UserDTO> userList = userService.getUserList(userCondition);
		if (userList != null && userList.size() > 0) {
			for (UserDTO userDTO : userList) {
				PurviewSecTreeDTO userSecTreeDTO = new PurviewSecTreeDTO();
				userSecTreeDTO.setSecId("U" + userDTO.getId());
				userSecTreeDTO.setSecName(userDTO.getName());
				userSecTreeDTO.setParentSecId("U-1000000000");
				if (dataPurviewMap.containsKey(userSecTreeDTO.getSecId())) {
					userSecTreeDTO.setChecked(true);
				} else {
					userSecTreeDTO.setChecked(false);
				}
				rs.add(userSecTreeDTO);
			}
		}
		return rs;
	}

	/***
	 * 校验接口地址是否具有权限
	 * @param userId 用户标识
	 * @param apiUrl 接口地址
	 * @return <code>true</code>有权限<code>false</code>无权限
	 */
	@Override
	public boolean checkPurview(Long userId, String apiUrl) {
		Map<String, FunctionPurviewDTO> allFunctionPurviewMap = new HashMap<String, FunctionPurviewDTO>(16);
		SessionUser su = sessionUserService.getSessionUser(userId);
		List<String> secIdList = sessionUserService.getUserAllSFStr(su);
		Map<String, Object> functionPurviewCondition = new HashMap<String, Object>(16);
		functionPurviewCondition.put("secIds", secIdList);
		List<FunctionPurviewDTO> functionPurviewList = getFunctionPurviewList(functionPurviewCondition);
		if (functionPurviewList != null && functionPurviewList.size() > 0) {
			for (FunctionPurviewDTO functionPurviewDTO : functionPurviewList) {
				Map<String, Object> functionApiRelCondition = new HashMap<String, Object>(16);
				functionApiRelCondition.put("functionId", functionPurviewDTO.getFunctionId());
				List<FunctionApiRelDTO> functionApiRelList = functionService.getFunctionApiRelList(functionApiRelCondition);
				if (functionApiRelList != null && functionApiRelList.size() > 0) {
					for (FunctionApiRelDTO functionApiRelDTO : functionApiRelList) {
						allFunctionPurviewMap.put(functionApiRelDTO.getUrl(), functionPurviewDTO);
					}
				}

			}
		}
		return allFunctionPurviewMap.containsKey(apiUrl);
	}

	/***
	 * 校验功能编码是否具有功能权限
	 * @param userId 用户标识
	 * @param functionCode 功能编码
	 * @return <code>true</code>有权限<code>false</code>无权限
	 */
	@Override
	public boolean checkFunctionPurview(Long userId, String functionCode) {
		Map<String, FunctionPurviewDTO> allFunctionPurviewMap = new HashMap<String, FunctionPurviewDTO>(16);
		SessionUser su = sessionUserService.getSessionUser(userId);
		List<String> secIdList = sessionUserService.getUserAllSFStr(su);
		Map<String, Object> functionPurviewCondition = new HashMap<String, Object>(16);
		functionPurviewCondition.put("secIds", secIdList);
		List<FunctionPurviewDTO> functionPurviewList = getFunctionPurviewList(functionPurviewCondition);
		if (functionPurviewList != null && functionPurviewList.size() > 0) {
			for (FunctionPurviewDTO functionPurviewDTO : functionPurviewList) {
				allFunctionPurviewMap.put(functionPurviewDTO.getFunctionCode(), functionPurviewDTO);
			}
		}
		return allFunctionPurviewMap.containsKey(functionCode);
	}

}