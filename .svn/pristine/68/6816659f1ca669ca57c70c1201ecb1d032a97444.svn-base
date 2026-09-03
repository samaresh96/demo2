package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form9EAPPRespTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		Form9EAPPResp resp = new Form9EAPPResp();
		List<HIFormTransactionResp> attachmentList = new ArrayList<>();

		resp.setSuccess(true);
		resp.setMessage("Success");
		resp.setAccessedOn("2024-01-01");
		resp.setId(100L);
		resp.setAttachmentList(attachmentList);

		assertTrue(resp.isSuccess());
		assertEquals("Success", resp.getMessage());
		assertEquals("2024-01-01", resp.getAccessedOn());
		assertEquals(100L, resp.getId());
		assertEquals(attachmentList, resp.getAttachmentList());
	}

	@Test
	void testParameterizedConstructor() {

		Form9EAPPResp resp = new Form9EAPPResp(true, "Success", "2024-01-01", 100L, null);

		assertTrue(resp.isSuccess());
		assertEquals("Success", resp.getMessage());
		assertEquals("2024-01-01", resp.getAccessedOn());
		assertEquals(100L, resp.getId());
	}

	@Test
	void testToString() {

		Form9EAPPResp resp = new Form9EAPPResp();
		resp.setSuccess(true);
		resp.setMessage("Success");
		resp.setAccessedOn("2024-01-01");
		resp.setId(100L);

		String result = resp.toString();

		assertNotNull(result);
		assertTrue(result.contains("Form9EAPPResp"));
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("message=Success"));
		assertTrue(result.contains("accessedOn=2024-01-01"));
		assertTrue(result.contains("id=100"));
	}
}