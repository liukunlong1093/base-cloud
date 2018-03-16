package com.mes.product.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.product.dto.UnitDTO;
import com.mes.product.service.UnitService;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.product.service.fallback]    
  * 类名称:		[UnitServiceFallback]  
  * 类描述:		[包装单位业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月03日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月03日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class UnitServiceFallback implements UnitService {
	/**
		 * 根据包装单位标识获取包装单位
		 * @param id 包装单位标识
		 * @return 服务响应对象
		 */
	@Override
	public ServiceResponse<UnitDTO> getUnitById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据包装单位标识获取包装单位服务不可用.");
	}

	/**
	 * 根据条件获取包装单位列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<UnitDTO>> getUnitList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取包装单位列表服务不可用.");
	}

	/**
	 * 保存包装单位
	 * @param unitDTO 包装单位对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveUnit(UnitDTO unitDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存包装单位服务不可用.");
	}

	/**
	 * 更新包装单位
	 * @param unitDTO 包装单位对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateUnit(UnitDTO unitDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新包装单位服务不可用.");
	}

	/**
	 * 根据包装单位标识删除包装单位
	 * @param id 包装单位标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteUnitById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据包装单位标识删除包装单位服务不可用.");
	}

	/**
	 * 批量保存包装单位
	 * @param unitDAOList 包装单位对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveUnit(List<UnitDTO> unitList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存包装单位服务不可用.");
	}
}
