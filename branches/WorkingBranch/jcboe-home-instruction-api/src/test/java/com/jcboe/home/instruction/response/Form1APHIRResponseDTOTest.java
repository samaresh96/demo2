package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Form1APHIRResponseDTOTest {

	@Test
	void testNoArgsConstructor() {
		Form1APHIRResponseDTO dto = new Form1APHIRResponseDTO();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-21";

		Form1AphirDataResp form1AphirDataResp = new Form1AphirDataResp();

		List<Form1AphirScheduleResp> form1AphirScheduleResp = Arrays.asList(new Form1AphirScheduleResp());

		List<HIFormTransactionResp> attachmentList = Arrays.asList(new HIFormTransactionResp());

		Map<String, Object> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		List<StudentDataResp> studentList = Arrays.asList(new StudentDataResp());

		GetPhysicianInfoResp physicianData = new GetPhysicianInfoResp();

		Form1APHIRResponseDTO dto = new Form1APHIRResponseDTO(success, message, accessedOn, form1AphirDataResp,
				form1AphirScheduleResp, attachmentList, configList, lookupList, studentList, physicianData);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(form1AphirDataResp, dto.getForm1AphirDataResp());
		assertEquals(form1AphirScheduleResp, dto.getForm1AphirScheduleResp());
		assertEquals(attachmentList, dto.getAttachmentList());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
		assertEquals(studentList, dto.getStudentList());
		assertEquals(physicianData, dto.getPhysicianData());
	}

	@Test
	void testGettersAndSetters() {
		Form1APHIRResponseDTO dto = new Form1APHIRResponseDTO();

		boolean success = true;
		String message = "Application processed successfully";
		String accessedOn = "2026-08-21T19:00:00";

		Form1AphirDataResp form1AphirDataResp = new Form1AphirDataResp();

		List<Form1AphirScheduleResp> form1AphirScheduleResp = Arrays.asList(new Form1AphirScheduleResp());

		List<HIFormTransactionResp> attachmentList = Arrays.asList(new HIFormTransactionResp());

		Map<String, Object> configList = new HashMap<>();
		configList.put("status", "ACTIVE");

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		List<StudentDataResp> studentList = Arrays.asList(new StudentDataResp());

		GetPhysicianInfoResp physicianData = new GetPhysicianInfoResp();

		dto.setSuccess(success);
		dto.setMessage(message);
		dto.setAccessedOn(accessedOn);
		dto.setForm1AphirDataResp(form1AphirDataResp);
		dto.setForm1AphirScheduleResp(form1AphirScheduleResp);
		dto.setAttachmentList(attachmentList);
		dto.setConfigList(configList);
		dto.setLookupList(lookupList);
		dto.setStudentList(studentList);
		dto.setPhysicianData(physicianData);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(form1AphirDataResp, dto.getForm1AphirDataResp());
		assertEquals(form1AphirScheduleResp, dto.getForm1AphirScheduleResp());
		assertEquals(attachmentList, dto.getAttachmentList());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
		assertEquals(studentList, dto.getStudentList());
		assertEquals(physicianData, dto.getPhysicianData());
	}

	@Test
	void testHIFormTransactionRespGetterSetter() {

		Form1APHIRResponseDTO dto = new Form1APHIRResponseDTO();

		List<HIFormTransactionResp> list = new ArrayList<>();
		list.add(new HIFormTransactionResp());

		dto.setAttachmentList(list);

		assertEquals(list, dto.getAttachmentList());
	}
	
	@Test
	void testToString() {
		Form1APHIRResponseDTO resp = new Form1APHIRResponseDTO();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, resp.toString());
	}
}