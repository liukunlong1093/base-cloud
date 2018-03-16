package com.mes.system.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.manager.ApiManager;
import com.mes.system.dao.ApiMapper;
import com.mes.system.dto.ApiDTO;
/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.manager.impl]    
  * 类名称:		[ApiManagerImpl]  
  * 类描述:		[应用程序接口管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("apiManager")
public class ApiManagerImpl implements ApiManager {
	@Autowired
	private ApiMapper apiMapper;


	/**
	 * 根据应用程序接口标识获取应用程序接口
	 * @param id 应用程序接口标识
	 * @return 应用程序接口对象
	 */
	@Override
	public ApiDTO getApiById(Long id){
		return apiMapper.getApiById(id);
	}

	/**
	 * 根据条件获取应用程序接口列表
	 * @param condition 查询条件
	 * @return 应用程序接口列表
	 */
	@Override
	public List<ApiDTO> getApiList(Map<String, Object> condition){
		return apiMapper.getApiList(condition);
	}

	/**
	 * 保存应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveApi(ApiDTO apiDTO){
		return apiMapper.saveApi(apiDTO);
	}

	/**
	 * 更新应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateApi(ApiDTO apiDTO){
		return apiMapper.updateApi(apiDTO);
	}

	/**
	 * 根据应用程序接口标识删除应用程序接口
	 * @param id 应用程序接口标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteApiById(Long id){
		return apiMapper.deleteApiById(id);
	}

	/**
	 * 批量保存应用程序接口
	 * @param  apiList 应用程序接口数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveApi(List<ApiDTO> apiList){
		return apiMapper.batchSaveApi(apiList);
	}
}
