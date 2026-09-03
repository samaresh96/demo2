package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FileUploadRespTest {

	@Test
	public void testNoArgsConstructor() {
		FileUploadResp resp = new FileUploadResp();

		assertFalse(resp.isSuccess());
		assertEquals(null, resp.getMessage());
		assertEquals(null, resp.getTransactionId());
		assertEquals(null, resp.getUpdatedOn());
		assertEquals(null, resp.getApplicationId());
		assertEquals(null, resp.getApplicationNo());
		assertEquals(null, resp.getApplicationStatus());
		assertEquals(null, resp.getApplicationStatusAbbrev());
	}

	@Test
	public void testParameterizedConstructor() {
		FileUploadResp resp = new FileUploadResp(true, "File uploaded successfully");

		assertTrue(resp.isSuccess());
		assertEquals("File uploaded successfully", resp.getMessage());
	}

	@Test
	public void testGettersAndSetters() {
		FileUploadResp resp = new FileUploadResp();

		resp.setSuccess(true);
		resp.setMessage("File uploaded successfully");
		resp.setTransactionId(1001L);
		resp.setUpdatedOn("2026-08-11");
		resp.setApplicationId(2001L);
		resp.setApplicationNo("APP001");
		resp.setApplicationStatus("COMPLETED");
		resp.setApplicationStatusAbbrev("CMP");

		List<HIFormTransactionResp> attachmentList = new ArrayList<>();
		resp.setAttachmentList(attachmentList);

		assertTrue(resp.isSuccess());
		assertEquals("File uploaded successfully", resp.getMessage());
		assertEquals(Long.valueOf(1001L), resp.getTransactionId());
		assertEquals("2026-08-11", resp.getUpdatedOn());
		assertEquals(Long.valueOf(2001L), resp.getApplicationId());
		assertEquals("APP001", resp.getApplicationNo());
		assertEquals("COMPLETED", resp.getApplicationStatus());
		assertEquals("CMP", resp.getApplicationStatusAbbrev());

		// Covers getAttachmentList()
		assertEquals(attachmentList, resp.getAttachmentList());
	}

	@Test
	void testAttachmentListGetterAndSetter() {
		FileUploadResp response = new FileUploadResp();

		List<HIFormTransactionResp> attachments = new ArrayList<>();

		response.setAttachmentList(attachments);

		assertEquals(attachments, response.getAttachmentList());
	}

	@Test
	public void testSuccessSetterWithFalse() {
		FileUploadResp resp = new FileUploadResp();

		resp.setSuccess(true);
		assertTrue(resp.isSuccess());

		resp.setSuccess(false);
		assertFalse(resp.isSuccess());
	}

	@Test
	void testToString() {

		FileUploadResp response = new FileUploadResp(true, "Success");

		response.setTransactionId(100L);
		response.setUpdatedOn("2025-02-01");

		List<HIFormTransactionResp> attachments = new ArrayList<>();
		response.setAttachmentList(attachments);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("isSuccess=true"));
		assertTrue(result.contains("message=Success"));
		assertTrue(result.contains("transactionId=100"));
		assertTrue(result.contains("updatedOn=2025-02-01"));
		assertTrue(result.contains("attachmentList=[]"));
	}
}