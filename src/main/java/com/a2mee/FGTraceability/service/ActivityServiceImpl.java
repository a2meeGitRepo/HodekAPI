/** 28-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2mee.FGTraceability.model.UserActivityLog;
import com.a2mee.FGTraceability.repository.UserActivityLogRepo;

/**
 * @author {Dattatray Bodhale}
 *
 * 28-Dec-2020
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	UserActivityLogRepo userActivityLogRepo;

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ActivityService#getActivityLogsByACtivity(java.lang.String)
	 */
	@Override
	public List<UserActivityLog> getActivityLogsByACtivity(String activity) {
		// TODO Auto-generated method stub
		return userActivityLogRepo.getActivityLogsByACtivity(activity);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ActivityService#getActivityLogsByDate(java.util.Date)
	 */
	@Override
	public List<UserActivityLog> getActivityLogsByDate(Date activityDate) {
		// TODO Auto-generated method stub
		return userActivityLogRepo.getActivityLogsByDate(activityDate);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ActivityService#getActivityLogsByUser(java.lang.String)
	 */
	@Override
	public List<UserActivityLog> getActivityLogsByUser(String userId) {
		// TODO Auto-generated method stub
		return userActivityLogRepo.getActivityLogsByUser(userId);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ActivityService#getActivityLogsByShift(java.lang.String)
	 */
	@Override
	public List<UserActivityLog> getActivityLogsByShift(String shift) {
		
		String shitstr="";
		if(shift.equalsIgnoreCase("Shift 1")){
			shitstr="SHIFT 1 - 6:00 AM - 2:00 PM";
		}
		if(shift.equalsIgnoreCase("Shift 2")){
			shitstr="SHIFT 2 - 2:00 PM - 10:00 PM";
		}
		if(shift.equalsIgnoreCase("Shift 3")){
			shitstr="SHIFT 3 - 10:00 PM - 6:00 AM";
		}
		System.out.println("Shift ::"+shitstr);

		// TODO Auto-generated method stub
		return userActivityLogRepo.getActivityLogsByShift(shitstr);
	}

}
