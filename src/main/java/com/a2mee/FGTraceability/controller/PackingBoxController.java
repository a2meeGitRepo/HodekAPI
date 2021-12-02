/** 08-Dec-2020
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

import com.a2mee.FGTraceability.access.model.Role;
import com.a2mee.FGTraceability.access.model.UserDetails;
import com.a2mee.FGTraceability.dto.LoginRequest;
import com.a2mee.FGTraceability.dto.LoginResponce;
import com.a2mee.FGTraceability.dto.PackingBoxReqiestDTO;
import com.a2mee.FGTraceability.dto.ResponceDTO;
import com.a2mee.FGTraceability.model.PackingBox;
import com.a2mee.FGTraceability.model.PackingBoxLayer;
import com.a2mee.FGTraceability.service.PackingBoxService;

/**
 * @author {Dattatray Bodhale}
 *
 * 08-Dec-2020
 */
@RestController
@RequestMapping("/packingBox")
@CrossOrigin("*")
public class PackingBoxController {
	@Autowired
	PackingBoxService packingBoxService;
	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get ALL Packing Box List
	 * 08-Dec-2020
	 */
	@RequestMapping(value = "/getAllPackingBoxes", method = RequestMethod.GET)
	public @ResponseBody List<PackingBox> getAllPackingBoxes() {
		List<PackingBox> list = null;

		list = packingBoxService.getAllPackingBoxes();

		return list ;
	}
	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get ALL Packing Box List
	 * 08-Dec-2020
	 */
	@RequestMapping(value = "/getAllActivePackingBoxes", method = RequestMethod.GET)
	public @ResponseBody List<PackingBox> getAllActivePackingBoxes() {
		List<PackingBox> list = null;

		list = packingBoxService.getAllActivePackingBoxes();

		return list ;
	}
	/**
	 * @author {Dattatray Bodhale}
	 * name : For Add New  Packing Box ]
	 * 08-Dec-2020
	 */

	@RequestMapping(value = "/addPackingBox", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO addPackingBox(@RequestBody PackingBoxReqiestDTO  packingBoxReqiestDTO) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			Optional<PackingBox> optional= packingBoxService.getPacckingBoxNyName(packingBoxReqiestDTO.getPackingBox().getBoxName());
			if(! optional.isPresent()){
				packingBoxReqiestDTO.getPackingBox().setActive(1);
				packingBoxReqiestDTO.getPackingBox().setAddedDate(new Date());
				PackingBox packingBox1=packingBoxReqiestDTO.getPackingBox();
				packingBox1.setDelet(0);
				PackingBox packingBox= packingBoxService.addPackingBox(packingBox1);
				if(packingBox!=null){
					for (PackingBoxLayer packingBoxLayer:packingBoxReqiestDTO.getBoxLayers()) {
						
						packingBoxLayer.setPackingBox(packingBox);
						packingBoxLayer.setActive(1);
						packingBoxLayer.setAddedDate(new Date());
						packingBoxService.savepackingBoxLayer(packingBoxLayer);
						
						
					}
				}
				responceDTO.setCode(200);
				responceDTO.setMessage("Packing Box Added.....Successfully");	
			}else{
				responceDTO.setCode(500);
				responceDTO.setMessage("Box Name Is already exits");	
			}
			
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}
	
	@RequestMapping(value = "/editPackingBox", method = RequestMethod.POST)
	public  ResponceDTO editPackingBox(@RequestBody PackingBoxReqiestDTO  packingBoxReqiestDTO) {
		
		ResponceDTO responceDTO= new ResponceDTO();
		try {			
			PackingBox packingBox1=packingBoxReqiestDTO.getPackingBox();
			packingBox1.setUpdDatetime(new Date());
			PackingBox packingBox= packingBoxService.addPackingBox(packingBox1);
			if(packingBox!=null){
				for (PackingBoxLayer packingBoxLayer:packingBoxReqiestDTO.getBoxLayers()) {
					
					packingBoxLayer.setPackingBox(packingBox);
					packingBoxLayer.setUpdDatetime(new Date());
					packingBoxService.savepackingBoxLayer(packingBoxLayer);
					
					
				}
			}
			responceDTO.setCode(200);
			responceDTO.setMessage("Packing Box Edited.....Successfully");	
			
		}catch(Exception e) {
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage("Error occured");	
		}
		
		return  responceDTO;
	}
	
	/**
	 * @author {Dattatray Bodhale}
	 * name : Change Status for Packing box
	 * 09-Dec-2020
	 */

	@RequestMapping(value = "/changeStatusPackingBox", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO changeStatusPackingBox(@RequestBody PackingBox packingBox) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			if (packingBox.getActive()==1) {
				packingBox.setActive(0);
			}else{
				packingBox.setActive(1);
			}
		 packingBoxService.addPackingBox(packingBox);

			responceDTO.setCode(200);
			responceDTO.setMessage("Packing Box Status Change.....Successfully");
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
	 *  name : For Get ALL Packing Layer list By Packing Box Id 
	 * 09-Dec-2020
	 */
	@RequestMapping(value = "/getlayersByPackingBox", method = RequestMethod.GET)
	public @ResponseBody List<PackingBoxLayer> getlayersByPackingBox(@RequestParam("packingBoxId")int packingBoxId) {
		List<PackingBoxLayer> list = null;

		list = packingBoxService.getlayersByPackingBox(packingBoxId);

		return list ;
	}
	
	
	/**
	 * @author {Dattatray Bodhale}
	 * name : For Add New  Packing Box ]
	 * 08-Dec-2020
	 */

	@RequestMapping(value = "/DeletPackingBox", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO DeletPackingBox(@RequestBody PackingBox packingBox) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			packingBox.setDelet(1);
			 packingBoxService.addPackingBox(packingBox);

			
				responceDTO.setCode(200);
				responceDTO.setMessage("Packing Box Deleted Successfully");	
			
			
			return responceDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return responceDTO;
		}
		
			
		}

}
