package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class GetStudentParentInfoRespTest {

	@Test
	void testDefaultConstructor() {
		GetStudentParentInfoResp response = new GetStudentParentInfoResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		List<StudentDataResp> studentList = new ArrayList<>();
		StudentDataResp student = new StudentDataResp();
		student.setStudentId(1L);
		student.setStudentName("Test Student");
		studentList.add(student);

		GetStudentParentInfoResp response = new GetStudentParentInfoResp(true, "Success", "2026-01-01", studentList);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("2026-01-01", response.getAccessedOn());
		assertEquals(studentList, response.getStudentInfoList());

		assertNotNull(response.toString());
	}

	@Test
	void testSettersAndGetters() {

		GetStudentParentInfoResp response = new GetStudentParentInfoResp();

		List<StudentDataResp> studentList = new ArrayList<>();
		Map<String, String> configList = new HashMap<>();

		response.setSuccess(true);
		response.setMessage("Message");
		response.setAccessedOn("2026-01-01");
		response.setStudentInfoList(studentList);
		response.setConfigList(configList);

		assertTrue(response.isSuccess());
		assertEquals("Message", response.getMessage());
		assertEquals("2026-01-01", response.getAccessedOn());
		assertEquals(studentList, response.getStudentInfoList());
		assertEquals(configList, response.getConfigList());
	}

	@Test
	void testToString() {
		GetStudentParentInfoResp response = new GetStudentParentInfoResp(false, "Failed", "2026-01-01",
				new ArrayList<>());

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("GetStudentParentInfoResp"));
	}
}