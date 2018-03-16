package com.mes.common.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.common.dto.DataDictionaryDTO;
import com.mes.common.manager.DataDictionaryManager;
import com.mes.common.service.DataDictionaryService;
import com.mes.core.utils.StringUtils;

/**
 * 项目名称:	[common-app]
 * 包:	        [com.mes.common.service.impl]    
 * 类名称:		[DataDictionaryServiceImpl]  
 * 类描述:		[数据字典业务处理类]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月24日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月24日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Autowired
	private DataDictionaryManager dataDictionaryManager;

	/**
	 * 根据数据字典标识获取数据字典
	 * @param id 数据字典标识
	 * @return 数据字典对象
	 */
	@Override
	public DataDictionaryDTO getDataDictionaryById(Long id) {
		DataDictionaryDTO dataDictionaryDTO = dataDictionaryManager.getDataDictionaryById(id);
		return dataDictionaryDTO;
	}

	/**
	 * 根据条件获取数据字典列表
	 * @param condition 查询条件
	 * @return 数据字典列表
	 */
	@Override
	public List<DataDictionaryDTO> getDataDictionaryList(Map<String, Object> condition) {
		List<DataDictionaryDTO> dataDictionaryList = dataDictionaryManager.getDataDictionaryList(condition);
		return dataDictionaryList;
	}

	/**
	 * 保存数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 新增后的数据字典对象
	 */
	@Override
	public DataDictionaryDTO saveDataDictionary(DataDictionaryDTO dataDictionaryDTO) {
		dataDictionaryDTO.setCreateTime(new Date());
		dataDictionaryManager.saveDataDictionary(dataDictionaryDTO);
		return dataDictionaryDTO;
	}

	/**
	 * 更新数据字典
	 * @param dataDictionaryDTO 数据字典对象
	 * @return 更新后的数据字典对象
	 */
	@Override
	public DataDictionaryDTO updateDataDictionary(DataDictionaryDTO dataDictionaryDTO) {
		dataDictionaryDTO.setUpdateTime(new Date());
		dataDictionaryManager.updateDataDictionary(dataDictionaryDTO);
		return dataDictionaryDTO;
	}

	/**
	 * 根据数据字典标识删除数据字典
	 * @param id 数据字典标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public long deleteDataDictionaryById(String id) {
		long result = 0;
		String[] ids = id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				dataDictionaryManager.deleteDataDictionaryById(StringUtils.getAsLong(idStr, 0L));
			}
		}
		return result;
	}

	/**
	 * 批量保存数据字典
	 * @param  dataDictionaryList 数据字典数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveDataDictionary(List<DataDictionaryDTO> dataDictionaryList) {
		long result = 0;
		result = dataDictionaryManager.batchSaveDataDictionary(dataDictionaryList);
		return result;
	}

	/**
	 * 批量更新数据字典
	 * @param  dataDictionaryList 数据字典数据集合
	 * @return 更新成功条数
	 */
	@Override
	public long batchUpdateDataDictionary(List<DataDictionaryDTO> dataDictionaryList) {
		long result = 0;
		if (dataDictionaryList != null && dataDictionaryList.size() > 0) {
			for (DataDictionaryDTO dataDictionaryDTO : dataDictionaryList) {
				dataDictionaryManager.updateDataDictionary(dataDictionaryDTO);
			}
		}
		return result;
	}

}