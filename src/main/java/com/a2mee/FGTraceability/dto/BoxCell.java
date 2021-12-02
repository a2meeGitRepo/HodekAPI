/** 03-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.dto;

/**
 * @author {Dattatray Bodhale}
 *
 * 03-Jan-2021
 */
public class BoxCell {
private String packedStatus;
private int layerNo;
private int layerUnit;
private int addedBit;
private int boxLayerId;;

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
 * @return the packedStatus
 */
public String getPackedStatus() {
	return packedStatus;
}

/**
 * @param packedStatus the packedStatus to set
 */
public void setPackedStatus(String packedStatus) {
	this.packedStatus = packedStatus;
}

/**
 * @return the layerNo
 */
public int getLayerNo() {
	return layerNo;
}

/**
 * @param layerNo the layerNo to set
 */
public void setLayerNo(int layerNo) {
	this.layerNo = layerNo;
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
 * @return the addedBit
 */
public int getAddedBit() {
	return addedBit;
}

/**
 * @param addedBit the addedBit to set
 */
public void setAddedBit(int addedBit) {
	this.addedBit = addedBit;
}




}
