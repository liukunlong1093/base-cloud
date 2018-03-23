package com.mes.system.web;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.mes.core.controller.BaseController;
import com.mes.core.pojos.ServiceResponse;
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
  * 包:	        [com.mes.system.web]    
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
@Api(value = "DomainController", description = "群组管理")
public class DomainController extends BaseController {
	@Autowired
	private DomainService domainService;

	/**
	 * 根据群组标识获取群组
	 * @param id 群组标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据群组标识获取群组", httpMethod = "GET", notes = "根据群组标识获取群组详细信息")
	@ApiImplicitParam(name = "id", value = "群组标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDomainById")
	public ServiceResponse<DomainDTO> getDomainById(@RequestParam(value="id") Long id) {
		DomainDTO domainDTO = domainService.getDomainById(id);
		return ServiceResponse.handleSuccess(domainDTO);
	}

	/**
	 * 根据条件获取群组列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取群组列表", httpMethod = "GET", notes = "根据条件获取群组列表")
	@ApiImplicitParams({ 
						@ApiImplicitParam(name = "id", value = "群组标识", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "code", value = "群组编号", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "name", value = "群组名称", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "type", value = "群组类型(0系统群组)", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "comment", value = "群组说明", required = false, dataType = "String", paramType = "query"), 
								@ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), 
																														@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), 
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") 
	})
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDomainList")
	public ServiceResponse<List<DomainDTO>> getDomainList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<DomainDTO> domainList = domainService.getDomainList(condition);
		PageInfo<DomainDTO> pageInfo = new PageInfo<DomainDTO>(domainList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存群组
	 * @param domainDTO 群组对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存群组", httpMethod = "POST", notes = "保存群组信息")
	@ApiImplicitParam(name = "domainDTO", value = "群组对象", required = true, dataType = "DomainDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveDomain")
	public ServiceResponse<DomainDTO> saveDomain(@RequestBody DomainDTO domainDTO) {
		return ServiceResponse.handleSuccess(domainService.saveDomain(domainDTO));
	}

	/**
	 * 更新群组
	 * @param domainDTO 群组对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新群组", httpMethod = "POST", notes = "更新群组信息")
	@ApiImplicitParam(name = "domainDTO", value = "群组对象", required = true, dataType = "DomainDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateDomain")
	public ServiceResponse<?> updateDomain(@RequestBody DomainDTO domainDTO) {
		domainService.updateDomain(domainDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据群组标识删除群组
	 * @param id 群组标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据群组标识删除群组", httpMethod = "GET", notes = "根据群组标识删除群组")
	@ApiImplicitParam(name = "id", value = "群组标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteDomainById")
	public ServiceResponse<?> deleteDomainById(@RequestParam(value="id") String id) {
		domainService.deleteDomainById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存群组
	 * @param domainDAOList 群组对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存群组", httpMethod = "POST", notes = "批量保存群组信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveDomain")
	public ServiceResponse<?> batchSaveDomain(@RequestBody List<DomainDTO> domainList) {
		domainService.batchSaveDomain(domainList);
		return ServiceResponse.handleSuccess();
	}
	
	/**
	 * 根据群组用户成员标识获取群组用户成员
	 * @param id 群组用户成员标识
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据群组用户成员标识获取群组用户成员", httpMethod = "GET", notes = "根据群组用户成员标识获取群组用户成员详细信息")
	@ApiImplicitParam(name = "id", value = "群组用户成员标识", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDomainUserRelById")
	public ServiceResponse<DomainUserRelDTO> getDomainUserRelById(@RequestParam(value="id") Long id) {
		DomainUserRelDTO domainUserRelDTO = domainService.getDomainUserRelById(id);
		return ServiceResponse.handleSuccess(domainUserRelDTO);
	}

	/**
	 * 根据条件获取群组用户成员列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据条件获取群组用户成员列表", httpMethod = "GET", notes = "根据条件获取群组用户成员列表")
	@ApiImplicitParams({ 
						@ApiImplicitParam(name = "id", value = "群组用户成员标识", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "domainId", value = "群组标识", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "userId", value = "用户标识", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "Long", paramType = "query"), 
								@ApiImplicitParam(name = "isDel", value = "是否删除0:不删除；1:删除", required = false, dataType = "Long", paramType = "query"), 
																														@ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "String", paramType = "query"), 
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, dataType = "String", paramType = "query") 
	})
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/getDomainUserRelList")
	public ServiceResponse<List<DomainUserRelDTO>> getDomainUserRelList(@ApiIgnore @RequestParam Map<String, Object> condition) {
		List<DomainUserRelDTO> domainUserRelList = domainService.getDomainUserRelList(condition);
		PageInfo<DomainUserRelDTO> pageInfo = new PageInfo<DomainUserRelDTO>(domainUserRelList);
		return ServiceResponse.handleSuccess(pageInfo.getList(), pageInfo.getTotal());
	}

	/**
	 * 保存群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "保存群组用户成员", httpMethod = "POST", notes = "保存群组用户成员信息")
	@ApiImplicitParam(name = "domainUserRelDTO", value = "群组用户成员对象", required = true, dataType = "DomainUserRelDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/saveDomainUserRel")
	public ServiceResponse<?> saveDomainUserRel(@RequestBody DomainUserRelDTO domainUserRelDTO) {
		domainService.saveDomainUserRel(domainUserRelDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 更新群组用户成员
	 * @param domainUserRelDTO 群组用户成员对象
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "更新群组用户成员", httpMethod = "POST", notes = "更新群组用户成员信息")
	@ApiImplicitParam(name = "domainUserRelDTO", value = "群组用户成员对象", required = true, dataType = "DomainUserRelDTO", paramType = "body")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/updateDomainUserRel")
	public ServiceResponse<?> updateDomainUserRel(@RequestBody DomainUserRelDTO domainUserRelDTO) {
		domainService.updateDomainUserRel(domainUserRelDTO);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 根据群组用户成员标识删除群组用户成员
	 * @param id 群组用户成员标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "根据群组用户成员标识删除群组用户成员", httpMethod = "GET", notes = "根据群组用户成员标识删除群组用户成员")
	@ApiImplicitParam(name = "id", value = "群组用户成员标识(多个已逗号分隔)", required = true, dataType = "String", paramType = "query")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/deleteDomainUserRelById")
	public ServiceResponse<?> deleteDomainUserRelById(@RequestParam(value="id") String id) {
		domainService.deleteDomainUserRelById(id);
		return ServiceResponse.handleSuccess();
	}

	/**
	 * 批量保存群组用户成员
	 * @param domainUserRelDAOList 群组用户成员对象集合
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "批量保存群组用户成员", httpMethod = "POST", notes = "批量保存群组用户成员信息")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/batchSaveDomainUserRel")
	public ServiceResponse<?> batchSaveDomainUserRel(@RequestBody List<DomainUserRelDTO> domainUserRelList) {
		domainService.batchSaveDomainUserRel(domainUserRelList);
		return ServiceResponse.handleSuccess();
	}
}
