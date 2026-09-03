package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDetailTest {

	@Test
	void testDefaultConstructorAndSetters() {

		UserDetail user = new UserDetail();

		user.setId(1L);
		user.setUserActivityId(2L);
		user.setEmployeeId(3L);
		user.setEmployeeFirstName("John");
		user.setEmployeeMiddleName("M");
		user.setEmployeeLastName("Smith");
		user.setEmployeeName("John M Smith");
		user.setActivityId(4L);
		user.setCreatedBy(5L);
		user.setMadeInactiveBy(6L);
		user.setActive(true);
		user.setLocationId("100");
		user.setLocation("School");
		user.setEffectiveDate("2025-01-01");
		user.setEndDate("2025-12-31");
		user.setIndicator("Y");
		user.setUserAssignable(true);
		user.setUserActLocIds("1,2");
		user.setUserActLocations("Location1");
		user.setThresholdAmount("100");
		user.setThresholdHour("10");

		assertEquals(1L, user.getId());
		assertEquals(2L, user.getUserActivityId());
		assertEquals(3L, user.getEmployeeId());
		assertEquals("John", user.getEmployeeFirstName());
		assertEquals("M", user.getEmployeeMiddleName());
		assertEquals("Smith", user.getEmployeeLastName());
		assertEquals("John M Smith", user.getEmployeeName());
		assertEquals(4L, user.getActivityId());
		assertEquals(5L, user.getCreatedBy());
		assertEquals(6L, user.getMadeInactiveBy());
		assertTrue(user.isActive());
		assertEquals("100", user.getLocationId());
		assertEquals("School", user.getLocation());
		assertEquals("2025-01-01", user.getEffectiveDate());
		assertEquals("2025-12-31", user.getEndDate());
		assertEquals("Y", user.getIndicator());
		assertTrue(user.isUserAssignable());
		assertEquals("1,2", user.getUserActLocIds());
		assertEquals("Location1", user.getUserActLocations());
		assertEquals("100", user.getThresholdAmount());
		assertEquals("10", user.getThresholdHour());
	}

	@Test
	void testFirstParameterizedConstructor() {

		UserDetail user = new UserDetail(1L, 2L, 3L, "John", "M", "Smith", "John M Smith", 4L, 5L, 6L, true, "100",
				"School");

		assertEquals(1L, user.getId());
		assertEquals(2L, user.getUserActivityId());
		assertEquals(3L, user.getEmployeeId());
		assertEquals("John", user.getEmployeeFirstName());
		assertEquals("M", user.getEmployeeMiddleName());
		assertEquals("Smith", user.getEmployeeLastName());
		assertEquals("John M Smith", user.getEmployeeName());
		assertEquals(4L, user.getActivityId());
		assertEquals(5L, user.getCreatedBy());
		assertEquals(6L, user.getMadeInactiveBy());
		assertTrue(user.isActive());
		assertEquals("100", user.getLocationId());
		assertEquals("School", user.getLocation());
	}

	@Test
	void testSecondParameterizedConstructor() {

		UserDetail user = new UserDetail(1L, 2L, 3L, "John Smith", 4L, true, "100", "School", "2025-01-01",
				"2025-12-31", true, "1,2", "Location1", "100", "10");

		assertEquals(1L, user.getId());
		assertEquals(2L, user.getUserActivityId());
		assertEquals(3L, user.getEmployeeId());
		assertEquals("John Smith", user.getEmployeeName());
		assertEquals(4L, user.getActivityId());
		assertTrue(user.isActive());
		assertEquals("100", user.getLocationId());
		assertEquals("School", user.getLocation());
		assertEquals("2025-01-01", user.getEffectiveDate());
		assertEquals("2025-12-31", user.getEndDate());
		assertTrue(user.isUserAssignable());
		assertEquals("1,2", user.getUserActLocIds());
		assertEquals("Location1", user.getUserActLocations());
		assertEquals("100", user.getThresholdAmount());
		assertEquals("10", user.getThresholdHour());
	}

	@Test
	void testToString() {

		UserDetail user = new UserDetail();
		user.setId(1L);
		user.setEmployeeName("John");
		user.setLocation("School");

		String result = user.toString();

		assertNotNull(result);
		assertTrue(result.contains("id=1"));
		assertTrue(result.contains("employeeName=John"));
		assertTrue(result.contains("location=School"));
	}
}