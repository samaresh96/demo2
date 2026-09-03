package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SchoolRespTest {

	@Test
	void testNoArgsConstructor() {
		SchoolResp dto = new SchoolResp();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		long schoolId = 101L;
		String schoolCode = "SCH001";
		String schoolName = "ABC Public School";

		SchoolResp dto = new SchoolResp(schoolId, schoolCode, schoolName);

		assertEquals(schoolId, dto.getSchoolId());
		assertEquals(schoolCode, dto.getSchoolCode());
		assertEquals(schoolName, dto.getSchoolName());
	}

	@Test
	void testGettersAndSetters() {
		SchoolResp dto = new SchoolResp();

		long schoolId = 202L;
		String schoolCode = "SCH002";
		String schoolName = "XYZ High School";

		dto.setSchoolId(schoolId);
		dto.setSchoolCode(schoolCode);
		dto.setSchoolName(schoolName);

		assertEquals(schoolId, dto.getSchoolId());
		assertEquals(schoolCode, dto.getSchoolCode());
		assertEquals(schoolName, dto.getSchoolName());
	}

	@Test
	void testToString() {
		SchoolResp dto = new SchoolResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dto.toString());
	}

}
