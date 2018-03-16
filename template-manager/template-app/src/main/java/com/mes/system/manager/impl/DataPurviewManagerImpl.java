package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.DataPurviewManager;
import com.mes.system.dao.DataPurviewMapper;
import com.mes.system.dto.DataPurviewDTO;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[DataPurviewManagerImpl]  
  * 类描述:		[数据权限管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("dataPurviewManager")
public class DataPurviewManagerImpl implements DataPurviewManager {
	@Autowired
	private DataPurviewMapper dataPurviewMapper;

	/**
	 * 根据数据权限标识获取数据权限
	 * @param id 数据权限标识
	 * @return 数据权限对象
	 */
	@Override
	public DataPurviewDTO getDataPurviewById(Long id) {
		return dataPurviewMapper.getDataPurviewById(id);
	}

	/**
	 * 根据条件获取数据权限列表
	 * @param condition 查询条件
	 * @return 数据权限列表
	 */
	@Override
	public List<DataPurviewDTO> getDataPurviewList(Map<String, Object> condition) {
		return dataPurviewMapper.getDataPurviewList(condition);
	}

	/**
	 * 保存数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveDataPurview(DataPurviewDTO dataPurviewDTO) {
		return dataPurviewMapper.saveDataPurview(dataPurviewDTO);
	}

	/**
	 * 更新数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateDataPurview(DataPurviewDTO dataPurviewDTO) {
		return dataPurviewMapper.updateDataPurview(dataPurviewDTO);
	}

	/**
	 * 根据数据权限标识删除数据权限
	 * @param id 数据权限标识
	 * @return 删除成功条数
	 */
	@Override
	public long deleteDataPurviewById(Long id) {
		return dataPurviewMapper.deleteDataPurviewById(id);
	}

	/**
	 * 批量保存数据权限
	 * @param  dataPurviewList 数据权限数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveDataPurview(List<DataPurviewDTO> dataPurviewList) {
		return dataPurviewMapper.batchSaveDataPurview(dataPurviewList);
	}

	/**
	 * 根据权限对象标识删除数据权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	@Override
	public long deleteDataPurviewBySecId(String secId) {
		return dataPurviewMapper.deleteDataPurviewBySecId(secId);
	}
}
