package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Form9EAPPDataRespTest {

	@Test
	public void testDefaultConstructorAndGetterSetter() {

		Form9EAPPDataResp dataResp = new Form9EAPPDataResp();

		List<Form9EAPPPlanDataResp> planData = new ArrayList<>();
		planData.add(new Form9EAPPPlanDataResp());

		dataResp.setId(1L);
		dataResp.setApplicationId(2L);
		dataResp.setFormTransactionId(3L);
		dataResp.setStudentId(4L);
		dataResp.setStudentName("John Doe");
		dataResp.setStudentDob("01/01/2010");
		dataResp.setStudentGender("Male");
		dataResp.setStudentGrade("5");
		dataResp.setStudentGradeId("GRADE5");
		dataResp.setStudentSchool("ABC School");
		dataResp.setStudentSchoolCode("SCH001");
		dataResp.setTeacherName("Teacher One");
		dataResp.setTeacherEmail("teacher@test.com");
		dataResp.setTeacherSignature("Signature");
		dataResp.setTeacherSignDate("06/08/2026");
		dataResp.setForm9EappPlanData(planData);
		dataResp.setSchoolYear("2026-2027");
		dataResp.setApplicationNo("APP001");

		assertEquals(Long.valueOf(1L), dataResp.getId());
		assertEquals(Long.valueOf(2L), dataResp.getApplicationId());
		assertEquals(Long.valueOf(3L), dataResp.getFormTransactionId());
		assertEquals(Long.valueOf(4L), dataResp.getStudentId());
		assertEquals("John Doe", dataResp.getStudentName());
		assertEquals("01/01/2010", dataResp.getStudentDob());
		assertEquals("Male", dataResp.getStudentGender());
		assertEquals("5", dataResp.getStudentGrade());
		assertEquals("GRADE5", dataResp.getStudentGradeId());
		assertEquals("ABC School", dataResp.getStudentSchool());
		assertEquals("SCH001", dataResp.getStudentSchoolCode());
		assertEquals("Teacher One", dataResp.getTeacherName());
		assertEquals("teacher@test.com", dataResp.getTeacherEmail());
		assertEquals("Signature", dataResp.getTeacherSignature());
		assertEquals("06/08/2026", dataResp.getTeacherSignDate());
		assertEquals(planData, dataResp.getForm9EappPlanData());
		assertEquals("2026-2027", dataResp.getSchoolYear());
		assertEquals("APP001", dataResp.getApplicationNo());
	}

	@Test
	public void testParameterizedConstructor() {

		List<Form9EAPPPlanDataResp> planData = new ArrayList<>();
		planData.add(new Form9EAPPPlanDataResp());

		Form9EAPPDataResp dataResp = new Form9EAPPDataResp(1L, 2L, 3L, 4L, "John Doe", "01/01/2010", "Male", "5",
				"GRADE5", "ABC School", "SCH001", "Teacher One", "teacher@test.com", "Signature", "06/08/2026", "", "",
				planData);

		assertEquals(Long.valueOf(1L), dataResp.getId());
		assertEquals(Long.valueOf(2L), dataResp.getApplicationId());
		assertEquals(Long.valueOf(3L), dataResp.getFormTransactionId());
		assertEquals(Long.valueOf(4L), dataResp.getStudentId());
		assertEquals("John Doe", dataResp.getStudentName());
		assertEquals("01/01/2010", dataResp.getStudentDob());
		assertEquals("Male", dataResp.getStudentGender());
		assertEquals("5", dataResp.getStudentGrade());
		assertEquals("GRADE5", dataResp.getStudentGradeId());
		assertEquals("ABC School", dataResp.getStudentSchool());
		assertEquals("SCH001", dataResp.getStudentSchoolCode());
		assertEquals("Teacher One", dataResp.getTeacherName());
		assertEquals("teacher@test.com", dataResp.getTeacherEmail());
		assertEquals("Signature", dataResp.getTeacherSignature());
		assertEquals("06/08/2026", dataResp.getTeacherSignDate());
		assertEquals(planData, dataResp.getForm9EappPlanData());
	}

	@Test
	void testToString() {
		Form9EAPPDataResp dataResp = new Form9EAPPDataResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dataResp.toString());
	}

}
