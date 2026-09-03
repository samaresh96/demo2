package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FormSubFolderRespTest {

	@Test
	void testDefaultConstructor() {
		FormSubFolderResp response = new FormSubFolderResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		FormSubFolderResp response = new FormSubFolderResp(1L, "Medical Forms", "Student medical related forms");

		assertEquals(1L, response.getId());
		assertEquals("Medical Forms", response.getSubFolder());
		assertEquals("Student medical related forms", response.getDescription());

		assertNotNull(response.toString());
	}

	@Test
	void testSettersAndGetters() {

		FormSubFolderResp response = new FormSubFolderResp();

		response.setId(10L);
		response.setSubFolder("Test Folder");
		response.setDescription("Test Description");

		assertEquals(10L, response.getId());
		assertEquals("Test Folder", response.getSubFolder());
		assertEquals("Test Description", response.getDescription());
	}

	@Test
	void testToString() {

		FormSubFolderResp response = new FormSubFolderResp(100L, "Folder", "Description");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("FormSubFolderResp"));
		assertTrue(result.contains("Folder"));
	}
}