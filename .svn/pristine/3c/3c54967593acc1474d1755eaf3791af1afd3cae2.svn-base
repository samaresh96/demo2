package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Form3RhiltDataRespTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		Form3RhiltDataResp resp = new Form3RhiltDataResp();

		resp.setId(1L);
		resp.setApplicationId(2L);
		resp.setFormTransactionId(3L);
		resp.setStudentId(100L);
		resp.setStudentName("John");
		resp.setStudentDob("01/01/2010");
		resp.setStudentGender("M");
		resp.setStudentGrade("5");
		resp.setStudentGradeId(5);
		resp.setStudentSchool("ABC School");
		resp.setStudentSchoolCode("SCH001");
		resp.setInjuryType("Minor Injury");
		resp.setLengthOfAbsence("10 Days");
		resp.setParentSignature("Parent");
		resp.setParentSignDate("01/01/2026");
		resp.setReceivedBy("Principal");
		resp.setNurseSignature("Nurse");
		resp.setNurseSignDate("02/01/2026");
		resp.setIsApplicationGiven(true);
		resp.setSchoolYear("2026-2027");
		resp.setApplicationNo("APP001");

		assertEquals(1L, resp.getId());
		assertEquals(2L, resp.getApplicationId());
		assertEquals(3L, resp.getFormTransactionId());
		assertEquals(100L, resp.getStudentId());
		assertEquals("John", resp.getStudentName());
		assertEquals("01/01/2010", resp.getStudentDob());
		assertEquals("M", resp.getStudentGender());
		assertEquals("5", resp.getStudentGrade());
		assertEquals(Integer.valueOf(5), resp.getStudentGradeId());
		assertEquals("ABC School", resp.getStudentSchool());
		assertEquals("SCH001", resp.getStudentSchoolCode());
		assertEquals("Minor Injury", resp.getInjuryType());
		assertEquals("10 Days", resp.getLengthOfAbsence());
		assertEquals("Parent", resp.getParentSignature());
		assertEquals("01/01/2026", resp.getParentSignDate());
		assertEquals("Principal", resp.getReceivedBy());
		assertEquals("Nurse", resp.getNurseSignature());
		assertEquals("02/01/2026", resp.getNurseSignDate());
		assertTrue(resp.getIsApplicationGiven());
		assertEquals("2026-2027", resp.getSchoolYear());
		assertEquals("APP001", resp.getApplicationNo());

		String result = resp.toString();
		assertNotNull(result);
		assertTrue(result.contains("John"));
		assertTrue(result.contains("Minor Injury"));
	}

	@Test
	void testParameterizedConstructor() {

		Form3RhiltDataResp resp = new Form3RhiltDataResp(1L, 2L, 3L, 100L, "John", "01/01/2010", "M", "5", null, null,
				5, "ABC School", "SCH001", "Minor Injury", "10 Days", "Parent", "01/01/2026", "Principal", "Nurse",
				"02/01/2026", true);

		assertEquals(1L, resp.getId());
		assertEquals(2L, resp.getApplicationId());
		assertEquals(3L, resp.getFormTransactionId());
		assertEquals(100L, resp.getStudentId());
		assertEquals("John", resp.getStudentName());
		assertEquals("01/01/2010", resp.getStudentDob());
		assertEquals("M", resp.getStudentGender());
		assertEquals("5", resp.getStudentGrade());
		assertEquals(Integer.valueOf(5), resp.getStudentGradeId());
		assertEquals("ABC School", resp.getStudentSchool());
		assertEquals("SCH001", resp.getStudentSchoolCode());
		assertEquals("Minor Injury", resp.getInjuryType());
		assertEquals("10 Days", resp.getLengthOfAbsence());
		assertEquals("Parent", resp.getParentSignature());
		assertEquals("01/01/2026", resp.getParentSignDate());
		assertEquals("Principal", resp.getReceivedBy());
		assertEquals("Nurse", resp.getNurseSignature());
		assertEquals("02/01/2026", resp.getNurseSignDate());
		assertTrue(resp.getIsApplicationGiven());

		String result = resp.toString();
		assertNotNull(result);
		assertTrue(result.contains("John"));
		assertTrue(result.contains("isApplicationGiven=true"));
	}
}