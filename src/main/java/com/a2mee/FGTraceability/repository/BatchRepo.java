/** 18-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.Batch;

/**
 * @author {Dattatray Bodhale}
 *
 * 16-Dec-2020
 */
public interface BatchRepo extends JpaRepository<Batch, Integer>{

	/**
	 * Dattatray Bodhale
	 */
	@Query("from Batch b where b.active=1 and b.po.poId=?1")
	List<Batch> getActiveBatchesByPo(int poId);

	/**
	 * Dattatray Bodhale
	 */
	@Query("from Batch b where   b.po.poId=?1")
	List<Batch> getAllBatchesByPo(int poId);
	@Query("from Batch b where b.active=1 ")
	Optional<Batch> getActiveBatch();

}
