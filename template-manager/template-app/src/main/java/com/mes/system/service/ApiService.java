package com.mes.system.service;

import java.util.*;
import com.mes.system.dto.ApiDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[ApiService]  
  * 类描述:		[应用程序接口业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface ApiService {
	/**
	 * 根据应用程序接口标识获取应用程序接口
	 * @param id 应用程序接口标识
	 * @return 应用程序接口对象
	 */
	 ApiDTO getApiById(Long id);
	

	/**
	 * 根据条件获取应用程序接口列表
	 * @param condition 查询条件
	 * @return 应用程序接口列表
	 */
	 List<ApiDTO> getApiList(Map<String, Object> condition);

	/**
	 * 保存应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 新增后的应用程序接口对象
	 */
	 ApiDTO saveApi(ApiDTO apiDTO);
	
	/**
	 * 更新应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 更新后的应用程序接口对象
	 */
	 ApiDTO updateApi(ApiDTO apiDTO);


	/**
	 * 根据应用程序接口标识删除应用程序接口
	 * @param id 应用程序接口标识
	 * @return 删除成功条数
	 */
	 long  deleteApiById(String id);
	

	/**
	 * 批量保存应用程序接口
	 * @param  apiList 应用程序接口数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveApi(List<ApiDTO> apiList);
}
