package com.mes.system.service;

import java.util.List;
import java.util.Map;

import com.mes.system.dto.DomainDTO;
import com.mes.system.dto.DomainUserRelDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[DomainService]  
  * 类描述:		[群组业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface DomainService {
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
	 * @return 新增后的群组对象
	 */
	 DomainDTO saveDomain(DomainDTO domainDTO);
	
	/**
	 * 更新群组
	 * @param domainDTO 群组对象
	 * @return 更新后的群组对象
	 */
	 DomainDTO updateDomain(DomainDTO domainDTO);


	/**
	 * 根据群组标识删除群组
	 * @param id 群组标识
	 * @return 删除成功条数
	 */
	 long  deleteDomainById(String id);
	

	/**
	 * 批量保存群组
	 * @param  domainList 群组数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveDomain(List<DomainDTO> domainList);
	 
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
		 * @return 新增后的群组用户成员对象
		 */
		 DomainUserRelDTO saveDomainUserRel(DomainUserRelDTO domainUserRelDTO);
		
		/**
		 * 更新群组用户成员
		 * @param domainUserRelDTO 群组用户成员对象
		 * @return 更新后的群组用户成员对象
		 */
		 DomainUserRelDTO updateDomainUserRel(DomainUserRelDTO domainUserRelDTO);


		/**
		 * 根据群组用户成员标识删除群组用户成员
		 * @param id 群组用户成员标识
		 * @return 删除成功条数
		 */
		 long  deleteDomainUserRelById(String id);
		

		/**
		 * 批量保存群组用户成员
		 * @param  domainUserRelList 群组用户成员数据集合
		 * @return 新增成功条数
		 */
		 long batchSaveDomainUserRel(List<DomainUserRelDTO> domainUserRelList);
}
