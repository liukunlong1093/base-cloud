package com.mes.pay.dto;

import java.util.*;
import com.mes.core.pojos.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
  * 项目名称:	[pay-app]
  * 包:	        [com.mes.pay.dto]    
  * 类名称:		[PaymentTypeDTO]  
  * 类描述:		[支付类型数据传输对象]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月25日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月25日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@ApiModel
public class PaymentTypeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**  支付类型标识*/
	@ApiModelProperty(value = "支付类型标识")
	private Long id;
	/**  */
	@ApiModelProperty(value = "")
	private String name;
	/**  0 PC,1手机*/
	@ApiModelProperty(value = "0 PC,1手机")
	private Long type;
	/**  是否隐藏*/
	@ApiModelProperty(value = "是否隐藏")
	private Long isHidden;
	/**  备注说明*/
	@ApiModelProperty(value = "备注说明")
	private String comment;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Long isHidden) {
		this.isHidden = isHidden;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
