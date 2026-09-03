package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AssignTeacherResponseTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {
		AssignTeacherResponse response = new AssignTeacherResponse();

		response.setSuccess(true);
		response.setMessage("Teacher assigned successfully");
		response.setAccessedOn("2026-08-29");

		assertTrue(response.isSuccess());
		assertEquals("Teacher assigned successfully", response.getMessage());
		assertEquals("2026-08-29", response.getAccessedOn());
	}

	@Test
	void testParameterizedConstructor() {
		AssignTeacherResponse response = new AssignTeacherResponse(true, "Teacher assigned successfully", "2026-08-29");

		assertTrue(response.isSuccess());
		assertEquals("Teacher assigned successfully", response.getMessage());
		assertEquals("2026-08-29", response.getAccessedOn());
	}

	@Test
	void testSetSuccessFalse() {
		AssignTeacherResponse response = new AssignTeacherResponse();

		response.setSuccess(false);

		assertFalse(response.isSuccess());
	}

	@Test
	void testToString() {
		AssignTeacherResponse response = new AssignTeacherResponse(true, "Teacher assigned successfully", "2026-08-29");

		assertEquals(
				"AssignTeacherResponse [success=true, message=Teacher assigned successfully, accessedOn=2026-08-29]",
				response.toString());
	}
}
