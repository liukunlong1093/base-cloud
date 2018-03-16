package com.mes.system.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.MenuDTO;
import com.mes.system.service.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.web.controller]    
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
@Api(value = "MenuController", description = "菜单管理")
public class MenuController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	MenuService menuService;

	/**
	 * 根据菜单标识获取菜单
	 * @param id 菜单标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据菜单标识获取菜单", httpMethod = "GET", notes = "根据菜单标识获取菜单详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "菜单标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMenuById")
	public ServiceResponse<MenuDTO> getMenuById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return menuService.getMenuById(id);
	}

	/**
	 * 根据条件获取菜单列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取菜单列表", httpMethod = "GET", notes = "根据条件获取菜单列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "菜单标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "菜单编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "parentId", value = "父标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "name", value = "菜单名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "iconName", value = "图标名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "link", value = "链接", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMenuList")
	public List<MenuDTO> getMenuList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return menuService.getMenuList(condition).getData();
	}

	/**
	 * 保存菜单
	 * @param menuDTO 菜单数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存菜单", httpMethod = "POST", notes = "保存菜单信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "menuDTO", value = "菜单数据传输对象", required = true, dataType = "MenuDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveMenu")
	public ServiceResponse<?> saveMenu(@RequestBody MenuDTO menuDTO) {
		return menuService.saveMenu(menuDTO);
	}

	/**
	 * 更新菜单
	 * @param menuDTO 菜单数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新菜单", httpMethod = "POST", notes = "更新菜单信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "menuDTO", value = "菜单数据传输对象", required = true, dataType = "MenuDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateMenu")
	public ServiceResponse<?> updateMenu(@RequestBody MenuDTO menuDTO) {
		return menuService.updateMenu(menuDTO);
	}

	/**
	 * 根据菜单标识删除菜单
	 * @param id 菜单标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据菜单标识删除菜单", httpMethod = "GET", notes = "根据菜单标识删除菜单")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "菜单标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteMenuById")
	public ServiceResponse<?> deleteMenuById(@RequestParam(value = "id") String id) {
		return menuService.deleteMenuById(id);
	}

	/**
	 * 批量保存菜单
	 * @param menuDAOList 菜单数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存菜单", httpMethod = "POST", notes = "批量保存菜单")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "菜单数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveMenu")
	public ServiceResponse<?> batchSaveMenu(@RequestBody List<MenuDTO> menuList) {
		return menuService.batchSaveMenu(menuList);
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
		return menuService.getMainTopMenuList(userId);
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
		return menuService.getMainLeftMenuTree(userId, parentId);
	}
}
