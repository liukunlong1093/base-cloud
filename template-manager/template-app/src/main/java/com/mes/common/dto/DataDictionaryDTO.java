package com.mes.common.dto;
import java.util.*;
import com.mes.core.pojos.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.dto]    
  * 类名称:		[DataDictionaryDTO]  
  * 类描述:		[数据字典数据传输对象]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@ApiModel
public class DataDictionaryDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	
		    /**  ID编号*/
	@ApiModelProperty(value = "ID编号")
	private Long id;
   			    /**  业务编码*/
	@ApiModelProperty(value = "业务编码")
	private String code;
   			    /**  业务名称*/
	@ApiModelProperty(value = "业务名称")
	private String name;
   			    /**  所属编码*/
	@ApiModelProperty(value = "所属编码")
	private String parentCode;
   			    /**  是否可修改(0:否  1:是)*/
	@ApiModelProperty(value = "是否可修改(0:否  1:是)")
	private Long isEdit;
   			    /**  是否有效(0:否  1:是)*/
	@ApiModelProperty(value = "是否有效(0:否  1:是)")
	private Long isValid;
   			    /**  是否默认(0:否  1:是)*/
	@ApiModelProperty(value = "是否默认(0:否  1:是)")
	private Long isDefault;
   			    /**  说明*/
	@ApiModelProperty(value = "说明")
	private String comment;
   			    /**  排序字段*/
	@ApiModelProperty(value = "排序字段")
	private Long sort;
   			    /**  创建人*/
	@ApiModelProperty(value = "创建人")
	private Long createBy;
   			    /**  创建人名称*/
	@ApiModelProperty(value = "创建人名称")
	private String createName;
   			    /**  创建时间*/
	@ApiModelProperty(value = "创建时间",example = "2016-11-07 05:20:54")
	private Date createTime;
   			    /**  更新人*/
	@ApiModelProperty(value = "更新人")
	private Long updateBy;
   			    /**  更新人名称*/
	@ApiModelProperty(value = "更新人名称")
	private String updateName;
   			    /**  更新时间*/
	@ApiModelProperty(value = "更新时间",example = "2016-11-07 05:20:54")
	private Date updateTime;
   			    /**  是否删除*/
	@ApiModelProperty(value = "是否删除")
	private Long isDel;
   		
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =id;
	}
		
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code =code;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name =name;
	}
		
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode =parentCode;
	}
		
	public Long getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Long isEdit) {
		this.isEdit =isEdit;
	}
		
	public Long getIsValid() {
		return isValid;
	}

	public void setIsValid(Long isValid) {
		this.isValid =isValid;
	}
		
	public Long getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Long isDefault) {
		this.isDefault =isDefault;
	}
		
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment =comment;
	}
		
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort =sort;
	}
		
	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy =createBy;
	}
		
	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName =createName;
	}
		
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime =createTime;
	}
		
	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy =updateBy;
	}
		
	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName =updateName;
	}
		
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime =updateTime;
	}
		
	public Long getIsDel() {
		return isDel;
	}

	public void setIsDel(Long isDel) {
		this.isDel =isDel;
	}
	}
