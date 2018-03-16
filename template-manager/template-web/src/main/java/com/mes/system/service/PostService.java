package com.mes.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostUserRelDTO;
import com.mes.system.service.fallback.PostServiceFallback;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[PostService]  
  * 类描述:		[岗位业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = PostServiceFallback.class)
public interface PostService {

	/**
	 * 根据岗位标识获取岗位
	 * @param id 岗位标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/getPostById")
	ServiceResponse<PostDTO> getPostById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取岗位列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/getPostList")
	ServiceResponse<List<PostDTO>> getPostList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存岗位
	 * @param postDTO 岗位对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/savePost")
	ServiceResponse<?> savePost(@RequestBody PostDTO postDTO);

	/**
	 * 更新岗位
	 * @param postDTO 岗位对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/updatePost")
	ServiceResponse<?> updatePost(@RequestBody PostDTO postDTO);

	/**
	 * 根据岗位标识删除岗位
	 * @param id 岗位标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/deletePostById")
	ServiceResponse<?> deletePostById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存岗位
	 * @param postList 岗位对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/batchSavePost")
	ServiceResponse<?> batchSavePost(@RequestBody List<PostDTO> postList);

	/**
	 * 根据岗位用户标识获取岗位用户
	 * @param id 岗位用户标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/getPostUserRelById")
	ServiceResponse<PostUserRelDTO> getPostUserRelById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取岗位用户列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/getPostUserRelList")
	ServiceResponse<List<PostUserRelDTO>> getPostUserRelList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/savePostUserRel")
	ServiceResponse<?> savePostUserRel(@RequestBody PostUserRelDTO postUserRelDTO);

	/**
	 * 更新岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/updatePostUserRel")
	ServiceResponse<?> updatePostUserRel(@RequestBody PostUserRelDTO postUserRelDTO);

	/**
	 * 根据岗位用户标识删除岗位用户
	 * @param id 岗位用户标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/deletePostUserRelById")
	ServiceResponse<?> deletePostUserRelById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存岗位用户
	 * @param postUserRelList 岗位用户对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/post/batchSavePostUserRel")
	ServiceResponse<?> batchSavePostUserRel(@RequestBody List<PostUserRelDTO> postUserRelList);
}
