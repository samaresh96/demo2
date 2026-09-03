package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UpdateHIActivityRespTest {

	@Test
	public void testNoArgsConstructor() {
		UpdateHIActivityResp resp = new UpdateHIActivityResp();

		assertEquals(null, resp.getActivityId());
		assertEquals(null, resp.getApplicationNo());
		assertEquals(null, resp.getApplicationStatus());
		assertEquals(null, resp.getApplicationStatusAbbrev());
	}

	@Test
	public void testParameterizedConstructor() {
		Long activityId = 123L;
		String applicationNo = "APP001";
		String applicationStatus = "COMPLETED";
		String applicationStatusAbbrev = "CMP";

		UpdateHIActivityResp resp = new UpdateHIActivityResp(activityId, applicationNo, applicationStatus,
				applicationStatusAbbrev);

		assertEquals(activityId, resp.getActivityId());
		assertEquals(applicationNo, resp.getApplicationNo());
		assertEquals(applicationStatus, resp.getApplicationStatus());
		assertEquals(applicationStatusAbbrev, resp.getApplicationStatusAbbrev());
	}

	@Test
	public void testGettersAndSetters() {
		UpdateHIActivityResp resp = new UpdateHIActivityResp();

		Long activityId = 456L;
		String applicationNo = "APP002";
		String applicationStatus = "PENDING";
		String applicationStatusAbbrev = "PND";

		resp.setActivityId(activityId);
		resp.setApplicationNo(applicationNo);
		resp.setApplicationStatus(applicationStatus);
		resp.setApplicationStatusAbbrev(applicationStatusAbbrev);

		assertEquals(activityId, resp.getActivityId());
		assertEquals(applicationNo, resp.getApplicationNo());
		assertEquals(applicationStatus, resp.getApplicationStatus());
		assertEquals(applicationStatusAbbrev, resp.getApplicationStatusAbbrev());
	}

	@Test
	void testToString() {
		UpdateHIActivityResp resp = new UpdateHIActivityResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, resp.toString());
	}

}
