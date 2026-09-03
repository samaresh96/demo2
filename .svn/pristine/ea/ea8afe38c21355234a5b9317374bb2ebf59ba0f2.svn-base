package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TeacherListRespTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {
		TeacherListResp response = new TeacherListResp();

		response.setEmployeeId(100L);
		response.setEmployeeName("John Doe");

		assertEquals(100L, response.getEmployeeId());
		assertEquals("John Doe", response.getEmployeeName());
	}

	@Test
	void testParameterizedConstructor() {
		TeacherListResp response = new TeacherListResp(200L, "Jane Smith");

		assertEquals(200L, response.getEmployeeId());
		assertEquals("Jane Smith", response.getEmployeeName());
	}

	@Test
	void testToString() {
		TeacherListResp response = new TeacherListResp(300L, "Robert Brown");

		assertEquals("TeacherList [employeeId=300, employeeName=Robert Brown]", response.toString());
	}
}
