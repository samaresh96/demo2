package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ApplicationHistoryDTOTest {

	@Test
	void testNoArgsConstructor() {
		ApplicationHistoryDTO dto = new ApplicationHistoryDTO();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		Long id = 101L;
		String action = "Application Submitted";
		String actionAbbreviation = "SUB";
		String status = "Submitted";
		String statusAbbreviation = "SUB";
		String comment = "Application submitted successfully";
		String actionTakenBy = "John Doe";
		String actionTakenOn = "2026-08-21T19:00:00";
		String actionTakenByPersonType = "USER";

		ApplicationHistoryDTO dto = new ApplicationHistoryDTO(id, action, actionAbbreviation, status,
				statusAbbreviation, comment, actionTakenBy, actionTakenOn, actionTakenByPersonType);

		assertEquals(id, dto.getId());
		assertEquals(action, dto.getAction());
		assertEquals(actionAbbreviation, dto.getActionAbbreviation());
		assertEquals(status, dto.getStatus());
		assertEquals(statusAbbreviation, dto.getStatusAbbreviation());
		assertEquals(comment, dto.getComment());
		assertEquals(actionTakenBy, dto.getActionTakenBy());
		assertEquals(actionTakenOn, dto.getActionTakenOn());
		assertEquals(actionTakenByPersonType, dto.getActionTakenByPersonType());
	}

	@Test
	void testGettersAndSetters() {
		ApplicationHistoryDTO dto = new ApplicationHistoryDTO();

		Long id = 202L;
		String action = "Application Approved";
		String actionAbbreviation = "APP";
		String status = "Approved";
		String statusAbbreviation = "APR";
		String comment = "Application approved";
		String actionTakenBy = "Jane Smith";
		String actionTakenOn = "2026-08-22T10:30:00";
		String actionTakenByPersonType = "ADMIN";

		dto.setId(id);
		dto.setAction(action);
		dto.setActionAbbreviation(actionAbbreviation);
		dto.setStatus(status);
		dto.setStatusAbbreviation(statusAbbreviation);
		dto.setComment(comment);
		dto.setActionTakenBy(actionTakenBy);
		dto.setActionTakenOn(actionTakenOn);
		dto.setActionTakenByPersonType(actionTakenByPersonType);

		assertEquals(id, dto.getId());
		assertEquals(action, dto.getAction());
		assertEquals(actionAbbreviation, dto.getActionAbbreviation());
		assertEquals(status, dto.getStatus());
		assertEquals(statusAbbreviation, dto.getStatusAbbreviation());
		assertEquals(comment, dto.getComment());
		assertEquals(actionTakenBy, dto.getActionTakenBy());
		assertEquals(actionTakenOn, dto.getActionTakenOn());
		assertEquals(actionTakenByPersonType, dto.getActionTakenByPersonType());
	}

	@Test
	void testToString() {
		ApplicationHistoryDTO dto = new ApplicationHistoryDTO();

		String expectedString = "ApplicationHistorDTO [id=null, action=null, actionAbbreviation=null, status=null, "
				+ "statusAbbreviation=null, comment=null, actionTakenBy=null, actionTakenOn=null, "
				+ "actionTakenByPersonType=null]";

		assertEquals(expectedString, dto.toString());
	}
}