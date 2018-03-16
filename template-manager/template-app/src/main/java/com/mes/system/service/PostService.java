package com.mes.system.service;

import java.util.List;
import java.util.Map;

import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostUserRelDTO;

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
public interface PostService {
	/**
	 * 根据岗位标识获取岗位
	 * @param id 岗位标识
	 * @return 岗位对象
	 */
	PostDTO getPostById(Long id);

	/**
	 * 根据条件获取岗位列表
	 * @param condition 查询条件
	 * @return 岗位列表
	 */
	List<PostDTO> getPostList(Map<String, Object> condition);

	/**
	 * 保存岗位
	 * @param postDTO 岗位对象
	 * @return 新增后的岗位对象
	 */
	PostDTO savePost(PostDTO postDTO);

	/**
	 * 更新岗位
	 * @param postDTO 岗位对象
	 * @return 更新后的岗位对象
	 */
	PostDTO updatePost(PostDTO postDTO);

	/**
	 * 根据岗位标识删除岗位
	 * @param id 岗位标识
	 * @return 删除成功条数
	 */
	long deletePostById(String id);

	/**
	 * 批量保存岗位
	 * @param  postList 岗位数据集合
	 * @return 新增成功条数
	 */
	long batchSavePost(List<PostDTO> postList);

	/**
	 * 根据岗位用户标识获取岗位用户
	 * @param id 岗位用户标识
	 * @return 岗位用户对象
	 */
	PostUserRelDTO getPostUserRelById(Long id);

	/**
	 * 根据条件获取岗位用户列表
	 * @param condition 查询条件
	 * @return 岗位用户列表
	 */
	List<PostUserRelDTO> getPostUserRelList(Map<String, Object> condition);

	/**
	 * 保存岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 新增后的岗位用户对象
	 */
	PostUserRelDTO savePostUserRel(PostUserRelDTO postUserRelDTO);

	/**
	 * 更新岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 更新后的岗位用户对象
	 */
	PostUserRelDTO updatePostUserRel(PostUserRelDTO postUserRelDTO);

	/**
	 * 根据岗位用户标识删除岗位用户
	 * @param id 岗位用户标识
	 * @return 删除成功条数
	 */
	long deletePostUserRelById(String id);

	/**
	 * 批量保存岗位用户
	 * @param  postUserRelList 岗位用户数据集合
	 * @return 新增成功条数
	 */
	long batchSavePostUserRel(List<PostUserRelDTO> postUserRelList);
}
