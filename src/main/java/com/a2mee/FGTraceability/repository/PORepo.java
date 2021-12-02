/** 18-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.PO;

/**
 * @author {Dattatray Bodhale}
 *
 * 16-Dec-2020
 */
public interface PORepo extends JpaRepository<PO, Integer>{

	/**
	 * Dattatray Bodhale
	 */
	@Query("From PO p where p.active=1")
	List<PO> getAllActivePos();

	@Query("From PO p where p.poId=?1")
	Optional<PO> getPobyPOId(int poId);
	
	
}
