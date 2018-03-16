package com.mes.system.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.core.utils.StringUtils;
import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostUserRelDTO;
import com.mes.system.manager.PostManager;
import com.mes.system.manager.PostUserRelManager;
import com.mes.system.service.PostService;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.impl]    
  * 类名称:		[PostServiceImpl]  
  * 类描述:		[岗位业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("postService")
public class PostServiceImpl implements PostService {
	@Autowired
	private PostManager postManager;
	
	@Autowired
	private PostUserRelManager postUserRelManager;
	
	/**
	 * 根据岗位标识获取岗位
	 * @param id 岗位标识
	 * @return 岗位对象
	 */
	@Override
	public PostDTO getPostById(Long id){
		PostDTO postDTO = postManager.getPostById(id);
		return postDTO;
	}
	

	/**
	 * 根据条件获取岗位列表
	 * @param condition 查询条件
	 * @return 岗位列表
	 */
	@Override
	public List<PostDTO> getPostList(Map<String, Object> condition){
		List<PostDTO> postList = postManager.getPostList(condition);
		return postList;
	}

	/**
	 * 保存岗位
	 * @param postDTO 岗位对象
	 * @return 新增后的岗位对象
	 */
	@Override
	public PostDTO savePost(PostDTO postDTO){
	    postDTO.setCreateTime(new Date());
		postManager.savePost(postDTO);
		return postDTO;
	}
	
	/**
	 * 更新岗位
	 * @param postDTO 岗位对象
	 * @return 更新后的岗位对象
	 */
	@Override
	public PostDTO updatePost(PostDTO postDTO){
		postDTO.setUpdateTime(new Date());
		postManager.updatePost(postDTO);
		return postDTO;
	}


	/**
	 * 根据岗位标识删除岗位
	 * @param id 岗位标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deletePostById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				postManager.deletePostById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存岗位
	 * @param  postList 岗位数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePost(List<PostDTO> postList){
		long result = 0;
		result = postManager.batchSavePost(postList);
		return result;
	}

	/**
	 * 根据岗位用户标识获取岗位用户
	 * @param id 岗位用户标识
	 * @return 岗位用户对象
	 */
	@Override
	public PostUserRelDTO getPostUserRelById(Long id){
		PostUserRelDTO postUserRelDTO = postUserRelManager.getPostUserRelById(id);
		return postUserRelDTO;
	}
	

	/**
	 * 根据条件获取岗位用户列表
	 * @param condition 查询条件
	 * @return 岗位用户列表
	 */
	@Override
	public List<PostUserRelDTO> getPostUserRelList(Map<String, Object> condition){
		List<PostUserRelDTO> postUserRelList = postUserRelManager.getPostUserRelList(condition);
		return postUserRelList;
	}

	/**
	 * 保存岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 新增后的岗位用户对象
	 */
	@Override
	public PostUserRelDTO savePostUserRel(PostUserRelDTO postUserRelDTO){
	    postUserRelDTO.setCreateTime(new Date());
		postUserRelManager.savePostUserRel(postUserRelDTO);
		return postUserRelDTO;
	}
	
	/**
	 * 更新岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 更新后的岗位用户对象
	 */
	@Override
	public PostUserRelDTO updatePostUserRel(PostUserRelDTO postUserRelDTO){
		postUserRelDTO.setUpdateTime(new Date());
		postUserRelManager.updatePostUserRel(postUserRelDTO);
		return postUserRelDTO;
	}


	/**
	 * 根据岗位用户标识删除岗位用户
	 * @param id 岗位用户标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deletePostUserRelById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				postUserRelManager.deletePostUserRelById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存岗位用户
	 * @param  postUserRelList 岗位用户数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePostUserRel(List<PostUserRelDTO> postUserRelList){
		long result = 0;
		result = postUserRelManager.batchSavePostUserRel(postUserRelList);
		return result;
	}


}