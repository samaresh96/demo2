package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form4PrthiRespTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		Form4PrthiResp resp = new Form4PrthiResp();
		List<HIFormTransactionResp> list = new ArrayList<>();

		resp.setSuccess(true);
		resp.setMessage("Success");
		resp.setAccessedOn("2024-01-01");
		resp.setId(101L);
		resp.setAttachmentList(list);

		assertTrue(resp.isSuccess());
		assertEquals("Success", resp.getMessage());
		assertEquals("2024-01-01", resp.getAccessedOn());
		assertEquals(101L, resp.getId());
		assertEquals(list, resp.getAttachmentList());
	}

	@Test
	void testParameterizedConstructor() {

		Form4PrthiResp resp = new Form4PrthiResp(true, "Success", "2024-01-01", 101L, null);

		assertTrue(resp.isSuccess());
		assertEquals("Success", resp.getMessage());
		assertEquals("2024-01-01", resp.getAccessedOn());
		assertEquals(101L, resp.getId());
	}

	@Test
	void testToString() {

		Form4PrthiResp resp = new Form4PrthiResp();
		resp.setSuccess(true);
		resp.setMessage("Success");
		resp.setAccessedOn("2024-01-01");
		resp.setId(101L);

		String result = resp.toString();

		assertNotNull(result);
		assertTrue(result.contains("Form4PrthiResp"));
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("message=Success"));
		assertTrue(result.contains("accessedOn=2024-01-01"));
		assertTrue(result.contains("id=101"));
	}
}