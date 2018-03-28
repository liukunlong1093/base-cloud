package com.mes.common.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.ConfigDTO;
import com.mes.common.service.fallback.ConfigServiceFallback;

/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service]    
  * 类名称:		[ConfigService]  
  * 类描述:		[配置业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = ConfigServiceFallback.class)
public interface ConfigService {

	/**
	 * 根据配置标识获取配置
	 * @param id 配置标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/config/getConfigById")
	ServiceResponse<ConfigDTO> getConfigById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取配置列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/config/getConfigList")
	ServiceResponse<List<ConfigDTO>> getConfigList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存配置
	 * @param configDTO 配置对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/config/saveConfig")
	ServiceResponse<?> saveConfig(@RequestBody ConfigDTO configDTO);

	/**
	 * 更新配置
	 * @param configDTO 配置对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/config/updateConfig")
	ServiceResponse<?> updateConfig(@RequestBody ConfigDTO configDTO);

	/**
	 * 根据配置标识删除配置
	 * @param id 配置标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/config/deleteConfigById")
	ServiceResponse<?> deleteConfigById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存配置
	 * @param configList 配置对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/config/batchSaveConfig")
	ServiceResponse<?> batchSaveConfig(@RequestBody List<ConfigDTO> configList);
}
