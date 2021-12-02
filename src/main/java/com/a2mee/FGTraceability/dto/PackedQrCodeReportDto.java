/**
 * 
 */
package com.a2mee.FGTraceability.dto;

import java.util.Date;

/**
 * @author hp
 *
 */
public class PackedQrCodeReportDto {
	
	private int packing_id;
	private String component_name;
	private Date packing_date;
	private String component_code;
	private String packing_code;
	private String fname;
	private String lname;
	
	
	
	
	
	
	/**
	 * @return the packing_id
	 */
	
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the component_name
	 */
	public String getComponent_name() {
		return component_name;
	}
	/**
	 * @return the packing_id
	 */
	
	/**
	 * @param component_name the component_name to set
	 */
	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}
	/**
	 * @return the packing_id
	 */
	public int getPacking_id() {
		return packing_id;
	}

	/**
	 * @param packing_id the packing_id to set
	 */
	public void setPacking_id(int packing_id) {
		this.packing_id = packing_id;
	}

	/**
	 * @return the packing_date
	 */
	public Date getPacking_date() {
		return packing_date;
	}
	/**
	 * @param packing_date the packing_date to set
	 */
	public void setPacking_date(Date packing_date) {
		this.packing_date = packing_date;
	}
	/**
	 * @return the component_code
	 */
	public String getComponent_code() {
		return component_code;
	}
	/**
	 * @param component_code the component_code to set
	 */
	public void setComponent_code(String component_code) {
		this.component_code = component_code;
	}
	/**
	 * @return the packing_code
	 */
	public String getPacking_code() {
		return packing_code;
	}
	/**
	 * @param packing_code the packing_code to set
	 */
	public void setPacking_code(String packing_code) {
		this.packing_code = packing_code;
	}

	@Override
	public String toString() {
		return "PackedQrCodeReportDto [packing_id=" + packing_id + ", component_name=" + component_name
				+ ", packing_date=" + packing_date + ", component_code=" + component_code + ", packing_code="
				+ packing_code + ", fname=" + fname + ", lname=" + lname + ", getFname()=" + getFname()
				+ ", getLname()=" + getLname() + ", getComponent_name()=" + getComponent_name() + ", getPacking_id()="
				+ getPacking_id() + ", getPacking_date()=" + getPacking_date() + ", getComponent_code()="
				+ getComponent_code() + ", getPacking_code()=" + getPacking_code() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
