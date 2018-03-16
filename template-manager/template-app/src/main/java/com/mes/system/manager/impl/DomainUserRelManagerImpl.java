package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.DomainUserRelManager;
import com.mes.system.dao.DomainUserRelMapper;
import com.mes.system.dto.DomainUserRelDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[DomainUserRelManagerImpl]  
  * 类描述:		[群组用户成员管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("domainUserRelManager")
public class DomainUserRelManagerImpl implements DomainUserRelManager {
	@Autowired
	private DomainUserRelMapper domainUserRelMapper;


	/**
	 * 根据群组用户成员标识获取群组用户成员
	 * @param id 群组用户成员标识
	 * @return 群组用户成员对象
	 */
	@Override
	public DomainUserRelDTO getDomainUserRelById(Long id){
		return domainUserRelMapper.getDomainUserRelById(id);
	}

	/**
	 * 根据条件获取群组用户成员列表
	 * @param condition 查询条件
	 * @return 群组用户成员列表
	 */
	@Override
	public List<DomainUserRelDTO> getDomainUserRelList(Map<String, Object> condition){
		return domainUserRelMapper.getDomainUserRelList(condition);
	}

	/**
	 * 保存群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveDomainUserRel(DomainUserRelDTO domainUserRelDTO){
		return domainUserRelMapper.saveDomainUserRel(domainUserRelDTO);
	}

	/**
	 * 更新群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateDomainUserRel(DomainUserRelDTO domainUserRelDTO){
		return domainUserRelMapper.updateDomainUserRel(domainUserRelDTO);
	}

	/**
	 * 根据群组用户成员标识删除群组用户成员
	 * @param id 群组用户成员标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteDomainUserRelById(Long id){
		return domainUserRelMapper.deleteDomainUserRelById(id);
	}

	/**
	 * 批量保存群组用户成员
	 * @param  domainUserRelList 群组用户成员数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveDomainUserRel(List<DomainUserRelDTO> domainUserRelList){
		return domainUserRelMapper.batchSaveDomainUserRel(domainUserRelList);
	}
}
