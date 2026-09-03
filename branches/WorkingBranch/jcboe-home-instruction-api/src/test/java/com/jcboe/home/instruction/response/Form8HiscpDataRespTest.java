package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Form8HiscpDataRespTest {

	@Test
	void testDefaultConstructor() {
		Form8HiscpDataResp response = new Form8HiscpDataResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		Form8HiscpDataResp response = new Form8HiscpDataResp(1L, 2L, 3L, 4L, "John Doe", "2025-2026", "APP001",
				"2015-01-01", "Male", "Grade 5", 5, "ABC School", "SCH001", "Medical Reason", "2026-01-01", true,
				"Comments", "Nurse Signature", "2026-01-02", "Program", "English", "2026-01-03", "10", "5", "Grade 10",
				"Student History", "Counsellor Signature", "2026-01-04");

		assertEquals(1L, response.getId());
		assertEquals(2L, response.getApplicationId());
		assertEquals(3L, response.getFormTransactionId());
		assertEquals(4L, response.getStudentId());
		assertEquals("John Doe", response.getStudentName());
		assertEquals("2025-2026", response.getSchoolYear());
		assertEquals("APP001", response.getApplicationNo());
		assertEquals("2015-01-01", response.getStudentDob());
		assertEquals("Male", response.getStudentGender());
		assertEquals("Grade 5", response.getStudentGrade());
		assertEquals(5, response.getStudentGradeId());
		assertEquals("ABC School", response.getStudentSchool());
		assertEquals("SCH001", response.getStudentSchoolCode());
		assertEquals("Medical Reason", response.getReason());
		assertEquals("2026-01-01", response.getMedicalCutoffDate());
		assertTrue(response.getIsPhysicalLimitation());
		assertEquals("Comments", response.getNurseComments());
		assertEquals("Nurse Signature", response.getNurseSignature());
		assertEquals("2026-01-02", response.getNurseSignDate());
		assertEquals("Program", response.getProgram());
		assertEquals("English", response.getPrimaryLanguage());
		assertEquals("2026-01-03", response.getLastPresentDate());
		assertEquals("10", response.getNumberOfDayMissing());
		assertEquals("5", response.getHoursOfInstruction());
		assertEquals("Grade 10", response.getAcademicLevel());
		assertEquals("Student History", response.getStudentHistory());
		assertEquals("Counsellor Signature", response.getCounsellorSignature());
		assertEquals("2026-01-04", response.getCounsellorSignDate());
	}

	@Test
	void testStudentFieldSettersAndGetters() {

		Form8HiscpDataResp response = new Form8HiscpDataResp();

		response.setStudentId(4L);
		response.setStudentName("John Doe");
		response.setSchoolYear("2025-2026");
		response.setApplicationNo("APP001");
		response.setStudentDob("2015-01-01");
		response.setStudentGender("Male");
		response.setStudentGrade("Grade 5");
		response.setStudentGradeId(5);
		response.setStudentSchool("ABC School");
		response.setStudentSchoolCode("SCH001");

		assertEquals(4L, response.getStudentId());
		assertEquals("John Doe", response.getStudentName());
		assertEquals("2025-2026", response.getSchoolYear());
		assertEquals("APP001", response.getApplicationNo());
		assertEquals("2015-01-01", response.getStudentDob());
		assertEquals("Male", response.getStudentGender());
		assertEquals("Grade 5", response.getStudentGrade());
		assertEquals(5, response.getStudentGradeId());
		assertEquals("ABC School", response.getStudentSchool());
		assertEquals("SCH001", response.getStudentSchoolCode());
	}

	@Test
	void testSetters() {

		Form8HiscpDataResp response = new Form8HiscpDataResp();

		response.setId(10L);
		response.setApplicationId(20L);
		response.setFormTransactionId(30L);
		response.setReason("Reason");
		response.setMedicalCutoffDate("2026-02-01");
		response.setIsPhysicalLimitation(false);
		response.setNurseComments("Test Comments");
		response.setNurseSignature("Nurse");
		response.setNurseSignDate("2026-02-02");
		response.setProgram("Program");
		response.setPrimaryLanguage("Spanish");
		response.setLastPresentDate("2026-02-03");
		response.setNumberOfDayMissing("15");
		response.setHoursOfInstruction("20");
		response.setAcademicLevel("Level");
		response.setStudentHistory("History");
		response.setCounsellorSignature("Counsellor");
		response.setCounsellorSignDate("2026-02-04");

		assertEquals(10L, response.getId());
		assertEquals(20L, response.getApplicationId());
		assertEquals(30L, response.getFormTransactionId());
		assertEquals("Reason", response.getReason());
		assertEquals("2026-02-01", response.getMedicalCutoffDate());
		assertFalse(response.getIsPhysicalLimitation());
		assertEquals("Test Comments", response.getNurseComments());
		assertEquals("Nurse", response.getNurseSignature());
		assertEquals("2026-02-02", response.getNurseSignDate());
		assertEquals("Program", response.getProgram());
		assertEquals("Spanish", response.getPrimaryLanguage());
		assertEquals("2026-02-03", response.getLastPresentDate());
		assertEquals("15", response.getNumberOfDayMissing());
		assertEquals("20", response.getHoursOfInstruction());
		assertEquals("Level", response.getAcademicLevel());
		assertEquals("History", response.getStudentHistory());
		assertEquals("Counsellor", response.getCounsellorSignature());
		assertEquals("2026-02-04", response.getCounsellorSignDate());
	}

	@Test
	void testToString() {

		Form8HiscpDataResp response = new Form8HiscpDataResp(1L, 2L, 3L, 4L, "John Doe", "2025-2026", "APP001",
				"2015-01-01", "Male", "Grade 5", 5, "ABC School", "SCH001", "Reason", "2026-01-01", true, "Comments",
				"Nurse", "2026-01-02", "Program", "English", "2026-01-03", "10", "5", "Level", "History", "Counsellor",
				"2026-01-04");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("Form8HiscpDataResp"));
		assertTrue(result.contains("Reason"));
		assertTrue(result.contains("Counsellor"));
	}
}