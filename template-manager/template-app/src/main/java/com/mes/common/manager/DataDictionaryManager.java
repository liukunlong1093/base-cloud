package com.mes.common.manager;
import java.util.*;
import com.mes.common.dto.DataDictionaryDTO;
 /**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.manager]    
  * 类名称:		[DataDictionaryManager]  
  * 类描述:		[数据字典管理处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface DataDictionaryManager {
	/**
	 * 根据数据字典标识获取数据字典
	 * @param id 数据字典标识
	 * @return 数据字典对象
	 */
	 DataDictionaryDTO getDataDictionaryById(Long id);

	/**
	 * 根据条件获取数据字典列表
	 * @param condition 查询条件
	 * @return 数据字典列表
	 */
	 List<DataDictionaryDTO> getDataDictionaryList(Map<String, Object> condition);

	/**
	 * 保存数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 新增成功条数
	 */
	 long saveDataDictionary(DataDictionaryDTO dataDictionaryDTO);

	/**
	 * 更新数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 更新成功条数
	 */
	 long updateDataDictionary(DataDictionaryDTO dataDictionaryDTO);

	/**
	 * 根据数据字典标识删除数据字典
	 * @param id 数据字典标识
	 * @return 删除成功条数
	 */
	 long  deleteDataDictionaryById(Long id);

	/**
	 * 批量保存数据字典
	 * @param  dataDictionaryList 数据字典数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveDataDictionary(List<DataDictionaryDTO> dataDictionaryList);
}
