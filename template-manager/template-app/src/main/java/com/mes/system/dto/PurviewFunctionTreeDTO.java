package com.mes.system.dto;

import java.util.List;
import java.util.Map;

public class PurviewFunctionTreeDTO {

	/**  菜单ID*/
	private Long menuId;

	/**  菜单名称*/
	private String menuName;

	/**  父菜单标识*/
	private Long parentMenuId;
	
	private Boolean checked;

	/**  用于存储菜单叶子节点下面的系统功能*/
	private List<Map<String, Object>> functions;;

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Long getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public List<Map<String, Object>> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Map<String, Object>> functions) {
		this.functions = functions;
	}

}
