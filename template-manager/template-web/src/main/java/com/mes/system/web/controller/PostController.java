package com.mes.system.web.controller;

import java.util.ArrayList;
import java.util.Date;
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
  * 包:	        [com.mes.system.web.controller]    
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
@Api(value = "postController", description = "岗位管理")
public class PostController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	PostService postService;

	/**
	 * 根据岗位标识获取岗位
	 * @param id 岗位标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位标识获取岗位", httpMethod = "GET", notes = "根据岗位标识获取岗位详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostById")
	public ServiceResponse<PostDTO> getPostById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return postService.getPostById(id);
	}

	/**
	 * 根据条件获取岗位列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取岗位列表", httpMethod = "GET", notes = "根据条件获取岗位列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "postTypeId", value = "岗位类型标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "orgId", value = "织组标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "岗位编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "name", value = "岗位名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "comment", value = "岗位说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostList")
	public ServiceResponse<List<PostDTO>> getPostList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return postService.getPostList(condition);
	}

	/**
	 * 保存岗位
	 * @param postDTO 岗位数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存岗位", httpMethod = "POST", notes = "保存岗位信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "postDTO", value = "岗位数据传输对象", required = true, dataType = "PostDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/savePost")
	public ServiceResponse<?> savePost(@RequestBody PostDTO postDTO) {
		return postService.savePost(postDTO);
	}

	/**
	 * 更新岗位
	 * @param postDTO 岗位数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新岗位", httpMethod = "POST", notes = "更新岗位信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "postDTO", value = "岗位数据传输对象", required = true, dataType = "PostDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updatePost")
	public ServiceResponse<?> updatePost(@RequestBody PostDTO postDTO) {
		return postService.updatePost(postDTO);
	}

	/**
	 * 根据岗位标识删除岗位
	 * @param id 岗位标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位标识删除岗位", httpMethod = "GET", notes = "根据岗位标识删除岗位")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deletePostById")
	public ServiceResponse<?> deletePostById(@RequestParam(value = "id") String id) {
		return postService.deletePostById(id);
	}

	/**
	 * 批量保存岗位
	 * @param postDAOList 岗位数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存岗位", httpMethod = "POST", notes = "批量保存岗位")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "岗位数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSavePost")
	public ServiceResponse<?> batchSavePost(@RequestBody List<PostDTO> postList) {
		return postService.batchSavePost(postList);
	}

	/**
	 * 根据岗位用户标识获取岗位用户
	 * @param id 岗位用户标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位用户标识获取岗位用户", httpMethod = "GET", notes = "根据岗位用户标识获取岗位用户详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位用户标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostUserRelById")
	public ServiceResponse<PostUserRelDTO> getPostUserRelById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return postService.getPostUserRelById(id);
	}

	/**
	 * 根据条件获取岗位用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取岗位用户列表", httpMethod = "GET", notes = "根据条件获取岗位用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位用户成员标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "postId", value = "岗位标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "postIds", value = "岗位标识数组(已逗号分隔)", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "userId", value = "用户标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "sort", value = "序号", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostUserRelList")
	public ServiceResponse<List<PostUserRelDTO>> getPostUserRelList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return postService.getPostUserRelList(condition);
	}

	/**
	 * 保存岗位用户
	 * @param postUserRelDTO 岗位用户数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存岗位用户", httpMethod = "POST", notes = "保存岗位用户信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "postUserRelDTO", value = "岗位用户数据传输对象", required = true, dataType = "PostUserRelDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/savePostUserRel")
	public ServiceResponse<?> savePostUserRel(@RequestBody PostUserRelDTO postUserRelDTO) {
		return postService.savePostUserRel(postUserRelDTO);
	}

	/**
	 * 更新岗位用户
	 * @param postUserRelDTO 岗位用户数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新岗位用户", httpMethod = "POST", notes = "更新岗位用户信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "postUserRelDTO", value = "岗位用户数据传输对象", required = true, dataType = "PostUserRelDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updatePostUserRel")
	public ServiceResponse<?> updatePostUserRel(@RequestBody PostUserRelDTO postUserRelDTO) {
		return postService.updatePostUserRel(postUserRelDTO);
	}

	/**
	 * 根据岗位用户标识删除岗位用户
	 * @param id 岗位用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位用户标识删除岗位用户", httpMethod = "GET", notes = "根据岗位用户标识删除岗位用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位用户标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deletePostUserRelById")
	public ServiceResponse<?> deletePostUserRelById(@RequestParam(value = "id") String id) {
		return postService.deletePostUserRelById(id);
	}

	/**
	 * 批量保存岗位用户
	 * @param postUserRelDAOList 岗位用户数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存岗位用户", httpMethod = "POST", notes = "批量保存岗位用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "postId", value = "岗位标识", required = true, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "userIds", value = "用户标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSavePostUserRel")
	public ServiceResponse<?> batchSavePostUserRel(@RequestParam(value = "postId") Long postId, @RequestParam(value = "userIds") String userIds) {
		String[] userId = userIds.split(",");
		List<PostUserRelDTO> postUserRelList = new ArrayList<PostUserRelDTO>();
		if (userId != null && userId.length > 0) {
			for (String uid : userId) {
				PostUserRelDTO postUserRelDTO = new PostUserRelDTO();
				postUserRelDTO.setPostId(postId);
				postUserRelDTO.setUserId(StringUtils.getAsLong(uid));
				postUserRelDTO.setSort(0L);
				postUserRelDTO.setIsDel(0L);
				postUserRelDTO.setCreateBy(999999L);
				postUserRelDTO.setCreateName("admin");
				postUserRelDTO.setCreateTime(new Date());
				postUserRelList.add(postUserRelDTO);
			}
		}
		return postService.batchSavePostUserRel(postUserRelList);
	}
}
