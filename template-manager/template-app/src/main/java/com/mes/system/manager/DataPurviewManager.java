package com.mes.system.manager;

import java.util.*;
import com.mes.system.dto.DataPurviewDTO;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.manager]    
 * 类名称:		[DataPurviewManager]  
 * 类描述:		[数据权限管理处理接口]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月21日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月21日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
public interface DataPurviewManager {
	/**
	 * 根据数据权限标识获取数据权限
	 * @param id 数据权限标识
	 * @return 数据权限对象
	 */
	DataPurviewDTO getDataPurviewById(Long id);

	/**
	 * 根据条件获取数据权限列表
	 * @param condition 查询条件
	 * @return 数据权限列表
	 */
	List<DataPurviewDTO> getDataPurviewList(Map<String, Object> condition);

	/**
	 * 保存数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 新增成功条数
	 */
	long saveDataPurview(DataPurviewDTO dataPurviewDTO);

	/**
	 * 更新数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 更新成功条数
	 */
	long updateDataPurview(DataPurviewDTO dataPurviewDTO);

	/**
	 * 根据数据权限标识删除数据权限
	 * @param id 数据权限标识
	 * @return 删除成功条数
	 */
	long deleteDataPurviewById(Long id);

	/**
	 * 批量保存数据权限
	 * @param  dataPurviewList 数据权限数据集合
	 * @return 新增成功条数
	 */
	long batchSaveDataPurview(List<DataPurviewDTO> dataPurviewList);

	/**
	 * 根据权限对象标识删除数据权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	long deleteDataPurviewBySecId(String secId);
}
