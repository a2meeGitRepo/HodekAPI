/** 08-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.List;
import java.util.Optional;

import com.a2mee.FGTraceability.dto.PackingBoxReqiestDTO;
import com.a2mee.FGTraceability.model.PackingBox;
import com.a2mee.FGTraceability.model.PackingBoxLayer;

/**
 * @author {Dattatray Bodhale}
 *
 * 08-Dec-2020
 */
public interface PackingBoxService {

	/**
	 * Dattatray Bodhale
	 */
	List<PackingBox> getAllPackingBoxes();

	/**
	 * Dattatray Bodhale
	 */
	PackingBox addPackingBox(PackingBox packingBox );

	/**
	 * Dattatray Bodhale
	 */
	void savepackingBoxLayer(PackingBoxLayer packingBoxLayer);

	/**
	 * Dattatray Bodhale
	 */
	List<PackingBoxLayer> getlayersByPackingBox(int packingBoxId);

	/**
	 * Dattatray Bodhale
	 */
	Optional<PackingBox> getPacckingBoxNyName(String string);

	/**
	 * Dattatray Bodhale
	 */
	PackingBoxLayer getlayersByPackingBoxlayerId(int boxLayerId);

	/**
	 * Dattatray Bodhale
	 */
	List<PackingBox> getAllActivePackingBoxes();

}
