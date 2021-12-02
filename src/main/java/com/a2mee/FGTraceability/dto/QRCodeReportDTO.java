package com.a2mee.FGTraceability.dto;

import com.a2mee.FGTraceability.model.ComponentMst;

public class QRCodeReportDTO {
	private String componentCode;
	private String componentname;
	private String shift;
	private String generatedBy;
	private int count;
	private int packedCount;
	
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getGeneratedBy() {
		return generatedBy;
	}
	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPackedCount() {
		return packedCount;
	}
	public void setPackedCount(int packedCount) {
		this.packedCount = packedCount;
	}
	public String getComponentCode() {
		return componentCode;
	}
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}
	public String getComponentname() {
		return componentname;
	}
	public void setComponentname(String componentname) {
		this.componentname = componentname;
	}
	
	
	
	

}
