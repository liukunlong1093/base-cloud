package com.mes.system.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.PostTypeDTO;
import com.mes.system.service.PostTypeService;

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
  * 类名称:		[PostTypeController]  
  * 类描述:		[岗位类型控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/postType")
@Api(value = "postTypeController", description = "岗位类型管理")
public class PostTypeController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	PostTypeService postTypeService;

	/**
	 * 根据岗位类型标识获取岗位类型
	 * @param id 岗位类型标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位类型标识获取岗位类型", httpMethod = "GET", notes = "根据岗位类型标识获取岗位类型详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位类型标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostTypeById")
	public ServiceResponse<PostTypeDTO> getPostTypeById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return postTypeService.getPostTypeById(id);
	}

	/**
	 * 根据条件获取岗位类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取岗位类型列表", httpMethod = "GET", notes = "根据条件获取岗位类型列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位类型标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "岗位类型编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "name", value = "名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "type", value = "类型(1一般类型,0部门缺省类型，2单位缺省类型)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "comment", value = "岗位类型说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getPostTypeList")
	public ServiceResponse<List<PostTypeDTO>> getPostTypeList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return postTypeService.getPostTypeList(condition);
	}

	/**
	 * 保存岗位类型
	 * @param postTypeDTO 岗位类型数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存岗位类型", httpMethod = "POST", notes = "保存岗位类型信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "postTypeDTO", value = "岗位类型数据传输对象", required = true, dataType = "PostTypeDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/savePostType")
	public ServiceResponse<?> savePostType(@RequestBody PostTypeDTO postTypeDTO) {
		return postTypeService.savePostType(postTypeDTO);
	}

	/**
	 * 更新岗位类型
	 * @param postTypeDTO 岗位类型数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新岗位类型", httpMethod = "POST", notes = "更新岗位类型信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "postTypeDTO", value = "岗位类型数据传输对象", required = true, dataType = "PostTypeDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updatePostType")
	public ServiceResponse<?> updatePostType(@RequestBody PostTypeDTO postTypeDTO) {
		return postTypeService.updatePostType(postTypeDTO);
	}

	/**
	 * 根据岗位类型标识删除岗位类型
	 * @param id 岗位类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据岗位类型标识删除岗位类型", httpMethod = "GET", notes = "根据岗位类型标识删除岗位类型")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "岗位类型标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deletePostTypeById")
	public ServiceResponse<?> deletePostTypeById(@RequestParam(value = "id") String id) {
		return postTypeService.deletePostTypeById(id);
	}

	/**
	 * 批量保存岗位类型
	 * @param postTypeDAOList 岗位类型数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存岗位类型", httpMethod = "POST", notes = "批量保存岗位类型")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "岗位类型数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSavePostType")
	public ServiceResponse<?> batchSavePostType(@RequestBody List<PostTypeDTO> postTypeList) {
		return postTypeService.batchSavePostType(postTypeList);
	}

	/**
	 * 岗位类型集合列表
	 * @param id 岗位类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "岗位类型集合列表", httpMethod = "GET", notes = "岗位类型集合列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/buildPostType")
	public List<PostTypeDTO> buildPostType() {
		return postTypeService.getPostTypeList(new HashMap<String, Object>(16)).getData();
	}
}
