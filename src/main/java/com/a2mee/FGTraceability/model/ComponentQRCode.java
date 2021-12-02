/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a2mee.FGTraceability.access.model.UserDetails;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
@Entity
@Table(name="tr_component_qr")
public class ComponentQRCode {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "component_qr_id", unique = true, nullable = false)
	private int componentQrId;
	
	
	
	@ManyToOne
	@JoinColumn(name="packing_box_id")
	private PackingBox packingBox;
	
	
	@ManyToOne
	@JoinColumn(name="component_id")
	private ComponentMst componentMst;
	
	
	
	@Column(name="transaction_no")
	private String transactionNo;
	
	@Transient
	UserDetails generatedByUser;

	
	@Transient
	private String addedBy;
	


	/**
	 * @return the generatedByUser
	 */
	public UserDetails getGeneratedByUser() {
		return generatedByUser;
	}

	/**
	 * @param generatedByUser the generatedByUser to set
	 */
	public void setGeneratedByUser(UserDetails generatedByUser) {
		this.generatedByUser = generatedByUser;
	}

	/**
	 * @return the transactionNo
	 */
	public String getTransactionNo() {
		return transactionNo;
	}

	/**
	 * @param transactionNo the transactionNo to set
	 */
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	@Column(name="qr_code")
	private String qrCode;
	
	
	
	@Column(name="generated_datetime")
	private Date generatedDatetime;
	
	
	
	@Column(name="generated_by")
	private String generatedBy;
	
	
	@Column(name="print_by")
	private String printBy;
	
	
	@Column(name="print_date")
	private Date printDate;
	
	
	@Column(name="generated_shift")
	private String generatedShift;
	
	
	
	
	

	/**
	 * @return the componentQrId
	 */
	public int getComponentQrId() {
		return componentQrId;
	}

	/**
	 * @param componentQrId the componentQrId to set
	 */
	public void setComponentQrId(int componentQrId) {
		this.componentQrId = componentQrId;
	}

	/**
	 * @return the packingBox
	 */
	public PackingBox getPackingBox() {
		return packingBox;
	}

	/**
	 * @param packingBox the packingBox to set
	 */
	public void setPackingBox(PackingBox packingBox) {
		this.packingBox = packingBox;
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
	 * @return the qrCode
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * @param qrCode the qrCode to set
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	/**
	 * @return the generatedDatetime
	 */
	public Date getGeneratedDatetime() {
		return generatedDatetime;
	}

	/**
	 * @param generatedDatetime the generatedDatetime to set
	 */
	public void setGeneratedDatetime(Date generatedDatetime) {
		this.generatedDatetime = generatedDatetime;
	}

	/**
	 * @return the generatedBy
	 */
	public String getGeneratedBy() {
		return generatedBy;
	}

	/**
	 * @param generatedBy the generatedBy to set
	 */
	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}

	/**
	 * @return the printBy
	 */
	public String getPrintBy() {
		return printBy;
	}

	/**
	 * @param printBy the printBy to set
	 */
	public void setPrintBy(String printBy) {
		this.printBy = printBy;
	}

	/**
	 * @return the printDate
	 */
	public Date getPrintDate() {
		return printDate;
	}

	/**
	 * @param printDate the printDate to set
	 */
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	/**
	 * @return the generatedShift
	 */
	public String getGeneratedShift() {
		return generatedShift;
	}

	/**
	 * @param generatedShift the generatedShift to set
	 */
	public void setGeneratedShift(String generatedShift) {
		this.generatedShift = generatedShift;
	}

	/**
	 * @return the printShift
	 */
	public String getPrintShift() {
		return printShift;
	}

	/**
	 * @param printShift the printShift to set
	 */
	public void setPrintShift(String printShift) {
		this.printShift = printShift;
	}

	/**
	 * @return the packedStatus
	 */
	public int getPackedStatus() {
		return packedStatus;
	}

	/**
	 * @param packedStatus the packedStatus to set
	 */
	public void setPackedStatus(int packedStatus) {
		this.packedStatus = packedStatus;
	}

	/**
	 * @return the packedDaterime
	 */
	public Date getPackedDaterime() {
		return packedDaterime;
	}

	/**
	 * @param packedDaterime the packedDaterime to set
	 */
	public void setPackedDaterime(Date packedDaterime) {
		this.packedDaterime = packedDaterime;
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

	@Column(name="print_shift")
	private String printShift;
	
	
	@Column(name="packed_status")
	private int packedStatus;
	
	
	@Column(name="packed_daterime")
	private Date packedDaterime;
	
	@Column(name="active")
	private int active;
	
	@Column(name="delet")
	private int delet;
	
	
	@Column(name="print_status")
	private int printStatus;




	/**
	 * @return the printStatus
	 */
	public int getPrintStatus() {
		return printStatus;
	}

	/**
	 * @param printStatus the printStatus to set
	 */
	public void setPrintStatus(int printStatus) {
		this.printStatus = printStatus;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}



}
