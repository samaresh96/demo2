package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Form2RequestTest {

	@Test
	public void testDefaultConstructor() {
		Form2Request request = new Form2Request();

		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		String indicator = "Y";
		String schoolYear = "2026-2027";
		Integer id = 10;
		String studentId = "STU001";
		String activity = "Medical Review";
		String status = "APPROVED";
		String comment = "Approved by physician";
		long applicationId = 100L;
		long formMasterId = 200L;
		String formAbbreviation = "F2";
		String physicianReview = "Reviewed";
		String hiEndDate = "2026-12-31";
		String nurseSignature = "Nurse Signature";
		String nurseSignDate = "2026-08-08";
		Boolean isAgree = Boolean.TRUE;
		String physicianSignature = "Physician Signature";
		String physicianSignDate = "2026-08-08";
		String loggedInUserId = "USER001";
		String loggedInUserPersonType = "PHYSICIAN";

		Form2Request request = new Form2Request(indicator, schoolYear, id, studentId, activity, status, comment,
				applicationId, formMasterId, formAbbreviation, physicianReview, hiEndDate, nurseSignature,
				nurseSignDate, isAgree, physicianSignature, physicianSignDate, loggedInUserId, loggedInUserPersonType);

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
		assertEquals(physicianReview, request.getPhysicianReview());
		assertEquals(hiEndDate, request.getHiEndDate());
		assertEquals(nurseSignature, request.getNurseSignature());
		assertEquals(nurseSignDate, request.getNurseSignDate());
		assertEquals(isAgree, request.getIsAgree());
		assertEquals(physicianSignature, request.getPhysicianSignature());
		assertEquals(physicianSignDate, request.getPhysicianSignDate());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());

		// otherDocumentName is not part of the parameterized constructor.
		assertEquals(null, request.getOtherDocumentName());
	}

	@Test
	public void testSettersAndGetters() {
		Form2Request request = new Form2Request();

		request.setIndicator("N");
		request.setSchoolYear("2026-2027");
		request.setId(20);
		request.setStudentId("STU002");
		request.setActivity("Test Activity");
		request.setStatus("PENDING");
		request.setComment("Test Comment");
		request.setApplicationId(300L);
		request.setFormMasterId(400L);
		request.setOtherDocumentName("Medical Document");
		request.setFormAbbreviation("F2A");
		request.setPhysicianReview("Pending Review");
		request.setHiEndDate("2026-09-30");
		request.setNurseSignature("Nurse Sign");
		request.setNurseSignDate("2026-08-09");
		request.setIsAgree(Boolean.FALSE);
		request.setPhysicianSignature("Physician Sign");
		request.setPhysicianSignDate("2026-08-10");
		request.setLoggedInUserId("USER002");
		request.setLoggedInUserPersonType("NURSE");

		assertEquals("N", request.getIndicator());
		assertEquals("2026-2027", request.getSchoolYear());
		assertEquals(Integer.valueOf(20), request.getId());
		assertEquals("STU002", request.getStudentId());
		assertEquals("Test Activity", request.getActivity());
		assertEquals("PENDING", request.getStatus());
		assertEquals("Test Comment", request.getComment());
		assertEquals(300L, request.getApplicationId());
		assertEquals(400L, request.getFormMasterId());
		assertEquals("Medical Document", request.getOtherDocumentName());
		assertEquals("F2A", request.getFormAbbreviation());
		assertEquals("Pending Review", request.getPhysicianReview());
		assertEquals("2026-09-30", request.getHiEndDate());
		assertEquals("Nurse Sign", request.getNurseSignature());
		assertEquals("2026-08-09", request.getNurseSignDate());
		assertEquals(Boolean.FALSE, request.getIsAgree());
		assertEquals("Physician Sign", request.getPhysicianSignature());
		assertEquals("2026-08-10", request.getPhysicianSignDate());
		assertEquals("USER002", request.getLoggedInUserId());
		assertEquals("NURSE", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {
		Form2Request request = new Form2Request();

		String expectedString = "Form2Request [indicator=null" + ", schoolYear=null" + ", id=null" + ", studentId=null"
				+ ", activity=null" + ", status=null" + ", comment=null" + ", applicationId=0" + ", formMasterId=0"
				+ ", otherDocumentName=null" + ", formAbbreviation=null" + ", physicianReview=null" + ", hiEndDate=null"
				+ ", nurseSignature=null" + ", nurseSignDate=null" + ", isAgree=null" + ", physicianSignature=null"
				+ ", physicianSignDate=null" + ", loggedInUserId=null" + ", loggedInUserPersonType=null]";

		assertEquals(expectedString, request.toString());
	}
}
