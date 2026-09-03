package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Form4PrthiResponseDTOTest {

	@Test
	void testDefaultConstructorGettersSettersAndToString() {

		Form4PrthiResponseDTO dto = new Form4PrthiResponseDTO();

		Form4PrthiDataResp dataResp = new Form4PrthiDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = new ArrayList<>();

		dto.setSuccess(true);
		dto.setMessage("Success");
		dto.setAccessedOn("2024-01-01");
		dto.setForm4PrthiDataResp(dataResp);
		dto.setConfigList(configList);
		dto.setLookupList(lookupList);

		assertTrue(dto.isSuccess());
		assertEquals("Success", dto.getMessage());
		assertEquals("2024-01-01", dto.getAccessedOn());
		assertSame(dataResp, dto.getForm4PrthiDataResp());
		assertSame(configList, dto.getConfigList());
		assertSame(lookupList, dto.getLookupList());

		String result = dto.toString();

		assertNotNull(result);
		assertTrue(result.contains("Success"));
		assertTrue(result.contains("2024-01-01"));
	}

	@Test
	void testParameterizedConstructor() {

		Form4PrthiDataResp dataResp = new Form4PrthiDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("config", "test");

		List<LookupDetails> lookupList = new ArrayList<>();

		Form4PrthiResponseDTO dto = new Form4PrthiResponseDTO(true, "Completed", "2024-02-01", dataResp, configList,
				lookupList);

		assertTrue(dto.isSuccess());
		assertEquals("Completed", dto.getMessage());
		assertEquals("2024-02-01", dto.getAccessedOn());
		assertSame(dataResp, dto.getForm4PrthiDataResp());
		assertSame(configList, dto.getConfigList());
		assertSame(lookupList, dto.getLookupList());

		assertNotNull(dto.toString());
	}
}