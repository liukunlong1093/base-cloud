package com.mes.system.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.ApiDTO;
import com.mes.system.service.fallback.ApiServiceFallback;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[ApiService]  
  * 类描述:		[应用程序接口业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = ApiServiceFallback.class)
public interface ApiService {

	/**
	 * 根据应用程序接口标识获取应用程序接口
	 * @param id 应用程序接口标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/api/getApiById")
	ServiceResponse<ApiDTO> getApiById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取应用程序接口列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/api/getApiList")
	ServiceResponse<List<ApiDTO>> getApiList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/api/saveApi")
	ServiceResponse<?> saveApi(@RequestBody ApiDTO apiDTO);

	/**
	 * 更新应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/api/updateApi")
	ServiceResponse<?> updateApi(@RequestBody ApiDTO apiDTO);

	/**
	 * 根据应用程序接口标识删除应用程序接口
	 * @param id 应用程序接口标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/api/deleteApiById")
	ServiceResponse<?> deleteApiById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存应用程序接口
	 * @param apiList 应用程序接口对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/api/batchSaveApi")
	ServiceResponse<?> batchSaveApi(@RequestBody List<ApiDTO> apiList);
}
