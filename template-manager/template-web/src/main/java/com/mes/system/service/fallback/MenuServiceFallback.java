package com.mes.system.service.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.MenuDTO;
import com.mes.system.service.MenuService;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[MenuServiceFallback]  
  * 类描述:		[菜单业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月17日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月17日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class MenuServiceFallback implements MenuService {
	/**
		 * 根据菜单标识获取菜单
		 * @param id 菜单标识
		 * @return 服务响应对象
		 */
	@Override
	public ServiceResponse<MenuDTO> getMenuById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据菜单标识获取菜单服务不可用.");
	}

	/**
	 * 根据条件获取菜单列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<MenuDTO>> getMenuList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取菜单列表服务不可用.");
	}

	/**
	 * 保存菜单
	 * @param menuDTO 菜单对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveMenu(MenuDTO menuDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存菜单服务不可用.");
	}

	/**
	 * 更新菜单
	 * @param menuDTO 菜单对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateMenu(MenuDTO menuDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新菜单服务不可用.");
	}

	/**
	 * 根据菜单标识删除菜单
	 * @param id 菜单标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteMenuById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据菜单标识删除菜单服务不可用.");
	}

	/**
	 * 批量保存菜单
	 * @param menuDAOList 菜单对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveMenu(List<MenuDTO> menuList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存菜单服务不可用.");
	}

	/**
	* 根据用户标识获取主界面顶部菜单列表
	* @param userId 用户标识
	* @return 服务响应对象
	*/
	@Override
	public ServiceResponse<List<MenuDTO>> getMainTopMenuList(Long userId) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据用户标识获取主界面顶部菜单列表服务不可用.");
	}

	/**
	 * 根据条件获取主界面左边菜单树
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<MenuDTO>> getMainLeftMenuTree(Long userId, Long parentId) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取主界面左边菜单树服务不可用.");
	}
}
