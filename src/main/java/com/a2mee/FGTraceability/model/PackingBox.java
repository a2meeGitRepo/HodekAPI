/** 09-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author {Dattatray Bodhale}
 *
 * 09-Dec-2020
 */
@Entity
@Table(name="mst_packing_box")
public class PackingBox {
	@Id
	@GeneratedValue
	@Column(name = "packing_box_id", unique = true, nullable = false)
	private int packing_box_id;
	
	@Column(name="box_name")
	private String boxName;
	
	
	
	@Column(name="box_size")
	private int boxSize;
	
	@Column(name="box_layer")
	private int boxLayer;
	
	
	@Column(name="active")
	private int active;
	
	@Column(name="delet")
	private int delet;
	
	@Column(name="added_date")
	private Date addedDate;
	
	
	@Column(name="upd_datetime")
	private Date updDatetime;
	
	
	@Column(name="added_by")
	private String addedBy;


	/**
	 * @return the packing_box_id
	 */
	public int getPacking_box_id() {
		return packing_box_id;
	}


	/**
	 * @param packing_box_id the packing_box_id to set
	 */
	public void setPacking_box_id(int packing_box_id) {
		this.packing_box_id = packing_box_id;
	}


	/**
	 * @return the boxName
	 */
	public String getBoxName() {
		return boxName;
	}


	/**
	 * @param boxName the boxName to set
	 */
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}


	/**
	 * @return the boxSize
	 */
	public int getBoxSize() {
		return boxSize;
	}


	/**
	 * @param boxSize the boxSize to set
	 */
	public void setBoxSize(int boxSize) {
		this.boxSize = boxSize;
	}


	/**
	 * @return the boxLayer
	 */
	public int getBoxLayer() {
		return boxLayer;
	}


	/**
	 * @param boxLayer the boxLayer to set
	 */
	public void setBoxLayer(int boxLayer) {
		this.boxLayer = boxLayer;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackingBox [packing_box_id=" + packing_box_id + ", boxName=" + boxName + ", boxSize=" + boxSize
				+ ", boxLayer=" + boxLayer + ", active=" + active + ", delet=" + delet + ", addedDate=" + addedDate
				+ ", updDatetime=" + updDatetime + ", addedBy=" + addedBy + "]";
	}
	
	
	
}
