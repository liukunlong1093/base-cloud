package com.mes.common.manager;
import java.util.*;
import com.mes.common.dto.ConfigDTO;
 /**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.manager]    
  * 类名称:		[ConfigManager]  
  * 类描述:		[配置管理处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface ConfigManager {
	/**
	 * 根据配置标识获取配置
	 * @param id 配置标识
	 * @return 配置对象
	 */
	 ConfigDTO getConfigById(Long id);

	/**
	 * 根据条件获取配置列表
	 * @param condition 查询条件
	 * @return 配置列表
	 */
	 List<ConfigDTO> getConfigList(Map<String, Object> condition);

	/**
	 * 保存配置
	 * @param configDTO 配置对象
	 * @return 新增成功条数
	 */
	 long saveConfig(ConfigDTO configDTO);

	/**
	 * 更新配置
	 * @param configDTO 配置对象
	 * @return 更新成功条数
	 */
	 long updateConfig(ConfigDTO configDTO);

	/**
	 * 根据配置标识删除配置
	 * @param id 配置标识
	 * @return 删除成功条数
	 */
	 long  deleteConfigById(Long id);

	/**
	 * 批量保存配置
	 * @param  configList 配置数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveConfig(List<ConfigDTO> configList);
}
