package com.jcboe.home.instruction.model.request;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form1RequestTest {

	@Test
	public void testDefaultConstructor() {
		Form1Request request = new Form1Request();
		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		String indicator = "Y";
		Long form1AphirDataId = 1L;
		String studentId = "STU001";
		String schoolYear = "2026-2027";
		String applicationType = "Medical";
		String schoolCode = "SCH001";
		int gradeId = 10;
		String requestDate = "2026-08-08";
		String activity = "APHIR Activity";
		String status = "APPROVED";
		String comment = "Approved";
		Long applicationId = 100L;
		Long formMasterId = 200L;
		String otherDocumentName = "Medical Certificate";
		String formAbbreviation = "F1";
		String classification = "Class A";
		String parentName = "John Parent";
		String homePhone = "111-222-3333";
		String workPhone = "444-555-6666";
		String emergencyPhone = "777-888-9999";
		String homeAddress = "123 Main Street";
		String emailAddress = "parent@example.com";
		String counselorName = "Jane Counselor";
		String counselorPhone = "111-333-5555";
		String nurseName = "Mary Nurse";
		String nursePhone = "222-444-6666";
		String attendanceLastDate = "2026-08-01";
		String reason = "Medical Reason";
		String caseNotification = "Notification Sent";
		String notificationDate = "2026-08-02";
		String parentSignature = "Parent Signature";
		String parentSignDate = "2026-08-03";
		String principalSignature = "Principal Signature";
		String principalSignDate = "2026-08-04";
		String dirSpecialEdSignature = "Special Ed Signature";
		String dirSpecialEdSignDate = "2026-08-05";
		String dirSupSignature = "Supervisor Signature";
		String dirSupSignDate = "2026-08-06";
		String dirStudentLifeService = "Student Life Service";
		String dirStudentLifeDate = "2026-08-07";
		Boolean approved = Boolean.TRUE;
		String approvedUptoDate = "2026-12-31";
		String physicianSignature = "Physician Signature";
		String physicianSignDate = "2026-08-08";
		List<Form1AphirSchedule> scheduleData = new ArrayList<Form1AphirSchedule>();
		String loggedInUserId = "USER001";
		String loggedInUserpersonType = "TEACHER";
		Form1Request request = new Form1Request(indicator, form1AphirDataId, studentId, schoolYear, applicationType,
				schoolCode, gradeId, requestDate, activity, status, comment, applicationId, formMasterId,
				otherDocumentName, formAbbreviation, classification, parentName, homePhone, workPhone, emergencyPhone,
				homeAddress, emailAddress, counselorName, counselorPhone, nurseName, nursePhone, attendanceLastDate,
				reason, caseNotification, notificationDate, parentSignature, parentSignDate, principalSignature,
				principalSignDate, dirSpecialEdSignature, dirSpecialEdSignDate, dirSupSignature, dirSupSignDate,
				dirStudentLifeService, dirStudentLifeDate, approved, approvedUptoDate, physicianSignature,
				physicianSignDate, scheduleData, loggedInUserId, loggedInUserpersonType);
		assertEquals(indicator, request.getIndicator());
		assertEquals(form1AphirDataId, request.getForm1AphirDataId());
		assertEquals(studentId, request.getStudentId());
		assertEquals(schoolYear, request.getSchoolYear());
		assertEquals(applicationType, request.getApplicationType());
		assertEquals(schoolCode, request.getSchoolCode());
		assertEquals(gradeId, request.getGradeId());
		assertEquals(requestDate, request.getRequestDate());
		assertEquals(activity, request.getActivity());
		assertEquals(status, request.getStatus());
		assertEquals(comment, request.getComment());
		assertEquals(applicationId, request.getApplicationId());
		assertEquals(formMasterId, request.getFormMasterId());
		assertEquals(otherDocumentName, request.getOtherDocumentName());
		assertEquals(formAbbreviation, request.getFormAbbreviation());
		assertEquals(classification, request.getClassification());
		assertEquals(parentName, request.getParentName());
		assertEquals(homePhone, request.getHomePhone());
		assertEquals(workPhone, request.getWorkPhone());
		assertEquals(emergencyPhone, request.getEmergencyPhone());
		assertEquals(homeAddress, request.getHomeAddress());
		assertEquals(emailAddress, request.getEmailAddress());
		assertEquals(counselorName, request.getCounselorName());
		assertEquals(counselorPhone, request.getCounselorPhone());
		assertEquals(nurseName, request.getNurseName());
		assertEquals(nursePhone, request.getNursePhone());
		assertEquals(attendanceLastDate, request.getAttendanceLastDate());
		assertEquals(reason, request.getReason());
		assertEquals(caseNotification, request.getCaseNotification());
		assertEquals(notificationDate, request.getNotificationDate());
		assertEquals(parentSignature, request.getParentSignature());
		assertEquals(parentSignDate, request.getParentSignDate());
		assertEquals(principalSignature, request.getPrincipalSignature());
		assertEquals(principalSignDate, request.getPrincipalSignDate());
		assertEquals(dirSpecialEdSignature, request.getDirSpecialEdSignature());
		assertEquals(dirSpecialEdSignDate, request.getDirSpecialEdSignDate());
		assertEquals(dirSupSignature, request.getDirSupSignature());
		assertEquals(dirSupSignDate, request.getDirSupSignDate());
		assertEquals(dirStudentLifeService, request.getDirStudentLifeService());
		assertEquals(dirStudentLifeDate, request.getDirStudentLifeDate());
		assertEquals(approved, request.getApproved());
		assertEquals(approvedUptoDate, request.getApprovedUptoDate());
		assertEquals(physicianSignature, request.getPhysicianSignature());
		assertEquals(physicianSignDate, request.getPhysicianSignDate());
		assertEquals(scheduleData, request.getForm1AphirScheduleData());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserpersonType, request.getLoggedInUserPersonType());
	}

	@Test
	public void testSettersAndGetters() {
		Form1Request request = new Form1Request();
		request.setIndicator("N");
		request.setForm1AphirDataId(10L);
		request.setStudentId("STU002");
		request.setSchoolYear("2025-2026");
		request.setApplicationType("Academic");
		request.setSchoolCode("SCH002");
		request.setGradeId(12);
		request.setRequestDate("2026-09-01");
		request.setActivity("Test Activity");
		request.setStatus("PENDING");
		request.setComment("Test Comment");
		request.setApplicationId(20L);
		request.setFormMasterId(30L);
		request.setOtherDocumentName("Test Document");
		request.setFormAbbreviation("F1A");
		request.setClassification("Class B");
		request.setParentName("Test Parent");
		request.setHomePhone("1111111111");
		request.setWorkPhone("2222222222");
		request.setEmergencyPhone("3333333333");
		request.setHomeAddress("456 Test Street");
		request.setEmailAddress("test@example.com");
		request.setCounselorName("Test Counselor");
		request.setCounselorPhone("4444444444");
		request.setNurseName("Test Nurse");
		request.setNursePhone("5555555555");
		request.setAttendanceLastDate("2026-08-15");
		request.setReason("Test Reason");
		request.setCaseNotification("Test Notification");
		request.setNotificationDate("2026-08-16");
		request.setParentSignature("Parent Sign");
		request.setParentSignDate("2026-08-17");
		request.setPrincipalSignature("Principal Sign");
		request.setPrincipalSignDate("2026-08-18");
		request.setDirSpecialEdSignature("Special Ed Sign");
		request.setDirSpecialEdSignDate("2026-08-19");
		request.setDirSupSignature("Supervisor Sign");
		request.setDirSupSignDate("2026-08-20");
		request.setDirStudentLifeService("Student Life");
		request.setDirStudentLifeDate("2026-08-21");
		request.setApproved(Boolean.FALSE);
		request.setApprovedUptoDate("2026-12-30");
		request.setPhysicianSignature("Physician Sign");
		request.setPhysicianSignDate("2026-08-22");
		List<Form1AphirSchedule> scheduleData = new ArrayList<Form1AphirSchedule>();
		request.setForm1AphirScheduleData(scheduleData);
		request.setLoggedInUserId("USER002");
		request.setLoggedInUserPersonType("STUDENT");
		assertEquals("N", request.getIndicator());
		assertEquals(Long.valueOf(10L), request.getForm1AphirDataId());
		assertEquals("STU002", request.getStudentId());
		assertEquals("2025-2026", request.getSchoolYear());
		assertEquals("Academic", request.getApplicationType());
		assertEquals("SCH002", request.getSchoolCode());
		assertEquals(12, request.getGradeId());
		assertEquals("2026-09-01", request.getRequestDate());
		assertEquals("Test Activity", request.getActivity());
		assertEquals("PENDING", request.getStatus());
		assertEquals("Test Comment", request.getComment());
		assertEquals(Long.valueOf(20L), request.getApplicationId());
		assertEquals(Long.valueOf(30L), request.getFormMasterId());
		assertEquals("Test Document", request.getOtherDocumentName());
		assertEquals("F1A", request.getFormAbbreviation());
		assertEquals("Class B", request.getClassification());
		assertEquals("Test Parent", request.getParentName());
		assertEquals("1111111111", request.getHomePhone());
		assertEquals("2222222222", request.getWorkPhone());
		assertEquals("3333333333", request.getEmergencyPhone());
		assertEquals("456 Test Street", request.getHomeAddress());
		assertEquals("test@example.com", request.getEmailAddress());
		assertEquals("Test Counselor", request.getCounselorName());
		assertEquals("4444444444", request.getCounselorPhone());
		assertEquals("Test Nurse", request.getNurseName());
		assertEquals("5555555555", request.getNursePhone());
		assertEquals("2026-08-15", request.getAttendanceLastDate());
		assertEquals("Test Reason", request.getReason());
		assertEquals("Test Notification", request.getCaseNotification());
		assertEquals("2026-08-16", request.getNotificationDate());
		assertEquals("Parent Sign", request.getParentSignature());
		assertEquals("2026-08-17", request.getParentSignDate());
		assertEquals("Principal Sign", request.getPrincipalSignature());
		assertEquals("2026-08-18", request.getPrincipalSignDate());
		assertEquals("Special Ed Sign", request.getDirSpecialEdSignature());
		assertEquals("2026-08-19", request.getDirSpecialEdSignDate());
		assertEquals("Supervisor Sign", request.getDirSupSignature());
		assertEquals("2026-08-20", request.getDirSupSignDate());
		assertEquals("Student Life", request.getDirStudentLifeService());
		assertEquals("2026-08-21", request.getDirStudentLifeDate());
		assertEquals(Boolean.FALSE, request.getApproved());
		assertEquals("2026-12-30", request.getApprovedUptoDate());
		assertEquals("Physician Sign", request.getPhysicianSignature());
		assertEquals("2026-08-22", request.getPhysicianSignDate());
		assertEquals(scheduleData, request.getForm1AphirScheduleData());
		assertEquals("USER002", request.getLoggedInUserId());
		assertEquals("STUDENT", request.getLoggedInUserPersonType());
	}

	@Test
	public void testApprovedSetterAndGetter() {
		Form1Request request = new Form1Request();
		request.setApproved(Boolean.TRUE);
		assertEquals(Boolean.TRUE, request.getApproved());
		request.setApproved(Boolean.FALSE);
		assertEquals(Boolean.FALSE, request.getApproved());
		request.setApproved(null);
		assertEquals(null, request.getApproved());
	}

	@Test
	void testToString() {
		Form1Request request = new Form1Request();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, request.toString());
	}

	@Test
	void testForm1Request() {
		Form1Request request = new Form1Request();

		request.setSchoolCode("SCH001");

		assertEquals("SCH001", request.form1Request());
	}
}
