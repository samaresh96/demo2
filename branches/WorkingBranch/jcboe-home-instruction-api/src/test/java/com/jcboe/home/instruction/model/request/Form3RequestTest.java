package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Form3RequestTest {

	@Test
	public void testDefaultConstructor() {
		Form3Request request = new Form3Request();

		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		String indicator = "Y";
		String schoolYear = "2026-2027";
		Long id = 10L;
		String studentId = "STU001";
		String activity = "Injury Report";
		String status = "SUBMITTED";
		String comment = "Test comment";
		Long applicationId = 100L;
		Long formMasterId = 200L;
		String formAbbreviation = "F3";
		String injuryType = "Sports Injury";
		String lengthOfAbsence = "5 Days";
		String parentSignature = "Parent Signature";
		String parentSignDate = "2026-08-08";
		String receivedBy = "School Nurse";
		String nurseSignature = "Nurse Signature";
		String nurseSignDate = "2026-08-08";
		Boolean isApplicationGiven = Boolean.TRUE;
		String loggedInUserId = "USER001";
		String loggedInUserPersonType = "NURSE";

		Form3Request request = new Form3Request(indicator, schoolYear, id, studentId, activity, status, comment,
				applicationId, formMasterId, formAbbreviation, injuryType, lengthOfAbsence, parentSignature,
				parentSignDate, receivedBy, nurseSignature, nurseSignDate, isApplicationGiven, loggedInUserId,
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

		// otherDocumentName is not included in the parameterized constructor
		assertEquals(null, request.getOtherDocumentName());

		assertEquals(formAbbreviation, request.getFormAbbreviation());
		assertEquals(injuryType, request.getInjuryType());
		assertEquals(lengthOfAbsence, request.getLengthOfAbsence());
		assertEquals(parentSignature, request.getParentSignature());
		assertEquals(parentSignDate, request.getParentSignDate());
		assertEquals(receivedBy, request.getReceivedBy());
		assertEquals(nurseSignature, request.getNurseSignature());
		assertEquals(nurseSignDate, request.getNurseSignDate());
		assertEquals(isApplicationGiven, request.getIsApplicationGiven());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());
	}

	@Test
	public void testSettersAndGetters() {
		Form3Request request = new Form3Request();

		request.setIndicator("N");
		request.setSchoolYear("2026-2027");
		request.setId(20L);
		request.setStudentId("STU002");
		request.setActivity("Medical Activity");
		request.setStatus("PENDING");
		request.setComment("Pending review");
		request.setApplicationId(300L);
		request.setFormMasterId(400L);
		request.setOtherDocumentName("Injury Certificate");
		request.setFormAbbreviation("F3A");
		request.setInjuryType("Fall Injury");
		request.setLengthOfAbsence("10 Days");
		request.setParentSignature("Parent Sign");
		request.setParentSignDate("2026-08-09");
		request.setReceivedBy("Nurse");
		request.setNurseSignature("Nurse Sign");
		request.setNurseSignDate("2026-08-10");
		request.setIsApplicationGiven(Boolean.FALSE);
		request.setLoggedInUserId("USER002");
		request.setLoggedInUserPersonType("TEACHER");

		assertEquals("N", request.getIndicator());
		assertEquals("2026-2027", request.getSchoolYear());
		assertEquals(Long.valueOf(20L), request.getId());
		assertEquals("STU002", request.getStudentId());
		assertEquals("Medical Activity", request.getActivity());
		assertEquals("PENDING", request.getStatus());
		assertEquals("Pending review", request.getComment());
		assertEquals(Long.valueOf(300L), request.getApplicationId());
		assertEquals(Long.valueOf(400L), request.getFormMasterId());
		assertEquals("Injury Certificate", request.getOtherDocumentName());
		assertEquals("F3A", request.getFormAbbreviation());
		assertEquals("Fall Injury", request.getInjuryType());
		assertEquals("10 Days", request.getLengthOfAbsence());
		assertEquals("Parent Sign", request.getParentSignature());
		assertEquals("2026-08-09", request.getParentSignDate());
		assertEquals("Nurse", request.getReceivedBy());
		assertEquals("Nurse Sign", request.getNurseSignature());
		assertEquals("2026-08-10", request.getNurseSignDate());
		assertEquals(Boolean.FALSE, request.getIsApplicationGiven());
		assertEquals("USER002", request.getLoggedInUserId());
		assertEquals("TEACHER", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {
		Form3Request request = new Form3Request();

		String expectedString = "Form3Request [indicator=null" + ", schoolYear=null" + ", id=null" + ", studentId=null"
				+ ", activity=null" + ", status=null" + ", comment=null" + ", applicationId=null"
				+ ", formMasterId=null" + ", otherDocumentName=null" + ", formAbbreviation=null" + ", injuryType=null"
				+ ", lengthOfAbsence=null" + ", parentSignature=null" + ", parentSignDate=null" + ", receivedBy=null"
				+ ", nurseSignature=null" + ", nurseSignDate=null" + ", isApplicationGiven=null"
				+ ", loggedInUserId=null" + ", loggedInUserPersonType=null]";

		assertEquals(expectedString, request.toString());
	}
}
