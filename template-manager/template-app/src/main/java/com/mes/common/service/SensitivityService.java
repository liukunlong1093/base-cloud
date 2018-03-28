package com.mes.common.service;

import java.util.*;
import com.mes.common.dto.SensitivityDTO;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service]    
  * 类名称:		[SensitivityService]  
  * 类描述:		[敏感词业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface SensitivityService {
	/**
	 * 根据敏感词标识获取敏感词
	 * @param id 敏感词标识
	 * @return 敏感词对象
	 */
	 SensitivityDTO getSensitivityById(Long id);
	

	/**
	 * 根据条件获取敏感词列表
	 * @param condition 查询条件
	 * @return 敏感词列表
	 */
	 List<SensitivityDTO> getSensitivityList(Map<String, Object> condition);

	/**
	 * 保存敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 新增后的敏感词对象
	 */
	 SensitivityDTO saveSensitivity(SensitivityDTO sensitivityDTO);
	
	/**
	 * 更新敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 更新后的敏感词对象
	 */
	 SensitivityDTO updateSensitivity(SensitivityDTO sensitivityDTO);


	/**
	 * 根据敏感词标识删除敏感词
	 * @param id 敏感词标识
	 * @return 删除成功条数
	 */
	 long  deleteSensitivityById(String id);
	

	/**
	 * 批量保存敏感词
	 * @param  sensitivityList 敏感词数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveSensitivity(List<SensitivityDTO> sensitivityList);
}
