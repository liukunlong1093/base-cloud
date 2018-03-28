package com.mes.common.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.ConfigDTO;
import com.mes.common.service.ConfigService;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service.fallback]    
  * 类名称:		[ConfigServiceFallback]  
  * 类描述:		[配置业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class ConfigServiceFallback implements ConfigService {
/**
	 * 根据配置标识获取配置
	 * @param id 配置标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<ConfigDTO> getConfigById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据配置标识获取配置服务不可用.");
	}

	/**
	 * 根据条件获取配置列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<ConfigDTO>> getConfigList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取配置列表服务不可用.");
	}

	/**
	 * 保存配置
	 * @param configDTO 配置对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveConfig(ConfigDTO configDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存配置服务不可用.");
	}
	
	/**
	 * 更新配置
	 * @param configDTO 配置对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateConfig(ConfigDTO configDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新配置服务不可用.");
	}

	/**
	 * 根据配置标识删除配置
	 * @param id 配置标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteConfigById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据配置标识删除配置服务不可用.");
	}

	/**
	 * 批量保存配置
	 * @param configDAOList 配置对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSaveConfig(List<ConfigDTO> configList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存配置服务不可用.");
	 }
}
