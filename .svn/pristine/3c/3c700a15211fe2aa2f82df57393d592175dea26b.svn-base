package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form1AphirRespTest {

	@Test
	public void testDefaultConstructor() {
		Form1AphirResp response = new Form1AphirResp();
		assertNotNull(response);
	}

	@Test
	public void testParameterizedConstructor() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-08";
		long form1AphirDataId = 100L;
		Form1AphirResp response = new Form1AphirResp(success, message, accessedOn, form1AphirDataId);
		assertEquals(success, response.isSuccess());
		assertEquals(message, response.getMessage());
		assertEquals(accessedOn, response.getAccessedOn());
		assertEquals(form1AphirDataId, response.getForm1AphirDataId());
	}

	@Test
	public void testParameterizedConstructor_new() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-08";
		long form1AphirDataId = 100L;
		Long applicationId = 100L;
		String applicationNumber = "";
		String applicationStatus = "DRFT";
		String applicationStatusAbbrev = "ASBM";
		Long formTransactionId = 500L;

		Form1AphirResp response = new Form1AphirResp(success, message, accessedOn, form1AphirDataId, applicationId,
				applicationNumber, applicationStatus, applicationStatusAbbrev, formTransactionId);

		assertEquals(success, response.isSuccess());
		assertEquals(message, response.getMessage());
		assertEquals(accessedOn, response.getAccessedOn());
		assertEquals(form1AphirDataId, response.getForm1AphirDataId());
		assertEquals(applicationId, response.getApplicationId());
		assertEquals(applicationNumber, response.getApplicationNumber());
		assertEquals(applicationStatus, response.getApplicationStatus());
		assertEquals(applicationStatusAbbrev, response.getApplicationStatusAbbrev());
		assertEquals(formTransactionId, response.getFormTransactionId());
	}

	@Test
	public void testSettersAndGetters() {
		Form1AphirResp response = new Form1AphirResp();

		response.setSuccess(true);
		response.setMessage("Test Message");
		response.setAccessedOn("2026-08-08 10:00:00");
		response.setForm1AphirDataId(200L);
		response.setApplicationId(300L);
		response.setApplicationNumber("APP-001");
		response.setApplicationStatus("PRNT");
		response.setApplicationStatusAbbrev("abbr");
		response.setFormTransactionId(400L);

		assertEquals(true, response.isSuccess());
		assertEquals("Test Message", response.getMessage());
		assertEquals("2026-08-08 10:00:00", response.getAccessedOn());
		assertEquals(200L, response.getForm1AphirDataId());
		assertEquals(Long.valueOf(300L), response.getApplicationId());
		assertEquals("APP-001", response.getApplicationNumber());
		assertEquals("PRNT", response.getApplicationStatus());
		assertEquals("abbr", response.getApplicationStatusAbbrev());
		assertEquals(Long.valueOf(400L), response.getFormTransactionId());
	}

	@Test
	public void testSuccessSetterAndGetter() {
		Form1AphirResp response = new Form1AphirResp();
		response.setSuccess(true);
		assertTrue(response.isSuccess());
		response.setSuccess(false);
		assertEquals(false, response.isSuccess());
	}

	@Test
	public void testListSetterAndGetter() {
		Form1AphirResp response = new Form1AphirResp();
		List scheduleList = new ArrayList();
		scheduleList.add("Schedule 1");
	}

	@Test
	void testToString() {
		Form1AphirResp response = new Form1AphirResp(true, "Success", "2026-08-08", 100L, 200L, "APP-001", "DRFT",
				"DFT", 300L);

		assertEquals(
				"Form1AphirResp [success=true, message=Success, accessedOn=2026-08-08, "
						+ "form1AphirDataId=100, applicationId=200, applicationNumber=APP-001, "
						+ "applicationStatus=DRFT, applicationStatusAbbrev=DFT, formTransactionId=300]",
				response.toString());
	}
}