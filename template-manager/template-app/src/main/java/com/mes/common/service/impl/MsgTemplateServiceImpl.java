package com.mes.common.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.common.dto.MsgTemplateDTO;
import com.mes.common.manager.MsgTemplateManager;
import com.mes.common.service.MsgTemplateService;
import com.mes.core.utils.StringUtils;
 /**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.service.impl]    
  * 类名称:		[MsgTemplateServiceImpl]  
  * 类描述:		[消息模板业务处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("msgTemplateService")
public class MsgTemplateServiceImpl implements MsgTemplateService {
	@Autowired
	private MsgTemplateManager msgTemplateManager;
	
	/**
	 * 根据消息模板标识获取消息模板
	 * @param id 消息模板标识
	 * @return 消息模板对象
	 */
	@Override
	public MsgTemplateDTO getMsgTemplateById(Long id){
		MsgTemplateDTO msgTemplateDTO = msgTemplateManager.getMsgTemplateById(id);
		return msgTemplateDTO;
	}
	

	/**
	 * 根据条件获取消息模板列表
	 * @param condition 查询条件
	 * @return 消息模板列表
	 */
	@Override
	public List<MsgTemplateDTO> getMsgTemplateList(Map<String, Object> condition){
		List<MsgTemplateDTO> msgTemplateList = msgTemplateManager.getMsgTemplateList(condition);
		return msgTemplateList;
	}

	/**
	 * 保存消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 新增后的消息模板对象
	 */
	@Override
	public MsgTemplateDTO saveMsgTemplate(MsgTemplateDTO msgTemplateDTO){
	    msgTemplateDTO.setCreateTime(new Date());
		msgTemplateManager.saveMsgTemplate(msgTemplateDTO);
		return msgTemplateDTO;
	}
	
	/**
	 * 更新消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 更新后的消息模板对象
	 */
	@Override
	public MsgTemplateDTO updateMsgTemplate(MsgTemplateDTO msgTemplateDTO){
		msgTemplateDTO.setUpdateTime(new Date());
		msgTemplateManager.updateMsgTemplate(msgTemplateDTO);
		return msgTemplateDTO;
	}


	/**
	 * 根据消息模板标识删除消息模板
	 * @param id 消息模板标识
	 * @return <code>0</code>删除成功
	 */
	@Override
	public  long  deleteMsgTemplateById(String id){
		long result = 0;
		String[] ids=id.split(",");
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				msgTemplateManager.deleteMsgTemplateById(StringUtils.getAsLong(idStr,0L));
			}
		}
		return result;
	}
	

	/**
	 * 批量保存消息模板
	 * @param  msgTemplateList 消息模板数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveMsgTemplate(List<MsgTemplateDTO> msgTemplateList){
		long result = 0;
		result = msgTemplateManager.batchSaveMsgTemplate(msgTemplateList);
		return result;
	}

	

}