/** 15-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.dto;

import javax.persistence.Transient;

import com.a2mee.FGTraceability.access.model.UserDetails;
import com.a2mee.FGTraceability.model.ComponentMst;

/**
 * @author {Dattatray Bodhale}
 *
 * 15-Dec-2020
 */
public class QRCodeTransactionRequest {
	
	private ComponentMst componentMst;
	private int qrCount;
	private UserDetails generatedBy;
	
	@Transient
	private String variant;
	
	public String getVariant() {
		return variant;
	}


	public void setVariant(String variant) {
		this.variant = variant;
	}
	/**
	 * @return the componentMst
	 */
	public ComponentMst getComponentMst() {
		return componentMst;
	}
	/**
	 * @param componentMst the componentMst to set
	 */
	public void setComponentMst(ComponentMst componentMst) {
		this.componentMst = componentMst;
	}
	/**
	 * @return the qrCount
	 */
	public int getQrCount() {
		return qrCount;
	}
	/**
	 * @param qrCount the qrCount to set
	 */
	public void setQrCount(int qrCount) {
		this.qrCount = qrCount;
	}
	/**
	 * @return the generatedBy
	 */
	public UserDetails getGeneratedBy() {
		return generatedBy;
	}
	/**
	 * @param generatedBy the generatedBy to set
	 */
	public void setGeneratedBy(UserDetails generatedBy) {
		this.generatedBy = generatedBy;
	}

	
	

}
