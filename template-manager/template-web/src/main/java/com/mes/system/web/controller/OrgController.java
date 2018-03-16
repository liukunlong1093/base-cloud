package com.mes.system.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.core.utils.StringUtils;
import com.mes.system.dto.OrgDTO;
import com.mes.system.dto.OrgUserRelDTO;
import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostUserRelDTO;
import com.mes.system.service.OrgService;
import com.mes.system.service.PostService;

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
@Api(value = "orgController", description = "组织机构管理")
public class OrgController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	OrgService orgService;

	@Autowired
	PostService postService;

	/**
	 * 根据组织机构标识获取组织机构
	 * @param id 组织机构标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据组织机构标识获取组织机构", httpMethod = "GET", notes = "根据组织机构标识获取组织机构详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "组织机构标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgById")
	public ServiceResponse<OrgDTO> getOrgById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return orgService.getOrgById(id);
	}

	/**
	 * 根据条件获取组织机构列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取组织机构列表", httpMethod = "GET", notes = "根据条件获取组织机构列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "组织标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "组织编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "name", value = "名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "parentId", value = "上层组织", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "type", value = "类型(0组织 1部门)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "comment", value = "说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgList")
	public ServiceResponse<List<OrgDTO>> getOrgList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return orgService.getOrgList(condition);
	}

	/**
	 * 保存组织机构
	 * @param orgDTO 组织机构数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存组织机构", httpMethod = "POST", notes = "保存组织机构信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "orgDTO", value = "组织机构数据传输对象", required = true, dataType = "OrgDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveOrg")
	public ServiceResponse<?> saveOrg(@RequestBody OrgDTO orgDTO) {
		return orgService.saveOrg(orgDTO);
	}

	/**
	 * 更新组织机构
	 * @param orgDTO 组织机构数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新组织机构", httpMethod = "POST", notes = "更新组织机构信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "orgDTO", value = "组织机构数据传输对象", required = true, dataType = "OrgDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateOrg")
	public ServiceResponse<?> updateOrg(@RequestBody OrgDTO orgDTO) {
		return orgService.updateOrg(orgDTO);
	}

	/**
	 * 根据组织机构标识删除组织机构
	 * @param id 组织机构标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据组织机构标识删除组织机构", httpMethod = "GET", notes = "根据组织机构标识删除组织机构")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "组织机构标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteOrgById")
	public ServiceResponse<?> deleteOrgById(@RequestParam(value = "id") String id) {
		return orgService.deleteOrgById(id);
	}

	/**
	 * 批量保存组织机构
	 * @param orgDAOList 组织机构数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存组织机构", httpMethod = "POST", notes = "批量保存组织机构")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "组织机构数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveOrg")
	public ServiceResponse<?> batchSaveOrg(@RequestBody List<OrgDTO> orgList) {
		return orgService.batchSaveOrg(orgList);
	}

	/**
	 * 根据组织用户标识获取组织用户
	 * @param id 组织用户标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据组织用户标识获取组织用户", httpMethod = "GET", notes = "根据组织用户标识获取组织用户详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "组织用户标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgUserRelById")
	public ServiceResponse<OrgUserRelDTO> getOrgUserRelById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return orgService.getOrgUserRelById(id);
	}

	/**
	 * 根据条件获取组织用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取组织用户列表", httpMethod = "GET", notes = "根据条件获取组织用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "组织用户成员标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "orgId", value = "组织标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "userId", value = "用户标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "sort", value = "序号", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgUserRelList")
	public ServiceResponse<List<OrgUserRelDTO>> getOrgUserRelList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return orgService.getOrgUserRelList(condition);
	}

	/**
	 * 保存组织用户
	 * @param orgUserRelDTO 组织用户数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存组织用户", httpMethod = "POST", notes = "保存组织用户信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "orgUserRelDTO", value = "组织用户数据传输对象", required = true, dataType = "OrgUserRelDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveOrgUserRel")
	public ServiceResponse<?> saveOrgUserRel(@RequestBody OrgUserRelDTO orgUserRelDTO) {
		return orgService.saveOrgUserRel(orgUserRelDTO);
	}

	/**
	 * 更新组织用户
	 * @param orgUserRelDTO 组织用户数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新组织用户", httpMethod = "POST", notes = "更新组织用户信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "orgUserRelDTO", value = "组织用户数据传输对象", required = true, dataType = "OrgUserRelDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateOrgUserRel")
	public ServiceResponse<?> updateOrgUserRel(@RequestBody OrgUserRelDTO orgUserRelDTO) {
		return orgService.updateOrgUserRel(orgUserRelDTO);
	}

	/**
	 * 根据组织用户标识删除组织用户
	 * @param id 组织用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据组织用户标识删除组织用户", httpMethod = "GET", notes = "根据组织用户标识删除组织用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "组织用户标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteOrgUserRelById")
	public ServiceResponse<?> deleteOrgUserRelById(@RequestParam(value = "id") String id) {
		return orgService.deleteOrgUserRelById(id);
	}

	/**
	 * 批量保存组织用户
	 * @param orgUserRelDAOList 组织用户数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存组织用户", httpMethod = "POST", notes = "批量保存组织用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "orgId", value = "组织机构标识", required = true, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "userIds", value = "用户标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveOrgUserRel")
	public ServiceResponse<?> batchSaveOrgUserRel(@RequestParam(value = "orgId") Long orgId, @RequestParam(value = "userIds") String userIds) {
		String[] userId = userIds.split(",");
		List<OrgUserRelDTO> orgUserRelList = new ArrayList<OrgUserRelDTO>();
		if (userId != null && userId.length > 0) {
			for (String uid : userId) {
				OrgUserRelDTO orgUserRelDTO = new OrgUserRelDTO();
				orgUserRelDTO.setOrgId(orgId);
				orgUserRelDTO.setUserId(StringUtils.getAsLong(uid));
				orgUserRelDTO.setSort(0L);
				orgUserRelDTO.setIsDel(0L);
				orgUserRelDTO.setCreateBy(999999L);
				orgUserRelDTO.setCreateName("admin");
				orgUserRelDTO.setCreateTime(new Date());
				orgUserRelList.add(orgUserRelDTO);
			}
		}
		return orgService.batchSaveOrgUserRel(orgUserRelList);
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
	public List<OrgDTO> getOrgTree() {
		ServiceResponse<List<OrgDTO>> serviceResponse = orgService.getOrgTree(999999L, 0L);
		return serviceResponse.getData();
	}

	/**
	 * 获取组织机构部门岗位用户
	 * @param orgId 组织机构部门标识
	 * @return 部门岗位用户对象信息
	 */
	@ApiOperation(value = "获取组织机构部门岗位用户列表", httpMethod = "GET", notes = "获取组织机构部门岗位用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orgId", value = "组织机构部门标识", required = true, dataType = "Long", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getOrgPostUser")
	public Map<String, String> getOrgPostUser(@RequestParam(value = "orgId") Long orgId) {
		Map<String, String> postUserViewMap = new LinkedHashMap<String, String>();
		Map<String, Object> condition = new HashMap<String, Object>(16);
		condition.put("orgId", orgId);
		ServiceResponse<List<PostDTO>> postServiceResponse = postService.getPostList(condition);
		List<Long> postIdList = new ArrayList<Long>();
		if (postServiceResponse.isSuccess()) {
			List<PostDTO> postList = postServiceResponse.getData();
			if (postList != null && postList.size() > 0) {
				for (PostDTO postDTO : postList) {
					postIdList.add(postDTO.getId());
				}
				condition.clear();
				condition.put("postIds", StringUtils.join(postIdList, ","));
				ServiceResponse<List<PostUserRelDTO>> postUserRelServiceResponse = postService.getPostUserRelList(condition);
				if (postUserRelServiceResponse.isSuccess()) {
					List<PostUserRelDTO> postUserRelDTOList = postUserRelServiceResponse.getData();
					if (postUserRelDTOList != null && postUserRelDTOList.size() > 0) {
						for (PostUserRelDTO postUserRelDTO : postUserRelDTOList) {
							String postName = postUserRelDTO.getPostName();
							String userName = postUserRelDTO.getName();
							if (postUserViewMap.containsKey(postName)) {
								String uname = postUserViewMap.get(postName);
								if (StringUtils.hasText(uname)) {
									uname = uname + ",";
								}
								String tempUserName = uname + userName;
								postUserViewMap.put(postName, tempUserName);
							} else {
								postUserViewMap.put(postName, userName);
							}
						}
					}
				}
			}
		}

		return postUserViewMap;
	}

}
