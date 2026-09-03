/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.GetStudentInfoReqById;
import com.jcboe.home.instruction.repo.AppConfigRepo;
import com.jcboe.home.instruction.response.GetStudentParentInfoResp;
import com.jcboe.home.instruction.response.IdsKeyValue;
import com.jcboe.home.instruction.response.ScreenTextResponse;
import com.jcboe.home.instruction.response.StudentDataResp;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@Service
public class AppConfigServiceImpl implements IAppConfigServiceImpl {
	private final Logger logger = LogManager.getLogger(AppConfigServiceImpl.class);

	private Utility utility;
	private AppConfigRepo appConfigRepo;

	@Autowired
	public AppConfigServiceImpl(Utility utility, AppConfigRepo appConfigRepo) {
		this.utility = utility;
		this.appConfigRepo = appConfigRepo;
	}

	/*
	 * 
	 * 
	 * Date: 30-July-2026 Method: getScreenTextValues Purpose: For getting Screen
	 * text values
	 *
	 */
	@Override
	public ScreenTextResponse getScreenTextValues(int screenId, int languageId) {

		logger.debug("Parameter for getScreenTextValues API :screenId :{},languageId :{}", screenId, languageId);
		if (screenId == 0) {
			return new ScreenTextResponse(false, Constant.getMessageMap().get(Constant.APP_SIM),
					utility.responseDate(LocalDateTime.now()), new HashMap<String, String>());
		}
		try {
			List<IdsKeyValue> screenTextVal = appConfigRepo.getScreenTextDetails(screenId, languageId);
			ScreenTextResponse response = new ScreenTextResponse();
			if (screenTextVal != null && !screenTextVal.isEmpty()) {
				Map<String, String> fieldKeyValues = new LinkedHashMap<String, String>();
				if (!StringUtils.equalsAny(screenTextVal.get(0).getKey(), "-1")
						&& !StringUtils.equalsAny(screenTextVal.get(0).getKey(), "-2")) {
					for (IdsKeyValue idsKeyValue : screenTextVal) {
						fieldKeyValues.put(idsKeyValue.getKey(), idsKeyValue.getValue());
					}
					response.setScreenTexts(fieldKeyValues);
					response.setSuccess(true);
					response.setMessage(Constant.getMessageMap().get(Constant.APP_RFS));
					response.setAccessedOn(utility.responseDate(LocalDateTime.now()));
					return response;
				}
				return new ScreenTextResponse(false, Constant.getMessageMap().get(Constant.APP_NRF),
						utility.responseDate(LocalDateTime.now()), new HashMap<String, String>());

			} else {
				return new ScreenTextResponse(false, Constant.getMessageMap().get(Constant.APP_NRF),
						utility.responseDate(LocalDateTime.now()), new HashMap<String, String>());
			}
		} catch (Exception e) {
			logger.error("Exception for GetScreenTextValues: Screen ID>> {}, LanguageID>> {}", screenId, languageId);
			throw new HomeInstructionException(Constant.DATABASE_ERROR_MSG, Constant.DATABASE_ERROR_CODE, e);
		}
	}

	@SuppressWarnings("null")
	@Override
	public GetStudentParentInfoResp getStudentInfoByStudentId(GetStudentInfoReqById studentInfoReq) {

		logger.debug("Request for getStudentInfoByStudentId API: \n{}",
				utility.printJson(studentInfoReq) != null ? utility.printJson(studentInfoReq) : studentInfoReq);

		try {
			Map<String, String> configList = Collections.emptyMap();
			if (StringUtils.isNotBlank(studentInfoReq.getConfigKeys())) {
				configList = utility.getConfigList(studentInfoReq.getConfigKeys());
			}
			List<StudentDataResp> studentFormResp = appConfigRepo.getStudentData(studentInfoReq.getStudentId(),
					"");
			GetStudentParentInfoResp commonResponse = null;

			if (CollectionUtils.isNotEmpty(studentFormResp)) {
				commonResponse = new GetStudentParentInfoResp(true, Constant.getMessageMap().get(Constant.GSF_RFS),
						utility.responseDate(LocalDateTime.now()), studentFormResp);
				commonResponse.setConfigList(configList);
			} else {
				commonResponse = new GetStudentParentInfoResp(false, Constant.getMessageMap().get(Constant.GSF_RNS),
						utility.responseDate(LocalDateTime.now()), studentFormResp);
				commonResponse.setConfigList(configList);
			}

			return commonResponse;

		} catch (Exception e) {
			logger.error("Exception occured while calling getStudentInfoByStudentId data:{} ", e.getMessage());
			throw new HomeInstructionException(e.getMessage(), Constant.INTERNAL_SERVER_ERROR);
		}
	}

}
