package com.mes.common.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.SensitivityDTO;
import com.mes.common.service.fallback.SensitivityServiceFallback;

/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service]    
  * 类名称:		[SensitivityService]  
  * 类描述:		[敏感词业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = SensitivityServiceFallback.class)
public interface SensitivityService {

	/**
	 * 根据敏感词标识获取敏感词
	 * @param id 敏感词标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/sensitivity/getSensitivityById")
	ServiceResponse<SensitivityDTO> getSensitivityById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取敏感词列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/sensitivity/getSensitivityList")
	ServiceResponse<List<SensitivityDTO>> getSensitivityList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/sensitivity/saveSensitivity")
	ServiceResponse<?> saveSensitivity(@RequestBody SensitivityDTO sensitivityDTO);

	/**
	 * 更新敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/sensitivity/updateSensitivity")
	ServiceResponse<?> updateSensitivity(@RequestBody SensitivityDTO sensitivityDTO);

	/**
	 * 根据敏感词标识删除敏感词
	 * @param id 敏感词标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/sensitivity/deleteSensitivityById")
	ServiceResponse<?> deleteSensitivityById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存敏感词
	 * @param sensitivityList 敏感词对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/sensitivity/batchSaveSensitivity")
	ServiceResponse<?> batchSaveSensitivity(@RequestBody List<SensitivityDTO> sensitivityList);
}
