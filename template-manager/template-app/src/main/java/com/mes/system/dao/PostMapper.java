package com.mes.system.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.mes.system.dto.PostDTO;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.dao]    
  * 类名称:		[UserMapper]  
  * 类描述:		[岗位数据映射接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Mapper
public interface PostMapper {
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
	 * @return 新增成功条数
	 */
	long savePost(PostDTO postDTO);

	/**
	 * 更新岗位
	 * @param postDTO 岗位对象
	 * @return 更新成功条数
	 */
	long updatePost(PostDTO postDTO);

	/**
	 * 根据岗位标识删除岗位
	 * @param id 岗位标识
	 * @return 删除成功条数
	 */
	long deletePostById(Long id);

	/**
	 * 批量保存岗位
	 * @param  postList 岗位数据集合
	 * @return 新增成功条数
	 */
	long batchSavePost(List<PostDTO> postList);

}
