/** 04-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.dto;

import com.a2mee.FGTraceability.access.model.UserDetails;

/**
 * @author {Dattatray Bodhale}
 *
 * 04-Dec-2020
 */
public class LoginResponce {
	
	private int code;
	private String message;
	private UserDetails data;
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
	 * @return the data
	 */
	public UserDetails getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(UserDetails data) {
		this.data = data;
	}
	
	
	
	

}
