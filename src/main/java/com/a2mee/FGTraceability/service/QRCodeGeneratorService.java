/** 15-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.Date;
import java.util.List;

import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.model.QRCodeTransaction;

/**
 * @author {Dattatray Bodhale}
 *
 * 15-Dec-2020
 */
public interface QRCodeGeneratorService {

	/**
	 * Dattatray Bodhale
	 */
	String getTransactionCode();

	/**
	 * Dattatray Bodhale
	 */
	List<QRCodeTransaction> getAllQRCodeTransaction();

	/**
	 * Dattatray Bodhale
	 */
	void saveQRCodeTransaction(QRCodeTransaction qrCodeTransaction);

	/**
	 * Dattatray Bodhale
	 */
	void saveComponentQR(ComponentQRCode componentQRCode);

	/**
	 * Dattatray Bodhale
	 */
	List<ComponentQRCode> getUnPacckedComponentQRCodeByQRCode(String qrCode);

	List<ComponentQRCode> getComponentQRByDate(Date date);

	List<ComponentQRCode> getComponentQRByDateAndComponent(Date date, ComponentMst componentMst);

	int getPrintQrCodeCount(String transactionNo);

}
