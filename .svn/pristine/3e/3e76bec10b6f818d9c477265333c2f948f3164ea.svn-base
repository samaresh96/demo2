package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Form760DHIRequestTest {

	@Test
	public void testDefaultConstructor() {
		Form760DHIRequest request = new Form760DHIRequest();
		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		String indicator = "Y";
		String schoolYear = "2026-2027";
		Long id = 1L;
		String studentId = "STU001";
		String activity = "DHI Activity";
		String status = "APPROVED";
		String comment = "Approved";
		Long applicationId = 100L;
		Long formMasterId = 200L;
		String formAbbreviation = "760DHI";
		String nurseName = "Jane Nurse";
		String noticeDate = "2026-08-08";
		String loggedInUserId = "USER001";
		String loggedInUserPersonType = "NURSE";

		Form760DHIRequest request = new Form760DHIRequest(indicator, schoolYear, id, studentId, activity, status,
				comment, applicationId, formMasterId, formAbbreviation, nurseName, noticeDate, loggedInUserId,
				loggedInUserPersonType);

		assertEquals(indicator, request.getIndicator());
		assertEquals(schoolYear, request.getSchoolYear());
		assertEquals(id, request.getId());
		assertEquals(studentId, request.getStudentId());
		assertEquals(activity, request.getActivity());
		assertEquals(status, request.getStatus());
		assertEquals(comment, request.getComment());
		assertEquals(applicationId, request.getApplicationId());
		assertEquals(formMasterId, request.getFormMasterId());
		assertEquals(formAbbreviation, request.getFormAbbreviation());
		assertEquals(nurseName, request.getNurseName());
		assertEquals(noticeDate, request.getNoticeDate());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());
	}

	@Test
	public void testSettersAndGetters() {
		Form760DHIRequest request = new Form760DHIRequest();

		request.setIndicator("N");
		request.setSchoolYear("2026-2027");
		request.setId(10L);
		request.setStudentId("STU002");
		request.setActivity("Test Activity");
		request.setStatus("PENDING");
		request.setComment("Test Comment");
		request.setApplicationId(20L);
		request.setFormMasterId(30L);
		request.setFormAbbreviation("760DHI");
		request.setNurseName("Test Nurse");
		request.setNoticeDate("2026-09-01");
		request.setLoggedInUserId("USER002");
		request.setLoggedInUserPersonType("PHYSICIAN");

		assertEquals("N", request.getIndicator());
		assertEquals("2026-2027", request.getSchoolYear());
		assertEquals(Long.valueOf(10L), request.getId());
		assertEquals("STU002", request.getStudentId());
		assertEquals("Test Activity", request.getActivity());
		assertEquals("PENDING", request.getStatus());
		assertEquals("Test Comment", request.getComment());
		assertEquals(Long.valueOf(20L), request.getApplicationId());
		assertEquals(Long.valueOf(30L), request.getFormMasterId());
		assertEquals("760DHI", request.getFormAbbreviation());
		assertEquals("Test Nurse", request.getNurseName());
		assertEquals("2026-09-01", request.getNoticeDate());
		assertEquals("USER002", request.getLoggedInUserId());
		assertEquals("PHYSICIAN", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {
		Form760DHIRequest request = new Form760DHIRequest();

		String expectedString = "Form760DHIRequest [indicator=null, schoolYear=null, id=null, "
				+ "studentId=null, activity=null, status=null, comment=null, applicationId=null, "
				+ "formMasterId=null, formAbbreviation=null, nurseName=null, noticeDate=null, "
				+ "loggedInUserId=null, loggedInUserPersonType=null]";

		assertEquals(expectedString, request.toString());
	}
}
