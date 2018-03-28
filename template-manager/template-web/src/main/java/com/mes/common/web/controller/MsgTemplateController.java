package com.mes.common.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.common.dto.MsgTemplateDTO;
import com.mes.common.service.MsgTemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.web.controller]    
  * 类名称:		[MsgTemplateController]  
  * 类描述:		[消息模板控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/msgTemplate")
@Api(value = "msgTemplateController", description = "消息模板管理")
public class MsgTemplateController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	MsgTemplateService msgTemplateService;

	/**
	 * 根据消息模板标识获取消息模板
	 * @param id 消息模板标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据消息模板标识获取消息模板", httpMethod = "GET", notes = "根据消息模板标识获取消息模板详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "消息模板标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMsgTemplateById")
	public ServiceResponse<MsgTemplateDTO> getMsgTemplateById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return msgTemplateService.getMsgTemplateById(id);
	}

	/**
	 * 根据条件获取消息模板列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取消息模板列表", httpMethod = "GET", notes = "根据条件获取消息模板列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "主键", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "模板编码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "type", value = "模板类型（1---邮件，2---短信，3---微信）", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "status", value = "模板状态（0---启用，1---禁用）", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "content", value = "模板内容", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getMsgTemplateList")
	public ServiceResponse<List<MsgTemplateDTO>> getMsgTemplateList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return msgTemplateService.getMsgTemplateList(condition);
	}

	/**
	 * 保存消息模板
	 * @param msgTemplateDTO 消息模板数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存消息模板", httpMethod = "POST", notes = "保存消息模板信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "msgTemplateDTO", value = "消息模板数据传输对象", required = true, dataType = "MsgTemplateDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveMsgTemplate")
	public ServiceResponse<?> saveMsgTemplate(@RequestBody MsgTemplateDTO msgTemplateDTO) {
		return msgTemplateService.saveMsgTemplate(msgTemplateDTO);
	}

	/**
	 * 更新消息模板
	 * @param msgTemplateDTO 消息模板数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新消息模板", httpMethod = "POST", notes = "更新消息模板信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "msgTemplateDTO", value = "消息模板数据传输对象", required = true, dataType = "MsgTemplateDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateMsgTemplate")
	public ServiceResponse<?> updateMsgTemplate(@RequestBody MsgTemplateDTO msgTemplateDTO) {
		return msgTemplateService.updateMsgTemplate(msgTemplateDTO);
	}

	/**
	 * 根据消息模板标识删除消息模板
	 * @param id 消息模板标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据消息模板标识删除消息模板", httpMethod = "GET", notes = "根据消息模板标识删除消息模板")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "消息模板标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteMsgTemplateById")
	public ServiceResponse<?> deleteMsgTemplateById(@RequestParam(value = "id") String id) {
		return msgTemplateService.deleteMsgTemplateById(id);
	}

	/**
	 * 批量保存消息模板
	 * @param msgTemplateDAOList 消息模板数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存消息模板", httpMethod = "POST", notes = "批量保存消息模板")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "消息模板数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveMsgTemplate")
	public ServiceResponse<?> batchSaveMsgTemplate(@RequestBody List<MsgTemplateDTO> msgTemplateList) {
		return msgTemplateService.batchSaveMsgTemplate(msgTemplateList);
	}
}
