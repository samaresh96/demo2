package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Form4RequestTest {

	@Test
	public void testDefaultConstructorAndGettersSetters() {

		Form4Request request = new Form4Request();

		request.setIndicator("I");
		request.setSchoolYear("2026-2027");
		request.setId(1L);
		request.setStudentId("STU001");
		request.setActivity("Sports");
		request.setStatus("Active");
		request.setComment("Good");
		request.setApplicationId(100L);
		request.setFormMasterId(200L);
		request.setFormAbbreviation("F4");
		request.setIsTeacherAccept(true);
		request.setIsTeacherRecommend(true);
		request.setIsTeacherCertified(false);
		request.setTeacherArea1("Area1");
		request.setTeacherArea2("Area2");
		request.setTeacherArea3("Area3");
		request.setTeacherArea4("Area4");
		request.setTeacherName("John Smith");
		request.setTeacherSchool("ABC School");
		request.setTeacherHomePhone("1111111111");
		request.setTeacherWorkPhone("2222222222");
		request.setTeacherSignature("TeacherSign");
		request.setTeacherSignDate("2026-08-01");
		request.setPrincipalSignature("PrincipalSign");
		request.setPrincipalSignDate("2026-08-02");
		request.setLoggedInUserId("USER01");
		request.setLoggedInUserPersonType("ADMIN");

		assertEquals("I", request.getIndicator());
		assertEquals("2026-2027", request.getSchoolYear());
		assertEquals(Long.valueOf(1L), request.getId());
		assertEquals("STU001", request.getStudentId());
		assertEquals("Sports", request.getActivity());
		assertEquals("Active", request.getStatus());
		assertEquals("Good", request.getComment());
		assertEquals(Long.valueOf(100L), request.getApplicationId());
		assertEquals(Long.valueOf(200L), request.getFormMasterId());
		assertEquals("F4", request.getFormAbbreviation());
		assertEquals(Boolean.TRUE, request.getIsTeacherAccept());
		assertEquals(Boolean.TRUE, request.getIsTeacherRecommend());
		assertEquals(Boolean.FALSE, request.getIsTeacherCertified());
		assertEquals("Area1", request.getTeacherArea1());
		assertEquals("Area2", request.getTeacherArea2());
		assertEquals("Area3", request.getTeacherArea3());
		assertEquals("Area4", request.getTeacherArea4());
		assertEquals("John Smith", request.getTeacherName());
		assertEquals("ABC School", request.getTeacherSchool());
		assertEquals("1111111111", request.getTeacherHomePhone());
		assertEquals("2222222222", request.getTeacherWorkPhone());
		assertEquals("TeacherSign", request.getTeacherSignature());
		assertEquals("2026-08-01", request.getTeacherSignDate());
		assertEquals("PrincipalSign", request.getPrincipalSignature());
		assertEquals("2026-08-02", request.getPrincipalSignDate());
		assertEquals("USER01", request.getLoggedInUserId());
		assertEquals("ADMIN", request.getLoggedInUserPersonType());
	}

	@Test
	public void testParameterizedConstructor() {

		Form4Request request = new Form4Request("I", "2026-2027", 1L, "STU001", "Sports", "Active", "Good", 100L, 200L,
				"F4", true, true, false, "Area1", "Area2", "Area3", "Area4", "John Smith", "ABC School", "1111111111",
				"2222222222", "TeacherSign", "2026-08-01", "PrincipalSign", "2026-08-02", "USER01", "ADMIN");

		assertEquals("I", request.getIndicator());
		assertEquals("2026-2027", request.getSchoolYear());
		assertEquals(Long.valueOf(1L), request.getId());
		assertEquals("STU001", request.getStudentId());
		assertEquals("Sports", request.getActivity());
		assertEquals("Active", request.getStatus());
		assertEquals("Good", request.getComment());
		assertEquals(Long.valueOf(100L), request.getApplicationId());
		assertEquals(Long.valueOf(200L), request.getFormMasterId());
		assertEquals("F4", request.getFormAbbreviation());
		assertEquals(Boolean.TRUE, request.getIsTeacherAccept());
		assertEquals(Boolean.TRUE, request.getIsTeacherRecommend());
		assertEquals(Boolean.FALSE, request.getIsTeacherCertified());
		assertEquals("Area1", request.getTeacherArea1());
		assertEquals("Area2", request.getTeacherArea2());
		assertEquals("Area3", request.getTeacherArea3());
		assertEquals("Area4", request.getTeacherArea4());
		assertEquals("John Smith", request.getTeacherName());
		assertEquals("ABC School", request.getTeacherSchool());
		assertEquals("1111111111", request.getTeacherHomePhone());
		assertEquals("2222222222", request.getTeacherWorkPhone());
		assertEquals("TeacherSign", request.getTeacherSignature());
		assertEquals("2026-08-01", request.getTeacherSignDate());
		assertEquals("PrincipalSign", request.getPrincipalSignature());
		assertEquals("2026-08-02", request.getPrincipalSignDate());
		assertEquals("USER01", request.getLoggedInUserId());
		assertEquals("ADMIN", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {

		Form4Request request = new Form4Request();

		String expectedString = "Form4Request [indicator=null" + ", schoolYear=null" + ", id=null" + ", studentId=null"
				+ ", activity=null" + ", status=null" + ", comment=null" + ", applicationId=null"
				+ ", formMasterId=null" + ", formAbbreviation=null" + ", isTeacherAccept=null"
				+ ", isTeacherRecommend=null" + ", isTeacherCertified=null" + ", teacherArea1=null"
				+ ", teacherArea2=null" + ", teacherArea3=null" + ", teacherArea4=null" + ", teacherName=null"
				+ ", teacherSchool=null" + ", teacherHomePhone=null" + ", teacherWorkPhone=null"
				+ ", teacherSignature=null" + ", teacherSignDate=null" + ", principalSignature=null"
				+ ", principalSignDate=null" + ", loggedInUserId=null" + ", loggedInUserPersonType=null]";

		assertNotNull(request.toString());
		assertEquals(expectedString, request.toString());
	}
}
