package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Form760DhiResponseDTOTest {

	@Test
	void testNoArgsConstructor() {
		Form760DhiResponseDTO dto = new Form760DhiResponseDTO();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-21";

		List<HIFormTransactionResp> attachmentList = Arrays.asList(new HIFormTransactionResp());

		Form760DhiResponseDTO dto = new Form760DhiResponseDTO(success, message, accessedOn, attachmentList);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(attachmentList, dto.getAttachmentList());
	}

	@Test
	void testGettersAndSetters() {
		Form760DhiResponseDTO dto = new Form760DhiResponseDTO();

		boolean success = true;
		String message = "Application processed successfully";
		String accessedOn = "2026-08-21T19:00:00";

		List<HIFormTransactionResp> attachmentList = Arrays.asList(new HIFormTransactionResp());

		dto.setSuccess(success);
		dto.setMessage(message);
		dto.setAccessedOn(accessedOn);
		dto.setAttachmentList(attachmentList);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(attachmentList, dto.getAttachmentList());
	}

	@Test
	void testToString() {
		Form760DhiResponseDTO resp = new Form760DhiResponseDTO();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, resp.toString());
	}
}