package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GradeListRespTest {

	@Test
	void testNoArgsConstructor() {
		GradeListResp dto = new GradeListResp();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		int gradeId = 10;
		String grade = "Grade 10";

		GradeListResp dto = new GradeListResp(gradeId, grade);

		assertEquals(gradeId, dto.getGradeId());
		assertEquals(grade, dto.getGrade());
	}

	@Test
	void testGettersAndSetters() {
		GradeListResp dto = new GradeListResp();

		int gradeId = 12;
		String grade = "Grade 12";

		dto.setGradeId(gradeId);
		dto.setGrade(grade);

		assertEquals(gradeId, dto.getGradeId());
		assertEquals(grade, dto.getGrade());
	}

	@Test
	void testToString() {
		GradeListResp dto = new GradeListResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dto.toString());
	}

}
