package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ApplicationHistoryRespTest {

	@Test
	void testNoArgsConstructor() {
		ApplicationHistoryResp dto = new ApplicationHistoryResp();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-21";

		List<ApplicationHistoryDTO> applicationHistorDTO = Arrays.asList(new ApplicationHistoryDTO());

		ApplicationHistoryResp dto = new ApplicationHistoryResp(success, message, accessedOn, applicationHistorDTO);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(applicationHistorDTO, dto.getApplicationHistorDTO());
	}

	@Test
	void testGettersAndSetters() {
		ApplicationHistoryResp dto = new ApplicationHistoryResp();

		boolean success = true;
		String message = "Application history retrieved successfully";
		String accessedOn = "2026-08-21T19:00:00";

		List<ApplicationHistoryDTO> applicationHistorDTO = Arrays.asList(new ApplicationHistoryDTO());

		dto.setSuccess(success);
		dto.setMessage(message);
		dto.setAccessedOn(accessedOn);
		dto.setApplicationHistorDTO(applicationHistorDTO);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(applicationHistorDTO, dto.getApplicationHistorDTO());
	}

	@Test
	void testToString() {
		ApplicationHistoryResp dto = new ApplicationHistoryResp();

		String expectedString = "ApplicationHistoryResp [success=false, message=null, accessedOn=null, applicationHistorDTO=null]";

		assertEquals(expectedString, dto.toString());
	}
}