package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetApplicationTrackingRespTest {

	@Test
	void testNoArgsConstructor() {
		GetApplicationTrackingResp dto = new GetApplicationTrackingResp();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		Long applicationId = 1001L;
		String applicationNo = "APP-001";
		String schoolYear = "2026-2027";
		String school = "ABC High School";
		String grade = "10";
		String studentName = "John Doe";
		Long applicationTrackingId = 2001L;
		String verificationDate = "2026-08-01";
		String noticeDate30Day = "2026-08-30";
		String noticeDate60Day = "2026-09-30";
		String cstAction = "Approved";
		String returnDate = "2026-10-01";

		GetApplicationTrackingResp dto = new GetApplicationTrackingResp(applicationId, applicationNo, schoolYear,
				school, grade, studentName, applicationTrackingId, verificationDate, noticeDate30Day, noticeDate60Day,
				cstAction, returnDate);

		assertEquals(applicationId, dto.getApplicationId());
		assertEquals(applicationNo, dto.getApplicationNo());
		assertEquals(schoolYear, dto.getSchoolYear());
		assertEquals(school, dto.getSchool());
		assertEquals(grade, dto.getGrade());
		assertEquals(studentName, dto.getStudentName());
		assertEquals(applicationTrackingId, dto.getApplicationTrackingId());
		assertEquals(verificationDate, dto.getVerificationDate());
		assertEquals(noticeDate30Day, dto.getNoticeDate30Day());
		assertEquals(noticeDate60Day, dto.getNoticeDate60Day());
		assertEquals(cstAction, dto.getCstAction());
		assertEquals(returnDate, dto.getReturnDate());
	}

	@Test
	void testGettersAndSetters() {
		GetApplicationTrackingResp dto = new GetApplicationTrackingResp();

		Long applicationId = 1002L;
		String applicationNo = "APP-002";
		String schoolYear = "2025-2026";
		String school = "XYZ Public School";
		String grade = "12";
		String studentName = "Jane Doe";
		Long applicationTrackingId = 2002L;
		String verificationDate = "2026-07-01";
		String noticeDate30Day = "2026-07-30";
		String noticeDate60Day = "2026-08-30";
		String cstAction = "Pending";
		String returnDate = "2026-09-01";

		dto.setApplicationId(applicationId);
		dto.setApplicationNo(applicationNo);
		dto.setSchoolYear(schoolYear);
		dto.setSchool(school);
		dto.setGrade(grade);
		dto.setStudentName(studentName);
		dto.setApplicationTrackingId(applicationTrackingId);
		dto.setVerificationDate(verificationDate);
		dto.setNoticeDate30Day(noticeDate30Day);
		dto.setNoticeDate60Day(noticeDate60Day);
		dto.setCstAction(cstAction);
		dto.setReturnDate(returnDate);

		assertEquals(applicationId, dto.getApplicationId());
		assertEquals(applicationNo, dto.getApplicationNo());
		assertEquals(schoolYear, dto.getSchoolYear());
		assertEquals(school, dto.getSchool());
		assertEquals(grade, dto.getGrade());
		assertEquals(studentName, dto.getStudentName());
		assertEquals(applicationTrackingId, dto.getApplicationTrackingId());
		assertEquals(verificationDate, dto.getVerificationDate());
		assertEquals(noticeDate30Day, dto.getNoticeDate30Day());
		assertEquals(noticeDate60Day, dto.getNoticeDate60Day());
		assertEquals(cstAction, dto.getCstAction());
		assertEquals(returnDate, dto.getReturnDate());
	}

	@Test
	void testToString() {
		GetApplicationTrackingResp dto = new GetApplicationTrackingResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dto.toString());
	}

}
