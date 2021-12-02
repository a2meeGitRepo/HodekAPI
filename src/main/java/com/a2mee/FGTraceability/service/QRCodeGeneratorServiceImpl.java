/** 15-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.model.QRCodeTransaction;
import com.a2mee.FGTraceability.repository.ComponentQRCodeRepo;
import com.a2mee.FGTraceability.repository.QRCodeTransactionRepo;

/**
 * @author {Dattatray Bodhale}
 *
 * 15-Dec-2020
 */
@Transactional
@Service
public class QRCodeGeneratorServiceImpl implements QRCodeGeneratorService {

	
	@Autowired
	QRCodeTransactionRepo qRCodeTransactionRepo;
	@Autowired
	ComponentQRCodeRepo componentQRCodeRepo;
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.QRCodeGeneratorService#getTransactionCode()
	 */
	@Override
	public String getTransactionCode() {
		// TODO Auto-generated method stub
		 LocalDate currentdate = LocalDate.now();
		  int currentYear = currentdate.getYear();
		  int currentMonth=currentdate.getMonthValue();
		  String month; 
		  if(currentMonth<9){
			  month ="0"+Integer.toString(currentMonth);
		  }else{
			  month=Integer.toString(currentMonth);
		  }
		  String year=Integer.toString(currentYear).substring(2,4);
		//String maxCode=packingTrRepo.getNewPackingCode(year+month);
		  int count=(int) qRCodeTransactionRepo.getCountBySubString(year+month);
		  String newCode="";
		  if(count==0){ 
			  newCode= "0001";
			}else{
				String maxCode=qRCodeTransactionRepo.getMaxCodeBySubString(year+month);
				//String maxCode= (String) entityManager.createQuery("select MAX(p.packingCode) from PackingTr p where substr(p.packingCode,1,4)=:grnNo").setParameter("packingCode", string).getSingleResult();
				String subCode="1"+maxCode.substring(4,8);
				int intCode=Integer.parseInt(subCode);
				intCode++;
				newCode=String.valueOf(intCode).substring(1,5);
				
			}
		 String packingCode=year+month+newCode;
				return packingCode;
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.QRCodeGeneratorService#getAllQRCodeTransaction()
	 */
	@Override
	public List<QRCodeTransaction> getAllQRCodeTransaction() {
		// TODO Auto-generated method stub
		return qRCodeTransactionRepo.findAll();
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.QRCodeGeneratorService#saveQRCodeTransaction(com.a2mee.FGTraceability.model.QRCodeTransaction)
	 */
	@Override
	public void saveQRCodeTransaction(QRCodeTransaction qrCodeTransaction) {
		// TODO Auto-generated method stub
		
		qRCodeTransactionRepo.save(qrCodeTransaction);
		
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.QRCodeGeneratorService#saveComponentQR(com.a2mee.FGTraceability.model.ComponentQRCode)
	 */
	@Override
	public void saveComponentQR(ComponentQRCode componentQRCode) {
		// TODO Auto-generated method stub
		componentQRCodeRepo.save(componentQRCode);
	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.QRCodeGeneratorService#getUnPacckedComponentQRCodeByQRCode(java.lang.String)
	 */
	@Override
	public List<ComponentQRCode> getUnPacckedComponentQRCodeByQRCode(String qrCode) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.findByQrCode(qrCode);
	}
	@Override
	public List<ComponentQRCode> getComponentQRByDate(Date date) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.getComponentQRByDate(date);
	}
	@Override
	public List<ComponentQRCode> getComponentQRByDateAndComponent(Date date, ComponentMst componentMst) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.getComponentQRByDateAndComponent(date,componentMst.getPartNo());
	}
	@Override
	public int getPrintQrCodeCount(String transactionNo) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.getPrintQrCodeCount(transactionNo);
	}

}
