/** 28-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.dto;

import java.util.List;

import com.a2mee.FGTraceability.model.UserActivityLog;

/**
 * @author {Dattatray Bodhale}
 *
 * 28-Dec-2020
 */
public class ResponceObjList {
	private int code;
	private String message;
	private List<UserActivityLog> datas;
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the datas
	 */
	public List<UserActivityLog> getDatas() {
		return datas;
	}
	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<UserActivityLog> datas) {
		this.datas = datas;
	}
	

	
	
	
	
	
}
