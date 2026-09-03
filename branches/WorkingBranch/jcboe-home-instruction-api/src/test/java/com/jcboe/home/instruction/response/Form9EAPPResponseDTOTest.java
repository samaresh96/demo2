package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Form9EAPPResponseDTOTest {

	@Test
	public void testDefaultConstructorAndSettersGetters() {
		Form9EAPPResponseDTO dto = new Form9EAPPResponseDTO();

		Form9EAPPDataResp dataResp = new Form9EAPPDataResp();
		Map<String, String> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		dto.setSuccess(true);
		dto.setMessage("Success");
		dto.setAccessedOn("2026-08-06");
		dto.setForm9EAPPDataResp(dataResp);
		dto.setConfigList(configList);
		dto.setLookupList(lookupList);

		assertTrue(dto.isSuccess());
		assertEquals("Success", dto.getMessage());
		assertEquals("2026-08-06", dto.getAccessedOn());
		assertEquals(dataResp, dto.getForm9EAPPDataResp());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
	}

	@Test
	public void testParameterizedConstructor() {

		Form9EAPPDataResp dataResp = new Form9EAPPDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		Form9EAPPResponseDTO dto = new Form9EAPPResponseDTO(true, "Success", "2026-08-06", dataResp, configList,
				lookupList);

		assertTrue(dto.isSuccess());
		assertEquals("Success", dto.getMessage());
		assertEquals("2026-08-06", dto.getAccessedOn());
		assertEquals(dataResp, dto.getForm9EAPPDataResp());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
	}

	@Test
	void testToString() {
		Form9EAPPResponseDTO dto = new Form9EAPPResponseDTO();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dto.toString());
	}

}
