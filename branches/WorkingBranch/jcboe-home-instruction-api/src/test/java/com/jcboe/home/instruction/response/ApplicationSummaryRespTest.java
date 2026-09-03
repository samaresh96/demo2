package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationSummaryRespTest {

	@Test
	void testNoArgsConstructor() {
		ApplicationSummaryResp dto = new ApplicationSummaryResp();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		String statusAbbreviation = "APP";
		String statusName = "Approved";
		Long applicationCount = 100L;

		ApplicationSummaryResp dto = new ApplicationSummaryResp(statusAbbreviation, statusName, applicationCount);

		assertEquals(statusAbbreviation, dto.getStatusAbbreviation());
		assertEquals(statusName, dto.getStatusName());
		assertEquals(applicationCount, dto.getApplicationCount());
	}

	@Test
	void testGettersAndSetters() {
		ApplicationSummaryResp dto = new ApplicationSummaryResp();

		String statusAbbreviation = "PEN";
		String statusName = "Pending";
		Long applicationCount = 50L;

		dto.setStatusAbbreviation(statusAbbreviation);
		dto.setStatusName(statusName);
		dto.setApplicationCount(applicationCount);

		assertEquals(statusAbbreviation, dto.getStatusAbbreviation());
		assertEquals(statusName, dto.getStatusName());
		assertEquals(applicationCount, dto.getApplicationCount());
	}

	@Test
	void testToString() {
		ApplicationSummaryResp resp = new ApplicationSummaryResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, resp.toString());
	}

}
