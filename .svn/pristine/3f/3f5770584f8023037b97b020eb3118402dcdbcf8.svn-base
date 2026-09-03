package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class NotificationDetailsRespTest {

	@Test
	void testNoArgsConstructor() {

		NotificationDetailsResp response = new NotificationDetailsResp();

		assertNotNull(response);
		assertNull(response.getRequestedOn());
		assertNull(response.getComment());
		assertNull(response.getRequestedBy());
		assertNull(response.getRequestedByName());
		assertNull(response.getActivity());
	}

	@Test
	void testParameterizedConstructor() {

		String requestedOn = "2026-08-14";
		String comment = "Test notification";
		Long requestedBy = 123L;
		String requestedByName = "John Doe";
		String activity = "Application Submitted";

		NotificationDetailsResp response = new NotificationDetailsResp(requestedOn, comment, requestedBy,
				requestedByName, activity);

		assertEquals(requestedOn, response.getRequestedOn());
		assertEquals(comment, response.getComment());
		assertEquals(requestedBy, response.getRequestedBy());
		assertEquals(requestedByName, response.getRequestedByName());
		assertEquals(activity, response.getActivity());
	}

	@Test
	void testGettersAndSetters() {

		NotificationDetailsResp response = new NotificationDetailsResp();

		String requestedOn = "2026-08-15";
		String comment = "Updated notification";
		Long requestedBy = 456L;
		String requestedByName = "Jane Smith";
		String activity = "Application Updated";

		response.setRequestedOn(requestedOn);
		response.setComment(comment);
		response.setRequestedBy(requestedBy);
		response.setRequestedByName(requestedByName);
		response.setActivity(activity);

		assertEquals(requestedOn, response.getRequestedOn());
		assertEquals(comment, response.getComment());
		assertEquals(requestedBy, response.getRequestedBy());
		assertEquals(requestedByName, response.getRequestedByName());
		assertEquals(activity, response.getActivity());
	}

	@Test
	void testToString() {

		NotificationDetailsResp response = new NotificationDetailsResp();

		String expectedString = "NotificationDetailsResp [requestedOn=null, comment=null, "
				+ "requestedBy=null, requestedByName=null, activity=null]";

		assertEquals(expectedString, response.toString());
	}

	@Test
	void testToStringWithValues() {

		NotificationDetailsResp response = new NotificationDetailsResp("2026-08-14", "Test notification", 123L,
				"John Doe", "Application Submitted");

		String expectedString = "NotificationDetailsResp [requestedOn=2026-08-14, comment=Test notification, "
				+ "requestedBy=123, requestedByName=John Doe, activity=Application Submitted]";

		assertEquals(expectedString, response.toString());
	}
}
