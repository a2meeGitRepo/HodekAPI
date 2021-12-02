/** 22-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.PackedQRCode;

/**
 * @author {Dattatray Bodhale}
 *
 * 22-Dec-2020
 */
public interface PackedQRCodeRepo extends JpaRepository<PackedQRCode, Integer>{

	/**
	 * Dattatray Bodhale
	 */
	@Query("from PackedQRCode p where p.packingTr.packingId=?1 and  p.packingBoxLayer.boxLayerId=?2")
	List<PackedQRCode> getPackedQrCode(int packngId, int boxLayerId);

	/**
	 * Dattatray Bodhale
	 */
	@Query("from PackedQRCode p where p.packingTr.packingId=?1 and  p.packingBoxLayer.boxLayerId=?2 and p.layerUnit=?3")

	Optional<PackedQRCode> getlayerUnitPackedQrCodeBy(int packngId, int boxLayerId, int layerUnit);
	
	@Query("from PackedQRCode p where p.packingTr.packingId=?1")
	List<PackedQRCode> getPackedQrCodeByPackingId(int packingId);

}
