package com.jcboe.home.instruction.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.repo.AppConfigRepo;
import com.jcboe.home.instruction.repo.ConfigRepo;
import com.jcboe.home.instruction.response.Form10HSAPPDataResp;
import com.jcboe.home.instruction.response.Form1AphirDataResp;
import com.jcboe.home.instruction.response.Form1AphirScheduleResp;
import com.jcboe.home.instruction.response.Form2RHIDTDataResp;
import com.jcboe.home.instruction.response.Form3RhiltDataResp;
import com.jcboe.home.instruction.response.Form4PrthiDataResp;
import com.jcboe.home.instruction.response.Form630DhiDataResp;
import com.jcboe.home.instruction.response.Form760DhiDataResp;
import com.jcboe.home.instruction.response.Form8HiscpDataResp;
import com.jcboe.home.instruction.response.Form9EAPPDataResp;
import com.jcboe.home.instruction.response.Form9EAPPPlanDataResp;
import com.jcboe.home.instruction.response.HomeInstructionConfig;
import com.jcboe.home.instruction.response.IdsKeyValue;
import com.jcboe.home.instruction.response.S3UploadResponse;
import com.jcboe.home.instruction.response.ScreenTextApiResponse;

@ExtendWith(MockitoExtension.class)
class UtilityTest {

	@Mock
	private ConfigRepo configRepo;

	@Mock
	private AppConfigRepo appConfigRepo;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private RestTemplate restTemplateUtility;

	@Mock
	private Zip4jUtility zip4jUtility;

	@Mock
	private HomeInstructionConfig homeInstructionConfig;

	@Mock
	private IdsKeyValue idsKeyValue;

	@TempDir
	Path tempDir;

	private Utility utility;

	private File tempDirectory;

	@BeforeEach
	void setUp() throws Exception {
		utility = new Utility(configRepo, restTemplate, restTemplateUtility, zip4jUtility, appConfigRepo);

		tempDirectory = new File(System.getProperty("java.io.tmpdir"), "utility-test-" + System.nanoTime());

		assertTrue(tempDirectory.mkdirs());

		ReflectionTestUtils.setField(utility, "tempDir", tempDirectory.getAbsolutePath());

		ReflectionTestUtils.setField(utility, "commonUrl", "http://localhost");

		ReflectionTestUtils.setField(utility, "username", "testuser");

		ReflectionTestUtils.setField(utility, "password", "testpassword");
	}

	// -------------------------------------------------------------------------
	// stringToXmlFormat
	// -------------------------------------------------------------------------

	@Test
	void testStringToXmlFormat() throws Exception {

		Map<String, String> data = new LinkedHashMap<>();
		data.put("name", "John");

		String result = utility.stringToXmlFormat(data);

		assertNotNull(result);
		assertTrue(result.contains("John"));
	}

	// -------------------------------------------------------------------------
	// printJson
	// -------------------------------------------------------------------------

	@Test
	void testPrintJson() {

		Map<String, String> data = new LinkedHashMap<>();
		data.put("name", "John");

		String result = utility.printJson(data);

		assertNotNull(result);
		assertTrue(result.contains("\"name\""));
		assertTrue(result.contains("\"John\""));
	}

	// -------------------------------------------------------------------------
	// getConfigList
	// -------------------------------------------------------------------------

	@Test
    void testGetConfigListSuccess() throws Exception {

        when(homeInstructionConfig.getConfigKey()).thenReturn("KEY1");
        when(homeInstructionConfig.getConfigValue()).thenReturn("VALUE1");

        when(configRepo.getMgmtConfigValuesByKey("KEY1"))
                .thenReturn(Collections.singletonList(homeInstructionConfig));

        Map<String, String> result = utility.getConfigList("KEY1");

        assertNotNull(result);
        assertEquals("VALUE1", result.get("KEY1"));
    }

	@Test
    void testGetConfigListException() throws Exception {

        when(configRepo.getMgmtConfigValuesByKey(anyString()))
                .thenThrow(new RuntimeException("DB error"));

        Map<String, String> result = utility.getConfigList("KEY1");

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

	// -------------------------------------------------------------------------
	// responseDate
	// -------------------------------------------------------------------------

	@Test
	void testResponseDate() {

		LocalDateTime dateTime = LocalDateTime.of(2026, 7, 30, 14, 30);

		String result = utility.responseDate(dateTime);

		assertEquals("07/30/2026 02:30 PM", result);
	}

	// -------------------------------------------------------------------------
	// responseDateTime
	// -------------------------------------------------------------------------

	@Test
	void testResponseDateTime() {

		LocalDateTime dateTime = LocalDateTime.of(2026, 7, 30, 14, 30);

		String result = utility.responseDateTime(dateTime, "MM-dd-yyyy hh:mm a");

		assertEquals("07-30-2026 02:30 PM", result);
	}

	// -------------------------------------------------------------------------
	// getFinancialYears
	// -------------------------------------------------------------------------

	@Test
	void testGetFinancialYears() {

		List<String> result = utility.getFinancialYears("26-27");

		assertEquals(2, result.size());
		assertEquals("2026-2027", result.get(0));
		assertEquals("2025-2026", result.get(1));
	}

	// -------------------------------------------------------------------------
	// getEmailBody
	// -------------------------------------------------------------------------

	@Test
	void testGetEmailBodySuccess() throws Exception {

		File template = new File(tempDirectory, "email-template.html");

		java.nio.file.Files.write(template.toPath(), "Hello {NAME}".getBytes(StandardCharsets.UTF_8));

		Map<String, String> replacers = new HashMapBuilder().put("{NAME}", "John").build();

		String result = utility.getEmailBody(replacers, template.getAbsolutePath());

		assertEquals("Hello John", result);
	}

	@Test
	void testGetEmailBodyFileNotFound() {

		Map<String, String> replacers = new LinkedHashMap<>();

		Exception exception = assertThrows(Exception.class,
				() -> utility.getEmailBody(replacers, new File(tempDirectory, "missing.html").getAbsolutePath()));

		assertTrue(exception.getMessage().contains("Template File not found"));
	}

	// -------------------------------------------------------------------------
	// configureMailProperties
	// -------------------------------------------------------------------------

	@Test
	void testConfigureMailPropertiesWithoutAuth() {

		JavaMailSenderImpl result = utility.configureMailProperties("smtp.test.com", 25, "test@test.com", null, false);

		assertNotNull(result);
		assertEquals("smtp.test.com", result.getHost());
		assertEquals(25, result.getPort());
		assertEquals("test@test.com", result.getUsername());

		assertEquals("false", result.getJavaMailProperties().getProperty("mail.smtp.auth"));

		assertEquals("false", result.getJavaMailProperties().getProperty("mail.smtp.starttls.enable"));
	}

	@Test
	void testConfigureMailPropertiesWithAuth() {

		JavaMailSenderImpl result = utility.configureMailProperties("smtp.test.com", 587, "test@test.com", "password",
				true);

		assertNotNull(result);
		assertEquals("smtp.test.com", result.getHost());
		assertEquals(587, result.getPort());
		assertEquals("test@test.com", result.getUsername());
		assertEquals("password", result.getPassword());

		assertEquals("true", result.getJavaMailProperties().getProperty("mail.smtp.auth"));

		assertEquals("true", result.getJavaMailProperties().getProperty("mail.smtp.starttls.enable"));
	}

	// -------------------------------------------------------------------------
	// replaceSubjectParent
	// -------------------------------------------------------------------------

	@Test
	void testReplaceSubjectParent() {

		String result = utility.replaceSubjectParent("Student {STUDENT_ID} DOB {STUDENT_DOB}", "12345", "01/01/2010");

		assertEquals("Student 12345 DOB 01/01/2010", result);
	}

	@Test
	void testReplaceSubjectParentWithNullValues() {

		String result = utility.replaceSubjectParent("{STUDENT_ID}-{STUDENT_DOB}", null, null);

		assertEquals("-", result);
	}

	// -------------------------------------------------------------------------
	// replaceSubjectUser
	// -------------------------------------------------------------------------

	@Test
	void testReplaceSubjectUser() {

		String result = utility.replaceSubjectUser("Employee {EMP_ID} {FIRST_NAME} {EMAIL_ID}", "100", "John",
				"john@test.com");

		assertEquals("Employee 100 John john@test.com", result);
	}

	// -------------------------------------------------------------------------
	// getDocEncPass
	// -------------------------------------------------------------------------

	@Test
	void testGetDocEncPass() throws Exception {

		String result = utility.getDocEncPass("12345");

		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	// -------------------------------------------------------------------------
	// getScreenTexts
	// -------------------------------------------------------------------------

	@Test
    void testGetScreenTextsWithData() throws Exception {

        when(idsKeyValue.getKey()).thenReturn("KEY1");
        when(idsKeyValue.getValue()).thenReturn("VALUE1");

        when(appConfigRepo.getScreenTextDetails(
                anyInt(),
                eq(1)))
                .thenReturn(Collections.singletonList(idsKeyValue));

        List<ScreenTextApiResponse> result =
                utility.getScreenTexts();

        assertNotNull(result);
        assertEquals(14, result.size());
    }

	@Test
    void testGetScreenTextsEmpty() throws Exception {

        when(appConfigRepo.getScreenTextDetails(
                anyInt(),
                eq(1)))
                .thenReturn(Collections.emptyList());

        List<ScreenTextApiResponse> result =
                utility.getScreenTexts();

        assertNotNull(result);
        assertEquals(14, result.size());
    }

	@Test
    void testGetScreenTextsNull() throws Exception {

        when(appConfigRepo.getScreenTextDetails(
                anyInt(),
                eq(1)))
                .thenReturn(null);

        List<ScreenTextApiResponse> result =
                utility.getScreenTexts();

        assertNotNull(result);
        assertEquals(14, result.size());
    }

	@Test
    void testGetScreenTextsException() throws Exception {

        when(appConfigRepo.getScreenTextDetails(
                anyInt(),
                eq(1)))
                .thenThrow(new RuntimeException("DB error"));

        List<ScreenTextApiResponse> result =
                utility.getScreenTexts();

        assertNotNull(result);
        assertEquals(14, result.size());
    }

	// -------------------------------------------------------------------------
	// getScreenTextBody
	// -------------------------------------------------------------------------

	@Test
	void testGetScreenTextBody() throws Exception {

		ScreenTextApiResponse response = new ScreenTextApiResponse();

		Map<String, String> map = new LinkedHashMap<>();
		map.put("TITLE", "Home Instruction");

		response.setScreenTexts(map);

		String result = utility.getScreenTextBody(Collections.singletonList(response), "Welcome {screenTexts.TITLE}");

		assertEquals("Welcome Home Instruction", result);
	}

	@Test
	void testGetScreenTextBodyWithNullMap() throws Exception {

		ScreenTextApiResponse response = new ScreenTextApiResponse();

		response.setScreenTexts(null);

		String result = utility.getScreenTextBody(Collections.singletonList(response), "Hello");

		assertEquals("Hello", result);
	}

	// -------------------------------------------------------------------------
	// createDirIfNotExists
	// -------------------------------------------------------------------------

	@Test
	void testCreateDirIfNotExists() {

		File directory = new File(tempDirectory, "new-directory");

		assertFalse(directory.exists());

		utility.createDirIfNotExists(directory);

		assertTrue(directory.exists());
		assertTrue(directory.isDirectory());
	}

	@Test
	void testCreateDirIfNotExistsAlreadyExists() {

		File directory = new File(tempDirectory, "existing-directory");

		assertTrue(directory.mkdirs());

		utility.createDirIfNotExists(directory);

		assertTrue(directory.exists());
	}

	// -------------------------------------------------------------------------
	// permitFileOrFolder
	// -------------------------------------------------------------------------

	@Test
	void testPermitFileOrFolderExists() throws Exception {

		File file = new File(tempDirectory, "permission.txt");

		assertTrue(file.createNewFile());

		utility.permitFileOrFolder(file);

		assertTrue(file.exists());
	}

	@Test
	void testPermitFileOrFolderDoesNotExist() {

		File file = new File(tempDirectory, "missing.txt");

		utility.permitFileOrFolder(file);

		assertFalse(file.exists());
	}

	// -------------------------------------------------------------------------
	// permitFileAndFolder
	// -------------------------------------------------------------------------

	@Test
	void testPermitFileAndFolderExists() throws Exception {

		File file = new File(tempDirectory, "permission2.txt");

		assertTrue(file.createNewFile());

		utility.permitFileAndFolder(file);

		assertTrue(file.exists());
	}

	@Test
	void testPermitFileAndFolderDoesNotExist() {

		File file = new File(tempDirectory, "missing2.txt");

		utility.permitFileAndFolder(file);

		assertFalse(file.exists());
	}

	// -------------------------------------------------------------------------
	// getBase64EncDoc(MultipartFile)
	// -------------------------------------------------------------------------

	@Test
	void testGetBase64EncDocMultipartFile() {

		MultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain",
				"Hello".getBytes(StandardCharsets.UTF_8));

		String result = utility.getBase64EncDoc(file);

		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	void testGetBase64EncDocMultipartFileException() throws Exception {

		MultipartFile file = mock(MultipartFile.class);

		when(file.getBytes()).thenThrow(new RuntimeException("read error"));

		String result = utility.getBase64EncDoc(file);

		assertEquals("", result);
	}

	// -------------------------------------------------------------------------
	// getBase64EncDoc(File)
	// -------------------------------------------------------------------------

	@Test
	void testGetBase64EncDocFile() throws Exception {

		File file = new File(tempDirectory, "base64.txt");

		java.nio.file.Files.write(file.toPath(), "Hello".getBytes(StandardCharsets.UTF_8));

		String result = utility.getBase64EncDoc(file);

		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	// -------------------------------------------------------------------------
	// replaceString
	// -------------------------------------------------------------------------

	@Test
	void testReplaceString() {

		Map<String, String> replacers = new LinkedHashMap<>();

		replacers.put("{NAME}", "John");
		replacers.put("{CITY}", "New York");

		String result = utility.replaceString(replacers, "Hello {NAME} from {CITY}");

		assertEquals("Hello John from New York", result);
	}

	// -------------------------------------------------------------------------
	// changeDateFormatPattern
	// -------------------------------------------------------------------------

	@Test
	void testChangeDateFormatPattern() {

		String result = utility.changeDateFormatPattern("07/30/2026", "MM/dd/yyyy", "yyyy-MM-dd");

		assertEquals("2026-07-30", result);
	}

	@Test
	void testChangeDateFormatPatternInvalidDate() {

		String result = utility.changeDateFormatPattern("invalid", "MM/dd/yyyy", "yyyy-MM-dd");

		assertEquals("invalid", result);
	}

	// -------------------------------------------------------------------------
	// formatPhNumber
	// -------------------------------------------------------------------------

	@Test
	void testFormatPhNumberNull() {

		assertNull(utility.formatPhNumber(null));
	}

	@Test
	void testFormatPhNumberEmpty() {

		assertEquals("", utility.formatPhNumber(""));
	}

	@Test
	void testFormatPhNumberSpaces() {

		assertEquals("   ", utility.formatPhNumber("   "));
	}

	@Test
	void testFormatPhNumberTenDigits() {

		String result = utility.formatPhNumber("1234567890");

		assertEquals("123-456-7890", result);
	}

	@Test
	void testFormatPhNumberAlreadyHasDashes() {

		String result = utility.formatPhNumber("123-456-7890");

		assertEquals("123-456-7890", result);
	}

	@Test
	void testFormatPhNumberShortNumber() {

		String result = utility.formatPhNumber("12345");

		assertEquals("123-45", result);
	}

	// -------------------------------------------------------------------------
	// encodeURIComponent
	// -------------------------------------------------------------------------

	@Test
	void testEncodeURIComponent() {

		String result = Utility.encodeURIComponent("hello world!");

		assertEquals("hello%20world!", result);
	}

	@Test
	void testEncodeURIComponentNull() {

		String result = Utility.encodeURIComponent(null);

		assertNull(result);
	}

	// -------------------------------------------------------------------------
	// convertFileToMultipartFile
	// -------------------------------------------------------------------------

	@Test
	void testConvertFileToMultipartFile() throws Exception {

		File file = new File(tempDirectory, "multipart.txt");

		java.nio.file.Files.write(file.toPath(), "Hello".getBytes(StandardCharsets.UTF_8));

		MultipartFile result = utility.convertFileToMultipartFile(file);

		assertNotNull(result);
		assertEquals("multipart.txt", result.getOriginalFilename());

		assertEquals("Hello", new String(result.getBytes(), StandardCharsets.UTF_8));
	}

	// -------------------------------------------------------------------------
	// decodeAndSaveFile
	// -------------------------------------------------------------------------

	@Test
	void testDecodeAndSaveFile() throws Exception {

		File encodedFile = new File(tempDirectory, "encoded.txt");

		String encoded = java.util.Base64.getEncoder().encodeToString("Hello".getBytes(StandardCharsets.UTF_8));

		java.nio.file.Files.write(encodedFile.toPath(), encoded.getBytes(StandardCharsets.UTF_8));

		File result = utility.decodeAndSaveFile(encodedFile, tempDirectory.getAbsolutePath(), "decoded");

		assertNotNull(result);
		assertTrue(result.exists());
		assertEquals("Hello", new String(java.nio.file.Files.readAllBytes(result.toPath()), StandardCharsets.UTF_8));
	}

	@Test
	void testDecodeAndSaveFile_Exception() throws Exception {

		File tempDir = Files.createTempDirectory("decode-error").toFile();

		File encodedFile = new File(tempDir, "missing-file.txt");

		File result = utility.decodeAndSaveFile(encodedFile, tempDir.getAbsolutePath(), "testFile");

		assertNull(result);

		FileUtils.deleteDirectory(tempDir);
	}

	// -------------------------------------------------------------------------
	// decompressGZIP
	// -------------------------------------------------------------------------

	@Test
	void testDecompressGZIP() throws Exception {

		File input = new File(tempDirectory, "test.gz");

		File output = new File(tempDirectory, "output.txt");

		java.util.zip.GZIPOutputStream gzip = new java.util.zip.GZIPOutputStream(new FileOutputStream(input));

		gzip.write("Hello GZIP".getBytes(StandardCharsets.UTF_8));
		gzip.close();

		File result = utility.decompressGZIP(input, output);

		assertNotNull(result);
		assertTrue(result.exists());

		String content = new String(java.nio.file.Files.readAllBytes(output.toPath()), StandardCharsets.UTF_8);

		assertEquals("Hello GZIP", content);
	}

	@Test
	void testDecompressGZIPException() {

		File input = new File(tempDirectory, "missing.gz");

		File output = new File(tempDirectory, "output.txt");

		assertThrows(Exception.class, () -> utility.decompressGZIP(input, output));
	}

	// -------------------------------------------------------------------------
	// getUnzippedFile
	// -------------------------------------------------------------------------

	@Test
	void testGetUnzippedFile() throws Exception {

		File decoded = new File(tempDirectory, "decoded.zip");

		File expected = new File(tempDirectory, "expected.txt");

		when(zip4jUtility.decompressWithPassword(decoded, "original.txt", "attach.txt", "txt", "password",
				tempDirectory.getAbsolutePath())).thenReturn(expected);

		File result = utility.getUnzippedFile(decoded, "original.txt", "attach.txt", "txt", "password",
				tempDirectory.getAbsolutePath());

		assertEquals(expected, result);

		verify(zip4jUtility).decompressWithPassword(decoded, "original.txt", "attach.txt", "txt", "password",
				tempDirectory.getAbsolutePath());
	}

	// -------------------------------------------------------------------------
	// getProtectedZipFile
	// -------------------------------------------------------------------------

	@Test
	void testGetProtectedZipFile() throws Exception {

		MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain",
				"Hello".getBytes(StandardCharsets.UTF_8));

		File zipFile = new File(tempDirectory, "encrypted.zip");

		when(zip4jUtility.compressWithPassword(any(File.class), eq("password"), eq(tempDirectory.getAbsolutePath())))
				.thenReturn(zipFile);

		File result = utility.getProtectedZipFile(multipartFile, "password", "123-456",
				tempDirectory.getAbsolutePath());

		assertEquals(zipFile, result);

		verify(zip4jUtility).compressWithPassword(any(File.class), eq("password"), eq(tempDirectory.getAbsolutePath()));
	}

	// -------------------------------------------------------------------------
	// getScreenTexts special - -1 / -2
	// -------------------------------------------------------------------------

	@Test
    void testGetScreenTextsWithMinusOne() throws Exception {

        when(idsKeyValue.getKey()).thenReturn("-1");
        when(idsKeyValue.getValue()).thenReturn("Error");

        when(appConfigRepo.getScreenTextDetails(
                anyInt(),
                eq(1)))
                .thenReturn(Collections.singletonList(idsKeyValue));

        List<ScreenTextApiResponse> result =
                utility.getScreenTexts();

        assertEquals(14, result.size());
    }

	@Test
    void testGetScreenTextsWithMinusTwo() throws Exception {

        when(idsKeyValue.getKey()).thenReturn("-2");
        when(idsKeyValue.getValue()).thenReturn("Error");

        when(appConfigRepo.getScreenTextDetails(
                anyInt(),
                eq(1)))
                .thenReturn(Collections.singletonList(idsKeyValue));

        List<ScreenTextApiResponse> result =
                utility.getScreenTexts();

        assertEquals(14, result.size());
    }

	// -------------------------------------------------------------------------
	// bindTheHttpServletResponse
	// -------------------------------------------------------------------------

	@Test
	void testBindTheHttpServletResponseWithResource() throws Exception {

		File file = new File(tempDirectory, "document.pdf");

		java.nio.file.Files.write(file.toPath(), "PDF DATA".getBytes(StandardCharsets.UTF_8));

		org.springframework.core.io.FileSystemResource resource = new org.springframework.core.io.FileSystemResource(
				file);

		MockHttpServletResponse response = new MockHttpServletResponse();

		utility.bindTheHttpServletResponse(resource, response);

		assertEquals("application/pdf", response.getContentType());

		assertTrue(response.getHeader("Content-Disposition").contains("document.pdf"));
	}

	@Test
	void testBindTheHttpServletResponseWithNullResource() throws Exception {

		MockHttpServletResponse response = new MockHttpServletResponse();

		utility.bindTheHttpServletResponse(null, response);

		assertEquals("application/pdf", response.getContentType());

		assertTrue(response.getHeader("Content-Disposition").contains("Document_Not_Found.pdf"));
	}

	@Test
	void testBindTheHttpServletResponse_ResourceNotNull_Exception() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Resource resource = mock(Resource.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(resource.getFilename()).thenReturn("test.pdf");

		when(resource.getFile()).thenThrow(new IOException("File error"));

		spyService.bindTheHttpServletResponse(resource, response);

		verify(response).setContentType("application/pdf");

		verify(response).setHeader(eq("Content-Disposition"), eq("inline; filename=\"test.pdf\""));
	}

	@Test
	void testBindTheHttpServletResponse_ResourceNull_Exception() throws Exception {

		Utility spyService = Mockito.spy(utility);

		HttpServletResponse response = mock(HttpServletResponse.class);

		when(response.getOutputStream()).thenThrow(new IOException("Output stream error"));

		spyService.bindTheHttpServletResponse(null, response);

		verify(response).setContentType("application/pdf");

		verify(response).setHeader(eq("Content-Disposition"), eq("inline; fileName=\"Document_Not_Found.pdf\""));

		verify(response).getOutputStream();
	}

	// -------------------------------------------------------------------------
	// generatePDF
	// -------------------------------------------------------------------------

	@Test
	void testGeneratePDFInvalidInput() {

		String result = utility.generatePDF(new File(tempDirectory, "missing.html").getAbsolutePath(),
				new File(tempDirectory, "output.pdf").getAbsolutePath());

		assertNull(result);
	}

	// -------------------------------------------------------------------------
	// createPdf
	// -------------------------------------------------------------------------

	@Test
	void testCreatePdfInvalidTemplate() {

		Map<String, String> replacers = new LinkedHashMap<>();

		String result = utility.createPdf(new File(tempDirectory, "missing.html").getAbsolutePath(), replacers,
				new File(tempDirectory, "output.pdf").getAbsolutePath());

		assertNull(result);
	}

	// -------------------------------------------------------------------------
	// uploadBase64FileToS3
	// -------------------------------------------------------------------------

	@Test
	void testUploadBase64FileToS3_Success() throws Exception {

		MultipartFile multipartFile = new MockMultipartFile("file", "test.pdf", "application/pdf",
				"dummy pdf content".getBytes(StandardCharsets.UTF_8));

		String accessKey = "ACCESS_KEY";
		String secretKey = "SECRET_KEY";
		String bucketName = "TEST_BUCKET";
		String subFolder = "TEST_FOLDER";
		String region = "us-east-1";
		String attachFileName = "test.pdf";
		boolean isCompressed = false;
		String fileEncDecPass = "password";
		String guid = "1234-5678-9012";
		String tempFilePath = tempDir.toString();

		File encryptedFile = new File(tempDir.toFile(), "encrypted.zip");
		FileUtils.writeStringToFile(encryptedFile, "dummy encrypted content", StandardCharsets.UTF_8);

		S3UploadResponse uploadResponse = new S3UploadResponse();
		uploadResponse.setSuccess(true);

		when(zip4jUtility.compressWithPassword(any(File.class), eq(fileEncDecPass), eq(tempFilePath)))
				.thenReturn(encryptedFile);

		when(restTemplateUtility.postForEntity(anyString(), any(HttpEntity.class), eq(S3UploadResponse.class)))
				.thenReturn(new ResponseEntity<>(uploadResponse, HttpStatus.OK));

		Utility spyService = Mockito.spy(utility);

		doNothing().when(spyService).permitFileAndFolder(any(File.class));

		S3UploadResponse response = spyService.uploadBase64FileToS3(multipartFile, accessKey, secretKey, bucketName,
				subFolder, region, attachFileName, isCompressed, fileEncDecPass, guid, tempFilePath);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(zip4jUtility).compressWithPassword(any(File.class), eq(fileEncDecPass), eq(tempFilePath));

		verify(restTemplateUtility).postForEntity(anyString(), any(HttpEntity.class), eq(S3UploadResponse.class));

		verify(multipartFile).transferTo(any(File.class));
	}

	@Test
	void testUploadBase64FileToS3Exception() throws Exception {

		MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain",
				"Hello".getBytes(StandardCharsets.UTF_8));

		when(zip4jUtility.compressWithPassword(any(File.class), anyString(), anyString()))
				.thenThrow(new RuntimeException("compression failed"));

		assertThrows(Exception.class, () -> utility.uploadBase64FileToS3(multipartFile, "access", "secret", "bucket",
				"folder", "region", "attachment", true, "password", "123-456", tempDirectory.getAbsolutePath()));
	}

	// -------------------------------------------------------------------------
	// downloadFromS3AsStream
	// -------------------------------------------------------------------------

	@Test
	void testDownloadFromS3AsStream_Success() throws Exception {

		Utility spyService = Mockito.spy(utility);

		File tempDir = Files.createTempDirectory("s3-download-test").toFile();

		String guidFile = "abc123";
		String attachFileName = "test.pdf";

		byte[] fileContent = "dummy zip content".getBytes(StandardCharsets.UTF_8);

		HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);

		server.createContext("/S3FileDownload", exchange -> {

			exchange.sendResponseHeaders(200, fileContent.length);

			try (OutputStream os = exchange.getResponseBody()) {
				os.write(fileContent);
			}
		});

		server.start();

		try {

			int port = server.getAddress().getPort();

			ReflectionTestUtils.setField(spyService, "commonUrl", "http://localhost:" + port);

			ReflectionTestUtils.setField(spyService, "username", "testUser");

			ReflectionTestUtils.setField(spyService, "password", "testPassword");

			File unzippedFile = new File(tempDir, "unzipped.pdf");

			doNothing().when(spyService).permitFileAndFolder(any(File.class));

			when(zip4jUtility.decompressWithPassword(any(File.class), eq("original.pdf"), eq("test.pdf"), eq("pdf"),
					eq("password"), eq(tempDir.getAbsolutePath()))).thenReturn(unzippedFile);

			File result = spyService.downloadFromS3AsStream("accessKey", "secretKey", "bucketName", "folder",
					"us-east-1", guidFile, attachFileName, false, "original.pdf", "pdf", "password",
					tempDir.getAbsolutePath());

			assertNotNull(result);
			assertEquals(unzippedFile, result);

			verify(zip4jUtility).decompressWithPassword(any(File.class), eq("original.pdf"), eq("test.pdf"), eq("pdf"),
					eq("password"), eq(tempDir.getAbsolutePath()));

			verify(spyService).permitFileAndFolder(any(File.class));

		} finally {
			server.stop(0);
			FileUtils.deleteDirectory(tempDir);
		}
	}

	@Test
	void testDownloadFromS3AsStreamException() {

		ReflectionTestUtils.setField(utility, "commonUrl", "http://[invalid-url");

		File result = utility.downloadFromS3AsStream("access", "secret", "bucket", "folder", "region", "guid",
				"attachment.pdf", true, "original.pdf", "pdf", "password", tempDirectory.getAbsolutePath());

		assertNull(result);
	}

	// -------------------------------------------------------------------------
	// deleteS3File - exception branch
	// -------------------------------------------------------------------------

	@Test
	void testDeleteS3File() throws Exception {

		doNothing().when(restTemplateUtility).delete(any(java.net.URI.class));

		utility.deleteS3File("access", "secret", "region", "bucket", "folder", "file.pdf");

		verify(restTemplateUtility).delete(any(java.net.URI.class));
	}

	// -------------------------------------------------------------------------
	// getProtectedZipFile - compression exception
	// -------------------------------------------------------------------------

	@Test
	void testGetProtectedZipFileException() throws Exception {

		MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain",
				"Hello".getBytes(StandardCharsets.UTF_8));

		when(zip4jUtility.compressWithPassword(any(File.class), anyString(), anyString()))
				.thenThrow(new RuntimeException("zip error"));

		assertThrows(Exception.class,
				() -> utility.getProtectedZipFile(multipartFile, "password", "guid", tempDirectory.getAbsolutePath()));
	}

	// -------------------------------------------------------------------------
	// getFinancialYears additional
	// -------------------------------------------------------------------------

	@Test
	void testGetFinancialYearsAnotherYear() {

		List<String> result = utility.getFinancialYears("25-26");

		assertEquals(Arrays.asList("2025-2026", "2024-2025"), result);
	}

	// -------------------------------------------------------------------------
	// getEmailBody replacement
	// -------------------------------------------------------------------------

	@Test
	void testGetEmailBodyMultipleReplacements() throws Exception {

		File template = new File(tempDirectory, "template.html");

		java.nio.file.Files.write(template.toPath(),
				"Hello {NAME}, welcome to {SCHOOL}".getBytes(StandardCharsets.UTF_8));

		Map<String, String> replacers = new LinkedHashMap<>();

		replacers.put("{NAME}", "John");
		replacers.put("{SCHOOL}", "JCBOE");

		String result = utility.getEmailBody(replacers, template.getAbsolutePath());

		assertEquals("Hello John, welcome to JCBOE", result);
	}

	// -------------------------------------------------------------------------
	// replaceString with no replacement
	// -------------------------------------------------------------------------

	@Test
	void testReplaceStringNoMatchingValue() {

		Map<String, String> replacers = new LinkedHashMap<>();

		replacers.put("{NAME}", "John");

		String result = utility.replaceString(replacers, "Hello World");

		assertEquals("Hello World", result);
	}

	// -------------------------------------------------------------------------
	// Utility constructor
	// -------------------------------------------------------------------------

	@Test
	void testDefaultConstructor() {

		Utility result = new Utility();

		assertNotNull(result);
	}

	// -------------------------------------------------------------------------
	// Helper class for Java 8
	// -------------------------------------------------------------------------

	private static class HashMapBuilder {

		private final Map<String, String> map = new LinkedHashMap<>();

		HashMapBuilder put(String key, String value) {
			map.put(key, value);
			return this;
		}

		Map<String, String> build() {
			return map;
		}
	}

	@Test
	void testGetHSAPPdfFileDetails_AdditionalTimeNeededTrue() throws Exception {

		Form10HSAPPDataResp data = new Form10HSAPPDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);
		data.setStudentSchool("Test School");
		data.setSubject("Math");
		data.setGradeInProgress("5");
		data.setTeacherName("Teacher One");
		data.setTeacherEmail("teacher@test.com");

		data.setUnityOfStudy("Algebra");
		data.setAssignments("Assignment 1");
		data.setIndependentWork("Independent Work");
		data.setAssessments("Test");
		data.setStandardsCovered("Standard 1");
		data.setOtherResources("Resource 1");

		data.setTeacherSignature("Teacher Signature");
		data.setTeacherSignDate("08/13/2026");

		data.setIsAdditionalTimeNeeded(true);

		File templateFile = new File(tempDir.toFile(), "HSAPP.html");

		String template = "<html>" + "{student_name}" + "{student_id}" + "{school_name}" + "{subject}"
				+ "{grade_in_progress}" + "{teacher_name}" + "{teacher_email}" + "{unit_of_study}" + "{assignments}"
				+ "{independent_work}" + "{assessments}" + "{standards_covered}" + "{other_resources}"
				+ "{teacher_signature}" + "{teacher_sign_date}" + "{IS_ADDITIONAL_TIME_NEEDED_CHECKED_START}"
				+ "{IS_ADDITIONAL_TIME_NEEDED_CHECKED_END}" + "{IS_ADDITIONAL_TIME_NEEDED_NOTCHECKED_START}"
				+ "{IS_ADDITIONAL_TIME_NEEDED_NOTCHECKED_END}" + "</html>";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getHSAPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);
		assertNotNull(mainHtmlRet);

		assertTrue(mainHtmlRet.toString().contains("John Doe"));
		assertTrue(mainHtmlRet.toString().contains("123"));
		assertTrue(mainHtmlRet.toString().contains("Test School"));
		assertTrue(mainHtmlRet.toString().contains("Math"));

		// TRUE branch
		assertFalse(mainHtmlRet.toString().contains("{IS_ADDITIONAL_TIME_NEEDED_CHECKED_START}"));

		assertFalse(mainHtmlRet.toString().contains("{IS_ADDITIONAL_TIME_NEEDED_CHECKED_END}"));

		assertFalse(mainHtmlRet.toString().contains("{IS_ADDITIONAL_TIME_NEEDED_NOTCHECKED_START}"));

		assertFalse(mainHtmlRet.toString().contains("{IS_ADDITIONAL_TIME_NEEDED_NOTCHECKED_END}"));
	}

	@Test
	void testGetHSAPPdfFileDetails_AdditionalTimeNeededFalse() throws Exception {

		Form10HSAPPDataResp data = new Form10HSAPPDataResp();

		data.setStudentName("Jane Doe");
		data.setStudentId(456L);
		data.setStudentSchool("Test School");
		data.setSubject("Science");
		data.setGradeInProgress("6");
		data.setTeacherName("Teacher Two");
		data.setTeacherEmail("teacher2@test.com");

		data.setUnityOfStudy("Biology");
		data.setAssignments("Assignment 2");
		data.setIndependentWork("Independent Work 2");
		data.setAssessments("Assessment 2");
		data.setStandardsCovered("Standard 2");
		data.setOtherResources("Resource 2");

		data.setTeacherSignature("Signature");
		data.setTeacherSignDate("08/13/2026");

		data.setIsAdditionalTimeNeeded(false);

		File templateFile = new File(tempDir.toFile(), "HSAPP.html");

		String template = "<html>" + "{student_name}" + "{student_id}" + "{school_name}" + "{subject}"
				+ "{grade_in_progress}" + "{teacher_name}" + "{teacher_email}" + "{unit_of_study}" + "{assignments}"
				+ "{independent_work}" + "{assessments}" + "{standards_covered}" + "{other_resources}"
				+ "{teacher_signature}" + "{teacher_sign_date}" + "{IS_ADDITIONAL_TIME_NEEDED_CHECKED_START}"
				+ "{IS_ADDITIONAL_TIME_NEEDED_CHECKED_END}" + "{IS_ADDITIONAL_TIME_NEEDED_NOTCHECKED_START}"
				+ "{IS_ADDITIONAL_TIME_NEEDED_NOTCHECKED_END}" + "</html>";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getHSAPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		assertTrue(mainHtmlRet.toString().contains("Jane Doe"));
		assertTrue(mainHtmlRet.toString().contains("456"));
		assertTrue(mainHtmlRet.toString().contains("Test School"));
		assertTrue(mainHtmlRet.toString().contains("Science"));

		// FALSE / ELSE branch
		assertTrue(mainHtmlRet.toString().contains("<!--"));

		assertTrue(mainHtmlRet.toString().contains("-->"));

		assertFalse(mainHtmlRet.toString().contains("{IS_ADDITIONAL_TIME_NEEDED_CHECKED_START}"));

		assertFalse(mainHtmlRet.toString().contains("{IS_ADDITIONAL_TIME_NEEDED_CHECKED_END}"));

		assertFalse(mainHtmlRet.toString().contains("{IS_ADDITIONAL_TIME_NEEDED_NOTCHECKED_START}"));

		assertFalse(mainHtmlRet.toString().contains("{IS_ADDITIONAL_TIME_NEEDED_NOTCHECKED_END}"));
	}

	@Test
	void testGetHSAPPdfFileDetails_Exception() throws Exception {

		Form10HSAPPDataResp data = new Form10HSAPPDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);

		StringBuilder mainHtmlRet = new StringBuilder();

		String invalidTemplatePath = tempDir.resolve("does-not-exist.html").toString();

		assertThrows(HomeInstructionException.class,
				() -> utility.getHSAPPdfFileDetails(data, mainHtmlRet, invalidTemplatePath));

		assertEquals("", mainHtmlRet.toString());
	}

	@Test
	void testTableBodyReplace_NullHtml() throws Exception {

		List<Form9EAPPPlanDataResp> planDataList = new ArrayList<>();

		String result = utility.tableBodyReplace(null, planDataList);

		assertNull(result);
	}

	@Test
	void testTableBodyReplace_NullPlanDataList() throws Exception {

		String mainHtml = "<html>" + "{ROW_START}" + "<tr><td>{plan_type}</td><td>{plan_1}</td><td>{plan_2}</td></tr>"
				+ "{ROW_END}" + "</html>";

		String result = utility.tableBodyReplace(mainHtml, null);

		assertNotNull(result);

		assertFalse(result.contains("{ROW_START}"));
		assertFalse(result.contains("{ROW_END}"));

		assertFalse(result.contains("{plan_type}"));
	}

	@Test
	void testTableBodyReplace_EmptyPlanDataList() throws Exception {

		String mainHtml = "<html>" + "{ROW_START}" + "<tr><td>{plan_type}</td><td>{plan_1}</td><td>{plan_2}</td></tr>"
				+ "{ROW_END}" + "</html>";

		List<Form9EAPPPlanDataResp> planDataList = Collections.emptyList();

		String result = utility.tableBodyReplace(mainHtml, planDataList);

		assertNotNull(result);

		assertFalse(result.contains("{ROW_START}"));
		assertFalse(result.contains("{ROW_END}"));

		assertFalse(result.contains("{plan_type}"));
		assertFalse(result.contains("{plan_1}"));
		assertFalse(result.contains("{plan_2}"));
	}

	@Test
	void testTableBodyReplace_Success() throws Exception {

		String mainHtml = "<html>" + "{ROW_START}" + "<tr>" + "<td>{plan_type}</td>" + "<td>{plan_1}</td>"
				+ "<td>{plan_2}</td>" + "</tr>" + "{ROW_END}" + "</html>";

		Form9EAPPPlanDataResp planData1 = new Form9EAPPPlanDataResp();

		planData1.setPlanType("Plan Type 1");
		planData1.setPlan1("Plan 1");
		planData1.setPlan2("Plan 2");

		Form9EAPPPlanDataResp planData2 = new Form9EAPPPlanDataResp();

		planData2.setPlanType("Plan Type 2");
		planData2.setPlan1("Plan 3");
		planData2.setPlan2("Plan 4");

		List<Form9EAPPPlanDataResp> planDataList = Arrays.asList(planData1, planData2);

		String result = utility.tableBodyReplace(mainHtml, planDataList);

		assertNotNull(result);

		// ROW markers should be removed
		assertFalse(result.contains("{ROW_START}"));
		assertFalse(result.contains("{ROW_END}"));

		// First row
		assertTrue(result.contains("Plan Type 1"));
		assertTrue(result.contains("Plan 1"));
		assertTrue(result.contains("Plan 2"));

		// Second row
		assertTrue(result.contains("Plan Type 2"));
		assertTrue(result.contains("Plan 3"));
		assertTrue(result.contains("Plan 4"));

		// Original placeholders should be gone
		assertFalse(result.contains("{plan_type}"));
		assertFalse(result.contains("{plan_1}"));
		assertFalse(result.contains("{plan_2}"));
	}

	@Test
	void testTableBodyReplace_NullPlanValues() throws Exception {

		String mainHtml = "<html>" + "{ROW_START}" + "<tr>" + "<td>{plan_type}</td>" + "<td>{plan_1}</td>"
				+ "<td>{plan_2}</td>" + "</tr>" + "{ROW_END}" + "</html>";

		Form9EAPPPlanDataResp planData = new Form9EAPPPlanDataResp();

		planData.setPlanType(null);
		planData.setPlan1(null);
		planData.setPlan2(null);

		List<Form9EAPPPlanDataResp> planDataList = Collections.singletonList(planData);

		String result = utility.tableBodyReplace(mainHtml, planDataList);

		assertNotNull(result);

		assertFalse(result.contains("{ROW_START}"));
		assertFalse(result.contains("{ROW_END}"));

		assertFalse(result.contains("{plan_type}"));
		assertFalse(result.contains("{plan_1}"));
		assertFalse(result.contains("{plan_2}"));
	}

	@Test
	void testTableBodyReplace_Exception() throws Exception {

		String mainHtml = "<html>" + "{ROW_START}" + "<tr><td>{plan_type}</td></tr>" + "{ROW_END}" + "</html>";

		List<Form9EAPPPlanDataResp> planDataList = new ArrayList<>();

		planDataList.add(null);

		assertThrows(HomeInstructionException.class, () -> utility.tableBodyReplace(mainHtml, planDataList));
	}

	@Test
	void testGetEAPPPdfFileDetails_Success() throws Exception {

		Form9EAPPDataResp data = new Form9EAPPDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);
		data.setStudentSchool("Test School");
		data.setTeacherName("Teacher One");
		data.setTeacherEmail("teacher@test.com");
		data.setTeacherSignature("Teacher Signature");
		data.setTeacherSignDate("08/13/2026");

		Form9EAPPPlanDataResp planData = new Form9EAPPPlanDataResp();

		planData.setPlanType("Math");
		planData.setPlan1("Assignment 1");
		planData.setPlan2("Assignment 2");

		data.setForm9EappPlanData(Collections.singletonList(planData));

		File templateFile = new File(tempDir.toFile(), "EAPP.html");

		String template = "<html>" + "<div>{student_name}</div>" + "<div>{student_id}</div>"
				+ "<div>{school_name}</div>" + "<div>{teacher_name}</div>" + "<div>{teacher_email}</div>"
				+ "<div>{teacher_signature}</div>" + "<div>{teacher_sign_date}</div>" + "{ROW_START}" + "<tr>"
				+ "<td>{plan_type}</td>" + "<td>{plan_1}</td>" + "<td>{plan_2}</td>" + "</tr>" + "{ROW_END}"
				+ "</html>";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getEAPPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);
		assertNotNull(mainHtmlRet);

		String resultHtml = mainHtmlRet.toString();

		assertTrue(resultHtml.contains("John Doe"));
		assertTrue(resultHtml.contains("123"));
		assertTrue(resultHtml.contains("Test School"));
		assertTrue(resultHtml.contains("Teacher One"));
		assertTrue(resultHtml.contains("teacher@test.com"));
		assertTrue(resultHtml.contains("Teacher Signature"));
		assertTrue(resultHtml.contains("08/13/2026"));

		assertTrue(resultHtml.contains("Math"));
		assertTrue(resultHtml.contains("Assignment 1"));
		assertTrue(resultHtml.contains("Assignment 2"));

		assertFalse(resultHtml.contains("{student_name}"));
		assertFalse(resultHtml.contains("{student_id}"));
		assertFalse(resultHtml.contains("{school_name}"));
		assertFalse(resultHtml.contains("{teacher_name}"));
		assertFalse(resultHtml.contains("{teacher_email}"));
		assertFalse(resultHtml.contains("{teacher_signature}"));
		assertFalse(resultHtml.contains("{teacher_sign_date}"));

		assertFalse(resultHtml.contains("{ROW_START}"));
		assertFalse(resultHtml.contains("{ROW_END}"));

		assertFalse(resultHtml.contains("{plan_type}"));
		assertFalse(resultHtml.contains("{plan_1}"));
		assertFalse(resultHtml.contains("{plan_2}"));
	}

	@Test
	void testGetEAPPPdfFileDetails_NullPlanData() throws Exception {

		Form9EAPPDataResp data = new Form9EAPPDataResp();

		data.setStudentName("Jane Doe");
		data.setStudentId(456L);
		data.setStudentSchool("Test School");
		data.setTeacherName("Teacher Two");
		data.setTeacherEmail("teacher2@test.com");
		data.setTeacherSignature("Signature");
		data.setTeacherSignDate("08/13/2026");

		data.setForm9EappPlanData(null);

		File templateFile = new File(tempDir.toFile(), "EAPP_NULL_PLAN.html");

		String template = "<html>" + "<div>{student_name}</div>" + "<div>{student_id}</div>"
				+ "<div>{school_name}</div>" + "<div>{teacher_name}</div>" + "<div>{teacher_email}</div>"
				+ "<div>{teacher_signature}</div>" + "<div>{teacher_sign_date}</div>" + "{ROW_START}" + "<tr>"
				+ "<td>{plan_type}</td>" + "<td>{plan_1}</td>" + "<td>{plan_2}</td>" + "</tr>" + "{ROW_END}"
				+ "</html>";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getEAPPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);
		assertNotNull(mainHtmlRet);

		String resultHtml = mainHtmlRet.toString();

		assertTrue(resultHtml.contains("Jane Doe"));
		assertTrue(resultHtml.contains("456"));
		assertTrue(resultHtml.contains("Test School"));
		assertTrue(resultHtml.contains("Teacher Two"));

		// Row template should be removed because plan list is null
		assertFalse(resultHtml.contains("{ROW_START}"));
		assertFalse(resultHtml.contains("{ROW_END}"));

		assertFalse(resultHtml.contains("{plan_type}"));
		assertFalse(resultHtml.contains("{plan_1}"));
		assertFalse(resultHtml.contains("{plan_2}"));
	}

	@Test
	void testGetEAPPPdfFileDetails_Exception() throws Exception {

		Form9EAPPDataResp data = new Form9EAPPDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);

		StringBuilder mainHtmlRet = new StringBuilder();

		String invalidTemplatePath = tempDir.resolve("does-not-exist.html").toString();

		assertThrows(HomeInstructionException.class,
				() -> utility.getEAPPPdfFileDetails(data, mainHtmlRet, invalidTemplatePath));

		assertEquals("", mainHtmlRet.toString());
	}

	@Test
	void testGetEAPPPdfFileDetails_NullFields() throws Exception {

		Form9EAPPDataResp data = new Form9EAPPDataResp();

		data.setStudentName(null);
		data.setStudentId(null);
		data.setStudentSchool(null);
		data.setTeacherName(null);
		data.setTeacherEmail(null);
		data.setTeacherSignature(null);
		data.setTeacherSignDate(null);

		data.setForm9EappPlanData(Collections.emptyList());

		File templateFile = new File(tempDir.toFile(), "EAPP_NULL_FIELDS.html");

		String template = "{student_name}" + "{student_id}" + "{school_name}" + "{teacher_name}" + "{teacher_email}"
				+ "{teacher_signature}" + "{teacher_sign_date}" + "{ROW_START}" + "<tr>{plan_type}{plan_1}{plan_2}</tr>"
				+ "{ROW_END}";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getEAPPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);
		assertNotNull(mainHtmlRet);

		String resultHtml = mainHtmlRet.toString();

		assertFalse(resultHtml.contains("{student_name}"));
		assertFalse(resultHtml.contains("{student_id}"));
		assertFalse(resultHtml.contains("{school_name}"));
		assertFalse(resultHtml.contains("{teacher_name}"));
		assertFalse(resultHtml.contains("{teacher_email}"));
		assertFalse(resultHtml.contains("{teacher_signature}"));
		assertFalse(resultHtml.contains("{teacher_sign_date}"));
	}

	@Test
	void testGetHISCPPdfFileDetails_Injury_PhysicalTrue_GE_HistoryPresent() throws Exception {

		Form8HiscpDataResp data = new Form8HiscpDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);
		data.setStudentGrade("5");
		data.setStudentSchool("Test School");
		data.setMedicalCutoffDate("08/13/2026");

		data.setNurseSignature("Nurse Signature");
		data.setNurseSignDate("08/13/2026");

		data.setPrimaryLanguage("English");
		data.setLastPresentDate("08/01/2026");
		data.setNumberOfDayMissing("5");
		data.setHoursOfInstruction("Injury");
		data.setAcademicLevel("Grade 5");

		data.setCounsellorSignature("Counsellor Signature");
		data.setCounsellorSignDate("08/13/2026");

		data.setIsPhysicalLimitation(true);
		data.setNurseComments("Physical limitation comments");

		data.setProgram("GE");
		data.setStudentHistory("Student history information");

		File templateFile = new File(tempDir.toFile(), "HISCP.html");

		String template = "{student_name}" + "{student_id}" + "{grade}" + "{school_name}" + "{medical_cutoff_date}"
				+ "{nurse_signature}" + "{nurse_sign_date}" + "{primary_language}" + "{last_present_date}"
				+ "{number_of_day_missing}" + "{hours_of_instruction}" + "{academic_level}" + "{counsellor_signature}"
				+ "{counsellor_sign_date}"

				+ "{REASON_INJ_CHECKED_START}" + "{REASON_INJ_CHECKED_END}" + "{REASON_INJ_NOTCHECKED_START}"
				+ "{REASON_INJ_NOTCHECKED_END}"

				+ "{REASON_ILL_CHECKED_START}" + "{REASON_ILL_CHECKED_END}" + "{REASON_ILL_NOTCHECKED_START}"
				+ "{REASON_ILL_NOTCHECKED_END}"

				+ "{REASON_BHV_CHECKED_START}" + "{REASON_BHV_CHECKED_END}" + "{REASON_BHV_NOTCHECKED_START}"
				+ "{REASON_BHV_NOTCHECKED_END}"

				+ "{IS_PHYSICAL_LIMITATION_Y_CHECKED_START}" + "{IS_PHYSICAL_LIMITATION_Y_CHECKED_END}"
				+ "{IS_PHYSICAL_LIMITATION_Y_NOTCHECKED_START}" + "{IS_PHYSICAL_LIMITATION_Y_NOTCHECKED_END}"

				+ "{IS_PHYSICAL_LIMITATION_N_CHECKED_START}" + "{IS_PHYSICAL_LIMITATION_N_CHECKED_END}"
				+ "{IS_PHYSICAL_LIMITATION_N_NOTCHECKED_START}" + "{IS_PHYSICAL_LIMITATION_N_NOTCHECKED_END}"

				+ "{comments}" + "{COMMENTS_NOTBLANK_START}" + "{COMMENTS_NOTBLANK_END}" + "{COMMENTS_BLANK_START}"
				+ "{COMMENTS_BLANK_END}"

				+ "{PROGRAM_GENED_CHECKED_START}" + "{PROGRAM_GENED_CHECKED_END}" + "{PROGRAM_GENED_NOTCHECKED_START}"
				+ "{PROGRAM_GENED_NOTCHECKED_END}"

				+ "{PROGRAM_SPED_CHECKED_START}" + "{PROGRAM_SPED_CHECKED_END}" + "{PROGRAM_SPED_NOTCHECKED_START}"
				+ "{PROGRAM_SPED_NOTCHECKED_END}"

				+ "{PROGRAM_ESL_CHECKED_START}" + "{PROGRAM_ESL_CHECKED_END}" + "{PROGRAM_ESL_NOTCHECKED_START}"
				+ "{PROGRAM_ESL_NOTCHECKED_END}"

				+ "{PROGRAM_ELL_CHECKED_START}" + "{PROGRAM_ELL_CHECKED_END}" + "{PROGRAM_ELL_NOTCHECKED_START}"
				+ "{PROGRAM_ELL_NOTCHECKED_END}"

				+ "{PROGRAM_504_CHECKED_START}" + "{PROGRAM_504_CHECKED_END}" + "{PROGRAM_504_NOTCHECKED_START}"
				+ "{PROGRAM_504_NOTCHECKED_END}"

				+ "{STUDENT_HISTORY_NOTBLANK_START}" + "{STUDENT_HISTORY_NOTBLANK_END}"
				+ "{STUDENT_HISTORY_BLANK_START}" + "{STUDENT_HISTORY_BLANK_END}" + "{student_history}";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getHISCPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("John Doe"));
		assertTrue(html.contains("123"));
		assertTrue(html.contains("Test School"));
		assertTrue(html.contains("Injury"));
		assertTrue(html.contains("Physical limitation comments"));
		assertTrue(html.contains("Student history information"));

		assertFalse(html.contains("{REASON_INJ_CHECKED_START}"));
		assertFalse(html.contains("{REASON_INJ_CHECKED_END}"));
		assertTrue(html.contains("<!--"));
		assertTrue(html.contains("-->"));

		assertTrue(html.contains("Physical limitation comments"));

		assertFalse(html.contains("{PROGRAM_GENED_CHECKED_START}"));
		assertFalse(html.contains("{PROGRAM_GENED_CHECKED_END}"));

		assertFalse(html.contains("{STUDENT_HISTORY_NOTBLANK_START}"));
		assertFalse(html.contains("{STUDENT_HISTORY_NOTBLANK_END}"));
		assertTrue(html.contains("Student history information"));
	}

	@Test
	void testGetHISCPPdfFileDetails_Illness_PhysicalFalse_SP_HistoryBlank() throws Exception {

		Form8HiscpDataResp data = new Form8HiscpDataResp();

		data.setStudentName("Jane Doe");
		data.setStudentId(456L);
		data.setStudentGrade("6");
		data.setStudentSchool("School Two");

		data.setMedicalCutoffDate("08/13/2026");
		data.setNurseSignature("Nurse");
		data.setNurseSignDate("08/13/2026");

		data.setPrimaryLanguage("English");
		data.setLastPresentDate("08/02/2026");
		data.setNumberOfDayMissing("3");
		data.setHoursOfInstruction("Illness");
		data.setAcademicLevel("Grade 6");

		data.setCounsellorSignature("Counsellor");
		data.setCounsellorSignDate("08/13/2026");

		data.setIsPhysicalLimitation(false);
		data.setNurseComments(null);

		data.setProgram("SP");
		data.setStudentHistory("");

		File templateFile = new File(tempDir.toFile(), "HISCP_2.html");

		String template = getHiscpTestTemplate();

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getHISCPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Jane Doe"));
		assertTrue(html.contains("456"));
		assertTrue(html.contains("Illness"));

		// Illness checked
		assertFalse(html.contains("{REASON_ILL_CHECKED_START}"));
		assertFalse(html.contains("{REASON_ILL_CHECKED_END}"));

		// Physical limitation FALSE
		assertFalse(html.contains("{IS_PHYSICAL_LIMITATION_Y_CHECKED_START}"));
		assertFalse(html.contains("{IS_PHYSICAL_LIMITATION_N_CHECKED_START}"));

		// History blank
		assertFalse(html.contains("{student_history}"));
		assertFalse(html.contains("{STUDENT_HISTORY_BLANK_START}"));
		assertFalse(html.contains("{STUDENT_HISTORY_BLANK_END}"));
	}

	@Test
	void testGetHISCPPdfFileDetails_Behavior_PhysicalTrue_ES() throws Exception {

		Form8HiscpDataResp data = new Form8HiscpDataResp();

		data.setStudentName("Student Three");
		data.setStudentId(789L);
		data.setStudentGrade("7");
		data.setStudentSchool("School Three");

		data.setHoursOfInstruction("Behavior");

		data.setIsPhysicalLimitation(true);
		data.setNurseComments("Comments");

		data.setProgram("ES");
		data.setStudentHistory("History");

		File templateFile = new File(tempDir.toFile(), "HISCP_3.html");

		FileUtils.writeStringToFile(templateFile, getHiscpTestTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getHISCPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Student Three"));
		assertTrue(html.contains("Behavior"));
		assertTrue(html.contains("Comments"));
		assertTrue(html.contains("History"));

		// Behavior checked
		assertFalse(html.contains("{REASON_BHV_CHECKED_START}"));
		assertFalse(html.contains("{REASON_BHV_CHECKED_END}"));

		// ES checked
		assertFalse(html.contains("{PROGRAM_ESL_CHECKED_START}"));
		assertFalse(html.contains("{PROGRAM_ESL_CHECKED_END}"));
	}

	@Test
	void testGetHISCPPdfFileDetails_BlankHours_EL() throws Exception {

		Form8HiscpDataResp data = new Form8HiscpDataResp();

		data.setStudentName("Student Four");
		data.setStudentId(999L);
		data.setStudentGrade("8");
		data.setStudentSchool("School Four");

		data.setHoursOfInstruction("");
		data.setIsPhysicalLimitation(false);
		data.setProgram("EL");
		data.setStudentHistory("");

		File templateFile = new File(tempDir.toFile(), "HISCP_4.html");

		FileUtils.writeStringToFile(templateFile, getHiscpTestTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getHISCPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Student Four"));
		assertTrue(html.contains("999"));

		// Blank hours branch
		assertFalse(html.contains("{REASON_INJ_CHECKED_START}"));
		assertFalse(html.contains("{REASON_ILL_CHECKED_START}"));
		assertFalse(html.contains("{REASON_BHV_CHECKED_START}"));

		// EL checked
		assertFalse(html.contains("{PROGRAM_ELL_CHECKED_START}"));
		assertFalse(html.contains("{PROGRAM_ELL_CHECKED_END}"));
	}

	@Test
	void testGetHISCPPdfFileDetails_Program504() throws Exception {

		Form8HiscpDataResp data = new Form8HiscpDataResp();

		data.setStudentName("Student Five");
		data.setStudentId(1000L);
		data.setHoursOfInstruction("Other");
		data.setIsPhysicalLimitation(false);
		data.setProgram("504");
		data.setStudentHistory("History");

		File templateFile = new File(tempDir.toFile(), "HISCP_5.html");

		FileUtils.writeStringToFile(templateFile, getHiscpTestTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getHISCPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Student Five"));

		assertFalse(html.contains("{PROGRAM_504_CHECKED_START}"));
		assertFalse(html.contains("{PROGRAM_504_CHECKED_END}"));
	}

	@Test
	void testGetHISCPPdfFileDetails_ProgramOther() throws Exception {

		Form8HiscpDataResp data = new Form8HiscpDataResp();

		data.setStudentName("Student Six");
		data.setStudentId(2000L);

		data.setHoursOfInstruction("Other");
		data.setIsPhysicalLimitation(false);
		data.setProgram("OTHER");
		data.setStudentHistory("History");

		File templateFile = new File(tempDir.toFile(), "HISCP_6.html");

		FileUtils.writeStringToFile(templateFile, getHiscpTestTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getHISCPPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Student Six"));

		// OTHER means all program checkboxes are not selected
		assertFalse(html.contains("{PROGRAM_GENED_CHECKED_START}"));
		assertFalse(html.contains("{PROGRAM_SPED_CHECKED_START}"));
		assertFalse(html.contains("{PROGRAM_ESL_CHECKED_START}"));
		assertFalse(html.contains("{PROGRAM_ELL_CHECKED_START}"));
		assertFalse(html.contains("{PROGRAM_504_CHECKED_START}"));
	}

	@Test
	void testGetHISCPPdfFileDetails_Exception() throws Exception {

		Form8HiscpDataResp data = new Form8HiscpDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);

		StringBuilder mainHtmlRet = new StringBuilder();

		String invalidTemplatePath = tempDir.resolve("does-not-exist.html").toString();

		assertThrows(HomeInstructionException.class,
				() -> utility.getHISCPPdfFileDetails(data, mainHtmlRet, invalidTemplatePath));

		assertEquals("", mainHtmlRet.toString());
	}

	private String getHiscpTestTemplate() {

		return "{student_name}" + "{student_id}" + "{grade}" + "{school_name}" + "{medical_cutoff_date}"
				+ "{nurse_signature}" + "{nurse_sign_date}" + "{primary_language}" + "{last_present_date}"
				+ "{number_of_day_missing}" + "{hours_of_instruction}" + "{academic_level}" + "{counsellor_signature}"
				+ "{counsellor_sign_date}"

				+ "{REASON_INJ_CHECKED_START}" + "{REASON_INJ_CHECKED_END}" + "{REASON_INJ_NOTCHECKED_START}"
				+ "{REASON_INJ_NOTCHECKED_END}"

				+ "{REASON_ILL_CHECKED_START}" + "{REASON_ILL_CHECKED_END}" + "{REASON_ILL_NOTCHECKED_START}"
				+ "{REASON_ILL_NOTCHECKED_END}"

				+ "{REASON_BHV_CHECKED_START}" + "{REASON_BHV_CHECKED_END}" + "{REASON_BHV_NOTCHECKED_START}"
				+ "{REASON_BHV_NOTCHECKED_END}"

				+ "{IS_PHYSICAL_LIMITATION_Y_CHECKED_START}" + "{IS_PHYSICAL_LIMITATION_Y_CHECKED_END}"
				+ "{IS_PHYSICAL_LIMITATION_Y_NOTCHECKED_START}" + "{IS_PHYSICAL_LIMITATION_Y_NOTCHECKED_END}"

				+ "{IS_PHYSICAL_LIMITATION_N_CHECKED_START}" + "{IS_PHYSICAL_LIMITATION_N_CHECKED_END}"
				+ "{IS_PHYSICAL_LIMITATION_N_NOTCHECKED_START}" + "{IS_PHYSICAL_LIMITATION_N_NOTCHECKED_END}"

				+ "{comments}" + "{COMMENTS_NOTBLANK_START}" + "{COMMENTS_NOTBLANK_END}" + "{COMMENTS_BLANK_START}"
				+ "{COMMENTS_BLANK_END}"

				+ "{PROGRAM_GENED_CHECKED_START}" + "{PROGRAM_GENED_CHECKED_END}" + "{PROGRAM_GENED_NOTCHECKED_START}"
				+ "{PROGRAM_GENED_NOTCHECKED_END}"

				+ "{PROGRAM_SPED_CHECKED_START}" + "{PROGRAM_SPED_CHECKED_END}" + "{PROGRAM_SPED_NOTCHECKED_START}"
				+ "{PROGRAM_SPED_NOTCHECKED_END}"

				+ "{PROGRAM_ESL_CHECKED_START}" + "{PROGRAM_ESL_CHECKED_END}" + "{PROGRAM_ESL_NOTCHECKED_START}"
				+ "{PROGRAM_ESL_NOTCHECKED_END}"

				+ "{PROGRAM_ELL_CHECKED_START}" + "{PROGRAM_ELL_CHECKED_END}" + "{PROGRAM_ELL_NOTCHECKED_START}"
				+ "{PROGRAM_ELL_NOTCHECKED_END}"

				+ "{PROGRAM_504_CHECKED_START}" + "{PROGRAM_504_CHECKED_END}" + "{PROGRAM_504_NOTCHECKED_START}"
				+ "{PROGRAM_504_NOTCHECKED_END}"

				+ "{STUDENT_HISTORY_NOTBLANK_START}" + "{STUDENT_HISTORY_NOTBLANK_END}"
				+ "{STUDENT_HISTORY_BLANK_START}" + "{STUDENT_HISTORY_BLANK_END}" + "{student_history}";
	}

	@Test
	void testGet760DHIPdfFileDetails_Success() throws Exception {

		Form760DhiDataResp data = new Form760DhiDataResp();

		data.setNurseName("Nurse Smith");
		data.setStudentName("John Doe");
		data.setStudentId(123L);
		data.setStudentGrade("5");
		data.setNoticeDate("08/13/2026");
		data.setPhysicianName("Dr. Smith");
		data.setPhysicianVerifiedOn("08/12/2026");

		File templateFile = new File(tempDir.toFile(), "760DHI.html");

		String template = "{nurse_name}" + "{student_name}" + "{student_id}" + "{grade}" + "{notice_date}"
				+ "{physician_name}" + "{physician_verified_on}";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.get760DHIPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Nurse Smith"));
		assertTrue(html.contains("John Doe"));
		assertTrue(html.contains("123"));
		assertTrue(html.contains("5"));
		assertTrue(html.contains("08/13/2026"));
		assertTrue(html.contains("Dr. Smith"));
		assertTrue(html.contains("08/12/2026"));

		assertFalse(html.contains("{nurse_name}"));
		assertFalse(html.contains("{student_name}"));
		assertFalse(html.contains("{student_id}"));
		assertFalse(html.contains("{grade}"));
		assertFalse(html.contains("{notice_date}"));
		assertFalse(html.contains("{physician_name}"));
		assertFalse(html.contains("{physician_verified_on}"));
	}

	@Test
	void testGet760DHIPdfFileDetails_Exception() throws Exception {

		Form760DhiDataResp data = new Form760DhiDataResp();

		data.setNurseName("Nurse Smith");
		data.setStudentName("John Doe");
		data.setStudentId(123L);

		StringBuilder mainHtmlRet = new StringBuilder();

		String invalidTemplatePath = tempDir.resolve("does-not-exist.html").toString();

		assertThrows(HomeInstructionException.class,
				() -> utility.get760DHIPdfFileDetails(data, mainHtmlRet, invalidTemplatePath));

		assertEquals("", mainHtmlRet.toString());
	}

	@Test
	void testGet30DHIPdfFileDetails_Success() throws Exception {

		Form630DhiDataResp data = new Form630DhiDataResp();

		data.setNurseName("Nurse Smith");
		data.setStudentName("John Doe");
		data.setStudentId(123L);
		data.setStudentGrade("5");
		data.setNoticeDate("08/13/2026");
		data.setPhysicianName("Dr. Smith");
		data.setPhysicianVerifiedOn("08/12/2026");

		File templateFile = new File(tempDir.toFile(), "630DHI.html");

		String template = "{nurse_name}" + "{student_name}" + "{student_id}" + "{grade}" + "{notice_date}"
				+ "{physician_name}" + "{physician_verified_on}";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.get30DHIPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Nurse Smith"));
		assertTrue(html.contains("John Doe"));
		assertTrue(html.contains("123"));
		assertTrue(html.contains("5"));
		assertTrue(html.contains("08/13/2026"));
		assertTrue(html.contains("Dr. Smith"));
		assertTrue(html.contains("08/12/2026"));

		assertFalse(html.contains("{nurse_name}"));
		assertFalse(html.contains("{student_name}"));
		assertFalse(html.contains("{student_id}"));
		assertFalse(html.contains("{grade}"));
		assertFalse(html.contains("{notice_date}"));
		assertFalse(html.contains("{physician_name}"));
		assertFalse(html.contains("{physician_verified_on}"));
	}

	@Test
	void testGet30DHIPdfFileDetails_Exception() throws Exception {

		Form630DhiDataResp data = new Form630DhiDataResp();

		data.setNurseName("Nurse Smith");
		data.setStudentName("John Doe");
		data.setStudentId(123L);

		StringBuilder mainHtmlRet = new StringBuilder();

		String invalidTemplatePath = tempDir.resolve("does-not-exist.html").toString();

		assertThrows(HomeInstructionException.class,
				() -> utility.get30DHIPdfFileDetails(data, mainHtmlRet, invalidTemplatePath));

		assertEquals("", mainHtmlRet.toString());
	}

	@Test
	void testGetPRTHIPdfFileDetails_AllTrue() throws Exception {

		Form4PrthiDataResp data = new Form4PrthiDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);
		data.setStudentDob("01/01/2015");
		data.setStudentSchool("Test School");
		data.setStudentGrade("5");

		data.setTeacherName("Teacher Smith");
		data.setTeacherSchool("Teacher School");
		data.setTeacherHomePhone("111-222-3333");
		data.setTeacherWorkPhone("444-555-6666");
		data.setTeacherSignature("Teacher Signature");
		data.setTeacherSignDate("08/13/2026");
		data.setPrincipalSignature("Principal Signature");
		data.setPrincipalSignDate("08/13/2026");

		data.setIsTeacherAccept(true);
		data.setIsTeacherRecommend(true);
		data.setIsTeacherCertified(true);

		data.setTeacherArea1("Math");
		data.setTeacherArea2("Science");
		data.setTeacherArea3("English");
		data.setTeacherArea4("History");

		File templateFile = new File(tempDir.toFile(), "PRTHI.html");

		String template = "{student_name}" + "{student_id}" + "{student_dob}" + "{school_name}" + "{grade}"
				+ "{teacher_name}" + "{teacher_school}" + "{teacher_home_phone}" + "{teacher_work_phone}"
				+ "{teacher_signature}" + "{teacher_sign_date}" + "{principal_signature}" + "{principal_sign_date}"

				+ "{IS_TEACHER_ACCEPT_CHECKED_START}" + "{IS_TEACHER_ACCEPT_CHECKED_END}"
				+ "{IS_TEACHER_ACCEPT_NOTCHECKED_START}" + "{IS_TEACHER_ACCEPT_NOTCHECKED_END}"

				+ "{IS_TEACHER_RECOMMEND_CHECKED_START}" + "{IS_TEACHER_RECOMMEND_CHECKED_END}"
				+ "{IS_TEACHER_RECOMMEND_NOTCHECKED_START}" + "{IS_TEACHER_RECOMMEND_NOTCHECKED_END}"

				+ "{IS_TEACHER_CERTIFIED_CHECKED_START}" + "{IS_TEACHER_CERTIFIED_CHECKED_END}"
				+ "{IS_TEACHER_CERTIFIED_NOTCHECKED_START}" + "{IS_TEACHER_CERTIFIED_NOTCHECKED_END}"

				+ "{teacher_area_1}" + "{teacher_area_2}" + "{teacher_area_3}" + "{teacher_area_4}";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getPRTHIPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("John Doe"));
		assertTrue(html.contains("123"));
		assertTrue(html.contains("01/01/2015"));
		assertTrue(html.contains("Test School"));
		assertTrue(html.contains("5"));

		assertTrue(html.contains("Teacher Smith"));
		assertTrue(html.contains("Teacher School"));
		assertTrue(html.contains("111-222-3333"));
		assertTrue(html.contains("444-555-6666"));
		assertTrue(html.contains("Teacher Signature"));
		assertTrue(html.contains("Principal Signature"));

		assertTrue(html.contains("Math"));
		assertTrue(html.contains("Science"));
		assertTrue(html.contains("English"));
		assertTrue(html.contains("History"));

		// Teacher Accept = TRUE
		assertFalse(html.contains("{IS_TEACHER_ACCEPT_CHECKED_START}"));
		assertFalse(html.contains("{IS_TEACHER_ACCEPT_CHECKED_END}"));

		// Teacher Recommend = TRUE
		assertFalse(html.contains("{IS_TEACHER_RECOMMEND_CHECKED_START}"));
		assertFalse(html.contains("{IS_TEACHER_RECOMMEND_CHECKED_END}"));

		// Teacher Certified = TRUE
		assertFalse(html.contains("{IS_TEACHER_CERTIFIED_CHECKED_START}"));
		assertFalse(html.contains("{IS_TEACHER_CERTIFIED_CHECKED_END}"));

		// All placeholders replaced
		assertFalse(html.contains("{teacher_area_1}"));
		assertFalse(html.contains("{teacher_area_2}"));
		assertFalse(html.contains("{teacher_area_3}"));
		assertFalse(html.contains("{teacher_area_4}"));
	}

	@Test
	void testGetPRTHIPdfFileDetails_AllFalse() throws Exception {

		Form4PrthiDataResp data = new Form4PrthiDataResp();

		data.setStudentName("Jane Doe");
		data.setStudentId(456L);
		data.setStudentDob("02/02/2014");
		data.setStudentSchool("School Two");
		data.setStudentGrade("6");

		data.setTeacherName("Teacher Two");
		data.setTeacherSchool("School Two");
		data.setTeacherHomePhone("111-111-1111");
		data.setTeacherWorkPhone("222-222-2222");
		data.setTeacherSignature("Signature");
		data.setTeacherSignDate("08/13/2026");
		data.setPrincipalSignature("Principal");
		data.setPrincipalSignDate("08/13/2026");

		data.setIsTeacherAccept(false);
		data.setIsTeacherRecommend(false);
		data.setIsTeacherCertified(false);

		File templateFile = new File(tempDir.toFile(), "PRTHI_False.html");

		FileUtils.writeStringToFile(templateFile, getPrtHiTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getPRTHIPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Jane Doe"));
		assertTrue(html.contains("456"));
		assertTrue(html.contains("Teacher Two"));

		// Accept = FALSE
		assertFalse(html.contains("{IS_TEACHER_ACCEPT_CHECKED_START}"));
		assertFalse(html.contains("{IS_TEACHER_ACCEPT_CHECKED_END}"));

		// Recommend = FALSE
		assertFalse(html.contains("{IS_TEACHER_RECOMMEND_CHECKED_START}"));
		assertFalse(html.contains("{IS_TEACHER_RECOMMEND_CHECKED_END}"));

		// Certified = FALSE
		assertFalse(html.contains("{IS_TEACHER_CERTIFIED_CHECKED_START}"));
		assertFalse(html.contains("{IS_TEACHER_CERTIFIED_CHECKED_END}"));

		// Areas should be replaced with empty strings
		assertFalse(html.contains("{teacher_area_1}"));
		assertFalse(html.contains("{teacher_area_2}"));
		assertFalse(html.contains("{teacher_area_3}"));
		assertFalse(html.contains("{teacher_area_4}"));
	}

	@Test
	void testGetPRTHIPdfFileDetails_MixedValues() throws Exception {

		Form4PrthiDataResp data = new Form4PrthiDataResp();

		data.setStudentName("Student Three");
		data.setStudentId(789L);
		data.setStudentDob("03/03/2013");
		data.setStudentSchool("School Three");
		data.setStudentGrade("7");

		data.setTeacherName("Teacher Three");
		data.setTeacherSchool("School Three");
		data.setTeacherHomePhone("333-333-3333");
		data.setTeacherWorkPhone("444-444-4444");
		data.setTeacherSignature("Teacher Signature");
		data.setTeacherSignDate("08/13/2026");
		data.setPrincipalSignature("Principal Signature");
		data.setPrincipalSignDate("08/13/2026");

		// Mixed values
		data.setIsTeacherAccept(true);
		data.setIsTeacherRecommend(false);
		data.setIsTeacherCertified(true);

		data.setTeacherArea1("Area One");
		data.setTeacherArea2("Area Two");
		data.setTeacherArea3("Area Three");
		data.setTeacherArea4("Area Four");

		File templateFile = new File(tempDir.toFile(), "PRTHI_Mixed.html");

		FileUtils.writeStringToFile(templateFile, getPrtHiTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getPRTHIPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Student Three"));
		assertTrue(html.contains("789"));

		// Accept TRUE
		assertFalse(html.contains("{IS_TEACHER_ACCEPT_CHECKED_START}"));

		// Recommend FALSE
		assertFalse(html.contains("{IS_TEACHER_RECOMMEND_CHECKED_START}"));

		// Certified TRUE
		assertFalse(html.contains("{IS_TEACHER_CERTIFIED_CHECKED_START}"));

		assertTrue(html.contains("Area One"));
		assertTrue(html.contains("Area Two"));
		assertTrue(html.contains("Area Three"));
		assertTrue(html.contains("Area Four"));
	}

	@Test
	void testGetPRTHIPdfFileDetails_Exception() throws Exception {

		Form4PrthiDataResp data = new Form4PrthiDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);

		StringBuilder mainHtmlRet = new StringBuilder();

		String invalidTemplatePath = tempDir.resolve("does-not-exist.html").toString();

		assertThrows(HomeInstructionException.class,
				() -> utility.getPRTHIPdfFileDetails(data, mainHtmlRet, invalidTemplatePath));

		assertEquals("", mainHtmlRet.toString());
	}

	private String getPrtHiTemplate() {

		return "{student_name}" + "{student_id}" + "{student_dob}" + "{school_name}" + "{grade}" + "{teacher_name}"
				+ "{teacher_school}" + "{teacher_home_phone}" + "{teacher_work_phone}" + "{teacher_signature}"
				+ "{teacher_sign_date}" + "{principal_signature}" + "{principal_sign_date}"

				+ "{IS_TEACHER_ACCEPT_CHECKED_START}" + "{IS_TEACHER_ACCEPT_CHECKED_END}"
				+ "{IS_TEACHER_ACCEPT_NOTCHECKED_START}" + "{IS_TEACHER_ACCEPT_NOTCHECKED_END}"

				+ "{IS_TEACHER_RECOMMEND_CHECKED_START}" + "{IS_TEACHER_RECOMMEND_CHECKED_END}"
				+ "{IS_TEACHER_RECOMMEND_NOTCHECKED_START}" + "{IS_TEACHER_RECOMMEND_NOTCHECKED_END}"

				+ "{IS_TEACHER_CERTIFIED_CHECKED_START}" + "{IS_TEACHER_CERTIFIED_CHECKED_END}"
				+ "{IS_TEACHER_CERTIFIED_NOTCHECKED_START}" + "{IS_TEACHER_CERTIFIED_NOTCHECKED_END}"

				+ "{teacher_area_1}" + "{teacher_area_2}" + "{teacher_area_3}" + "{teacher_area_4}";
	}

	@Test
	void testScheduleBodyReplace_Success() {

		String mainHtml = "<table>" + "{ROW_START}" + "<tr>" + "<td>{subject_name_mp1_mp2}</td>" + "<td>{mp1}</td>"
				+ "<td>{mp2}</td>" + "<td>{subject_name_mp3_mp4}</td>" + "<td>{mp3}</td>" + "<td>{mp4}</td>" + "</tr>"
				+ "{ROW_END}" + "</table>";

		List<Form1AphirScheduleResp> leftScheduleList = new ArrayList<>();
		List<Form1AphirScheduleResp> rightScheduleList = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {

			Form1AphirScheduleResp left = new Form1AphirScheduleResp();
			left.setSubject("Left Subject " + i);
			left.setMp1("MP1-" + i);
			left.setMp2("MP2-" + i);

			Form1AphirScheduleResp right = new Form1AphirScheduleResp();
			right.setSubject("Right Subject " + i);
			right.setMp3("MP3-" + i);
			right.setMp4("MP4-" + i);

			leftScheduleList.add(left);
			rightScheduleList.add(right);
		}

		String result = utility.scheduleBodyReplace(mainHtml, leftScheduleList, rightScheduleList);

		assertNotNull(result);

		assertTrue(result.contains("Left Subject 1"));
		assertTrue(result.contains("MP1-1"));
		assertTrue(result.contains("MP2-1"));
		assertTrue(result.contains("Right Subject 1"));
		assertTrue(result.contains("MP3-1"));
		assertTrue(result.contains("MP4-1"));

		assertTrue(result.contains("Left Subject 5"));
		assertTrue(result.contains("MP1-5"));
		assertTrue(result.contains("MP2-5"));
		assertTrue(result.contains("Right Subject 5"));
		assertTrue(result.contains("MP3-5"));
		assertTrue(result.contains("MP4-5"));

		assertFalse(result.contains("{ROW_START}"));
		assertFalse(result.contains("{ROW_END}"));

		assertFalse(result.contains("{subject_name_mp1_mp2}"));
		assertFalse(result.contains("{mp1}"));
		assertFalse(result.contains("{mp2}"));
		assertFalse(result.contains("{subject_name_mp3_mp4}"));
		assertFalse(result.contains("{mp3}"));
		assertFalse(result.contains("{mp4}"));
	}

	@Test
	void testScheduleBodyReplace_NullHtml() {

		List<Form1AphirScheduleResp> leftScheduleList = new ArrayList<>();
		List<Form1AphirScheduleResp> rightScheduleList = new ArrayList<>();

		String result = utility.scheduleBodyReplace(null, leftScheduleList, rightScheduleList);

		assertNull(result);
	}

	@Test
	void testScheduleBodyReplace_Exception() {

		String mainHtml = "{ROW_START}" + "<tr>" + "<td>{subject_name_mp1_mp2}</td>" + "<td>{mp1}</td>"
				+ "<td>{mp2}</td>" + "<td>{subject_name_mp3_mp4}</td>" + "<td>{mp3}</td>" + "<td>{mp4}</td>" + "</tr>"
				+ "{ROW_END}";

		List<Form1AphirScheduleResp> leftScheduleList = new ArrayList<>();
		List<Form1AphirScheduleResp> rightScheduleList = new ArrayList<>();

		for (int i = 1; i <= 4; i++) {

			Form1AphirScheduleResp left = new Form1AphirScheduleResp();
			left.setSubject("Left " + i);
			left.setMp1("MP1-" + i);
			left.setMp2("MP2-" + i);

			Form1AphirScheduleResp right = new Form1AphirScheduleResp();
			right.setSubject("Right " + i);
			right.setMp3("MP3-" + i);
			right.setMp4("MP4-" + i);

			leftScheduleList.add(left);
			rightScheduleList.add(right);
		}

		assertThrows(HomeInstructionException.class,
				() -> utility.scheduleBodyReplace(mainHtml, leftScheduleList, rightScheduleList));
	}

	@Test
	void testGenerateBlankScheduleList_AddBlankSchedules() {

		List<Form1AphirScheduleResp> scheduleList = new ArrayList<>();

		Form1AphirScheduleResp schedule = new Form1AphirScheduleResp();
		schedule.setId(10L);
		schedule.setForm1APHIRDataId(20L);
		schedule.setSubject("Math");
		schedule.setMp1("A");
		schedule.setMp2("B");
		schedule.setMp3("C");
		schedule.setMp4("D");

		scheduleList.add(schedule);

		int maxLength = 5;

		List<Form1AphirScheduleResp> result = utility.generateBlankScheduleList(scheduleList, maxLength);

		assertNotNull(result);
		assertEquals(5, result.size());

		// Original record should remain
		assertEquals(Long.valueOf(10L), result.get(0).getId());
		assertEquals(Long.valueOf(20L), result.get(0).getForm1APHIRDataId());
		assertEquals("Math", result.get(0).getSubject());
		assertEquals("A", result.get(0).getMp1());
		assertEquals("B", result.get(0).getMp2());
		assertEquals("C", result.get(0).getMp3());
		assertEquals("D", result.get(0).getMp4());

		// First generated blank record
		assertEquals(Long.valueOf(0L), result.get(1).getId());
		assertEquals(Long.valueOf(0L), result.get(1).getForm1APHIRDataId());
		assertEquals("", result.get(1).getSubject());
		assertEquals("", result.get(1).getMp1());
		assertEquals("", result.get(1).getMp2());
		assertEquals("", result.get(1).getMp3());
		assertEquals("", result.get(1).getMp4());

		// Last generated blank record
		assertEquals(Long.valueOf(0L), result.get(4).getId());
		assertEquals(Long.valueOf(0L), result.get(4).getForm1APHIRDataId());
		assertEquals("", result.get(4).getSubject());
		assertEquals("", result.get(4).getMp1());
		assertEquals("", result.get(4).getMp2());
		assertEquals("", result.get(4).getMp3());
		assertEquals("", result.get(4).getMp4());

		// Original list should not be modified
		assertEquals(1, scheduleList.size());
	}

	@Test
	void testGenerateBlankScheduleList_AlreadyMaxLength() {

		List<Form1AphirScheduleResp> scheduleList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			Form1AphirScheduleResp schedule = new Form1AphirScheduleResp();

			schedule.setId((long) i);
			schedule.setForm1APHIRDataId((long) (i + 10));
			schedule.setSubject("Subject " + i);
			schedule.setMp1("MP1-" + i);
			schedule.setMp2("MP2-" + i);
			schedule.setMp3("MP3-" + i);
			schedule.setMp4("MP4-" + i);

			scheduleList.add(schedule);
		}

		List<Form1AphirScheduleResp> result = utility.generateBlankScheduleList(scheduleList, 5);

		assertNotNull(result);
		assertEquals(5, result.size());

		assertEquals("Subject 0", result.get(0).getSubject());
		assertEquals("Subject 4", result.get(4).getSubject());

		assertEquals("MP1-0", result.get(0).getMp1());
		assertEquals("MP4-4", result.get(4).getMp4());

		// No blank record should have been added
		assertEquals(5, result.size());

		// Original list is unchanged
		assertEquals(5, scheduleList.size());
	}

	@Test
	void testGetRHILTPdfFileDetails_ApplicationGivenTrue() throws Exception {

		Form3RhiltDataResp data = new Form3RhiltDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);
		data.setStudentSchool("Test School");
		data.setStudentGrade("5");
		data.setInjuryType("Injury");
		data.setLengthOfAbsence("10");
		data.setParentSignature("Parent Signature");
		data.setParentSignDate("08/13/2026");
		data.setReceivedBy("Nurse");
		data.setNurseSignature("Nurse Signature");
		data.setNurseSignDate("08/13/2026");

		data.setIsApplicationGiven(true);

		File templateFile = new File(tempDir.toFile(), "RHILT_TRUE.html");

		String template = "{student_name}" + "{student_id}" + "{school_name}" + "{grade}" + "{injury_type}"
				+ "{length_of_absence}" + "{parent_signature}" + "{parent_sign_date}" + "{received_by}"
				+ "{nurse_signature}" + "{nurse_sign_date}"

				+ "{IS_APPLICATION_GIVEN_Y_CHECKED_START}" + "{IS_APPLICATION_GIVEN_Y_CHECKED_END}"
				+ "{IS_APPLICATION_GIVEN_Y_NOTCHECKED_START}" + "{IS_APPLICATION_GIVEN_Y_NOTCHECKED_END}"

				+ "{IS_APPLICATION_GIVEN_N_CHECKED_START}" + "{IS_APPLICATION_GIVEN_N_CHECKED_END}"
				+ "{IS_APPLICATION_GIVEN_N_NOTCHECKED_START}" + "{IS_APPLICATION_GIVEN_N_NOTCHECKED_END}";

		FileUtils.writeStringToFile(templateFile, template, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHILTPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("John Doe"));
		assertTrue(html.contains("123"));
		assertTrue(html.contains("Test School"));
		assertTrue(html.contains("5"));
		assertTrue(html.contains("Injury"));
		assertTrue(html.contains("10"));
		assertTrue(html.contains("Parent Signature"));
		assertTrue(html.contains("Nurse Signature"));

		// TRUE branch
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_CHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_CHECKED_END}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_NOTCHECKED_END}"));

		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_CHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_CHECKED_END}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_NOTCHECKED_END}"));
	}

	@Test
	void testGetRHILTPdfFileDetails_ApplicationGivenFalse() throws Exception {

		Form3RhiltDataResp data = new Form3RhiltDataResp();

		data.setStudentName("Jane Doe");
		data.setStudentId(456L);
		data.setStudentSchool("School Two");
		data.setStudentGrade("6");
		data.setInjuryType("Illness");
		data.setLengthOfAbsence("15");
		data.setParentSignature("Parent");
		data.setParentSignDate("08/12/2026");
		data.setReceivedBy("School Nurse");
		data.setNurseSignature("Nurse");
		data.setNurseSignDate("08/12/2026");

		data.setIsApplicationGiven(false);

		File templateFile = new File(tempDir.toFile(), "RHILT_FALSE.html");

		FileUtils.writeStringToFile(templateFile, getRhiltTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHILTPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Jane Doe"));
		assertTrue(html.contains("456"));
		assertTrue(html.contains("School Two"));
		assertTrue(html.contains("Illness"));

		// FALSE branch
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_CHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_CHECKED_END}"));

		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_CHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_CHECKED_END}"));

		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_NOTCHECKED_END}"));

		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_NOTCHECKED_END}"));
	}

	@Test
	void testGetRHILTPdfFileDetails_ApplicationGivenNull() throws Exception {

		Form3RhiltDataResp data = new Form3RhiltDataResp();

		data.setStudentName("Student Three");
		data.setStudentId(789L);
		data.setStudentSchool("School Three");
		data.setStudentGrade("7");
		data.setInjuryType("Other");
		data.setLengthOfAbsence("20");
		data.setParentSignature("Parent Three");
		data.setParentSignDate("08/11/2026");
		data.setReceivedBy("Nurse Three");
		data.setNurseSignature("Nurse Three");
		data.setNurseSignDate("08/11/2026");

		data.setIsApplicationGiven(null);

		File templateFile = new File(tempDir.toFile(), "RHILT_NULL.html");

		FileUtils.writeStringToFile(templateFile, getRhiltTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHILTPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Student Three"));
		assertTrue(html.contains("789"));
		assertTrue(html.contains("School Three"));

		// NULL -> final else branch
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_CHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_CHECKED_END}"));

		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_CHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_CHECKED_END}"));

		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_Y_NOTCHECKED_END}"));

		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_APPLICATION_GIVEN_N_NOTCHECKED_END}"));
	}

	@Test
	void testGetRHILTPdfFileDetails_Exception() throws Exception {

		Form3RhiltDataResp data = new Form3RhiltDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);

		StringBuilder mainHtmlRet = new StringBuilder();

		String invalidTemplatePath = tempDir.resolve("does-not-exist.html").toString();

		assertThrows(HomeInstructionException.class,
				() -> utility.getRHILTPdfFileDetails(data, mainHtmlRet, invalidTemplatePath));

		assertEquals("", mainHtmlRet.toString());
	}

	private String getRhiltTemplate() {

		return "{student_name}" + "{student_id}" + "{school_name}" + "{grade}" + "{injury_type}" + "{length_of_absence}"
				+ "{parent_signature}" + "{parent_sign_date}" + "{received_by}" + "{nurse_signature}"
				+ "{nurse_sign_date}"

				+ "{IS_APPLICATION_GIVEN_Y_CHECKED_START}" + "{IS_APPLICATION_GIVEN_Y_CHECKED_END}"
				+ "{IS_APPLICATION_GIVEN_Y_NOTCHECKED_START}" + "{IS_APPLICATION_GIVEN_Y_NOTCHECKED_END}"

				+ "{IS_APPLICATION_GIVEN_N_CHECKED_START}" + "{IS_APPLICATION_GIVEN_N_CHECKED_END}"
				+ "{IS_APPLICATION_GIVEN_N_NOTCHECKED_START}" + "{IS_APPLICATION_GIVEN_N_NOTCHECKED_END}";
	}

	@Test
	void testGetRHIDTPdfFileDetails_Success_AgreeTrue() throws Exception {

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);
		data.setStudentDob("01/01/2015");
		data.setStudentSchool("Test School");
		data.setPhysicianReview("Physician approved the application");
		data.setHiEndDate("08/31/2026");

		data.setNurseSignature("Nurse Signature");
		data.setNurseSignDate("08/13/2026");

		data.setPhysicianSignDate("08/12/2026");

		data.setIsAgree(true);

		File templateFile = new File(tempDir.toFile(), "RHIDT_TRUE.html");

		FileUtils.writeStringToFile(templateFile, getRhidtTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHIDTPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		// Normal data
		assertTrue(html.contains("John Doe"));
		assertTrue(html.contains("123"));
		assertTrue(html.contains("01/01/2015"));
		assertTrue(html.contains("Test School"));
		assertTrue(html.contains("Physician approved the application"));
		assertTrue(html.contains("08/31/2026"));
		assertTrue(html.contains("Nurse Signature"));
		assertTrue(html.contains("08/13/2026"));
		assertTrue(html.contains("08/12/2026"));

		// Physician signature = populated
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_START}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_END}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_BLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_BLANK_END}"));

		// Physician review = populated
		assertFalse(html.contains("{PHYSICIAN_REVIEW_NOTBLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_NOTBLANK_END}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_BLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_BLANK_END}"));

		// Agree = TRUE
		assertFalse(html.contains("{IS_AGREE_CHECKED_START}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_END}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_START_BLANK}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_END_BLANK}"));

		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_END}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_START_BLANK}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_END_BLANK}"));
	}

	@Test
	void testGetRHIDTPdfFileDetails_Blank_AgreeFalse() throws Exception {

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		data.setStudentName("Jane Doe");
		data.setStudentId(456L);
		data.setStudentDob("02/02/2014");
		data.setStudentSchool("School Two");
		data.setPhysicianReview("");
		data.setHiEndDate("09/30/2026");

		data.setNurseSignature("Nurse Two");
		data.setNurseSignDate("08/13/2026");

		data.setPhysicianSignDate("");

		data.setIsAgree(false);

		File templateFile = new File(tempDir.toFile(), "RHIDT_FALSE.html");

		FileUtils.writeStringToFile(templateFile, getRhidtTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHIDTPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Jane Doe"));
		assertTrue(html.contains("456"));
		assertTrue(html.contains("School Two"));

		// Physician signature = blank
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_START}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_END}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_BLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_BLANK_END}"));

		// Physician review = blank
		assertFalse(html.contains("{PHYSICIAN_REVIEW_NOTBLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_NOTBLANK_END}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_BLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_BLANK_END}"));

		// Agree = FALSE
		assertFalse(html.contains("{IS_AGREE_CHECKED_START}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_END}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_START_BLANK}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_END_BLANK}"));

		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_END}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_START_BLANK}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_END_BLANK}"));

		// Physician sign date is explicitly replaced by empty string
		assertFalse(html.contains("{physician_sign_date}"));
	}

	@Test
	void testGetRHIDTPdfFileDetails_Null_Agree() throws Exception {

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		data.setStudentName("Student Three");
		data.setStudentId(789L);
		data.setStudentDob("03/03/2013");
		data.setStudentSchool("School Three");
		data.setPhysicianReview(null);
		data.setHiEndDate("10/31/2026");

		data.setNurseSignature("Nurse Three");
		data.setNurseSignDate("08/13/2026");

		data.setPhysicianSignDate(null);

		data.setIsAgree(null);

		File templateFile = new File(tempDir.toFile(), "RHIDT_NULL.html");

		FileUtils.writeStringToFile(templateFile, getRhidtTemplate(), StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHIDTPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);

		String html = mainHtmlRet.toString();

		assertTrue(html.contains("Student Three"));
		assertTrue(html.contains("789"));
		assertTrue(html.contains("School Three"));

		// Physician signature blank branch
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_START}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_END}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_BLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_SIGNATURE_BLANK_END}"));

		// Physician review blank branch
		assertFalse(html.contains("{PHYSICIAN_REVIEW_NOTBLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_NOTBLANK_END}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_BLANK_START}"));
		assertFalse(html.contains("{PHYSICIAN_REVIEW_BLANK_END}"));

		// isAgree = NULL -> final else
		assertFalse(html.contains("{IS_AGREE_CHECKED_START}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_END}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_START_BLANK}"));
		assertFalse(html.contains("{IS_AGREE_CHECKED_END_BLANK}"));

		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_START}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_END}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_START_BLANK}"));
		assertFalse(html.contains("{IS_AGREE_NOTCHECKED_END_BLANK}"));
	}

	@Test
	void testGetRHIDTPdfFileDetails_Exception() throws Exception {

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		data.setStudentName("John Doe");
		data.setStudentId(123L);

		StringBuilder mainHtmlRet = new StringBuilder();

		String invalidTemplatePath = tempDir.resolve("does-not-exist.html").toString();

		assertThrows(HomeInstructionException.class,
				() -> utility.getRHIDTPdfFileDetails(data, mainHtmlRet, invalidTemplatePath));

		assertEquals("", mainHtmlRet.toString());
	}

	private String getRhidtTemplate() {

		return "{student_name}" + "{student_id}" + "{student_dob}" + "{school_name}" + "{physician_review}"
				+ "{hi_end_date}" + "{nurse_signature}" + "{nurse_sign_date}" + "{physician_sign_date}"

				+ "{PHYSICIAN_SIGNATURE_START}" + "{PHYSICIAN_SIGNATURE_END}" + "{PHYSICIAN_SIGNATURE_BLANK_START}"
				+ "{PHYSICIAN_SIGNATURE_BLANK_END}"

				+ "{PHYSICIAN_REVIEW_NOTBLANK_START}" + "{PHYSICIAN_REVIEW_NOTBLANK_END}"
				+ "{PHYSICIAN_REVIEW_BLANK_START}" + "{PHYSICIAN_REVIEW_BLANK_END}"

				+ "{IS_AGREE_CHECKED_START}" + "{IS_AGREE_CHECKED_END}" + "{IS_AGREE_CHECKED_START_BLANK}"
				+ "{IS_AGREE_CHECKED_END_BLANK}"

				+ "{IS_AGREE_NOTCHECKED_START}" + "{IS_AGREE_NOTCHECKED_END}" + "{IS_AGREE_NOTCHECKED_START_BLANK}"
				+ "{IS_AGREE_NOTCHECKED_END_BLANK}";
	}

	@Test
	void testGetAPHIMPdfFileDetails_Success_MI_Male_ApproveTrue() throws Exception {

		Form1AphirDataResp data = new Form1AphirDataResp();

		data.setRequestDate("08/06/2026");
		data.setStudentName("John Doe");
		data.setStudentId(1001L);
		data.setStudentDob("01/01/2010");
		data.setStudentSchool("Test School");
		data.setStudentGrade("5");
		data.setParentName("Parent");
		data.setHomePhone("1111111111");
		data.setWorkPhone("2222222222");
		data.setEmergencyPhone("3333333333");
		data.setHomeAddress("Test Address");
		data.setEmailAddress("test@test.com");
		data.setCounselorName("Counselor");
		data.setCounselorPhone("4444444444");
		data.setNurseName("Nurse");
		data.setNursePhone("5555555555");
		data.setAttendanceLastDate("08/01/2026");
		data.setReason("Medical");
		data.setCaseNotification("Yes");
		data.setNotificationDate("08/02/2026");
		data.setParentSignature("Parent Sign");
		data.setParentSignDate("08/03/2026");
		data.setPrincipalSignature("Principal Sign");
		data.setPrincipalSignDate("08/04/2026");
		data.setDirSplEdSignature("Special Ed Sign");
		data.setDirSplEdSignDate("08/04/2026");
		data.setDirSupSignature("Supervisor Sign");
		data.setDirSupSignDate("08/04/2026");
		data.setDirStuLifeService("Student Life");
		data.setDirStuLifeDate("08/04/2026");

		// Physician signature branch - TRUE
		data.setPhysicianSignature("Physician Sign");
		data.setPhysicianSignDate("08/05/2026");

		// Application type branch - MI
		data.setApplicationTypeAbbreviation("MI");

		// Gender branch - Male
		data.setStudentGender("Male");

		// Approval branch - TRUE
		data.setIsApprove(Boolean.TRUE);
		data.setApproveUptoDate("09/01/2026");

		List<Form1AphirScheduleResp> scheduleData = new ArrayList<>();

		for (int i = 0; i < 2; i++) {

			Form1AphirScheduleResp left = new Form1AphirScheduleResp();
			left.setId((long) i);
			left.setScheduleType("L");
			left.setSubject("Math");
			left.setMp1("MP1");
			left.setMp2("MP2");
			left.setMp3("MP3");
			left.setMp4("MP4");

			Form1AphirScheduleResp right = new Form1AphirScheduleResp();
			right.setId((long) i);
			right.setScheduleType("R");
			right.setSubject("Science");
			right.setMp1("MP1");
			right.setMp2("MP2");
			right.setMp3("MP3");
			right.setMp4("MP4");

			scheduleData.add(left);
			scheduleData.add(right);
		}

		// Need ROW_START/ROW_END because scheduleBodyReplace() searches for them.
		String templateContent = "{student_name}{student_id}{student_dob}{school_name}{grade}"
				+ "{PHYSICIAN_SIGNATURE_START}{physician_sign_date}{PHYSICIAN_SIGNATURE_END}"
				+ "{PHYSICIAN_SIGNATURE_BLANK_START}{PHYSICIAN_SIGNATURE_BLANK_END}"
				+ "{APPLICATION_TYPE_MI_CHECKED_START}{APPLICATION_TYPE_MI_CHECKED_END}"
				+ "{APPLICATION_TYPE_MI_NOTCHECKED_START}{APPLICATION_TYPE_MI_NOTCHECKED_END}"
				+ "{APPLICATION_TYPE_AE_CHECKED_START}{APPLICATION_TYPE_AE_CHECKED_END}"
				+ "{APPLICATION_TYPE_AE_NOTCHECKED_START}{APPLICATION_TYPE_AE_NOTCHECKED_END}"
				+ "{STUDENT_GENDER_M_CHECKED_START}{STUDENT_GENDER_M_CHECKED_END}"
				+ "{STUDENT_GENDER_M_NOTCHECKED_START}{STUDENT_GENDER_M_NOTCHECKED_END}"
				+ "{STUDENT_GENDER_F_CHECKED_START}{STUDENT_GENDER_F_CHECKED_END}"
				+ "{STUDENT_GENDER_F_NOTCHECKED_START}{STUDENT_GENDER_F_NOTCHECKED_END}"
				+ "{IS_APPROVE_CHECKED_START}{IS_APPROVE_CHECKED_END}"
				+ "{IS_APPROVE_NOTCHECKED_START}{IS_APPROVE_NOTCHECKED_END}"
				+ "{IS_NOT_APPROVE_NOTCHECKED_START}{IS_NOT_APPROVE_NOTCHECKED_END}"
				+ "{IS_NOT_APPROVE_CHECKED_START}{IS_NOT_APPROVE_CHECKED_END}" + "{approve_upto_date}" + "{ROW_START}"
				+ "{subject_name_mp1_mp2}|{mp1}|{mp2}|{subject_name_mp3_mp4}|{mp3}|{mp4}" + "{ROW_END}";

		File templateFile = File.createTempFile("aphim", ".html");
		FileUtils.writeStringToFile(templateFile, templateContent, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		Utility spyService = Mockito.spy(utility);

		doCallRealMethod().when(spyService).generateBlankScheduleList(anyList(), anyInt());
		doCallRealMethod().when(spyService).scheduleBodyReplace(anyString(), anyList(), anyList());

		boolean result = spyService.getAPHIMPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath(),
				scheduleData);

		assertTrue(result);
		assertNotNull(mainHtmlRet);
		assertTrue(mainHtmlRet.length() > 0);

		templateFile.delete();
	}

	@Test
	void testGetAPHIMPdfFileDetails_Success_AE_Female_ApproveFalse() throws Exception {

		Form1AphirDataResp data = new Form1AphirDataResp();

		data.setStudentName("Jane Doe");
		data.setStudentId(1002L);
		data.setStudentDob("02/02/2010");
		data.setStudentSchool("Test School");
		data.setStudentGrade("6");

		// Physician signature blank
		data.setPhysicianSignature("");
		data.setPhysicianSignDate("");

		// Application type - AE
		data.setApplicationTypeAbbreviation("AE");

		// Gender - Female/anything other than Male
		data.setStudentGender("Female");

		// Approval - FALSE
		data.setIsApprove(Boolean.FALSE);
		data.setApproveUptoDate("09/01/2026");

		List<Form1AphirScheduleResp> scheduleData = new ArrayList<>();

		Form1AphirScheduleResp left = new Form1AphirScheduleResp();
		left.setScheduleType("L");
		left.setSubject("Math");
		left.setMp1("MP1");
		left.setMp2("MP2");

		Form1AphirScheduleResp right = new Form1AphirScheduleResp();
		right.setScheduleType("R");
		right.setSubject("Science");
		right.setMp3("MP3");
		right.setMp4("MP4");

		scheduleData.add(left);
		scheduleData.add(right);

		String templateContent = "{student_name}{student_id}" + "{PHYSICIAN_SIGNATURE_START}{PHYSICIAN_SIGNATURE_END}"
				+ "{PHYSICIAN_SIGNATURE_BLANK_START}{PHYSICIAN_SIGNATURE_BLANK_END}"
				+ "{APPLICATION_TYPE_MI_CHECKED_START}{APPLICATION_TYPE_MI_CHECKED_END}"
				+ "{APPLICATION_TYPE_MI_NOTCHECKED_START}{APPLICATION_TYPE_MI_NOTCHECKED_END}"
				+ "{APPLICATION_TYPE_AE_CHECKED_START}{APPLICATION_TYPE_AE_CHECKED_END}"
				+ "{APPLICATION_TYPE_AE_NOTCHECKED_START}{APPLICATION_TYPE_AE_NOTCHECKED_END}"
				+ "{STUDENT_GENDER_M_CHECKED_START}{STUDENT_GENDER_M_CHECKED_END}"
				+ "{STUDENT_GENDER_M_NOTCHECKED_START}{STUDENT_GENDER_M_NOTCHECKED_END}"
				+ "{STUDENT_GENDER_F_CHECKED_START}{STUDENT_GENDER_F_CHECKED_END}"
				+ "{STUDENT_GENDER_F_NOTCHECKED_START}{STUDENT_GENDER_F_NOTCHECKED_END}"
				+ "{IS_APPROVE_CHECKED_START}{IS_APPROVE_CHECKED_END}"
				+ "{IS_APPROVE_NOTCHECKED_START}{IS_APPROVE_NOTCHECKED_END}"
				+ "{IS_NOT_APPROVE_NOTCHECKED_START}{IS_NOT_APPROVE_NOTCHECKED_END}"
				+ "{IS_NOT_APPROVE_CHECKED_START}{IS_NOT_APPROVE_CHECKED_END}" + "{approve_upto_date}" + "{ROW_START}"
				+ "{subject_name_mp1_mp2}{mp1}{mp2}" + "{subject_name_mp3_mp4}{mp3}{mp4}" + "{ROW_END}";

		File templateFile = File.createTempFile("aphim", ".html");
		FileUtils.writeStringToFile(templateFile, templateContent, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		Utility spyService = Mockito.spy(utility);

		boolean result = spyService.getAPHIMPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath(),
				scheduleData);

		assertTrue(result);
		assertNotNull(mainHtmlRet);
		assertTrue(mainHtmlRet.length() > 0);

		templateFile.delete();
	}

	@Test
	void testGetAPHIMPdfFileDetails_Success_OtherType_NonMale_ApproveNull() throws Exception {

		Form1AphirDataResp data = new Form1AphirDataResp();

		data.setStudentName("Test Student");
		data.setStudentId(1003L);
		data.setStudentDob("03/03/2010");
		data.setStudentSchool("Test School");
		data.setStudentGrade("7");

		// Physician signature present
		data.setPhysicianSignature("Doctor Signature");
		data.setPhysicianSignDate("08/05/2026");

		// Neither MI nor AE -> final else
		data.setApplicationTypeAbbreviation("XX");

		// Anything other than Male -> else
		data.setStudentGender("Other");

		// null -> final else
		data.setIsApprove(null);
		data.setApproveUptoDate(null);

		List<Form1AphirScheduleResp> scheduleData = new ArrayList<>();

		String templateContent = "{student_name}{student_id}" + "{PHYSICIAN_SIGNATURE_START}{PHYSICIAN_SIGNATURE_END}"
				+ "{PHYSICIAN_SIGNATURE_BLANK_START}{PHYSICIAN_SIGNATURE_BLANK_END}"
				+ "{APPLICATION_TYPE_MI_CHECKED_START}{APPLICATION_TYPE_MI_CHECKED_END}"
				+ "{APPLICATION_TYPE_MI_NOTCHECKED_START}{APPLICATION_TYPE_MI_NOTCHECKED_END}"
				+ "{APPLICATION_TYPE_AE_CHECKED_START}{APPLICATION_TYPE_AE_CHECKED_END}"
				+ "{APPLICATION_TYPE_AE_NOTCHECKED_START}{APPLICATION_TYPE_AE_NOTCHECKED_END}"
				+ "{STUDENT_GENDER_M_CHECKED_START}{STUDENT_GENDER_M_CHECKED_END}"
				+ "{STUDENT_GENDER_M_NOTCHECKED_START}{STUDENT_GENDER_M_NOTCHECKED_END}"
				+ "{STUDENT_GENDER_F_CHECKED_START}{STUDENT_GENDER_F_CHECKED_END}"
				+ "{STUDENT_GENDER_F_NOTCHECKED_START}{STUDENT_GENDER_F_NOTCHECKED_END}"
				+ "{IS_APPROVE_CHECKED_START}{IS_APPROVE_CHECKED_END}"
				+ "{IS_APPROVE_NOTCHECKED_START}{IS_APPROVE_NOTCHECKED_END}"
				+ "{IS_NOT_APPROVE_NOTCHECKED_START}{IS_NOT_APPROVE_NOTCHECKED_END}"
				+ "{IS_NOT_APPROVE_CHECKED_START}{IS_NOT_APPROVE_CHECKED_END}" + "{approve_upto_date}" + "{ROW_START}"
				+ "{subject_name_mp1_mp2}{mp1}{mp2}" + "{subject_name_mp3_mp4}{mp3}{mp4}" + "{ROW_END}";

		File templateFile = File.createTempFile("aphim", ".html");
		FileUtils.writeStringToFile(templateFile, templateContent, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		Utility spyService = Mockito.spy(utility);

		boolean result = spyService.getAPHIMPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath(),
				scheduleData);

		assertTrue(result);
		assertNotNull(mainHtmlRet);
		assertTrue(mainHtmlRet.length() > 0);

		templateFile.delete();
	}

	@Test
	void testGetAPHIMPdfFileDetails_Exception() throws Exception {

		Form1AphirDataResp data = new Form1AphirDataResp();

		data.setStudentId(1001L);
		data.setStudentName("Test Student");

		StringBuilder mainHtmlRet = new StringBuilder();

		List<Form1AphirScheduleResp> scheduleData = new ArrayList<>();

		assertThrows(HomeInstructionException.class,
				() -> utility.getAPHIMPdfFileDetails(data, mainHtmlRet, "invalid-template-path.html", scheduleData));
	}

	@Test
	void testDownloadPdfForm_APHIM() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form1AphirDataResp data = new Form1AphirDataResp();
		StringBuilder mainHtml = new StringBuilder();
		List<Form1AphirScheduleResp> scheduleData = new ArrayList<>();

		doReturn(true).when(spyService).getAPHIMPdfFileDetails(any(Form1AphirDataResp.class), any(StringBuilder.class),
				anyString(), anyList());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "APHIM", "template.html", scheduleData);

		assertTrue(result);

		verify(spyService).getAPHIMPdfFileDetails(any(Form1AphirDataResp.class), any(StringBuilder.class),
				eq("template.html"), eq(scheduleData));
	}

	@Test
	void testDownloadPdfForm_RHIDT() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doReturn(true).when(spyService).getRHIDTPdfFileDetails(any(Form2RHIDTDataResp.class), any(StringBuilder.class),
				anyString());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "RHIDT", "template.html", null);

		assertTrue(result);

		verify(spyService).getRHIDTPdfFileDetails(any(Form2RHIDTDataResp.class), any(StringBuilder.class),
				eq("template.html"));
	}

	@Test
	void testDownloadPdfForm_RHILT() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form3RhiltDataResp data = new Form3RhiltDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doReturn(true).when(spyService).getRHILTPdfFileDetails(any(Form3RhiltDataResp.class), any(StringBuilder.class),
				anyString());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "RHILT", "template.html", null);

		assertTrue(result);

		verify(spyService).getRHILTPdfFileDetails(any(Form3RhiltDataResp.class), any(StringBuilder.class),
				eq("template.html"));
	}

	@Test
	void testDownloadPdfForm_PRTHI() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form4PrthiDataResp data = new Form4PrthiDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doReturn(true).when(spyService).getPRTHIPdfFileDetails(any(Form4PrthiDataResp.class), any(StringBuilder.class),
				anyString());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "PRTHI", "template.html", null);

		assertTrue(result);

		verify(spyService).getPRTHIPdfFileDetails(any(Form4PrthiDataResp.class), any(StringBuilder.class),
				eq("template.html"));
	}

	@Test
	void testDownloadPdfForm_LAHIT() throws Exception {

		Utility spyService = Mockito.spy(utility);

		boolean result = spyService.downloadPdfForm(new Object(), new StringBuilder(), "LAHIT", "template.html", null);

		assertFalse(result);
	}

	@Test
	void testDownloadPdfForm_30DHI() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form630DhiDataResp data = new Form630DhiDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doReturn(true).when(spyService).get30DHIPdfFileDetails(any(Form630DhiDataResp.class), any(StringBuilder.class),
				anyString());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "30DHI", "template.html", null);

		assertTrue(result);

		verify(spyService).get30DHIPdfFileDetails(any(Form630DhiDataResp.class), any(StringBuilder.class),
				eq("template.html"));
	}

	@Test
	void testDownloadPdfForm_60DHI() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form760DhiDataResp data = new Form760DhiDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doReturn(true).when(spyService).get760DHIPdfFileDetails(any(Form760DhiDataResp.class), any(StringBuilder.class),
				anyString());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "60DHI", "template.html", null);

		assertTrue(result);

		verify(spyService).get760DHIPdfFileDetails(any(Form760DhiDataResp.class), any(StringBuilder.class),
				eq("template.html"));
	}

	@Test
	void testDownloadPdfForm_HISCP() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form8HiscpDataResp data = new Form8HiscpDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doReturn(true).when(spyService).getHISCPPdfFileDetails(any(Form8HiscpDataResp.class), any(StringBuilder.class),
				anyString());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "HISCP", "template.html", null);

		assertTrue(result);

		verify(spyService).getHISCPPdfFileDetails(any(Form8HiscpDataResp.class), any(StringBuilder.class),
				eq("template.html"));
	}

	@Test
	void testDownloadPdfForm_EAPP() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form9EAPPDataResp data = new Form9EAPPDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doReturn(true).when(spyService).getEAPPPdfFileDetails(any(Form9EAPPDataResp.class), any(StringBuilder.class),
				anyString());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "EAPP", "template.html", null);

		assertTrue(result);

		verify(spyService).getEAPPPdfFileDetails(any(Form9EAPPDataResp.class), any(StringBuilder.class),
				eq("template.html"));
	}

	@Test
	void testDownloadPdfForm_HSAPP() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form10HSAPPDataResp data = new Form10HSAPPDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doReturn(true).when(spyService).getHSAPPdfFileDetails(any(Form10HSAPPDataResp.class), any(StringBuilder.class),
				anyString());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "HSAPP", "template.html", null);

		assertTrue(result);

		verify(spyService).getHSAPPdfFileDetails(any(Form10HSAPPDataResp.class), any(StringBuilder.class),
				eq("template.html"));
	}

	@Test
	void testDownloadPdfForm_Default() throws Exception {

		Utility spyService = Mockito.spy(utility);

		boolean result = spyService.downloadPdfForm(new Object(), new StringBuilder(), "INVALID", "template.html",
				null);

		assertFalse(result);
	}

	@Test
	void testDownloadPdfForm_HomeInstructionException() throws Exception {

		Utility spyService = Mockito.spy(utility);

		Form1AphirDataResp data = new Form1AphirDataResp();
		StringBuilder mainHtml = new StringBuilder();

		doThrow(new HomeInstructionException("Test Exception", "Internal Server Error")).when(spyService)
				.getAPHIMPdfFileDetails(any(Form1AphirDataResp.class), any(StringBuilder.class), anyString(),
						anyList());

		boolean result = spyService.downloadPdfForm(data, mainHtml, "APHIM", "template.html", new ArrayList<>());

		assertFalse(result);
	}

}