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

import com.jcboe.home.instruction.model.request.UserInfoReq;
import com.jcboe.home.instruction.model.request.VerifyOtpReq;
import com.jcboe.home.instruction.response.LookupDetails;
import com.jcboe.home.instruction.response.TeacherListResp;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

/**
 * 
 * 
 * Date: 06-Feb-2026 Class: UserDetailsRepo.java Purpose:repository class for
 * user details related database operations
 *
 */
@Repository
public class UserDetailsRepo {
	private final Logger logger = LogManager.getLogger(UserDetailsRepo.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public UserDetailsRepo(final NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	public List<Long> verifyUserOtp(VerifyOtpReq verifyOtpReq) throws Exception {

		logger.debug("Calling db function 071_fn_verify_otp with parameter(s): -{}", verifyOtpReq);

		final String query = "SELECT * FROM fn_verify_otp(:p_student_id,:p_otp)";

		Map<String, Object> params = new HashMap<>();

		if (StringUtils.isEmpty(verifyOtpReq.getStudentId())) {
			params.put("p_student_id", 0L);
		} else {
			params.put("p_student_id",
					Long.parseLong(AES.decryptToString(verifyOtpReq.getStudentId(), Constant.SALT_AES)));
		}
		params.put("p_otp", verifyOtpReq.getOtp());

		try {
			List<Long> importStdResp = jdbcTemplate.query(query, params,
					(rs, rowNum) -> Long.valueOf(rs.getInt("status_code")));

			logger.debug("DB response fetched successfully.");

			return importStdResp;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function 071_fn_verify_otp: {} {}", e.getMessage(),
					e);
			throw e;
		}
	}

	public List<LookupDetails> getLookupValues(String lookupValues) throws Exception {
		logger.debug("Calling db function fn_get_lookup_values with parameter(s): -{}", lookupValues);

		final String query = "SELECT * FROM fn_get_lookup_values(:p_lookup_type)";

		Map<String, Object> params = new HashMap<>();

		params.put("p_lookup_type", lookupValues);

		try {
			List<LookupDetails> userDetailsResp = jdbcTemplate.query(query, params, (rs, rowNum) -> new LookupDetails(

					rs.getString("lookup_type"), rs.getInt("lookup_value_id"), rs.getString("lookup_value"),
					rs.getString("lookup_abbreviation"), rs.getBoolean("is_active")));

			logger.debug("Record fetched successfully.");

			return userDetailsResp;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_get_lookup_values: {} {}",
					e.getMessage(), e);
			throw e;
		}
	}

	public List<Long> updateuserInfoData(UserInfoReq userInfoReq) throws Exception {

		logger.debug("Calling db function fn_update_user_info with parameter(s): -{}", userInfoReq);

		final String query = "SELECT * FROM fn_update_user_info(:p_indicator,:p_employee_id,:p_user_type,:p_phone_number_1,:p_phone_number_2)";

		Map<String, Object> params = new HashMap<>();
		params.put("p_indicator", userInfoReq.getIndicator());

		if (StringUtils.isEmpty(userInfoReq.getEmployeeId())) {
			params.put("p_employee_id", 0l);
		} else {
			params.put("p_employee_id",
					Long.parseLong(AES.decryptToString(userInfoReq.getEmployeeId(), Constant.SALT_AES)));
		}

		params.put("p_user_type", userInfoReq.getUserType());
		params.put("p_phone_number_1", userInfoReq.getPhoneNumber1());
		params.put("p_phone_number_2", userInfoReq.getPhoneNumber2());

		try {

			List<Long> response = jdbcTemplate.query(query, params, (rs, rowNum) -> rs.getLong("tag_id"));

			logger.debug("Record Form9 EAPPP updated successfully.");

			return response;

		} catch (Exception e) {

			logger.error("Exception occurred while calling database function fn_update_form9_eapp_data: {} {}",
					e.getMessage(), e);

			throw e;
		}
	}

	public List<TeacherListResp> getTeacherData() throws Exception {
		logger.debug("Calling db function fn_get_teacher_list");

		final String query = "SELECT * FROM fn_get_teacher_list()";

		try {
			List<TeacherListResp> teacherListResp = jdbcTemplate.query(query,
					(rs, rowNum) -> new TeacherListResp(rs.getLong("employee_id"), rs.getString("employee_name")));

			logger.debug("Record fetched successfully.");

			return teacherListResp;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_get_teacher_list: {} {}", e.getMessage(),
					e);
			throw e;
		}
	}
}
