package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form8HiscpRespTest {

	@Test
	void testDefaultConstructorAndSetters() {
		Form8HiscpResp response = new Form8HiscpResp();
		List<HIFormTransactionResp> list = new ArrayList<>();

		response.setSuccess(true);
		response.setMessage("Success");
		response.setAccessedOn("2026-08-08");
		response.setId(123L);
		response.setAttachmentList(list);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("2026-08-08", response.getAccessedOn());
		assertEquals(123L, response.getId());
		assertEquals(list, response.getAttachmentList());
	}

	@Test
	void testParameterizedConstructor() {
		Form8HiscpResp response = new Form8HiscpResp(true, "Success", "2026-08-08", 123L, null);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("2026-08-08", response.getAccessedOn());
		assertEquals(123L, response.getId());
	}

	@Test
	void testToString() {
		Form8HiscpResp response = new Form8HiscpResp(true, "Success", "2026-08-08", 123L, null);

		String result = response.toString();

		assertEquals("Form8HiscpResp [success=true, message=Success, accessedOn=2026-08-08, id=123]", result);
	}
}
