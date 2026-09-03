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

import com.jcboe.home.instruction.response.IdsKeyValue;
import com.jcboe.home.instruction.response.StudentDataResp;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

/*
 * 
 * Date: 30-July-2026
 * Class: AppConfigRepo.java
 * Purpose: AppConfigRepo class use for fetch data from Config  table.
 *
 */
@Repository
public class AppConfigRepo {
	private final Logger logger = LogManager.getLogger(AppConfigRepo.class);
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public AppConfigRepo(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * 
	 * 
	 * Date: 30-July-2026 Method: getScreenTextDetails Purpose: Repository method
	 * for fetching screen text records
	 *
	 */
	public List<IdsKeyValue> getScreenTextDetails(int screenId, int languageId) throws Exception {
		logger.debug("Calling db function fn_get_screen_text with parameter(s): -{}{}", screenId, languageId);
		final String query = "select * from fn_get_screen_text(:p_screenId,:p_languageId)";
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("p_screenId", screenId);
			params.put("p_languageId", languageId);
			List<IdsKeyValue> returnVals = jdbcTemplate.query(query, params, (rs, rowNum) -> new IdsKeyValue(// NOSONAR

					rs.getString("ScreenTextKey"), rs.getString("ScreenKeyValue")// NOSONAR

			));
			logger.debug("Record fetched successfully.");
			return returnVals;

		}

		catch (Exception e) {
			logger.error("Exception occured while calling database funtion fn_get_screen_text: {} {}", e.getMessage(),
					e);
			throw e;
		}
	}

	public List<StudentDataResp> getStudentData(String studentId, String employeeId) {
		try {
			logger.debug("Calling db function fn_get_student_data with student id: {}",
					StringUtils.isEmpty(studentId) ? "" : AES.decrypt(studentId, Constant.SALT_AES));

			final String query = "SELECT * FROM fn_get_student_data(:p_student_id,:p_employee_id)";

			Map<String, Object> params = new HashMap<>();
			if (StringUtils.isEmpty(studentId)) {
				params.put("p_student_id", 0);
			} else {
				params.put("p_student_id", AES.decrypt(studentId, Constant.SALT_AES));
			}

			if (StringUtils.isEmpty(employeeId)) {
				params.put("p_employee_id", 0);
			} else {
				params.put("p_employee_id", AES.decrypt(employeeId, Constant.SALT_AES));
			}

			List<StudentDataResp> userDetailsResp = jdbcTemplate.query(query, params,
					(rs, rowNum) -> new StudentDataResp(rs.getLong("student_id"), rs.getString("student_name"),
							rs.getString("dob"), rs.getString("gender"), rs.getString("age"), rs.getString("grade"),
							rs.getInt("grade_id"), rs.getString("school"), rs.getString("school_code"),
							rs.getString("special_ed"), rs.getString("parents_name"), rs.getString("email_id"),
							rs.getBoolean("is_forgot_link"), rs.getBoolean("is_verified")));

			logger.debug("Record fetched successfully.");

			return userDetailsResp;

		} catch (Exception e) {
			logger.error("Error fetching student data for calling fn_get_student_data {}{}", e, e.getMessage());
			throw e;
		}
	}

}
