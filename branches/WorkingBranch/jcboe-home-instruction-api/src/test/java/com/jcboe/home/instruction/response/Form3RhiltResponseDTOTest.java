package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Form3RhiltResponseDTOTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		Form3RhiltResponseDTO dto = new Form3RhiltResponseDTO();

		Form3RhiltDataResp dataResp = new Form3RhiltDataResp();
		Map<String, String> config = new HashMap<>();
		config.put("key", "value");
		List<LookupDetails> lookupList = new ArrayList<>();

		dto.setSuccess(true);
		dto.setMessage("Success");
		dto.setAccessedOn("2024-01-01");
		dto.setForm3RhiltDataResp(dataResp);
		dto.setConfigList(config);
		dto.setLookupList(lookupList);

		assertTrue(dto.isSuccess());
		assertEquals("Success", dto.getMessage());
		assertEquals("2024-01-01", dto.getAccessedOn());
		assertSame(dataResp, dto.getForm3RhiltDataResp());
		assertSame(config, dto.getConfigList());
		assertSame(lookupList, dto.getLookupList());

		String str = dto.toString();
		assertNotNull(str);
		assertTrue(str.contains("Success"));
		assertTrue(str.contains("2024-01-01"));
	}

	@Test
	void testParameterizedConstructor() {

		Form3RhiltDataResp dataResp = new Form3RhiltDataResp();
		Map<String, String> config = new HashMap<>();
		List<LookupDetails> lookupList = new ArrayList<>();

		Form3RhiltResponseDTO dto = new Form3RhiltResponseDTO(true, "Completed", "2024-01-02", dataResp, config,
				lookupList);

		assertTrue(dto.isSuccess());
		assertEquals("Completed", dto.getMessage());
		assertEquals("2024-01-02", dto.getAccessedOn());
		assertSame(dataResp, dto.getForm3RhiltDataResp());
		assertSame(config, dto.getConfigList());
		assertSame(lookupList, dto.getLookupList());
	}
}