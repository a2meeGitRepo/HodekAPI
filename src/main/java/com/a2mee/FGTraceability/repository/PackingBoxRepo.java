/** 08-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.PackingBox;

/**
 * @author {Dattatray Bodhale}
 *
 * 08-Dec-2020
 */
public interface PackingBoxRepo extends JpaRepository<PackingBox, Integer>,PackingTrCustomeRepo {

	/**
	 * Dattatray Bodhale
	 */
	@Query("From PackingBox p where p.boxName=?1  and p.delet=0")
	Optional<PackingBox> getPacckingBoxNyName(String string);

	/**
	 * Dattatray Bodhale
	 */
	@Query("From PackingBox p where p.active=1 and p.delet=0")
	List<PackingBox> getAllActivePackingBoxes();

	/**
	 * Dattatray Bodhale
	 */
	@Query("From PackingBox p where p.delet=0")
	List<PackingBox> getAllPackingBoxes();

}
