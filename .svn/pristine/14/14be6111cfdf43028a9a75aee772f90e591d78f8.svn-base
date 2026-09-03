package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class NotificationListTest {

	@Test
	void testDefaultConstructor() {
		NotificationList notificationList = new NotificationList();

		assertNotNull(notificationList);
		assertEquals(null, notificationList.getId());
		assertEquals(null, notificationList.getTitle());
		assertEquals(null, notificationList.getRespondActivity());
		assertEquals(null, notificationList.getNotificationDetails());
	}

	@Test
	void testParameterizedConstructor() {

		List<NotificationDetailsResp> details = new ArrayList<>();

		NotificationList notificationList = new NotificationList(100L, "Application approved", "APPROVED", details);

		assertEquals(Long.valueOf(100L), notificationList.getId());
		assertEquals("Application approved", notificationList.getTitle());
		assertEquals("APPROVED", notificationList.getRespondActivity());
		assertEquals(details, notificationList.getNotificationDetails());
	}

	@Test
	void testGettersAndSetters() {

		NotificationList notificationList = new NotificationList();

		List<NotificationDetailsResp> details = new ArrayList<>();

		notificationList.setId(100L);
		notificationList.setTitle("Application approved");
		notificationList.setRespondActivity("APPROVED");
		notificationList.setNotificationDetails(details);

		assertEquals(Long.valueOf(100L), notificationList.getId());
		assertEquals("Application approved", notificationList.getTitle());
		assertEquals("APPROVED", notificationList.getRespondActivity());
		assertEquals(details, notificationList.getNotificationDetails());
	}

	@Test
	void testSettersWithNullValues() {

		NotificationList notificationList = new NotificationList();

		notificationList.setId(null);
		notificationList.setTitle(null);
		notificationList.setRespondActivity(null);
		notificationList.setNotificationDetails(null);

		assertEquals(null, notificationList.getId());
		assertEquals(null, notificationList.getTitle());
		assertEquals(null, notificationList.getRespondActivity());
		assertEquals(null, notificationList.getNotificationDetails());
	}

	@Test
	void testToString() {

		List<NotificationDetailsResp> details = new ArrayList<>();

		NotificationList notificationList = new NotificationList(100L, "Application approved", "APPROVED", details);

		String expectedString = "NotificationList [id=100, title=Application approved, "
				+ "respondActivity=APPROVED, notificationDetails=[]]";

		assertEquals(expectedString, notificationList.toString());
	}
}
