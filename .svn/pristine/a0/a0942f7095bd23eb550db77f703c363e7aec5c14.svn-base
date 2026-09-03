package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UpdateApplicationRespTest {

	@Test
	void testNoArgsConstructor() {
		UpdateApplicationResp response = new UpdateApplicationResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructor() {
		UpdateApplicationResp response = new UpdateApplicationResp(Boolean.TRUE, "Application updated successfully",
				"2026-08-14");

		assertEquals(Boolean.TRUE, response.getSuccess());
		assertEquals("Application updated successfully", response.getMessage());
		assertEquals("2026-08-14", response.getAccessedOn());
	}

	@Test
	void testGettersAndSetters() {
		UpdateApplicationResp response = new UpdateApplicationResp();

		response.setSuccess(Boolean.TRUE);
		response.setMessage("Application updated successfully");
		response.setAccessedOn("2026-08-14");

		assertEquals(Boolean.TRUE, response.getSuccess());
		assertEquals("Application updated successfully", response.getMessage());
		assertEquals("2026-08-14", response.getAccessedOn());
	}

	@Test
	void testToString() {
		UpdateApplicationResp response = new UpdateApplicationResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, response.toString());
	}

}
