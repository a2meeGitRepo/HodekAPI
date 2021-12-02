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
@Table(name="tr_packing")
public class PackingTr {
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "packing_id", unique = true, nullable = false)
	private int packingId;
	
	@Column(name="packing_code")
	private String packingCode;
	
	@ManyToOne
	@JoinColumn(name="component_id")
	private ComponentMst componentMst;
	
	@ManyToOne
	@JoinColumn(name="packing_box_id")
	private PackingBox packingBox;
	
	@ManyToOne
	@JoinColumn(name="po_id")
	private PO po;

	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
	
	@ManyToOne
	@JoinColumn(name="packed_by")
	private UserDetails packedBy;

	@Column(name="packed_shift")
	private String packedShift;

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
	 * @return the batch
	 */
	public Batch getBatch() {
		return batch;
	}

	/**
	 * @param batch the batch to set
	 */
	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Transient
	private String userId;
	
	
	
	@Column(name="toal_component")
	private Double toalComponent;
	
	@Column(name="packed_component")
	private Double packedComponent;
	

	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="status")
	private String status;

	
	@Column(name="packed_date")
	private Date packedDate;


	/**
	 * @return the packedDate
	 */
	public Date getPackedDate() {
		return packedDate;
	}

	/**
	 * @param packedDate the packedDate to set
	 */
	public void setPackedDate(Date packedDate) {
		this.packedDate = packedDate;
	}

	/**
	 * @return the packingId
	 */
	public int getPackingId() {
		return packingId;
	}

	/**
	 * @param packingId the packingId to set
	 */
	public void setPackingId(int packingId) {
		this.packingId = packingId;
	}

	/**
	 * @return the packingCode
	 */
	public String getPackingCode() {
		return packingCode;
	}

	/**
	 * @param packingCode the packingCode to set
	 */
	public void setPackingCode(String packingCode) {
		this.packingCode = packingCode;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the toalComponent
	 */
	public Double getToalComponent() {
		return toalComponent;
	}

	/**
	 * @param toalComponent the toalComponent to set
	 */
	public void setToalComponent(Double toalComponent) {
		this.toalComponent = toalComponent;
	}

	/**
	 * @return the packedComponent
	 */
	public Double getPackedComponent() {
		return packedComponent;
	}

	/**
	 * @param packedComponent the packedComponent to set
	 */
	public void setPackedComponent(Double packedComponent) {
		this.packedComponent = packedComponent;
	}

	/**
	 * @return the packedBy
	 */
	public UserDetails getPackedBy() {
		return packedBy;
	}

	/**
	 * @param packedBy the packedBy to set
	 */
	public void setPackedBy(UserDetails packedBy) {
		this.packedBy = packedBy;
	}

	public String getPackedShift() {
		return packedShift;
	}

	public void setPackedShift(String packedShift) {
		this.packedShift = packedShift;
	}
	
	
	
	
	

}
