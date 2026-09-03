package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form2RhidtRespTest {

	@Test
	void testDefaultConstructor() {

		Form2RhidtResp response = new Form2RhidtResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructor() {

		Form2RhidtResp response = new Form2RhidtResp(true, "Record updated successfully", "2026-08-05 10:30:00", 101L,
				null);

		assertTrue(response.isSuccess());
		assertEquals("Record updated successfully", response.getMessage());
		assertEquals("2026-08-05 10:30:00", response.getAccessedOn());
		assertEquals(101L, response.getId());
	}

	@Test
	void testSetterGetterMethods() {

		Form2RhidtResp response = new Form2RhidtResp();
		List<HIFormTransactionResp> list = new ArrayList<>();

		response.setSuccess(false);
		response.setMessage("Update failed");
		response.setAccessedOn("2026-08-05 11:00:00");
		response.setId(200L);
		response.setAttachmentList(list);

		assertFalse(response.isSuccess());
		assertEquals("Update failed", response.getMessage());
		assertEquals("2026-08-05 11:00:00", response.getAccessedOn());
		assertEquals(200L, response.getId());
		assertEquals(list, response.getAttachmentList());
	}

	@Test
	void testToStringMethod() {

		Form2RhidtResp response = new Form2RhidtResp();

		response.setSuccess(true);
		response.setMessage("Success");
		response.setAccessedOn("2026-08-05");
		response.setId(1L);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("Success"));
		assertTrue(result.contains("1"));
	}

}
