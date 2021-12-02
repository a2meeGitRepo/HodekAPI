/** 15-Dec-2020
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

import com.a2mee.FGTraceability.access.model.UserDetails;

/**
 * @author {Dattatray Bodhale}
 *
 * 15-Dec-2020
 */
@Entity
@Table(name="tr_qr_code_transaction")
public class QRCodeTransaction {
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "transaction_id", unique = true, nullable = false)
	private int transactionId;
	
	@Column(name="transaction_no")
	private String transactionNo;
	
	@Column(name="transaction_date")
	private Date transactionDate;
	
	
	@ManyToOne
	@JoinColumn(name="component_id")
	private ComponentMst componentMst;
	
	@Column(name="transaction_by")
	private String transactionBy;
	
/*	
	@ManyToOne
	@JoinColumn(name="transaction_by")
	private UserDetails transactionBy;*/
	
	@Column(name="no_of_qr")
	private int noQfQr;

	/**
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	

	public String getTransactionBy() {
		return transactionBy;
	}

	public void setTransactionBy(String transactionBy) {
		this.transactionBy = transactionBy;
	}

	/**
	 * @return the noQfQr
	 */
	public int getNoQfQr() {
		return noQfQr;
	}

	/**
	 * @param noQfQr the noQfQr to set
	 */
	public void setNoQfQr(int noQfQr) {
		this.noQfQr = noQfQr;
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
	
	
	
	
	
	
	

}
