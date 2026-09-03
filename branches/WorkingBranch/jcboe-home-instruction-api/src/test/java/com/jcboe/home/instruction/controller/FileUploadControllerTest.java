package com.jcboe.home.instruction.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.ApplicationTrackingRequest;
import com.jcboe.home.instruction.model.request.DHIRequest;
import com.jcboe.home.instruction.model.request.DeleteDocumentReq;
import com.jcboe.home.instruction.model.request.UploadFormDocumentReq;
import com.jcboe.home.instruction.response.DeleteDocResponse;
import com.jcboe.home.instruction.response.FileUploadResp;
import com.jcboe.home.instruction.response.GetAttachmentListResp;
import com.jcboe.home.instruction.service.IFileUploadService;
import com.jcboe.home.instruction.service.MessageServiceImpl;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@ExtendWith(MockitoExtension.class)
class FileUploadControllerTest {

	@Mock
	private IFileUploadService uploadService;

	@Mock
	private MessageServiceImpl messageService;

	@Mock
	private Utility utility;

	@Mock
	private HttpServletResponse response;

	@Mock
	private Resource resource;

	@InjectMocks
	private FileUploadController fileUploadController;

	// =========================================================
	// uploadFormDocument
	// =========================================================

	@Test
	void testUploadFormDocument_Success() {

		MultipartFile file = new MockMultipartFile("file", "test.pdf", "application/pdf",
				"test data".getBytes(StandardCharsets.UTF_8));

		FileUploadResp expectedResponse = new FileUploadResp(true, "File uploaded successfully");

		when(uploadService.uploadAndParseFile(eq(file), any(UploadFormDocumentReq.class))).thenReturn(expectedResponse);

		ResponseEntity<FileUploadResp> result = fileUploadController.uploadFormDocument(file, "I", 100L, "5001", "2025",
				"HOME", "SCH001", 5, "2025-01-01", "test", "UPLOAD", "ACTIVE", "comment", 10L, 20L, "test.pdf",
				"test.pdf", "999", "PARENT");

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(expectedResponse, result.getBody());

		verify(messageService).getMessage(Constant.FUA_API);

		verify(uploadService).uploadAndParseFile(eq(file), any(UploadFormDocumentReq.class));

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	@Test
	void testUploadFormDocument_Exception() {

		MultipartFile file = new MockMultipartFile("file", "test.pdf", "application/pdf",
				"test".getBytes(StandardCharsets.UTF_8));

		RuntimeException exception = new RuntimeException("Upload failed");

		when(uploadService.uploadAndParseFile(eq(file), any(UploadFormDocumentReq.class))).thenThrow(exception);

		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> fileUploadController.uploadFormDocument(file, "I", 100L, "5001", "2025", "HOME", "SCH001", 5,
						"2025-01-01", "test", "UPLOAD", "ACTIVE", null, null, 20L, "test.pdf", "test.pdf", "999",
						"PARENT"));

		assertSame(exception, thrown);

		verify(messageService).getMessage(Constant.FUA_API);

		verify(uploadService).uploadAndParseFile(eq(file), any(UploadFormDocumentReq.class));

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	// =========================================================
	// getPdfFileDetails
	// =========================================================

	@Test
	void testGetPdfFileDetails_Success() {

		ResponseEntity<String> result = fileUploadController.getPdfFileDetails(1L, 2L, 3L, "PARENT", "2025", response);

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNull(result.getBody());

		verify(uploadService).getPdfFileDetails(1L, 2L, 3L, "PARENT", "2025", response);
	}

	@Test
	void testGetPdfFileDetails_Exception() {

		RuntimeException exception = new RuntimeException("PDF error");

		doThrow(exception).when(uploadService).getPdfFileDetails(1L, 2L, 3L, "PARENT", "2025", response);

		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> fileUploadController.getPdfFileDetails(1L, 2L, 3L, "PARENT", "2025", response));

		assertSame(exception, thrown);
	}

	// =========================================================
	// downloadFormDocument - Resource found
	// =========================================================

	@Test
	void testDownloadFormDocument_ResourceFound() throws Exception {

		File tempFile = File.createTempFile("test", ".pdf");

		tempFile.deleteOnExit();

		ByteArrayInputStream inputStream = new ByteArrayInputStream("test data".getBytes(StandardCharsets.UTF_8));

		ServletOutputStream outputStream = Mockito.mock(ServletOutputStream.class);

		when(uploadService.getDownloadSubmittedForm(1L, 2L, 3L, "PARENT", "2025", "5001")).thenReturn(resource);

		when(resource.getFile()).thenReturn(tempFile);

		when(resource.getInputStream()).thenReturn(inputStream);

		when(resource.getFilename()).thenReturn("test%20file.pdf");

		when(response.getOutputStream()).thenReturn(outputStream);

		ResponseEntity<String> result = fileUploadController.downloadFormDocument(1L, 2L, 3L, "PARENT", "2025", "5001",
				response);

		assertNull(result);

		verify(response).setContentType("application/octet-stream");

		verify(response).setHeader(eq("Content-Disposition"), contains("test file.pdf"));

		verify(response).setContentLength((int) tempFile.length());

		verify(outputStream).close();

		verify(utility).permitFileAndFolder(tempFile);
	}

	// =========================================================
	// downloadFormDocument - Close exception
	// =========================================================

	@Test
	void testDownloadFormDocument_OutputStreamCloseException() throws Exception {

		File tempFile = File.createTempFile("test", ".pdf");

		tempFile.deleteOnExit();

		ByteArrayInputStream inputStream = new ByteArrayInputStream("test data".getBytes(StandardCharsets.UTF_8));

		ServletOutputStream outputStream = Mockito.mock(ServletOutputStream.class);

		when(uploadService.getDownloadSubmittedForm(1L, 2L, 3L, "PARENT", "2025", "5001")).thenReturn(resource);

		when(resource.getFile()).thenReturn(tempFile);

		when(resource.getInputStream()).thenReturn(inputStream);

		when(resource.getFilename()).thenReturn("test.pdf");

		when(response.getOutputStream()).thenReturn(outputStream);

		doThrow(new IOException("Close failed")).when(outputStream).close();

		ResponseEntity<String> result = fileUploadController.downloadFormDocument(1L, 2L, 3L, "PARENT", "2025", "5001",
				response);

		assertNull(result);

		verify(outputStream).close();

		verify(utility, never()).permitFileAndFolder(tempFile);
	}

	// =========================================================
	// downloadFormDocument - Resource not found
	// =========================================================

	@Test
	void testDownloadFormDocument_ResourceNotFound() throws Exception {

		ServletOutputStream outputStream = Mockito.mock(ServletOutputStream.class);

		when(uploadService.getDownloadSubmittedForm(1L, 2L, 3L, "PARENT", "2025", "5001")).thenReturn(null);

		when(response.getOutputStream()).thenReturn(outputStream);

		ResponseEntity<String> result = fileUploadController.downloadFormDocument(1L, 2L, 3L, "PARENT", "2025", "5001",
				response);

		assertNull(result);

		verify(response).setContentType("application/octet-stream");

		verify(response).setHeader(eq("Content-Disposition"), contains("Document_Not_Found.pdf"));

		verify(outputStream).close();
	}

	// =========================================================
	// downloadFormDocument - Resource not found close exception
	// =========================================================

	@Test
    void testDownloadFormDocument_ResourceNotFound_CloseException()
            throws Exception {

        when(uploadService.getDownloadSubmittedForm(
                1L,
                2L,
                3L,
                "PARENT",
                "2025",
                "5001"))
                .thenReturn(null);

        ServletOutputStream outputStream =
                Mockito.mock(ServletOutputStream.class);

        doThrow(new IOException("Close failed"))
                .when(outputStream)
                .close();

        when(response.getOutputStream())
                .thenReturn(outputStream);

        ResponseEntity<String> result =
                fileUploadController.downloadFormDocument(
                        1L,
                        2L,
                        3L,
                        "PARENT",
                        "2025",
                        "5001",
                        response);

        assertNull(result);

        verify(response)
                .setContentType("application/octet-stream");

        verify(response)
                .setHeader(
                        eq("Content-Disposition"),
                        contains("Document_Not_Found.pdf"));

        verify(outputStream).close();
    }

	// =========================================================
	// downloadFormDocument - Outer exception
	// =========================================================

	@Test
    void testDownloadFormDocument_Exception() {

        when(uploadService.getDownloadSubmittedForm(
                1L,
                2L,
                3L,
                "PARENT",
                "2025",
                "5001"))
                .thenThrow(
                        new RuntimeException("DB error"));

        HomeInstructionException thrown =
                assertThrows(
                        HomeInstructionException.class,
                        () -> fileUploadController.downloadFormDocument(
                                1L,
                                2L,
                                3L,
                                "PARENT",
                                "2025",
                                "5001",
                                response));

        assertEquals("DB error", thrown.getMessage());
    }

	// =========================================================
	// getAttachmentList
	// =========================================================

	@Test
	void testGetAttachmentList_Success() {

		GetAttachmentListResp expected = new GetAttachmentListResp();

		when(uploadService.getAttachmentList(1L, 2L, 3L, "PARENT")).thenReturn(expected);

		ResponseEntity<GetAttachmentListResp> result = fileUploadController.getAttachmentList(1L, 2L, 3L, "PARENT");

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(expected, result.getBody());

		verify(messageService).getMessage(Constant.FUC_GAT);

		verify(uploadService).getAttachmentList(1L, 2L, 3L, "PARENT");

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	@Test
	void testGetAttachmentList_Exception() {

		RuntimeException exception = new RuntimeException("Attachment error");

		when(uploadService.getAttachmentList(1L, 2L, 3L, "PARENT")).thenThrow(exception);

		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> fileUploadController.getAttachmentList(1L, 2L, 3L, "PARENT"));

		assertSame(exception, thrown);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	// =========================================================
	// fileDelete
	// =========================================================

	@Test
	void testFileDelete_Success() {

		DeleteDocumentReq request = new DeleteDocumentReq();

		DeleteDocResponse expected = new DeleteDocResponse();

		when(uploadService.deleteFormDocument(request)).thenReturn(expected);

		ResponseEntity<DeleteDocResponse> result = fileUploadController.fileDelete(request);

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(expected, result.getBody());

		verify(messageService).getMessage(Constant.FDE_API);

		verify(uploadService).deleteFormDocument(request);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	@Test
	void testFileDelete_Exception() {

		DeleteDocumentReq request = new DeleteDocumentReq();

		RuntimeException exception = new RuntimeException("Delete failed");

		when(uploadService.deleteFormDocument(request)).thenThrow(exception);

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> fileUploadController.fileDelete(request));

		assertSame(exception, thrown);

		verify(messageService).getMessage(Constant.FDE_API);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	// =========================================================
	// getFormPDFDetail
	// =========================================================

	@Test
	void testGetFormPDFDetail_Success() {

		ResponseEntity<String> result = fileUploadController.getFormPDFDetail(1L, 1L, "PRTHI", null, response);

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNull(result.getBody());

		verify(uploadService).getFormPdfDetails(1L, 1L, "PRTHI", null, response);
	}

	@Test
	void testGetFormPDFDetail_Exception() {

		RuntimeException exception = new RuntimeException("PDF generation failed");

		doThrow(exception).when(uploadService).getFormPdfDetails(1L, 1L, "PRTHI", null, response);

		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> fileUploadController.getFormPDFDetail(1L, 1L, "PRTHI", null, response));

		assertSame(exception, thrown);
	}

	// =========================================================
	// getApplicationTrackingPdfDetails
	// =========================================================

	@Test
	void testGetApplicationTrackingPdfDetails_Success() {

		ApplicationTrackingRequest request = new ApplicationTrackingRequest();

		ResponseEntity<String> result = fileUploadController.getApplicationTrackingPdfDetails(request, response);

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNull(result.getBody());

		verify(uploadService, times(1)).getApplicationTrackingPdfDetails(request, response);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	@Test
	void testGetApplicationTrackingPdfDetails_Exception() {

		ApplicationTrackingRequest request = new ApplicationTrackingRequest();

		RuntimeException exception = new RuntimeException("Service error");

		doThrow(exception).when(uploadService).getApplicationTrackingPdfDetails(request, response);

		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> fileUploadController.getApplicationTrackingPdfDetails(request, response));

		assertSame(exception, thrown);

		verify(uploadService).getApplicationTrackingPdfDetails(request, response);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	// =========================================================
	// getForm30DHIPDFDetails
	// =========================================================

	@Test
	void testGetForm30DHIPDFDetails_Success() {

		DHIRequest request = new DHIRequest(100L, "2026-08-19", "Dr. Smith", "", null);

		ResponseEntity<String> result = fileUploadController.getForm30DHIPDFDetails(request, response);

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNull(result.getBody());

		verify(uploadService).get30DHIPDFDetails(request, response);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	@Test
	void testGetForm30DHIPDFDetails_Exception() {

		DHIRequest request = new DHIRequest(100L, "2026-08-19", "Dr. Smith", "", null);

		RuntimeException exception = new RuntimeException("PDF generation failed");

		doThrow(exception).when(uploadService).get30DHIPDFDetails(request, response);

		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> fileUploadController.getForm30DHIPDFDetails(request, response));

		assertSame(exception, thrown);

		verify(uploadService).get30DHIPDFDetails(request, response);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	// =========================================================
	// getForm760DHIPDFDetails
	// =========================================================

	@Test
	void testGetForm760DHIPDFDetails_Success() {

		DHIRequest request = new DHIRequest(100L, "2026-08-19", "Dr. Smith", "", null);

		ResponseEntity<String> result = fileUploadController.getForm760DHIPDFDetails(request, response);

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNull(result.getBody());

		verify(uploadService).getForm760DHIPDFDetails(request, response);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	@Test
	void testGetForm760DHIPDFDetails_Exception() {

		DHIRequest request = new DHIRequest(100L, "2026-08-19", "Dr. Smith", "", null);

		RuntimeException exception = new RuntimeException("PDF generation failed");

		doThrow(exception).when(uploadService).getForm760DHIPDFDetails(request, response);

		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> fileUploadController.getForm760DHIPDFDetails(request, response));

		assertSame(exception, thrown);

		verify(uploadService).getForm760DHIPDFDetails(request, response);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	// =========================================================
	// getTemplatePDFDetails
	// =========================================================

	@Test
	void testGetTemplatePDFDetails_Success() {

		ResponseEntity<String> result = fileUploadController.getTemplatePDFDetails("LAHIT", response);

		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNull(result.getBody());

		verify(uploadService).getTemplatePDFDetails("LAHIT", response);

		assertTrue(Constant.getMessageMap().isEmpty());
	}

	@Test
	void testGetTemplatePDFDetails_Exception() {

		RuntimeException exception = new RuntimeException("Template PDF generation failed");

		doThrow(exception).when(uploadService).getTemplatePDFDetails("LAHIT", response);

		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> fileUploadController.getTemplatePDFDetails("LAHIT", response));

		assertSame(exception, thrown);

		verify(uploadService).getTemplatePDFDetails("LAHIT", response);

		assertTrue(Constant.getMessageMap().isEmpty());
	}
}
