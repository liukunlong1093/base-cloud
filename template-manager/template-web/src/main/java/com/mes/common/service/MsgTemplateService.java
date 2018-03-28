package com.mes.common.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.MsgTemplateDTO;
import com.mes.common.service.fallback.MsgTemplateServiceFallback;

/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service]    
  * 类名称:		[MsgTemplateService]  
  * 类描述:		[消息模板业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = MsgTemplateServiceFallback.class)
public interface MsgTemplateService {

	/**
	 * 根据消息模板标识获取消息模板
	 * @param id 消息模板标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/msgTemplate/getMsgTemplateById")
	ServiceResponse<MsgTemplateDTO> getMsgTemplateById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取消息模板列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/msgTemplate/getMsgTemplateList")
	ServiceResponse<List<MsgTemplateDTO>> getMsgTemplateList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/msgTemplate/saveMsgTemplate")
	ServiceResponse<?> saveMsgTemplate(@RequestBody MsgTemplateDTO msgTemplateDTO);

	/**
	 * 更新消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/msgTemplate/updateMsgTemplate")
	ServiceResponse<?> updateMsgTemplate(@RequestBody MsgTemplateDTO msgTemplateDTO);

	/**
	 * 根据消息模板标识删除消息模板
	 * @param id 消息模板标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/msgTemplate/deleteMsgTemplateById")
	ServiceResponse<?> deleteMsgTemplateById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存消息模板
	 * @param msgTemplateList 消息模板对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/msgTemplate/batchSaveMsgTemplate")
	ServiceResponse<?> batchSaveMsgTemplate(@RequestBody List<MsgTemplateDTO> msgTemplateList);
}
