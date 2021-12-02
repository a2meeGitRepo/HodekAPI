/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
public interface ComponentMstService {

	/**
	 * Dattatray Bodhale
	 */
	void addComponent(ComponentMst componentMst);

	/**
	 * Dattatray Bodhale
	 */
	List<ComponentMst> getAllComponents();

	/**
	 * Dattatray Bodhale
	 */
	List<ComponentQRCode> getQRCodeByTransactionNo(String transactionNo);

	/**
	 * Dattatray Bodhale
	 */
	ComponentMst getComponentById(int componentId);

	/**
	 * Dattatray Bodhale
	 */
	Optional<ComponentMst> checkPartNo(String string);

	/**
	 * Dattatray Bodhale
	 */
	List<ComponentQRCode> getPrintedQRCodeByTransactionNo(String transactionNo);

	/**
	 * Dattatray Bodhale
	 */
	Optional<ComponentMst> getComponentByCode(String constantQrCode);

	/**
	 * Dattatray Bodhale
	 */
	List<ComponentMst> getAllActiveComponents();

	int getPackedQRCodeByComponentQrId(int componentQrId);

	int getTodaysPackedQRCodeByComponentQrId(int componentQrId, Date date);

	List<ComponentQRCode> getAllComponentQRCode();

}
