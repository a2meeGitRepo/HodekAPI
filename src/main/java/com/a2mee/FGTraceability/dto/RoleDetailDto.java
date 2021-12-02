package com.a2mee.FGTraceability.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class RoleDetailDto {
	
	int id;
	String roleName;
	boolean active;
	List<PermissionTypeDto> permission = new ArrayList<PermissionTypeDto>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PermissionTypeDto> getPermission() {
		return permission;
	}

	public void setPermission(List<PermissionTypeDto> permission) {
		this.permission = permission;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

}
