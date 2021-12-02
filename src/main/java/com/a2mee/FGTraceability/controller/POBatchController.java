/** 18-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.a2mee.FGTraceability.dto.ResponceDTO;
import com.a2mee.FGTraceability.model.Batch;
import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.PO;
import com.a2mee.FGTraceability.service.POBatchServices;

/**
 * @author {Dattatray Bodhale}
 *
 * 16-Dec-2020
 */
@RestController
@RequestMapping("/poBatch")
@CrossOrigin("*")
public class POBatchController {
	@Autowired
	POBatchServices pOBatchServices;
	
	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get ALL PO List 
	 * 16-Dec-2020
	 */
	@RequestMapping(value = "/getAllPos", method = RequestMethod.GET)
	public @ResponseBody List<PO> getAllPos() {
		List<PO> list = null;

		list = pOBatchServices.getAllPos();

		return list ;
	}
	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get Active PO List 
	 * 16-Dec-2020
	 */
	@RequestMapping(value = "/getAllActivePos", method = RequestMethod.GET)
	public @ResponseBody List<PO> getAllActivePos() {
		List<PO> list = null;

		list = pOBatchServices.getAllActivePos();

		return list ;
	}
	
	
	
	/**
	 * @author {Dattatray Bodhale}
	 * name : For Add New  PO
	 * 16-Dec-2020
	 */

	@RequestMapping(value = "/addPO", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO addPO(@RequestBody PO  po) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			po.setActive(1);
			po.setCreatedDate(new Date());
			List<PO> list = pOBatchServices.getAllPos();
			for(PO po2:list){
				po2.setActive(0);
				pOBatchServices.addPO(po2);
				 List<Batch> batches=pOBatchServices.getActiveBatchesByPo(po2.getPoId());
				 for(Batch batch:batches){
					 batch.setActive(0);
					 pOBatchServices.addBatch(batch);
				 }
			}
			pOBatchServices.addPO(po);
		
			responceDTO.setCode(200);
			responceDTO.setMessage("PO Added.....Successfully");
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
	 * name : For change PO Active Status
	 * 16-Dec-2020
	 */

	@RequestMapping(value = "/changeStatusPO", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO changeStatusPO(@RequestBody PO  po) {
		ResponceDTO responceDTO= new ResponceDTO();

		try {
			if (po.getActive()==1) {
				po.setActive(0);
				List<Batch> batchs= pOBatchServices.getAllBatchesByPo(po.getPoId());
				for(Batch batch:batchs){
					
					batch.setActive(0);
					pOBatchServices.addBatch(batch);
				}
 			}else {
				
				List<PO> list = pOBatchServices.getAllActivePos();
				for(PO po2:list){
					po2.setActive(0);
					pOBatchServices.addPO(po2);
					List<Batch> batchs= pOBatchServices.getAllBatchesByPo(po.getPoId());
					for(Batch batch:batchs){
						
						batch.setActive(0);
						pOBatchServices.addBatch(batch);
					}
				}
				po.setActive(1);
			}
		
			pOBatchServices.addPO(po);
		
			responceDTO.setCode(200);
			responceDTO.setMessage("PO Status Changed.....Successfully");
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
	 *  name : For Get ALL Bach List 
	 * 16-Dec-2020
	 */
	@RequestMapping(value = "/getAllBatches", method = RequestMethod.GET)
	public @ResponseBody List<Batch> getAllBatches() {
		List<Batch> list = null;

		list = pOBatchServices.getAllBatches();

		return list ;
	}
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get Active Bach List 
	 * 16-Dec-2020
	 */
	@RequestMapping(value = "/getActiveBatchesByPo", method = RequestMethod.GET)
	public @ResponseBody List<Batch> getActiveBatchesByPo(@RequestParam("poId") int poId) {
		List<Batch> list = null;

		list = pOBatchServices.getActiveBatchesByPo(poId);

		return list ;
	}
	
	/**
	 * @author {Dattatray Bodhale}
	 *  name : For Get ALL Bach List By PO 
	 * 16-Dec-2020
	 */
	@RequestMapping(value = "/getAllBatchesByPo", method = RequestMethod.GET)
	public @ResponseBody List<Batch> getAllBatchesByPo(@RequestParam("poId") int poId) {
		List<Batch> list = null;

		list = pOBatchServices.getAllBatchesByPo(poId);

		return list ;
	}
	

	
	
	/**
	 * @author {Dattatray Bodhale}
	 * name : For Add New  Batch
	 * 16-Dec-2020
	 */

	@RequestMapping(value = "/addBatch", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponceDTO addBatch(@RequestBody Batch  batch) {
		ResponceDTO responceDTO= new ResponceDTO();
		
		PO po=pOBatchServices.getPobyPOId(batch.getPo().getPoId());
		try {
			batch.setRem_po_quant(po.getPo_quantity()-batch.getBatch_quant());
			batch.setActive(1);
			batch.setCreatedDate(new Date());
			List<Batch> list = pOBatchServices.getAllBatchesByPo(batch.getPo().getPoId());
			for(Batch batch2:list){
				batch2.setActive(0);
				pOBatchServices.addBatch(batch2);
			}
			pOBatchServices.addBatch(batch);
		
			responceDTO.setCode(200);
			responceDTO.setMessage("Batch Added.....Successfully");
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
 * name : For Change active status of batch
 * 16-Dec-2020
 */

@RequestMapping(value = "/changeStatusBatch", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponceDTO changeStatusBatch(@RequestBody Batch  batch) {
	ResponceDTO responceDTO= new ResponceDTO();

	try {
		if (batch.getActive()==1) {
			batch.setActive(0);
		}else {
		
			List<Batch> list = pOBatchServices.getAllBatchesByPo(batch.getPo().getPoId());
			System.out.println("Batch list"+list.size());
			for(Batch batch2:list){
				if( ! batch2.getBatchName().equalsIgnoreCase(batch.getBatchName())){
					System.out.println("Batch "+batch2.getBatchName());
					batch2.setActive(0);
					pOBatchServices.addBatch(batch2);
				}
				
			}
			batch.setActive(1);
		}
	
		pOBatchServices.addBatch(batch);
	
		responceDTO.setCode(200);
		responceDTO.setMessage("Status Change.....Successfully");
		return responceDTO;
		
	} catch (Exception e) {
		// TODO: handle exception
		responceDTO.setCode(500);
		responceDTO.setMessage(e.getMessage());
		return responceDTO;
	}
	
		
	}
	
}
