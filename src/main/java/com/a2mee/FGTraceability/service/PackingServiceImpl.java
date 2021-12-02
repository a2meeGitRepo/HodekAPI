/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2mee.FGTraceability.model.BoxQRCode;
import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.model.PackedQRCode;
import com.a2mee.FGTraceability.model.PackingTr;
import com.a2mee.FGTraceability.repository.BoxQRCodeRepo;
import com.a2mee.FGTraceability.repository.ComponentQRCodeRepo;
import com.a2mee.FGTraceability.repository.PackedQRCodeRepo;
import com.a2mee.FGTraceability.repository.PackingTrRepo;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
@Transactional
@Service
public class PackingServiceImpl implements PackingService {
	@Autowired
	PackingTrRepo packingTrRepo;
	@Autowired
	ComponentQRCodeRepo componentQRCodeRepo;
	@Autowired
	PackedQRCodeRepo   packedQRCodeRepo;
	@Autowired
	BoxQRCodeRepo boxQRCodeRepo;
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#getAllPackings()
	 */
	@Override
	public List<PackingTr> getAllPackings() {
		// TODO Auto-generated method stub
		return packingTrRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#getNewPackingCode()
	 */
	@Override
	public String getNewPackingCode() {
		// TODO Auto-generated method stub
		try {
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
			  int count=(int) packingTrRepo.getCountBySubString(year+month);
			  String newCode="";
			  if(count==0){ 
				  newCode= "0001";
				}else{
					System.out.println("YEAR MONTH "+year+month);
					String maxCode=packingTrRepo.getMaxCodeBySubString(year+month);
					System.out.println("YEAR MONTH "+maxCode);
					//String maxCode= (String) entityManager.createQuery("select MAX(p.packingCode) from PackingTr p where substr(p.packingCode,1,4)=:grnNo").setParameter("packingCode", string).getSingleResult();
					String subCode="1"+maxCode.substring(4,8);
					int intCode=Integer.parseInt(subCode);
					intCode++;
					newCode=String.valueOf(intCode).substring(1,5);
					
				}
			 String packingCode=year+month+newCode;
					return packingCode;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	
				
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#savePacking(com.a2mee.FGTraceability.model.PackingTr)
	 */
	@Override
	public PackingTr savePacking(PackingTr packingTr) {
		// TODO Auto-generated method stub
		return packingTrRepo.save(packingTr);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#saveComponentQR(com.a2mee.FGTraceability.model.ComponentQRCode)
	 */
	@Override
	public void saveComponentQR(ComponentQRCode componentQRCode) {
		// TODO Auto-generated method stub
		componentQRCodeRepo.save(componentQRCode);
	}
	
	
	
	public  String getShift()  {
		String shift="";
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println(" SHIFY HOIR OF DAY :: "+hour);
		if(hour>=7.15 && hour<15.4){
			shift="SHIFT 1 - 7:15 AM - 3:45 PM";
			System.out.println("SHIFT 1");
		}else if(hour>=15.45 && hour<23.59){
			
			shift="SHIFT 2 - 3:45 PM - 12:00 AM";
			
			System.out.println("SHIFT 2");
			
		}else  if((hour>=24 && hour<=7.14) || (hour>1 && hour<6)){
			shift="SHIFT 3 - 12:00 AM - 7:15 AM";
			System.out.println("SHIFT 3");
		}
		   return shift;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#getComponentQRByQRCode(java.lang.String)
	 */
	@Override
	public List<ComponentQRCode> getComponentQRByQRCode(String qrCode) {
		// TODO Auto-generated method stub
		return componentQRCodeRepo.findByQrCode(qrCode);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#getPackingTrById(int)
	 */
	@Override
	public PackingTr getPackingTrById(int packingId) {
		// TODO Auto-generated method stub
		Optional<PackingTr> optional = packingTrRepo.findAllByPackingId(packingId);
		//System.out.println("PACKING TR is "+optional.isPresent());
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#getPackedQrCode(int, int)
	 */
	@Override
	public List<PackedQRCode> getPackedQrCode(int packngId, int boxLayerId) {
		// TODO Auto-generated method stub
		return packedQRCodeRepo.getPackedQrCode(packngId,boxLayerId);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#getBoxUnitPackedQrCodeBy(int, int, int)
	 */
	@Override
	public Optional<PackedQRCode> getlayerUnitPackedQrCodeBy(int packngId, int boxLayerId, int boxUnit) {
		// TODO Auto-generated method stub
		
		return packedQRCodeRepo.getlayerUnitPackedQrCodeBy(packngId,boxLayerId,boxUnit);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#savePackedQr(com.a2mee.FGTraceability.model.PackedQRCode)
	 */
	@Override
	public void savePackedQr(PackedQRCode code) {
		// TODO Auto-generated method stub
		packedQRCodeRepo.save(code);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#saveBoxQrCode(com.a2mee.FGTraceability.model.BoxQRCode)
	 */
	@Override
	public void saveBoxQrCode(BoxQRCode boxqrCode) {
		// TODO Auto-generated method stub
		boxQRCodeRepo.save(boxqrCode);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#getBoxQRByPacking(int)
	 */
	@Override
	public BoxQRCode getBoxQRByPacking(int packngId) {
		// TODO Auto-generated method stub
		Optional<BoxQRCode> optional= boxQRCodeRepo.getBoxQRByPacking(packngId);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.PackingService#getAllActivePackings()
	 */
	@Override
	public List<PackingTr> getAllActivePackings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPackingTrByCompId(int componentId) {
		// TODO Auto-generated method stub
		return packingTrRepo.getPackingTrByCompId(componentId);
	}

	@Override
	public int getPackingTrByCompId(int componentId, Date date) {
		// TODO Auto-generated method stub
		System.out.println(date);
		return packingTrRepo.getPackingTrByCompId(componentId,date);
	}

	@Override
	public List<PackingTr> getPackingTrByDateAndUserId(String id, Date forDate) {
		// TODO Auto-generated method stub
		return packingTrRepo.getPackingTrByDateAndUserId(id,forDate);
	}

	@Override
	public List<PackedQRCode> getPackedQrCodeByPackingId(int packingId) {
		// TODO Auto-generated method stub
		return packedQRCodeRepo.getPackedQrCodeByPackingId(packingId);
	}

	@Override
	public List<PackingTr> getPackingByDate(Date date) {
		// TODO Auto-generated method stub
		return packingTrRepo.getPackingByDate(date);
	}

	@Override
	public List<PackingTr> getPackingByDateAndComponent(Date date, ComponentMst componentMst) {
		// TODO Auto-generated method stub
		return packingTrRepo.getPackingByDateAndComponent(date,componentMst.getComponentId());
	}
	
}
