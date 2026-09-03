package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GetAttachmentListRespTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		GetAttachmentListResp resp = new GetAttachmentListResp();

		List<HIFormTransactionResp> attachments = new ArrayList<>();
		attachments.add(new HIFormTransactionResp());

		resp.setSuccess(true);
		resp.setMessage("Success");
		resp.setAccessedOn("2024-01-01");
		resp.setAttachmentList(attachments);

		assertTrue(resp.isSuccess());
		assertEquals("Success", resp.getMessage());
		assertEquals("2024-01-01", resp.getAccessedOn());
		assertEquals(attachments, resp.getAttachmentList());
	}

	@Test
	void testParameterizedConstructor() {

		List<HIFormTransactionResp> attachments = new ArrayList<>();
		HIFormTransactionResp transactionResp = new HIFormTransactionResp();
		transactionResp.setId(1L);
		attachments.add(transactionResp);

		GetAttachmentListResp resp = new GetAttachmentListResp(true, "Success", "2024-01-01", attachments);

		assertTrue(resp.isSuccess());
		assertEquals("Success", resp.getMessage());
		assertEquals("2024-01-01", resp.getAccessedOn());
		assertEquals(attachments, resp.getAttachmentList());
	}

	@Test
	void testToString() {

		GetAttachmentListResp resp = new GetAttachmentListResp();
		resp.setSuccess(true);
		resp.setMessage("Success");
		resp.setAccessedOn("2024-01-01");

		String result = resp.toString();

		assertNotNull(result);
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("message=Success"));
		assertTrue(result.contains("accessedOn=2024-01-01"));
		assertTrue(result.contains("attachmentList="));
	}
}