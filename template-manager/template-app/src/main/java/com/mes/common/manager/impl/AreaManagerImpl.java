package com.mes.common.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.common.dao.AreaMapper;
import com.mes.common.dto.AreaDTO;
import com.mes.common.manager.AreaManager;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.manager.impl]    
  * 类名称:		[AreaManagerImpl]  
  * 类描述:		[区域管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("areaManager")
public class AreaManagerImpl implements AreaManager {
	@Autowired
	private AreaMapper areaMapper;


	/**
	 * 根据区域标识获取区域
	 * @param id 区域标识
	 * @return 区域对象
	 */
	@Override
	public AreaDTO getAreaById(Long id){
		return areaMapper.getAreaById(id);
	}

	/**
	 * 根据条件获取区域列表
	 * @param condition 查询条件
	 * @return 区域列表
	 */
	@Override
	public List<AreaDTO> getAreaList(Map<String, Object> condition){
		return areaMapper.getAreaList(condition);
	}

	/**
	 * 保存区域
	 * @param areaDTO 区域对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveArea(AreaDTO areaDTO){
		return areaMapper.saveArea(areaDTO);
	}

	/**
	 * 更新区域
	 * @param areaDTO 区域对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateArea(AreaDTO areaDTO){
		return areaMapper.updateArea(areaDTO);
	}

	/**
	 * 根据区域标识删除区域
	 * @param id 区域标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteAreaById(Long id){
		return areaMapper.deleteAreaById(id);
	}

	/**
	 * 批量保存区域
	 * @param  areaList 区域数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveArea(List<AreaDTO> areaList){
		return areaMapper.batchSaveArea(areaList);
	}
}
