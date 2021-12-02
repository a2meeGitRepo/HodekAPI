/** 11-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.UserActivityLog;

/**
 * @author {Dattatray Bodhale}
 *
 * 11-Dec-2020
 */
public interface UserActivityLogRepo extends JpaRepository<UserActivityLog, Integer>{

	/**
	 * Dattatray Bodhale
	 */
	@Query("from UserActivityLog u where u.activity=?1")
	List<UserActivityLog> getActivityLogsByACtivity(String activity);

	/**
	 * Dattatray Bodhale
	 */
	@Query("from UserActivityLog u where Date(u.activityDateTime)=?1")
	List<UserActivityLog> getActivityLogsByDate(Date activityDate);

	/**
	 * Dattatray Bodhale
	 */
	@Query("from UserActivityLog u where u.user_id=?1")
	List<UserActivityLog> getActivityLogsByUser(String userId);

	/**
	 * Dattatray Bodhale
	 */
	@Query("from UserActivityLog u where u.activityInShift=?1")
	List<UserActivityLog> getActivityLogsByShift(String shitstr);

}
