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
import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostUserRelDTO;
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
  * 包:	        [com.mes.system.web]    
  * 类名称:		[PostController]  
  * 类描述:		[岗位控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/post")
@Api(value = "PostController", description = "岗位管理")
public class PostController extends BaseController {
	@Autowired
	private PostService postService;

	/**
	 * 根据岗位标识获取岗位
	 * @param id 岗位标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位标识获取岗位", httpMethod = "GET", notes = "根据岗位标识获取岗位详细信息")
	@ApiImplicitParam(name = "id", value = "岗位标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostById")
	public ServiceResponse<PostDTO> getPostById(@RequestParam(value = "id") Long id) {
		PostDTO postDTO = postService.getPostById(id);
		return ServiceResponse.handleSussess(postDTO);
	}

	/**
	 * 根据条件获取岗位列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取岗位列表", httpMethod = "GET", notes = "根据条件获取岗位列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "岗位标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "postTypeId", value = "岗位类型标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "orgId", value = "织组标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "岗位编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "name", value = "岗位名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "comment", value = "岗位说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostList")
	public ServiceResponse<List<PostDTO>> getPostList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<PostDTO> postList = postService.getPostList(condition);
		PageInfo<PostDTO> pageInfo = new PageInfo<PostDTO>(postList);
		return ServiceResponse.handleSussess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存岗位
	 * @param postDTO 岗位对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存岗位", httpMethod = "POST", notes = "保存岗位信息")
	@ApiImplicitParam(name = "postDTO", value = "岗位对象", required = true, dataType = "PostDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/savePost")
	public ServiceResponse<?> savePost(@RequestBody PostDTO postDTO) {
		postService.savePost(postDTO);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 更新岗位
	 * @param postDTO 岗位对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新岗位", httpMethod = "POST", notes = "更新岗位信息")
	@ApiImplicitParam(name = "postDTO", value = "岗位对象", required = true, dataType = "PostDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updatePost")
	public ServiceResponse<?> updatePost(@RequestBody PostDTO postDTO) {
		postService.updatePost(postDTO);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 根据岗位标识删除岗位
	 * @param id 岗位标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位标识删除岗位", httpMethod = "GET", notes = "根据岗位标识删除岗位")
	@ApiImplicitParam(name = "id", value = "岗位标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deletePostById")
	public ServiceResponse<?> deletePostById(@RequestParam(value = "id") String id) {
		postService.deletePostById(id);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 批量保存岗位
	 * @param postDAOList 岗位对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存岗位", httpMethod = "POST", notes = "批量保存岗位信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSavePost")
	public ServiceResponse<?> batchSavePost(@RequestBody List<PostDTO> postList) {
		postService.batchSavePost(postList);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 根据岗位用户标识获取岗位用户
	 * @param id 岗位用户标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位用户标识获取岗位用户", httpMethod = "GET", notes = "根据岗位用户标识获取岗位用户详细信息")
	@ApiImplicitParam(name = "id", value = "岗位用户标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostUserRelById")
	public ServiceResponse<PostUserRelDTO> getPostUserRelById(@RequestParam(value = "id") Long id) {
		PostUserRelDTO postUserRelDTO = postService.getPostUserRelById(id);
		return ServiceResponse.handleSussess(postUserRelDTO);
	}

	/**
	 * 根据条件获取岗位用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取岗位用户列表", httpMethod = "GET", notes = "根据条件获取岗位用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "岗位用户成员标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "postId", value = "岗位标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "postIds", value = "岗位标识数组(已逗号分隔)", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "userId", value = "用户标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "sort", value = "序号", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostUserRelList")
	public ServiceResponse<List<PostUserRelDTO>> getPostUserRelList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		processWhereIn(condition,"postIds");
		List<PostUserRelDTO> postUserRelList = postService.getPostUserRelList(condition);
		PageInfo<PostUserRelDTO> pageInfo = new PageInfo<PostUserRelDTO>(postUserRelList);
		return ServiceResponse.handleSussess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存岗位用户", httpMethod = "POST", notes = "保存岗位用户信息")
	@ApiImplicitParam(name = "postUserRelDTO", value = "岗位用户对象", required = true, dataType = "PostUserRelDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/savePostUserRel")
	public ServiceResponse<?> savePostUserRel(@RequestBody PostUserRelDTO postUserRelDTO) {
		postService.savePostUserRel(postUserRelDTO);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 更新岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新岗位用户", httpMethod = "POST", notes = "更新岗位用户信息")
	@ApiImplicitParam(name = "postUserRelDTO", value = "岗位用户对象", required = true, dataType = "PostUserRelDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updatePostUserRel")
	public ServiceResponse<?> updatePostUserRel(@RequestBody PostUserRelDTO postUserRelDTO) {
		postService.updatePostUserRel(postUserRelDTO);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 根据岗位用户标识删除岗位用户
	 * @param id 岗位用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位用户标识删除岗位用户", httpMethod = "GET", notes = "根据岗位用户标识删除岗位用户")
	@ApiImplicitParam(name = "id", value = "岗位用户标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deletePostUserRelById")
	public ServiceResponse<?> deletePostUserRelById(@RequestParam(value = "id") String id) {
		postService.deletePostUserRelById(id);
		return ServiceResponse.handleSussess();
	}

	/**
	 * 批量保存岗位用户
	 * @param postUserRelDAOList 岗位用户对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存岗位用户", httpMethod = "POST", notes = "批量保存岗位用户信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSavePostUserRel")
	public ServiceResponse<?> batchSavePostUserRel(@RequestBody List<PostUserRelDTO> postUserRelList) {
		postService.batchSavePostUserRel(postUserRelList);
		return ServiceResponse.handleSussess();
	}
}
