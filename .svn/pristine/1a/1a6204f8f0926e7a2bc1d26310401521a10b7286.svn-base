package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form3RhiltRespTest {

	@Test
	void testDefaultConstructor() {
		Form3RhiltResp response = new Form3RhiltResp();

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertEquals(null, response.getMessage());
		assertEquals(null, response.getAccessedOn());
		assertEquals(0L, response.getId());
		assertEquals(null, response.getAttachmentList());
	}

	@Test
	void testParameterizedConstructor() {
		List<HIFormTransactionResp> attachmentList = Arrays.asList(null, null);

		Form3RhiltResp response = new Form3RhiltResp(true, "Form submitted successfully", "2026-08-14 10:00:00", 12345L,
				attachmentList);

		assertTrue(response.isSuccess());
		assertEquals("Form submitted successfully", response.getMessage());
		assertEquals("2026-08-14 10:00:00", response.getAccessedOn());
		assertEquals(12345L, response.getId());
		assertEquals(attachmentList, response.getAttachmentList());
	}

	@Test
	void testSuccessGetterAndSetter() {
		Form3RhiltResp response = new Form3RhiltResp();

		response.setSuccess(true);
		assertTrue(response.isSuccess());

		response.setSuccess(false);
		assertFalse(response.isSuccess());
	}

	@Test
	void testMessageGetterAndSetter() {
		Form3RhiltResp response = new Form3RhiltResp();

		response.setMessage("Test message");

		assertEquals("Test message", response.getMessage());
	}

	@Test
	void testAccessedOnGetterAndSetter() {
		Form3RhiltResp response = new Form3RhiltResp();

		response.setAccessedOn("2026-08-14 10:30:00");

		assertEquals("2026-08-14 10:30:00", response.getAccessedOn());
	}

	@Test
	void testIdGetterAndSetter() {
		Form3RhiltResp response = new Form3RhiltResp();

		response.setId(98765L);

		assertEquals(98765L, response.getId());
	}

	@Test
	void testAttachmentListGetterAndSetter() {
		Form3RhiltResp response = new Form3RhiltResp();

		List<HIFormTransactionResp> attachmentList = Arrays.asList(null, null);

		response.setAttachmentList(attachmentList);

		assertNotNull(response.getAttachmentList());
		assertEquals(attachmentList, response.getAttachmentList());
		assertEquals(2, response.getAttachmentList().size());
	}

	@Test
	void testToString() {
		Form3RhiltResp response = new Form3RhiltResp(true, "Form submitted successfully", "2026-08-14 10:00:00", 12345L,
				null);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("Form3RhiltResp"));
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("Form submitted successfully"));
		assertTrue(result.contains("2026-08-14 10:00:00"));
		assertTrue(result.contains("12345"));
		assertTrue(result.contains("attachmentList"));
	}

	@Test
	void testToStringWithAttachmentList() {
		List<HIFormTransactionResp> attachmentList = Arrays.asList(null, null);

		Form3RhiltResp response = new Form3RhiltResp(true, "Success", "2026-08-14", 100L, attachmentList);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("Form3RhiltResp"));
		assertTrue(result.contains("attachmentList"));
	}
}