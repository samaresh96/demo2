/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcboe.home.instruction.model.request.UserLoginRequest;
import com.jcboe.home.instruction.response.UsrLoginResponse;
import com.jcboe.home.instruction.response.UsrNameResponse;
import com.jcboe.home.instruction.service.IEmployeeLoginService;
import com.jcboe.home.instruction.service.IMessageService;
import com.jcboe.home.instruction.utilities.Constant;

/*
 * 
 * Date: 30-July-2026
 * Class: EmployeeRegisterController.java
 * Purpose: Fetch record for dashboard record
 
 *
 */
@RestController
public class EmployeeRegisterController {

	private IEmployeeLoginService employeeLoginService;
	private IMessageService iMessageService;

	@Autowired
	public EmployeeRegisterController(IEmployeeLoginService employeeLoginService, IMessageService iMessageService) {
		this.employeeLoginService = employeeLoginService;
		this.iMessageService = iMessageService;
	}
	/*
	 * 
	 * Date: 30-July-2026 Method: userName Purpose: to get user name of the user
	 * 
	 */

	@PostMapping(path = "/GetUserName", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UsrNameResponse> getUserName(@RequestBody UserLoginRequest usrRequest) {

		iMessageService.getMessage(Constant.ELA_API_REF);

		UsrNameResponse response = employeeLoginService.userName(usrRequest);

		return new ResponseEntity<UsrNameResponse>(response, HttpStatus.OK);

	}

	/*
	 * 
	 * Date: 30-July-2026 Method: EmployeeLogin Purpose: to get user details and
	 * send mail user
	 * 
	 */

	@PostMapping(path = "/EmployeeLogin", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UsrLoginResponse> employeeLogInCheck(@RequestBody UserLoginRequest usrRequest) {

		iMessageService.getMessage(Constant.ELA_API_REF);

		UsrLoginResponse response = employeeLoginService.userLogin(usrRequest);

		return new ResponseEntity<UsrLoginResponse>(response, HttpStatus.OK);

	}

}
