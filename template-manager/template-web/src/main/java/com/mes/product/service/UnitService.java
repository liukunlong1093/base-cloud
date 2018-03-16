package com.mes.product.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.product.dto.UnitDTO;
import com.mes.product.service.fallback.UnitServiceFallback;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.product.service]    
  * 类名称:		[UnitService]  
  * 类描述:		[包装单位业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月03日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月03日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = UnitServiceFallback.class)
public interface UnitService {

	/**
	 * 根据包装单位标识获取包装单位
	 * @param id 包装单位标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/product/getUnitById")
	ServiceResponse<UnitDTO> getUnitById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取包装单位列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/product/getUnitList")
	ServiceResponse<List<UnitDTO>> getUnitList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存包装单位
	 * @param unitDTO 包装单位对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/product/saveUnit")
	ServiceResponse<?> saveUnit(@RequestBody UnitDTO unitDTO);

	/**
	 * 更新包装单位
	 * @param unitDTO 包装单位对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/product/updateUnit")
	ServiceResponse<?> updateUnit(@RequestBody UnitDTO unitDTO);

	/**
	 * 根据包装单位标识删除包装单位
	 * @param id 包装单位标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/product/deleteUnitById")
	ServiceResponse<?> deleteUnitById(@RequestParam(value = "id") Long id);

	/**
	 * 批量保存包装单位
	 * @param unitList 包装单位对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/product/batchSaveUnit")
	ServiceResponse<?> batchSaveUnit(@RequestBody List<UnitDTO> unitList);
}
