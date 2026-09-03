/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcboe.home.instruction.model.request.GetLogDataReq;
import com.jcboe.home.instruction.response.GetLogDataResp;
import com.jcboe.home.instruction.service.IMessageService;
import com.jcboe.home.instruction.service.LogInfoServiceImpl;


@RestController
public class LogInfoController {

	private LogInfoServiceImpl iogInfoServiceImpl;
	private IMessageService msgService;

	@Autowired
	LogInfoController(LogInfoServiceImpl iogInfoServiceImpl, IMessageService msgService) {
		this.iogInfoServiceImpl = iogInfoServiceImpl;
		this.msgService = msgService;
	}

	@PostMapping(path = "/GetLogData", consumes = "application/json", produces = "application/json")
	public ResponseEntity<GetLogDataResp> getLogData(@RequestBody GetLogDataReq getLogDataReq) {

		msgService.getMessage("");

		GetLogDataResp response = iogInfoServiceImpl.getLogData(getLogDataReq);

		return ResponseEntity.ok(response);
	}
}
