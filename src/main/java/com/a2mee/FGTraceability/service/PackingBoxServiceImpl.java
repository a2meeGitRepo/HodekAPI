/** 08-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2mee.FGTraceability.dto.PackingBoxReqiestDTO;
import com.a2mee.FGTraceability.model.PackingBox;
import com.a2mee.FGTraceability.model.PackingBoxLayer;
import com.a2mee.FGTraceability.repository.PackingBoxLayerRepo;
import com.a2mee.FGTraceability.repository.PackingBoxRepo;

/**
 * @author {Dattatray Bodhale}
 *
 * 08-Dec-2020
 */
@Transactional
@Service
public class PackingBoxServiceImpl implements PackingBoxService {
	
	@Autowired
	PackingBoxRepo packingBoxRepo;
	@Autowired
	PackingBoxLayerRepo packingBoxLayerRepo;

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingBoxService#getAllPackingBoxes()
	 */
	@Override
	public List<PackingBox> getAllPackingBoxes() {
		// TODO Auto-generated method stub
		return packingBoxRepo.getAllPackingBoxes();
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingBoxService#addPackingBox(com.a2mee.FGTraceability.dto.PackingBoxReqiestDTO)
	 */
	@Override
	public PackingBox addPackingBox(PackingBox packingBox) {
		// TODO Auto-generated method stub
	
		return packingBoxRepo.save(packingBox);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingBoxService#savepackingBoxLayer(com.a2mee.FGTraceability.model.PackingBoxLayer)
	 */
	@Override
	public void savepackingBoxLayer(PackingBoxLayer packingBoxLayer) {
		// TODO Auto-generated method stub
		packingBoxLayerRepo.save(packingBoxLayer);	
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingBoxService#getlayersByPackingBox(int)
	 */
	@Override
	public List<PackingBoxLayer> getlayersByPackingBox(int packingBoxId) {
		// TODO Auto-generated method stub
		return packingBoxLayerRepo.getlayersByPackingBox(packingBoxId);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingBoxService#getPacckingBoxNyName(java.lang.String)
	 */
	@Override
	public Optional<PackingBox> getPacckingBoxNyName(String string) {
		// TODO Auto-generated method stub
		return packingBoxRepo.getPacckingBoxNyName(string);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingBoxService#getlayersByPackingBoxlayerId(int)
	 */
	@Override
	public PackingBoxLayer getlayersByPackingBoxlayerId(int boxLayerId) {
		// TODO Auto-generated method stub
		Optional<PackingBoxLayer> optional=packingBoxLayerRepo.findById(boxLayerId);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingBoxService#getAllActivePackingBoxes()
	 */
	@Override
	public List<PackingBox> getAllActivePackingBoxes() {
		// TODO Auto-generated method stub
		return packingBoxRepo.getAllActivePackingBoxes();
	}

}
