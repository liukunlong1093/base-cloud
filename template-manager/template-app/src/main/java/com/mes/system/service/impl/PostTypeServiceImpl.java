package com.mes.system.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.dto.PostTypeDTO;
import com.mes.system.manager.PostTypeManager;
import com.mes.system.service.PostTypeService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.impl]    
  * 类名称:		[PostTypeServiceImpl]  
  * 类描述:		[岗位类型业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("postTypeService")
public class PostTypeServiceImpl implements PostTypeService {
	@Autowired
	private PostTypeManager postTypeManager;
	
	/**
	 * 根据岗位类型标识获取岗位类型
	 * @param id 岗位类型标识
	 * @return 岗位类型对象
	 */
	@Override
	public PostTypeDTO getPostTypeById(Long id){
		PostTypeDTO postTypeDTO = postTypeManager.getPostTypeById(id);
		return postTypeDTO;
	}
	

	/**
	 * 根据条件获取岗位类型列表
	 * @param condition 查询条件
	 * @return 岗位类型列表
	 */
	@Override
	public List<PostTypeDTO> getPostTypeList(Map<String, Object> condition){
		List<PostTypeDTO> postTypeList = postTypeManager.getPostTypeList(condition);
		return postTypeList;
	}

	/**
	 * 保存岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 新增后的岗位类型对象
	 */
	@Override
	public PostTypeDTO savePostType(PostTypeDTO postTypeDTO){
	    postTypeDTO.setCreateTime(new Date());
		postTypeManager.savePostType(postTypeDTO);
		return postTypeDTO;
	}
	
	/**
	 * 更新岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 更新后的岗位类型对象
	 */
	@Override
	public PostTypeDTO updatePostType(PostTypeDTO postTypeDTO){
		postTypeDTO.setUpdateTime(new Date());
		postTypeManager.updatePostType(postTypeDTO);
		return postTypeDTO;
	}


	/**
	 * 根据岗位类型标识删除岗位类型
	 * @param id 岗位类型标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deletePostTypeById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				postTypeManager.deletePostTypeById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存岗位类型
	 * @param  postTypeList 岗位类型数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSavePostType(List<PostTypeDTO> postTypeList){
		long result = 0;
		result = postTypeManager.batchSavePostType(postTypeList);
		return result;
	}

	

}