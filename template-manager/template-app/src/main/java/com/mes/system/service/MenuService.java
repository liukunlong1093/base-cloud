package com.mes.system.service;

import java.util.*;
import com.mes.system.dto.MenuDTO;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[MenuService]  
  * 类描述:		[菜单业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月17日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月17日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface MenuService {
	/**
	 * 根据菜单标识获取菜单
	 * @param id 菜单标识
	 * @return 菜单对象
	 */
	MenuDTO getMenuById(Long id);

	/**
	 * 根据条件获取菜单列表
	 * @param condition 查询条件
	 * @return 菜单列表
	 */
	List<MenuDTO> getMenuList(Map<String, Object> condition);

	/**
	 * 保存菜单
	 * @param menuDTO 菜单对象
	 * @return 新增后的菜单对象
	 */
	MenuDTO saveMenu(MenuDTO menuDTO);

	/**
	 * 更新菜单
	 * @param menuDTO 菜单对象
	 * @return 更新后的菜单对象
	 */
	MenuDTO updateMenu(MenuDTO menuDTO);

	/**
	 * 根据菜单标识删除菜单
	 * @param id 菜单标识
	 * @return 删除成功条数
	 */
	long deleteMenuById(String id);

	/**
	 * 批量保存菜单
	 * @param  menuList 菜单数据集合
	 * @return 新增成功条数
	 */
	long batchSaveMenu(List<MenuDTO> menuList);

	/**
	 * 根据用户标识获取主界面顶部菜单列表
	 * @param userId 用户标识
	 * @return 主界面顶部菜单列表
	 */
	List<MenuDTO> getMainTopMenuList(Long userId);

	/**
	 * 根据条件获取主界面左边菜单树
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 主界面左边菜单树
	 */
	List<MenuDTO> getMainLeftMenuTree(Long userId, Long parentId);

	/**
	 * 根据条件获取带有权限的菜单树
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 主界面左边菜单树
	 */
	List<MenuDTO> getPurviewMenuTree(Long userId, Long parentId);
	
	/**
	 * 根据条件获取带有权限的菜单树
	 * @param condition 查询条件
	 * <li>put("parentId",父节点标识--必须)</li>
	 * <li>put("userId",用户标识--必须)</li>
	 *  @return 递归菜单集合对象
	 */
	public List<MenuDTO> getPurviewMenuTree(Map<String, Object> condition);
}
