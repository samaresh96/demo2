package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;

import org.junit.jupiter.api.Test;

class HIFormTransactionRespTest {

	@Test
	void testDefaultConstructorAndSettersGetters() {

		HIFormTransactionResp resp = new HIFormTransactionResp();

		File file = new File("test.txt");

		resp.setId(1L);
		resp.setApplicationId(2L);
		resp.setActivityId(3L);
		resp.setFormMasterId(4L);
		resp.setFormName("Other Doc");
		resp.setOtherDocumentName("Other Document");
		resp.setUploadedGeneratedTag("TAG123");
		resp.setDataRecordId(5L);
		resp.setOriginalFileName("sample.pdf");
		resp.setUploadedFileName("uploaded_sample.pdf");
		resp.setOriginalFileExtension("pdf");
		resp.setOriginalFileSize(10.5);
		resp.setFileSize("10.5 KB");
		resp.setEncryptedFileGuid("GUID123");
		resp.setFileStorageIndicator("LOCAL");
		resp.setUploadedBy(100L);
		resp.setUploadedOn("2024-01-01");
		resp.setUploadedByPersonType("ADMIN");
		resp.setDownloadedFile(file);

		assertEquals(1L, resp.getId());
		assertEquals(2L, resp.getApplicationId());
		assertEquals(3L, resp.getActivityId());
		assertEquals(4L, resp.getFormMasterId());
		assertEquals("Other Doc", resp.getFormName());
		assertEquals("Other Document", resp.getOtherDocumentName());
		assertEquals("TAG123", resp.getUploadedGeneratedTag());
		assertEquals(5L, resp.getDataRecordId());
		assertEquals("sample.pdf", resp.getOriginalFileName());
		assertEquals("uploaded_sample.pdf", resp.getUploadedFileName());
		assertEquals("pdf", resp.getOriginalFileExtension());
		assertEquals(10.5, resp.getOriginalFileSize());
		assertEquals("10.5 KB", resp.getFileSize());
		assertEquals("GUID123", resp.getEncryptedFileGuid());
		assertEquals("LOCAL", resp.getFileStorageIndicator());
		assertEquals(100L, resp.getUploadedBy());
		assertEquals("2024-01-01", resp.getUploadedOn());
		assertEquals("ADMIN", resp.getUploadedByPersonType());
		assertEquals(file, resp.getDownloadedFile());
	}

	@Test
	void testParameterizedConstructor() {

		Long id = 1L;
		Long applicationId = 2L;
		Long activityId = 3L;
		Long formMasterId = 4L;
		String formName = "Other Doc";
		String otherDocumentName = "Other Document";
		String uploadedGeneratedTag = "TAG123";
		Long dataRecordId = 5L;
		String originalFileName = "sample.pdf";
		String uploadedFileName = "uploaded_sample.pdf";
		String originalFileExtension = "pdf";
		Double originalFileSize = 10.5;
		String fileSize = "10.5 KB";
		String encryptedFileGuid = "GUID123";
		String fileStorageIndicator = "LOCAL";
		Long uploadedBy = 100L;
		String uploadedOn = "2024-01-01";
		String uploadedByPersonType = "ADMIN";

		HIFormTransactionResp resp = new HIFormTransactionResp(id, applicationId, activityId, formMasterId, formName,
				otherDocumentName, uploadedGeneratedTag, dataRecordId, originalFileName, uploadedFileName,
				originalFileExtension, originalFileSize, fileSize, encryptedFileGuid, fileStorageIndicator, uploadedBy,
				uploadedOn, uploadedByPersonType);

		assertEquals(id, resp.getId());
		assertEquals(applicationId, resp.getApplicationId());
		assertEquals(activityId, resp.getActivityId());
		assertEquals(formMasterId, resp.getFormMasterId());
		assertEquals(formName, resp.getFormName());
		assertEquals(otherDocumentName, resp.getOtherDocumentName());
		assertEquals(uploadedGeneratedTag, resp.getUploadedGeneratedTag());
		assertEquals(dataRecordId, resp.getDataRecordId());
		assertEquals(originalFileName, resp.getOriginalFileName());
		assertEquals(uploadedFileName, resp.getUploadedFileName());
		assertEquals(originalFileExtension, resp.getOriginalFileExtension());
		assertEquals(originalFileSize, resp.getOriginalFileSize());
		assertEquals(fileSize, resp.getFileSize());
		assertEquals(encryptedFileGuid, resp.getEncryptedFileGuid());
		assertEquals(fileStorageIndicator, resp.getFileStorageIndicator());
		assertEquals(uploadedBy, resp.getUploadedBy());
		assertEquals(uploadedOn, resp.getUploadedOn());
		assertEquals(uploadedByPersonType, resp.getUploadedByPersonType());
		assertNull(resp.getDownloadedFile());
	}

	@Test
	void testDefaultValues() {

		HIFormTransactionResp resp = new HIFormTransactionResp();

		assertNull(resp.getId());
		assertNull(resp.getApplicationId());
		assertNull(resp.getActivityId());
		assertNull(resp.getFormMasterId());
		assertNull(resp.getFormName());
		assertNull(resp.getOtherDocumentName());
		assertNull(resp.getUploadedGeneratedTag());
		assertNull(resp.getDataRecordId());
		assertNull(resp.getOriginalFileName());
		assertNull(resp.getUploadedFileName());
		assertNull(resp.getOriginalFileExtension());
		assertNull(resp.getOriginalFileSize());
		assertNull(resp.getFileSize());
		assertNull(resp.getEncryptedFileGuid());
		assertNull(resp.getFileStorageIndicator());
		assertNull(resp.getUploadedBy());
		assertNull(resp.getUploadedOn());
		assertNull(resp.getUploadedByPersonType());
		assertNull(resp.getDownloadedFile());
	}

	@Test
	void testToString() {

		HIFormTransactionResp resp = new HIFormTransactionResp();

		String expectedString = "HIFormTransactionResp [id=null, applicationId=null, activityId=null, "
				+ "formMasterId=null, formName=null, otherDocumentName=null, uploadedGeneratedTag=null, "
				+ "dataRecordId=null, originalFileName=null, uploadedFileName=null, originalFileExtension=null, "
				+ "originalFileSize=null, fileSize=null, encryptedFileGuid=null, fileStorageIndicator=null, "
				+ "uploadedBy=null, uploadedOn=null, uploadedByPersonType=null, downloadedFile=null]";

		assertEquals(expectedString, resp.toString());
	}

	@Test
	void testToStringWithValues() {

		File file = new File("test.txt");

		HIFormTransactionResp resp = new HIFormTransactionResp(1L, 2L, 3L, 4L, "Form", "Other Document", "TAG123", 5L,
				"original.pdf", "uploaded.pdf", "pdf", 10.5, "10.5 KB", "GUID123", "LOCAL", 100L, "2024-01-01",
				"ADMIN");

		resp.setDownloadedFile(file);

		String expectedString = "HIFormTransactionResp [id=1, applicationId=2, activityId=3, "
				+ "formMasterId=4, formName=Form, otherDocumentName=Other Document, "
				+ "uploadedGeneratedTag=TAG123, dataRecordId=5, originalFileName=original.pdf, "
				+ "uploadedFileName=uploaded.pdf, originalFileExtension=pdf, originalFileSize=10.5, "
				+ "fileSize=10.5 KB, encryptedFileGuid=GUID123, fileStorageIndicator=LOCAL, "
				+ "uploadedBy=100, uploadedOn=2024-01-01, uploadedByPersonType=ADMIN, " + "downloadedFile=" + file
				+ "]";

		assertEquals(expectedString, resp.toString());
	}
}
