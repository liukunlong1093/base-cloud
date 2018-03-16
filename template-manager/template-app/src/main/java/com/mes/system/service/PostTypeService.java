package com.mes.system.service;

import java.util.*;
import com.mes.system.dto.PostTypeDTO;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[PostTypeService]  
  * 类描述:		[岗位类型业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface PostTypeService {
	/**
	 * 根据岗位类型标识获取岗位类型
	 * @param id 岗位类型标识
	 * @return 岗位类型对象
	 */
	PostTypeDTO getPostTypeById(Long id);

	/**
	 * 根据条件获取岗位类型列表
	 * @param condition 查询条件
	 * @return 岗位类型列表
	 */
	List<PostTypeDTO> getPostTypeList(Map<String, Object> condition);

	/**
	 * 保存岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 新增后的岗位类型对象
	 */
	PostTypeDTO savePostType(PostTypeDTO postTypeDTO);

	/**
	 * 更新岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 更新后的岗位类型对象
	 */
	PostTypeDTO updatePostType(PostTypeDTO postTypeDTO);

	/**
	 * 根据岗位类型标识删除岗位类型
	 * @param id 岗位类型标识
	 * @return 删除成功条数
	 */
	long deletePostTypeById(String id);

	/**
	 * 批量保存岗位类型
	 * @param  postTypeList 岗位类型数据集合
	 * @return 新增成功条数
	 */
	long batchSavePostType(List<PostTypeDTO> postTypeList);
}
