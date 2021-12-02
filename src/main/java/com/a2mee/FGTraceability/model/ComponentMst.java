/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
@Entity
@Table(name="mst_component")
public class ComponentMst {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComponentMst [partNo=" + partNo + ", componentName=" + componentName + ", description=" + description
				+ ", printType=" + printType + ", qrType=" + qrType + ", constantQrCode=" + constantQrCode
				+ ", labelHeading=" + labelHeading + "]";
	}


	@Id
	@GeneratedValue
	@Column(name = "component_id")
	private int componentId;
	
	@Column(name="part_no")
	private String partNo;
	
	@Column(name="component_name")
	private String componentName;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="print_type")
	private String printType;
	
	@Column(name="qr_type")
	private String qrType;
	
	@Column(name="print_size")
	private String print_size;
	
	@Column(name="variable_type")
	private String variableType;
	
	@Column(name="format")
	private String format;
	
	


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	/**
	 * @return the variableType
	 */
	public String getVariableType() {
		return variableType;
	}


	/**
	 * @param variableType the variableType to set
	 */
	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}


	@Column(name="constant_qr_code")
	private String constantQrCode;
	@Column(name="label_heading")
	private String labelHeading;
	
	
	@Column(name="label_heading2")
	private String labelHeading2;
	



	public String getLabelHeading2() {
		return labelHeading2;
	}


	public void setLabelHeading2(String labelHeading2) {
		this.labelHeading2 = labelHeading2;
	}


	/**
	 * @return the labelHeading
	 */
	public String getLabelHeading() {
		return labelHeading;
	}


	/**
	 * @param labelHeading the labelHeading to set
	 */
	public void setLabelHeading(String labelHeading) {
		this.labelHeading = labelHeading;
	}


	/**
	 * @return the constantQrCode
	 */
	public String getConstantQrCode() {
		return constantQrCode;
	}


	/**
	 * @param constantQrCode the constantQrCode to set
	 */
	public void setConstantQrCode(String constantQrCode) {
		this.constantQrCode = constantQrCode;
	}


	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="added_by")
	private String addedby;
	
	@Column(name="upd_datetime")
	private Date updDatetime;
	
	
	
	@Column(name="active")
	private int active;
	
	
	@Column(name="delet")
	private int delet;


	/**
	 * @return the componentId
	 */
	public int getComponentId() {
		return componentId;
	}


	/**
	 * @param componentId the componentId to set
	 */
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}


	/**
	 * @return the partNo
	 */
	public String getPartNo() {
		return partNo;
	}


	/**
	 * @param partNo the partNo to set
	 */
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}


	/**
	 * @return the componentName
	 */
	public String getComponentName() {
		return componentName;
	}


	/**
	 * @param componentName the componentName to set
	 */
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}


	

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the printType
	 */
	public String getPrintType() {
		return printType;
	}


	/**
	 * @param printType the printType to set
	 */
	public void setPrintType(String printType) {
		this.printType = printType;
	}





	/**
	 * @return the qrType
	 */
	public String getQrType() {
		return qrType;
	}


	/**
	 * @param qrType the qrType to set
	 */
	public void setQrType(String qrType) {
		this.qrType = qrType;
	}


	/**
	 * @return the addedDate
	 */
	public Date getAddedDate() {
		return addedDate;
	}


	/**
	 * @param addedDate the addedDate to set
	 */
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}




	/**
	 * @return the addedby
	 */
	public String getAddedby() {
		return addedby;
	}


	/**
	 * @param addedby the addedby to set
	 */
	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}


	/**
	 * @return the updDatetime
	 */
	public Date getUpdDatetime() {
		return updDatetime;
	}


	/**
	 * @param updDatetime the updDatetime to set
	 */
	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}


	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}


	/**
	 * @return the delet
	 */
	public int getDelet() {
		return delet;
	}


	/**
	 * @param delet the delet to set
	 */
	public void setDelet(int delet) {
		this.delet = delet;
	}


	/**
	 * @return the print_size
	 */
	public String getPrint_size() {
		return print_size;
	}


	/**
	 * @param print_size the print_size to set
	 */
	public void setPrint_size(String print_size) {
		this.print_size = print_size;
	}




	
}
