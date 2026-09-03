package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ApplicationTrackingRequestTest {

	@Test
	public void testDefaultConstructor() {
		ApplicationTrackingRequest request = new ApplicationTrackingRequest();
		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		ApplicationTrackingDataList data1 = new ApplicationTrackingDataList();
		ApplicationTrackingDataList data2 = new ApplicationTrackingDataList();

		List<ApplicationTrackingDataList> applicationTrackingDataList = Arrays.asList(data1, data2);
		String loggedInUserId = "USER001";
		String loggedInUserPersonType = "PHYSICIAN";

		ApplicationTrackingRequest request = new ApplicationTrackingRequest(applicationTrackingDataList, loggedInUserId,
				loggedInUserPersonType);

		assertEquals(applicationTrackingDataList, request.getApplicationTrackingDataList());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());
	}

	@Test
	public void testSettersAndGetters() {
		ApplicationTrackingRequest request = new ApplicationTrackingRequest();

		ApplicationTrackingDataList data1 = new ApplicationTrackingDataList();
		ApplicationTrackingDataList data2 = new ApplicationTrackingDataList();

		List<ApplicationTrackingDataList> applicationTrackingDataList = Arrays.asList(data1, data2);

		request.setApplicationTrackingDataList(applicationTrackingDataList);
		request.setLoggedInUserId("USER002");
		request.setLoggedInUserPersonType("NURSE");

		assertEquals(applicationTrackingDataList, request.getApplicationTrackingDataList());
		assertEquals("USER002", request.getLoggedInUserId());
		assertEquals("NURSE", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {
		ApplicationTrackingDataList data1 = new ApplicationTrackingDataList();
		ApplicationTrackingDataList data2 = new ApplicationTrackingDataList();

		List<ApplicationTrackingDataList> applicationTrackingDataList = Arrays.asList(data1, data2);
		String loggedInUserId = "USER001";
		String loggedInUserPersonType = "PHYSICIAN";

		ApplicationTrackingRequest request = new ApplicationTrackingRequest(applicationTrackingDataList, loggedInUserId,
				loggedInUserPersonType);

		String expectedString = "ApplicationTrackingRequest [applicationTrackingDataList=" + applicationTrackingDataList
				+ ", loggedInUserId=" + loggedInUserId + ", loggedInUserPersonType=" + loggedInUserPersonType + "]";

		assertEquals(expectedString, request.toString());
	}
}
