package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.MenuPurviewManager;
import com.mes.system.dao.MenuPurviewMapper;
import com.mes.system.dto.MenuPurviewDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[MenuPurviewManagerImpl]  
  * 类描述:		[菜单权限管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("menuPurviewManager")
public class MenuPurviewManagerImpl implements MenuPurviewManager {
	@Autowired
	private MenuPurviewMapper menuPurviewMapper;


	/**
	 * 根据菜单权限标识获取菜单权限
	 * @param id 菜单权限标识
	 * @return 菜单权限对象
	 */
	@Override
	public MenuPurviewDTO getMenuPurviewById(Long id){
		return menuPurviewMapper.getMenuPurviewById(id);
	}

	/**
	 * 根据条件获取菜单权限列表
	 * @param condition 查询条件
	 * @return 菜单权限列表
	 */
	@Override
	public List<MenuPurviewDTO> getMenuPurviewList(Map<String, Object> condition){
		return menuPurviewMapper.getMenuPurviewList(condition);
	}

	/**
	 * 保存菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveMenuPurview(MenuPurviewDTO menuPurviewDTO){
		return menuPurviewMapper.saveMenuPurview(menuPurviewDTO);
	}

	/**
	 * 更新菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateMenuPurview(MenuPurviewDTO menuPurviewDTO){
		return menuPurviewMapper.updateMenuPurview(menuPurviewDTO);
	}

	/**
	 * 根据菜单权限标识删除菜单权限
	 * @param id 菜单权限标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteMenuPurviewById(Long id){
		return menuPurviewMapper.deleteMenuPurviewById(id);
	}

	/**
	 * 批量保存菜单权限
	 * @param  menuPurviewList 菜单权限数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveMenuPurview(List<MenuPurviewDTO> menuPurviewList){
		return menuPurviewMapper.batchSaveMenuPurview(menuPurviewList);
	}
	
	/**
	 * 据权限对象标识删除菜单权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	@Override
	 public long  deleteMenuPurviewBySecId(String secId){
		 return menuPurviewMapper.deleteMenuPurviewBySecId(secId);
	 }
}
