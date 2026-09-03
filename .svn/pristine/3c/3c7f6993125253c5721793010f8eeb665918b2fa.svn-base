/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jcboe.home.instruction.model.request.GetLogDataReq;
import com.jcboe.home.instruction.response.GetLogDataResp;


@Service
public class LogInfoServiceImpl {

	private final Logger logger = LogManager.getLogger(LogInfoServiceImpl.class);

	public GetLogDataResp getLogData(GetLogDataReq getLogDataReq) {

		if (getLogDataReq != null) {

			if (getLogDataReq.getError() != null && !getLogDataReq.getError().trim().isEmpty()) {

				logger.error("Function Name : {}", getLogDataReq.getFunctionName());
				logger.error("Error : {}", getLogDataReq.getError());
				logger.error("Date Time : {}", getLogDataReq.getDateTime());
				logger.error("Error From : {}", getLogDataReq.getErrorFrom());
				return new GetLogDataResp(true, "Record found successful.");

			} else {

				logger.info("Function Name : {}", getLogDataReq.getFunctionName());
				logger.info("Error: {}", getLogDataReq.getError());
				logger.info("Date Time : {}", getLogDataReq.getDateTime());
				logger.info("Error From : {}", getLogDataReq.getErrorFrom());
				return new GetLogDataResp(true, "Record found successful.");
			}
		}
		logger.error("Log not found.");
		return new GetLogDataResp(false, "Log not found");
	}
}
