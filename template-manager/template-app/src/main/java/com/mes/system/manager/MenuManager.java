package com.mes.system.manager;

import java.util.*;
import com.mes.system.dto.MenuDTO;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.manager]    
 * 类名称:		[MenuManager]  
 * 类描述:		[菜单管理处理接口]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月17日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月17日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
public interface MenuManager {
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
	 * @return 新增成功条数
	 */
	long saveMenu(MenuDTO menuDTO);

	/**
	 * 更新菜单
	 * @param menuDTO 菜单对象
	 * @return 更新成功条数
	 */
	long updateMenu(MenuDTO menuDTO);

	/**
	 * 根据菜单标识删除菜单
	 * @param id 菜单标识
	 * @return 删除成功条数
	 */
	long deleteMenuById(Long id);

	/**
	 * 批量保存菜单
	 * @param  menuList 菜单数据集合
	 * @return 新增成功条数
	 */
	long batchSaveMenu(List<MenuDTO> menuList);
}
