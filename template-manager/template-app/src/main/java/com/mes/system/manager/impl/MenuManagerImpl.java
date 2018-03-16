package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.MenuManager;
import com.mes.system.dao.MenuMapper;
import com.mes.system.dto.MenuDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[MenuManagerImpl]  
  * 类描述:		[菜单管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月17日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月17日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("menuManager")
public class MenuManagerImpl implements MenuManager {
	@Autowired
	private MenuMapper menuMapper;


	/**
	 * 根据菜单标识获取菜单
	 * @param id 菜单标识
	 * @return 菜单对象
	 */
	@Override
	public MenuDTO getMenuById(Long id){
		return menuMapper.getMenuById(id);
	}

	/**
	 * 根据条件获取菜单列表
	 * @param condition 查询条件
	 * @return 菜单列表
	 */
	@Override
	public List<MenuDTO> getMenuList(Map<String, Object> condition){
		return menuMapper.getMenuList(condition);
	}

	/**
	 * 保存菜单
	 * @param menuDTO 菜单对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveMenu(MenuDTO menuDTO){
		return menuMapper.saveMenu(menuDTO);
	}

	/**
	 * 更新菜单
	 * @param menuDTO 菜单对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateMenu(MenuDTO menuDTO){
		return menuMapper.updateMenu(menuDTO);
	}

	/**
	 * 根据菜单标识删除菜单
	 * @param id 菜单标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteMenuById(Long id){
		return menuMapper.deleteMenuById(id);
	}

	/**
	 * 批量保存菜单
	 * @param  menuList 菜单数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveMenu(List<MenuDTO> menuList){
		return menuMapper.batchSaveMenu(menuList);
	}
}
