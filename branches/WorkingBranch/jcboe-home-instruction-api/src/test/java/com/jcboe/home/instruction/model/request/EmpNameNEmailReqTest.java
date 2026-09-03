package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmpNameNEmailReqTest {

	@Test
	void testParameterizedConstructorAndGetters() {

		EmpNameNEmailReq request = new EmpNameNEmailReq("USR001", "John", "Doe", "EMPLOYEE");

		assertEquals("USR001", request.getUsrId());
		assertEquals("John", request.getUsrFirstName());
		assertEquals("Doe", request.getUsrLastName());
		assertEquals("EMPLOYEE", request.getUsrType());
	}

	@Test
	void testSetters() {

		EmpNameNEmailReq request = new EmpNameNEmailReq();

		request.setUsrId("USR002");
		request.setUsrFirstName("Jane");
		request.setUsrLastName("Smith");
		request.setUsrType("ADMIN");

		assertEquals("USR002", request.getUsrId());
		assertEquals("Jane", request.getUsrFirstName());
		assertEquals("Smith", request.getUsrLastName());
		assertEquals("ADMIN", request.getUsrType());
	}

	@Test
	void testDefaultConstructor() {

		EmpNameNEmailReq request = new EmpNameNEmailReq();

		assertNull(request.getUsrId());
		assertNull(request.getUsrFirstName());
		assertNull(request.getUsrLastName());
		assertNull(request.getUsrType());
	}

	@Test
	void testToString() {

		EmpNameNEmailReq request = new EmpNameNEmailReq("USR001", "John", "Doe", "EMPLOYEE");

		String result = request.toString();

		assertNotNull(result);
		assertTrue(result.contains("USR001"));
		assertTrue(result.contains("John"));
		assertTrue(result.contains("Doe"));
		assertTrue(result.contains("EMPLOYEE"));
	}
}