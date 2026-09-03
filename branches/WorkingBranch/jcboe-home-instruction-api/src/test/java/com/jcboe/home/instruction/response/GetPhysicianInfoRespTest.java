package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GetPhysicianInfoRespTest {

	@Test
	void testDefaultConstructor() {

		GetPhysicianInfoResp response = new GetPhysicianInfoResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructor() {

		String physicianName = "Dr. John Smith";
		String physicianSignDate = "08/19/2026";

		GetPhysicianInfoResp response = new GetPhysicianInfoResp(physicianName, physicianSignDate);

		assertEquals(physicianName, response.getPhysicianName());
		assertEquals(physicianSignDate, response.getPhysicianSignDate());
	}

	@Test
	void testSettersAndGetters() {

		GetPhysicianInfoResp response = new GetPhysicianInfoResp();

		String physicianName = "Dr. Jane Doe";
		String physicianSignDate = "08/20/2026";

		response.setPhysicianName(physicianName);
		response.setPhysicianSignDate(physicianSignDate);

		assertEquals(physicianName, response.getPhysicianName());
		assertEquals(physicianSignDate, response.getPhysicianSignDate());
	}

	@Test
	void testToString() {

		GetPhysicianInfoResp response = new GetPhysicianInfoResp("Dr. John Smith", "08/19/2026");

		String result = response.toString();

		assertNotNull(result);

		assertEquals("GetPhysicianInfoResp [physicianName=Dr. John Smith, physicianSignDate=08/19/2026]", result);
	}
}
