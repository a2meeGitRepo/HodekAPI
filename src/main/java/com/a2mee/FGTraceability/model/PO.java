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
@Table(name="mst_po")
public class PO {
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "po_id", unique = true, nullable = false)
	private int poId;
	
	@Column(name="po_no")
	private String poNo;
	
	
	@Column(name="po_date")
	private Date poDate;
	
	
	@Column(name="active")
	private int active;

	@Column(name="po_quantity")
	private int po_quantity;
	
	

	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	
	@ManyToOne
	@JoinColumn(name="component_id")
	private ComponentMst component;
	

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
	 * @return the poId
	 */
	public int getPoId() {
		return poId;
	}


	/**
	 * @param poId the poId to set
	 */
	public void setPoId(int poId) {
		this.poId = poId;
	}


	/**
	 * @return the poNo
	 */
	public String getPoNo() {
		return poNo;
	}


	/**
	 * @param poNo the poNo to set
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}




	/**
	 * @return the poDate
	 */
	public Date getPoDate() {
		return poDate;
	}


	/**
	 * @param poDate the poDate to set
	 */
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
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
	 * @return the po_quantity
	 */
	public int getPo_quantity() {
		return po_quantity;
	}


	/**
	 * @param po_quantity the po_quantity to set
	 */
	public void setPo_quantity(int po_quantity) {
		this.po_quantity = po_quantity;
	}


	/**
	 * @return the component
	 */
	public ComponentMst getComponent() {
		return component;
	}


	/**
	 * @param component the component to set
	 */
	public void setComponent(ComponentMst component) {
		this.component = component;
	}
	
	
	
}
