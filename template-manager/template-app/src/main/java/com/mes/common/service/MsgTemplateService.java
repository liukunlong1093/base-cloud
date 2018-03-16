package com.mes.common.service;

import java.util.*;
import com.mes.common.dto.MsgTemplateDTO;
/**
  * 项目名称:	[common-app]
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
public interface MsgTemplateService {
	/**
	 * 根据消息模板标识获取消息模板
	 * @param id 消息模板标识
	 * @return 消息模板对象
	 */
	 MsgTemplateDTO getMsgTemplateById(Long id);
	

	/**
	 * 根据条件获取消息模板列表
	 * @param condition 查询条件
	 * @return 消息模板列表
	 */
	 List<MsgTemplateDTO> getMsgTemplateList(Map<String, Object> condition);

	/**
	 * 保存消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 新增后的消息模板对象
	 */
	 MsgTemplateDTO saveMsgTemplate(MsgTemplateDTO msgTemplateDTO);
	
	/**
	 * 更新消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 更新后的消息模板对象
	 */
	 MsgTemplateDTO updateMsgTemplate(MsgTemplateDTO msgTemplateDTO);


	/**
	 * 根据消息模板标识删除消息模板
	 * @param id 消息模板标识
	 * @return 删除成功条数
	 */
	 long  deleteMsgTemplateById(String id);
	

	/**
	 * 批量保存消息模板
	 * @param  msgTemplateList 消息模板数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveMsgTemplate(List<MsgTemplateDTO> msgTemplateList);
}
