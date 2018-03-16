package com.mes.system.manager;

import java.util.*;
import com.mes.system.dto.OrgDTO;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.manager]    
 * 类名称:		[OrgManager]  
 * 类描述:		[组织机构管理处理接口]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月18日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月18日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
public interface OrgManager {
	/**
	 * 根据组织机构标识获取组织机构
	 * @param id 组织机构标识
	 * @return 组织机构对象
	 */
	OrgDTO getOrgById(Long id);

	/**
	 * 根据条件获取组织机构列表
	 * @param condition 查询条件
	 * @return 组织机构列表
	 */
	List<OrgDTO> getOrgList(Map<String, Object> condition);

	/**
	 * 保存组织机构
	 * @param orgDTO 组织机构对象
	 * @return 新增成功条数
	 */
	long saveOrg(OrgDTO orgDTO);

	/**
	 * 更新组织机构
	 * @param orgDTO 组织机构对象
	 * @return 更新成功条数
	 */
	long updateOrg(OrgDTO orgDTO);

	/**
	 * 根据组织机构标识删除组织机构
	 * @param id 组织机构标识
	 * @return 删除成功条数
	 */
	long deleteOrgById(Long id);

	/**
	 * 批量保存组织机构
	 * @param  orgList 组织机构数据集合
	 * @return 新增成功条数
	 */
	long batchSaveOrg(List<OrgDTO> orgList);
}
