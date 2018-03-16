package com.mes.common.service;

import java.util.*;
import com.mes.common.dto.AreaDTO;
/**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.service]    
  * 类名称:		[AreaService]  
  * 类描述:		[区域业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface AreaService {
	/**
	 * 根据区域标识获取区域
	 * @param id 区域标识
	 * @return 区域对象
	 */
	 AreaDTO getAreaById(Long id);
	

	/**
	 * 根据条件获取区域列表
	 * @param condition 查询条件
	 * @return 区域列表
	 */
	 List<AreaDTO> getAreaList(Map<String, Object> condition);

	/**
	 * 保存区域
	 * @param areaDTO 区域对象
	 * @return 新增后的区域对象
	 */
	 AreaDTO saveArea(AreaDTO areaDTO);
	
	/**
	 * 更新区域
	 * @param areaDTO 区域对象
	 * @return 更新后的区域对象
	 */
	 AreaDTO updateArea(AreaDTO areaDTO);


	/**
	 * 根据区域标识删除区域
	 * @param id 区域标识
	 * @return 删除成功条数
	 */
	 long  deleteAreaById(String id);
	

	/**
	 * 批量保存区域
	 * @param  areaList 区域数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveArea(List<AreaDTO> areaList);
}
