package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UpdateAssignTeacherReqTest {

	@Test
	public void testDefaultConstructor() {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {

		Long applicationId = 100L;
		String activity = "UPDATE";
		String status = "SUBMITTED";
		String comment = "Teacher assigned";
		String actionTakenBy = "USER123";
		String actionTakenByPersonType = "STAFF";
		String employeeIds = "101,102";

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq(applicationId, activity, status, comment,
				actionTakenBy, actionTakenByPersonType, employeeIds);

		assertEquals(applicationId, request.getApplicationId());
		assertEquals(activity, request.getActivity());
		assertEquals(status, request.getStatus());
		assertEquals(comment, request.getComment());
		assertEquals(actionTakenBy, request.getActionTakenBy());
		assertEquals(actionTakenByPersonType, request.getActionTakenByPersonType());
		assertEquals(employeeIds, request.getEmployeeIds());
	}

	@Test
	public void testSettersAndGetters() {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		request.setApplicationId(200L);
		request.setActivity("ASSIGN");
		request.setStatus("APPROVED");
		request.setComment("Teacher assignment completed");
		request.setActionTakenBy("USER456");
		request.setActionTakenByPersonType("TEACHER");
		request.setEmployeeIds("201,202,203");

		assertEquals(Long.valueOf(200L), request.getApplicationId());
		assertEquals("ASSIGN", request.getActivity());
		assertEquals("APPROVED", request.getStatus());
		assertEquals("Teacher assignment completed", request.getComment());
		assertEquals("USER456", request.getActionTakenBy());
		assertEquals("TEACHER", request.getActionTakenByPersonType());
		assertEquals("201,202,203", request.getEmployeeIds());
	}

	@Test
	void testToString() {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		String expectedString = "UpdateAssignTeacherReq [applicationId=null" + ", activity=null" + ", status=null"
				+ ", comment=null" + ", actionTakenBy=null" + ", actionTakenByPersonType=null" + ", employeeIds=null]";

		assertEquals(expectedString, request.toString());
	}
}
