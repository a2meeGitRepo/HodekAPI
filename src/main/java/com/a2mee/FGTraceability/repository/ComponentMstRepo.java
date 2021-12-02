/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.ComponentMst;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
public interface ComponentMstRepo extends JpaRepository<ComponentMst, Integer> {

	/**
	 * Dattatray Bodhale
	 */
	@Query("From ComponentMst c where c.partNo=?1 and c.delet=0")
	Optional<ComponentMst> checkPartNo(String string);

	/**
	 * Dattatray Bodhale
	 */
	@Query("From ComponentMst c where c.active=1 and c.delet=0")
	List<ComponentMst> getAllActiveComponents();

	/**
	 * Dattatray Bodhale
	 */
	@Query("From ComponentMst c where c.delet=0")
	List<ComponentMst> getAllComponents();

}
