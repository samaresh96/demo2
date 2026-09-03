package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Form4PrthiDataRespTest {

	@Test
	void testDefaultConstructorGettersSettersAndToString() {

		Form4PrthiDataResp resp = new Form4PrthiDataResp();

		resp.setId(1L);
		resp.setApplicationId(2L);
		resp.setFormTransactionId(3L);
		resp.setStudentId(4L);
		resp.setStudentName("John");
		resp.setStudentDob("01/01/2010");
		resp.setStudentGender("Male");
		resp.setStudentGrade("5");
		resp.setStudentGradeId(5);
		resp.setStudentSchool("ABC School");
		resp.setStudentSchoolCode("SCH001");
		resp.setIsTeacherAccept(true);
		resp.setIsTeacherRecommend(true);
		resp.setIsTeacherCertified(false);
		resp.setTeacherArea1("Math");
		resp.setTeacherArea2("Science");
		resp.setTeacherArea3("English");
		resp.setTeacherArea4("History");
		resp.setTeacherName("Mr. Smith");
		resp.setTeacherSchool("ABC School");
		resp.setTeacherHomePhone("1111111111");
		resp.setTeacherWorkPhone("2222222222");
		resp.setTeacherSignature("TeacherSign");
		resp.setTeacherSignDate("2024-01-01");
		resp.setPrincipalSignature("PrincipalSign");
		resp.setPrincipalSignDate("2024-01-02");
		resp.setSchoolYear("2026-2027");
		resp.setApplicationNo("APP001");

		assertEquals(1L, resp.getId());
		assertEquals(2L, resp.getApplicationId());
		assertEquals(3L, resp.getFormTransactionId());
		assertEquals(4L, resp.getStudentId());
		assertEquals("John", resp.getStudentName());
		assertEquals("01/01/2010", resp.getStudentDob());
		assertEquals("Male", resp.getStudentGender());
		assertEquals("5", resp.getStudentGrade());
		assertEquals(5, resp.getStudentGradeId());
		assertEquals("ABC School", resp.getStudentSchool());
		assertEquals("SCH001", resp.getStudentSchoolCode());
		assertTrue(resp.getIsTeacherAccept());
		assertTrue(resp.getIsTeacherRecommend());
		assertFalse(resp.getIsTeacherCertified());
		assertEquals("Math", resp.getTeacherArea1());
		assertEquals("Science", resp.getTeacherArea2());
		assertEquals("English", resp.getTeacherArea3());
		assertEquals("History", resp.getTeacherArea4());
		assertEquals("Mr. Smith", resp.getTeacherName());
		assertEquals("ABC School", resp.getTeacherSchool());
		assertEquals("1111111111", resp.getTeacherHomePhone());
		assertEquals("2222222222", resp.getTeacherWorkPhone());
		assertEquals("TeacherSign", resp.getTeacherSignature());
		assertEquals("2024-01-01", resp.getTeacherSignDate());
		assertEquals("PrincipalSign", resp.getPrincipalSignature());
		assertEquals("2024-01-02", resp.getPrincipalSignDate());
		assertEquals("2026-2027", resp.getSchoolYear());
		assertEquals("APP001", resp.getApplicationNo());

		String str = resp.toString();
		assertNotNull(str);
		assertTrue(str.contains("John"));
		assertTrue(str.contains("ABC School"));
		assertTrue(str.contains("TeacherSign"));
	}

	@Test
	void testParameterizedConstructor() {

		Form4PrthiDataResp resp = new Form4PrthiDataResp(1L, 2L, 3L, 4L, "John", "01/01/2010", "Male", "5", null, null,
				5, "ABC School", "SCH001", true, false, true, "Area1", "Area2", "Area3", "Area4", "Teacher", "School",
				"1111111111", "2222222222", "TeacherSign", "2024-01-01", "PrincipalSign", "2024-01-02");

		assertEquals(1L, resp.getId());
		assertEquals(2L, resp.getApplicationId());
		assertEquals(3L, resp.getFormTransactionId());
		assertEquals(4L, resp.getStudentId());
		assertEquals("John", resp.getStudentName());
		assertEquals("01/01/2010", resp.getStudentDob());
		assertEquals("Male", resp.getStudentGender());
		assertEquals("5", resp.getStudentGrade());
		assertEquals(5, resp.getStudentGradeId());
		assertEquals("ABC School", resp.getStudentSchool());
		assertEquals("SCH001", resp.getStudentSchoolCode());
		assertTrue(resp.getIsTeacherAccept());
		assertFalse(resp.getIsTeacherRecommend());
		assertTrue(resp.getIsTeacherCertified());
		assertEquals("Area1", resp.getTeacherArea1());
		assertEquals("Area2", resp.getTeacherArea2());
		assertEquals("Area3", resp.getTeacherArea3());
		assertEquals("Area4", resp.getTeacherArea4());
		assertEquals("Teacher", resp.getTeacherName());
		assertEquals("School", resp.getTeacherSchool());
		assertEquals("1111111111", resp.getTeacherHomePhone());
		assertEquals("2222222222", resp.getTeacherWorkPhone());
		assertEquals("TeacherSign", resp.getTeacherSignature());
		assertEquals("2024-01-01", resp.getTeacherSignDate());
		assertEquals("PrincipalSign", resp.getPrincipalSignature());
		assertEquals("2024-01-02", resp.getPrincipalSignDate());
	}
}