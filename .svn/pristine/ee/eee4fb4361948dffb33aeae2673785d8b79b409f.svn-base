package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class LogInResponseDTOTest {

	@Test
	void testDefaultConstructor() {

		LogInResponseDTO response = new LogInResponseDTO();

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertNull(response.getMessage());
		assertNull(response.getAccessedOn());
		assertNull(response.getConfigList());
		assertNull(response.getRecords());
		assertFalse(response.isValidCode());
		assertNull(response.getStudentListResp());
		assertFalse(response.isSamePassword());
	}

	@Test
	void testParameterizedConstructor() {

		Map<String, String> configList = new HashMap<>();
		configList.put("KEY", "VALUE");

		List<String> records = new ArrayList<>();
		records.add("Record1");

		LogInResponseDTO response = new LogInResponseDTO(true, "Success", "2025-01-01", configList, records, true);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("2025-01-01", response.getAccessedOn());
		assertEquals(configList, response.getConfigList());
		assertEquals(records, response.getRecords());
		assertTrue(response.isValidCode());

		assertNotNull(response.toString());
	}

	@Test
	void testSettersAndGetters() {

		LogInResponseDTO response = new LogInResponseDTO();

		Map<String, String> configList = new HashMap<>();
		configList.put("CONFIG", "TEST");

		List<String> records = new ArrayList<>();
		records.add("DATA");

		List<StudentDataResp> students = new ArrayList<>();
		students.add(new StudentDataResp(1L, "John", "01-01-2015", "M", "10", "5", 5, "ABC School", "ABC", "N",
				"Parent", "test@test.com", false, true));

		response.setSuccess(true);
		response.setMessage("Updated");
		response.setAccessedOn("2025-02-01");
		response.setConfigList(configList);
		response.setRecords(records);
		response.setValidCode(true);
		response.setStudentListResp(students);
		response.setSamePassword(true);

		assertTrue(response.isSuccess());
		assertEquals("Updated", response.getMessage());
		assertEquals("2025-02-01", response.getAccessedOn());
		assertEquals(configList, response.getConfigList());
		assertEquals(records, response.getRecords());
		assertTrue(response.isValidCode());
		assertEquals(students, response.getStudentListResp());
		assertTrue(response.isSamePassword());
	}

	@Test
	void testToString() {

		LogInResponseDTO response = new LogInResponseDTO(true, "Success", "2025-01-01", new HashMap<>(),
				new ArrayList<>(), true);

		response.setSamePassword(true);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("message=Success"));
		assertTrue(result.contains("validCode=true"));
		assertTrue(result.contains("samePassword=true"));
	}
}