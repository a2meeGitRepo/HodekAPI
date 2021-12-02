/** 08-Dec-2020
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
 * 08-Dec-2020
 */
@Entity
@Table(name="mst_box_layer")
public class PackingBoxLayer {
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "box_layer_id", unique = true, nullable = false)
	private int boxLayerId;
	
	@ManyToOne
	@JoinColumn(name="packing_box_id")
	private PackingBox packingBox;
	
	@Column(name="layer_no")
	private String layerNo;
	

	@Column(name="layer_name")
	private String layerName;
	
	

	@Column(name="layer_size")
	private double layerSize;
	
	
	@Column(name="active")
	private int active;
	
	
	
	@Column(name="delet")
	private int delet;
	
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="added_by")
	private String addedBy;
	
	@Column(name="upd_datetime")
	private Date updDatetime;

	/**
	 * @return the boxLayerId
	 */
	public int getBoxLayerId() {
		return boxLayerId;
	}

	/**
	 * @param boxLayerId the boxLayerId to set
	 */
	public void setBoxLayerId(int boxLayerId) {
		this.boxLayerId = boxLayerId;
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
	 * @return the layerNo
	 */
	public String getLayerNo() {
		return layerNo;
	}

	/**
	 * @param layerNo the layerNo to set
	 */
	public void setLayerNo(String layerNo) {
		this.layerNo = layerNo;
	}

	/**
	 * @return the layerName
	 */
	public String getLayerName() {
		return layerName;
	}

	/**
	 * @param layerName the layerName to set
	 */
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	/**
	 * @return the layerSize
	 */
	public double getLayerSize() {
		return layerSize;
	}

	/**
	 * @param layerSize the layerSize to set
	 */
	public void setLayerSize(double layerSize) {
		this.layerSize = layerSize;
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
	 * @return the addedBy
	 */
	public String getAddedBy() {
		return addedBy;
	}

	/**
	 * @param addedBy the addedBy to set
	 */
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
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
	

}
