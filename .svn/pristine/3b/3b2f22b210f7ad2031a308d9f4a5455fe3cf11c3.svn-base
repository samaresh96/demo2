package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ApplicationInfoRespTest {

	@Test
	void testDefaultConstructor() {
		ApplicationInfoResp response = new ApplicationInfoResp();

		assertNotNull(response);
		assertEquals(0L, response.getApplicationId());
		assertEquals(null, response.getApplicationType());
		assertEquals(null, response.getApplicationTypeAbbreviation());
		assertEquals(null, response.getApplicationStatus());
		assertEquals(null, response.getApplicationStatusAbbrev());
		assertEquals(null, response.getRequestDate());
		assertEquals(null, response.getClassification());
		assertEquals(null, response.getStudentId());
		assertEquals(null, response.getStudentName());
		assertEquals(null, response.getSchoolYear());
		assertEquals(null, response.getApplicationNo());
		assertEquals(null, response.getStudentDob());
		assertEquals(null, response.getStudentGender());
		assertEquals(null, response.getStudentGrade());
		assertEquals(0, response.getStudentGradeId());
		assertEquals(null, response.getStudentSchool());
		assertEquals(null, response.getStudentSchoolCode());
		assertEquals(null, response.getTeacherIds());
		assertEquals(null, response.getHiApproverComment());
		assertEquals(null, response.getHiApproved());
	}

	@Test
	void testParameterizedConstructor() {

		long applicationId = 100L;
		String applicationType = "Medical";
		String applicationTypeAbbreviation = "MED";
		String applicationStatus = "Approved";
		String applicationStatusAbbrev = "APP";
		String requestDate = "2026-08-08";
		String classification = "classification";
		Long studentId = 1001L;
		String studentName = "John Doe";
		String schoolYear = "2026-2027";
		String applicationNo = "APP-2026-001";
		String studentDob = "2010-05-15";
		String studentGender = "Male";
		String studentGrade = "Grade 10";
		int studentGradeId = 10;
		String studentSchool = "ABC High School";
		String studentSchoolCode = "SCH001";
		String teacherIds = "12,34";
		String hiApproverComment = "Comment";
		Boolean hiApproved = true;

		ApplicationInfoResp response = new ApplicationInfoResp(applicationId, applicationType,
				applicationTypeAbbreviation, applicationStatus, applicationStatusAbbrev, requestDate, classification,
				studentId, studentName, schoolYear, applicationNo, studentDob, studentGender, studentGrade,
				studentGradeId, studentSchool, studentSchoolCode, teacherIds, hiApproverComment, hiApproved);

		assertEquals(applicationId, response.getApplicationId());
		assertEquals(applicationType, response.getApplicationType());
		assertEquals(applicationTypeAbbreviation, response.getApplicationTypeAbbreviation());
		assertEquals(applicationStatus, response.getApplicationStatus());
		assertEquals(applicationStatusAbbrev, response.getApplicationStatusAbbrev());
		assertEquals(requestDate, response.getRequestDate());
		assertEquals(classification, response.getClassification());
		assertEquals(studentId, response.getStudentId());
		assertEquals(studentName, response.getStudentName());
		assertEquals(schoolYear, response.getSchoolYear());
		assertEquals(applicationNo, response.getApplicationNo());
		assertEquals(studentDob, response.getStudentDob());
		assertEquals(studentGender, response.getStudentGender());
		assertEquals(studentGrade, response.getStudentGrade());
		assertEquals(studentGradeId, response.getStudentGradeId());
		assertEquals(studentSchool, response.getStudentSchool());
		assertEquals(studentSchoolCode, response.getStudentSchoolCode());
		assertEquals(teacherIds, response.getTeacherIds());
		assertEquals(hiApproverComment, response.getHiApproverComment());
		assertEquals(hiApproved, response.getHiApproved());
	}

	@Test
	void testSettersAndGetters() {

		ApplicationInfoResp response = new ApplicationInfoResp();

		response.setApplicationId(200L);
		response.setApplicationType("Academic");
		response.setApplicationTypeAbbreviation("ACD");
		response.setApplicationStatus("Pending");
		response.setApplicationStatusAbbrev("PEN");
		response.setRequestDate("2026-09-01");
		response.setClassification("classification");
		response.setStudentId(2002L);
		response.setStudentName("Jane Smith");
		response.setSchoolYear("2025-2026");
		response.setApplicationNo("APP-2026-002");
		response.setStudentDob("2011-06-20");
		response.setStudentGender("Female");
		response.setStudentGrade("Grade 9");
		response.setStudentGradeId(9);
		response.setStudentSchool("XYZ School");
		response.setStudentSchoolCode("SCH002");
		response.setTeacherIds("56,78");
		response.setHiApproverComment("Approved by HI");
		response.setHiApproved(true);

		assertEquals(200L, response.getApplicationId());
		assertEquals("Academic", response.getApplicationType());
		assertEquals("ACD", response.getApplicationTypeAbbreviation());
		assertEquals("Pending", response.getApplicationStatus());
		assertEquals("PEN", response.getApplicationStatusAbbrev());
		assertEquals("2026-09-01", response.getRequestDate());
		assertEquals("classification", response.getClassification());
		assertEquals(Long.valueOf(2002L), response.getStudentId());
		assertEquals("Jane Smith", response.getStudentName());
		assertEquals("2025-2026", response.getSchoolYear());
		assertEquals("APP-2026-002", response.getApplicationNo());
		assertEquals("2011-06-20", response.getStudentDob());
		assertEquals("Female", response.getStudentGender());
		assertEquals("Grade 9", response.getStudentGrade());
		assertEquals(9, response.getStudentGradeId());
		assertEquals("XYZ School", response.getStudentSchool());
		assertEquals("SCH002", response.getStudentSchoolCode());
		assertEquals("56,78", response.getTeacherIds());
		assertEquals("Approved by HI", response.getHiApproverComment());
		assertEquals(true, response.getHiApproved());
	}

	@Test
	void testToString() {

		ApplicationInfoResp resp = new ApplicationInfoResp();

		String expectedString = "ApplicationInfoResp [applicationId=0, applicationType=null, "
				+ "applicationTypeAbbreviation=null, applicationStatus=null, applicationStatusAbbrev=null, "
				+ "requestDate=null, classification=null, studentId=null, studentName=null, schoolYear=null, "
				+ "applicationNo=null, studentDob=null, studentGender=null, studentGrade=null, studentGradeId=0, "
				+ "studentSchool=null, studentSchoolCode=null, teacherIds=null, hiApproverComment=null, "
				+ "hiApproved=null]";

		assertEquals(expectedString, resp.toString());
	}
}
