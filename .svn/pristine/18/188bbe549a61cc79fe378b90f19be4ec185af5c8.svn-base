package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Form1AphirScheduleRespTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		Form1AphirScheduleResp resp = new Form1AphirScheduleResp();

		resp.setId(1L);
		resp.setForm1APHIRDataId(10L);
		resp.setSubject("Mathematics");
		resp.setMp1("A");
		resp.setMp2("B");
		resp.setMp3("C");
		resp.setMp4("D");
		resp.setScheduleType("FULL_TIME");

		assertEquals(1L, resp.getId());
		assertEquals(10L, resp.getForm1APHIRDataId());
		assertEquals("Mathematics", resp.getSubject());
		assertEquals("A", resp.getMp1());
		assertEquals("B", resp.getMp2());
		assertEquals("C", resp.getMp3());
		assertEquals("D", resp.getMp4());
		assertEquals("FULL_TIME", resp.getScheduleType());

		String result = resp.toString();
		assertNotNull(result);
		assertTrue(result.contains("Mathematics"));
		assertTrue(result.contains("mp1=A"));
		assertTrue(result.contains("scheduleType=FULL_TIME"));
	}

	@Test
	void testParameterizedConstructor() {

		Form1AphirScheduleResp resp = new Form1AphirScheduleResp(1L, 10L, "Science", "P1", "P2", "P3", "P4",
				"PART_TIME");

		assertEquals(1L, resp.getId());
		assertEquals(10L, resp.getForm1APHIRDataId());
		assertEquals("Science", resp.getSubject());
		assertEquals("P1", resp.getMp1());
		assertEquals("P2", resp.getMp2());
		assertEquals("P3", resp.getMp3());
		assertEquals("P4", resp.getMp4());
		assertEquals("PART_TIME", resp.getScheduleType());

		String result = resp.toString();
		assertNotNull(result);
		assertTrue(result.contains("Science"));
		assertTrue(result.contains("P4"));
		assertTrue(result.contains("scheduleType=PART_TIME"));
	}
}