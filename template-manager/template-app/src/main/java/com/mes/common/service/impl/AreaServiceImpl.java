package com.mes.common.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.common.dto.AreaDTO;
import com.mes.common.manager.AreaManager;
import com.mes.common.service.AreaService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.service.impl]    
  * 类名称:		[AreaServiceImpl]  
  * 类描述:		[区域业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaManager areaManager;
	
	/**
	 * 根据区域标识获取区域
	 * @param id 区域标识
	 * @return 区域对象
	 */
	@Override
	public AreaDTO getAreaById(Long id){
		AreaDTO areaDTO = areaManager.getAreaById(id);
		return areaDTO;
	}
	

	/**
	 * 根据条件获取区域列表
	 * @param condition 查询条件
	 * @return 区域列表
	 */
	@Override
	public List<AreaDTO> getAreaList(Map<String, Object> condition){
		List<AreaDTO> areaList = areaManager.getAreaList(condition);
		return areaList;
	}

	/**
	 * 保存区域
	 * @param areaDTO 区域对象
	 * @return 新增后的区域对象
	 */
	@Override
	public AreaDTO saveArea(AreaDTO areaDTO){
	    areaDTO.setCreateTime(new Date());
		areaManager.saveArea(areaDTO);
		return areaDTO;
	}
	
	/**
	 * 更新区域
	 * @param areaDTO 区域对象
	 * @return 更新后的区域对象
	 */
	@Override
	public AreaDTO updateArea(AreaDTO areaDTO){
		areaDTO.setUpdateTime(new Date());
		areaManager.updateArea(areaDTO);
		return areaDTO;
	}


	/**
	 * 根据区域标识删除区域
	 * @param id 区域标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteAreaById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				areaManager.deleteAreaById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存区域
	 * @param  areaList 区域数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveArea(List<AreaDTO> areaList){
		long result = 0;
		result = areaManager.batchSaveArea(areaList);
		return result;
	}

	

}