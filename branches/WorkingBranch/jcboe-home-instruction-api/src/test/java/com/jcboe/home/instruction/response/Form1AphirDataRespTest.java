package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class Form1AphirDataRespTest {

	@Test
	void testDefaultConstructor() {

		Form1AphirDataResp response = new Form1AphirDataResp();

		assertNotNull(response);

		assertEquals(0L, response.getId());
		assertEquals(0L, response.getApplicationId());
		assertEquals(0L, response.getFormTransactionId());
		assertNull(response.getApplicationType());
		assertNull(response.getApplicationTypeAbbreviation());
		assertNull(response.getApplicationStatus());
		assertNull(response.getApplicationStatusAbbrev());
		assertNull(response.getRequestDate());
		assertNull(response.getStudentId());
		assertNull(response.getStudentName());
		assertNull(response.getSchoolYear());
		assertNull(response.getApplicationNo());
		assertNull(response.getStudentDob());
		assertNull(response.getStudentGender());
		assertNull(response.getStudentGrade());
		assertEquals(0, response.getStudentGradeId());
		assertNull(response.getStudentSchool());
		assertNull(response.getStudentSchoolCode());
		assertNull(response.getClassification());
		assertNull(response.getParentName());
		assertNull(response.getHomePhone());
		assertNull(response.getWorkPhone());
		assertNull(response.getEmergencyPhone());
		assertNull(response.getHomeAddress());
		assertNull(response.getEmailAddress());
		assertNull(response.getCounselorName());
		assertNull(response.getCounselorPhone());
		assertNull(response.getNurseName());
		assertNull(response.getNursePhone());
		assertNull(response.getAttendanceLastDate());
		assertNull(response.getReason());
		assertNull(response.getCaseNotification());
		assertNull(response.getNotificationDate());
		assertNull(response.getParentSignature());
		assertNull(response.getParentSignDate());
		assertNull(response.getPrincipalSignature());
		assertNull(response.getPrincipalSignDate());
		assertNull(response.getDirSplEdSignature());
		assertNull(response.getDirSplEdSignDate());
		assertNull(response.getDirSupSignature());
		assertNull(response.getDirSupSignDate());
		assertNull(response.getDirStuLifeService());
		assertNull(response.getDirStuLifeDate());
		assertNull(response.getIsApprove());
		assertNull(response.getApproveUptoDate());
		assertNull(response.getPhysicianSignature());
		assertNull(response.getPhysicianSignDate());
	}

	@Test
	void testParameterizedConstructor() {

		Form1AphirDataResp response = new Form1AphirDataResp(1L, 100L, 200L, "Medical", "MED", "Approved", "APP",
				"2026-08-08", 1001L, "John Doe", "2026-2027", "APP-2026-001", "2010-05-15", "Male", "Grade 10", 10,
				"ABC High School", "SCH001", "Class A", "John Parent", "111-222-3333", "444-555-6666", "777-888-9999",
				"123 Main Street", "parent@example.com", "Jane Counselor", "111-333-5555", "Mary Nurse", "222-444-6666",
				"2026-08-01", "Medical Reason", "Notification Sent", "2026-08-02", "Parent Signature", "2026-08-03",
				"Principal Signature", "2026-08-04", "Special Education Signature", "2026-08-05",
				"Supervisor Signature", "2026-08-06", "Student Life Service", "2026-08-07", true, "2026-12-31",
				"Physician Signature", "2026-08-08");

		assertEquals(1L, response.getId());
		assertEquals(100L, response.getApplicationId());
		assertEquals(200L, response.getFormTransactionId());
		assertEquals("Medical", response.getApplicationType());
		assertEquals("MED", response.getApplicationTypeAbbreviation());
		assertEquals("Approved", response.getApplicationStatus());
		assertEquals("APP", response.getApplicationStatusAbbrev());
		assertEquals("2026-08-08", response.getRequestDate());
		assertEquals(1001L, response.getStudentId());
		assertEquals("John Doe", response.getStudentName());
		assertEquals("2026-2027", response.getSchoolYear());
		assertEquals("APP-2026-001", response.getApplicationNo());
		assertEquals("2010-05-15", response.getStudentDob());
		assertEquals("Male", response.getStudentGender());
		assertEquals("Grade 10", response.getStudentGrade());
		assertEquals(10, response.getStudentGradeId());
		assertEquals("ABC High School", response.getStudentSchool());
		assertEquals("SCH001", response.getStudentSchoolCode());
		assertEquals("Class A", response.getClassification());
		assertEquals("John Parent", response.getParentName());
		assertEquals("111-222-3333", response.getHomePhone());
		assertEquals("444-555-6666", response.getWorkPhone());
		assertEquals("777-888-9999", response.getEmergencyPhone());
		assertEquals("123 Main Street", response.getHomeAddress());
		assertEquals("parent@example.com", response.getEmailAddress());
		assertEquals("Jane Counselor", response.getCounselorName());
		assertEquals("111-333-5555", response.getCounselorPhone());
		assertEquals("Mary Nurse", response.getNurseName());
		assertEquals("222-444-6666", response.getNursePhone());
		assertEquals("2026-08-01", response.getAttendanceLastDate());
		assertEquals("Medical Reason", response.getReason());
		assertEquals("Notification Sent", response.getCaseNotification());
		assertEquals("2026-08-02", response.getNotificationDate());
		assertEquals("Parent Signature", response.getParentSignature());
		assertEquals("2026-08-03", response.getParentSignDate());
		assertEquals("Principal Signature", response.getPrincipalSignature());
		assertEquals("2026-08-04", response.getPrincipalSignDate());
		assertEquals("Special Education Signature", response.getDirSplEdSignature());
		assertEquals("2026-08-05", response.getDirSplEdSignDate());
		assertEquals("Supervisor Signature", response.getDirSupSignature());
		assertEquals("2026-08-06", response.getDirSupSignDate());
		assertEquals("Student Life Service", response.getDirStuLifeService());
		assertEquals("2026-08-07", response.getDirStuLifeDate());
		assertEquals(Boolean.TRUE, response.getIsApprove());
		assertEquals("2026-12-31", response.getApproveUptoDate());
		assertEquals("Physician Signature", response.getPhysicianSignature());
		assertEquals("2026-08-08", response.getPhysicianSignDate());
	}

	@Test
	void testSettersAndGetters() {

		Form1AphirDataResp response = new Form1AphirDataResp();

		response.setId(10L);
		response.setApplicationId(20L);
		response.setFormTransactionId(30L);
		response.setApplicationType("Academic");
		response.setApplicationTypeAbbreviation("ACD");
		response.setApplicationStatus("Pending");
		response.setApplicationStatusAbbrev("PEN");
		response.setRequestDate("2026-09-01");
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
		response.setClassification("Class B");
		response.setParentName("Jane Parent");
		response.setHomePhone("1111111111");
		response.setWorkPhone("2222222222");
		response.setEmergencyPhone("3333333333");
		response.setHomeAddress("456 Test Street");
		response.setEmailAddress("test@example.com");
		response.setCounselorName("Test Counselor");
		response.setCounselorPhone("4444444444");
		response.setNurseName("Test Nurse");
		response.setNursePhone("5555555555");
		response.setAttendanceLastDate("2026-08-15");
		response.setReason("Test Reason");
		response.setCaseNotification("Test Notification");
		response.setNotificationDate("2026-08-16");
		response.setParentSignature("Parent Sign");
		response.setParentSignDate("2026-08-17");
		response.setPrincipalSignature("Principal Sign");
		response.setPrincipalSignDate("2026-08-18");
		response.setDirSplEdSignature("Special Ed Sign");
		response.setDirSplEdSignDate("2026-08-19");
		response.setDirSupSignature("Supervisor Sign");
		response.setDirSupSignDate("2026-08-20");
		response.setDirStuLifeService("Student Life");
		response.setDirStuLifeDate("2026-08-21");
		response.setIsApprove(true);
		response.setApproveUptoDate("2026-12-30");
		response.setPhysicianSignature("Physician Sign");
		response.setPhysicianSignDate("2026-08-22");

		assertEquals(10L, response.getId());
		assertEquals(20L, response.getApplicationId());
		assertEquals(30L, response.getFormTransactionId());
		assertEquals("Academic", response.getApplicationType());
		assertEquals("ACD", response.getApplicationTypeAbbreviation());
		assertEquals("Pending", response.getApplicationStatus());
		assertEquals("PEN", response.getApplicationStatusAbbrev());
		assertEquals("2026-09-01", response.getRequestDate());
		assertEquals(2002L, response.getStudentId());
		assertEquals("Jane Smith", response.getStudentName());
		assertEquals("2025-2026", response.getSchoolYear());
		assertEquals("APP-2026-002", response.getApplicationNo());
		assertEquals("2011-06-20", response.getStudentDob());
		assertEquals("Female", response.getStudentGender());
		assertEquals("Grade 9", response.getStudentGrade());
		assertEquals(9, response.getStudentGradeId());
		assertEquals("XYZ School", response.getStudentSchool());
		assertEquals("SCH002", response.getStudentSchoolCode());
		assertEquals("Class B", response.getClassification());
		assertEquals("Jane Parent", response.getParentName());
		assertEquals("1111111111", response.getHomePhone());
		assertEquals("2222222222", response.getWorkPhone());
		assertEquals("3333333333", response.getEmergencyPhone());
		assertEquals("456 Test Street", response.getHomeAddress());
		assertEquals("test@example.com", response.getEmailAddress());
		assertEquals("Test Counselor", response.getCounselorName());
		assertEquals("4444444444", response.getCounselorPhone());
		assertEquals("Test Nurse", response.getNurseName());
		assertEquals("5555555555", response.getNursePhone());
		assertEquals("2026-08-15", response.getAttendanceLastDate());
		assertEquals("Test Reason", response.getReason());
		assertEquals("Test Notification", response.getCaseNotification());
		assertEquals("2026-08-16", response.getNotificationDate());
		assertEquals("Parent Sign", response.getParentSignature());
		assertEquals("2026-08-17", response.getParentSignDate());
		assertEquals("Principal Sign", response.getPrincipalSignature());
		assertEquals("2026-08-18", response.getPrincipalSignDate());
		assertEquals("Special Ed Sign", response.getDirSplEdSignature());
		assertEquals("2026-08-19", response.getDirSplEdSignDate());
		assertEquals("Supervisor Sign", response.getDirSupSignature());
		assertEquals("2026-08-20", response.getDirSupSignDate());
		assertEquals("Student Life", response.getDirStuLifeService());
		assertEquals("2026-08-21", response.getDirStuLifeDate());
		assertEquals(Boolean.TRUE, response.getIsApprove());
		assertEquals("2026-12-30", response.getApproveUptoDate());
		assertEquals("Physician Sign", response.getPhysicianSignature());
		assertEquals("2026-08-22", response.getPhysicianSignDate());
	}

	@Test
	void testSetIsApproveFalse() {

		Form1AphirDataResp response = new Form1AphirDataResp();

		response.setIsApprove(false);

		assertEquals(Boolean.FALSE, response.getIsApprove());
	}

	@Test
	void testSetIsApproveNull() {

		Form1AphirDataResp response = new Form1AphirDataResp();

		response.setIsApprove(null);

		assertNull(response.getIsApprove());
	}

	@Test
	void testToString() {

		Form1AphirDataResp response = new Form1AphirDataResp();

		String expected = "Form1AphirDataResp [id=0, applicationId=0, formTransactionId=0, "
				+ "applicationType=null, applicationTypeAbbreviation=null, "
				+ "applicationStatus=null, applicationStatusAbbrev=null, "
				+ "requestDate=null, studentId=null, studentName=null, "
				+ "schoolYear=null, applicationNo=null, studentDob=null, "
				+ "studentGender=null, studentGrade=null, studentGradeId=0, "
				+ "studentSchool=null, studentSchoolCode=null, classification=null, "
				+ "parentName=null, homePhone=null, workPhone=null, emergencyPhone=null, "
				+ "homeAddress=null, emailAddress=null, counselorName=null, "
				+ "counselorPhone=null, nurseName=null, nursePhone=null, "
				+ "attendanceLastDate=null, reason=null, caseNotification=null, "
				+ "notificationDate=null, parentSignature=null, parentSignDate=null, "
				+ "principalSignature=null, principalSignDate=null, "
				+ "dirSplEdSignature=null, dirSplEdSignDate=null, " + "dirSupSignature=null, dirSupSignDate=null, "
				+ "dirStuLifeService=null, dirStuLifeDate=null, isApprove=null, "
				+ "approveUptoDate=null, physicianSignature=null, physicianSignDate=null]";

		assertEquals(expected, response.toString());
	}

	@Test
	void testToStringWithValues() {

		Form1AphirDataResp response = new Form1AphirDataResp();

		response.setId(1L);
		response.setApplicationId(2L);
		response.setFormTransactionId(3L);
		response.setApplicationType("Medical");
		response.setStudentName("John Doe");
		response.setStudentGradeId(10);
		response.setIsApprove(true);
		response.setApproveUptoDate("2026-12-31");

		String result = response.toString();

		assertNotNull(result);
		assertEquals(true, result.contains("id=1"));
		assertEquals(true, result.contains("applicationId=2"));
		assertEquals(true, result.contains("formTransactionId=3"));
		assertEquals(true, result.contains("applicationType=Medical"));
		assertEquals(true, result.contains("studentName=John Doe"));
		assertEquals(true, result.contains("studentGradeId=10"));
		assertEquals(true, result.contains("isApprove=true"));
		assertEquals(true, result.contains("approveUptoDate=2026-12-31"));
	}
}
