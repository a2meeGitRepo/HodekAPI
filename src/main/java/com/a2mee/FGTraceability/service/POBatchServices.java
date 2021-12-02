/** 18-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.List;

import com.a2mee.FGTraceability.model.Batch;
import com.a2mee.FGTraceability.model.PO;

/**
 * @author {Dattatray Bodhale}
 *
 * 16-Dec-2020
 */
public interface POBatchServices {

	/**
	 * Dattatray Bodhale
	 */
	List<PO> getAllPos();

	/**
	 * Dattatray Bodhale
	 */
	void addPO(PO po);

	/**
	 * Dattatray Bodhale
	 */
	List<Batch> getAllBatches();

	/**
	 * Dattatray Bodhale
	 */
	void addBatch(Batch batch);

	/**
	 * Dattatray Bodhale
	 */
	List<Batch> getActiveBatchesByPo(int poId);

	/**
	 * Dattatray Bodhale
	 */
	List<PO> getAllActivePos();

	/**
	 * Dattatray Bodhale
	 */
	List<Batch> getAllBatchesByPo(int poId);

	PO getPobyPOId(int poId);

	Batch getActiveBatch();

}
