package com.mes.common.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.DataDictionaryDTO;
import com.mes.common.service.DataDictionaryService;

/**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.service.fallback]    
  * 类名称:		[DataDictionaryServiceFallback]  
  * 类描述:		[数据字典业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class DataDictionaryServiceFallback implements DataDictionaryService {
	/**
		 * 根据数据字典标识获取数据字典
		 * @param id 数据字典标识
		 * @return 服务响应对象
		 */
	@Override
	public ServiceResponse<DataDictionaryDTO> getDataDictionaryById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据数据字典标识获取数据字典服务不可用.");
	}

	/**
	 * 根据条件获取数据字典列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<DataDictionaryDTO>> getDataDictionaryList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取数据字典列表服务不可用.");
	}

	/**
	 * 保存数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveDataDictionary(DataDictionaryDTO dataDictionaryDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存数据字典服务不可用.");
	}

	/**
	 * 更新数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateDataDictionary(DataDictionaryDTO dataDictionaryDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新数据字典服务不可用.");
	}

	/**
	 * 根据数据字典标识删除数据字典
	 * @param id 数据字典标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteDataDictionaryById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据数据字典标识删除数据字典服务不可用.");
	}

	/**
	 * 批量保存数据字典
	 * @param dataDictionaryDAOList 数据字典对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveDataDictionary(List<DataDictionaryDTO> dataDictionaryList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存数据字典服务不可用.");
	}

	/**
	 * 批量更新数据字典
	 * @param dataDictionaryDAOList 数据字典对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchUpdateDataDictionary(List<DataDictionaryDTO> dataDictionaryList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量更新数据字典服务不可用.");
	}
}
