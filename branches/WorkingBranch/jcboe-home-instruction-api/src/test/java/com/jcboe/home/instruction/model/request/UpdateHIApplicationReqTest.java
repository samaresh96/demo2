package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UpdateHIApplicationReqTest {

	@Test
	void testNoArgsConstructor() {
		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		assertNotNull(request);
	}

	@Test
	void testParameterizedConstructor() {
		UpdateHIApplicationReq request = new UpdateHIApplicationReq("HI", 123L, "STU001", "2025-2026", "NEW", "SCH001",
				5, "2025-08-14", null, "admin", "STAFF");

		assertEquals("HI", request.getIndicator());
		assertEquals(123L, request.getId());
		assertEquals("STU001", request.getStudentId());
		assertEquals("2025-2026", request.getSchoolYear());
		assertEquals("NEW", request.getApplicationType());
		assertEquals("SCH001", request.getSchoolCode());
		assertEquals(5, request.getGradeId());
		assertEquals("2025-08-14", request.getRequestDate());
		assertEquals("admin", request.getSubmittedBy());
		assertEquals("STAFF", request.getSubmittedByPersonType());
	}

	@Test
	void testGettersAndSetters() {
		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("HI");
		request.setId(123L);
		request.setStudentId("STU001");
		request.setSchoolYear("2025-2026");
		request.setApplicationType("NEW");
		request.setSchoolCode("SCH001");
		request.setGradeId(5);
		request.setRequestDate("2025-08-14");
		request.setActivity("SUBMIT");
		request.setStatus("ACTIVE");
		request.setComment("Test comment");
		request.setSubmittedBy("admin");
		request.setSubmittedByPersonType("STAFF");

		assertEquals("HI", request.getIndicator());
		assertEquals(123L, request.getId());
		assertEquals("STU001", request.getStudentId());
		assertEquals("2025-2026", request.getSchoolYear());
		assertEquals("NEW", request.getApplicationType());
		assertEquals("SCH001", request.getSchoolCode());
		assertEquals(5, request.getGradeId());
		assertEquals("2025-08-14", request.getRequestDate());
		assertEquals("SUBMIT", request.getActivity());
		assertEquals("ACTIVE", request.getStatus());
		assertEquals("Test comment", request.getComment());
		assertEquals("admin", request.getSubmittedBy());
		assertEquals("STAFF", request.getSubmittedByPersonType());
	}

	@Test
	void testToString() {
		UpdateHIApplicationReq request = new UpdateHIApplicationReq();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, request.toString());
	}

}
