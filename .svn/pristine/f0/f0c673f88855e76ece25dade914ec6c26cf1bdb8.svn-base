package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class DeleteDocResponseTest {

	@Test
	void testDefaultConstructor() {
		DeleteDocResponse response = new DeleteDocResponse();

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertEquals(null, response.getMessage());
		assertEquals(null, response.getAccessedOn());
		assertEquals(null, response.getAttachmentList());
	}

	@Test
	void testParameterizedConstructor() {
		DeleteDocResponse response = new DeleteDocResponse(true, "Document deleted successfully");

		assertTrue(response.isSuccess());
		assertEquals("Document deleted successfully", response.getMessage());
	}

	@Test
	void testSuccessGetterAndSetter() {
		DeleteDocResponse response = new DeleteDocResponse();

		response.setSuccess(true);

		assertTrue(response.isSuccess());

		response.setSuccess(false);

		assertFalse(response.isSuccess());
	}

	@Test
	void testMessageGetterAndSetter() {
		DeleteDocResponse response = new DeleteDocResponse();

		response.setMessage("Delete completed");

		assertEquals("Delete completed", response.getMessage());
	}

	@Test
	void testAccessedOnGetterAndSetter() {
		DeleteDocResponse response = new DeleteDocResponse();

		response.setAccessedOn("2026-08-13 10:00:00");

		assertEquals("2026-08-13 10:00:00", response.getAccessedOn());
	}

	@Test
	void testAttachmentListGetterAndSetter() {
		DeleteDocResponse response = new DeleteDocResponse();

		List<HIFormTransactionResp> attachmentList = Arrays.asList(null, null);

		response.setAttachmentList(attachmentList);

		assertNotNull(response.getAttachmentList());
		assertEquals(attachmentList, response.getAttachmentList());
		assertEquals(2, response.getAttachmentList().size());
	}

	@Test
	void testToString() {
		DeleteDocResponse response = new DeleteDocResponse(true, "Document deleted");

		response.setAccessedOn("2026-08-13 10:00:00");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("DeleteDocResponse"));
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("Document deleted"));
		assertTrue(result.contains("2026-08-13 10:00:00"));
	}

	@Test
	void testToStringWithAttachmentList() {
		DeleteDocResponse response = new DeleteDocResponse(true, "Document deleted");

		List<HIFormTransactionResp> attachmentList = Arrays.asList(null, null);

		response.setAttachmentList(attachmentList);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("attachmentList"));
	}
}