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
import com.mes.system.dto.OrgDTO;
import com.mes.system.dto.OrgUserRelDTO;
import com.mes.system.service.OrgService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.web]    
  * 类名称:		[OrgController]  
  * 类描述:		[组织机构控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/org")
@Api(value = "OrgController", description = "组织机构管理")
public class OrgController extends BaseController {
	@Autowired
	private OrgService orgService;

	/**
	 * 根据组织机构标识获取组织机构
	 * @param id 组织机构标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据组织机构标识获取组织机构", httpMethod = "GET", notes = "根据组织机构标识获取组织机构详细信息")
	@ApiImplicitParam(name = "id", value = "组织机构标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgById")
	public ServiceResponse<OrgDTO> getOrgById(@RequestParam(value = "id") Long id) {
		OrgDTO orgDTO = orgService.getOrgById(id);
		return ServiceResponse.handleSuccess(orgDTO);
	}

	/**
	 * 根据条件获取组织机构列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取组织机构列表", httpMethod = "GET", notes = "根据条件获取组织机构列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "组织标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "组织编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "name", value = "名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "parentId", value = "上层组织", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "type", value = "类型(0组织 1部门)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "comment", value = "说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgList")
	public ServiceResponse<List<OrgDTO>> getOrgList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<OrgDTO> orgList = orgService.getOrgList(condition);
		PageInfo<OrgDTO> pageInfo = new PageInfo<OrgDTO>(orgList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存组织机构
	 * @param orgDTO 组织机构对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存组织机构", httpMethod = "POST", notes = "保存组织机构信息")
	@ApiImplicitParam(name = "orgDTO", value = "组织机构对象", required = true, dataType = "OrgDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveOrg")
	public ServiceResponse<?> saveOrg(@RequestBody OrgDTO orgDTO) {
		orgService.saveOrg(orgDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新组织机构
	 * @param orgDTO 组织机构对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新组织机构", httpMethod = "POST", notes = "更新组织机构信息")
	@ApiImplicitParam(name = "orgDTO", value = "组织机构对象", required = true, dataType = "OrgDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateOrg")
	public ServiceResponse<?> updateOrg(@RequestBody OrgDTO orgDTO) {
		orgService.updateOrg(orgDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据组织机构标识删除组织机构
	 * @param id 组织机构标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据组织机构标识删除组织机构", httpMethod = "GET", notes = "根据组织机构标识删除组织机构")
	@ApiImplicitParam(name = "id", value = "组织机构标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteOrgById")
	public ServiceResponse<?> deleteOrgById(@RequestParam(value = "id") String id) {
		orgService.deleteOrgById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存组织机构
	 * @param orgDAOList 组织机构对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存组织机构", httpMethod = "POST", notes = "批量保存组织机构信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveOrg")
	public ServiceResponse<?> batchSaveOrg(@RequestBody List<OrgDTO> orgList) {
		orgService.batchSaveOrg(orgList);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据组织用户标识获取组织用户
	 * @param id 组织用户标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据组织用户标识获取组织用户", httpMethod = "GET", notes = "根据组织用户标识获取组织用户详细信息")
	@ApiImplicitParam(name = "id", value = "组织用户标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgUserRelById")
	public ServiceResponse<OrgUserRelDTO> getOrgUserRelById(@RequestParam(value = "id") Long id) {
		OrgUserRelDTO orgUserRelDTO = orgService.getOrgUserRelById(id);
		return ServiceResponse.handleSuccess(orgUserRelDTO);
	}

	/**
	 * 根据条件获取组织用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取组织用户列表", httpMethod = "GET", notes = "根据条件获取组织用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "组织用户成员标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "orgId", value = "组织标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "userId", value = "用户标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "sort", value = "序号", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgUserRelList")
	public ServiceResponse<List<OrgUserRelDTO>> getOrgUserRelList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<OrgUserRelDTO> orgUserRelList = orgService.getOrgUserRelList(condition);
		PageInfo<OrgUserRelDTO> pageInfo = new PageInfo<OrgUserRelDTO>(orgUserRelList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存组织用户", httpMethod = "POST", notes = "保存组织用户信息")
	@ApiImplicitParam(name = "orgUserRelDTO", value = "组织用户对象", required = true, dataType = "OrgUserRelDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveOrgUserRel")
	public ServiceResponse<?> saveOrgUserRel(@RequestBody OrgUserRelDTO orgUserRelDTO) {
		orgService.saveOrgUserRel(orgUserRelDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新组织用户", httpMethod = "POST", notes = "更新组织用户信息")
	@ApiImplicitParam(name = "orgUserRelDTO", value = "组织用户对象", required = true, dataType = "OrgUserRelDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateOrgUserRel")
	public ServiceResponse<?> updateOrgUserRel(@RequestBody OrgUserRelDTO orgUserRelDTO) {
		orgService.updateOrgUserRel(orgUserRelDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据组织用户标识删除组织用户
	 * @param id 组织用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据组织用户标识删除组织用户", httpMethod = "GET", notes = "根据组织用户标识删除组织用户")
	@ApiImplicitParam(name = "id", value = "组织用户标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteOrgUserRelById")
	public ServiceResponse<?> deleteOrgUserRelById(@RequestParam(value = "id") String id) {
		orgService.deleteOrgUserRelById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存组织用户
	 * @param orgUserRelDAOList 组织用户对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存组织用户", httpMethod = "POST", notes = "批量保存组织用户信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveOrgUserRel")
	public ServiceResponse<?> batchSaveOrgUserRel(@RequestBody List<OrgUserRelDTO> orgUserRelList) {
		orgService.batchSaveOrgUserRel(orgUserRelList);
		return ServiceResponse.handleSuccess();
	}
	
	/**
	 * 获取组织机构树列表
	 * @param userId 用户标识
	 * @param parentId 父节点标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "获取组织机构树列表", httpMethod = "GET", notes = "获取组织机构树列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "userId", value = "用户标识", required = true, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "parentId", value = "父节点标识", required = true, dataType = "Long", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgTree")
	public ServiceResponse<List<OrgDTO>> getOrgTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "parentId") Long parentId) {
		List<OrgDTO> orgList = orgService.getOrgTree(userId, parentId);
		return ServiceResponse.handleSuccess(orgList);
	}
}
