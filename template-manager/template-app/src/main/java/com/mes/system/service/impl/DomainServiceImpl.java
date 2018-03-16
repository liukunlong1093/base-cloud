package com.mes.system.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.core.utils.StringUtils;
import com.mes.system.dto.DomainDTO;
import com.mes.system.dto.DomainUserRelDTO;
import com.mes.system.manager.DomainManager;
import com.mes.system.manager.DomainUserRelManager;
import com.mes.system.service.DomainService;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.impl]    
  * 类名称:		[DomainServiceImpl]  
  * 类描述:		[群组业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("domainService")
public class DomainServiceImpl implements DomainService {
	@Autowired
	private DomainManager domainManager;
	
	@Autowired
	private DomainUserRelManager domainUserRelManager;
	
	/**
	 * 根据群组标识获取群组
	 * @param id 群组标识
	 * @return 群组对象
	 */
	@Override
	public DomainDTO getDomainById(Long id){
		DomainDTO domainDTO = domainManager.getDomainById(id);
		return domainDTO;
	}
	

	/**
	 * 根据条件获取群组列表
	 * @param condition 查询条件
	 * @return 群组列表
	 */
	@Override
	public List<DomainDTO> getDomainList(Map<String, Object> condition){
		List<DomainDTO> domainList = domainManager.getDomainList(condition);
		return domainList;
	}

	/**
	 * 保存群组
	 * @param domainDTO 群组对象
	 * @return 新增后的群组对象
	 */
	@Override
	public DomainDTO saveDomain(DomainDTO domainDTO){
	    domainDTO.setCreateTime(new Date());
		domainManager.saveDomain(domainDTO);
		return domainDTO;
	}
	
	/**
	 * 更新群组
	 * @param domainDTO 群组对象
	 * @return 更新后的群组对象
	 */
	@Override
	public DomainDTO updateDomain(DomainDTO domainDTO){
		domainDTO.setUpdateTime(new Date());
		domainManager.updateDomain(domainDTO);
		return domainDTO;
	}


	/**
	 * 根据群组标识删除群组
	 * @param id 群组标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteDomainById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				domainManager.deleteDomainById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存群组
	 * @param  domainList 群组数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveDomain(List<DomainDTO> domainList){
		long result = 0;
		result = domainManager.batchSaveDomain(domainList);
		return result;
	}

	/**
	 * 根据群组用户成员标识获取群组用户成员
	 * @param id 群组用户成员标识
	 * @return 群组用户成员对象
	 */
	@Override
	public DomainUserRelDTO getDomainUserRelById(Long id){
		DomainUserRelDTO domainUserRelDTO = domainUserRelManager.getDomainUserRelById(id);
		return domainUserRelDTO;
	}
	

	/**
	 * 根据条件获取群组用户成员列表
	 * @param condition 查询条件
	 * @return 群组用户成员列表
	 */
	@Override
	public List<DomainUserRelDTO> getDomainUserRelList(Map<String, Object> condition){
		List<DomainUserRelDTO> domainUserRelList = domainUserRelManager.getDomainUserRelList(condition);
		return domainUserRelList;
	}

	/**
	 * 保存群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 新增后的群组用户成员对象
	 */
	@Override
	public DomainUserRelDTO saveDomainUserRel(DomainUserRelDTO domainUserRelDTO){
	    domainUserRelDTO.setCreateTime(new Date());
		domainUserRelManager.saveDomainUserRel(domainUserRelDTO);
		return domainUserRelDTO;
	}
	
	/**
	 * 更新群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 更新后的群组用户成员对象
	 */
	@Override
	public DomainUserRelDTO updateDomainUserRel(DomainUserRelDTO domainUserRelDTO){
		domainUserRelDTO.setUpdateTime(new Date());
		domainUserRelManager.updateDomainUserRel(domainUserRelDTO);
		return domainUserRelDTO;
	}


	/**
	 * 根据群组用户成员标识删除群组用户成员
	 * @param id 群组用户成员标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteDomainUserRelById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				domainUserRelManager.deleteDomainUserRelById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存群组用户成员
	 * @param  domainUserRelList 群组用户成员数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveDomainUserRel(List<DomainUserRelDTO> domainUserRelList){
		long result = 0;
		result = domainUserRelManager.batchSaveDomainUserRel(domainUserRelList);
		return result;
	}

	

}