/** 22-Dec-2020
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

/**
 * @author {Dattatray Bodhale}
 *
 * 22-Dec-2020
 */
@Entity
@Table(name="tr_packed_qr_code")
public class PackedQRCode {
	
	@Id
	@GeneratedValue
	@Column(name = "packing_qr_code_id", unique = true, nullable = false)
	private int packingQrCodId;
	
	@ManyToOne
	@JoinColumn(name="box_layer_id")
	private PackingBoxLayer  packingBoxLayer;
	
	@Column(name="layer_unit")
	private int layerUnit;
	
	@ManyToOne
	@JoinColumn(name="packing_id")
	private PackingTr packingTr;
	
	
	
	@Column(name="qr_code")
	private String qrCode;
	
	
	
	@Column(name="packed_date")
	private Date packedDate;
	
	@Column(name="packed_by")
	private String packed_by;

	/**
	 * @return the packingQrCodId
	 */
	public int getPackingQrCodId() {
		return packingQrCodId;
	}

	/**
	 * @param packingQrCodId the packingQrCodId to set
	 */
	public void setPackingQrCodId(int packingQrCodId) {
		this.packingQrCodId = packingQrCodId;
	}

	/**
	 * @return the packingBoxLayer
	 */
	public PackingBoxLayer getPackingBoxLayer() {
		return packingBoxLayer;
	}

	/**
	 * @param packingBoxLayer the packingBoxLayer to set
	 */
	public void setPackingBoxLayer(PackingBoxLayer packingBoxLayer) {
		this.packingBoxLayer = packingBoxLayer;
	}

	/**
	 * @return the packingTr
	 */
	public PackingTr getPackingTr() {
		return packingTr;
	}

	/**
	 * @param packingTr the packingTr to set
	 */
	public void setPackingTr(PackingTr packingTr) {
		this.packingTr = packingTr;
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
	 * @return the packed_by
	 */
	public String getPacked_by() {
		return packed_by;
	}

	/**
	 * @param packed_by the packed_by to set
	 */
	public void setPacked_by(String packed_by) {
		this.packed_by = packed_by;
	}

	/**
	 * @return the layerUnit
	 */
	public int getLayerUnit() {
		return layerUnit;
	}

	/**
	 * @param layerUnit the layerUnit to set
	 */
	public void setLayerUnit(int layerUnit) {
		this.layerUnit = layerUnit;
	}


	
	
	
}
