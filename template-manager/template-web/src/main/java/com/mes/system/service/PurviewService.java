package com.mes.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.DataPurviewDTO;
import com.mes.system.dto.FunctionPurviewDTO;
import com.mes.system.dto.MenuPurviewDTO;
import com.mes.system.dto.PurviewFunctionTreeDTO;
import com.mes.system.dto.PurviewSecTreeDTO;
import com.mes.system.service.fallback.PurviewServiceFallback;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[MenuPurviewService]  
  * 类描述:		[权限业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@FeignClient(value = "info-app", fallback = PurviewServiceFallback.class)
public interface PurviewService {

	/**
	 * 根据菜单权限标识获取菜单权限
	 * @param id 菜单权限标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/getMenuPurviewById")
	ServiceResponse<MenuPurviewDTO> getMenuPurviewById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取菜单权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/getMenuPurviewList")
	ServiceResponse<List<MenuPurviewDTO>> getMenuPurviewList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/saveMenuPurview")
	ServiceResponse<?> saveMenuPurview(@RequestBody MenuPurviewDTO menuPurviewDTO);

	/**
	 * 更新菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/updateMenuPurview")
	ServiceResponse<?> updateMenuPurview(@RequestBody MenuPurviewDTO menuPurviewDTO);

	/**
	 * 根据菜单权限标识删除菜单权限
	 * @param id 菜单权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/deleteMenuPurviewById")
	ServiceResponse<?> deleteMenuPurviewById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存菜单权限
	 * @param menuPurviewList 菜单权限对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/batchSaveMenuPurview")
	ServiceResponse<?> batchSaveMenuPurview(@RequestBody List<MenuPurviewDTO> menuPurviewList);

	/**
	 * 根据功能权限标识获取功能权限
	 * @param id 功能权限标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/getFunctionPurviewById")
	ServiceResponse<FunctionPurviewDTO> getFunctionPurviewById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取功能权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/getFunctionPurviewList")
	ServiceResponse<List<FunctionPurviewDTO>> getFunctionPurviewList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/saveFunctionPurview")
	ServiceResponse<?> saveFunctionPurview(@RequestBody FunctionPurviewDTO functionPurviewDTO);

	/**
	 * 更新功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/updateFunctionPurview")
	ServiceResponse<?> updateFunctionPurview(@RequestBody FunctionPurviewDTO functionPurviewDTO);

	/**
	 * 根据功能权限标识删除功能权限
	 * @param id 功能权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/deleteFunctionPurviewById")
	ServiceResponse<?> deleteFunctionPurviewById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存功能权限
	 * @param functionPurviewList 功能权限对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/batchSaveFunctionPurview")
	ServiceResponse<?> batchSaveFunctionPurview(@RequestBody List<FunctionPurviewDTO> functionPurviewList);

	/**
	 * 根据数据权限标识获取数据权限
	 * @param id 数据权限标识
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/getDataPurviewById")
	ServiceResponse<DataPurviewDTO> getDataPurviewById(@RequestParam(value = "id") Long id);

	/**
	 * 根据条件获取数据权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/getDataPurviewList")
	ServiceResponse<List<DataPurviewDTO>> getDataPurviewList(@RequestParam Map<String, Object> condition);

	/**
	 * 保存数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/saveDataPurview")
	ServiceResponse<?> saveDataPurview(@RequestBody DataPurviewDTO dataPurviewDTO);

	/**
	 * 更新数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/updateDataPurview")
	ServiceResponse<?> updateDataPurview(@RequestBody DataPurviewDTO dataPurviewDTO);

	/**
	 * 根据数据权限标识删除数据权限
	 * @param id 数据权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/deleteDataPurviewById")
	ServiceResponse<?> deleteDataPurviewById(@RequestParam(value = "id") String id);

	/**
	 * 批量保存数据权限
	 * @param dataPurviewList 数据权限对象集合
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/batchSaveDataPurview")
	ServiceResponse<?> batchSaveDataPurview(@RequestBody List<DataPurviewDTO> dataPurviewList);

	/**
	 * 批量保存数据权限
	 * @param userId 用户标识
	 * @param secDataJson 权限对象Json字符串
	 * @param prviewFucntionDataJson 权限功能Json字符串
	 * @param rangeSecDataJson 范围权限对象Json字符串
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/batchSavePurview")
	ServiceResponse<?> batchSavePurview(@RequestParam(value = "userId") Long userId, @RequestParam(value = "secDataJson") String secDataJson, @RequestParam(value = "prviewFucntionDataJson") String prviewFucntionDataJson, @RequestParam(value = "rangeSecDataJson") String rangeSecDataJson);

	/**
	 * 根据条件获取系统权限对象树
	 * @param userId 用户标识
	 * @param pvSql 数据权限SQL
	 * @return 系统权限对象树
	 */
	@RequestMapping("/purview/getPurviewSecTree")
	ServiceResponse<List<PurviewSecTreeDTO>> getPurviewSecTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "pvSql") String pvSql);


	/**
	 * 根据条件获取系统权限功能树
	 * @param userId 用户标识
	 * @param secId 权限对象标识
	 * @return 功能权限树
	 */
	@RequestMapping("/purview/getPurviewFucntionTree")
	ServiceResponse<List<PurviewFunctionTreeDTO>> getPurviewFucntionTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "secId", required = false) String secId);

	/**
	 * 根据条件获取系统权限范围对象树
	 * @param userId 用户标识
	 * @param secId  权限资源对象
	 * @param pvSql  数据权限SQL
	 * @return 系统权限范围对象树
	 */
	@RequestMapping("/purview/getPurviewRangeSecTree")
	ServiceResponse<List<PurviewSecTreeDTO>> getPurviewRangeSecTree(@RequestParam(value = "userId") Long userId, @RequestParam(value = "secId", required = false) String secId, @RequestParam(value = "pvSql") String pvSql);

	/***
	 * 校验接口地址是否具有权限
	 * @param userId 用户标识
	 * @param apiUrl 接口地址
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/checkPurview")
	ServiceResponse<Boolean> checkPurview(@RequestParam(value = "userId") Long userId, @RequestParam(value = "apiUrl", required = false) String apiUrl);

	/***
	 * 校验功能编码是否具有功能权限
	 * @param userId 用户标识
	 * @param functionCode 功能编码
	 * @return 服务响应对象
	 */
	@RequestMapping("/purview/checkFunctionPurview")
	ServiceResponse<Boolean> checkFunctionPurview(@RequestParam(value = "userId") Long userId, @RequestParam(value = "functionCode", required = false) String functionCode);
}
