package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.PostUserRelManager;
import com.mes.system.dao.PostUserRelMapper;
import com.mes.system.dto.PostUserRelDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[PostUserRelManagerImpl]  
  * 类描述:		[岗位用户管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("postUserRelManager")
public class PostUserRelManagerImpl implements PostUserRelManager {
	@Autowired
	private PostUserRelMapper postUserRelMapper;


	/**
	 * 根据岗位用户标识获取岗位用户
	 * @param id 岗位用户标识
	 * @return 岗位用户对象
	 */
	@Override
	public PostUserRelDTO getPostUserRelById(Long id){
		return postUserRelMapper.getPostUserRelById(id);
	}

	/**
	 * 根据条件获取岗位用户列表
	 * @param condition 查询条件
	 * @return 岗位用户列表
	 */
	@Override
	public List<PostUserRelDTO> getPostUserRelList(Map<String, Object> condition){
		return postUserRelMapper.getPostUserRelList(condition);
	}

	/**
	 * 保存岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 新增成功条数
	 */
	@Override
	public long savePostUserRel(PostUserRelDTO postUserRelDTO){
		return postUserRelMapper.savePostUserRel(postUserRelDTO);
	}

	/**
	 * 更新岗位用户
	 * @param postUserRelDTO 岗位用户对象
	 * @return 更新成功条数
	 */
	@Override
	public long updatePostUserRel(PostUserRelDTO postUserRelDTO){
		return postUserRelMapper.updatePostUserRel(postUserRelDTO);
	}

	/**
	 * 根据岗位用户标识删除岗位用户
	 * @param id 岗位用户标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deletePostUserRelById(Long id){
		return postUserRelMapper.deletePostUserRelById(id);
	}

	/**
	 * 批量保存岗位用户
	 * @param  postUserRelList 岗位用户数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePostUserRel(List<PostUserRelDTO> postUserRelList){
		return postUserRelMapper.batchSavePostUserRel(postUserRelList);
	}
}
