/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcboe.home.instruction.model.request.GetStudentInfoReqById;
import com.jcboe.home.instruction.response.GetStudentParentInfoResp;
import com.jcboe.home.instruction.response.ScreenTextResponse;
import com.jcboe.home.instruction.service.IAppConfigServiceImpl;
import com.jcboe.home.instruction.service.IMessageService;
import com.jcboe.home.instruction.utilities.Constant;

@RestController
public class AppController {
	private IAppConfigServiceImpl appCofigService;
	private IMessageService iMessageService;

	@Autowired
	public AppController(final IAppConfigServiceImpl appCofigService, final IMessageService iMessageService) {
		this.appCofigService = appCofigService;
		this.iMessageService = iMessageService;
	}

	/*
	 * 
	 * Date: 30-July-2026 Method: getScreenTextValues Purpose: get screen text values
	 * from ScreenText table
	 *
	 */
	@GetMapping(value = "/GetScreenTextValues", produces = "application/json")
	public ResponseEntity<ScreenTextResponse> getScreenTextValues(
			@RequestParam(name = "screenId", required = true) int screenId,
			@RequestParam(name = "languageId", required = false, defaultValue = "1") int languageId) {
		try {
			iMessageService.getMessage(Constant.APP_CONFIG_API_REF);
			ScreenTextResponse response = appCofigService.getScreenTextValues(screenId, languageId);

			return new ResponseEntity<ScreenTextResponse>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}
	
	@PostMapping(path = "/GetStudentInfoByStudentId", consumes = "application/json", produces = "application/json")
	ResponseEntity<GetStudentParentInfoResp> getStudentInfoByStudentId(
			@RequestBody GetStudentInfoReqById getStudentInfoReqById) {
		try {
			iMessageService.getMessage(Constant.AFC_GSF);

			GetStudentParentInfoResp response = appCofigService
					.getStudentInfoByStudentId(getStudentInfoReqById);

			return new ResponseEntity<GetStudentParentInfoResp>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}
}
