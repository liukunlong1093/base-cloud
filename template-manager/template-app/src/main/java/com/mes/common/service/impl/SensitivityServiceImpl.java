package com.mes.common.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.common.dto.SensitivityDTO;
import com.mes.common.manager.SensitivityManager;
import com.mes.common.service.SensitivityService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service.impl]    
  * 类名称:		[SensitivityServiceImpl]  
  * 类描述:		[敏感词业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("sensitivityService")
public class SensitivityServiceImpl implements SensitivityService {
	@Autowired
	private SensitivityManager sensitivityManager;
	
	/**
	 * 根据敏感词标识获取敏感词
	 * @param id 敏感词标识
	 * @return 敏感词对象
	 */
	@Override
	public SensitivityDTO getSensitivityById(Long id){
		SensitivityDTO sensitivityDTO = sensitivityManager.getSensitivityById(id);
		return sensitivityDTO;
	}
	

	/**
	 * 根据条件获取敏感词列表
	 * @param condition 查询条件
	 * @return 敏感词列表
	 */
	@Override
	public List<SensitivityDTO> getSensitivityList(Map<String, Object> condition){
		List<SensitivityDTO> sensitivityList = sensitivityManager.getSensitivityList(condition);
		return sensitivityList;
	}

	/**
	 * 保存敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 新增后的敏感词对象
	 */
	@Override
	public SensitivityDTO saveSensitivity(SensitivityDTO sensitivityDTO){
	    sensitivityDTO.setCreateTime(new Date());
		sensitivityManager.saveSensitivity(sensitivityDTO);
		return sensitivityDTO;
	}
	
	/**
	 * 更新敏感词
	 * @param sensitivityDTO 敏感词对象
	 * @return 更新后的敏感词对象
	 */
	@Override
	public SensitivityDTO updateSensitivity(SensitivityDTO sensitivityDTO){
		sensitivityDTO.setUpdateTime(new Date());
		sensitivityManager.updateSensitivity(sensitivityDTO);
		return sensitivityDTO;
	}


	/**
	 * 根据敏感词标识删除敏感词
	 * @param id 敏感词标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteSensitivityById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				sensitivityManager.deleteSensitivityById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存敏感词
	 * @param  sensitivityList 敏感词数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveSensitivity(List<SensitivityDTO> sensitivityList){
		long result = 0;
		result = sensitivityManager.batchSaveSensitivity(sensitivityList);
		return result;
	}

	

}