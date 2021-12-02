/** 04-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

/**
 * @author {Dattatray Bodhale}
 *
 * 04-Jan-2021
 */
@Entity
@Table(name="tr_box_qr")
public class BoxQRCode {
	@Id
	@GeneratedValue
	@Column(name="tr_box_qr_id")
	private int boxQrId;
	@ManyToOne
	@JoinColumn(name="packing_id")
	private PackingTr packing;
	
	@Column(name="box_qr")
	private String boxQr;
	
	@Column(name="generated_date_time")
	private Date generatedDateTime;
	
	
	@Column(name="generated_by")
	private String generated_by;


	/**
	 * @return the boxQrId
	 */
	public int getBoxQrId() {
		return boxQrId;
	}


	/**
	 * @param boxQrId the boxQrId to set
	 */
	public void setBoxQrId(int boxQrId) {
		this.boxQrId = boxQrId;
	}


	/**
	 * @return the packing
	 */
	public PackingTr getPacking() {
		return packing;
	}


	/**
	 * @param packing the packing to set
	 */
	public void setPacking(PackingTr packing) {
		this.packing = packing;
	}


	/**
	 * @return the boxQr
	 */
	public String getBoxQr() {
		return boxQr;
	}


	/**
	 * @param boxQr the boxQr to set
	 */
	public void setBoxQr(String boxQr) {
		this.boxQr = boxQr;
	}


	/**
	 * @return the generatedDateTime
	 */
	public Date getGeneratedDateTime() {
		return generatedDateTime;
	}


	/**
	 * @param generatedDateTime the generatedDateTime to set
	 */
	public void setGeneratedDateTime(Date generatedDateTime) {
		this.generatedDateTime = generatedDateTime;
	}


	/**
	 * @return the generated_by
	 */
	public String getGenerated_by() {
		return generated_by;
	}


	/**
	 * @param generated_by the generated_by to set
	 */
	public void setGenerated_by(String generated_by) {
		this.generated_by = generated_by;
	}
	
	
	
	
	
	
	

}
