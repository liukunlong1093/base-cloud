package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.OrgManager;
import com.mes.system.dao.OrgMapper;
import com.mes.system.dto.OrgDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[OrgManagerImpl]  
  * 类描述:		[组织机构管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("orgManager")
public class OrgManagerImpl implements OrgManager {
	@Autowired
	private OrgMapper orgMapper;


	/**
	 * 根据组织机构标识获取组织机构
	 * @param id 组织机构标识
	 * @return 组织机构对象
	 */
	@Override
	public OrgDTO getOrgById(Long id){
		return orgMapper.getOrgById(id);
	}

	/**
	 * 根据条件获取组织机构列表
	 * @param condition 查询条件
	 * @return 组织机构列表
	 */
	@Override
	public List<OrgDTO> getOrgList(Map<String, Object> condition){
		return orgMapper.getOrgList(condition);
	}

	/**
	 * 保存组织机构
	 * @param orgDTO 组织机构对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveOrg(OrgDTO orgDTO){
		return orgMapper.saveOrg(orgDTO);
	}

	/**
	 * 更新组织机构
	 * @param orgDTO 组织机构对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateOrg(OrgDTO orgDTO){
		return orgMapper.updateOrg(orgDTO);
	}

	/**
	 * 根据组织机构标识删除组织机构
	 * @param id 组织机构标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteOrgById(Long id){
		return orgMapper.deleteOrgById(id);
	}

	/**
	 * 批量保存组织机构
	 * @param  orgList 组织机构数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveOrg(List<OrgDTO> orgList){
		return orgMapper.batchSaveOrg(orgList);
	}
}
