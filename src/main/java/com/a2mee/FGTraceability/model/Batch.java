/** 18-Dec-2020
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

/**
 * @author {Dattatray Bodhale}
 *
 * 18-Dec-2020
 */
@Entity
@Table(name="mst_batch")
public class Batch {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "batch_id", unique = true, nullable = false)
	private int batchId;
	
	@Column(name="batch_name")
	private String batchName;
	
	@ManyToOne
	@JoinColumn(name="po_id")
	private PO po;
	
	
	@Column(name="batch_quant")
	private int batch_quant;
	
	@Column(name="rem_po_quant")
	private int rem_po_quant;

	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	
	
	@Column(name="active")
	private int active;



	/**
	 * @return the batchId
	 */
	public int getBatchId() {
		return batchId;
	}



	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}



	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}



	/**
	 * @param batchName the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}



	/**
	 * @return the po
	 */
	public PO getPo() {
		return po;
	}



	/**
	 * @param po the po to set
	 */
	public void setPo(PO po) {
		this.po = po;
	}



	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}



	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}



	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	 * @return the batch_quant
	 */
	public int getBatch_quant() {
		return batch_quant;
	}



	/**
	 * @param batch_quant the batch_quant to set
	 */
	public void setBatch_quant(int batch_quant) {
		this.batch_quant = batch_quant;
	}



	/**
	 * @return the rem_po_quant
	 */
	public int getRem_po_quant() {
		return rem_po_quant;
	}



	/**
	 * @param rem_po_quant the rem_po_quant to set
	 */
	public void setRem_po_quant(int rem_po_quant) {
		this.rem_po_quant = rem_po_quant;
	}

	
	
	
	

}
