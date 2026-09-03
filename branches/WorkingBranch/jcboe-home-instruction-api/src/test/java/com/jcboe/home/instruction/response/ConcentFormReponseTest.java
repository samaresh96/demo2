package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcentFormReponseTest {

	@Test
	void testDefaultConstructorAndSetters() {

		ConcentFormReponse response = new ConcentFormReponse();

		response.setId(1L);
		response.setSubmittedFormId(2L);
		response.setStdSignature("stdSig");
		response.setStdPrintName("John");
		response.setStdSignDt("2025-01-01");
		response.setPntSignature("parentSig");
		response.setPntPrintName("Parent");
		response.setPntSignDt("2025-01-02");
		response.setSchoolName("ABC School");
		response.setSchoolDistrict("District");
		response.setErPrimaryPh(1111111111L);
		response.setErPrimaryRelation("Father");
		response.setErSecondPh(2222222222L);
		response.setErSecondRelation("Mother");
		response.setPhysicianPh(3333333333L);
		response.setPhysicianName("Doctor");
		response.setPhysicianAddr("Address");
		response.setPhysicianExist(true);
		response.setSubmittedOn("2025-01-03");
		response.setNote("Note");
		response.setActive(true);
		response.setAtheleticFormId(4L);
		response.setFormShortName("FORM");
		response.setAddress("Address");
		response.setStuedentInfoId(5L);
		response.setSubmissionDetailId(6L);
		response.setFormName("Form Name");
		response.setFormType("Type");
		response.setPdfName("file.pdf");
		response.setSpecialType("Special");
		response.setFormTypeName("Type Name");
		response.setFormStatus("Submitted");
		response.setCreatedOn("2025-01-04");
		response.setSchoolYear("2025");

		assertEquals(1L, response.getId());
		assertEquals(2L, response.getSubmittedFormId());
		assertEquals("stdSig", response.getStdSignature());
		assertEquals("John", response.getStdPrintName());
		assertEquals("2025-01-01", response.getStdSignDt());
		assertEquals("parentSig", response.getPntSignature());
		assertEquals("Parent", response.getPntPrintName());
		assertEquals("2025-01-02", response.getPntSignDt());
		assertEquals("ABC School", response.getSchoolName());
		assertEquals("District", response.getSchoolDistrict());
		assertEquals(1111111111L, response.getErPrimaryPh());
		assertEquals("Father", response.getErPrimaryRelation());
		assertEquals(2222222222L, response.getErSecondPh());
		assertEquals("Mother", response.getErSecondRelation());
		assertEquals(3333333333L, response.getPhysicianPh());
		assertEquals("Doctor", response.getPhysicianName());
		assertEquals("Address", response.getPhysicianAddr());
		assertTrue(response.isPhysicianExist());
		assertEquals("2025-01-03", response.getSubmittedOn());
		assertEquals("Note", response.getNote());
		assertTrue(response.isActive());
		assertEquals(4L, response.getAtheleticFormId());
		assertEquals("FORM", response.getFormShortName());
		assertEquals("Address", response.getAddress());
		assertEquals(5L, response.getStuedentInfoId());
		assertEquals(6L, response.getSubmissionDetailId());
		assertEquals("Form Name", response.getFormName());
		assertEquals("Type", response.getFormType());
		assertEquals("file.pdf", response.getPdfName());
		assertEquals("Special", response.getSpecialType());
		assertEquals("Type Name", response.getFormTypeName());
		assertEquals("Submitted", response.getFormStatus());
		assertEquals("2025-01-04", response.getCreatedOn());
		assertEquals("2025", response.getSchoolYear());
	}

	@Test
	void testFullParameterizedConstructor() {

		ConcentFormReponse response = new ConcentFormReponse(1L, 2L, "stdSig", "John", "2025-01-01", "parentSig",
				"Parent", "2025-01-02", "School", "District", 111L, "Father", 222L, "Mother", 333L, "Doctor", "Addr",
				true, "2025-01-03", "Note", true, 4L, "FORM", "Address", 5L, 6L, "Form", "Type", "pdf", "Special",
				"TypeName", "Submitted", "2025-01-04", "2025");

		assertEquals(1L, response.getId());
		assertEquals(2L, response.getSubmittedFormId());
		assertTrue(response.isPhysicianExist());
		assertTrue(response.isActive());
		assertEquals("Form", response.getFormName());
		assertEquals("2025", response.getSchoolYear());
	}

	@Test
	void testShortConstructor() {

		ConcentFormReponse response = new ConcentFormReponse(10L, 20L, 30L);

		assertEquals(10L, response.getSubmittedFormId());
		assertEquals(20L, response.getAtheleticFormId());
		assertEquals(30L, response.getStuedentInfoId());
	}

	@Test
	void testToString() {

		ConcentFormReponse response = new ConcentFormReponse(1L, 2L, 3L);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("submittedFormId=1"));
		assertTrue(result.contains("atheleticFormId=2"));
		assertTrue(result.contains("stuedentInfoId=3"));
	}
}