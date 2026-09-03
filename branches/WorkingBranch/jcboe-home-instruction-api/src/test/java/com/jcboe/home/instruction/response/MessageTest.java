package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MessageTest {

	@Test
	void testDefaultConstructor() {
		Message message = new Message();

		assertNotNull(message);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		Message message = new Message(1, "API_REF", "MSG_REF", "Test Message", "INFO");

		assertEquals(1, message.getMessageId());
		assertEquals("API_REF", message.getApiRef());
		assertEquals("MSG_REF", message.getMessageRef());
		assertEquals("Test Message", message.getMessageText());
		assertEquals("INFO", message.getMessageType());

		assertNotNull(message.toString());
	}

	@Test
	void testSettersAndGetters() {

		Message message = new Message();

		message.setMessageId(10);
		message.setApiRef("API");
		message.setMessageRef("REF");
		message.setMessageText("Sample Text");
		message.setMessageType("ERROR");

		assertEquals(10, message.getMessageId());
		assertEquals("API", message.getApiRef());
		assertEquals("REF", message.getMessageRef());
		assertEquals("Sample Text", message.getMessageText());
		assertEquals("ERROR", message.getMessageType());
	}

	@Test
	void testToString() {

		Message message = new Message(100, "API", "REF", "Message Text", "SUCCESS");

		String result = message.toString();

		assertNotNull(result);
		assertTrue(result.contains("Message"));
		assertTrue(result.contains("Message Text"));
	}
}