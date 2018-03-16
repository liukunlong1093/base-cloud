package com.mes.system.manager;

import java.util.*;
import com.mes.system.dto.MenuPurviewDTO;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.manager]    
 * 类名称:		[MenuPurviewManager]  
 * 类描述:		[菜单权限管理处理接口]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月21日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月21日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
public interface MenuPurviewManager {
	/**
	 * 根据菜单权限标识获取菜单权限
	 * @param id 菜单权限标识
	 * @return 菜单权限对象
	 */
	MenuPurviewDTO getMenuPurviewById(Long id);

	/**
	 * 根据条件获取菜单权限列表
	 * @param condition 查询条件
	 * @return 菜单权限列表
	 */
	List<MenuPurviewDTO> getMenuPurviewList(Map<String, Object> condition);

	/**
	 * 保存菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 新增成功条数
	 */
	long saveMenuPurview(MenuPurviewDTO menuPurviewDTO);

	/**
	 * 更新菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 更新成功条数
	 */
	long updateMenuPurview(MenuPurviewDTO menuPurviewDTO);

	/**
	 * 根据菜单权限标识删除菜单权限
	 * @param id 菜单权限标识
	 * @return 删除成功条数
	 */
	long deleteMenuPurviewById(Long id);

	/**
	 * 批量保存菜单权限
	 * @param  menuPurviewList 菜单权限数据集合
	 * @return 新增成功条数
	 */
	long batchSaveMenuPurview(List<MenuPurviewDTO> menuPurviewList);

	/**
	 * 据权限对象标识删除菜单权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	long deleteMenuPurviewBySecId(String secId);
}
