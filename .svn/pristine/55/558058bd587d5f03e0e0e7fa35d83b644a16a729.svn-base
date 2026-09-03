package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Form10HSAPPDataRespTest {

	@Test
	public void testDefaultConstructorAndGetterSetter() {

		Form10HSAPPDataResp dataResp = new Form10HSAPPDataResp();

		dataResp.setId(1L);
		dataResp.setApplicationId(2L);
		dataResp.setFormTransactionId(3L);
		dataResp.setStudentId(4L);
		dataResp.setStudentName("John Doe");
		dataResp.setStudentDob("01/01/2010");
		dataResp.setStudentGender("Male");
		dataResp.setStudentGrade("10");
		dataResp.setStudentGradeId("GRADE10");
		dataResp.setStudentSchool("ABC High School");
		dataResp.setStudentSchoolCode("SCH001");
		dataResp.setSubject("Mathematics");
		dataResp.setGradeInProgress("A");
		dataResp.setTeacherName("Mr. Smith");
		dataResp.setTeacherEmail("smith@test.com");
		dataResp.setIsAdditionalTimeNeeded(true);
		dataResp.setUnityOfStudy("Algebra");
		dataResp.setAssignments("Assignment 1");
		dataResp.setIndependentWork("Worksheet");
		dataResp.setAssessments("Quiz");
		dataResp.setStandardsCovered("Common Core");
		dataResp.setOtherResources("Textbook");
		dataResp.setTeacherSignature("Signature");
		dataResp.setTeacherSignDate("06/08/2026");
		dataResp.setSchoolYear("2026-2027");
		dataResp.setApplicationNo("APP001");

		assertEquals(Long.valueOf(1L), dataResp.getId());
		assertEquals(Long.valueOf(2L), dataResp.getApplicationId());
		assertEquals(Long.valueOf(3L), dataResp.getFormTransactionId());
		assertEquals(Long.valueOf(4L), dataResp.getStudentId());
		assertEquals("John Doe", dataResp.getStudentName());
		assertEquals("01/01/2010", dataResp.getStudentDob());
		assertEquals("Male", dataResp.getStudentGender());
		assertEquals("10", dataResp.getStudentGrade());
		assertEquals("GRADE10", dataResp.getStudentGradeId());
		assertEquals("ABC High School", dataResp.getStudentSchool());
		assertEquals("SCH001", dataResp.getStudentSchoolCode());
		assertEquals("Mathematics", dataResp.getSubject());
		assertEquals("A", dataResp.getGradeInProgress());
		assertEquals("Mr. Smith", dataResp.getTeacherName());
		assertEquals("smith@test.com", dataResp.getTeacherEmail());
		assertTrue(dataResp.getIsAdditionalTimeNeeded());
		assertEquals("Algebra", dataResp.getUnityOfStudy());
		assertEquals("Assignment 1", dataResp.getAssignments());
		assertEquals("Worksheet", dataResp.getIndependentWork());
		assertEquals("Quiz", dataResp.getAssessments());
		assertEquals("Common Core", dataResp.getStandardsCovered());
		assertEquals("Textbook", dataResp.getOtherResources());
		assertEquals("Signature", dataResp.getTeacherSignature());
		assertEquals("06/08/2026", dataResp.getTeacherSignDate());
		assertEquals("2026-2027", dataResp.getSchoolYear());
		assertEquals("APP001", dataResp.getApplicationNo());
	}

	@Test
	public void testParameterizedConstructor() {

		Form10HSAPPDataResp dataResp = new Form10HSAPPDataResp(1L, 2L, 3L, 4L, "John Doe", "01/01/2010", "Male", "10",
				"GRADE10", "ABC High School", "SCH001", "Mathematics", "A", "Mr. Smith", "smith@test.com", "", "", true,
				"Algebra", "Assignment 1", "Worksheet", "Quiz", "Common Core", "Textbook", "Signature", "06/08/2026");

		assertEquals(Long.valueOf(1L), dataResp.getId());
		assertEquals(Long.valueOf(2L), dataResp.getApplicationId());
		assertEquals(Long.valueOf(3L), dataResp.getFormTransactionId());
		assertEquals(Long.valueOf(4L), dataResp.getStudentId());
		assertEquals("John Doe", dataResp.getStudentName());
		assertEquals("01/01/2010", dataResp.getStudentDob());
		assertEquals("Male", dataResp.getStudentGender());
		assertEquals("10", dataResp.getStudentGrade());
		assertEquals("GRADE10", dataResp.getStudentGradeId());
		assertEquals("ABC High School", dataResp.getStudentSchool());
		assertEquals("SCH001", dataResp.getStudentSchoolCode());
		assertEquals("Mathematics", dataResp.getSubject());
		assertEquals("A", dataResp.getGradeInProgress());
		assertEquals("Mr. Smith", dataResp.getTeacherName());
		assertEquals("smith@test.com", dataResp.getTeacherEmail());
		assertTrue(dataResp.getIsAdditionalTimeNeeded());
		assertEquals("Algebra", dataResp.getUnityOfStudy());
		assertEquals("Assignment 1", dataResp.getAssignments());
		assertEquals("Worksheet", dataResp.getIndependentWork());
		assertEquals("Quiz", dataResp.getAssessments());
		assertEquals("Common Core", dataResp.getStandardsCovered());
		assertEquals("Textbook", dataResp.getOtherResources());
		assertEquals("Signature", dataResp.getTeacherSignature());
		assertEquals("06/08/2026", dataResp.getTeacherSignDate());
	}

	@Test
	void testToString() {
		Form10HSAPPDataResp dataResp = new Form10HSAPPDataResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dataResp.toString());
	}

}
