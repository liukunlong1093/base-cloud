package com.mes.system.service.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mes.core.pojos.ServiceResponse;
import com.mes.system.dto.DataPurviewDTO;
import com.mes.system.dto.FunctionPurviewDTO;
import com.mes.system.dto.MenuPurviewDTO;
import com.mes.system.dto.PurviewFunctionTreeDTO;
import com.mes.system.dto.PurviewSecTreeDTO;
import com.mes.system.service.PurviewService;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service.fallback]    
  * 类名称:		[PurviewServiceFallback]  
  * 类描述:		[权限业务降级处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@Component
public class PurviewServiceFallback implements PurviewService {
	/**
		 * 根据菜单权限标识获取菜单权限
		 * @param id 菜单权限标识
		 * @return 服务响应对象
		 */
	@Override
	public ServiceResponse<MenuPurviewDTO> getMenuPurviewById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据菜单权限标识获取菜单权限服务不可用.");
	}

	/**
	 * 根据条件获取菜单权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<MenuPurviewDTO>> getMenuPurviewList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取菜单权限列表服务不可用.");
	}

	/**
	 * 保存菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveMenuPurview(MenuPurviewDTO menuPurviewDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存菜单权限服务不可用.");
	}

	/**
	 * 更新菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateMenuPurview(MenuPurviewDTO menuPurviewDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新菜单权限服务不可用.");
	}

	/**
	 * 根据菜单权限标识删除菜单权限
	 * @param id 菜单权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteMenuPurviewById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据菜单权限标识删除菜单权限服务不可用.");
	}

	/**
	 * 批量保存菜单权限
	 * @param menuPurviewDAOList 菜单权限对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveMenuPurview(List<MenuPurviewDTO> menuPurviewList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存菜单权限服务不可用.");
	}

	/**
	 * 根据功能权限标识获取功能权限
	 * @param id 功能权限标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<FunctionPurviewDTO> getFunctionPurviewById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据功能权限标识获取功能权限服务不可用.");
	}

	/**
	 * 根据条件获取功能权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<FunctionPurviewDTO>> getFunctionPurviewList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取功能权限列表服务不可用.");
	}

	/**
	 * 保存功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveFunctionPurview(FunctionPurviewDTO functionPurviewDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存功能权限服务不可用.");
	}

	/**
	 * 更新功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateFunctionPurview(FunctionPurviewDTO functionPurviewDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新功能权限服务不可用.");
	}

	/**
	 * 根据功能权限标识删除功能权限
	 * @param id 功能权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteFunctionPurviewById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据功能权限标识删除功能权限服务不可用.");
	}

	/**
	 * 批量保存功能权限
	 * @param functionPurviewDAOList 功能权限对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveFunctionPurview(List<FunctionPurviewDTO> functionPurviewList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存功能权限服务不可用.");
	}

	/**
	 * 根据数据权限标识获取数据权限
	 * @param id 数据权限标识
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<DataPurviewDTO> getDataPurviewById(Long id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据数据权限标识获取数据权限服务不可用.");
	}

	/**
	 * 根据条件获取数据权限列表
	 * @param condition 查询条件
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<List<DataPurviewDTO>> getDataPurviewList(Map<String, Object> condition) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取数据权限列表服务不可用.");
	}

	/**
	 * 保存数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> saveDataPurview(DataPurviewDTO dataPurviewDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "保存数据权限服务不可用.");
	}

	/**
	 * 更新数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> updateDataPurview(DataPurviewDTO dataPurviewDTO) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "更新数据权限服务不可用.");
	}

	/**
	 * 根据数据权限标识删除数据权限
	 * @param id 数据权限标识(多个已逗号分隔)
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> deleteDataPurviewById(String id) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据数据权限标识删除数据权限服务不可用.");
	}

	/**
	 * 批量保存数据权限
	 * @param dataPurviewDAOList 数据权限对象集合
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSaveDataPurview(List<DataPurviewDTO> dataPurviewList) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存数据权限服务不可用.");
	}

	/**
	 * 批量保存数据权限
	 * @param secDataJson 权限对象Json字符串
	 * @param prviewFucntionDataJson 权限功能Json字符串
	 * @param rangeSecDataJson 范围权限对象Json字符串
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<?> batchSavePurview(Long userId, String secDataJson, String prviewFucntionDataJson, String rangeSecDataJson) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "批量保存权限服务不可用.");
	}

	/**
	 * 根据条件获取系统权限对象树
	 * @param userId 用户标识
	 * @param pvSql 数据权限SQL
	 * @return 系统权限对象树
	 */
	@Override
	public ServiceResponse<List<PurviewSecTreeDTO>> getPurviewSecTree(Long userId, String pvSql) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取系统权限对象树服务不可用.");
	}

	/**
	 * 根据条件获取系统权限功能树
	 * @param condition 用户标识
	 * @param condition 权限对象标识
	 * @return 系统功能对象集合
	 */
	@Override
	public ServiceResponse<List<PurviewFunctionTreeDTO>> getPurviewFucntionTree(Long userId, String secId) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取系统权限功能树服务不可用.");
	}

	/**
	 * 根据条件获取系统权限范围对象树
	 * @param userId 用户标识
	 * @param secId  权限资源对象
	 * @param pvSql  数据权限SQL
	 * @return 系统权限范围对象树
	 */
	@Override
	public ServiceResponse<List<PurviewSecTreeDTO>> getPurviewRangeSecTree(Long userId, String secId, String pvSql) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "根据条件获取系统权限范围对象树服务不可用.");
	}

	/***
	 * 校验接口地址是否具有权限
	 * @param userId 用户标识
	 * @param apiUrl 接口地址
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<Boolean> checkPurview(Long userId, String apiUrl) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "校验接口地址是否具有权限服务不可用.");
	}

	/***
	 * 校验功能编码是否具有功能权限
	 * @param userId 用户标识
	 * @param functionCode 功能编码
	 * @return 服务响应对象
	 */
	@Override
	public ServiceResponse<Boolean> checkFunctionPurview(Long userId, String functionCode) {
		return ServiceResponse.handleFail(ServiceResponse.CODE_ERROR_SERVICE, "校验功能编码是否具有功能权限服务不可用.");
	}

}
