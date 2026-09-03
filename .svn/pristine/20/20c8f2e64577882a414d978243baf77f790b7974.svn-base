package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Form10RequestTest {

	@Test
	public void testDefaultConstructor() {
		Form10Request request = new Form10Request();

		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {

		String indicator = "I";
		String schoolYear = "2026-2027";
		Long id = 1L;
		String studentId = "STU001";
		String activity = "Activity";
		String status = "Pending";
		String comment = "Comment";
		Long applicationId = 100L;
		Long formMasterId = 200L;
		String formAbbreviation = "F10";
		String subject = "Mathematics";
		String gradeInProgress = "10";
		String teacherName = "John Smith";
		String teacherEmail = "john.smith@test.com";
		Boolean isAdditionalTimeNeeded = Boolean.TRUE;
		String unitOfStudy = "Algebra";
		String assignments = "Assignment 1";
		String independentWork = "Independent Project";
		String assessments = "Quiz";
		String standardsCovered = "Common Core";
		String otherResources = "Workbook";
		String teacherSignature = "TeacherSign";
		String teacherSignDate = "2026-01-01";
		String loggedInUserId = "USER01";
		String loggedInUserPersonType = "ADMIN";

		Form10Request request = new Form10Request(indicator, schoolYear, id, studentId, activity, status, comment,
				applicationId, formMasterId, formAbbreviation, subject, gradeInProgress, teacherName, teacherEmail,
				isAdditionalTimeNeeded, unitOfStudy, assignments, independentWork, assessments, standardsCovered,
				otherResources, teacherSignature, teacherSignDate, loggedInUserId, loggedInUserPersonType);

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
		assertEquals(subject, request.getSubject());
		assertEquals(gradeInProgress, request.getGradeInProgress());
		assertEquals(teacherName, request.getTeacherName());
		assertEquals(teacherEmail, request.getTeacherEmail());
		assertEquals(isAdditionalTimeNeeded, request.getIsAdditionalTimeNeeded());
		assertEquals(unitOfStudy, request.getUnitOfStudy());
		assertEquals(assignments, request.getAssignments());
		assertEquals(independentWork, request.getIndependentWork());
		assertEquals(assessments, request.getAssessments());
		assertEquals(standardsCovered, request.getStandardsCovered());
		assertEquals(otherResources, request.getOtherResources());
		assertEquals(teacherSignature, request.getTeacherSignature());
		assertEquals(teacherSignDate, request.getTeacherSignDate());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());
	}

	@Test
	public void testSettersAndGetters() {

		Form10Request request = new Form10Request();

		request.setIndicator("I");
		request.setSchoolYear("2026-2027");
		request.setId(10L);
		request.setStudentId("STU002");
		request.setActivity("Test Activity");
		request.setStatus("Approved");
		request.setComment("Test Comment");
		request.setApplicationId(300L);
		request.setFormMasterId(400L);
		request.setFormAbbreviation("F10A");
		request.setSubject("Science");
		request.setGradeInProgress("8");
		request.setTeacherName("Jane Doe");
		request.setTeacherEmail("jane.doe@test.com");
		request.setIsAdditionalTimeNeeded(Boolean.FALSE);
		request.setUnitOfStudy("Biology");
		request.setAssignments("Assignment 2");
		request.setIndependentWork("Research Project");
		request.setAssessments("Final Exam");
		request.setStandardsCovered("NGSS");
		request.setOtherResources("Online Resources");
		request.setTeacherSignature("Jane Signature");
		request.setTeacherSignDate("2026-02-01");
		request.setLoggedInUserId("USER02");
		request.setLoggedInUserPersonType("TEACHER");

		assertEquals("I", request.getIndicator());
		assertEquals("2026-2027", request.getSchoolYear());
		assertEquals(Long.valueOf(10L), request.getId());
		assertEquals("STU002", request.getStudentId());
		assertEquals("Test Activity", request.getActivity());
		assertEquals("Approved", request.getStatus());
		assertEquals("Test Comment", request.getComment());
		assertEquals(Long.valueOf(300L), request.getApplicationId());
		assertEquals(Long.valueOf(400L), request.getFormMasterId());
		assertEquals("F10A", request.getFormAbbreviation());
		assertEquals("Science", request.getSubject());
		assertEquals("8", request.getGradeInProgress());
		assertEquals("Jane Doe", request.getTeacherName());
		assertEquals("jane.doe@test.com", request.getTeacherEmail());
		assertEquals(Boolean.FALSE, request.getIsAdditionalTimeNeeded());
		assertEquals("Biology", request.getUnitOfStudy());
		assertEquals("Assignment 2", request.getAssignments());
		assertEquals("Research Project", request.getIndependentWork());
		assertEquals("Final Exam", request.getAssessments());
		assertEquals("NGSS", request.getStandardsCovered());
		assertEquals("Online Resources", request.getOtherResources());
		assertEquals("Jane Signature", request.getTeacherSignature());
		assertEquals("2026-02-01", request.getTeacherSignDate());
		assertEquals("USER02", request.getLoggedInUserId());
		assertEquals("TEACHER", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {

		Form10Request request = new Form10Request();

		String expectedString = "Form10Request [indicator=null" + ", schoolYear=null" + ", id=null" + ", studentId=null"
				+ ", activity=null" + ", status=null" + ", comment=null" + ", applicationId=null"
				+ ", formMasterId=null" + ", formAbbreviation=null" + ", subject=null" + ", gradeInProgress=null"
				+ ", teacherName=null" + ", teacherEmail=null" + ", isAdditionalTimeNeeded=null" + ", unitOfStudy=null"
				+ ", assignments=null" + ", independentWork=null" + ", assessments=null" + ", standardsCovered=null"
				+ ", otherResources=null" + ", teacherSignature=null" + ", teacherSignDate=null"
				+ ", loggedInUserId=null" + ", loggedInUserPersonType=null]";

		assertEquals(expectedString, request.toString());
	}
}
