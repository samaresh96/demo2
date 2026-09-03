/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jcboe.home.instruction.response.Message;

@Repository
public class MessageRepo {
	private final Logger logger = LogManager.getLogger(MessageRepo.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public MessageRepo(final NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * 
	 * Date: 09-Dec-2022 Method: getMessages Purpose:getMessages fect messgae
	 * details
	 *
	 */
	public List<Message> getMessages(String apiRef) throws Exception {
		logger.debug("Calling db function fn_get_message with parameter(s): -{}", apiRef);

		final String query = "select * from fn_get_message(:p_apiref)";
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("p_apiref", apiRef);

			List<Message> messages = jdbcTemplate.query(query, params, (rs, rowNum) -> new Message(

					0, rs.getString("api_ref"), rs.getString("message_ref"), rs.getString("message_text"),
					rs.getString("message_type")));

			logger.debug("Record(s) found-{}", messages.size());

			return messages;
		} catch (Exception e) {
			logger.error("Exception occurred while interacting with database for calling function fn_get_message: {}{}",
					e.getMessage(), e);
			throw e;
		}
	}
}
