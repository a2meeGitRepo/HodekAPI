/** 28-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.Date;
import java.util.List;

import com.a2mee.FGTraceability.model.UserActivityLog;

/**
 * @author {Dattatray Bodhale}
 *
 * 28-Dec-2020
 */
public interface ActivityService {

	/**
	 * Dattatray Bodhale
	 */
	List<UserActivityLog> getActivityLogsByACtivity(String activity);

	/**
	 * Dattatray Bodhale
	 */
	List<UserActivityLog> getActivityLogsByDate(Date activityDate);

	/**
	 * Dattatray Bodhale
	 */
	List<UserActivityLog> getActivityLogsByUser(String userId);

	/**
	 * Dattatray Bodhale
	 */
	List<UserActivityLog> getActivityLogsByShift(String shift);

}
