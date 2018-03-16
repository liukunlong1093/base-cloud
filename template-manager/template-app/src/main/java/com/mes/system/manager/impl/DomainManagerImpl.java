package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.DomainManager;
import com.mes.system.dao.DomainMapper;
import com.mes.system.dto.DomainDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[DomainManagerImpl]  
  * 类描述:		[群组管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("domainManager")
public class DomainManagerImpl implements DomainManager {
	@Autowired
	private DomainMapper domainMapper;


	/**
	 * 根据群组标识获取群组
	 * @param id 群组标识
	 * @return 群组对象
	 */
	@Override
	public DomainDTO getDomainById(Long id){
		return domainMapper.getDomainById(id);
	}

	/**
	 * 根据条件获取群组列表
	 * @param condition 查询条件
	 * @return 群组列表
	 */
	@Override
	public List<DomainDTO> getDomainList(Map<String, Object> condition){
		return domainMapper.getDomainList(condition);
	}

	/**
	 * 保存群组
	 * @param domainDTO 群组对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveDomain(DomainDTO domainDTO){
		return domainMapper.saveDomain(domainDTO);
	}

	/**
	 * 更新群组
	 * @param domainDTO 群组对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateDomain(DomainDTO domainDTO){
		return domainMapper.updateDomain(domainDTO);
	}

	/**
	 * 根据群组标识删除群组
	 * @param id 群组标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteDomainById(Long id){
		return domainMapper.deleteDomainById(id);
	}

	/**
	 * 批量保存群组
	 * @param  domainList 群组数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveDomain(List<DomainDTO> domainList){
		return domainMapper.batchSaveDomain(domainList);
	}
}
