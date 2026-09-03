package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ApplicationTrackingResponseDTOTest {

	@Test
	void testNoArgsConstructor() {
		ApplicationTrackingResponseDTO dto = new ApplicationTrackingResponseDTO();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-21";

		List<GetApplicationTrackingResp> applicationTrackingRespList = Arrays.asList(new GetApplicationTrackingResp());

		Map<String, Object> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		ApplicationTrackingResponseDTO dto = new ApplicationTrackingResponseDTO(success, message, accessedOn,
				applicationTrackingRespList, configList, lookupList);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(applicationTrackingRespList, dto.getApplicationTrackingRespList());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
	}

	@Test
	void testGettersAndSetters() {
		ApplicationTrackingResponseDTO dto = new ApplicationTrackingResponseDTO();

		boolean success = true;
		String message = "Application found";
		String accessedOn = "2026-08-21T19:00:00";

		List<GetApplicationTrackingResp> applicationTrackingRespList = Arrays.asList(new GetApplicationTrackingResp());

		Map<String, Object> configList = new HashMap<>();
		configList.put("status", "ACTIVE");

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		dto.setSuccess(success);
		dto.setMessage(message);
		dto.setAccessedOn(accessedOn);
		dto.setApplicationTrackingRespList(applicationTrackingRespList);
		dto.setConfigList(configList);
		dto.setLookupList(lookupList);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(applicationTrackingRespList, dto.getApplicationTrackingRespList());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
	}

	@Test
	void testToString() {
		ApplicationTrackingResponseDTO resp = new ApplicationTrackingResponseDTO();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, resp.toString());
	}

}
