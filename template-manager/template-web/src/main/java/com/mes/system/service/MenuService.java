package com.mes.system.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.MenuDTO;
import com.mes.system.service.fallback.MenuServiceFallback;

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
@FeignClient(value = "info-app", fallback = MenuServiceFallback.class)
public interface MenuService {

	/**
	 * 根据菜单标识获取菜单
	 * @param id 菜单标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/menu/getMenuById")
	ServiceResponse<MenuDTO> getMenuById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取菜单列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/menu/getMenuList")
	ServiceResponse<List<MenuDTO>> getMenuList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存菜单
	 * @param menuDTO 菜单对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/menu/saveMenu")
	ServiceResponse<?> saveMenu(@RequestBody MenuDTO menuDTO);

	/**
	 * 更新菜单
	 * @param menuDTO 菜单对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/menu/updateMenu")
	ServiceResponse<?> updateMenu(@RequestBody MenuDTO menuDTO);

	/**
	 * 根据菜单标识删除菜单
	 * @param id 菜单标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/menu/deleteMenuById")
	ServiceResponse<?> deleteMenuById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存菜单
	 * @param menuList 菜单对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/menu/batchSaveMenu")
	ServiceResponse<?> batchSaveMenu(@RequestBody List<MenuDTO> menuList);

	/**
	 * 根据用户标识获取主界面顶部菜单列表
	 * @param userId 用户标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/menu/getMainTopMenuList")
	ServiceResponse<List<MenuDTO>> getMainTopMenuList(@RequestParam(value = "userId") Long userId);

	/**
	 * 根据条件获取主界面左边菜单树
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/menu/getMainLeftMenuTree")
	ServiceResponse<List<MenuDTO>> getMainLeftMenuTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "parentId") Long parentId);
}
