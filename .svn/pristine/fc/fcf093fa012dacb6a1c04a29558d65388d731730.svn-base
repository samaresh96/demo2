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

import com.jcboe.home.instruction.response.HomeInstructionConfig;

@Repository
public class ConfigRepo {
	private final Logger logger = LogManager.getLogger(ConfigRepo.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public ConfigRepo(NamedParameterJdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	public List<HomeInstructionConfig> getMgmtConfigValuesByKey(String configkeys) throws Exception {
		logger.debug("Calling db function fn_get_config_values with parameter(s): configkeys {} ", configkeys);
		final String query = "SELECT * FROM fn_get_config_values(:p_config_key)";

		Map<String, Object> params = new HashMap<>();

		params.put("p_config_key", configkeys);

		try {
			List<HomeInstructionConfig> configList = jdbcTemplate.query(query, params,
					(rs, rowNum) -> new HomeInstructionConfig(rs.getInt("configuration_id"),

							StringUtils.defaultString(rs.getString("configuration_key")),

							StringUtils.defaultString(rs.getString("configuration_value")),

							rs.getBoolean("is_active")

					));

			logger.debug("Response received from the database.");

			return configList;
		} catch (Exception e) {
			logger.error("Exception occured while calling database function fn_get_config_values: {}{}", e.getMessage(),
					e);
			throw e;
		}
	}
}
