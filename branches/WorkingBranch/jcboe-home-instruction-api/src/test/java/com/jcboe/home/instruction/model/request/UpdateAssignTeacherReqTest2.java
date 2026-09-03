package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UpdateAssignTeacherReqTest2 {

	@Test
	void testDefaultConstructorAndSettersGetters() {
		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		request.setApplicationId(100L);
		request.setActivity("ASSIGN_TEACHER");
		request.setStatus("APPROVED");
		request.setComment("Teacher assigned successfully");
		request.setActionTakenBy("admin");
		request.setActionTakenByPersonType("STAFF");
		request.setEmployeeIds("101,102,103");

		assertEquals(100L, request.getApplicationId());
		assertEquals("ASSIGN_TEACHER", request.getActivity());
		assertEquals("APPROVED", request.getStatus());
		assertEquals("Teacher assigned successfully", request.getComment());
		assertEquals("admin", request.getActionTakenBy());
		assertEquals("STAFF", request.getActionTakenByPersonType());
		assertEquals("101,102,103", request.getEmployeeIds());
	}

	@Test
	void testParameterizedConstructor() {
		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq(200L, "UPDATE_TEACHER", "PENDING",
				"Waiting for approval", "manager", "MANAGER", "201,202");

		assertEquals(200L, request.getApplicationId());
		assertEquals("UPDATE_TEACHER", request.getActivity());
		assertEquals("PENDING", request.getStatus());
		assertEquals("Waiting for approval", request.getComment());
		assertEquals("manager", request.getActionTakenBy());
		assertEquals("MANAGER", request.getActionTakenByPersonType());
		assertEquals("201,202", request.getEmployeeIds());
	}

	@Test
	void testToString() {
		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq(300L, "ASSIGN_TEACHER", "APPROVED",
				"Assignment completed", "admin", "STAFF", "301,302");

		assertEquals("UpdateAssignTeacherReq [applicationId=300, activity=ASSIGN_TEACHER, status=APPROVED, "
				+ "comment=Assignment completed, actionTakenBy=admin, "
				+ "actionTakenByPersonType=STAFF, employeeIds=301,302]", request.toString());
	}
}
