package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ApplicationListTest {

	@Test
	public void testDefaultConstructor() {
		ApplicationList applicationList = new ApplicationList();
		assertNotNull(applicationList);
	}

	@Test
	public void testParameterizedConstructor() {
		Long applicationId = 100L;
		Long formTransactionId = 2L;
		Long form1APHIRDataId = 1L;
		Long studentId = 200L;
		String studentName = "John Doe";
		String schoolYear = "2026-2027";
		String applicationNo = "APP-001";
		String applicationType = "Medical";
		String applicationTypeAbbr = "MI";
		String studentSchool = "ABC High School";
		String studentGrade = "Grade 10";
		String applicationStatus = "Approved";
		String applicationStatusAbbr = "APP";
		String applicationDate = "2026-08-08";
		String classification = "classification";
		String hiPeriod = "10 Days";
		String updatedOn = "2026-08-08";
		Boolean isActive = Boolean.TRUE;
		String uploadedGeneratedTag = "tag";
		ApplicationList applicationList = new ApplicationList(applicationId, formTransactionId, form1APHIRDataId,
				studentId, studentName, schoolYear, applicationNo, applicationType, applicationTypeAbbr, studentSchool,
				studentGrade, applicationStatus, applicationStatusAbbr, applicationDate, classification, hiPeriod,
				updatedOn, isActive, uploadedGeneratedTag);
		assertEquals(applicationId, applicationList.getApplicationId());
		assertEquals(formTransactionId, applicationList.getFormTransactionId());
		assertEquals(form1APHIRDataId, applicationList.getForm1APHIRDataId());
		assertEquals(studentId, applicationList.getStudentId());
		assertEquals(studentName, applicationList.getStudentName());
		assertEquals(schoolYear, applicationList.getSchoolYear());
		assertEquals(applicationNo, applicationList.getApplicationNo());
		assertEquals(applicationType, applicationList.getApplicationType());
		assertEquals(applicationTypeAbbr, applicationList.getApplicationTypeAbbr());
		assertEquals(studentSchool, applicationList.getStudentSchool());
		assertEquals(studentGrade, applicationList.getStudentGrade());
		assertEquals(applicationStatus, applicationList.getApplicationStatus());
		assertEquals(applicationStatusAbbr, applicationList.getApplicationStatusAbbr());
		assertEquals(applicationDate, applicationList.getApplicationDate());
		assertEquals(classification, applicationList.getClassification());
		assertEquals(hiPeriod, applicationList.getHiPeriod());
		assertEquals(updatedOn, applicationList.getUpdatedOn());
		assertEquals(isActive, applicationList.getIsActive());
		assertEquals(uploadedGeneratedTag, applicationList.getUploadedGeneratedTag());
	}

	@Test
	public void testSettersAndGetters() {
		ApplicationList applicationList = new ApplicationList();
		applicationList.setApplicationId(101L);
		applicationList.setFormTransactionId(101L);
		applicationList.setForm1APHIRDataId(101L);
		applicationList.setStudentId(201L);
		applicationList.setStudentName("Jane Smith");
		applicationList.setSchoolYear("2025-2026");
		applicationList.setApplicationNo("APP-002");
		applicationList.setApplicationType("Academic");
		applicationList.setApplicationTypeAbbr("abbr");
		applicationList.setStudentSchool("XYZ School");
		applicationList.setStudentGrade("Grade 9");
		applicationList.setApplicationStatus("Pending");
		applicationList.setApplicationStatusAbbr("PEN");
		applicationList.setApplicationDate("2026-09-01");
		applicationList.setClassification("classification");
		applicationList.setHiPeriod("15 Days");
		applicationList.setUpdatedOn("2026-09-02");
		applicationList.setIsActive(Boolean.FALSE);
		applicationList.setUploadedGeneratedTag("tag");
		assertEquals(Long.valueOf(101L), applicationList.getApplicationId());
		assertEquals(Long.valueOf(101L), applicationList.getFormTransactionId());
		assertEquals(Long.valueOf(101L), applicationList.getForm1APHIRDataId());
		assertEquals(Long.valueOf(201L), applicationList.getStudentId());
		assertEquals("Jane Smith", applicationList.getStudentName());
		assertEquals("2025-2026", applicationList.getSchoolYear());
		assertEquals("APP-002", applicationList.getApplicationNo());
		assertEquals("Academic", applicationList.getApplicationType());
		assertEquals("abbr", applicationList.getApplicationTypeAbbr());
		assertEquals("XYZ School", applicationList.getStudentSchool());
		assertEquals("Grade 9", applicationList.getStudentGrade());
		assertEquals("Pending", applicationList.getApplicationStatus());
		assertEquals("PEN", applicationList.getApplicationStatusAbbr());
		assertEquals("2026-09-01", applicationList.getApplicationDate());
		assertEquals("classification1", applicationList.getClassification());
		assertEquals("15 Days", applicationList.getHiPeriod());
		assertEquals("2026-09-02", applicationList.getUpdatedOn());
		assertEquals(Boolean.FALSE, applicationList.getIsActive());
		assertEquals("tag", applicationList.getUploadedGeneratedTag());
	}

	@Test
	void testToString() {
		ApplicationList app = new ApplicationList();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, app.toString());
	}
}