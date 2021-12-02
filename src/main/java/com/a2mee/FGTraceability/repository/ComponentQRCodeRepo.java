/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.ComponentQRCode;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
public interface ComponentQRCodeRepo extends JpaRepository<ComponentQRCode, Integer> {

	/**
	 * Dattatray Bodhale
	 */
	@Query("from  ComponentQRCode c where c.transactionNo=?1")
	List<ComponentQRCode> getQRCodeByTransactionNo(String transactionNo);

	/**
	 * Dattatray Bodhale
	 */
	@Query("from  ComponentQRCode c where c. packedStatus =0 and  c.qrCode=?1")
	List<ComponentQRCode> findByQrCode(String qrCode);

	/**
	 * Dattatray Bodhale
	 */
	@Query(" select count(c) from  ComponentQRCode c")
	long getTotalQRCodeGenerated();

	/**
	 * Dattatray Bodhale
	 */
	@Query(" select count(*)from  ComponentQRCode c where Date(c.generatedDatetime)=?1")
	int getTodayQRCodeGenerated(Date date);

	/**
	 * Dattatray Bodhale
	 */
	@Query(" select count(*)from  ComponentQRCode c where c.printStatus=1")
	int getTotalQRCodePrinted();

	/**
	 * Dattatray Bodhale
	 */
	@Query(" select count(*)from  ComponentQRCode c where c.printStatus=1 and Date(c.printDate)=?1")
	int getTodayQRCodePrinted(Date date);

	/**
	 * Dattatray Bodhale
	 */
	@Query("from  ComponentQRCode c where c.transactionNo=?1 and c.printStatus=1")

	List<ComponentQRCode> getPrintedQRCodeByTransactionNo(String transactionNo);

	@Query("select count(*)from ComponentQRCode c where c.packedStatus=1 and  c.componentMst.componentId=?1")
	int getPrintedQRCodeByComponentQrId(int componentId);

	@Query(" select count(*)from  ComponentQRCode c where  c.packedStatus=1 and  c.componentMst.componentId=?1 and Date(c.packedDaterime)=?2")
	int getTodaysPrintedQRCodeByComponentQrId(int componentId, Date date);

	@Query("from  ComponentQRCode c where c.packedStatus=1")
	List<ComponentQRCode> getAllComponentQRCode();

	
	@Query("from  ComponentQRCode c where Date(c.generatedDatetime)=?1")
	List<ComponentQRCode> getComponentQRByDate(Date date);
	@Query("from  ComponentQRCode c where Date(c.generatedDatetime)=?1 and c.componentMst.partNo=?2")
	List<ComponentQRCode> getComponentQRByDateAndComponent(Date date, String partNo);
	
	@Query(" select count(*)from  ComponentQRCode c where  c.transactionNo=?1 and c.printStatus=1 ")
	int getPrintQrCodeCount(String transactionNo);
}
