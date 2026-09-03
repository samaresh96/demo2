package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class S3UploadResponseTest {

	@Test
	void testDefaultConstructorAndSetters() {

		S3UploadResponse response = new S3UploadResponse();

		response.setSuccess(true);
		response.setMessage("Upload successful");
		response.setGuid("file-guid-123");
		response.setUploadLocation("/uploads/file.pdf");
		response.setStudentRegistrationDocumetId(10);
		response.setFileRestrictedMsg(true);

		assertTrue(response.isSuccess());
		assertEquals("Upload successful", response.getMessage());
		assertEquals("file-guid-123", response.getGuid());
		assertEquals("/uploads/file.pdf", response.getUploadLocation());
		assertEquals(10, response.getStudentRegistrationDocumetId());
		assertTrue(response.isFileRestrictedMsg());
	}

	@Test
	void testParameterizedConstructor() {

		S3UploadResponse response = new S3UploadResponse(true, "Upload successful", "file-guid-123",
				"/uploads/file.pdf", 10, true);

		assertTrue(response.isSuccess());
		assertEquals("Upload successful", response.getMessage());
		assertEquals("file-guid-123", response.getGuid());
		assertEquals("/uploads/file.pdf", response.getUploadLocation());
		assertEquals(10, response.getStudentRegistrationDocumetId());
		assertTrue(response.isFileRestrictedMsg());
	}

	@Test
	void testBooleanSetters() {

		S3UploadResponse response = new S3UploadResponse();

		response.setSuccess(false);
		response.setFileRestrictedMsg(false);

		assertFalse(response.isSuccess());
		assertFalse(response.isFileRestrictedMsg());
	}

	@Test
	void testToString() {

		S3UploadResponse response = new S3UploadResponse();

		response.setSuccess(true);
		response.setMessage("Success");
		response.setGuid("abc123");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("isSuccess=true"));
		assertTrue(result.contains("message=Success"));
		assertTrue(result.contains("guid=abc123"));
	}
}