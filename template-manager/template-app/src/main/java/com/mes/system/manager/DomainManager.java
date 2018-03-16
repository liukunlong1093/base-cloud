package com.mes.system.manager;
import java.util.*;
import com.mes.system.dto.DomainDTO;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager]    
  * 类名称:		[DomainManager]  
  * 类描述:		[群组管理处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface DomainManager {
	/**
	 * 根据群组标识获取群组
	 * @param id 群组标识
	 * @return 群组对象
	 */
	 DomainDTO getDomainById(Long id);

	/**
	 * 根据条件获取群组列表
	 * @param condition 查询条件
	 * @return 群组列表
	 */
	 List<DomainDTO> getDomainList(Map<String, Object> condition);

	/**
	 * 保存群组
	 * @param domainDTO 群组对象
	 * @return 新增成功条数
	 */
	 long saveDomain(DomainDTO domainDTO);

	/**
	 * 更新群组
	 * @param domainDTO 群组对象
	 * @return 更新成功条数
	 */
	 long updateDomain(DomainDTO domainDTO);

	/**
	 * 根据群组标识删除群组
	 * @param id 群组标识
	 * @return 删除成功条数
	 */
	 long  deleteDomainById(Long id);

	/**
	 * 批量保存群组
	 * @param  domainList 群组数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveDomain(List<DomainDTO> domainList);
}
