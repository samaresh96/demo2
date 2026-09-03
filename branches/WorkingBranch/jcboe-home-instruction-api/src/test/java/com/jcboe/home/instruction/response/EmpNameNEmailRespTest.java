package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmpNameNEmailRespTest {

	@Test
	void testParameterizedConstructor() {

		EmpNameNEmailResp response = new EmpNameNEmailResp(true, "Success", "test@test.com", "John Doe");

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("test@test.com", response.getEmil());
		assertEquals("John Doe", response.getName());

		assertNotNull(response.toString());
	}

	@Test
	void testTwoArgumentConstructor() {

		EmpNameNEmailResp response = new EmpNameNEmailResp("test@test.com", "John Doe");

		assertEquals("test@test.com", response.getEmil());
		assertEquals("John Doe", response.getName());

		assertFalse(response.isSuccess());
		assertNull(response.getMessage());
	}

	@Test
	void testSettersAndGetters() {

		EmpNameNEmailResp response = new EmpNameNEmailResp("old@test.com", "Old Name");

		response.setSuccess(true);
		response.setMessage("Updated");
		response.setEmil("new@test.com");
		response.setName("New Name");

		assertTrue(response.isSuccess());
		assertEquals("Updated", response.getMessage());
		assertEquals("new@test.com", response.getEmil());
		assertEquals("New Name", response.getName());
	}

	@Test
	void testToString() {

		EmpNameNEmailResp response = new EmpNameNEmailResp(true, "Success", "test@test.com", "John");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("test@test.com"));
		assertTrue(result.contains("John"));
	}
}