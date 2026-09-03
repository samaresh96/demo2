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
import com.jcboe.home.instruction.model.request.ParentRegReq;
import com.jcboe.home.instruction.response.StudentInfoImportResp;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

/**
 * 
 * 
 * Date: 09-Feb-2026 Class: StudentDetailsRepo.java Purpose:repository class for
 * user details related database operations
 *
 */
@Repository
public class StudentDetailsRepo {
	private final Logger logger = LogManager.getLogger(StudentDetailsRepo.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public StudentDetailsRepo(final NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	public List<StudentInfoImportResp> getImportStudentData(ParentRegReq parentRegReq, String regCode)
			throws Exception {
		logger.debug("Calling db function fn_import_student_data with parameter(s): -{}", parentRegReq);

		final String query = "SELECT * FROM fn_import_student_data(:p_student_id,:p_student_dob,:p_parent_name,:p_email_id,:p_password,:p_reg_code,:p_call_from)";

		Map<String, Object> params = new HashMap<>();

		if (StringUtils.isEmpty(parentRegReq.getStudentId())) {
			params.put("p_student_id", 0);
		} else {
			params.put("p_student_id", AES.decrypt(parentRegReq.getStudentId(), Constant.SALT_AES));
		}
		params.put("p_student_dob", parentRegReq.getStudentDob());
		params.put("p_parent_name", parentRegReq.getParentName());
		params.put("p_email_id", parentRegReq.getEmailId());
		if (StringUtils.isEmpty(parentRegReq.getParentPw())) {
			params.put("p_password", "");
		} else {
			params.put("p_password", AES.decryptToString(parentRegReq.getParentPw(), Constant.SALT_AES));
		}
		params.put("p_reg_code", StringUtils.isEmpty(regCode) ? parentRegReq.getRegCode() : regCode);
		params.put("p_call_from", parentRegReq.getIndicator());
		try {
			List<StudentInfoImportResp> importStdResp = jdbcTemplate.query(query, params, (rs,
					rowNum) -> new StudentInfoImportResp(rs.getLong("tag_id"), rs.getString("v_db_email_verified_on")));

			logger.debug("Record updated successfully.");

			return importStdResp;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_import_student_data: {} {}",
					e.getMessage(), e);
			throw e;
		}
	}

	public List<Object> verifyEmail(ParentRegReq parentRegReq) throws Exception {
		logger.debug("Calling db function fn_forget_password with parameter(s): -{}", parentRegReq);

		final String query = "SELECT * FROM fn_forget_password(:p_student_id,:p_email_id)";

		Map<String, Object> params = new HashMap<>();

		if (StringUtils.isEmpty(parentRegReq.getStudentId())) {
			params.put("p_student_id", 0);
		} else {
			params.put("p_student_id", AES.decrypt(parentRegReq.getStudentId(), Constant.SALT_AES));
		}

		params.put("p_email_id", parentRegReq.getEmailId());

		try {
			List<Object> importStdResp = jdbcTemplate.query(query, params, (rs, rowNum) -> rs.getBoolean("status"));

			logger.debug("Record updated successfully.");

			return importStdResp;

		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_forget_password: {} {}", e.getMessage(),
					e);
			throw e;
		}
	}
}
