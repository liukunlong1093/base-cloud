package com.mes.common.dto;

import java.util.*;
import com.mes.core.pojos.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.dto]    
  * 类名称:		[MsgTemplateDTO]  
  * 类描述:		[消息模板数据传输对象]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@ApiModel
public class MsgTemplateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**  主键*/
	@ApiModelProperty(value = "主键")
	private Long id;
	/**  模板编码*/
	@ApiModelProperty(value = "模板编码")
	private String code;
	/**  模板类型（1---邮件，2---短信，3---微信）*/
	@ApiModelProperty(value = "模板类型（1---邮件，2---短信，3---微信）")
	private Long type;
	/**  模板状态（0---启用，1---禁用）*/
	@ApiModelProperty(value = "模板状态（0---启用，1---禁用）")
	private Long status;
	/**  标题*/
	@ApiModelProperty(value = "标题")
	private String title;
	/**  模板内容*/
	@ApiModelProperty(value = "模板内容")
	private String content;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
