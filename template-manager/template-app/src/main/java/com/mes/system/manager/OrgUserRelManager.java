package com.mes.system.manager;

import java.util.*;
import com.mes.system.dto.OrgUserRelDTO;

/**
 * 项目名称:	[info-app]
 * 包:	        [com.mes.system.manager]    
 * 类名称:		[OrgUserRelManager]  
 * 类描述:		[组织用户管理处理接口]
 * 创建人:		[刘坤龙]   
 * 创建时间:	[2017年8月18日 上午11:45:34]   
 * 修改人:		[刘坤龙]   
 * 修改时间:	[2017年8月18日 上午11:45:34]   
 * 修改备注:	[说明本次修改内容]  
 * 版本:		[v1.0]
*/
public interface OrgUserRelManager {
	/**
	 * 根据组织用户标识获取组织用户
	 * @param id 组织用户标识
	 * @return 组织用户对象
	 */
	OrgUserRelDTO getOrgUserRelById(Long id);

	/**
	 * 根据条件获取组织用户列表
	 * @param condition 查询条件
	 * @return 组织用户列表
	 */
	List<OrgUserRelDTO> getOrgUserRelList(Map<String, Object> condition);

	/**
	 * 保存组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 新增成功条数
	 */
	long saveOrgUserRel(OrgUserRelDTO orgUserRelDTO);

	/**
	 * 更新组织用户
	 * @param orgUserRelDTO 组织用户对象
	 * @return 更新成功条数
	 */
	long updateOrgUserRel(OrgUserRelDTO orgUserRelDTO);

	/**
	 * 根据组织用户标识删除组织用户
	 * @param id 组织用户标识
	 * @return 删除成功条数
	 */
	long deleteOrgUserRelById(Long id);

	/**
	 * 批量保存组织用户
	 * @param  orgUserRelList 组织用户数据集合
	 * @return 新增成功条数
	 */
	long batchSaveOrgUserRel(List<OrgUserRelDTO> orgUserRelList);
}
