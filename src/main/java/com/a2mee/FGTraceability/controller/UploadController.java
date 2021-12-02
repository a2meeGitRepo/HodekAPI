/** 22-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.model.PackingBox;
import com.a2mee.FGTraceability.service.ComponentMstService;
import com.a2mee.FGTraceability.service.PackingBoxService;
import com.sun.el.parser.ParseException;


/**
 * @author {Dattatray Bodhale}
 *
 * 22-Dec-2020
 */

@RestController
@RequestMapping("/uploadController")
@CrossOrigin("*")
public class UploadController {
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	ComponentMstService componentService;
	
	@Autowired
	PackingBoxService packingBoxService;
	
	
	
	/* for uploading Annual Plan or Sales Order */
	@RequestMapping(value = "/uploadComponent", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity postFile(ModelMap model, @ModelAttribute(value = "file") MultipartFile file,
			HttpServletRequest request,@RequestParam("addedBy") String addedBy) {
		try {
			if (!(file == null)) {
				if (file.isEmpty()) {
					logger.info("File not found");
				} else {
					logger.info(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						logger.info("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0); 
						int i = 1;
						while (i <= datatypeSheet.getLastRowNum()) { 

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if(str.length()==0) {
								continue;
							}
							ComponentMst componentMst= new ComponentMst();
							 Optional<ComponentMst> optional= componentService.checkPartNo(row.getCell(1).toString());
							
							 if(optional.isPresent()){
								 componentMst=optional.get();
							 }
							 String comNo=row.getCell(1).toString();
							 System.out.println("COM NO :"+comNo);
							componentMst.setPartNo(row.getCell(1).toString().replace(".0", ""));
							componentMst.setComponentName(row.getCell(2).toString());
							componentMst.setDescription(row.getCell(3).toString());
							componentMst.setPrintType(row.getCell(4).toString());
							componentMst.setQrType(row.getCell(5).toString());
							componentMst.setConstantQrCode(row.getCell(6).toString());
							componentMst.setAddedDate(new Date());
							componentMst.setUpdDatetime(new Date());
							System.out.println("OPTIONAL "+componentService.checkPartNo(row.getCell(1).toString()));
							componentMst.setAddedby(addedBy);
								componentService.addComponent(componentMst);
							
							
						}


						logger.info("Successfully imported");
						workbook.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/uploadpackingBox", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity uploadpackingBox(ModelMap model, @ModelAttribute(value = "file") MultipartFile file,
			HttpServletRequest request,@RequestParam("addedBy") String addedBy) {
		try {
			if (!(file == null)) {
				if (file.isEmpty()) {
					logger.info("File not found");
				} else {
					logger.info(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						logger.info("hiiii@" + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0); // contains model plan
						
						int i = 1;
						while (i <= datatypeSheet.getLastRowNum()) { // for saving model plan

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if(str.length()==0) {
								continue;
							}
							PackingBox packingBox= new PackingBox();
							Optional<PackingBox> optional=packingBoxService.getPacckingBoxNyName(row.getCell(1).toString()); 
							if(optional.isPresent()){
								packingBox=optional.get();
							}
							
							packingBox.setBoxName(row.getCell(1).toString());
							String boxSize=(row.getCell(2).toString());
							String boxLayer=(row.getCell(3).toString());
							
							packingBox.setAddedDate(new Date());
							System.out.println("  NEW   boxSize  : "+boxSize.replace(".0", ""));
							packingBox.setBoxSize(Integer.parseInt(boxSize.replace(".0", "")));
							packingBox.setBoxLayer(Integer.parseInt(boxLayer.replace(".0", "")));
							packingBox.setAddedBy(addedBy);
							packingBox.setUpdDatetime(new Date());
							packingBoxService.addPackingBox(packingBox);
						}


						logger.info("Successfully imported");
						workbook.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}
