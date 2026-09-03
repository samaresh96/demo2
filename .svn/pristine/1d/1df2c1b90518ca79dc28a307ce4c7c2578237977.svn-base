package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Form760DhiDataRespTest {

	@Test
	void testDefaultConstructor() {
		Form760DhiDataResp response = new Form760DhiDataResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		Form760DhiDataResp response = new Form760DhiDataResp(1L, 2L, 3L, 4L, "John Doe", "2025-2026", "APP001",
				"2015-01-01", "Male", "Grade 5", 5, "ABC School", "SCH001", "Nurse Name", "2026-01-01",
				"Physician Name", "2026-01-02");

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
		assertEquals("Nurse Name", response.getNurseName());
		assertEquals("2026-01-01", response.getNoticeDate());
		assertEquals("Physician Name", response.getPhysicianName());
		assertEquals("2026-01-02", response.getPhysicianVerifiedOn());
	}

	@Test
	void testAllSettersAndGetters() {

		Form760DhiDataResp response = new Form760DhiDataResp();

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

		Form760DhiDataResp response = new Form760DhiDataResp();

		response.setId(10L);
		response.setApplicationId(20L);
		response.setFormTransactionId(30L);
		response.setNurseName("Test Nurse");
		response.setNoticeDate("2026-02-01");
		response.setPhysicianName("Test Physician");
		response.setPhysicianVerifiedOn("2026-02-02");

		assertEquals(10L, response.getId());
		assertEquals(20L, response.getApplicationId());
		assertEquals(30L, response.getFormTransactionId());
		assertEquals("Test Nurse", response.getNurseName());
		assertEquals("2026-02-01", response.getNoticeDate());
		assertEquals("Test Physician", response.getPhysicianName());
		assertEquals("2026-02-02", response.getPhysicianVerifiedOn());
	}

	@Test
	void testToString() {

		Form760DhiDataResp response = new Form760DhiDataResp(1L, 2L, 3L, 4L, "John Doe", "2025-2026", "APP001",
				"2015-01-01", "Male", "Grade 5", 5, "ABC School", "SCH001", "Nurse Name", "2026-01-01",
				"Physician Name", "2026-01-02");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("John Doe"));
		assertTrue(result.contains("APP001"));
		assertTrue(result.contains("Nurse Name"));
		assertTrue(result.contains("Physician Name"));
	}
}