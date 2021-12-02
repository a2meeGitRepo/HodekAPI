/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.controller;

import java.text.Collator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.swing.BoxLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.a2mee.FGTraceability.access.model.UserDetails;
import com.a2mee.FGTraceability.dto.BoxCell;
import com.a2mee.FGTraceability.dto.ComponentPackedDto;
import com.a2mee.FGTraceability.dto.PackedQrCodeDto;
//import com.a2mee.FGTraceability.dto.PackedQrCodeReport;
import com.a2mee.FGTraceability.dto.PackedQrCodeReportDto;
import com.a2mee.FGTraceability.dto.PackedQrCodeReportFor;
import com.a2mee.FGTraceability.dto.QrCodePackingIdDTO;
import com.a2mee.FGTraceability.dto.ResponceDTO;
import com.a2mee.FGTraceability.dto.ResponceObj;
import com.a2mee.FGTraceability.model.BoxQRCode;
import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.model.PackedQRCode;
import com.a2mee.FGTraceability.model.PackingBox;
import com.a2mee.FGTraceability.model.PackingBoxLayer;
import com.a2mee.FGTraceability.model.PackingTr;
import com.a2mee.FGTraceability.model.QRCodeTransaction;
import com.a2mee.FGTraceability.model.UserActivityLog;
import com.a2mee.FGTraceability.service.AccessService;
import com.a2mee.FGTraceability.service.ComponentMstService;
import com.a2mee.FGTraceability.service.POBatchServices;
import com.a2mee.FGTraceability.service.PackingBoxService;
import com.a2mee.FGTraceability.service.PackingService;
import com.a2mee.FGTraceability.service.QRCodeGeneratorService;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
@RestController
@RequestMapping("/packing")
@CrossOrigin("*")
public class PackingController {
	
	@Autowired
	PackingService packingService;

	@Autowired
	AccessService accessService;
	
	@Autowired
	POBatchServices pOBatchServices;
	
	
	@Autowired
	PackingBoxService packingBoxService;
	@Autowired
	QRCodeGeneratorService qRCodeGeneratorService;
	
	@Autowired
	ComponentMstService componentService;
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get ALL Packing  List
	 * 10-Dec-2020
	 *  
	 */
	
	@RequestMapping(value = "/getPackedSerialNo", method = RequestMethod.GET)
	public @ResponseBody String getPackedSerialNo (@RequestParam("packingId") int packingId) {
		String qrcodes="";
		List<PackedQRCode> list= packingService.getPackedQrCodeByPackingId(packingId);

		PackingTr packingTr= packingService.getPackingTrById(packingId);
		if (packingTr.getComponentMst().getQrType().equalsIgnoreCase("fixed")) {
			qrcodes=packingTr.getComponentMst().getConstantQrCode();
		}else{
			
			for(PackedQRCode code:list){
				if(qrcodes==""){
					qrcodes=code.getQrCode();
				}else{
					qrcodes+=" , "+code.getQrCode();
				}
				
			}
			
		}
		return qrcodes ;
	}
	
	@RequestMapping(value = "/getQRCodeLenth", method = RequestMethod.GET)
	public @ResponseBody int getQRCodeLenth(@RequestParam("comId") int comId) {
		//System.out.println("COMP  :::::::::::::::::::::::::;;  "+comId);
	ComponentMst componentMst=componentService.getComponentById(comId);
	int qrsize=componentMst.getConstantQrCode().length();

		return qrsize ;
	}
	
	@RequestMapping(value = "/getAllPackings", method = RequestMethod.GET)
	public @ResponseBody List<PackingTr> getAllPackings() {
		List<PackingTr> list = null;

		list = packingService.getAllPackings();

		return list ;
	}
	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Packing By Id
	 * 21-Dec-2020
	 *  
	 */
	
	
	@RequestMapping(value = "/getpackingById", method = RequestMethod.GET)
	public @ResponseBody PackingTr getpackingById(@RequestParam("packngId") int packngId) {
		PackingTr packingTr  = new PackingTr();

		packingTr = packingService.getPackingTrById(packngId);

		return packingTr ;
	}

	/**
	 * @author {Dattatray Bodhale}
	 *  name : Add packing
	 * 10-Dec-2020
	 *  
	 */
	
	@RequestMapping(value = "/addPacking", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO addComponent(@RequestBody PackingTr  packingTr) {
		ResponceDTO responceDTO= new ResponceDTO();
		//System.out.println("add packing ");
		try {
			String packingCode=packingService.getNewPackingCode();
			packingTr.setStatus("Initiated");;
			packingTr.setCreatedDate(new Date());;
			
			packingTr.setPackingCode(packingCode);
			packingTr.setPackingCode(packingCode);
			packingTr.setToalComponent(Double.valueOf(packingTr.getPackingBox().getBoxSize()) );
			double packeCom=0;
			packingTr.setPackedComponent(packeCom);
			
			packingService.savePacking(packingTr);
			
		
			responceDTO.setCode(200);
			responceDTO.setMessage("Component Added.....Successfully");
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}
	

	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get Component QR By QRCode
	 * 21-Dec-2020
	 *  
	 */

	@RequestMapping(value = "/getComponentQRByQRCode", method = RequestMethod.POST)
	public @ResponseBody ResponceObj getComponentQRByQRCode(@RequestBody QrCodePackingIdDTO qrCodePackingIdDTO ) {
		//System.out.println(" qrCode "+qrCode);
		String qrCode=qrCodePackingIdDTO.getQrCode();
		 int packingId=qrCodePackingIdDTO.getPackingId();
		ResponceObj responceObj= new ResponceObj();
		List<ComponentQRCode> list = packingService.getComponentQRByQRCode(qrCode);
		System.out.println(" list "+list.size());
		if(list.size()!=0){
			PackingTr  packingTr= packingService.getPackingTrById(packingId);
			if(packingTr.getComponentMst().equals(list.get(0).getComponentMst())){
				responceObj.setCode(200);
				responceObj.setMessage("Verified .........!!!!");
				responceObj.setData(list.get(0));
			}else{
				responceObj.setCode(500);
				responceObj.setMessage("Wrong Qr Code .........!!!!");
			}
			/*if(packingTr.getComponentMst().getQrType().equalsIgnoreCase("Variable") && packingTr.getComponentMst().getVariableType().equalsIgnoreCase("Date")){
				 String[] arrOfStr = qrCode.split("#T",2);
				 String[] arrOfbtch = arrOfStr[1].split("#V",2);
				 String batchNo= arrOfbtch[0].substring(8);
				 System.out.println("BATCH NO "+batchNo);
				if(!packingTr.getBatch().getBatchName().equalsIgnoreCase(batchNo)){
					responceObj.setCode(500);
					responceObj.setMessage("Invalid Batch");

				}else{
					
					
				}
				
				
			}*/
			
			
			
		}else{
			responceObj.setCode(500);
			responceObj.setMessage("No Data Found");
		}

		return responceObj ;
	}

	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get Packed  QR QRCode
	 * 21-Dec-2020
	 *  
	 */



	
	
	@RequestMapping(value = "/getpackingBoxDetailsByPackingId", method = RequestMethod.GET)
	public @ResponseBody ArrayList getpackingBoxDetailsByPackingId(@RequestParam("packngId") int packngId) {
		PackingTr packingTr  = new PackingTr();

		packingTr = packingService.getPackingTrById(packngId);
		PackingBox packingBox=packingTr.getPackingBox();
		//System.out.println("Packing Box :: "+packingBox.toString());
		List<PackingBoxLayer> boxLayers=packingBoxService.getlayersByPackingBox(packingBox.getPacking_box_id());
		ArrayList<Object> arrayList= new  ArrayList();
		
		for(int j=1; j<=boxLayers.size();j++){
		PackingBoxLayer boxLayer=boxLayers.get(j-1);
			ArrayList<Object> layers= new  ArrayList();
					for(int i=1;i<=boxLayer.getLayerSize();i++){
						
						BoxCell boxCell= new BoxCell();
					//	System.out.println("PACKING ID :: "+packngId+" BOx IS "+boxLayer.getBoxLayerId()+" BOX UNIT "+i);
						Optional<PackedQRCode> packedQRCode=packingService.getlayerUnitPackedQrCodeBy(packngId,boxLayer.getBoxLayerId(),i);
						boxCell.setLayerNo(j);
						boxCell.setLayerUnit(i);
						boxCell.setBoxLayerId(boxLayer.getBoxLayerId());
						if(packedQRCode.isPresent()){
							boxCell.setPackedStatus("Packed");
							boxCell.setAddedBit(1);
						}else{
							boxCell.setPackedStatus("");
							boxCell.setAddedBit(0);
						}
						layers.add(boxCell);
					}
				
					arrayList.add(layers);
			
		}

		return arrayList ;
	}

	/**
	 * @author {Dattatray Bodhale}
	 *  name : Add packing
	 * 10-Dec-2020
	 *  
	 */
	
	@RequestMapping(value = "/addPackedQrCode", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO addPackedQrCode(@RequestBody PackedQrCodeDto  packedQrCodeDto) {
		ResponceDTO responceDTO= new ResponceDTO();
		//System.out.println("add packing ");
		try {
			UserActivityLog  activityLog= new UserActivityLog();
			PackedQRCode code= new PackedQRCode();
			PackingTr packingTr= packingService.getPackingTrById(packedQrCodeDto.getPackingId());
			PackingBoxLayer  packingBoxLayer=packingBoxService.getlayersByPackingBoxlayerId(packedQrCodeDto.getBoxLayerId());
			code.setLayerUnit(packedQrCodeDto.getLayerUnit());
			code.setPacked_by(packedQrCodeDto.getPacked_by());
			code.setPackedDate(packedQrCodeDto.getPackedDate());
			code.setPackingBoxLayer(packingBoxLayer);
			code.setPackingTr(packingTr);
			code.setQrCode(packedQrCodeDto.getQrCode());
			packingTr.setPackedComponent(packingTr.getPackedComponent()+1);
			if(Double.compare(packingTr.getPackedComponent(), packingTr.getToalComponent()) == 0){
				packingTr.setStatus("Completed");
				String packedShift=packingService.getShift();
				packingTr.setPackedDate(new Date());
				packingTr.setPackedShift(packedShift);
				UserDetails details= new UserDetails();
				details.setId(packedQrCodeDto.getPacked_by());
				packingTr.setPackedBy(details);
				
			}else{
				packingTr.setStatus("InProcess");
			}
		//	System.out.println("STATUS ::"+packingTr.getStatus());
			packingService.savePackedQr(code);
			packingService.savePacking(packingTr);
		List<ComponentQRCode> list =qRCodeGeneratorService.getUnPacckedComponentQRCodeByQRCode(code.getQrCode());
		if(list.size()!=0){
			ComponentQRCode code2= list.get(0);
			code2.setPackedStatus(1);
			code2.setPackedDaterime(new Date());
				qRCodeGeneratorService.saveComponentQR(code2);
		}
		
		
		activityLog.setActivity("Component Packed");
		activityLog.setActivityDateTime(new Date());
		activityLog.setPackingNo(packingTr.getPackingCode());
		activityLog.setUser_id(code.getPacked_by());
		UserDetails details= accessService.getUserDetailsBuId(code.getPacked_by());
		activityLog.setUserName(details.getFirstName()+"  "+details.getLastName());
		String shift=packingService.getShift();
	//	activityLog
		accessService.saveActivityLog(activityLog);
			responceDTO.setCode(200);
			responceDTO.setMessage("Component Added.....Successfully");
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}
	@RequestMapping(value = "/addBoxQR", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addBoxQR(@RequestBody BoxQRCode boxqrCode) {
		ResponceDTO responceDTO= new ResponceDTO();
		//System.out.println("add packing ");
		try {
			UserActivityLog activityLog= new  UserActivityLog();
			
			Date date = Calendar.getInstance().getTime();  
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
			String strDate = dateFormat.format(date);  
			System.out.println("USER :: "+boxqrCode.getGenerated_by());
			UserDetails details= accessService.getUserDetailsBuId(boxqrCode.getGenerated_by());
			String shift=packingService.getShift();
			String qrcodes="";
	
			List<PackedQRCode> list= packingService.getPackedQrCodeByPackingId(boxqrCode.getPacking().getPackingId());

			PackingTr packingTr= packingService.getPackingTrById(boxqrCode.getPacking().getPackingId());
			if (packingTr.getComponentMst().getQrType().equalsIgnoreCase("fixed")) {
				qrcodes=packingTr.getComponentMst().getConstantQrCode();
			}else{
				System.out.println("SIZE OF PACKED COM "+list.size());
				for(PackedQRCode code:list){
					if(qrcodes==""){
						qrcodes=code.getQrCode();
					}else{
						qrcodes+=" , "+code.getQrCode();
					}
					
				}
				
			}
			
			String packingno=boxqrCode.getPacking().getPackingCode();
			String component=boxqrCode.getPacking().getComponentMst().getPartNo()+"  "+boxqrCode.getPacking().getComponentMst().getComponentName();
			int quantity=boxqrCode.getPacking().getPackingBox().getBoxSize();
			int layers=boxqrCode.getPacking().getPackingBox().getBoxLayer();
			String operator=details.getFirstName()+" "+details.getLastName();
			String format=boxqrCode.getPacking().getComponentMst().getFormat();
			String barcodeType=boxqrCode.getPacking().getComponentMst().getQrType();
			System.out.println("shift: "+shift);
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			Date datetime = new Date();
   		String newBoxQRCode ="Packing No :"+packingno+" , Component :"+component+" , Quantity : "+quantity+" , Layers : "+layers+" , Barcode Type : "+barcodeType+" ,  Operator : "+operator+" , Date : "+strDate+" , Time : "+formatter.format(date)+" , Barcode Type : "+format+" , Barcodes :: "+qrcodes;
   		
   		System.out.println("BOX CODE :: "+newBoxQRCode);
   		
   		boxqrCode.setBoxQr(newBoxQRCode);
   		packingService.saveBoxQrCode(boxqrCode);

		activityLog.setActivity("BOX QR  Createted");
		activityLog.setActivityDateTime(new Date());
		activityLog.setPackingNo(boxqrCode.getPacking().getPackingCode());
		activityLog.setUser_id(boxqrCode.getGenerated_by());
		activityLog.setUserName(details.getFirstName()+"  "+details.getLastName());
	//	activityLog
		accessService.saveActivityLog(activityLog);
			responceDTO.setCode(200);
			responceDTO.setMessage("Component Added.....Successfully");
			return newBoxQRCode;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			e.printStackTrace();
			return "";
			
		}
		
			
		}
	
	@RequestMapping(value = "/getBoxQRByPacking", method = RequestMethod.GET)
	public @ResponseBody BoxQRCode getPackedQrCode(@RequestParam("packngId") int packngId) {
		BoxQRCode boxQRCode= new BoxQRCode();
		boxQRCode=packingService.getBoxQRByPacking(packngId);

		return boxQRCode ;
	}
	
	/*************************************Dash Board packed component data***************************************/
	@RequestMapping(value = "/dashBoardPackedComponentData", method = RequestMethod.GET)
	public @ResponseBody List<ComponentPackedDto> getPackedComponentCount() {
		List<ComponentPackedDto> componentPackedDto=new ArrayList<ComponentPackedDto>();
		try {
			List<ComponentMst> list=componentService.getAllActiveComponents();
			for(ComponentMst component:list){
				int  total_PackingTr=packingService.getPackingTrByCompId(component.getComponentId());
				int todays_total_PackingTr=packingService.getPackingTrByCompId(component.getComponentId(),new Date());
				ComponentPackedDto packedDto=new ComponentPackedDto();
				packedDto.setTodays_total_packed(todays_total_PackingTr);
				packedDto.setTotal_packed_comp(total_PackingTr);
				packedDto.setCompponent(component);
				
				componentPackedDto.add(packedDto);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}		
		return componentPackedDto;
	}
	
	/********************************REport for packed QR code***********************************************/
	@RequestMapping(value = "/reportForPackedQRCOde", method = RequestMethod.POST)
	public @ResponseBody List<PackedQrCodeReportDto> getPackedQrCodeReport(@RequestBody PackedQrCodeReportFor packedQrCodeReportFor) {
		
		List<PackedQrCodeReportDto> codeReportDtos=new ArrayList<PackedQrCodeReportDto>();
		try {
			//System.out.println("dto for:"+packedQrCodeReportFor.getForDate()+" name :"+packedQrCodeReportFor.getUserDetails().getFirstName());
			List<PackingTr> packingTr=packingService.getPackingTrByDateAndUserId(packedQrCodeReportFor.getUserDetails().getId(),packedQrCodeReportFor.getForDate());
			
			for(PackingTr packingTr2:packingTr) {
				
				PackedQrCodeReportDto codeReportDto=new PackedQrCodeReportDto();
				codeReportDto.setComponent_name(packingTr2.getComponentMst().getComponentName());
				codeReportDto.setComponent_code(packingTr2.getComponentMst().getPartNo());
				codeReportDto.setPacking_code(packingTr2.getPackingCode());
				codeReportDto.setPacking_date(packingTr2.getPackedDate());
				codeReportDto.setPacking_id(packingTr2.getPackingId());
				codeReportDto.setFname(packingTr2.getPackedBy().getFirstName());
				codeReportDto.setLname(packingTr2.getPackedBy().getLastName());
				
				
				codeReportDtos.add(codeReportDto);
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return codeReportDtos;
	}
	
	
}
