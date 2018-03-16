package com.mes.system.dto;

import java.util.*;
import com.mes.core.pojos.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.dto]    
  * 类名称:		[DataPurviewDTO]  
  * 类描述:		[数据权限数据传输对象]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@ApiModel
public class DataPurviewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**  主键*/
	@ApiModelProperty(value = "主键")
	private Long id;
	/**  标题*/
	@ApiModelProperty(value = "标题")
	private String title;
	/**  权限对象SEC*/
	@ApiModelProperty(value = "权限对象SEC")
	private String secId;
	/**  权限对象SEC名称*/
	@ApiModelProperty(value = "权限对象SEC名称")
	private String secName;
	/**  菜单主键*/
	@ApiModelProperty(value = "菜单主键")
	private Long menuId;
	/**  系统功能标识*/
	@ApiModelProperty(value = "系统功能标识")
	private Long functionId;
	/**  系统功能标识*/
	@ApiModelProperty(value = "系统功能标识")
	private String functionCode;
	/**  范围权限对象SEC*/
	@ApiModelProperty(value = "范围权限对象SEC")
	private String rangeSecId;
	/**  范围权限对象SEC名称*/
	@ApiModelProperty(value = "范围权限对象SEC名称")
	private String rangeSecName;
	/**  排序*/
	@ApiModelProperty(value = "排序")
	private Long sort;
	/**  是否删除0:不删除；1:删除*/
	@ApiModelProperty(value = "是否删除0:不删除；1:删除")
	private Long isDel;
	/**  创建时间*/
	@ApiModelProperty(value = "创建时间", example = "2016-11-07 05:20:54")
	private Date createTime;
	/**  创建人*/
	@ApiModelProperty(value = "创建人")
	private Long createBy;
	/**  创建人名称*/
	@ApiModelProperty(value = "创建人名称")
	private String createName;
	/**  更新时间*/
	@ApiModelProperty(value = "更新时间", example = "2016-11-07 05:20:54")
	private Date updateTime;
	/**  更新人*/
	@ApiModelProperty(value = "更新人")
	private Long updateBy;
	/**  更新人名称*/
	@ApiModelProperty(value = "更新人名称")
	private String updateName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getRangeSecId() {
		return rangeSecId;
	}

	public void setRangeSecId(String rangeSecId) {
		this.rangeSecId = rangeSecId;
	}

	public String getRangeSecName() {
		return rangeSecName;
	}

	public void setRangeSecName(String rangeSecName) {
		this.rangeSecName = rangeSecName;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public Long getIsDel() {
		return isDel;
	}

	public void setIsDel(Long isDel) {
		this.isDel = isDel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
}
