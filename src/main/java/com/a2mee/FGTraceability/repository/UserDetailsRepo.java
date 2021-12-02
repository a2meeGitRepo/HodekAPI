/** 04-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.access.model.UserDetails;

/**
 * @author {Dattatray Bodhale}
 *
 * 04-Dec-2020
 */
public interface UserDetailsRepo  extends JpaRepository<UserDetails, Integer>,UserDetailsCustumeRepo{

	/**
	 * Dattatray Bodhale
	 */
	@Query("From UserDetails u where u.username=?1")
	Optional<UserDetails> findByUserName(String userName);

	/**
	 * Dattatray Bodhale
	 */
	@Query("From UserDetails u where u.id=?1")
	Optional<UserDetails> getUserById(String userId);
	
	@Query("select count(u)From UserDetails u where substr(u.id,1,3)=?1")
	long getCountBySubString(String contString);

	/**
	 * Dattatray Bodhale
	 */
	@Query("select  MAX(u.id) From UserDetails u where substr(u.id,1,3)=?1")
	String getMaxCodeBySubString(String contString);

	/**
	 * Dattatray Bodhale
	 */
	@Query("From UserDetails u where u.id=?1")
	Optional<UserDetails> getUserDetailsBuId(String userId);

	/**
	 * Dattatray Bodhale
	 */
	@Query("From UserDetails u where u.deletbit=0")
	List<UserDetails> getAllUser();

	/**
	 * Dattatray Bodhale
	 */
	@Query("From UserDetails u where u.id=?1")
	Optional<UserDetails> findAllById(String id);

	/**
	 * Dattatray Bodhale
	 */

	/**
	 * Dattatray Bodhale
	 */
}
