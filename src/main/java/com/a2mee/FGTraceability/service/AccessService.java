/** 03-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.List;

import com.a2mee.FGTraceability.access.model.Permission;
import com.a2mee.FGTraceability.access.model.Role;
import com.a2mee.FGTraceability.access.model.UserDetails;
import com.a2mee.FGTraceability.dto.RoleDetailDto;
import com.a2mee.FGTraceability.dto.RoleDto;
import com.a2mee.FGTraceability.dto.UserPermissionDto;
import com.a2mee.FGTraceability.dto.UserRoleDto;
import com.a2mee.FGTraceability.model.UserActivityLog;

/**
 * @author {Dattatray Bodhale}
 *
 * 03-Dec-2020
 */
public interface AccessService {

	/**
	 * Dattatray Bodhale
	 */
	List<Role> getRoleList();

	/**
	 * Dattatray Bodhale
	 */
	UserDetails getUserByUserName(String userName);

	/**
	 * Dattatray Bodhale
	 */
	 UserPermissionDto getPermissionsByUser(String userId);

	/**
	 * Dattatray Bodhale
	 */
	UserDetails getUserById(String userId);

	/**
	 * Dattatray Bodhale
	 */
	void saveActivityLog(UserActivityLog activityLog);

	/**
	 * Dattatray Bodhale
	 */
	List<UserDetails> getAllUser();

	/**
	 * Dattatray Bodhale
	 */
	List<RoleDetailDto> getAllRoleDetails();

	/**
	 * Dattatray Bodhale
	 */
	List<Permission> getAllPermsisons();

	/**
	 * Dattatray Bodhale
	 */
	RoleDetailDto assignPermissions(RoleDetailDto rolesDetail);

	/**
	 * Dattatray Bodhale
	 */
	void updateUser(UserDetails user);

	/**
	 * Dattatray Bodhale
	 */
	void addUser(UserDetails user);

	/**
	 * Dattatray Bodhale
	 */
	String getMaxUserd();

	/**
	 * Dattatray Bodhale
	 */
	UserDetails getUserDetailsBuId(String userId);

	/**
	 * Dattatray Bodhale
	 */
	void delet(UserDetails userDetails);

	/**
	 * Dattatray Bodhale
	 */
	List<RoleDto> getAllRoles();

	/**
	 * Dattatray Bodhale
	 */
	UserRoleDto getUserDetailById(String id);

	/**
	 * Dattatray Bodhale
	 */
	UserDetails assignRoles(UserDetails userDetail);

	/**
	 * Dattatray Bodhale
	 */
	UserDetails deleteRoles(UserDetails userDetail);

	/**
	 * Dattatray Bodhale
	 */
	UserDetails getAllUserById(String userId);

	/**
	 * Dattatray Bodhale
	 */
	List<Role> getAllRolesById(String userId);

	/**
	 * Dattatray Bodhale
	 */
	Role setRoleStatus(Role role);

}
