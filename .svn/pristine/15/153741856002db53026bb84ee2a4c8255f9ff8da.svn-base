package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInfoReqTest {

	@Test
	public void testNoArgConstructor() {
		UserInfoReq userInfoReq = new UserInfoReq();

		assertNotNull(userInfoReq);
	}

	@Test
	public void testParameterizedConstructor() {
		UserInfoReq userInfoReq = new UserInfoReq("I", "EMP001", "ADMIN", "9876543210", "9123456780");

		assertEquals("I", userInfoReq.getIndicator());
		assertEquals("EMP001", userInfoReq.getEmployeeId());
		assertEquals("ADMIN", userInfoReq.getUserType());
		assertEquals("9876543210", userInfoReq.getPhoneNumber1());
		assertEquals("9123456780", userInfoReq.getPhoneNumber2());
	}

	@Test
	public void testGettersAndSetters() {
		UserInfoReq userInfoReq = new UserInfoReq();

		userInfoReq.setIndicator("U");
		userInfoReq.setEmployeeId("EMP002");
		userInfoReq.setUserType("USER");
		userInfoReq.setPhoneNumber1("9876543211");
		userInfoReq.setPhoneNumber2("9123456781");

		assertEquals("U", userInfoReq.getIndicator());
		assertEquals("EMP002", userInfoReq.getEmployeeId());
		assertEquals("USER", userInfoReq.getUserType());
		assertEquals("9876543211", userInfoReq.getPhoneNumber1());
		assertEquals("9123456781", userInfoReq.getPhoneNumber2());
	}

	@Test
	void testToString() {
		UserInfoReq request = new UserInfoReq();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, request.toString());
	}

}
