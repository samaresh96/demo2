package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeleteDocumentReqTest {

	@Test
	public void testDefaultConstructor() {
		DeleteDocumentReq request = new DeleteDocumentReq();

		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		DeleteDocumentReq request = new DeleteDocumentReq("DELETE", 101L, "Document Deletion", "SUCCESS",
				"Document deleted successfully", 1001L, "user123", "ADMIN");

		assertEquals("DELETE", request.getIndicator());
		assertEquals(Long.valueOf(101L), request.getId());
		assertEquals("Document Deletion", request.getActivity());
		assertEquals("SUCCESS", request.getStatus());
		assertEquals("Document deleted successfully", request.getComment());
		assertEquals(Long.valueOf(1001L), request.getApplicationId());
		assertEquals("user123", request.getLoggedInUserId());
		assertEquals("ADMIN", request.getLoggedInUserPersonType());
	}

	@Test
	public void testGettersAndSetters() {
		DeleteDocumentReq request = new DeleteDocumentReq();

		request.setIndicator("DELETE");
		request.setId(101L);
		request.setActivity("Document Deletion");
		request.setStatus("SUCCESS");
		request.setComment("Document deleted successfully");
		request.setApplicationId(1001L);
		request.setLoggedInUserId("user123");
		request.setLoggedInUserPersonType("ADMIN");

		assertEquals("DELETE", request.getIndicator());
		assertEquals(Long.valueOf(101L), request.getId());
		assertEquals("Document Deletion", request.getActivity());
		assertEquals("SUCCESS", request.getStatus());
		assertEquals("Document deleted successfully", request.getComment());
		assertEquals(Long.valueOf(1001L), request.getApplicationId());
		assertEquals("user123", request.getLoggedInUserId());
		assertEquals("ADMIN", request.getLoggedInUserPersonType());
	}

	@Test
	void testToString() {
		DeleteDocumentReq request = new DeleteDocumentReq();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, request.toString());
	}

}
