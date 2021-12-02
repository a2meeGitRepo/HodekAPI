package com.a2mee.FGTraceability.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.a2mee.FGTraceability.access.model.UserDetails;
import com.a2mee.FGTraceability.dto.PackingBoxReqiestDTO;
import com.a2mee.FGTraceability.dto.QRCodeReportDTO;
import com.a2mee.FGTraceability.dto.RequestObj;
import com.a2mee.FGTraceability.dto.ResponceDTO;
import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.model.PackingBox;
import com.a2mee.FGTraceability.model.PackingBoxLayer;
import com.a2mee.FGTraceability.model.PackingTr;
import com.a2mee.FGTraceability.service.AccessService;
import com.a2mee.FGTraceability.service.PackingService;
import com.a2mee.FGTraceability.service.QRCodeGeneratorService;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {
	
	
	@Autowired
	QRCodeGeneratorService qRCodeGeneratorService;
	@Autowired
	AccessService accessService;
	
	@Autowired
	PackingService packingService;

	
	@RequestMapping(value = "/getQRCodeReport", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Set<QRCodeReportDTO> addPackingBox(@RequestBody RequestObj  requestObj) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			
			Set<QRCodeReportDTO> sets= new HashSet<QRCodeReportDTO>();

			List<ComponentQRCode> list = qRCodeGeneratorService.getComponentQRByDate(requestObj.getDate());
			Set<ComponentMst> comCodes=new HashSet<ComponentMst>();
			for(ComponentQRCode componentQRCode:list){
				comCodes.add(componentQRCode.getComponentMst());
			}
			for(ComponentMst componentMst:comCodes){
				//comCodes.add(componentQRCode.getComponentMst());
				
				List<ComponentQRCode> listByCom = qRCodeGeneratorService.getComponentQRByDateAndComponent(requestObj.getDate(),componentMst);
				QRCodeReportDTO codeReportDTO=new QRCodeReportDTO();
				codeReportDTO.setComponentCode(listByCom.get(0).getComponentMst().getPartNo());
				codeReportDTO.setComponentname(listByCom.get(0).getComponentMst().getComponentName());
				codeReportDTO.setCount(listByCom.size());
				codeReportDTO.setShift(listByCom.get(0).getGeneratedShift());
				UserDetails  details= accessService.getAllUserById(listByCom.get(0).getGeneratedBy());
				codeReportDTO.setGeneratedBy(details.getFirstName()+" "+details.getLastName());
				sets.add(codeReportDTO);
			}
			
			System.out.println("LOST SIZE :: "+list.size());
			System.out.println("SET SIZE :: "+comCodes.size());

			return sets;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return null;
		}
		
			
		}
	
	@RequestMapping(value = "/getPackingReport", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Set<QRCodeReportDTO> getPackingReport(@RequestBody RequestObj  requestObj) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			
			Set<QRCodeReportDTO> sets= new HashSet<QRCodeReportDTO>();

			List<PackingTr> list = packingService.getPackingByDate(requestObj.getDate());
			Set<ComponentMst> comCodes=new HashSet<ComponentMst>();
			for(PackingTr packingTr:list){
				comCodes.add(packingTr.getComponentMst());
			}
			for(ComponentMst componentMst:comCodes){
				//comCodes.add(componentQRCode.getComponentMst());
				
				List<PackingTr> listByCom = packingService.getPackingByDateAndComponent(requestObj.getDate(),componentMst);
				QRCodeReportDTO codeReportDTO=new QRCodeReportDTO();
				codeReportDTO.setComponentCode(listByCom.get(0).getComponentMst().getPartNo());
				codeReportDTO.setComponentname(listByCom.get(0).getComponentMst().getComponentName());
				codeReportDTO.setCount(listByCom.size());
				codeReportDTO.setShift(listByCom.get(0).getPackedShift());
				codeReportDTO.setGeneratedBy(listByCom.get(0).getPackedBy().getFirstName()+" "+listByCom.get(0).getPackedBy().getLastName());
				sets.add(codeReportDTO);
			}
			
			System.out.println("LOST SIZE :: "+list.size());
			System.out.println("SET SIZE :: "+comCodes.size());

			return sets;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return null;
		}
		
			
		}

}
