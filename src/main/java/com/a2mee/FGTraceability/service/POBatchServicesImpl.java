/** 18-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2mee.FGTraceability.model.Batch;
import com.a2mee.FGTraceability.model.PO;
import com.a2mee.FGTraceability.repository.BatchRepo;
import com.a2mee.FGTraceability.repository.PORepo;

/**
 * @author {Dattatray Bodhale}
 *
 * 16-Dec-2020
 */
@Transactional
@Service
public class POBatchServicesImpl  implements POBatchServices{
	@Autowired
	PORepo pORepo;
	
	@Autowired
	BatchRepo batchRepo;

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.POBatchServices#getAllPos()
	 */
	@Override
	public List<PO> getAllPos() {
		// TODO Auto-generated method stub
		return pORepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.POBatchServices#addPO(com.a2mee.FGTraceability.model.PO)
	 */
	@Override
	public void addPO(PO po) {
		// TODO Auto-generated method stub
		pORepo.save(po);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.POBatchServices#getAllBatches()
	 */
	@Override
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return batchRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.POBatchServices#addBatch(com.a2mee.FGTraceability.model.Batch)
	 */
	@Override
	public void addBatch(Batch batch) {
		// TODO Auto-generated method stub
		batchRepo.save(batch);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.POBatchServices#getActiveBatchesByPo(int)
	 */
	@Override
	public List<Batch> getActiveBatchesByPo(int poId) {
		// TODO Auto-generated method stub
		return batchRepo.getActiveBatchesByPo(poId);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.POBatchServices#getAllActivePos()
	 */
	@Override
	public List<PO> getAllActivePos() {
		// TODO Auto-generated method stub
		return pORepo.getAllActivePos();
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.POBatchServices#getAllBatchesByPo(int)
	 */
	@Override
	public List<Batch> getAllBatchesByPo(int poId) {
		// TODO Auto-generated method stub
		return batchRepo.getAllBatchesByPo(poId);
	}

	@Override
	public PO getPobyPOId(int poId) {
		// TODO Auto-generated method stub
		Optional<PO>optional=pORepo.getPobyPOId(poId);
		return optional.isPresent()?optional.get():null;
	}

	@Override
	public Batch getActiveBatch() {
		// TODO Auto-generated method stub
		Optional<Batch>optional=batchRepo.getActiveBatch();
		return optional.isPresent()?optional.get():null;
	}

}
