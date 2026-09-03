package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class DHIRequestTest {

	@Test
	void testDefaultConstructor() {

		DHIRequest request = new DHIRequest();

		assertNotNull(request);
		assertNull(request.getApplicationId());
		assertNull(request.getNoticeDate());
		assertNull(request.getNurseName());
		assertNull(request.getFormAbbreviation());
		assertNull(request.getLoggedInUserPersonType());
	}

	@Test
	void testParameterizedConstructor() {

		Long applicationId = 100L;
		String noticeDate = "08/19/2026";
		String nurseName = "John Smith";
		String formAbbreviation = "DHI";
		String loggedInUserPersonType = "NURSE";

		DHIRequest request = new DHIRequest(applicationId, noticeDate, nurseName, formAbbreviation,
				loggedInUserPersonType);

		assertEquals(applicationId, request.getApplicationId());
		assertEquals(noticeDate, request.getNoticeDate());
		assertEquals(nurseName, request.getNurseName());
		assertEquals(formAbbreviation, request.getFormAbbreviation());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());
	}

	@Test
	void testSettersAndGetters() {

		DHIRequest request = new DHIRequest();

		Long applicationId = 200L;
		String noticeDate = "08/20/2026";
		String nurseName = "Jane Doe";
		String formAbbreviation = "DHI-760";
		String loggedInUserPersonType = "ADMIN";

		request.setApplicationId(applicationId);
		request.setNoticeDate(noticeDate);
		request.setNurseName(nurseName);
		request.setFormAbbreviation(formAbbreviation);
		request.setLoggedInUserPersonType(loggedInUserPersonType);

		assertEquals(applicationId, request.getApplicationId());
		assertEquals(noticeDate, request.getNoticeDate());
		assertEquals(nurseName, request.getNurseName());
		assertEquals(formAbbreviation, request.getFormAbbreviation());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {

		DHIRequest request = new DHIRequest(100L, "08/19/2026", "John Smith", "DHI", "NURSE");

		String expectedString = "DHIRequest [applicationId=100, noticeDate=08/19/2026, "
				+ "nurseName=John Smith, formAbbreviation=DHI, loggedInUserPersonType=NURSE]";

		assertEquals(expectedString, request.toString());
	}

	@Test
	void testToStringWithNullValues() {

		DHIRequest request = new DHIRequest(100L, "08/19/2026", "John Smith", "DHI", null);

		String expectedString = "DHIRequest [applicationId=100, noticeDate=08/19/2026, "
				+ "nurseName=John Smith, formAbbreviation=DHI, loggedInUserPersonType=null]";

		assertEquals(expectedString, request.toString());
	}
}
