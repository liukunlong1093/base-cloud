package com.mes.product.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.product.dto.UnitDTO;
import com.mes.product.manager.UnitManager;
import com.mes.product.service.UnitService;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.product.service.impl]    
  * 类名称:		[UnitServiceImpl]  
  * 类描述:		[包装单位业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月03日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月03日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("unitService")
public class UnitServiceImpl implements UnitService {
	@Autowired
	private UnitManager unitManager;
	
	/**
	 * 根据包装单位标识获取包装单位
	 * @param id 包装单位标识
	 * @return 包装单位对象
	 */
	@Override
	public <T>UnitDTO getUnitById(T id){
		UnitDTO unitDTO = unitManager.getUnitById(id);
		return unitDTO;
	}
	

	/**
	 * 根据条件获取包装单位列表
	 * @param condition 查询条件
	 * @return 包装单位列表
	 */
	@Override
	public List<UnitDTO> getUnitList(Map<String, Object> condition){
		List<UnitDTO> unitList = unitManager.getUnitList(condition);
		return unitList;
	}

	/**
	 * 保存包装单位
	 * @param unitDTO 包装单位对象
	 * @return 新增后的包装单位对象
	 */
	@Override
	public UnitDTO saveUnit(UnitDTO unitDTO){
		unitManager.saveUnit(unitDTO);
		return unitDTO;
	}
	
	/**
	 * 更新包装单位
	 * @param unitDTO 包装单位对象
	 * @return 更新后的包装单位对象
	 */
	@Override
	public UnitDTO updateUnit(UnitDTO unitDTO){
		unitManager.updateUnit(unitDTO);
		return unitDTO;
	}


	/**
	 * 根据标识删除包装单位
	 * @param id 包装单位标识
	 * @return 删除成功条数
	 */
	@Override
	public <T> long  deleteUnitById(T id){
		long result = 0;
		result = unitManager.deleteUnitById(id);
		return result;
	}
	
	
	/**
	 * 根据标识删除多条包装单位
	 * @param ids 包装单位标识数组
	 * @return 删除成功条数
	 */
	@Override
	public <T> long  deleteUnitByIds(T[] ids){
		long result = 0;
		if (ids != null && ids.length > 0) {
			for (T id : ids) {
				unitManager.deleteUnitById(id);
			}
		}
		return result;
	}

	

	/**
	 * 批量保存包装单位
	 * @param  unitList 包装单位数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveUnit(List<UnitDTO> unitList){
		long result = 0;
		result = unitManager.batchSaveUnit(unitList);
		return result;
	}

	

}