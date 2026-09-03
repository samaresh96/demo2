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

import com.jcboe.home.instruction.model.request.AdminLogInReq;
import com.jcboe.home.instruction.model.request.ParentLogInReq;
import com.jcboe.home.instruction.model.request.ParentRegReq;
import com.jcboe.home.instruction.model.request.VerifyOtpReq;
import com.jcboe.home.instruction.response.LogInResponseDTO;
import com.jcboe.home.instruction.response.VerifyOtpResponse;
import com.jcboe.home.instruction.service.IMessageService;
import com.jcboe.home.instruction.service.LogInServiceImpl;
import com.jcboe.home.instruction.utilities.Constant;

@RestController
public class LogInController {
	private LogInServiceImpl logInServiceImpl;
	private IMessageService msgService;

	@Autowired
	LogInController(LogInServiceImpl logInServiceImpl, IMessageService msgService) {
		this.logInServiceImpl = logInServiceImpl;
		this.msgService = msgService;
	}

	/*
	 * 
	 * Date: 30-July-2026 Method: parentLogInCheck Purpose: For API REF LOG_PA
	 * 
	 */

	@PostMapping(path = "/ParentLogIn", consumes = "application/json", produces = "application/json")
	ResponseEntity<LogInResponseDTO> parentLogInCheck(@RequestBody ParentLogInReq parentLogInReq) {
		try {

			msgService.getMessage(Constant.LOG_PA);

			LogInResponseDTO response = logInServiceImpl.checkParentLogin(parentLogInReq);

			return new ResponseEntity<LogInResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}


	/*
	 * 
	 * Date: 30-July-2026 Method: SubmitRegistration Purpose: For API REF LOG_PAPW
	 * 
	 */

	@PostMapping(path = "/RegisterStudent", consumes = "application/json", produces = "application/json")
	ResponseEntity<LogInResponseDTO> registerStudent(@RequestBody ParentRegReq parentRegReq) {
		try {

			msgService.getMessage(Constant.LOG_PAPW);
			LogInResponseDTO response = logInServiceImpl.submitRegistration(parentRegReq);

			return new ResponseEntity<LogInResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/**
	 * 
	 * Date: 26-July-2026 Method: VerifyOtp Purpose: For API REF VFO
	 * 
	 */
	@PostMapping(path = "/VerifyOtp", consumes = "application/json", produces = "application/json")
	ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody VerifyOtpReq verifyOtpReq) {
		try {
			msgService.getMessage(Constant.VFO_API_REF);

			VerifyOtpResponse response = logInServiceImpl.verfyOtpStudent(verifyOtpReq);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/**
	 * 
	 * Date: 26-July-2026 Method: ForgetPasswordStudent Purpose: For API REF LOG_PAPW
	 * 
	 */

	@PostMapping(path = "/ForgetPasswordStudent", consumes = "application/json", produces = "application/json")
	ResponseEntity<LogInResponseDTO> forgetPasswordStudent(@RequestBody ParentRegReq parentRegReq) {
		try {
			msgService.getMessage(Constant.LOG_PAPW);

			LogInResponseDTO response = logInServiceImpl.forgetPasswordStudent(parentRegReq);

			return new ResponseEntity<LogInResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}
	
	/*
	 * 
	 * Date: 31-July-2026 Method: adminLogInCheck Purpose: For API REF LOG_AD
	 * 
	 */

	@PostMapping(path = "/AdminLogIn", consumes = "application/json", produces = "application/json")
	ResponseEntity<LogInResponseDTO> adminLogInCheck(@RequestBody AdminLogInReq adminLogInReq) {
		try {

			msgService.getMessage(Constant.LOG_AD);
			LogInResponseDTO response = logInServiceImpl.checkAdminLogin(adminLogInReq);

			return new ResponseEntity<LogInResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}
}
