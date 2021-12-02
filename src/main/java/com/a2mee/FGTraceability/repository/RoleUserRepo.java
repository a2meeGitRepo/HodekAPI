/** 14-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.access.model.RoleUser;

/**
 * @author {Dattatray Bodhale}
 *
 * 14-Jan-2021
 */
public interface RoleUserRepo extends JpaRepository<RoleUser, Integer>{

	/**
	 * Dattatray Bodhale
	 */
	@Query("From RoleUser r where r.user_id=?1")
	List<RoleUser> getAllRolesById(String userId);

}
