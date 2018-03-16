package com.mes.product.service;

import java.util.*;
import com.mes.product.dto.UnitDTO;

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
public interface UnitService {
	/**
	 * 根据包装单位标识获取包装单位
	 * @param id 包装单位标识
	 * @return 包装单位对象
	 */
	public <T> UnitDTO getUnitById(T id);

	/**
	 * 根据条件获取包装单位列表
	 * @param condition 查询条件
	 * @return 包装单位列表
	 */
	public List<UnitDTO> getUnitList(Map<String, Object> condition);

	/**
	 * 保存包装单位
	 * @param unitDTO 包装单位对象
	 * @return 新增后的包装单位对象
	 */
	public UnitDTO saveUnit(UnitDTO unitDTO);

	/**
	 * 更新包装单位
	 * @param unitDTO 包装单位对象
	 * @return 更新后的包装单位对象
	 */
	public UnitDTO updateUnit(UnitDTO unitDTO);

	/**
	 * 根据标识删除包装单位
	 * @param id 包装单位标识
	 * @return 删除成功条数
	 */
	public <T> long deleteUnitById(T id);

	/**
	 * 根据标识删除多条包装单位
	 * @param ids 包装单位标识数组
	 * @return 删除成功条数
	 */
	public <T> long deleteUnitByIds(T[] ids);

	/**
	 * 批量保存包装单位
	 * @param  unitList 包装单位数据集合
	 * @return 新增成功条数
	 */
	public long batchSaveUnit(List<UnitDTO> unitList);
}
