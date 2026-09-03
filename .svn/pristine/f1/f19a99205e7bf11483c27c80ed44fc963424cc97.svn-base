package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Form9EAppPlanDataTest {

	@Test
	public void testDefaultConstructorAndSettersGetters() {
		Form9EAppPlanData data = new Form9EAppPlanData();

		data.setIndicator("Y");
		data.setId(101);
		data.setPlanType("TYPE1");
		data.setPlan1("PLAN_A");
		data.setPlan2("PLAN_B");

		assertEquals("Y", data.getIndicator());
		assertEquals(Integer.valueOf(101), data.getId());
		assertEquals("TYPE1", data.getPlanType());
		assertEquals("PLAN_A", data.getPlan1());
		assertEquals("PLAN_B", data.getPlan2());
	}

	@Test
	public void testParameterizedConstructor() {
		Form9EAppPlanData data = new Form9EAppPlanData("N", 200, "TYPE2", "PLAN1", "PLAN2");

		assertEquals("N", data.getIndicator());
		assertEquals(Integer.valueOf(200), data.getId());
		assertEquals("TYPE2", data.getPlanType());
		assertEquals("PLAN1", data.getPlan1());
		assertEquals("PLAN2", data.getPlan2());
	}

	@Test
	void testToString() {

		Form9EAppPlanData data = new Form9EAppPlanData();

		String result = data.toString();

		assertNotNull(result);
		assertTrue(result.contains("CONFIG_KEY"));
		assertTrue(result.contains("LOOKUP_TYPE"));
		assertTrue(result.contains("2026"));
	}

}
