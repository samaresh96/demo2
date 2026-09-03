package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UploadFormDocumentReqTest {

	@Test
	public void testDefaultConstructor() {
		UploadFormDocumentReq request = new UploadFormDocumentReq();
		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		String indicator = "Y";
		long id = 1L;
		String studentId = "STU001";
		String schoolYear = "2026-2027";
		String applicationType = "FORM";
		String schoolCode = "SCH001";
		int gradeId = 10;
		String requestDate = "2026-08-08";
		String classification = "test";
		String activity = "Document Upload";
		String status = "UPLOADED";
		String comment = "Document uploaded successfully";
		Long applicationId = 100L;
		Long formMasterId = 200L;
		String otherDocumentName = "Medical Certificate";
		String uploadedGeneratedTag = "GENERATED_TAG_001";
		String originalFileName = "certificate.pdf";
		String originalFileExtension = "pdf";
		String originalFileSize = "1024";
		String encryptedFileGuid = "encrypted-guid-001";
		String fileStorageInd = "Y";
		String uploadedBy = "USER001";
		String uploadPersonType = "STUDENT";
		UploadFormDocumentReq request = new UploadFormDocumentReq(indicator, id, studentId, schoolYear, applicationType,
				schoolCode, gradeId, requestDate, classification, activity, status, comment, applicationId,
				formMasterId, otherDocumentName, uploadedGeneratedTag, originalFileName, originalFileExtension,
				originalFileSize, encryptedFileGuid, fileStorageInd, uploadedBy, uploadPersonType);
		assertEquals(indicator, request.getIndicator());
		assertEquals(id, request.getId());
		assertEquals(studentId, request.getStudentId());
		assertEquals(schoolYear, request.getSchoolYear());
		assertEquals(applicationType, request.getApplicationType());
		assertEquals(schoolCode, request.getSchoolCode());
		assertEquals(gradeId, request.getGradeId());
		assertEquals(requestDate, request.getRequestDate());
		assertEquals(activity, request.getActivity());
		assertEquals(status, request.getStatus());
		assertEquals(comment, request.getComment());
		assertEquals(applicationId, request.getApplicationId());
		assertEquals(formMasterId, request.getFormMasterId());
		assertEquals(otherDocumentName, request.getOtherDocumentName());
		assertEquals(uploadedGeneratedTag, request.getUploadedGeneratedTag());
		assertEquals(originalFileName, request.getOriginalFileName());
		assertEquals(originalFileExtension, request.getOriginalFileExtension());
		assertEquals(originalFileSize, request.getOriginalFileSize());
		assertEquals(encryptedFileGuid, request.getEncryptedFileGuid());
		assertEquals(fileStorageInd, request.getFileStorageInd());
		assertEquals(uploadedBy, request.getUploadedBy());
		assertEquals(uploadPersonType, request.getUploadPersonType());
	}

	@Test
	public void testSettersAndGetters() {
		UploadFormDocumentReq request = new UploadFormDocumentReq();
		request.setIndicator("N");
		request.setId(10L);
		request.setStudentId("STU002");
		request.setSchoolYear("2025-2026");
		request.setApplicationType("APPLICATION");
		request.setSchoolCode("SCH002");
		request.setGradeId(12);
		request.setRequestDate("2026-09-01");
		request.setActivity("Test Activity");
		request.setStatus("PENDING");
		request.setComment("Test Comment");
		request.setApplicationId(20L);
		request.setFormMasterId(30L);
		request.setOtherDocumentName("Test Document");
		request.setUploadedGeneratedTag("TAG002");
		request.setOriginalFileName("test-document.pdf");
		request.setOriginalFileExtension("pdf");
		request.setOriginalFileSize("2048");
		request.setEncryptedFileGuid("GUID002");
		request.setFileStorageInd("N");
		request.setUploadedBy("USER002");
		request.setUploadPersonType("TEACHER");
		assertEquals("N", request.getIndicator());
		assertEquals(10L, request.getId());
		assertEquals("STU002", request.getStudentId());
		assertEquals("2025-2026", request.getSchoolYear());
		assertEquals("APPLICATION", request.getApplicationType());
		assertEquals("SCH002", request.getSchoolCode());
		assertEquals(12, request.getGradeId());
		assertEquals("2026-09-01", request.getRequestDate());
		assertEquals("Test Activity", request.getActivity());
		assertEquals("PENDING", request.getStatus());
		assertEquals("Test Comment", request.getComment());
		assertEquals(Long.valueOf(20L), request.getApplicationId());
		assertEquals(Long.valueOf(30L), request.getFormMasterId());
		assertEquals("Test Document", request.getOtherDocumentName());
		assertEquals("TAG002", request.getUploadedGeneratedTag());
		assertEquals("test-document.pdf", request.getOriginalFileName());
		assertEquals("pdf", request.getOriginalFileExtension());
		assertEquals("2048", request.getOriginalFileSize());
		assertEquals("GUID002", request.getEncryptedFileGuid());
		assertEquals("N", request.getFileStorageInd());
		assertEquals("USER002", request.getUploadedBy());
		assertEquals("TEACHER", request.getUploadPersonType());
	}

	@Test
	void testToString() {
		UploadFormDocumentReq request = new UploadFormDocumentReq();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, request.toString());
	}
}