package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Form2RHIDTResponseDTOTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		Form2RHIDTResponseDTO dto = new Form2RHIDTResponseDTO();

		assertNotNull(dto);
		assertEquals(false, dto.isSuccess());
		assertNull(dto.getMessage());
		assertNull(dto.getAccessedOn());
		assertNull(dto.getform2RHIDTDataResp());
		assertNull(dto.getConfigList());
		assertNull(dto.getLookupList());
		assertNull(dto.getPhysicianData());

		Form2RHIDTDataResp dataResp = new Form2RHIDTDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("KEY", "VALUE");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		GetPhysicianInfoResp physicianData = new GetPhysicianInfoResp();

		dto.setSuccess(true);
		dto.setMessage("Success");
		dto.setAccessedOn("2026-01-01");
		dto.setForm2RHIDTDataResp(dataResp);
		dto.setConfigList(configList);
		dto.setLookupList(lookupList);
		dto.setPhysicianData(physicianData);

		assertTrue(dto.isSuccess());
		assertEquals("Success", dto.getMessage());
		assertEquals("2026-01-01", dto.getAccessedOn());
		assertEquals(dataResp, dto.getform2RHIDTDataResp());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
		assertEquals(physicianData, dto.getPhysicianData());
	}

	@Test
	void testParameterizedConstructor() {

		Form2RHIDTDataResp dataResp = new Form2RHIDTDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("KEY", "VALUE");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		GetPhysicianInfoResp physicianData = new GetPhysicianInfoResp();

		Form2RHIDTResponseDTO dto = new Form2RHIDTResponseDTO(true, "Success", "2026-01-01", dataResp, configList,
				lookupList, physicianData);

		assertTrue(dto.isSuccess());
		assertEquals("Success", dto.getMessage());
		assertEquals("2026-01-01", dto.getAccessedOn());
		assertEquals(dataResp, dto.getform2RHIDTDataResp());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
		assertEquals(physicianData, dto.getPhysicianData());
	}

	@Test
	void testToString() {

		Form2RHIDTResponseDTO dto = new Form2RHIDTResponseDTO();

		String expectedString = "Form2RHIDTResponseDTO [success=false, message=null, accessedOn=null, "
				+ "form2RHIDTDataResp=null, configList=null, lookupList=null, physicianData=null]";

		assertEquals(expectedString, dto.toString());
	}

	@Test
	void testToStringWithValues() {

		Form2RHIDTDataResp dataResp = new Form2RHIDTDataResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("KEY", "VALUE");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		GetPhysicianInfoResp physicianData = new GetPhysicianInfoResp();

		Form2RHIDTResponseDTO dto = new Form2RHIDTResponseDTO(true, "Success", "2026-01-01", dataResp, configList,
				lookupList, physicianData);

		String expectedString = "Form2RHIDTResponseDTO [success=true, message=Success, accessedOn=2026-01-01, "
				+ "form2RHIDTDataResp=" + dataResp + ", configList=" + configList + ", lookupList=" + lookupList
				+ ", physicianData=" + physicianData + "]";

		assertEquals(expectedString, dto.toString());
	}
}
