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

import com.jcboe.home.instruction.model.request.AdminLogInReq;
import com.jcboe.home.instruction.model.request.ParentLogInReq;
import com.jcboe.home.instruction.response.AdminLoginResp;
import com.jcboe.home.instruction.response.GetYearAbbrevResp;
import com.jcboe.home.instruction.response.JCBOEApplicationDTO;
import com.jcboe.home.instruction.response.ParentLoginResp;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

/**
 * 
 * 
 * Date: 09-Feb-2026 Class: LogInRepo.java Purpose:repository class for Login
 * details related database operations
 *
 */
@Repository
public class LogInRepo {
	private final Logger logger = LogManager.getLogger(LogInRepo.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public LogInRepo(final NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	public List<ParentLoginResp> checkParentLoginData(ParentLogInReq parentLogInReq) throws Exception {
		logger.debug("Calling db function fn_student_login with parameter(s): -{}", parentLogInReq);

		final String query = "SELECT * FROM fn_student_login(:p_student_id,:p_student_dob,:p_otp)";

		Map<String, Object> params = new HashMap<>();
		if (StringUtils.isEmpty(parentLogInReq.getStudentId())) {
			params.put("p_student_id", parentLogInReq.getStudentId());
		} else {
			params.put("p_student_id", AES.decrypt(parentLogInReq.getStudentId(), Constant.SALT_AES));
		}
		params.put("p_student_dob", parentLogInReq.getStudentDob());
		if (StringUtils.isAllBlank(parentLogInReq.getOtpCode())) {
			params.put("p_otp", parentLogInReq.getOtpCode());
		} else {
			params.put("p_otp", AES.decryptToString(parentLogInReq.getOtpCode(), Constant.SALT_AES));
		}

		try {
			List<ParentLoginResp> stuLogIn = jdbcTemplate.query(query, params, (rs, rowNum) -> new ParentLoginResp(

					rs.getBoolean("is_valid"),

					rs.getInt("result_code"),

					rs.getLong("logged_in_user_id"),

					rs.getString("logged_in_user_name"),

					rs.getString("email_id"),

					rs.getBoolean("is_default_psw")

			));

			logger.debug("Record updated successfully.");

			return stuLogIn;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_parent_login: {} {}", e.getMessage(), e);
			throw e;
		}
	}

	public List<AdminLoginResp> checkAdminLoginData(AdminLogInReq adminLogInReq) throws Exception {
		logger.debug("Calling db function fn_admin_login with parameter(s): -{}", adminLogInReq);

		final String query = "SELECT * FROM fn_admin_login(:p_user_id,:p_password,:p_user_type)";

		Map<String, Object> params = new HashMap<>();
		if (StringUtils.isEmpty(adminLogInReq.getUserId())) {
			params.put("p_user_id", adminLogInReq.getUserId());
		} else {
			params.put("p_user_id", AES.decryptToString(adminLogInReq.getUserId(), Constant.SALT_AES));
		}
		if (StringUtils.isEmpty(adminLogInReq.getPassword())) {
			params.put("p_password", adminLogInReq.getPassword());
		} else {
			params.put("p_password", AES.decryptToString(adminLogInReq.getPassword(), Constant.SALT_AES));
		}
		params.put("p_user_type", adminLogInReq.getUserType());

		try {
			List<AdminLoginResp> empEmails = jdbcTemplate.query(query, params, (rs, rowNum) -> new AdminLoginResp(

					rs.getBoolean("is_valid"),

					rs.getInt("result_code"),

					rs.getLong("logged_in_user_id"),

					rs.getString("logged_in_user_name"),

					rs.getString("logged_in_user_type")

			));

			logger.debug("Record updated successfully.");

			return empEmails;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_admin_login : {} {}", e.getMessage(), e);
			throw e;
		}
	}

	public List<ParentLoginResp> checkParentPwdData(ParentLogInReq parentPwChkReq) throws Exception {
		logger.debug("Calling db function fn_student_password_login with parameter(s): -{}", parentPwChkReq);

		final String query = "SELECT * FROM fn_student_password_login(:p_student_id,:p_password,:p_indicator)";

		Map<String, Object> params = new HashMap<>();
		if (StringUtils.isEmpty(parentPwChkReq.getStudentId())) {
			params.put("p_student_id", parentPwChkReq.getStudentId());
		} else {
			params.put("p_student_id", AES.decrypt(parentPwChkReq.getStudentId(), Constant.SALT_AES));
		}
		if (StringUtils.isEmpty(parentPwChkReq.getStudentPw())) {
			params.put("p_password", parentPwChkReq.getStudentPw());
		} else {
			params.put("p_password", AES.decryptToString(parentPwChkReq.getStudentPw(), Constant.SALT_AES));
		}
		params.put("p_indicator", parentPwChkReq.getIndicator());

		try {
			List<ParentLoginResp> stuLogIn = jdbcTemplate.query(query, params, (rs, rowNum) -> new ParentLoginResp(

					rs.getBoolean("is_valid"),

					rs.getInt("result_code"),

					rs.getLong("logged_in_user_id"),

					rs.getString("logged_in_user_name"),

					"", false

			));

			logger.debug("Record updated successfully.");

			return stuLogIn;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_parent_password_login : {} {}",
					e.getMessage(), e);
			throw e;
		}
	}

	public List<GetYearAbbrevResp> getSchoolYear() throws Exception {
		logger.debug("Calling db function fn_get_schoolyear with parameter(s)");

		final String query = "SELECT * FROM fn_get_schoolyear()";

		Map<String, Object> params = new HashMap<>();

		try {
			List<GetYearAbbrevResp> abbrevYear = jdbcTemplate.query(query, params,
					(rs, rowNum) -> new GetYearAbbrevResp(

							rs.getString("lookup_value"),

							rs.getString("lookup_abbreviation")

					));

			logger.debug("Record updated successfully.");

			return abbrevYear;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_get_schoolyear: {} {}", e.getMessage(),
					e);
			throw e;
		}
	}

	public List<JCBOEApplicationDTO> getApplicationByAbbr(String applicationAbbr) throws Exception {
		logger.debug("Calling db function fn_get_application_by_abbr with parameter(s): -{}", applicationAbbr);

		final String query = "SELECT * FROM fn_get_application_by_abbr(:p_applicationAbbr)";

		Map<String, Object> params = new HashMap<>();

		params.put("p_applicationAbbr", applicationAbbr);

		try {
			List<JCBOEApplicationDTO> applicationList = jdbcTemplate.query(query, params, // NOSONAR
					(rs, rowNum) -> new JCBOEApplicationDTO(

							rs.getInt("applicationid"),

							rs.getString("applicationname"),

							rs.getString("applicationurl"),

							rs.getString("applicationabbreviation"),

							rs.getString("applicationlocalurl")

					));
			logger.debug("Record fetched successfully.");
			return applicationList;
		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_get_application_by_abbr: {}",
					e.getMessage());
			throw e;
		}
	}
}
