/** 08-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.PackingBoxLayer;

/**
 * @author {Dattatray Bodhale}
 *
 * 08-Dec-2020
 */
public interface PackingBoxLayerRepo extends JpaRepository<PackingBoxLayer, Integer> {

	/**
	 * Dattatray Bodhale
	 */
	@Query("from PackingBoxLayer p where p.packingBox.packing_box_id=?1")
	List<PackingBoxLayer> getlayersByPackingBox(int packingBoxId);

}
