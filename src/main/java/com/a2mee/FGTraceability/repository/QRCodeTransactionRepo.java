/** 15-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.QRCodeTransaction;

/**
 * @author {Dattatray Bodhale}
 *
 * 15-Dec-2020
 */
public interface QRCodeTransactionRepo  extends JpaRepository<QRCodeTransaction, Integer>{

	/**
	 * Dattatray Bodhale
	 */
	
	@Query("SELECT count(q) FROM QRCodeTransaction q where  substr(q.transactionNo,1,4)=?1")
	int getCountBySubString(String string);

	/**
	 * Dattatray Bodhale
	 */
	@Query("SELECT  MAX(p.transactionNo)  FROM QRCodeTransaction p where  substr(p.transactionNo,1,4)=?1")
	String getMaxCodeBySubString(String string);

}
