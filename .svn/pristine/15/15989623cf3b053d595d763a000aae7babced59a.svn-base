package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppStatusListRespTest {

	@Test
	public void testNoArgsConstructor() {
		AppStatusListResp resp = new AppStatusListResp();

		assertNull(resp.getApplnstsAbbvrs());
		assertNull(resp.getStatusText());
	}

	@Test
	public void testParameterizedConstructor() {
		String applnstsAbbvrs = "APR";
		String statusText = "Approved";

		AppStatusListResp resp = new AppStatusListResp(applnstsAbbvrs, statusText);

		assertEquals(applnstsAbbvrs, resp.getApplnstsAbbvrs());
		assertEquals(statusText, resp.getStatusText());
	}

	@Test
	public void testGettersAndSetters() {
		AppStatusListResp resp = new AppStatusListResp();

		resp.setApplnstsAbbvrs("PND");
		resp.setStatusText("Pending");

		assertEquals("PND", resp.getApplnstsAbbvrs());
		assertEquals("Pending", resp.getStatusText());
	}

	@Test
	void testToString() {
		AppStatusListResp resp = new AppStatusListResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, resp.toString());
	}

}
