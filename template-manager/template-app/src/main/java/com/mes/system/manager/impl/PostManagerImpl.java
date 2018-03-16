package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.PostManager;
import com.mes.system.dao.PostMapper;
import com.mes.system.dto.PostDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[PostManagerImpl]  
  * 类描述:		[岗位管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("postManager")
public class PostManagerImpl implements PostManager {
	@Autowired
	private PostMapper postMapper;


	/**
	 * 根据岗位标识获取岗位
	 * @param id 岗位标识
	 * @return 岗位对象
	 */
	@Override
	public PostDTO getPostById(Long id){
		return postMapper.getPostById(id);
	}

	/**
	 * 根据条件获取岗位列表
	 * @param condition 查询条件
	 * @return 岗位列表
	 */
	@Override
	public List<PostDTO> getPostList(Map<String, Object> condition){
		return postMapper.getPostList(condition);
	}

	/**
	 * 保存岗位
	 * @param postDTO 岗位对象
	 * @return 新增成功条数
	 */
	@Override
	public long savePost(PostDTO postDTO){
		return postMapper.savePost(postDTO);
	}

	/**
	 * 更新岗位
	 * @param postDTO 岗位对象
	 * @return 更新成功条数
	 */
	@Override
	public long updatePost(PostDTO postDTO){
		return postMapper.updatePost(postDTO);
	}

	/**
	 * 根据岗位标识删除岗位
	 * @param id 岗位标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deletePostById(Long id){
		return postMapper.deletePostById(id);
	}

	/**
	 * 批量保存岗位
	 * @param  postList 岗位数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePost(List<PostDTO> postList){
		return postMapper.batchSavePost(postList);
	}
}
