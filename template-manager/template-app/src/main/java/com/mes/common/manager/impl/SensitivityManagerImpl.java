package com.mes.common.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.common.manager.SensitivityManager;
import com.mes.common.dao.SensitivityMapper;
import com.mes.common.dto.SensitivityDTO;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.manager.impl]    
  * 类名称:		[SensitivityManagerImpl]  
  * 类描述:		[敏感词管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("sensitivityManager")
public class SensitivityManagerImpl implements SensitivityManager {
	@Autowired
	private SensitivityMapper sensitivityMapper;


	/**
	 * 根据敏感词标识获取敏感词
	 * @param id 敏感词标识
	 * @return 敏感词对象
	 */
	@Override
	public SensitivityDTO getSensitivityById(Long id){
		return sensitivityMapper.getSensitivityById(id);
	}

	/**
	 * 根据条件获取敏感词列表
	 * @param condition 查询条件
	 * @return 敏感词列表
	 */
	@Override
	public List<SensitivityDTO> getSensitivityList(Map<String, Object> condition){
		return sensitivityMapper.getSensitivityList(condition);
	}

	/**
	 * 保存敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveSensitivity(SensitivityDTO sensitivityDTO){
		return sensitivityMapper.saveSensitivity(sensitivityDTO);
	}

	/**
	 * 更新敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateSensitivity(SensitivityDTO sensitivityDTO){
		return sensitivityMapper.updateSensitivity(sensitivityDTO);
	}

	/**
	 * 根据敏感词标识删除敏感词
	 * @param id 敏感词标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteSensitivityById(Long id){
		return sensitivityMapper.deleteSensitivityById(id);
	}

	/**
	 * 批量保存敏感词
	 * @param  sensitivityList 敏感词数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveSensitivity(List<SensitivityDTO> sensitivityList){
		return sensitivityMapper.batchSaveSensitivity(sensitivityList);
	}
}
