package com.mes.common.manager.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mes.common.manager.MsgTemplateManager;
import com.mes.common.dao.MsgTemplateMapper;
import com.mes.common.dto.MsgTemplateDTO;
/**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.manager.impl]    
  * 类名称:		[MsgTemplateManagerImpl]  
  * 类描述:		[消息模板管理处理类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Service("msgTemplateManager")
public class MsgTemplateManagerImpl implements MsgTemplateManager {
	@Autowired
	private MsgTemplateMapper msgTemplateMapper;


	/**
	 * 根据消息模板标识获取消息模板
	 * @param id 消息模板标识
	 * @return 消息模板对象
	 */
	@Override
	public MsgTemplateDTO getMsgTemplateById(Long id){
		return msgTemplateMapper.getMsgTemplateById(id);
	}

	/**
	 * 根据条件获取消息模板列表
	 * @param condition 查询条件
	 * @return 消息模板列表
	 */
	@Override
	public List<MsgTemplateDTO> getMsgTemplateList(Map<String, Object> condition){
		return msgTemplateMapper.getMsgTemplateList(condition);
	}

	/**
	 * 保存消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 新增成功条数
	 */
	@Override
	public long saveMsgTemplate(MsgTemplateDTO msgTemplateDTO){
		return msgTemplateMapper.saveMsgTemplate(msgTemplateDTO);
	}

	/**
	 * 更新消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 更新成功条数
	 */
	@Override
	public long updateMsgTemplate(MsgTemplateDTO msgTemplateDTO){
		return msgTemplateMapper.updateMsgTemplate(msgTemplateDTO);
	}

	/**
	 * 根据消息模板标识删除消息模板
	 * @param id 消息模板标识
	 * @return 删除成功条数
	 */
	@Override
	public  long  deleteMsgTemplateById(Long id){
		return msgTemplateMapper.deleteMsgTemplateById(id);
	}

	/**
	 * 批量保存消息模板
	 * @param  msgTemplateList 消息模板数据集合
	 * @return 新增成功条数
	 */
	@Override
	public long batchSaveMsgTemplate(List<MsgTemplateDTO> msgTemplateList){
		return msgTemplateMapper.batchSaveMsgTemplate(msgTemplateList);
	}
}
