package com.mes.common.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.SensitivityDTO;
import com.mes.common.service.SensitivityService;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service.fallback]    
  * 类名称:		[SensitivityServiceFallback]  
  * 类描述:		[敏感词业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class SensitivityServiceFallback implements SensitivityService {
/**
	 * 根据敏感词标识获取敏感词
	 * @param id 敏感词标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<SensitivityDTO> getSensitivityById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据敏感词标识获取敏感词服务不可用.");
	}

	/**
	 * 根据条件获取敏感词列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<SensitivityDTO>> getSensitivityList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取敏感词列表服务不可用.");
	}

	/**
	 * 保存敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveSensitivity(SensitivityDTO sensitivityDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存敏感词服务不可用.");
	}
	
	/**
	 * 更新敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateSensitivity(SensitivityDTO sensitivityDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新敏感词服务不可用.");
	}

	/**
	 * 根据敏感词标识删除敏感词
	 * @param id 敏感词标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteSensitivityById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据敏感词标识删除敏感词服务不可用.");
	}

	/**
	 * 批量保存敏感词
	 * @param sensitivityDAOList 敏感词对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSaveSensitivity(List<SensitivityDTO> sensitivityList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存敏感词服务不可用.");
	 }
}
