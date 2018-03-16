package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.PostTypeManager;
import com.mes.system.dao.PostTypeMapper;
import com.mes.system.dto.PostTypeDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[PostTypeManagerImpl]  
  * 类描述:		[岗位类型管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("postTypeManager")
public class PostTypeManagerImpl implements PostTypeManager {
	@Autowired
	private PostTypeMapper postTypeMapper;


	/**
	 * 根据岗位类型标识获取岗位类型
	 * @param id 岗位类型标识
	 * @return 岗位类型对象
	 */
	@Override
	public PostTypeDTO getPostTypeById(Long id){
		return postTypeMapper.getPostTypeById(id);
	}

	/**
	 * 根据条件获取岗位类型列表
	 * @param condition 查询条件
	 * @return 岗位类型列表
	 */
	@Override
	public List<PostTypeDTO> getPostTypeList(Map<String, Object> condition){
		return postTypeMapper.getPostTypeList(condition);
	}

	/**
	 * 保存岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 新增成功条数
	 */
	@Override
	public long savePostType(PostTypeDTO postTypeDTO){
		return postTypeMapper.savePostType(postTypeDTO);
	}

	/**
	 * 更新岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 更新成功条数
	 */
	@Override
	public long updatePostType(PostTypeDTO postTypeDTO){
		return postTypeMapper.updatePostType(postTypeDTO);
	}

	/**
	 * 根据岗位类型标识删除岗位类型
	 * @param id 岗位类型标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deletePostTypeById(Long id){
		return postTypeMapper.deletePostTypeById(id);
	}

	/**
	 * 批量保存岗位类型
	 * @param  postTypeList 岗位类型数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePostType(List<PostTypeDTO> postTypeList){
		return postTypeMapper.batchSavePostType(postTypeList);
	}
}
