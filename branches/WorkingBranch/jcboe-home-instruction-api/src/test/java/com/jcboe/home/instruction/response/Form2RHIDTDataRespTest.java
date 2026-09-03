package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Form2RHIDTDataRespTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		Form2RHIDTDataResp resp = new Form2RHIDTDataResp();

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
		resp.setPhysicianReview("Approved");
		resp.setHiEndDate("12/31/2026");
		resp.setNurseSignature("Nurse");
		resp.setNurseSignDate("01/15/2026");
		resp.setIsAgree(Boolean.TRUE);
		resp.setPhysicianSignature("Doctor");
		resp.setPhysicianSignDate("01/16/2026");
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
		assertEquals("Approved", resp.getPhysicianReview());
		assertEquals("12/31/2026", resp.getHiEndDate());
		assertEquals("Nurse", resp.getNurseSignature());
		assertEquals("01/15/2026", resp.getNurseSignDate());
		assertTrue(resp.getIsAgree());
		assertEquals("Doctor", resp.getPhysicianSignature());
		assertEquals("01/16/2026", resp.getPhysicianSignDate());
		assertEquals("2026-2027", resp.getSchoolYear());
		assertEquals("APP001", resp.getApplicationNo());

		String result = resp.toString();
		assertNotNull(result);
		assertTrue(result.contains("John"));
		assertTrue(result.contains("Approved"));
	}

	@Test
	void testParameterizedConstructor() {

		Form2RHIDTDataResp resp = new Form2RHIDTDataResp(1L, 2L, 3L, 100L, "John", "2026-2027", "APP001", "01/01/2010",
				"M", "5", 5, "ABC School", "SCH001", "Approved", "12/31/2026", "Nurse", "01/15/2026", true, "Doctor",
				"01/16/2026");

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
		assertEquals("Approved", resp.getPhysicianReview());
		assertEquals("12/31/2026", resp.getHiEndDate());
		assertEquals("Nurse", resp.getNurseSignature());
		assertEquals("01/15/2026", resp.getNurseSignDate());
		assertTrue(resp.getIsAgree());
		assertEquals("Doctor", resp.getPhysicianSignature());
		assertEquals("01/16/2026", resp.getPhysicianSignDate());
		assertEquals("2026-2027", resp.getSchoolYear());
		assertEquals("APP001", resp.getApplicationNo());

		String result = resp.toString();
		assertNotNull(result);
		assertTrue(result.contains("John"));
		assertTrue(result.contains("Doctor"));
	}
}