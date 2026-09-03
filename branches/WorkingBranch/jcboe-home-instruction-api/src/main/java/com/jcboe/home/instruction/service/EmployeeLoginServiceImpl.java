/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.UserLoginRequest;
import com.jcboe.home.instruction.repo.EmployeeLoginRepo;
import com.jcboe.home.instruction.response.ParentLoginResp;
import com.jcboe.home.instruction.response.UserDetailDTO;
import com.jcboe.home.instruction.response.UsrLoginResponse;
import com.jcboe.home.instruction.response.UsrNameResponse;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@Service
public class EmployeeLoginServiceImpl implements IEmployeeLoginService {

	private final Logger logger = LogManager.getLogger(EmployeeLoginServiceImpl.class);

	private EmployeeLoginRepo loginRepo;
	private Utility utility;
	private LogInServiceImpl logInServiceImpl;

	@Autowired
	public EmployeeLoginServiceImpl(EmployeeLoginRepo loginRepo, Utility utility, LogInServiceImpl logInServiceImpl) {
		this.loginRepo = loginRepo;
		this.utility = utility;
		this.logInServiceImpl = logInServiceImpl;
	}
	/*
	 * 
	 * Date: 01-July-2023 Method: userName Purpose: to get regarding user
	 * details(name)
	 *
	 */

	@Override
	public UsrNameResponse userName(UserLoginRequest usrRequest) {

		logger.debug("Request for GetUserName API: \n{}",
				utility.printJson(usrRequest) != null ? utility.printJson(usrRequest) : usrRequest);

		/**
		 * if (StringUtils.isEmpty(StringUtils.strip(usrRequest.getUserId()))) { // User
		 * ID is mandatory. return new UsrNameResponse(false,
		 * Constant.getMessageMap().get(Constant.TLA_UDM)); } if
		 * (StringUtils.isEmpty(StringUtils.strip(usrRequest.getUserPassword()))) { //
		 * User password is mandatory. return new UsrNameResponse(false,
		 * Constant.getMessageMap().get(Constant.TLA_UPM)); }
		 **/
		try {

			UsrNameResponse userDetailsDbCallResp = loginRepo.getUserNameDbCall(usrRequest);

			Map<String, String> configKeyList = Collections.emptyMap();
			if (StringUtils.isNotBlank(usrRequest.getConfigKeys())) {
				configKeyList = utility.getConfigList(usrRequest.getConfigKeys());
			}

			if (userDetailsDbCallResp != null) {

				if (StringUtils.isNotEmpty(userDetailsDbCallResp.getUserName())) {
					userDetailsDbCallResp.setSuccess(true);
					// Employee Record found
					userDetailsDbCallResp.setMessage(Constant.getMessageMap().get(Constant.ELA_RFS));
					userDetailsDbCallResp.setConfigList(configKeyList);
					return userDetailsDbCallResp;
				} else {
					userDetailsDbCallResp.setSuccess(false);
					userDetailsDbCallResp.setMessage(Constant.getMessageMap().get(Constant.ELA_ENF));
					userDetailsDbCallResp.setMessage(Constant.getMessageMap().get(""));
					userDetailsDbCallResp.setConfigList(configKeyList);
					return userDetailsDbCallResp;
				}
			} else {
				UsrNameResponse invalidResp = new UsrNameResponse();
				invalidResp.setConfigList(configKeyList);
				invalidResp.setSuccess(false);
				invalidResp.setMessage(Constant.getMessageMap().get(Constant.ELA_ENF));
				return invalidResp;
			}

		} catch (Exception e) {
			logger.error("Request for GetUserName: \n {}", utility.printJson(usrRequest));
			logger.error("Error while interacting with database: {}{}", e.getMessage(), e);
			throw new HomeInstructionException(Constant.DATABASE_ERROR_MSG, Constant.DATABASE_ERROR_CODE);
		}
	}

	/*
	 * 
	 * Date: 30-July-2026 Method: userLogin Purpose: to get regarding user details
	 *
	 */

	@Override
	public UsrLoginResponse userLogin(UserLoginRequest usrRequest) {

		logger.debug("Request for userLogin API: \n{}",
				utility.printJson(usrRequest) != null ? utility.printJson(usrRequest) : usrRequest);

		UsrLoginResponse valResp = userLoginValidation(usrRequest);

		if (valResp != null) {
			return valResp;
		}
		if (StringUtils.isEmpty(usrRequest.getUserType())
				&& !StringUtils.equalsIgnoreCase(usrRequest.getUserType(), "e")) {
			// User type must be E
			return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_UTE));
		}

		/**
		 * if (StringUtils.isEmpty(usrRequest.getApplicationIndicator())) { //
		 * Application indicator mandatory : TIMEMGMT --> For Time Mangement Application
		 * return new UsrLoginResponse(false,
		 * Constant.getMessageMap().get(Constant.TLA_ADM)); }
		 */

		try {
			UserDetailDTO userDetailsDbCallResp = loginRepo.getUserDetailsDbCall(usrRequest);
			List<ParentLoginResp> dbResp = new ArrayList<>();
			dbResp.add(new ParentLoginResp());
			logInServiceImpl.setDbResponseList(dbResp);

			if (CollectionUtils.isNotEmpty(dbResp)) {
				userDetailsDbCallResp.setCurrentYear(dbResp.get(0).getCurrentYear());
				userDetailsDbCallResp.setPreviousYear(dbResp.get(0).getPreviousYear());
				userDetailsDbCallResp.setCurrentYearAbbr(dbResp.get(0).getCurrentYearAbbr());
				userDetailsDbCallResp.setPreviousYearAbbr(dbResp.get(0).getPreviousYearAbbr());
			}

			logger.debug("Response for Employee Login API: \n {}",
					userDetailsDbCallResp != null ? utility.printJson(userDetailsDbCallResp) : userDetailsDbCallResp);
			switch (userDetailsDbCallResp.getStatus()) {// NOSONAR
			case 1:
				logger.debug("Employee Login sucessfully.");

				// Login successfully
				return new UsrLoginResponse(true, Constant.getMessageMap().get(Constant.ELA_LGS), "",
						userDetailsDbCallResp);
			case -1:
				logger.debug("Employee not exist.");
				// Employee not exist
				return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_ENE));
			case -2:
				logger.debug("Employee not registered.");
				// Employee not registered
				return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_ENR));
			case -3:
				logger.debug("Incorrect password entered.");
				// Incorrect password
				return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_ICP));
			case -4:
				logger.debug("Incorrect Facilitator name.");
				// Invalid Facilitator name
				return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_ILN));
			case -5:
				logger.debug("Incorrect password entered.");
				// Invalid user password
				return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_ILP));
			case -6:
				logger.debug("User is not authorized.");
				// when logedInEmployee is true
				return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_NAE));

			default:
				logger.info("Data not found.");
				// Data not found
				return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_DNF));
			}

		} catch (Exception e) {
			logger.error("Request for EmployeeLogin: \n {} ", usrRequest);
			logger.error("Error while interacting with database: {}{}", e.getMessage(), e);
			throw new HomeInstructionException(Constant.DATABASE_ERROR_MSG, Constant.DATABASE_ERROR_CODE);
		}
	}

	private UsrLoginResponse userLoginValidation(UserLoginRequest usrRequest) {
		if (StringUtils.isEmpty(usrRequest.getApplicationId())) {
			logger.debug("Application ID is mandatory.");
			// Application ID is mandatory
			return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_AIM));
		}
		if (StringUtils.isEmpty(usrRequest.getUserId())) {
			logger.debug("User ID is mandatory.");
			// User ID is mandatory
			return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_UDM));
		}
		if (StringUtils.isEmpty(usrRequest.getUserPassword())) {
			logger.debug("User password is mandatory.");
			// User password is mandatory
			return new UsrLoginResponse(false, Constant.getMessageMap().get(Constant.ELA_UPM));
		}
		return null;
	}

}
