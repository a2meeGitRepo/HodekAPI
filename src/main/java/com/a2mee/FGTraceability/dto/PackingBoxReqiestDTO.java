/** 08-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.dto;

import java.util.List;

import com.a2mee.FGTraceability.model.PackingBox;
import com.a2mee.FGTraceability.model.PackingBoxLayer;

/**
 * @author {Dattatray Bodhale}
 *
 * 08-Dec-2020
 */
public class PackingBoxReqiestDTO {
	private PackingBox packingBox;
	private List<PackingBoxLayer> boxLayers;
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
	 * @return the boxLayers
	 */
	public List<PackingBoxLayer> getBoxLayers() {
		return boxLayers;
	}
	/**
	 * @param boxLayers the boxLayers to set
	 */
	public void setBoxLayers(List<PackingBoxLayer> boxLayers) {
		this.boxLayers = boxLayers;
	}
	
	
	

}
