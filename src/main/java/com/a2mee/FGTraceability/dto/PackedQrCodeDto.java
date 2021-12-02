/** 04-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.dto;

import java.util.Date;

/**
 * @author {Dattatray Bodhale}
 *
 * 04-Jan-2021
 */
public class PackedQrCodeDto {
private int boxLayerId;
private int packingId;
private int layerUnit;
private String qrCode;
private String packed_by;
private Date packedDate;
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






}
