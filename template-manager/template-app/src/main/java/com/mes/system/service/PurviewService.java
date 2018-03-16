package com.mes.system.service;

import java.util.List;
import java.util.Map;

import com.mes.system.dto.DataPurviewDTO;
import com.mes.system.dto.FunctionPurviewDTO;
import com.mes.system.dto.MenuPurviewDTO;
import com.mes.system.dto.PurviewFunctionTreeDTO;
import com.mes.system.dto.PurviewSecTreeDTO;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.service]    
  * 类名称:		[PurviewService]  
  * 类描述:		[权限业务处理接口]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public interface PurviewService {
	/**
	 * 根据菜单权限标识获取菜单权限
	 * @param id 菜单权限标识
	 * @return 菜单权限对象
	 */
	MenuPurviewDTO getMenuPurviewById(Long id);

	/**
	 * 根据条件获取菜单权限列表
	 * @param condition 查询条件
	 * @return 菜单权限列表
	 */
	List<MenuPurviewDTO> getMenuPurviewList(Map<String, Object> condition);

	/**
	 * 保存菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 新增后的菜单权限对象
	 */
	MenuPurviewDTO saveMenuPurview(MenuPurviewDTO menuPurviewDTO);

	/**
	 * 更新菜单权限
	 * @param menuPurviewDTO 菜单权限对象
	 * @return 更新后的菜单权限对象
	 */
	MenuPurviewDTO updateMenuPurview(MenuPurviewDTO menuPurviewDTO);

	/**
	 * 根据菜单权限标识删除菜单权限
	 * @param id 菜单权限标识
	 * @return 删除成功条数
	 */
	long deleteMenuPurviewById(String id);

	/**
	 * 批量保存菜单权限
	 * @param  menuPurviewList 菜单权限数据集合
	 * @return 新增成功条数
	 */
	long batchSaveMenuPurview(List<MenuPurviewDTO> menuPurviewList);
	
	/**
	 * 据权限对象标识删除菜单权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	 long  deleteMenuPurviewBySecId(String secId);

	/**
	* 根据功能权限标识获取功能权限
	* @param id 功能权限标识
	* @return 功能权限对象
	*/
	FunctionPurviewDTO getFunctionPurviewById(Long id);

	/**
	 * 根据条件获取功能权限列表
	 * @param condition 查询条件
	 * @return 功能权限列表
	 */
	List<FunctionPurviewDTO> getFunctionPurviewList(Map<String, Object> condition);

	/**
	 * 保存功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 新增后的功能权限对象
	 */
	FunctionPurviewDTO saveFunctionPurview(FunctionPurviewDTO functionPurviewDTO);

	/**
	 * 更新功能权限
	 * @param functionPurviewDTO 功能权限对象
	 * @return 更新后的功能权限对象
	 */
	FunctionPurviewDTO updateFunctionPurview(FunctionPurviewDTO functionPurviewDTO);

	/**
	 * 根据功能权限标识删除功能权限
	 * @param id 功能权限标识
	 * @return 删除成功条数
	 */
	long deleteFunctionPurviewById(String id);

	/**
	 * 批量保存功能权限
	 * @param  functionPurviewList 功能权限数据集合
	 * @return 新增成功条数
	 */
	long batchSaveFunctionPurview(List<FunctionPurviewDTO> functionPurviewList);

	/**
	 * 根据权限对象标识删除功能权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	long deleteFunctionPurviewBySecId(String secId);
	
	
	/**
	 * 根据数据权限标识获取数据权限
	 * @param id 数据权限标识
	 * @return 数据权限对象
	 */
	DataPurviewDTO getDataPurviewById(Long id);

	/**
	 * 根据条件获取数据权限列表
	 * @param condition 查询条件
	 * @return 数据权限列表
	 */
	List<DataPurviewDTO> getDataPurviewList(Map<String, Object> condition);

	/**
	 * 保存数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 新增后的数据权限对象
	 */
	DataPurviewDTO saveDataPurview(DataPurviewDTO dataPurviewDTO);

	/**
	 * 更新数据权限
	 * @param dataPurviewDTO 数据权限对象
	 * @return 更新后的数据权限对象
	 */
	DataPurviewDTO updateDataPurview(DataPurviewDTO dataPurviewDTO);

	/**
	 * 根据数据权限标识删除数据权限
	 * @param id 数据权限标识
	 * @return 删除成功条数
	 */
	long deleteDataPurviewById(String id);

	/**
	 * 批量保存数据权限
	 * @param  dataPurviewList 数据权限数据集合
	 * @return 新增成功条数
	 */
	long batchSaveDataPurview(List<DataPurviewDTO> dataPurviewList);
	
	/**
	 * 批量保存权限
	 * @param userId 用户标识
	 * @param secDataJson 权限对象SEC数据JSON字符串数组
	 * @param prviewFucntionDataJson 权限功能数据JSON字符串数组
	 * @param rangeSecDataJson 范围权限对象SEC数据JSON字符串数组
	 * @return <code>0<code>保存成功
	 */
	long batchSavePurview(Long userId,String secDataJson,String prviewFucntionDataJson,String rangeSecDataJson);
	
	/**
	 * 根据权限对象标识删除数据权限
	 * @param secId 权限对象标识
	 * @return 删除成功条数
	 */
	long deleteDataPurviewBySecId(String secId);

	/**
	 * 根据条件获取系统权限对象树
	 * @param userId 用户标识
	 * @param pvSql 数据权限SQL
	 * @return 系统权限对象树
	 */
	List<PurviewSecTreeDTO> getPurviewSecTree(Long userId,String pvSql);
	

	/**
	 * 根据条件获取系统权限功能树
	 * @param userId 用户标识
	 * @param secId 权限对象标识
	 * @return 系统功能对象集合
	 */
	List<PurviewFunctionTreeDTO> getPurviewFucntionTree(Long userId,String secId);
	
	/**
	 * 根据条件获取系统权限范围对象树
	 * @param userId 用户标识
	 * @param secId  权限资源对象
	 * @param pvSql  数据权限SQL
	 * @return 系统权限范围对象树
	 */
	List<PurviewSecTreeDTO> getPurviewRangeSecTree(Long userId,String secId,String pvSql);
	
	
	/***
	 * 校验接口地址是否具有权限
	 * @param userId 用户标识
	 * @param apiUrl 接口地址
	 * @return <code>true</code>有权限<code>false</code>无权限
	 */
	boolean checkPurview(Long userId,String apiUrl);
	
	
	/***
	 * 校验功能编码是否具有功能权限
	 * @param userId 用户标识
	 * @param functionCode 功能编码
	 * @return <code>true</code>有权限<code>false</code>无权限
	 */
	boolean checkFunctionPurview(Long userId,String functionCode);
	
	
	
}
