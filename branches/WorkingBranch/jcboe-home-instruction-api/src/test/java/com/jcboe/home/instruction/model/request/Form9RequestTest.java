package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form9RequestTest {

	@Test
	public void testDefaultConstructor() {
		Form9Request request = new Form9Request();
		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		String indicator = "Y";
		String schoolYear = "2026-2027";
		Long id = 1L;
		String studentId = "STU001";
		String activity = "Activity 1";
		String status = "APPROVED";
		String comment = "Approved";
		Long applicationId = 100L;
		Long formMasterId = 200L;
		String otherDocumentName = "Other Document";
		String formAbbreviation = "FORM9";
		String teacherName = "John Teacher";
		String teacherEmail = "john@example.com";
		String teacherSignature = "signature";
		String teacherSignDate = "2026-08-08";
		List<Form9EAppPlanData> form9EappPlanData = new ArrayList<Form9EAppPlanData>();
		String loggedInUserId = "USER001";
		String loggedInUserPersonType = "TEACHER";

		Form9Request request = new Form9Request(indicator, schoolYear, id, studentId, activity, status, comment,
				applicationId, formMasterId, otherDocumentName, formAbbreviation, teacherName, teacherEmail,
				teacherSignature, form9EappPlanData, loggedInUserId, loggedInUserPersonType);

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
		assertEquals(teacherName, request.getTeacherName());
		assertEquals(teacherEmail, request.getTeacherEmail());
		assertEquals(teacherSignature, request.getTeacherSignature());
		assertEquals(teacherSignDate, request.getTeacherSignDate());
		assertEquals(form9EappPlanData, request.getForm9EappPlanData());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());
	}

	@Test
	public void testSettersAndGetters() {
		Form9Request request = new Form9Request();
		List<Form9EAppPlanData> planData = new ArrayList<Form9EAppPlanData>();

		request.setIndicator("N");
		request.setSchoolYear("2026-2027");
		request.setId(10L);
		request.setStudentId("STU002");
		request.setActivity("Test Activity");
		request.setStatus("PENDING");
		request.setComment("Test Comment");
		request.setApplicationId(20L);
		request.setFormMasterId(30L);
		request.setFormAbbreviation("F9");
		request.setTeacherName("Test Teacher");
		request.setTeacherEmail("teacher@test.com");
		request.setTeacherSignature("Test Signature");
		request.setTeacherSignDate("2026-08-08");
		request.setForm9EappPlanData(planData);
		request.setLoggedInUserId("USER002");
		request.setLoggedInUserPersonType("STUDENT");

		assertEquals("N", request.getIndicator());
		assertEquals("2026-2027", request.getSchoolYear());
		assertEquals(Long.valueOf(10L), request.getId());
		assertEquals("STU002", request.getStudentId());
		assertEquals("Test Activity", request.getActivity());
		assertEquals("PENDING", request.getStatus());
		assertEquals("Test Comment", request.getComment());
		assertEquals(Long.valueOf(20L), request.getApplicationId());
		assertEquals(Long.valueOf(30L), request.getFormMasterId());
		assertEquals("F9", request.getFormAbbreviation());
		assertEquals("Test Teacher", request.getTeacherName());
		assertEquals("teacher@test.com", request.getTeacherEmail());
		assertEquals("Test Signature", request.getTeacherSignature());
		assertEquals("2026-08-08", request.getTeacherSignDate());
		assertEquals(planData, request.getForm9EappPlanData());
		assertEquals("USER002", request.getLoggedInUserId());
		assertEquals("STUDENT", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {
		Form9Request request = new Form9Request();

		String expectedString = "Form9Request [indicator=null, id=null, studentId=null, activity=null, "
				+ "status=null, comment=null, applicationId=null, formMasterId=null, otherDocumentName=null, "
				+ "formAbbreviation=null, teacherName=null, teacherEmail=null, teacherSignature=null, "
				+ "teacherSignDate=null, form9EappPlanData=null, loggedInUserId=null, "
				+ "loggedInUserPersonType=null]";

		assertEquals(expectedString, request.toString());
	}
}
