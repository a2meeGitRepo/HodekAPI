package com.a2mee.FGTraceability.dto;

import com.a2mee.FGTraceability.model.ComponentMst;

public class ComponentPackedDto {
	
	private ComponentMst compponent;
	private int total_packed_comp;
	private int todays_total_packed;
	
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
	 * @return the total_packed_comp
	 */
	public int getTotal_packed_comp() {
		return total_packed_comp;
	}
	/**
	 * @param total_packed_comp the total_packed_comp to set
	 */
	public void setTotal_packed_comp(int total_packed_comp) {
		this.total_packed_comp = total_packed_comp;
	}
	/**
	 * @return the todays_total_packed
	 */
	public int getTodays_total_packed() {
		return todays_total_packed;
	}
	/**
	 * @param todays_total_packed the todays_total_packed to set
	 */
	public void setTodays_total_packed(int todays_total_packed) {
		this.todays_total_packed = todays_total_packed;
	}
	
	
	
	
	

}
