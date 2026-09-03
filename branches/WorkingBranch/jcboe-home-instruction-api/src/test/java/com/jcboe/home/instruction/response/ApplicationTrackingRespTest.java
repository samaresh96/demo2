package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationTrackingRespTest {

	@Test
	void testNoArgsConstructor() {
		ApplicationTrackingResp dto = new ApplicationTrackingResp();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-21";

		ApplicationTrackingResp dto = new ApplicationTrackingResp(success, message, accessedOn);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
	}

	@Test
	void testGettersAndSetters() {
		ApplicationTrackingResp dto = new ApplicationTrackingResp();

		boolean success = true;
		String message = "Application tracking successful";
		String accessedOn = "2026-08-21T19:00:00";

		dto.setSuccess(success);
		dto.setMessage(message);
		dto.setAccessedOn(accessedOn);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
	}

	@Test
	void testToString() {
		ApplicationTrackingResp dto = new ApplicationTrackingResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dto.toString());
	}

}
