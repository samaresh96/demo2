/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.repo.MessageRepo;
import com.jcboe.home.instruction.response.Message;
import com.jcboe.home.instruction.utilities.Constant;

/**
 * 
 * 
 * Date: 30-July-2026 Class: MessageServiceImpl.java Purpose:fetch the message
 * details
 * 
 *
 */

@Service
public class MessageServiceImpl implements IMessageService {
	private final Logger logger = LogManager.getLogger(MessageServiceImpl.class);

	private MessageRepo messageRepo;

	@Autowired
	public MessageServiceImpl(final MessageRepo messageRepo) {
		this.messageRepo = messageRepo;
	}

	public MessageServiceImpl() {

	}

	/*
	 * 
	 * Date: 30-July-2026 Method: getMessage Purpose:fetch message details
	 *
	 */

	@Override
	public void getMessage(String apiRef) {
		try {
			List<Message> messgaes = messageRepo.getMessages(apiRef);
			LinkedHashMap<String, String> msgMap = new LinkedHashMap<String, String>();

			// here we put message data list to map
			messgaes.forEach(msg -> msgMap.put(msg.getMessageRef(), msg.getMessageText())

			);

			Constant.setMessageMap(msgMap);

		} catch (Exception e) {
			logger.error("Exception occured while fetching message service:{} ", e.getMessage());
			throw new HomeInstructionException(e.getMessage(), "Database access error", e);
		}

	}

}
