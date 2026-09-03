package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HIFormMasterRespTest {

	@Test
	public void testDefaultConstructorAndGettersSetters() {

		HIFormMasterResp resp = new HIFormMasterResp();

		resp.setId(1L);
		resp.setFormAbbreviation("F1");
		resp.setFormShortName("Form One");
		resp.setFormName("Form One Request");
		resp.setPdfName("form1.pdf");
		resp.setSpecialType("SPECIAL");
		resp.setActive(true);

		assertEquals(Long.valueOf(1L), resp.getId());
		assertEquals("F1", resp.getFormAbbreviation());
		assertEquals("Form One", resp.getFormShortName());
		assertEquals("Form One Request", resp.getFormName());
		assertEquals("form1.pdf", resp.getPdfName());
		assertEquals("SPECIAL", resp.getSpecialType());
		assertEquals(true, resp.isActive());
	}

	@Test
	public void testParameterizedConstructor() {

		HIFormMasterResp resp = new HIFormMasterResp(1L, "F1", "Form One", "Form One Request", "form1.pdf", "SPECIAL",
				true);

		assertEquals(Long.valueOf(1L), resp.getId());
		assertEquals("F1", resp.getFormAbbreviation());
		assertEquals("Form One", resp.getFormShortName());
		assertEquals("Form One Request", resp.getFormName());
		assertEquals("form1.pdf", resp.getPdfName());
		assertEquals("SPECIAL", resp.getSpecialType());
		assertEquals(true, resp.isActive());
	}

	@Test
	void testToString() {
		HIFormMasterResp resp = new HIFormMasterResp();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, resp.toString());
	}

}
