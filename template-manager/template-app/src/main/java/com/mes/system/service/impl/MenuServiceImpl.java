package com.mes.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.core.utils.StringUtils;
import com.mes.system.bean.SessionUser;
import com.mes.system.dto.MenuDTO;
import com.mes.system.dto.MenuPurviewDTO;
import com.mes.system.manager.MenuManager;
import com.mes.system.service.MenuService;
import com.mes.system.service.PurviewService;
import com.mes.system.service.SessionUserService;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.service.impl]    
 * 类名称:		[MenuServiceImpl]  
 * 类描述:		[菜单业务处理类]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月17日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月17日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuManager menuManager;

	@Autowired
	private SessionUserService sessionUserService;
	
	@Autowired
	private PurviewService purviewService;

	/**
	 * 根据菜单标识获取菜单
	 * @param id 菜单标识
	 * @return 菜单对象
	 */
	@Override
	public MenuDTO getMenuById(Long id) {
		MenuDTO menuDTO = menuManager.getMenuById(id);
		return menuDTO;
	}

	/**
	 * 根据条件获取菜单列表
	 * @param condition 查询条件
	 * @return 菜单列表
	 */
	@Override
	public List<MenuDTO> getMenuList(Map<String, Object> condition) {
		List<MenuDTO> menuList = menuManager.getMenuList(condition);
		return menuList;
	}

	/**
	 * 保存菜单
	 * @param menuDTO 菜单对象
	 * @return 新增后的菜单对象
	 */
	@Override
	public MenuDTO saveMenu(MenuDTO menuDTO) {
		menuDTO.setCreateTime(new Date());
		menuManager.saveMenu(menuDTO);
		return menuDTO;
	}

	/**
	 * 更新菜单
	 * @param menuDTO 菜单对象
	 * @return 更新后的菜单对象
	 */
	@Override
	public MenuDTO updateMenu(MenuDTO menuDTO) {
		menuDTO.setUpdateTime(new Date());
		menuManager.updateMenu(menuDTO);
		return menuDTO;
	}

	/**
	 * 根据菜单标识删除菜单
	 * @param id 菜单标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteMenuById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				menuManager.deleteMenuById(StringUtils.getAsLong(idStr, 0L));
			}
		}
		return result;
	}

	/**
	 * 批量保存菜单
	 * @param  menuList 菜单数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveMenu(List<MenuDTO> menuList) {
		long result = 0;
		result = menuManager.batchSaveMenu(menuList);
		return result;
	}

	/**
	 * 根据用户标识获取主界面顶部菜单列表
	 * @param userId 用户标识
	 * @return 主界面顶部菜单列表
	 */
	@Override
	public List<MenuDTO> getMainTopMenuList(Long userId) {
		Map<String, Object> menuCondition = new HashMap<String, Object>(16);
		menuCondition.put("parentId", 0L);
		menuCondition.put("sortField", "sort");
		menuCondition.put("sortOrder", "asc");
		List<MenuDTO> menuList = menuManager.getMenuList(menuCondition);
		List<MenuDTO> rsList = getPurviewMenuList(Long.valueOf(userId), menuList);
		return rsList;
	}

	/**
	 * 根据条件获取主界面左边菜单树
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 主界面左边菜单树
	 */
	@Override
	public List<MenuDTO> getMainLeftMenuTree(Long userId, Long parentId) {
		Map<String, Object> menuCondition = new HashMap<String, Object>(16);
		menuCondition.put("sortField", "sort");
		menuCondition.put("sortOrder", "asc");
		List<MenuDTO> menuList = menuManager.getMenuList(menuCondition);
		List<MenuDTO> allMenuList = new ArrayList<MenuDTO>();
		constructMenuTree(parentId, menuList, allMenuList);
		List<MenuDTO> rsList = getPurviewMenuList(userId, allMenuList);
		return rsList;
	}

	/**
	 * 根据条件获取带有权限的菜单树
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 主界面左边菜单树
	 */
	@Override
	public List<MenuDTO> getPurviewMenuTree(Long userId, Long parentId) {
		Map<String, Object> menuCondition = new HashMap<String, Object>(16);
		menuCondition.put("sortField", "sort");
		menuCondition.put("sortOrder", "asc");
		List<MenuDTO> menuList = menuManager.getMenuList(menuCondition);
		List<MenuDTO> allMenuList = new ArrayList<MenuDTO>();
		constructMenuTree(parentId, menuList, allMenuList);
		List<MenuDTO> rsList = getPurviewMenuList(userId, allMenuList);
		return rsList;
	}

	/**
	 * 根据条件返回带有权限的菜单集合
	 * @param userId  用户标识
	 * @param menuList 待处理的菜单集合
	 * @return 具有权限的菜单集合
	 */
	private List<MenuDTO> getPurviewMenuList(Long userId, List<MenuDTO> menuList) {
		List<MenuDTO> rsList = new ArrayList<MenuDTO>();
		long adminId=999999L;
		if (userId == adminId) {
			rsList = menuList;
		} else {
			if (menuList != null && menuList.size() > 0) {
				Map<Long, MenuDTO> purviewMenuMap = getPurviewMenuMap(userId);
				for (MenuDTO menuDTO : menuList) {
					if (purviewMenuMap.containsKey(menuDTO.getId())) {
						rsList.add(menuDTO);
					}
				}
			}
		}
		return rsList;
	}

	/**
	 * 根据用户标识获取带有权限的菜单Map<menuId,menuDTO>对象(键为菜单标识值为菜单对象)
	 * @param userId 用户标识
	 * @return 有权限的菜单Map<menuId,menuDTO>对象
	 */
	private Map<Long, MenuDTO> getPurviewMenuMap(Long userId) {
		SessionUser su = sessionUserService.getSessionUser(userId);
		List<String> allUserSF = sessionUserService.getUserAllSFStr(su);
		List<MenuDTO> menuList = getMenuList(new HashMap<String, Object>(16));
		Map<Long, MenuDTO> rsMap = new LinkedHashMap<Long, MenuDTO>();
		Map<String, Object> menuPurviewCondition = new HashMap<String, Object>(16);
		menuPurviewCondition.put("secIds", allUserSF);
		List<MenuPurviewDTO> menuPurviewList = purviewService.getMenuPurviewList(menuPurviewCondition);
		if (menuPurviewList != null && menuPurviewList.size() > 0) {
			for (MenuPurviewDTO menuPurviewDTO : menuPurviewList) {
				constructPurviewMenuTreeDesc(menuPurviewDTO.getMenuId(), menuList, rsMap);
			}
		}
		return rsMap;
	}

	/**
	 * 递归构件菜单树
	 * @param rootId
	 * @param menuList
	 * @param rsList
	 */
	private void constructMenuTree(long rootId, List<MenuDTO> menuList, List<MenuDTO> rsList) {
		for (MenuDTO menuDTO : menuList) {
			if (menuDTO.getParentId() == rootId) {
				rsList.add(menuDTO);
				constructMenuTree(menuDTO.getId(), menuList, rsList);
			}
		}
	}

	/**
	 * 构件权限的菜单节点(从某一个节点逆向递归)
	 * @param pid 节点ID
	 * @param orgList 所有的菜单集合
	 * @param rsList  返回处理后的菜单信息
	 */
	private void constructPurviewMenuTreeDesc(long pid, List<MenuDTO> menuList, Map<Long, MenuDTO> rsMap) {
		for (int i = 0; i < menuList.size(); i++) {
			MenuDTO menuDTO = (MenuDTO) menuList.get(i);
			if (pid == menuDTO.getId()) {
				rsMap.put(menuDTO.getId(), menuDTO);
				constructPurviewMenuTreeDesc(menuDTO.getParentId(), menuList, rsMap);
			}
		}
	}

	/**
	 * 根据条件获取带有权限的菜单树
	 * @param condition 查询条件
	 * <li>put("parentId",父节点标识--必须)</li>
	 * <li>put("userId",用户标识--必须)</li>
	 *  @return 递归菜单集合对象
	 */
	@Override
	public List<MenuDTO> getPurviewMenuTree(Map<String, Object> condition) {
		long parentId = StringUtils.getAsLong(StringUtils.trim(condition.get("parentId")));
		long userId = StringUtils.getAsLong(StringUtils.trim(condition.get("userId")));
		condition.clear();
		condition.put("sortField", "sort");
		condition.put("sortOrder", "asc");
		List<MenuDTO> menuList = getMenuList(condition);
		List<MenuDTO> allMenuList = new ArrayList<MenuDTO>();
		constructMenuTree(parentId, menuList, allMenuList);
		List<MenuDTO> rsList = getPurviewMenuList(userId, allMenuList);
		return rsList;
	}
}