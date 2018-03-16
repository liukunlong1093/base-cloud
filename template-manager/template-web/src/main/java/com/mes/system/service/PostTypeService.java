package com.mes.system.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.PostTypeDTO;
import com.mes.system.service.fallback.PostTypeServiceFallback;

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
@FeignClient(value = "info-app", fallback = PostTypeServiceFallback.class)
public interface PostTypeService {

	/**
	 * 根据岗位类型标识获取岗位类型
	 * @param id 岗位类型标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/postType/getPostTypeById")
	ServiceResponse<PostTypeDTO> getPostTypeById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取岗位类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/postType/getPostTypeList")
	ServiceResponse<List<PostTypeDTO>> getPostTypeList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/postType/savePostType")
	ServiceResponse<?> savePostType(@RequestBody PostTypeDTO postTypeDTO);

	/**
	 * 更新岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/postType/updatePostType")
	ServiceResponse<?> updatePostType(@RequestBody PostTypeDTO postTypeDTO);

	/**
	 * 根据岗位类型标识删除岗位类型
	 * @param id 岗位类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/postType/deletePostTypeById")
	ServiceResponse<?> deletePostTypeById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存岗位类型
	 * @param postTypeList 岗位类型对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/postType/batchSavePostType")
	ServiceResponse<?> batchSavePostType(@RequestBody List<PostTypeDTO> postTypeList);
}
