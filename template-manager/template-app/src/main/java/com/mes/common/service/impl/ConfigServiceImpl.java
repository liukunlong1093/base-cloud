package com.mes.common.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.common.dto.ConfigDTO;
import com.mes.common.manager.ConfigManager;
import com.mes.common.service.ConfigService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service.impl]    
  * 类名称:		[ConfigServiceImpl]  
  * 类描述:		[配置业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private ConfigManager configManager;
	
	/**
	 * 根据配置标识获取配置
	 * @param id 配置标识
	 * @return 配置对象
	 */
	@Override
	public ConfigDTO getConfigById(Long id){
		ConfigDTO configDTO = configManager.getConfigById(id);
		return configDTO;
	}
	

	/**
	 * 根据条件获取配置列表
	 * @param condition 查询条件
	 * @return 配置列表
	 */
	@Override
	public List<ConfigDTO> getConfigList(Map<String, Object> condition){
		List<ConfigDTO> configList = configManager.getConfigList(condition);
		return configList;
	}

	/**
	 * 保存配置
	 * @param configDTO 配置对象
	 * @return 新增后的配置对象
	 */
	@Override
	public ConfigDTO saveConfig(ConfigDTO configDTO){
	    configDTO.setCreateTime(new Date());
		configManager.saveConfig(configDTO);
		return configDTO;
	}
	
	/**
	 * 更新配置
	 * @param configDTO 配置对象
	 * @return 更新后的配置对象
	 */
	@Override
	public ConfigDTO updateConfig(ConfigDTO configDTO){
		configDTO.setUpdateTime(new Date());
		configManager.updateConfig(configDTO);
		return configDTO;
	}


	/**
	 * 根据配置标识删除配置
	 * @param id 配置标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteConfigById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				configManager.deleteConfigById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存配置
	 * @param  configList 配置数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveConfig(List<ConfigDTO> configList){
		long result = 0;
		result = configManager.batchSaveConfig(configList);
		return result;
	}

	

}