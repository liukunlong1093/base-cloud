package com.mes.system.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.pojos.ServiceResponse;
import com.mes.core.utils.StringUtils;
import com.mes.system.dto.DomainDTO;
import com.mes.system.dto.DomainUserRelDTO;
import com.mes.system.service.DomainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.web.controller]    
  * 类名称:		[DomainController]  
  * 类描述:		[群组控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/domain")
@Api(value = "domainController", description = "群组管理")
public class DomainController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	DomainService domainService;

	/**
	 * 根据群组标识获取群组
	 * @param id 群组标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据群组标识获取群组", httpMethod = "GET", notes = "根据群组标识获取群组详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "群组标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDomainById")
	public ServiceResponse<DomainDTO> getDomainById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return domainService.getDomainById(id);
	}

	/**
	 * 根据条件获取群组列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取群组列表", httpMethod = "GET", notes = "根据条件获取群组列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "群组标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "code", value = "群组编号", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "name", value = "群组名称", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "type", value = "群组类型(0系统群组)", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "comment", value = "群组说明", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDomainList")
	public ServiceResponse<List<DomainDTO>> getDomainList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return domainService.getDomainList(condition);
	}

	/**
	 * 保存群组
	 * @param domainDTO 群组数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存群组", httpMethod = "POST", notes = "保存群组信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "domainDTO", value = "群组数据传输对象", required = true, dataType = "DomainDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveDomain")
	public ServiceResponse<DomainDTO> saveDomain(@RequestBody DomainDTO domainDTO) {
		return domainService.saveDomain(domainDTO);
	}

	/**
	 * 更新群组
	 * @param domainDTO 群组数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新群组", httpMethod = "POST", notes = "更新群组信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "domainDTO", value = "群组数据传输对象", required = true, dataType = "DomainDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateDomain")
	public ServiceResponse<?> updateDomain(@RequestBody DomainDTO domainDTO) {
		return domainService.updateDomain(domainDTO);
	}

	/**
	 * 根据群组标识删除群组
	 * @param id 群组标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据群组标识删除群组", httpMethod = "GET", notes = "根据群组标识删除群组")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "群组标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteDomainById")
	public ServiceResponse<?> deleteDomainById(@RequestParam(value = "id") String id) {
		return domainService.deleteDomainById(id);
	}

	/**
	 * 批量保存群组
	 * @param domainDAOList 群组数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存群组", httpMethod = "POST", notes = "批量保存群组")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "userDTO", value = "群组数据传输对象", required = true, dataType = "List", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveDomain")
	public ServiceResponse<?> batchSaveDomain(@RequestBody List<DomainDTO> domainList) {
		return domainService.batchSaveDomain(domainList);
	}

	/**
	 * 根据群组用户成员标识获取群组用户成员
	 * @param id 群组用户成员标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据群组用户成员标识获取群组用户成员", httpMethod = "GET", notes = "根据群组用户成员标识获取群组用户成员详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "群组用户成员标识", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDomainUserRelById")
	public ServiceResponse<DomainUserRelDTO> getDomainUserRelById(@RequestParam(value = "id") Long id) {
		System.out.println(request.getHeader("token"));
		return domainService.getDomainUserRelById(id);
	}

	/**
	 * 根据条件获取群组用户成员列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取群组用户成员列表", httpMethod = "GET", notes = "根据条件获取群组用户成员列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "群组用户成员标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "domainId", value = "群组标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "userId", value = "用户标识", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDomainUserRelList")
	public ServiceResponse<List<DomainUserRelDTO>> getDomainUserRelList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		return domainService.getDomainUserRelList(condition);
	}

	/**
	 * 保存群组用户成员
	 * @param domainUserRelDTO 群组用户成员数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存群组用户成员", httpMethod = "POST", notes = "保存群组用户成员信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "domainUserRelDTO", value = "群组用户成员数据传输对象", required = true, dataType = "DomainUserRelDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveDomainUserRel")
	public ServiceResponse<?> saveDomainUserRel(@RequestBody DomainUserRelDTO domainUserRelDTO) {
		return domainService.saveDomainUserRel(domainUserRelDTO);
	}

	/**
	 * 更新群组用户成员
	 * @param domainUserRelDTO 群组用户成员数据传输对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新群组用户成员", httpMethod = "POST", notes = "更新群组用户成员信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "domainUserRelDTO", value = "群组用户成员数据传输对象", required = true, dataType = "DomainUserRelDTO", paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateDomainUserRel")
	public ServiceResponse<?> updateDomainUserRel(@RequestBody DomainUserRelDTO domainUserRelDTO) {
		return domainService.updateDomainUserRel(domainUserRelDTO);
	}

	/**
	 * 根据群组用户成员标识删除群组用户成员
	 * @param id 群组用户成员标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据群组用户成员标识删除群组用户成员", httpMethod = "GET", notes = "根据群组用户成员标识删除群组用户成员")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "id", value = "群组用户成员标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteDomainUserRelById")
	public ServiceResponse<?> deleteDomainUserRelById(@RequestParam(value = "id") String id) {
		return domainService.deleteDomainUserRelById(id);
	}

	/**
	 * 批量保存群组用户成员
	 * @param domainUserRelDAOList 群组用户成员数据传输对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存群组用户成员", httpMethod = "POST", notes = "批量保存群组用户成员")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String", paramType = "header"), @ApiImplicitParam(name = "domainId", value = "群组标识", required = true, dataType = "Long", paramType = "query"), @ApiImplicitParam(name = "userIds", value = "用户标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveDomainUserRel")
	public ServiceResponse<?> batchSaveDomainUserRel(@RequestParam(value = "domainId") Long domainId, @RequestParam(value = "userIds") String userIds) {
		String[] userId = userIds.split(",");
		List<DomainUserRelDTO> domainUserRelList = new ArrayList<DomainUserRelDTO>();
		if (userId != null && userId.length > 0) {
			for (String uid : userId) {
				DomainUserRelDTO domainUserRelDTO = new DomainUserRelDTO();
				domainUserRelDTO.setDomainId(domainId);
				domainUserRelDTO.setUserId(StringUtils.getAsLong(uid));
				domainUserRelDTO.setSort(0L);
				domainUserRelDTO.setIsDel(0L);
				domainUserRelDTO.setCreateBy(999999L);
				domainUserRelDTO.setCreateName("admin");
				domainUserRelDTO.setCreateTime(new Date());
				domainUserRelList.add(domainUserRelDTO);
			}
		}
		return domainService.batchSaveDomainUserRel(domainUserRelList);
	}
}
