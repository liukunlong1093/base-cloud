package com.mes.common.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.AreaDTO;
import com.mes.common.service.AreaService;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service.fallback]    
  * 类名称:		[AreaServiceFallback]  
  * 类描述:		[区域业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class AreaServiceFallback implements AreaService {
/**
	 * 根据区域标识获取区域
	 * @param id 区域标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<AreaDTO> getAreaById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据区域标识获取区域服务不可用.");
	}

	/**
	 * 根据条件获取区域列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<AreaDTO>> getAreaList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取区域列表服务不可用.");
	}

	/**
	 * 保存区域
	 * @param areaDTO 区域对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveArea(AreaDTO areaDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存区域服务不可用.");
	}
	
	/**
	 * 更新区域
	 * @param areaDTO 区域对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateArea(AreaDTO areaDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新区域服务不可用.");
	}

	/**
	 * 根据区域标识删除区域
	 * @param id 区域标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteAreaById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据区域标识删除区域服务不可用.");
	}

	/**
	 * 批量保存区域
	 * @param areaDAOList 区域对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSaveArea(List<AreaDTO> areaList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存区域服务不可用.");
	 }
}
