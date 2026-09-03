package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Form630DhiResponseDTOTest {

	@Test
	void testDefaultConstructor() {
		Form630DhiResponseDTO response = new Form630DhiResponseDTO();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		Form630DhiDataResp dataResp = new Form630DhiDataResp(1L, 2L, 3L, null, "Nurse", "2026-01-01", "Physician",
				"2026-01-02", null, null, 0, null, null, null, null, null, null);

		Map<String, String> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = new ArrayList<>();

		Form630DhiResponseDTO response = new Form630DhiResponseDTO(true, "Success", "2026-01-03", dataResp, configList,
				lookupList, null);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("2026-01-03", response.getAccessedOn());
		assertEquals(dataResp, response.getForm630DhiDataResp());
		assertEquals(configList, response.getConfigList());
		assertEquals(lookupList, response.getLookupList());
	}

	@Test
	void testSetters() {

		Form630DhiResponseDTO response = new Form630DhiResponseDTO();

		Form630DhiDataResp dataResp = new Form630DhiDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("test", "data");

		List<LookupDetails> lookupList = new ArrayList<>();

		List<HIFormTransactionResp> attachmentList = new ArrayList<>();

		response.setSuccess(true);
		response.setMessage("Test Message");
		response.setAccessedOn("2026-02-01");
		response.setForm630DhiDataResp(dataResp);
		response.setConfigList(configList);
		response.setLookupList(lookupList);
		response.setAttachmentList(attachmentList);

		assertTrue(response.isSuccess());
		assertEquals("Test Message", response.getMessage());
		assertEquals("2026-02-01", response.getAccessedOn());
		assertEquals(dataResp, response.getForm630DhiDataResp());
		assertEquals(configList, response.getConfigList());
		assertEquals(lookupList, response.getLookupList());
		assertEquals(attachmentList, response.getAttachmentList());
	}

	@Test
	void testToString() {

		Form630DhiResponseDTO response = new Form630DhiResponseDTO();

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("Form630DhiResponseDTO"));
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("Success"));
	}
}