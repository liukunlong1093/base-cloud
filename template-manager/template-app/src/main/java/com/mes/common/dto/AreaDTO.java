package com.mes.common.dto;
import java.util.*;
import com.mes.core.pojos.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
  * 项目名称:	[template-app]
  * 包:	        [com.mes.common.dto]    
  * 类名称:		[AreaDTO]  
  * 类描述:		[区域数据传输对象]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@ApiModel
public class AreaDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	
		    /**  主键标识*/
	@ApiModelProperty(value = "主键标识")
	private Long id;
   			    /**  父主键标识*/
	@ApiModelProperty(value = "父主键标识")
	private Long parentId;
   			    /**  标题*/
	@ApiModelProperty(value = "标题")
	private String title;
   			    /**  层级*/
	@ApiModelProperty(value = "层级")
	private Long level;
   			    /**  排序*/
	@ApiModelProperty(value = "排序")
	private Long sort;
   			    /**  是否删除0-否,1-是*/
	@ApiModelProperty(value = "是否删除0-否,1-是")
	private Long isDel;
   			    /**  创建时间*/
	@ApiModelProperty(value = "创建时间",example = "2016-11-07 05:20:54")
	private Date createTime;
   			    /**  创建人*/
	@ApiModelProperty(value = "创建人")
	private Long createBy;
   			    /**  创建人名称*/
	@ApiModelProperty(value = "创建人名称")
	private String createName;
   			    /**  更新时间*/
	@ApiModelProperty(value = "更新时间",example = "2016-11-07 05:20:54")
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
		this.id =id;
	}
		
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId =parentId;
	}
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =title;
	}
		
	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level =level;
	}
		
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort =sort;
	}
		
	public Long getIsDel() {
		return isDel;
	}

	public void setIsDel(Long isDel) {
		this.isDel =isDel;
	}
		
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime =createTime;
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
		
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime =updateTime;
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
	}
