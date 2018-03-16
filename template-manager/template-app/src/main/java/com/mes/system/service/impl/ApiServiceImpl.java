package com.mes.system.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.system.dto.ApiDTO;
import com.mes.system.manager.ApiManager;
import com.mes.system.service.ApiService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.impl]    
  * 类名称:		[ApiServiceImpl]  
  * 类描述:		[应用程序接口业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("apiService")
public class ApiServiceImpl implements ApiService {
	@Autowired
	private ApiManager apiManager;
	
	/**
	 * 根据应用程序接口标识获取应用程序接口
	 * @param id 应用程序接口标识
	 * @return 应用程序接口对象
	 */
	@Override
	public ApiDTO getApiById(Long id){
		ApiDTO apiDTO = apiManager.getApiById(id);
		return apiDTO;
	}
	

	/**
	 * 根据条件获取应用程序接口列表
	 * @param condition 查询条件
	 * @return 应用程序接口列表
	 */
	@Override
	public List<ApiDTO> getApiList(Map<String, Object> condition){
		List<ApiDTO> apiList = apiManager.getApiList(condition);
		return apiList;
	}

	/**
	 * 保存应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 新增后的应用程序接口对象
	 */
	@Override
	public ApiDTO saveApi(ApiDTO apiDTO){
	    apiDTO.setCreateTime(new Date());
		apiManager.saveApi(apiDTO);
		return apiDTO;
	}
	
	/**
	 * 更新应用程序接口
	 * @param apiDTO 应用程序接口对象
	 * @return 更新后的应用程序接口对象
	 */
	@Override
	public ApiDTO updateApi(ApiDTO apiDTO){
		apiDTO.setUpdateTime(new Date());
		apiManager.updateApi(apiDTO);
		return apiDTO;
	}


	/**
	 * 根据应用程序接口标识删除应用程序接口
	 * @param id 应用程序接口标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteApiById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				apiManager.deleteApiById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存应用程序接口
	 * @param  apiList 应用程序接口数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveApi(List<ApiDTO> apiList){
		long result = 0;
		result = apiManager.batchSaveApi(apiList);
		return result;
	}

	

}