package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Form760DhiRespTest {

	@Test
	void testNoArgsConstructor() {
		Form760DhiResp dto = new Form760DhiResp();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-21";

		List<Form760DhiDataResp> form7AphirDataResp = Arrays.asList(new Form760DhiDataResp());

		List<LookupDetails> lookupTypeList = Arrays.asList(new LookupDetails());

		Map<String, Object> configList = new HashMap<>();
		configList.put("key", "value");

		Form760DhiResp dto = new Form760DhiResp(success, message, accessedOn, form7AphirDataResp, lookupTypeList,
				configList);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(form7AphirDataResp, dto.getForm7AphirDataResp());
		assertEquals(lookupTypeList, dto.getLookupTypeList());
		assertEquals(configList, dto.getConfigList());
	}

	@Test
	void testGettersAndSetters() {
		Form760DhiResp dto = new Form760DhiResp();

		boolean success = true;
		String message = "Application processed successfully";
		String accessedOn = "2026-08-21T19:00:00";

		List<Form760DhiDataResp> form7AphirDataResp = Arrays.asList(new Form760DhiDataResp());

		List<LookupDetails> lookupTypeList = Arrays.asList(new LookupDetails());

		Map<String, Object> configList = new HashMap<>();
		configList.put("status", "ACTIVE");

		dto.setSuccess(success);
		dto.setMessage(message);
		dto.setAccessedOn(accessedOn);
		dto.setForm7AphirDataResp(form7AphirDataResp);
		dto.setLookupTypeList(lookupTypeList);
		dto.setConfigList(configList);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(form7AphirDataResp, dto.getForm7AphirDataResp());
		assertEquals(lookupTypeList, dto.getLookupTypeList());
		assertEquals(configList, dto.getConfigList());
	}

	@Test
	void testToString() {
		Form760DhiResp dto = new Form760DhiResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dto.toString());
	}

}
