package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Form9EAPPPlanDataRespTest {

	@Test
	public void testDefaultConstructorAndGetterSetter() {

		Form9EAPPPlanDataResp planData = new Form9EAPPPlanDataResp();

		planData.setId(1L);
		planData.setForm9EappDataId(100L);
		planData.setPlanType("Medical");
		planData.setPlan1("Plan A");
		planData.setPlan2("Plan B");

		assertEquals(Long.valueOf(1L), planData.getId());
		assertEquals(Long.valueOf(100L), planData.getForm9EappDataId());
		assertEquals("Medical", planData.getPlanType());
		assertEquals("Plan A", planData.getPlan1());
		assertEquals("Plan B", planData.getPlan2());
	}

	@Test
	public void testParameterizedConstructor() {

		Form9EAPPPlanDataResp planData = new Form9EAPPPlanDataResp(1L, 100L, "Medical", "Plan A", "Plan B");

		assertEquals(Long.valueOf(1L), planData.getId());
		assertEquals(Long.valueOf(100L), planData.getForm9EappDataId());
		assertEquals("Medical", planData.getPlanType());
		assertEquals("Plan A", planData.getPlan1());
		assertEquals("Plan B", planData.getPlan2());
	}

	@Test
	void testToString() {
		Form9EAPPPlanDataResp planData = new Form9EAPPPlanDataResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, planData.toString());
	}

}
