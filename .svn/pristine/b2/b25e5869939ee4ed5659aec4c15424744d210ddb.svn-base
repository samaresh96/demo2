package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UpdateHIActivityReqTest {

	@Test
	void testNoArgsConstructor() {

		UpdateHIActivityReq req = new UpdateHIActivityReq();

		assertNull(req.getApplicationId());
		assertNull(req.getActivity());
		assertNull(req.getStatus());
		assertNull(req.getComment());
		assertNull(req.getActionTakenBy());
		assertNull(req.getActionTakenByPersonType());
		assertFalse(req.isApplicationInfo());
	}

	@Test
	void testParameterizedConstructor() {

		Long applicationId = 123L;
		String activity = "Application Submitted";
		String status = "COMPLETED";
		String comment = "Application processed successfully";
		String actionTakenBy = "admin";
		String actionTakenByPersonType = "USER";
		boolean applicationInfo = true;

		UpdateHIActivityReq req = new UpdateHIActivityReq(applicationId, activity, status, comment, actionTakenBy,
				actionTakenByPersonType, applicationInfo);

		assertEquals(applicationId, req.getApplicationId());
		assertEquals(activity, req.getActivity());
		assertEquals(status, req.getStatus());
		assertEquals(comment, req.getComment());
		assertEquals(actionTakenBy, req.getActionTakenBy());
		assertEquals(actionTakenByPersonType, req.getActionTakenByPersonType());
		assertTrue(req.isApplicationInfo());
	}

	@Test
	void testGettersAndSetters() {

		UpdateHIActivityReq req = new UpdateHIActivityReq();

		Long applicationId = 456L;
		String activity = "Application Updated";
		String status = "PENDING";
		String comment = "Application requires review";
		String actionTakenBy = "reviewer";
		String actionTakenByPersonType = "ADMIN";
		boolean applicationInfo = true;

		req.setApplicationId(applicationId);
		req.setActivity(activity);
		req.setStatus(status);
		req.setComment(comment);
		req.setActionTakenBy(actionTakenBy);
		req.setActionTakenByPersonType(actionTakenByPersonType);
		req.setApplicationInfo(applicationInfo);

		assertEquals(applicationId, req.getApplicationId());
		assertEquals(activity, req.getActivity());
		assertEquals(status, req.getStatus());
		assertEquals(comment, req.getComment());
		assertEquals(actionTakenBy, req.getActionTakenBy());
		assertEquals(actionTakenByPersonType, req.getActionTakenByPersonType());
		assertTrue(req.isApplicationInfo());
	}

	@Test
	void testApplicationInfoSetterWithFalse() {

		UpdateHIActivityReq req = new UpdateHIActivityReq();

		req.setApplicationInfo(false);

		assertFalse(req.isApplicationInfo());
	}

	@Test
	void testToString() {

		UpdateHIActivityReq req = new UpdateHIActivityReq();

		String expectedString = "UpdateHIActivityReq [applicationId=null, activity=null, status=null, "
				+ "comment=null, actionTakenBy=null, actionTakenByPersonType=null, applicationInfo=false]";

		assertEquals(expectedString, req.toString());
	}

	@Test
	void testToStringWithValues() {

		UpdateHIActivityReq req = new UpdateHIActivityReq(123L, "Application Submitted", "COMPLETED",
				"Application processed successfully", "admin", "USER", true);

		String expectedString = "UpdateHIActivityReq [applicationId=123, activity=Application Submitted, "
				+ "status=COMPLETED, comment=Application processed successfully, actionTakenBy=admin, "
				+ "actionTakenByPersonType=USER, applicationInfo=true]";

		assertEquals(expectedString, req.toString());
	}
}
