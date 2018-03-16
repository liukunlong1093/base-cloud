package com.mes.system.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.PostTypeDTO;
import com.mes.system.service.PostTypeService;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[PostTypeServiceFallback]  
  * 类描述:		[岗位类型业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class PostTypeServiceFallback implements PostTypeService {
/**
	 * 根据岗位类型标识获取岗位类型
	 * @param id 岗位类型标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<PostTypeDTO> getPostTypeById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据岗位类型标识获取岗位类型服务不可用.");
	}

	/**
	 * 根据条件获取岗位类型列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<PostTypeDTO>> getPostTypeList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取岗位类型列表服务不可用.");
	}

	/**
	 * 保存岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> savePostType(PostTypeDTO postTypeDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存岗位类型服务不可用.");
	}
	
	/**
	 * 更新岗位类型
	 * @param postTypeDTO 岗位类型对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updatePostType(PostTypeDTO postTypeDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新岗位类型服务不可用.");
	}

	/**
	 * 根据岗位类型标识删除岗位类型
	 * @param id 岗位类型标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deletePostTypeById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据岗位类型标识删除岗位类型服务不可用.");
	}

	/**
	 * 批量保存岗位类型
	 * @param postTypeDAOList 岗位类型对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSavePostType(List<PostTypeDTO> postTypeList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存岗位类型服务不可用.");
	 }
}
