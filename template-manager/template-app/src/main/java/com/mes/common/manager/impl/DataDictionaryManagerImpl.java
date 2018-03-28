package com.mes.common.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.common.manager.DataDictionaryManager;
import com.mes.common.dao.DataDictionaryMapper;
import com.mes.common.dto.DataDictionaryDTO;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.manager.impl]    
  * 类名称:		[DataDictionaryManagerImpl]  
  * 类描述:		[数据字典管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("dataDictionaryManager")
public class DataDictionaryManagerImpl implements DataDictionaryManager {
	@Autowired
	private DataDictionaryMapper dataDictionaryMapper;


	/**
	 * 根据数据字典标识获取数据字典
	 * @param id 数据字典标识
	 * @return 数据字典对象
	 */
	@Override
	public DataDictionaryDTO getDataDictionaryById(Long id){
		return dataDictionaryMapper.getDataDictionaryById(id);
	}

	/**
	 * 根据条件获取数据字典列表
	 * @param condition 查询条件
	 * @return 数据字典列表
	 */
	@Override
	public List<DataDictionaryDTO> getDataDictionaryList(Map<String, Object> condition){
		return dataDictionaryMapper.getDataDictionaryList(condition);
	}

	/**
	 * 保存数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveDataDictionary(DataDictionaryDTO dataDictionaryDTO){
		return dataDictionaryMapper.saveDataDictionary(dataDictionaryDTO);
	}

	/**
	 * 更新数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateDataDictionary(DataDictionaryDTO dataDictionaryDTO){
		return dataDictionaryMapper.updateDataDictionary(dataDictionaryDTO);
	}

	/**
	 * 根据数据字典标识删除数据字典
	 * @param id 数据字典标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteDataDictionaryById(Long id){
		return dataDictionaryMapper.deleteDataDictionaryById(id);
	}

	/**
	 * 批量保存数据字典
	 * @param  dataDictionaryList 数据字典数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveDataDictionary(List<DataDictionaryDTO> dataDictionaryList){
		return dataDictionaryMapper.batchSaveDataDictionary(dataDictionaryList);
	}
}
