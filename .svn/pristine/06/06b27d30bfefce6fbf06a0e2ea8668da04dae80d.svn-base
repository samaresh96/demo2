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
class Form10HSAPPResponseDTOTest {

	@Test
	public void testDefaultConstructorAndGetterSetter() {

		Form10HSAPPResponseDTO response = new Form10HSAPPResponseDTO();

		Form10HSAPPDataResp dataResp = new Form10HSAPPDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		List<HIFormTransactionResp> attachmentList = new ArrayList<>();

		response.setSuccess(true);
		response.setMessage("Success");
		response.setAccessedOn("06/08/2026");
		response.setForm10HSAPPDataResp(dataResp);
		response.setConfigList(configList);
		response.setLookupList(lookupList);
		response.setAttachmentList(attachmentList);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("06/08/2026", response.getAccessedOn());
		assertEquals(dataResp, response.getForm10HSAPPDataResp());
		assertEquals(configList, response.getConfigList());
		assertEquals(lookupList, response.getLookupList());
		assertEquals(attachmentList, response.getAttachmentList());
	}

	@Test
	public void testParameterizedConstructor() {

		Form10HSAPPDataResp dataResp = new Form10HSAPPDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		Form10HSAPPResponseDTO response = new Form10HSAPPResponseDTO(true, "Success", "06/08/2026", dataResp,
				configList, lookupList, null);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("06/08/2026", response.getAccessedOn());
		assertEquals(dataResp, response.getForm10HSAPPDataResp());
		assertEquals(configList, response.getConfigList());
		assertEquals(lookupList, response.getLookupList());
	}

	@Test
	void testToString() {
		Form10HSAPPResponseDTO response = new Form10HSAPPResponseDTO();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, response.toString());
	}

}
