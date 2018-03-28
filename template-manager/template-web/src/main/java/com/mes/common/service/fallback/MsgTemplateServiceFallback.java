package com.mes.common.service.fallback;

import java.util.*;
import org.springframework.stereotype.Component;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.MsgTemplateDTO;
import com.mes.common.service.MsgTemplateService;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service.fallback]    
  * 类名称:		[MsgTemplateServiceFallback]  
  * 类描述:		[消息模板业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class MsgTemplateServiceFallback implements MsgTemplateService {
/**
	 * 根据消息模板标识获取消息模板
	 * @param id 消息模板标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<MsgTemplateDTO> getMsgTemplateById(Long id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据消息模板标识获取消息模板服务不可用.");
	}

	/**
	 * 根据条件获取消息模板列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<MsgTemplateDTO>> getMsgTemplateList(Map<String, Object> condition){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取消息模板列表服务不可用.");
	}

	/**
	 * 保存消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveMsgTemplate(MsgTemplateDTO msgTemplateDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存消息模板服务不可用.");
	}
	
	/**
	 * 更新消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateMsgTemplate(MsgTemplateDTO msgTemplateDTO){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新消息模板服务不可用.");
	}

	/**
	 * 根据消息模板标识删除消息模板
	 * @param id 消息模板标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteMsgTemplateById(String id){
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据消息模板标识删除消息模板服务不可用.");
	}

	/**
	 * 批量保存消息模板
	 * @param msgTemplateDAOList 消息模板对象集合
	 * @return 服务响应对象
	 */
	@Override
	 public ServiceResponse<?> batchSaveMsgTemplate(List<MsgTemplateDTO> msgTemplateList){
	 	return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存消息模板服务不可用.");
	 }
}
