package com.mes.system.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.ApiDTO;
import com.mes.system.service.ApiService;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[ApiServiceFallback]  
  * 类描述:		[应用程序接口业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class ApiServiceFallback implements ApiService {
/**
	 * 根据应用程序接口标识获取应用程序接口
	 * @param id 应用程序接口标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<ApiDTO> getApiById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据应用程序接口标识获取应用程序接口服务不可用.");
	}

	/**
	 * 根据条件获取应用程序接口列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<ApiDTO>> getApiList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取应用程序接口列表服务不可用.");
	}

	/**
	 * 保存应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveApi(ApiDTO apiDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存应用程序接口服务不可用.");
	}
	
	/**
	 * 更新应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateApi(ApiDTO apiDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新应用程序接口服务不可用.");
	}

	/**
	 * 根据应用程序接口标识删除应用程序接口
	 * @param id 应用程序接口标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteApiById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据应用程序接口标识删除应用程序接口服务不可用.");
	}

	/**
	 * 批量保存应用程序接口
	 * @param apiDAOList 应用程序接口对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSaveApi(List<ApiDTO> apiList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存应用程序接口服务不可用.");
	 }
}
