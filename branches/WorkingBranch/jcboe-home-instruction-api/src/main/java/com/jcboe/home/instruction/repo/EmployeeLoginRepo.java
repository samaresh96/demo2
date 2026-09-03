/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.jcboe.home.instruction.model.request.UserLoginRequest;
import com.jcboe.home.instruction.response.UserDetailDTO;
import com.jcboe.home.instruction.response.UsrNameResponse;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

@Repository
public class EmployeeLoginRepo {

	private final Logger logger = LogManager.getLogger(EmployeeLoginRepo.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeLoginRepo(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/*
	 * 
	 * Date: 01-July-2023 Method: getUserNameDbCall Purpose: To get user name
	 *
	 */

	public UsrNameResponse getUserNameDbCall(UserLoginRequest usrRequest) throws Exception {

		logger.debug("Parametrs  for FncGetUserName API: \n {}", usrRequest);

		final String query = "SELECT * FROM fn_get_user_name(:p_user_id, :p_user_password, :p_is_get_password, :p_application_indicator, :p_called_from)";
		try {

			long decryptedEmpId = 0;
			Map<String, Object> params = new HashMap<>();

			if (StringUtils.isNotEmpty(usrRequest.getUserId())) {
				decryptedEmpId = AES.decrypt(usrRequest.getUserId(), Constant.SALT_AES);
			} else {
				decryptedEmpId = 0;
			}

			params.put("p_user_id", decryptedEmpId);
			params.put("p_user_password", usrRequest.getUserPassword());
			params.put("p_is_get_password", usrRequest.isGetPassword());
			params.put("p_application_indicator", usrRequest.getApplicationIndicator());

			params.put("p_called_from", usrRequest.getCalledFrom());

			List<UsrNameResponse> userList = jdbcTemplate.query(query, params, (rs, rowNum) -> new UsrNameResponse(

					rs.getString("UserName"),

					rs.getString("Password"),

					rs.getString("FirstName"),

					rs.getString("MiddleName"),

					rs.getString("LastName"),

					rs.getString("LocationID"),

					rs.getString("Location"),

					rs.getString("ApplicationRoleID"),

					rs.getString("AppRoleAbbreviation"),

					rs.getString("AppRoleName"),

					rs.getBoolean("is_registered"),

					0l

			));

			if (!CollectionUtils.isEmpty(userList)) {
				logger.debug("user List record(s) fetched successfully: {}", userList.size());
				userList.get(0).setUserId(decryptedEmpId);
				return userList.get(0);

			} else {
				return null;
			}

		} catch (Exception e) {
			logger.error("Exception occured while interacting with database:{}{} ", e.getMessage(), e);
			throw e;
		}
	}

	/*
	 * 
	 * Date: 30-July-2026 Method: getUserDetailsDbCall Purpose: get user details of
	 * an user time sheet
	 *
	 */

	public UserDetailDTO getUserDetailsDbCall(UserLoginRequest usrRequest) throws Exception {
		logger.debug("Parametrs  for fn_get_user_details API: \n {}", usrRequest);
		final String query = "SELECT * FROM fn_get_user_details(:p_user_id, :p_user_type, :p_user_password, :p_application_id, :p_type, :p_login_name, :p_login_password)";
		try {

			long decryptedEmpId = 0;
			Map<String, Object> params = new HashMap<>();

			if (StringUtils.isNotEmpty(usrRequest.getUserId())) {
				decryptedEmpId = AES.decrypt(usrRequest.getUserId(), Constant.SALT_AES);
			} else {
				decryptedEmpId = 0;
			}

			params.put("p_user_id", decryptedEmpId);
			params.put("p_user_type", usrRequest.getUserType());
			params.put("p_user_password", usrRequest.getUserPassword());
			params.put("p_application_id", Integer.parseInt(usrRequest.getApplicationId()));

			params.put("p_type", usrRequest.getType());
			params.put("p_login_name", usrRequest.getLoginName());
			params.put("p_login_password", usrRequest.getLoginPassword());

			List<UserDetailDTO> userList = jdbcTemplate.query(query, params,
					(rs, rowNum) -> new UserDetailDTO(rs.getInt("RegisteredUserID"),

							rs.getInt("UserID"),

							StringUtils.defaultString(StringUtils.strip(rs.getString("user_type_inf"))),

							rs.getInt("OneTimeCode"),

							StringUtils.defaultString(StringUtils.strip(rs.getString("RegisteredEmail"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("UserPassword"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("OTPSentOn"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("RegisteredOn"))),

							rs.getBoolean("PasswordReset"),

							rs.getBoolean("IsActive"),

							rs.getInt("status"),

							rs.getInt("EmployeeID"),

							StringUtils.defaultString(StringUtils.strip(rs.getString("LocationID"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("FirstName"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("LastName"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("Guide"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("EmailID"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("MiddleName"))),

							rs.getInt("UpdatedBy"),

							StringUtils.defaultString(StringUtils.strip(rs.getString("UpdatedOn"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("AppRoleAbbreviation"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("AppRoleName"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("user_type_inf"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("phone_number_1_inf"))),

							StringUtils.defaultString(StringUtils.strip(rs.getString("phone_number_2_inf")))

					));

			logger.info("Response received from the database. {}", userList);

			if (!CollectionUtils.isEmpty(userList)) {
				return userList.get(0);

			} else {
				return null;
			}

		} catch (Exception e) {
			logger.error("Exception occured while interacting with database: {}{}", e.getMessage(), e);
			throw e;
		}
	}

}
