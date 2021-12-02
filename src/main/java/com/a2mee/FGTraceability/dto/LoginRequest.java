/** 04-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.dto;

/**
 * @author {Dattatray Bodhale}
 *
 * 04-Dec-2020
 */
public class LoginRequest {
	
	
	private String userName;
	private String password;
	private String appName;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	
	
	

}
