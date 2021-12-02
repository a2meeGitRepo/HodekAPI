package com.a2mee.FGTraceability.dto;

import java.util.Date;

import com.a2mee.FGTraceability.access.model.UserDetails;

public class PackedQrCodeReportFor {
	
	private UserDetails userDetails;
	private Date forDate;
	/**
	 * @return the userDetails
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}
	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	/**
	 * @return the forDate
	 */
	public Date getForDate() {
		return forDate;
	}
	/**
	 * @param forDate the forDate to set
	 */
	public void setForDate(Date forDate) {
		this.forDate = forDate;
	}
	@Override
	public String toString() {
		return "PackedQrCodeReportFor [userDetails=" + userDetails + ", forDate=" + forDate + ", getUserDetails()="
				+ getUserDetails() + ", getForDate()=" + getForDate() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
