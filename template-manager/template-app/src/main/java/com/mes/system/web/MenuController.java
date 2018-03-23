package com.mes.system.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.mes.core.controller.BaseController;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.MenuDTO;
import com.mes.system.service.MenuService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.web]    
  * 类名称:		[MenuController]  
  * 类描述:		[菜单控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月17日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月17日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
	@Autowired
	private MenuService menuService;

	/**
	 * 根据菜单标识获取菜单
	 * @param id 菜单标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据菜单标识获取菜单", httpMethod = "GET", notes = "根据菜单标识获取菜单详细信息")
	@ApiImplicitParam(name = "id", value = "菜单标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMenuById")
	public ServiceResponse<MenuDTO> getMenuById(@RequestParam(value = "id") Long id) {
		MenuDTO menuDTO = menuService.getMenuById(id);
		return ServiceResponse.handleSuccess(menuDTO);
	}

	/**
	 * 根据条件获取菜单列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取菜单列表", httpMethod = "GET", notes = "根据条件获取菜单列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "菜单标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "菜单编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "parentId", value = "父标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "name", value = "菜单名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "iconName", value = "图标名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "link", value = "链接", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMenuList")
	public ServiceResponse<List<MenuDTO>> getMenuList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<MenuDTO> menuList = menuService.getMenuList(condition);
		PageInfo<MenuDTO> pageInfo = new PageInfo<MenuDTO>(menuList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存菜单
	 * @param menuDTO 菜单对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存菜单", httpMethod = "POST", notes = "保存菜单信息")
	@ApiImplicitParam(name = "menuDTO", value = "菜单对象", required = true, dataType = "MenuDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveMenu")
	public ServiceResponse<?> saveMenu(@RequestBody MenuDTO menuDTO) {
		menuService.saveMenu(menuDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新菜单
	 * @param menuDTO 菜单对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新菜单", httpMethod = "POST", notes = "更新菜单信息")
	@ApiImplicitParam(name = "menuDTO", value = "菜单对象", required = true, dataType = "MenuDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateMenu")
	public ServiceResponse<?> updateMenu(@RequestBody MenuDTO menuDTO) {
		menuService.updateMenu(menuDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据菜单标识删除菜单
	 * @param id 菜单标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据菜单标识删除菜单", httpMethod = "GET", notes = "根据菜单标识删除菜单")
	@ApiImplicitParam(name = "id", value = "菜单标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteMenuById")
	public ServiceResponse<?> deleteMenuById(@RequestParam(value = "id") String id) {
		menuService.deleteMenuById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存菜单
	 * @param menuDAOList 菜单对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存菜单", httpMethod = "POST", notes = "批量保存菜单信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveMenu")
	public ServiceResponse<?> batchSaveMenu(@RequestBody List<MenuDTO> menuList) {
		menuService.batchSaveMenu(menuList);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据用户标识获取主界面顶部菜单列表
	 * @param userId 用户标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据用户标识获取主界面顶部菜单列表", httpMethod = "GET", notes = "根据用户标识获取主界面顶部菜单列表信息")
	@ApiImplicitParam(name = "userId", value = "用户标识", required = true, dataType = "Long", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMainTopMenuList")
	public ServiceResponse<List<MenuDTO>> getMainTopMenuList(@RequestParam(value = "userId") Long userId) {
		List<MenuDTO> menuList = menuService.getMainTopMenuList(userId);
		return ServiceResponse.handleSuccess(menuList);
	}

	/**
	 * 根据条件获取主界面左边菜单树
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据用户标识获取主界面顶部菜单列表", httpMethod = "GET", notes = "根据用户标识获取主界面顶部菜单列表信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "userId", value = "用户标识", required = true, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "parentId", value = "父节点标识", required = true, dataType = "Long", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMainLeftMenuTree")
	public ServiceResponse<List<MenuDTO>> getMainLeftMenuTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "parentId") Long parentId) {
		List<MenuDTO> menuList = menuService.getMainLeftMenuTree(userId, parentId);
		return ServiceResponse.handleSuccess(menuList);
	}
}
