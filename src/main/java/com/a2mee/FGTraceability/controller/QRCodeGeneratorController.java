/** 15-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.a2mee.FGTraceability.access.model.UserDetails;
import com.a2mee.FGTraceability.dto.QRCodeTransactionRequest;
import com.a2mee.FGTraceability.dto.QrCodeCountByComponent;
import com.a2mee.FGTraceability.dto.ResponceDTO;
import com.a2mee.FGTraceability.model.Batch;
import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.model.PackingTr;
import com.a2mee.FGTraceability.model.QRCodeTransaction;
import com.a2mee.FGTraceability.model.UserActivityLog;
import com.a2mee.FGTraceability.service.AccessService;
import com.a2mee.FGTraceability.service.ComponentMstService;
import com.a2mee.FGTraceability.service.POBatchServices;
import com.a2mee.FGTraceability.service.PackingService;
import com.a2mee.FGTraceability.service.QRCodeGeneratorService;

/**
 * @author {Dattatray Bodhale}
 *
 * 15-Dec-2020
 */


@RestController
@RequestMapping("/qrCode")
@CrossOrigin("*")
public class QRCodeGeneratorController {
	@Autowired
	QRCodeGeneratorService qRCodeGeneratorService;
	@Autowired
	PackingService packingService;
	
	
	
	@Autowired
	AccessService accessService;
	
	@Autowired
	ComponentMstService componentService;
	@Autowired
	POBatchServices pOBatchServices;
	/**
	 * @author {Dattatray Bodhale}
	 *  name : Add QR Code transaction
	 * 10-Dec-2020
	 *  
	 */
	
	@RequestMapping(value = "/addQRCodeTransaction", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO addComponent(@RequestBody QRCodeTransactionRequest  qrCodeTransactionRequest) {
		ResponceDTO responceDTO= new ResponceDTO();
		String msg="";
		try {
			
			String transactionNo=qRCodeGeneratorService.getTransactionCode();
			UserDetails userDetails=qrCodeTransactionRequest.getGeneratedBy();
			QRCodeTransaction qrCodeTransaction = new QRCodeTransaction();
			qrCodeTransaction.setNoQfQr(qrCodeTransactionRequest.getQrCount());
			qrCodeTransaction.setTransactionDate(new Date());
			qrCodeTransaction.setTransactionNo(transactionNo);
			qrCodeTransaction.setTransactionBy(userDetails.getFirstName()+" "+userDetails.getLastName());
			qrCodeTransaction.setComponentMst(qrCodeTransactionRequest.getComponentMst());
			int getNoQfQr=0;
			
				for(int i = 1;i<=qrCodeTransaction.getNoQfQr();i++){
					getNoQfQr++;
					ComponentQRCode componentQRCode= new ComponentQRCode();
					componentQRCode.setActive(1);
					componentQRCode.setComponentMst(qrCodeTransaction.getComponentMst());
					componentQRCode.setDelet(0);
					componentQRCode.setGeneratedBy(userDetails.getId());
					componentQRCode.setGeneratedDatetime(new Date());
					
				
					//componentQRCode.setGeneratedBy(generatedBy);
					ComponentMst componentMst= componentService.getComponentById(qrCodeTransactionRequest.getComponentMst().getComponentId());
				//	System.out.println("QR TYPW ::  "+componentMst.getQrType());
					System.out.println("  componentMst.getVariant() "+qrCodeTransactionRequest.getVariant());
					if(componentMst.getQrType().equalsIgnoreCase("Fixed")){
						componentQRCode.setQrCode(componentMst.getConstantQrCode());
					}else if (componentMst.getQrType().equalsIgnoreCase("Custom Front")){
						componentQRCode.setQrCode(qrCodeTransactionRequest.getVariant()+""+qrCodeTransactionRequest.getComponentMst().getConstantQrCode());
					}
				else if (componentMst.getQrType().equalsIgnoreCase("Custom Back")){
					componentQRCode.setQrCode(qrCodeTransactionRequest.getComponentMst().getConstantQrCode()+""+qrCodeTransactionRequest.getVariant());
				}
					else{
						
						if(componentMst.getVariableType().equalsIgnoreCase("Date")){
							//componentQRCode.setQrCode(componentMst.getConstantQrCode()+"-"+i);
							
							 Date date = Calendar.getInstance().getTime();  
				                DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");  
				                String strDate = dateFormat.format(date);  
				                //System.out.println("  Date"+strDate);
				                
				          
							  String[] arrOfStr = componentMst.getConstantQrCode().split("#T", 2);
							  String aftDateStr=arrOfStr[1];
							  String[] arrOfbatc = aftDateStr.split("#V", 2);
							  	 System.out.println("OLD BATCH BI  "+arrOfbatc[0].substring(8));
							  	 System.out.println("aFTER v  "+arrOfbatc[1]);
							  	 Batch batch= new Batch();
							  	 try {
							  		batch = pOBatchServices.getActiveBatch();
								} catch (Exception e) {
									// TODO: handle exception
									msg="Please Check Btach";
									responceDTO.setCode(500);
									responceDTO.setMessage(msg);
									return responceDTO;
									
								}
							  	
							//  componentQRCode.setQrCode(arrOfStr[0]+"#T"+strDate+batch.getBatchName()+"#V"+arrOfbatc[1]); 
							  
							  	componentQRCode.setQrCode(arrOfStr[0]+"#T"+qrCodeTransactionRequest.getVariant()+"#V"+arrOfbatc[1]); 
							  
						}else{
							componentQRCode.setQrCode(componentMst.getConstantQrCode()+"-"+i);
						}
						
						
					}
					
					componentQRCode.setTransactionNo(transactionNo);
					componentQRCode.setPackedStatus(0);
					String shift=packingService.getShift();
					//System.out.println(" shift "+shift);
					componentQRCode.setGeneratedShift(shift);
					
					
					//UserDetails userDetails2= accessService.getUserById(packingTr.getUserId());
					qRCodeGeneratorService.saveComponentQR(componentQRCode);
					UserActivityLog activityLog= new UserActivityLog();
					activityLog.setActivity("QR Generated");
					activityLog.setActivityDateTime(new Date());
					activityLog.setActivityInShift(shift);
					activityLog.setPackingNo(transactionNo);
					activityLog.setQrCode(componentQRCode.getQrCode());
					activityLog.setUser_id(userDetails.getId());
					activityLog.setUserName(userDetails.getFirstName()+" "+userDetails.getLastName());
					accessService.saveActivityLog(activityLog);
				}
				
			
				
			
				qrCodeTransaction.setNoQfQr(getNoQfQr);
		
				qRCodeGeneratorService.saveQRCodeTransaction(qrCodeTransaction);
			responceDTO.setCode(200);
			responceDTO.setMessage("QR Code Generated .....Successfully");
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(msg);
			return responceDTO;
		}
		
			
		}
	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : Get All QR Code Transaction
	 * 10-Dec-2020
	 *  
	 */
	
	@RequestMapping(value = "/getAllQRCodeTransaction", method = RequestMethod.GET)
	public @ResponseBody List<QRCodeTransaction> getAllQRCodeTransaction() {
		
		List<QRCodeTransaction> returnlist = new ArrayList<QRCodeTransaction>();

		List<QRCodeTransaction> list  = qRCodeGeneratorService.getAllQRCodeTransaction();
		
		for(QRCodeTransaction transaction:list){
			int  prntedQRCount=qRCodeGeneratorService.getPrintQrCodeCount(transaction.getTransactionNo());
			System.out.println("PRINT COUNT :: "+prntedQRCount+"       "+transaction.getNoQfQr());
			if(transaction.getNoQfQr()>prntedQRCount){
				returnlist.add(transaction);
				System.out.println("PUSH "+transaction.getTransactionNo());
			}
		}

		return returnlist ;
	}
	
	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : Get QR By Packing
	 * 10-Dec-2020
	 */
	@RequestMapping(value = "/getQRCodeByTransactionNo", method = RequestMethod.GET)
	public @ResponseBody List<ComponentQRCode> getQRCodeByPacking(@RequestParam("transactionNo") String  transactionNo ) {
		List<ComponentQRCode> list1= new ArrayList<ComponentQRCode>();
			try {
				List<ComponentQRCode> list = componentService.getQRCodeByTransactionNo(transactionNo);
				for (ComponentQRCode componentQRCode:list){
					System.out.println("componentQRCode.getGeneratedBy() :: "+componentQRCode.getGeneratedBy());
					UserDetails details= accessService.getUserById(componentQRCode.getGeneratedBy());
					//System.out.println("details :: "+details);
					componentQRCode.setGeneratedBy(componentQRCode.getGeneratedBy());
					componentQRCode.setAddedBy(details.getFirstName()+"  "+details.getLastName());
					//componentQRCode.setGeneratedByUser(details);
					list1.add(componentQRCode);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		

		return list1 ;
	}
	
	
	
	@RequestMapping(value = "/getPrintedQRCodeByTransactionNo", method = RequestMethod.GET)
	public @ResponseBody List<ComponentQRCode> getPrintedQRCodeByTransactionNo(@RequestParam("transactionNo") String  transactionNo ) {
		List<ComponentQRCode> list = null;

		list = componentService.getPrintedQRCodeByTransactionNo(transactionNo);

		return list ;
	}
	@RequestMapping(value = "/savePrinttedComponent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO saveReprinttedComponent(@RequestBody List<ComponentQRCode>  list) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			
		
				for(int i = 1;i<=list.size();i++){
					
					ComponentQRCode componentQRCode= list.get(i-1);
					componentQRCode.setActive(1);
					
					String shift=packingService.getShift();
					
					componentQRCode.setPrintShift(shift);
					componentQRCode.setPrintBy(componentQRCode.getPrintBy());
					componentQRCode.setPrintDate(new Date());
					componentQRCode.setPrintStatus(1);
					//componentQRCode.pri
					//UserDetails userDetails2= accessService.getUserById(packingTr.getUserId());
					qRCodeGeneratorService.saveComponentQR(componentQRCode);
					UserActivityLog activityLog= new UserActivityLog();
					activityLog.setActivity("QR Printed");
					activityLog.setActivityDateTime(new Date());
					activityLog.setActivityInShift(shift);
					activityLog.setPackingNo(componentQRCode.getTransactionNo());
					activityLog.setQrCode(componentQRCode.getQrCode());
					activityLog.setUser_id(componentQRCode.getPrintBy());
					UserDetails userDetails=accessService.getUserById(componentQRCode.getPrintBy());
					activityLog.setUserName(userDetails.getFirstName()+" "+userDetails.getLastName());
					accessService.saveActivityLog(activityLog);
				}
				
			
				
			
				//qrCodeTransaction.setNoQfQr(getNoQfQr);
		
				//qRCodeGeneratorService.saveQRCodeTransaction(qrCodeTransaction);
			responceDTO.setCode(200);
			responceDTO.setMessage("QR Code Printed .....Successfully");
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}
	@RequestMapping(value = "/saveRePrinttedComponent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO saveRePrinttedComponent(@RequestBody List<ComponentQRCode>  list) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			
		
				for(int i = 1;i<=list.size();i++){
					
					ComponentQRCode componentQRCode= list.get(i-1);
					
					
					String shift=packingService.getShift();
					
					
					//componentQRCode.pri
					//UserDetails userDetails2= accessService.getUserById(packingTr.getUserId());
					//qRCodeGeneratorService.saveComponentQR(componentQRCode);
					//System.out.println("Save Activity ");
					UserActivityLog activityLog= new UserActivityLog();
					activityLog.setActivity("QR RePrinted");
					activityLog.setActivityDateTime(new Date());
					activityLog.setActivityInShift(shift);
					activityLog.setPackingNo(componentQRCode.getTransactionNo());
					activityLog.setQrCode(componentQRCode.getQrCode());
					activityLog.setUser_id(componentQRCode.getPrintBy());
					System.out.println("PRINTED BY "+componentQRCode.getPrintBy());
					UserDetails userDetails=accessService.getUserById(componentQRCode.getPrintBy());
					activityLog.setUserName(userDetails.getFirstName()+" "+userDetails.getLastName());
					accessService.saveActivityLog(activityLog);
				}
				
			
				
			
				//qrCodeTransaction.setNoQfQr(getNoQfQr);
		
				//qRCodeGeneratorService.saveQRCodeTransaction(qrCodeTransaction);
			responceDTO.setCode(200);
			responceDTO.setMessage("QR Code Printed .....Successfully");
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}
	
	
	/************************************QR codes count by Components******************************************/
	@RequestMapping(value = "/qRCodesCountByComponents", method = RequestMethod.GET)
	public @ResponseBody List<QrCodeCountByComponent> getQrCodeCountBy(){
		
		List<QrCodeCountByComponent> codeCountByComponents=new ArrayList<QrCodeCountByComponent>();
		try {
			List<ComponentMst> componentMst=componentService.getAllActiveComponents();
			
			for(ComponentMst componentMst1:componentMst) {
				int total_packed_comp_qrCode=componentService.getPackedQRCodeByComponentQrId(componentMst1.getComponentId());
				int todays_total_comp_qrCode=componentService.getTodaysPackedQRCodeByComponentQrId(componentMst1.getComponentId(),new Date());
				QrCodeCountByComponent byComponent=new QrCodeCountByComponent();
				byComponent.setCompponent(componentMst1);
				byComponent.setTotal_packed_comp_qrCode(total_packed_comp_qrCode);
				byComponent.setTodays_total_comp_qrCode(todays_total_comp_qrCode);
				
				
				codeCountByComponents.add(byComponent);
			}
			
			
		}catch(Exception e){ 
			
			e.printStackTrace();
		}
		
		return codeCountByComponents;
	}
	
	@RequestMapping(value = "/getShift", method = RequestMethod.GET)
	public ResponseEntity<String> getShift(){
		String shift=packingService.getShift();
		return new ResponseEntity< String>(shift,HttpStatus.OK);
	}
}
