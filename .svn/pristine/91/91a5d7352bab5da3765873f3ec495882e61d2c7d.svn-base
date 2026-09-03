package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Form8HiscpResponseDTOTest {

	@Test
	void testDefaultConstructorAndSetters() {

		Form8HiscpResponseDTO dto = new Form8HiscpResponseDTO();

		Form8HiscpDataResp dataResp = new Form8HiscpDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = new ArrayList<>();

		dto.setSuccess(true);
		dto.setMessage("Success");
		dto.setAccessedOn("2026-01-01");
		dto.setForm8HiscpDataResp(dataResp);
		dto.setConfigList(configList);
		dto.setLookupList(lookupList);

		assertTrue(dto.isSuccess());
		assertEquals("Success", dto.getMessage());
		assertEquals("2026-01-01", dto.getAccessedOn());
		assertEquals(dataResp, dto.getForm8HiscpDataResp());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());

		assertNotNull(dto.toString());
	}

	@Test
	void testParameterizedConstructor() {

		Form8HiscpDataResp dataResp = new Form8HiscpDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("config", "test");

		List<LookupDetails> lookupList = new ArrayList<>();

		Form8HiscpResponseDTO dto = new Form8HiscpResponseDTO(true, "Completed", "2026-01-02", dataResp, configList,
				lookupList);

		assertTrue(dto.isSuccess());
		assertEquals("Completed", dto.getMessage());
		assertEquals("2026-01-02", dto.getAccessedOn());
		assertEquals(dataResp, dto.getForm8HiscpDataResp());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());

		assertTrue(dto.toString().contains("Completed"));
	}

	@Test
	void testSetterUpdates() {

		Form8HiscpResponseDTO dto = new Form8HiscpResponseDTO();

		dto.setSuccess(false);
		dto.setMessage("Failed");
		dto.setAccessedOn("2026-02-01");

		assertFalse(dto.isSuccess());
		assertEquals("Failed", dto.getMessage());
		assertEquals("2026-02-01", dto.getAccessedOn());
	}
}