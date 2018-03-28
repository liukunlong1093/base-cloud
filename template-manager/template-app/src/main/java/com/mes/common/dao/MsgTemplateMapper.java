package com.mes.common.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.mes.common.dto.MsgTemplateDTO;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.dao]    
  * 类名称:		[UserMapper]  
  * 类描述:		[消息模板数据映射接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Mapper
public interface MsgTemplateMapper {
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
	 * @return 新增成功条数
	 */
	 long saveMsgTemplate(MsgTemplateDTO msgTemplateDTO);

	/**
	 * 更新消息模板
	 * @param msgTemplateDTO 消息模板对象
	 * @return 更新成功条数
	 */
	 long updateMsgTemplate(MsgTemplateDTO msgTemplateDTO);

	/**
	 * 根据消息模板标识删除消息模板
	 * @param id 消息模板标识
	 * @return 删除成功条数
	 */
	 long  deleteMsgTemplateById(Long id);

	/**
	 * 批量保存消息模板
	 * @param  msgTemplateList 消息模板数据集合
	 * @return 新增成功条数
	 */
	 long batchSaveMsgTemplate(List<MsgTemplateDTO> msgTemplateList);

}
