package com.mes.system.service.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.PostDTO;
import com.mes.system.dto.PostUserRelDTO;
import com.mes.system.service.PostService;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[PostServiceFallback]  
  * 类描述:		[岗位业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class PostServiceFallback implements PostService {
/**
	 * 根据岗位标识获取岗位
	 * @param id 岗位标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<PostDTO> getPostById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据岗位标识获取岗位服务不可用.");
	}

	/**
	 * 根据条件获取岗位列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<PostDTO>> getPostList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取岗位列表服务不可用.");
	}

	/**
	 * 保存岗位
	 * @param postDTO 岗位对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> savePost(PostDTO postDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存岗位服务不可用.");
	}
	
	/**
	 * 更新岗位
	 * @param postDTO 岗位对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updatePost(PostDTO postDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新岗位服务不可用.");
	}

	/**
	 * 根据岗位标识删除岗位
	 * @param id 岗位标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deletePostById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据岗位标识删除岗位服务不可用.");
	}

	/**
	 * 批量保存岗位
	 * @param postDAOList 岗位对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSavePost(List<PostDTO> postList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存岗位服务不可用.");
	 }
	 
	 /**
		 * 根据岗位用户标识获取岗位用户
		 * @param id 岗位用户标识
		 * @return 服务响应对象
		 */
	@Override
		public ServiceResponse<PostUserRelDTO> getPostUserRelById(Long id){
			return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据岗位用户标识获取岗位用户服务不可用.");
		}

		/**
		 * 根据条件获取岗位用户列表
		 * @param condition 查询条件
		 * @return 服务响应对象
		 */
	@Override
		public ServiceResponse<List<PostUserRelDTO>> getPostUserRelList(Map<String, Object> condition){
			return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取岗位用户列表服务不可用.");
		}

		/**
		 * 保存岗位用户
		 * @param postUserRelDTO 岗位用户对象
		 * @return 服务响应对象
		 */
	@Override
		public ServiceResponse<?> savePostUserRel(PostUserRelDTO postUserRelDTO){
			return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存岗位用户服务不可用.");
		}
		
		/**
		 * 更新岗位用户
		 * @param postUserRelDTO 岗位用户对象
		 * @return 服务响应对象
		 */
	@Override
		public ServiceResponse<?> updatePostUserRel(PostUserRelDTO postUserRelDTO){
			return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新岗位用户服务不可用.");
		}

		/**
		 * 根据岗位用户标识删除岗位用户
		 * @param id 岗位用户标识(多个已逗号分隔)
		 * @return 服务响应对象
		 */
	@Override
		public ServiceResponse<?> deletePostUserRelById(String id){
			return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据岗位用户标识删除岗位用户服务不可用.");
		}

		/**
		 * 批量保存岗位用户
		 * @param postUserRelDAOList 岗位用户对象集合
		 * @return 服务响应对象
		 */
	@Override
		 public ServiceResponse<?> batchSavePostUserRel(List<PostUserRelDTO> postUserRelList){
		 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存岗位用户服务不可用.");
		 }
}
