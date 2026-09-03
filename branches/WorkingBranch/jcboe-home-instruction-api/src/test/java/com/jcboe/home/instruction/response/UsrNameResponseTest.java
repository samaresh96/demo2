package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class UsrNameResponseTest {

	@Test
	public void testDefaultConstructor() {
		UsrNameResponse response = new UsrNameResponse();
		assertNotNull(response);
	}

	@Test
	public void testSuccessConstructor() {
		boolean success = true;
		String userName = "testUser";
		String password = "testPassword";
		UsrNameResponse response = new UsrNameResponse(success, userName, password);
		assertEquals(success, response.isSuccess());
		assertEquals(userName, response.getUserName());
		assertEquals(password, response.getPassword());
	}

	@Test
	public void testUserDetailsParameterizedConstructor() {
		String userName = "john.doe";
		String password = "password123";
		String firstName = "John";
		String middleName = "Michael";
		String lastName = "Doe";
		String locationId = "LOC001";
		String location = "Main Campus";
		String applicationRoleId = "ROLE001";
		String appRoleAbbreviation = "ADMIN";
		String appRoleName = "Administrator";
		boolean registered = true;
		long userId = 1001L;
		UsrNameResponse response = new UsrNameResponse(userName, password, firstName, middleName, lastName, locationId,
				location, applicationRoleId, appRoleAbbreviation, appRoleName, registered, userId);
		assertEquals(userName, response.getUserName());
		assertEquals(password, response.getPassword());
		assertEquals(firstName, response.getFirstName());
		assertEquals(middleName, response.getMiddleName());
		assertEquals(lastName, response.getLastName());
		assertEquals(locationId, response.getLocationId());
		assertEquals(location, response.getLocation());
		assertEquals(applicationRoleId, response.getApplicationRoleId());
		assertEquals(appRoleAbbreviation, response.getAppRoleAbbreviation());
		assertEquals(appRoleName, response.getAppRoleName());
		assertEquals(registered, response.isRegistered());
		assertEquals(userId, response.getUserId());
	}

	@Test
	public void testSettersAndGetters() {
		UsrNameResponse response = new UsrNameResponse();
		response.setSuccess(true);
		response.setMessage("Login successful");
		response.setUserName("jane.doe");
		response.setPassword("password456");
		response.setFirstName("Jane");
		response.setMiddleName("Marie");
		response.setLastName("Doe");
		response.setLocationId("LOC002");
		response.setLocation("West Campus");
		response.setApplicationRoleId("ROLE002");
		response.setAppRoleAbbreviation("USER");
		response.setAppRoleName("Standard User");
		response.setRegistered(false);
		response.setUserId(2002L);
		response.setProgramNames("Program A, Program B");
		Map<String, String> configList = new HashMap<String, String>();
		configList.put("key1", "value1");
		response.setConfigList(configList);
		assertTrue(response.isSuccess());
		assertEquals("Login successful", response.getMessage());
		assertEquals("jane.doe", response.getUserName());
		assertEquals("password456", response.getPassword());
		assertEquals("Jane", response.getFirstName());
		assertEquals("Marie", response.getMiddleName());
		assertEquals("Doe", response.getLastName());
		assertEquals("LOC002", response.getLocationId());
		assertEquals("West Campus", response.getLocation());
		assertEquals("ROLE002", response.getApplicationRoleId());
		assertEquals("USER", response.getAppRoleAbbreviation());
		assertEquals("Standard User", response.getAppRoleName());
		assertEquals(false, response.isRegistered());
		assertEquals(2002L, response.getUserId());
		assertEquals("Program A, Program B", response.getProgramNames());
		assertEquals(configList, response.getConfigList());
	}

	@Test
	void testToString() {
		UsrNameResponse response = new UsrNameResponse();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, response.toString());
	}
}