/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.repository.ComponentMstRepo;
import com.a2mee.FGTraceability.repository.ComponentQRCodeRepo;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
@Transactional
@Service
public class ComponentMstServiceImpl implements ComponentMstService {

	
	@Autowired
	ComponentMstRepo componentMstRepo;
	
	@Autowired
	ComponentQRCodeRepo componentQRCodeRepo;
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ComponentMstService#addComponent(com.a2mee.FGTraceability.model.ComponentMst)
	 */
	@Override
	public void addComponent(ComponentMst componentMst) {
		// TODO Auto-generated method stub
		componentMstRepo.save(componentMst);
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ComponentMstService#getAllComponents()
	 */
	@Override
	public List<ComponentMst> getAllComponents() {
		// TODO Auto-generated method stub
		return componentMstRepo.getAllComponents();
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ComponentMstService#getQRCodeByPacking(int)
	 */
	@Override
	public List<ComponentQRCode> getQRCodeByTransactionNo(String transactionNo) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.getQRCodeByTransactionNo(transactionNo);
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ComponentMstService#getComponentById(int)
	 */
	@Override
	public ComponentMst getComponentById(int componentId) {
		// TODO Auto-generated method stub
		Optional<ComponentMst> optional=componentMstRepo.findById(componentId);
		return optional.isPresent()?optional.get():null;
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ComponentMstService#checkPartNo(java.lang.String)
	 */
	@Override
	public Optional<ComponentMst> checkPartNo(String string) {
		// TODO Auto-generated method stub
		Optional<ComponentMst> optional =componentMstRepo.checkPartNo(string);
		return optional;
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ComponentMstService#getPrintedQRCodeByTransactionNo(java.lang.String)
	 */
	@Override
	public List<ComponentQRCode> getPrintedQRCodeByTransactionNo(String transactionNo) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.getPrintedQRCodeByTransactionNo(transactionNo);
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ComponentMstService#getComponentByCode(java.lang.String)
	 */
	@Override
	public Optional<ComponentMst> getComponentByCode(String constantQrCode) {
		// TODO Auto-generated method stub
		return componentMstRepo.checkPartNo(constantQrCode);
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.ComponentMstService#getAllActiveComponents()
	 */
	@Override
	public List<ComponentMst> getAllActiveComponents() {
		// TODO Auto-generated method stub
		return componentMstRepo.getAllActiveComponents();
	}
	@Override
	public int getPackedQRCodeByComponentQrId(int componentId) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.getPrintedQRCodeByComponentQrId(componentId);
	}
	@Override
	public int getTodaysPackedQRCodeByComponentQrId(int componentId, Date date) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.getTodaysPrintedQRCodeByComponentQrId(componentId,date);
	}
	@Override
	public List<ComponentQRCode> getAllComponentQRCode() {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.getAllComponentQRCode(); 
	}

}
