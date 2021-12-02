/** 30-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2mee.FGTraceability.dto.DashBoard;
import com.a2mee.FGTraceability.model.PackingTr;
import com.a2mee.FGTraceability.repository.ComponentQRCodeRepo;
import com.a2mee.FGTraceability.repository.PackingTrRepo;

/**
 * @author {Dattatray Bodhale}
 *
 * 30-Dec-2020
 */
@Transactional
@Service
public class DashBoardServiceImpl implements DashBoardService{

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.DashBoardService#getDashboardDate()
	 */
	
	@Autowired
	ComponentQRCodeRepo componentQRCodeRepo;
	@Autowired
	PackingTrRepo packingTrRepo;
	@Override
	public DashBoard getDashboardDate() {
		// TODO Auto-generated method stub
		DashBoard dashBoard= new DashBoard();
		Date today= new Date();
		System.out.println("today : "+today);
		int totalQRGenerated=(int) componentQRCodeRepo.getTotalQRCodeGenerated();
		int todayQRGenerated=(int) componentQRCodeRepo.getTodayQRCodeGenerated(today);
		int totalQRPrinted=(int) componentQRCodeRepo.getTotalQRCodePrinted();
		int todayQRPrinted=(int) componentQRCodeRepo.getTodayQRCodePrinted(today);
		
		
		
		int totalBoxPackeed=(int) packingTrRepo.getTotalCompletePacking();
		int totalBoxInProcess=(int) packingTrRepo.getTotalInProcessPacking();
		

		dashBoard.setTotalQRGenerated(totalQRGenerated);
		dashBoard.setTodayQRGenerated(todayQRGenerated);
		dashBoard.setTotalQRPrinted(totalQRPrinted);
		dashBoard.setTodayQRPrinted(todayQRPrinted);
		dashBoard.setTotalBoxPackeed(totalBoxPackeed);
		dashBoard.setTotalBoxInProcess(totalBoxInProcess);
		
		return dashBoard;
	}

}
