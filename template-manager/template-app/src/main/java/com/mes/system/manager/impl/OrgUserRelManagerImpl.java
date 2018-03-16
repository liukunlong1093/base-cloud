package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.OrgUserRelManager;
import com.mes.system.dao.OrgUserRelMapper;
import com.mes.system.dto.OrgUserRelDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[OrgUserRelManagerImpl]  
  * 类描述:		[组织用户管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月18日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月18日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("orgUserRelManager")
public class OrgUserRelManagerImpl implements OrgUserRelManager {
	@Autowired
	private OrgUserRelMapper orgUserRelMapper;


	/**
	 * 根据组织用户标识获取组织用户
	 * @param id 组织用户标识
	 * @return 组织用户对象
	 */
	@Override
	public OrgUserRelDTO getOrgUserRelById(Long id){
		return orgUserRelMapper.getOrgUserRelById(id);
	}

	/**
	 * 根据条件获取组织用户列表
	 * @param condition 查询条件
	 * @return 组织用户列表
	 */
	@Override
	public List<OrgUserRelDTO> getOrgUserRelList(Map<String, Object> condition){
		return orgUserRelMapper.getOrgUserRelList(condition);
	}

	/**
	 * 保存组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveOrgUserRel(OrgUserRelDTO orgUserRelDTO){
		return orgUserRelMapper.saveOrgUserRel(orgUserRelDTO);
	}

	/**
	 * 更新组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateOrgUserRel(OrgUserRelDTO orgUserRelDTO){
		return orgUserRelMapper.updateOrgUserRel(orgUserRelDTO);
	}

	/**
	 * 根据组织用户标识删除组织用户
	 * @param id 组织用户标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteOrgUserRelById(Long id){
		return orgUserRelMapper.deleteOrgUserRelById(id);
	}

	/**
	 * 批量保存组织用户
	 * @param  orgUserRelList 组织用户数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveOrgUserRel(List<OrgUserRelDTO> orgUserRelList){
		return orgUserRelMapper.batchSaveOrgUserRel(orgUserRelList);
	}
}
