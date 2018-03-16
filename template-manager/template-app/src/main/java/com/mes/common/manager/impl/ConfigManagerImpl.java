package com.mes.common.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.common.dao.ConfigMapper;
import com.mes.common.dto.ConfigDTO;
import com.mes.common.manager.ConfigManager;
/**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.manager.impl]    
  * 类名称:		[ConfigManagerImpl]  
  * 类描述:		[配置管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("configManager")
public class ConfigManagerImpl implements ConfigManager {
	@Autowired
	private ConfigMapper configMapper;


	/**
	 * 根据配置标识获取配置
	 * @param id 配置标识
	 * @return 配置对象
	 */
	@Override
	public ConfigDTO getConfigById(Long id){
		return configMapper.getConfigById(id);
	}

	/**
	 * 根据条件获取配置列表
	 * @param condition 查询条件
	 * @return 配置列表
	 */
	@Override
	public List<ConfigDTO> getConfigList(Map<String, Object> condition){
		return configMapper.getConfigList(condition);
	}

	/**
	 * 保存配置
	 * @param configDTO 配置对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveConfig(ConfigDTO configDTO){
		return configMapper.saveConfig(configDTO);
	}

	/**
	 * 更新配置
	 * @param configDTO 配置对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateConfig(ConfigDTO configDTO){
		return configMapper.updateConfig(configDTO);
	}

	/**
	 * 根据配置标识删除配置
	 * @param id 配置标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteConfigById(Long id){
		return configMapper.deleteConfigById(id);
	}

	/**
	 * 批量保存配置
	 * @param  configList 配置数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveConfig(List<ConfigDTO> configList){
		return configMapper.batchSaveConfig(configList);
	}
}
