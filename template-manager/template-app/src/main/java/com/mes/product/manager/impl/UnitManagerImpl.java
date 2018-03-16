package com.mes.product.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.product.manager.UnitManager;
import com.mes.product.dao.UnitMapper;
import com.mes.product.dto.UnitDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.product.manager.impl]    
  * 类名称:		[UnitManagerImpl]  
  * 类描述:		[包装单位管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月03日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月03日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("unitManager")
public class UnitManagerImpl implements UnitManager {
	@Autowired
	private UnitMapper unitMapper;


	/**
	 * 根据包装单位标识获取包装单位
	 * @param id 包装单位标识
	 * @return 包装单位对象
	 */
	@Override
	public <T>UnitDTO getUnitById(T id){
		return unitMapper.getUnitById(id);
	}

	/**
	 * 根据条件获取包装单位列表
	 * @param condition 查询条件
	 * @return 包装单位列表
	 */
	@Override
	public List<UnitDTO> getUnitList(Map<String, Object> condition){
		return unitMapper.getUnitList(condition);
	}

	/**
	 * 保存包装单位
	 * @param unitDTO 包装单位对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveUnit(UnitDTO unitDTO){
		return unitMapper.saveUnit(unitDTO);
	}

	/**
	 * 更新包装单位
	 * @param unitDTO 包装单位对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateUnit(UnitDTO unitDTO){
		return unitMapper.updateUnit(unitDTO);
	}

	/**
	 * 根据标识删除包装单位
	 * @param id 包装单位标识
	 * @return 删除成功条数
	 */
	@Override
	public <T> long  deleteUnitById(T id){
		return unitMapper.deleteUnitById(id);
	}

	/**
	 * 批量保存包装单位
	 * @param  unitList 包装单位数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveUnit(List<UnitDTO> unitList){
		return unitMapper.batchSaveUnit(unitList);
	}
}
