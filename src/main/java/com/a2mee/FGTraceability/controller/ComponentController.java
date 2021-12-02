/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.a2mee.FGTraceability.dto.PackingBoxReqiestDTO;
import com.a2mee.FGTraceability.dto.ResponceDTO;
import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.ComponentQRCode;
import com.a2mee.FGTraceability.model.PackingBox;
import com.a2mee.FGTraceability.model.PackingBoxLayer;
import com.a2mee.FGTraceability.service.ComponentMstService;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
@RestController
@RequestMapping("/component")
@CrossOrigin("*")
public class ComponentController {
	
	@Autowired
	ComponentMstService componentService;
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get ALL component  List
	 * 10-Dec-2020
	 */
	@RequestMapping(value = "/getAllComponents", method = RequestMethod.GET)
	public @ResponseBody List<ComponentMst> getAllComponents() {
		List<ComponentMst> list = null;

		list = componentService.getAllComponents();

		return list ;
	}
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get ALL component  List
	 * 10-Dec-2020
	 */
	@RequestMapping(value = "/getAllActiveComponents", method = RequestMethod.GET)
	public @ResponseBody List<ComponentMst> getAllActiveComponents() {
		List<ComponentMst> list = null;

		list = componentService.getAllActiveComponents();

		return list ;
	}
	
	/**
	 * @author {Dattatray Bodhale}
	 * name : For Add New  Component
	 * 10-Dec-2020
	 */

	@RequestMapping(value = "/addComponent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO addComponent(@RequestBody ComponentMst  componentMst) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			System.out.println("componentMst QR  "+componentMst.getConstantQrCode());
			Optional<ComponentMst> optional= componentService.getComponentByCode(componentMst.getPartNo());
			
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Part No already .....Exits");
			}else{
				componentMst.setActive(1);
				componentMst.setDelet(0);
				componentMst.setAddedDate(new Date());
				componentMst.setUpdDatetime(new Date());				
				componentService.addComponent(componentMst);
				responceDTO.setCode(200);
				responceDTO.setMessage("Component Added.....Successfully");
			}
				
		
			
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}
	
	@RequestMapping(value = "/editComponent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO editComponent(@RequestBody ComponentMst  componentMst) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			System.out.println("componentMst QR  "+componentMst.getConstantQrCode());
			Optional<ComponentMst> optional= componentService.getComponentByCode(componentMst.getPartNo());
			
			
			
				componentMst.setUpdDatetime(new Date());				
				componentService.addComponent(componentMst);
				responceDTO.setCode(200);
				responceDTO.setMessage("Component updated.....Successfully");
		
				
		
			
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
	 * name : Delet  Component
	 * 10-Dec-2020
	 */

	@RequestMapping(value = "/DeletComponent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO DeletComponent(@RequestBody ComponentMst  componentMst) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			componentMst.setDelet(1);
			componentService.addComponent(componentMst);
			responceDTO.setCode(200);
			responceDTO.setMessage("Component Deleted.....Successfully");
			
			
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}
		
	
	@RequestMapping(value = "/changeStatusComponent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO changeStatusComponent(@RequestBody ComponentMst  componentMst) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			if (componentMst.getActive()==1) {
				componentMst.setActive(0);
				
			}else{
				componentMst.setActive(1);
			}
			componentMst.setUpdDatetime(new Date());
			componentService.addComponent(componentMst);
		
			responceDTO.setCode(200);
			responceDTO.setMessage("Component Status Change.....Successfully");
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}
	

}
