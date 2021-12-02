/** 04-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.BoxQRCode;

/**
 * @author {Dattatray Bodhale}
 *
 * 04-Jan-2021
 */
public interface BoxQRCodeRepo extends JpaRepository<BoxQRCode, Integer> {

	/**
	 * Dattatray Bodhale
	 */
	@Query("from BoxQRCode b where b.packing.packingId=?1")
	Optional<BoxQRCode> getBoxQRByPacking(int packngId);

}
