/** 28-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.a2mee.FGTraceability.dto.RequestObj;
import com.a2mee.FGTraceability.dto.ResponceObj;
import com.a2mee.FGTraceability.dto.ResponceObjList;
import com.a2mee.FGTraceability.dto.UserPermissionDto;
import com.a2mee.FGTraceability.model.UserActivityLog;
import com.a2mee.FGTraceability.service.ActivityService;

/**
 * @author {Dattatray Bodhale}
 *
 * 28-Dec-2020
 */
@RestController
@RequestMapping("/activity")
@CrossOrigin
public class ActivityController {
	
	@Autowired
	ActivityService 	activityService;
	
	@RequestMapping(value = "/getActivityLogsByACtivity", method = RequestMethod.GET)
	public @ResponseBody ResponceObjList getActivityLogsByACtivity(@RequestParam("activity") String  activity) {
		ResponceObjList  responceObjList= new ResponceObjList();
		List<UserActivityLog> list= activityService.getActivityLogsByACtivity(activity);
		if(list.size()!=0){
			responceObjList.setCode(200);
			responceObjList.setMessage("Data Found Successfuly");
			responceObjList.setDatas(list);
		}else{
			responceObjList.setCode(500);
			responceObjList.setMessage("Data Not Found");
		}
		return responceObjList;
	}
	
	@RequestMapping(value = "/getActivityLogsByDate", method = RequestMethod.POST)
	public @ResponseBody ResponceObjList getActivityLogsByDate(@RequestBody RequestObj  requestObj) {
		ResponceObjList  responceObjList= new ResponceObjList();
		// String sDate1="31/12/1998";  
		System.out.println("DATE 111 :: "+requestObj.getDate());

		List<UserActivityLog> list= activityService.getActivityLogsByDate(requestObj.getDate());
		if(list.size()!=0){
			responceObjList.setCode(200);
			responceObjList.setMessage("Data Found Successfuly");
			responceObjList.setDatas(list);
		}else{
			responceObjList.setCode(500);
			responceObjList.setMessage("Data Not Found");
		}
			  
		return responceObjList;
	}
	
	@RequestMapping(value = "/getActivityLogsByUser", method = RequestMethod.GET)
	public @ResponseBody ResponceObjList getActivityLogsByUser(@RequestParam("userId") String  userId) {
		ResponceObjList  responceObjList= new ResponceObjList();
		// String sDate1="31/12/1998";  
		

		List<UserActivityLog> list= activityService.getActivityLogsByUser(userId);
		if(list.size()!=0){
			responceObjList.setCode(200);
			responceObjList.setMessage("Data Found Successfuly");
			responceObjList.setDatas(list);
		}else{
			responceObjList.setCode(500);
			responceObjList.setMessage("Data Not Found");
		}
			  
		return responceObjList;
	}
	
	@RequestMapping(value = "/getActivityLogsByShift", method = RequestMethod.GET)
	public @ResponseBody ResponceObjList getActivityLogsByShift(@RequestParam("shift") String  shift) {
		ResponceObjList  responceObjList= new ResponceObjList();
		List<UserActivityLog> list= activityService.getActivityLogsByShift(shift);
		if(list.size()!=0){
			responceObjList.setCode(200);
			responceObjList.setMessage("Data Found Successfuly");
			responceObjList.setDatas(list);
		}else{
			responceObjList.setCode(500);
			responceObjList.setMessage("Data Not Found");
		}
		return responceObjList;
	}
	

}
