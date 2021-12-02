package com.a2mee.FGTraceability.dto;

import com.a2mee.FGTraceability.model.ComponentMst;

public class QrCodeCountByComponent {
	
	private ComponentMst compponent;
	private int total_packed_comp_qrCode;
	private int todays_total_comp_qrCode;
	
	
	/**
	 * @return the compponent
	 */
	public ComponentMst getCompponent() {
		return compponent;
	}
	/**
	 * @param compponent the compponent to set
	 */
	public void setCompponent(ComponentMst compponent) {
		this.compponent = compponent;
	}
	/**
	 * @return the total_packed_comp_qrCode
	 */
	public int getTotal_packed_comp_qrCode() {
		return total_packed_comp_qrCode;
	}
	/**
	 * @param total_packed_comp_qrCode the total_packed_comp_qrCode to set
	 */
	public void setTotal_packed_comp_qrCode(int total_packed_comp_qrCode) {
		this.total_packed_comp_qrCode = total_packed_comp_qrCode;
	}
	/**
	 * @return the todays_total_comp_qrCode
	 */
	public int getTodays_total_comp_qrCode() {
		return todays_total_comp_qrCode;
	}
	/**
	 * @param todays_total_comp_qrCode the todays_total_comp_qrCode to set
	 */
	public void setTodays_total_comp_qrCode(int todays_total_comp_qrCode) {
		this.todays_total_comp_qrCode = todays_total_comp_qrCode;
	}
	
	
	

}
