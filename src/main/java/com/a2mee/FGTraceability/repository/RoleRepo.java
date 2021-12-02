/** 03-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.access.model.Role;

/**
 * @author {Dattatray Bodhale}
 *
 * 03-Dec-2020
 */
public interface RoleRepo extends JpaRepository<Role, Integer> ,RoleCustomeRepo {

	/**
	 * Dattatray Bodhale
	 */
	@Query("from Role ")
	List<Role> getActiveRoleList();

	/**
	 * Dattatray Bodhale
	 */
	@Query("from Role r where r.roleId=?1 ")
	Role getRolesById(Integer roleId);

	/**
	 * Dattatray Bodhale
	 */


}
