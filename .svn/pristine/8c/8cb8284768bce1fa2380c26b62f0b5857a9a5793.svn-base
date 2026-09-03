package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Form8RequestTest {

	@Test
	void testDefaultConstructor() {
		Form8Request request = new Form8Request();

		assertNotNull(request);
	}

	@Test
	void testParameterizedConstructor() {
		String indicator = "Y";
		String schoolYear = "2026-2027";
		Long id = 1L;
		String studentId = "STU001";
		String activity = "Medical Leave";
		String status = "APPROVED";
		String comment = "Approved";
		Long applicationId = 100L;
		Long formMasterId = 200L;
		String formAbbreviation = "FORM8";
		String reason = "Medical Reason";
		String medicalCutoffDate = "2026-08-08";
		Boolean isPhysicalLimitation = Boolean.TRUE;
		String nurseComment = "Nurse Comment";
		String nurseSignature = "Nurse Signature";
		String nurseSignDate = "2026-08-08";
		String program = "Computer Science";
		String primaryLanguage = "English";
		String lastPresentDate = "2026-08-01";
		String numberOfDayMissing = "5";
		String hoursOfInstruction = "30";
		String academicLevel = "Undergraduate";
		String studentHistory = "Student History";
		String counsellorSignature = "Counsellor Signature";
		String counsellorSignDate = "2026-08-08";
		String loggedInUserId = "USER001";
		String loggedInUserPersonType = "TEACHER";

		Form8Request request = new Form8Request(indicator, schoolYear, id, studentId, activity, status, comment,
				applicationId, formMasterId, formAbbreviation, reason, medicalCutoffDate, isPhysicalLimitation,
				nurseComment, nurseSignature, nurseSignDate, program, primaryLanguage, lastPresentDate,
				numberOfDayMissing, hoursOfInstruction, academicLevel, studentHistory, counsellorSignature,
				counsellorSignDate, loggedInUserId, loggedInUserPersonType);

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
		assertEquals(reason, request.getReason());
		assertEquals(medicalCutoffDate, request.getMedicalCutoffDate());
		assertEquals(isPhysicalLimitation, request.getIsPhysicalLimitation());
		assertEquals(nurseComment, request.getNurseComment());
		assertEquals(nurseSignature, request.getNurseSignature());
		assertEquals(nurseSignDate, request.getNurseSignDate());
		assertEquals(program, request.getProgram());
		assertEquals(primaryLanguage, request.getPrimaryLanguage());
		assertEquals(lastPresentDate, request.getLastPresentDate());
		assertEquals(numberOfDayMissing, request.getNumberOfDayMissing());
		assertEquals(hoursOfInstruction, request.getHoursOfInstruction());
		assertEquals(academicLevel, request.getAcademicLevel());
		assertEquals(studentHistory, request.getStudentHistory());
		assertEquals(counsellorSignature, request.getCounsellorSignature());
		assertEquals(counsellorSignDate, request.getCounsellorSignDate());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());
	}

	@Test
	void testSettersAndGetters() {
		Form8Request request = new Form8Request();

		request.setIndicator("N");
		request.setSchoolYear("2025-2026");
		request.setId(10L);
		request.setStudentId("STU002");
		request.setActivity("Test Activity");
		request.setStatus("PENDING");
		request.setComment("Test Comment");
		request.setApplicationId(20L);
		request.setFormMasterId(30L);
		request.setFormAbbreviation("F8");
		request.setReason("Test Reason");
		request.setMedicalCutoffDate("2026-09-01");
		request.setIsPhysicalLimitation(Boolean.FALSE);
		request.setNurseComment("Nurse Test Comment");
		request.setNurseSignature("Nurse Test Signature");
		request.setNurseSignDate("2026-09-02");
		request.setProgram("Test Program");
		request.setPrimaryLanguage("French");
		request.setLastPresentDate("2026-08-01");
		request.setNumberOfDayMissing("10");
		request.setHoursOfInstruction("40");
		request.setAcademicLevel("Graduate");
		request.setStudentHistory("Test History");
		request.setCounsellorSignature("Counsellor Signature");
		request.setCounsellorSignDate("2026-09-03");
		request.setLoggedInUserId("USER002");
		request.setLoggedInUserPersonType("STUDENT");

		assertEquals("N", request.getIndicator());
		assertEquals("2025-2026", request.getSchoolYear());
		assertEquals(Long.valueOf(10L), request.getId());
		assertEquals("STU002", request.getStudentId());
		assertEquals("Test Activity", request.getActivity());
		assertEquals("PENDING", request.getStatus());
		assertEquals("Test Comment", request.getComment());
		assertEquals(Long.valueOf(20L), request.getApplicationId());
		assertEquals(Long.valueOf(30L), request.getFormMasterId());
		assertEquals("F8", request.getFormAbbreviation());
		assertEquals("Test Reason", request.getReason());
		assertEquals("2026-09-01", request.getMedicalCutoffDate());
		assertEquals(Boolean.FALSE, request.getIsPhysicalLimitation());
		assertEquals("Nurse Test Comment", request.getNurseComment());
		assertEquals("Nurse Test Signature", request.getNurseSignature());
		assertEquals("2026-09-02", request.getNurseSignDate());
		assertEquals("Test Program", request.getProgram());
		assertEquals("French", request.getPrimaryLanguage());
		assertEquals("2026-08-01", request.getLastPresentDate());
		assertEquals("10", request.getNumberOfDayMissing());
		assertEquals("40", request.getHoursOfInstruction());
		assertEquals("Graduate", request.getAcademicLevel());
		assertEquals("Test History", request.getStudentHistory());
		assertEquals("Counsellor Signature", request.getCounsellorSignature());
		assertEquals("2026-09-03", request.getCounsellorSignDate());
		assertEquals("USER002", request.getLoggedInUserId());
		assertEquals("STUDENT", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {
		Form8Request request = new Form8Request("Y", "2026-2027", 1L, "STU001", "Medical Leave", "APPROVED", "Approved",
				100L, 200L, "FORM8", "Medical Reason", "2026-08-08", Boolean.TRUE, "Nurse Comment", "Nurse Signature",
				"2026-08-08", "Computer Science", "English", "2026-08-01", "5", "30", "Undergraduate",
				"Student History", "Counsellor Signature", "2026-08-08", "USER001", "TEACHER");

		String expectedString = "Form8Request [indicator=Y, schoolYear=2026-2027, id=1, studentId=STU001, "
				+ "activity=Medical Leave, status=APPROVED, comment=Approved, applicationId=100, formMasterId=200, "
				+ "formAbbreviation=FORM8, reason=Medical Reason, medicalCutoffDate=2026-08-08, "
				+ "isPhysicalLimitation=true, nurseComment=Nurse Comment, nurseSignature=Nurse Signature, "
				+ "nurseSignDate=2026-08-08, program=Computer Science, primaryLanguage=English, "
				+ "lastPresentDate=2026-08-01, numberOfDayMissing=5, hoursOfInstruction=30, "
				+ "academicLevel=Undergraduate, studentHistory=Student History, "
				+ "counsellorSignature=Counsellor Signature, counsellorSignDate=2026-08-08, "
				+ "loggedInUserId=USER001, loggedInUserPersonType=TEACHER]";

		assertEquals(expectedString, request.toString());
	}
}
