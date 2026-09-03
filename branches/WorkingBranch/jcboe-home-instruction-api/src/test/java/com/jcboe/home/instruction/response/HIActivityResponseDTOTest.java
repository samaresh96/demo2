package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HIActivityResponseDTOTest {

	@Test
	void testDefaultConstructor() {
		HIActivityResponseDTO dto = new HIActivityResponseDTO();

		assertNotNull(dto);
		assertFalse(dto.isSuccess());
		assertNull(dto.getMessage());
		assertNull(dto.getAccessedOn());
		assertNull(dto.getNotificationList());
		assertNull(dto.getApplicationInfo());
	}

	@Test
	void testParameterizedConstructorAndGetters() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-12";
		List<NotificationList> notificationList = Arrays.asList(new NotificationList());
		ApplicationInfoResp applicationInfo = new ApplicationInfoResp();

		HIActivityResponseDTO dto = new HIActivityResponseDTO(success, message, accessedOn, notificationList,
				applicationInfo);

		assertTrue(dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(notificationList, dto.getNotificationList());
		assertEquals(applicationInfo, dto.getApplicationInfo());
	}

	@Test
	void testSettersAndGetters() {
		HIActivityResponseDTO dto = new HIActivityResponseDTO();

		List<NotificationList> notificationList = Arrays.asList(new NotificationList());
		ApplicationInfoResp applicationInfo = new ApplicationInfoResp();

		dto.setSuccess(true);
		dto.setMessage("Test message");
		dto.setAccessedOn("2026-08-12");
		dto.setNotificationList(notificationList);
		dto.setApplicationInfo(applicationInfo);

		assertTrue(dto.isSuccess());
		assertEquals("Test message", dto.getMessage());
		assertEquals("2026-08-12", dto.getAccessedOn());
		assertEquals(notificationList, dto.getNotificationList());
		assertEquals(applicationInfo, dto.getApplicationInfo());
	}

	@Test
	void testSettersWithNullValues() {
		HIActivityResponseDTO dto = new HIActivityResponseDTO();

		dto.setSuccess(false);
		dto.setMessage(null);
		dto.setAccessedOn(null);
		dto.setNotificationList(null);
		dto.setApplicationInfo(null);

		assertFalse(dto.isSuccess());
		assertNull(dto.getMessage());
		assertNull(dto.getAccessedOn());
		assertNull(dto.getNotificationList());
		assertNull(dto.getApplicationInfo());
	}

	@Test
	void testToString() {
		HIActivityResponseDTO dto = new HIActivityResponseDTO();

		dto.setSuccess(true);
		dto.setMessage("Success");
		dto.setAccessedOn("2026-08-12");
		dto.setNotificationList(null);
		dto.setApplicationInfo(null);

		String result = dto.toString();

		assertNotNull(result);
		assertTrue(result.contains("HIActivityResponseDTO"));
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("message=Success"));
		assertTrue(result.contains("accessedOn=2026-08-12"));
		assertTrue(result.contains("notificationList=null"));
		assertTrue(result.contains("applicationInfo=null"));
	}
}
