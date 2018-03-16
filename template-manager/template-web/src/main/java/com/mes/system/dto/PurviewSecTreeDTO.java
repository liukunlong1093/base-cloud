package com.mes.system.dto;

/**
 * 
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.dto]    
  * 类名称:		[PurviewSecTreeDTO]  
  * 类描述:		[权限对象树数据传输对象]
  * 创建人:		[liukl]   
  * 创建时间:	[2017年8月21日 下午5:03:07]   
  * 修改人:		[liukl]   
  * 修改时间:	[2017年8月21日 下午5:03:07]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public class PurviewSecTreeDTO {

	/** 权限对象标识*/
	private String secId;

	/** 权限名称*/
	private String secName;

	/** 父权限对象标识*/
	private String parentSecId;

	private Boolean checked;

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

	public String getParentSecId() {
		return parentSecId;
	}

	public void setParentSecId(String parentSecId) {
		this.parentSecId = parentSecId;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	

}
