package com.mes.system.manager;
import java.util.*;
import com.mes.system.dto.DomainUserRelDTO;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager]    
  * 类名称:		[DomainUserRelManager]  
  * 类描述:		[群组用户成员管理处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface DomainUserRelManager {
	/**
	 * 根据群组用户成员标识获取群组用户成员
	 * @param id 群组用户成员标识
	 * @return 群组用户成员对象
	 */
	 DomainUserRelDTO getDomainUserRelById(Long id);

	/**
	 * 根据条件获取群组用户成员列表
	 * @param condition 查询条件
	 * @return 群组用户成员列表
	 */
	 List<DomainUserRelDTO> getDomainUserRelList(Map<String, Object> condition);

	/**
	 * 保存群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 新增成功条数
	 */
	 long saveDomainUserRel(DomainUserRelDTO domainUserRelDTO);

	/**
	 * 更新群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 更新成功条数
	 */
	 long updateDomainUserRel(DomainUserRelDTO domainUserRelDTO);

	/**
	 * 根据群组用户成员标识删除群组用户成员
	 * @param id 群组用户成员标识
	 * @return 删除成功条数
	 */
	 long  deleteDomainUserRelById(Long id);

	/**
	 * 批量保存群组用户成员
	 * @param  domainUserRelList 群组用户成员数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveDomainUserRel(List<DomainUserRelDTO> domainUserRelList);
}
