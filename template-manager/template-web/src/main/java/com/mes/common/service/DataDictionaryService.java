package com.mes.common.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.DataDictionaryDTO;
import com.mes.common.service.fallback.DataDictionaryServiceFallback;

/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service]    
  * 类名称:		[DataDictionaryService]  
  * 类描述:		[数据字典业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = DataDictionaryServiceFallback.class)
public interface DataDictionaryService {

	/**
	 * 根据数据字典标识获取数据字典
	 * @param id 数据字典标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/dataDictionary/getDataDictionaryById")
	ServiceResponse<DataDictionaryDTO> getDataDictionaryById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取数据字典列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/dataDictionary/getDataDictionaryList")
	ServiceResponse<List<DataDictionaryDTO>> getDataDictionaryList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/dataDictionary/saveDataDictionary")
	ServiceResponse<?> saveDataDictionary(@RequestBody DataDictionaryDTO dataDictionaryDTO);

	/**
	 * 更新数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/dataDictionary/updateDataDictionary")
	ServiceResponse<?> updateDataDictionary(@RequestBody DataDictionaryDTO dataDictionaryDTO);

	/**
	 * 根据数据字典标识删除数据字典
	 * @param id 数据字典标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/dataDictionary/deleteDataDictionaryById")
	ServiceResponse<?> deleteDataDictionaryById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存数据字典
	 * @param dataDictionaryList 数据字典对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/dataDictionary/batchSaveDataDictionary")
	ServiceResponse<?> batchSaveDataDictionary(@RequestBody List<DataDictionaryDTO> dataDictionaryList);

	/**
	 * 批量更新数据字典
	 * @param dataDictionaryList 数据字典对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/dataDictionary/batchUpdateDataDictionary")
	ServiceResponse<?> batchUpdateDataDictionary(@RequestBody List<DataDictionaryDTO> dataDictionaryList);
}
