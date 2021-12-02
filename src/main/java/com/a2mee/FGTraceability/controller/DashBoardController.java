/** 30-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.a2mee.FGTraceability.dto.DashBoard;
import com.a2mee.FGTraceability.model.ComponentMst;
import com.a2mee.FGTraceability.service.DashBoardService;

/**
 * @author {Dattatray Bodhale}
 *
 * 30-Dec-2020
 */
@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class DashBoardController {
	
	@Autowired
	DashBoardService dashBoardService;
	@RequestMapping(value = "/getDashboardDate", method = RequestMethod.GET)
	public @ResponseBody DashBoard getDashboardDate() {
		DashBoard dashBoard = new DashBoard();

		dashBoard = dashBoardService.getDashboardDate();

		return dashBoard ;
	}

}
