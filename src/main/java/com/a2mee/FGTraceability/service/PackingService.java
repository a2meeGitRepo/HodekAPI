/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.a2mee.FGTraceability.model.BoxQRCode;
import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.model.PackedQRCode;
import com.a2mee.FGTraceability.model.PackingTr;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
public interface PackingService {

	/**
	 * Dattatray Bodhale
	 */
	List<PackingTr> getAllPackings();

	/**
	 * Dattatray Bodhale
	 */
	String getNewPackingCode();

	/**
	 * Dattatray Bodhale
	 * @return 
	 */
	PackingTr savePacking(PackingTr packingTr);

	/**
	 * Dattatray Bodhale
	 */
	void saveComponentQR(ComponentQRCode componentQRCode);
	 String getShift() ;

	/**
	 * Dattatray Bodhale
	 */
	List<ComponentQRCode> getComponentQRByQRCode(String qrCode);

	/**
	 * Dattatray Bodhale
	 */
	PackingTr getPackingTrById(int packingId);

	/**
	 * Dattatray Bodhale
	 */
	List<PackedQRCode> getPackedQrCode(int packngId, int boxLayerId);

	/**
	 * Dattatray Bodhale
	 */
	Optional<PackedQRCode> getlayerUnitPackedQrCodeBy(int packngId, int boxLayerId, int boxUnit);

	/**
	 * Dattatray Bodhale
	 */
	void savePackedQr(PackedQRCode code);

	/**
	 * Dattatray Bodhale
	 */
	void saveBoxQrCode(BoxQRCode boxqrCode);

	/**
	 * Dattatray Bodhale
	 */
	BoxQRCode getBoxQRByPacking(int packngId);

	/**
	 * Dattatray Bodhale
	 */
	List<PackingTr> getAllActivePackings();

	int getPackingTrByCompId(int componentId);

	int getPackingTrByCompId(int componentId, Date date);

	List<PackingTr> getPackingTrByDateAndUserId(String id, Date forDate);

	List<PackedQRCode> getPackedQrCodeByPackingId(int packingId);

	List<PackingTr> getPackingByDate(Date date);

	List<PackingTr> getPackingByDateAndComponent(Date date, ComponentMst componentMst);

}
