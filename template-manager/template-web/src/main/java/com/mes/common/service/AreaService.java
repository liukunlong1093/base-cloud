package com.mes.common.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.AreaDTO;
import com.mes.common.service.fallback.AreaServiceFallback;

/**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.service]    
  * 类名称:		[AreaService]  
  * 类描述:		[区域业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = AreaServiceFallback.class)
public interface AreaService {

	/**
	 * 根据区域标识获取区域
	 * @param id 区域标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/area/getAreaById")
	ServiceResponse<AreaDTO> getAreaById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取区域列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/area/getAreaList")
	ServiceResponse<List<AreaDTO>> getAreaList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存区域
	 * @param areaDTO 区域对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/area/saveArea")
	ServiceResponse<?> saveArea(@RequestBody AreaDTO areaDTO);

	/**
	 * 更新区域
	 * @param areaDTO 区域对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/area/updateArea")
	ServiceResponse<?> updateArea(@RequestBody AreaDTO areaDTO);

	/**
	 * 根据区域标识删除区域
	 * @param id 区域标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/area/deleteAreaById")
	ServiceResponse<?> deleteAreaById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存区域
	 * @param areaList 区域对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/area/batchSaveArea")
	ServiceResponse<?> batchSaveArea(@RequestBody List<AreaDTO> areaList);
}
