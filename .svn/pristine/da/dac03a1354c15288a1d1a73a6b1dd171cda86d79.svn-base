package com.jcboe.home.instruction.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.Form10Request;
import com.jcboe.home.instruction.model.request.Form1Request;
import com.jcboe.home.instruction.model.request.Form2Request;
import com.jcboe.home.instruction.model.request.Form3Request;
import com.jcboe.home.instruction.model.request.Form4Request;
import com.jcboe.home.instruction.model.request.Form630DHIRequest;
import com.jcboe.home.instruction.model.request.Form760DHIRequest;
import com.jcboe.home.instruction.model.request.Form8Request;
import com.jcboe.home.instruction.model.request.Form9Request;
import com.jcboe.home.instruction.model.request.GetStudentInfoReqById;
import com.jcboe.home.instruction.model.request.UpdateHIActivityReq;
import com.jcboe.home.instruction.model.request.UpdateHIApplicationReq;
import com.jcboe.home.instruction.model.request.UploadFormDocumentReq;
import com.jcboe.home.instruction.repo.AppConfigRepo;
import com.jcboe.home.instruction.repo.ApplicationListRepo;
import com.jcboe.home.instruction.repo.HomeInstructionRepo;
import com.jcboe.home.instruction.repo.UserDetailsRepo;
import com.jcboe.home.instruction.response.ApplicationInfoResp;
import com.jcboe.home.instruction.response.FileUploadResp;
import com.jcboe.home.instruction.response.Form10HSAPPDataResp;
import com.jcboe.home.instruction.response.Form10HSAPPResponseDTO;
import com.jcboe.home.instruction.response.Form1APHIRResponseDTO;
import com.jcboe.home.instruction.response.Form1AphirDataResp;
import com.jcboe.home.instruction.response.Form1AphirResp;
import com.jcboe.home.instruction.response.Form1AphirScheduleResp;
import com.jcboe.home.instruction.response.Form2RHIDTDataResp;
import com.jcboe.home.instruction.response.Form2RHIDTResponseDTO;
import com.jcboe.home.instruction.response.Form2RhidtResp;
import com.jcboe.home.instruction.response.Form3RhiltDataResp;
import com.jcboe.home.instruction.response.Form3RhiltResp;
import com.jcboe.home.instruction.response.Form3RhiltResponseDTO;
import com.jcboe.home.instruction.response.Form4PrthiDataResp;
import com.jcboe.home.instruction.response.Form4PrthiResp;
import com.jcboe.home.instruction.response.Form4PrthiResponseDTO;
import com.jcboe.home.instruction.response.Form630DHIResp;
import com.jcboe.home.instruction.response.Form630DhiDataResp;
import com.jcboe.home.instruction.response.Form630DhiResponseDTO;
import com.jcboe.home.instruction.response.Form760DhiDataResp;
import com.jcboe.home.instruction.response.Form760DhiResp;
import com.jcboe.home.instruction.response.Form760DhiResponseDTO;
import com.jcboe.home.instruction.response.Form8HiscpDataResp;
import com.jcboe.home.instruction.response.Form8HiscpResp;
import com.jcboe.home.instruction.response.Form8HiscpResponseDTO;
import com.jcboe.home.instruction.response.Form9EAPPDataResp;
import com.jcboe.home.instruction.response.Form9EAPPPlanDataResp;
import com.jcboe.home.instruction.response.Form9EAPPResp;
import com.jcboe.home.instruction.response.Form9EAPPResponseDTO;
import com.jcboe.home.instruction.response.GetPhysicianInfoResp;
import com.jcboe.home.instruction.response.GetStudentParentInfoResp;
import com.jcboe.home.instruction.response.HIActivityResponseDTO;
import com.jcboe.home.instruction.response.HIFormTransactionResp;
import com.jcboe.home.instruction.response.LookupDetails;
import com.jcboe.home.instruction.response.NotificationList;
import com.jcboe.home.instruction.response.StudentDataResp;
import com.jcboe.home.instruction.response.UpdateHIActivityResp;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@ExtendWith(MockitoExtension.class)
class HomeInstructionServiceImplTest {

	@Spy
	@InjectMocks
	private HomeInstructionServiceImpl formServiceImpl;
	private AppConfigServiceImpl appConfigServiceImpl;
	private ApplicationListServiceImpl applicationListServiceImpl;

	@Mock
	private HomeInstructionRepo formRepo;

	@Mock
	private AppConfigRepo appConfigRepo;

	@Mock
	private Utility utility;

	@Mock
	private FileUploadServiceImpl fileUploadService;

	@Mock
	private UserDetailsRepo userDetailsRepo;

	@Mock
	private ApplicationListRepo applicationListRepo;

	@Mock
	private HomeInstructionRepo homeInstructionRepo;

	@Mock
	private MultipartFile multipartFile;

	private Form760DHIRequest request;

	@BeforeEach
	void setup() {

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-04");

		Map<String, String> configMap = new HashMap<>();
		configMap.put("FILETMPL", "/tmp");
		configMap.put("TEMPL_PATH", "/tmp");
		configMap.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.getConfigList(anyString())).thenReturn(configMap);

		when(utility.getConfigList(anyString())).thenReturn(configMap);

		formServiceImpl = new HomeInstructionServiceImpl(formRepo, utility, fileUploadService,
				userDetailsRepo, applicationListRepo, appConfigRepo);
	}

	@TempDir
	Path tempDir;

	@Test
	void testGetStudentInfoByStudentId_Success() throws Exception {

		GetStudentInfoReqById req = new GetStudentInfoReqById();

		when(appConfigRepo.getStudentData("", null)).thenReturn(new ArrayList<StudentDataResp>());
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		GetStudentParentInfoResp response = appConfigServiceImpl.getStudentInfoByStudentId(req);

	}

	@Test
	void testGetStudentInfoByStudentId_StudentFormRespNullElement() throws Exception {
		GetStudentInfoReqById req = new GetStudentInfoReqById();

		List<StudentDataResp> listWithNullElement = new ArrayList<>();
		listWithNullElement.add(null);

		when(appConfigRepo.getStudentData("", null)).thenReturn(listWithNullElement);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		assertThrows(NullPointerException.class, () -> appConfigServiceImpl.getStudentInfoByStudentId(req));
	}

	@Test
	void testGetStudentInfoByStudentId_EmptyList() throws Exception {

		GetStudentInfoReqById req = new GetStudentInfoReqById();

		when(appConfigRepo.getStudentData("", null)).thenReturn(new ArrayList<>());
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		GetStudentParentInfoResp response = appConfigServiceImpl.getStudentInfoByStudentId(req);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertTrue(response.getStudentInfoList().isEmpty());
	}

	@Test
	void testGetStudentInfoByStudentId_NonEmptyList() throws Exception {

		GetStudentInfoReqById req = new GetStudentInfoReqById();

		List<StudentDataResp> list = new ArrayList<>();
		StudentDataResp studentData = new StudentDataResp();
		list.add(studentData);

		when(appConfigRepo.getStudentData("", null)).thenReturn(list);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		GetStudentParentInfoResp response = appConfigServiceImpl.getStudentInfoByStudentId(req);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(1, response.getStudentInfoList().size());
	}

	@Test
	void testGetForm1ApiHir_Success() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;

		List<Form1AphirDataResp> data = new ArrayList<>();
		data.add(new Form1AphirDataResp());

		List<Form1AphirScheduleResp> schedule = new ArrayList<>();

		when(formRepo.getForm1AphirData(id, applicationId, null)).thenReturn(data);
		when(formRepo.getForm1AphirScheduleData(id)).thenReturn(schedule);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		Form1APHIRResponseDTO response = formServiceImpl.getForm1ApiHir(id, applicationId, id, "loggedInUserId", "PRNT",
				"config keys", "lookupValues", true);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertNotNull(response.getAttachmentList());
		assertNotNull(response.getConfigList());
		assertNotNull(response.getLookupList());
		assertNotNull(response.getStudentList());
		assertNotNull(response.getStudentList());

		verify(formRepo).getForm1AphirData(id, applicationId, null);
		verify(formRepo).getForm1AphirScheduleData(id);
	}

	@Test
	void testGetForm1ApiHir_NoData() {

		Long id = 1L;
		Long applicationId = 1L;

		when(formRepo.getForm1AphirData(id, applicationId, null)).thenReturn(new ArrayList<>());
		when(formRepo.getForm1AphirScheduleData(id)).thenReturn(new ArrayList<>());
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		Form1APHIRResponseDTO response = formServiceImpl.getForm1ApiHir(id, applicationId, null, null, null, null, null,
				false);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(formRepo).getForm1AphirData(id, applicationId, null);
	}

	@Test
	public void testGetForm1ApiHir_lookupValuesNotBlank() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;

		Form1AphirDataResp appInfo = mock(Form1AphirDataResp.class);

		when(homeInstructionRepo.getForm1AphirData(id, applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		when(userDetailsRepo.getLookupValues("ABC")).thenReturn(new ArrayList<LookupDetails>());

		formServiceImpl.getForm1ApiHir(id, applicationId, 56L, "", "", "ABC", null, false);

		verify(userDetailsRepo).getLookupValues("ABC");
	}

	@Test
	public void testGetForm1ApiHir_lookupValuesBlank() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;
		Form1AphirDataResp appInfo = mock(Form1AphirDataResp.class);

		when(homeInstructionRepo.getForm1AphirData(id, applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		formServiceImpl.getForm1ApiHir(id, applicationId, null, null, null, null, null, false);

		verify(userDetailsRepo, never()).getLookupValues(anyString());
	}

	@Test
	public void testGetForm1ApiHir_configKeysNotBlank() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;

		Form1AphirDataResp appInfo = mock(Form1AphirDataResp.class);

		when(homeInstructionRepo.getForm1AphirData(id, applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		Map<String, String> configMap = new HashMap<>();
		configMap.put("ABC", "VALUE");

		when(utility.getConfigList("ABC")).thenReturn(configMap);

		formServiceImpl.getForm1ApiHir(id, applicationId, null, null, "ABC", null, null, false);

		verify(utility).getConfigList("ABC");
	}

	@Test
	public void testGetForm1ApiHir_configKeysBlank() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;

		Form1AphirDataResp appInfo = mock(Form1AphirDataResp.class);

		when(homeInstructionRepo.getForm1AphirData(id, applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		formServiceImpl.getForm1ApiHir(id, applicationId, null, null, "ABC", null, null, false);

		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	public void testGetForm1ApiHir_studentList() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		boolean isStudent = true;
		String loggedInUserId = "";

		Form1AphirDataResp appInfo = mock(Form1AphirDataResp.class);

		List<StudentDataResp> studentList = new ArrayList<>();

		when(appConfigRepo.getStudentData("", loggedInUserId)).thenReturn(studentList);

		when(homeInstructionRepo.getForm1AphirData(id, applicationId, loggedInUserId))
				.thenReturn(Collections.singletonList(appInfo));

		Form1APHIRResponseDTO response = formServiceImpl.getForm1ApiHir(id, applicationId, 1L, "ABC", "ABC", "ABC",
				loggedInUserId, isStudent);

		assertNotNull(response);
		assertNotNull(studentList);
		assertTrue(response.isSuccess());

		verify(formRepo).getForm1AphirData(id, applicationId, loggedInUserId);
	}

	@Test
	void testGetForm1ApiHir_Exception() {

		Long id = 1L;
		Long applicationId = 100L;

		when(formRepo.getForm1AphirData(id, applicationId, null)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.getForm1ApiHir(id, applicationId, 45L, "", "", "", null, false));
	}

	@Test
	void testGetRHIDTPdfFileDetails_PhysicianSigned_AgreeTrue() throws Exception {

		// Create dummy template file
		Path templateFile = tempDir.resolve("template.html");

		String htmlTemplate = "<html>{student_name}{student_dob}{school_name}{physician_review}{hi_end_date}{nurse_signature}{nurse_sign_date}{physician_sign_date}</html>";

		Files.write(templateFile, htmlTemplate.getBytes(StandardCharsets.UTF_8));

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		data.setStudentName("John Doe");
		data.setStudentDob("01-01-2010");
		data.setStudentSchool("ABC School");
		data.setPhysicianReview("Approved");
		data.setHiEndDate("2026-12-31");
		data.setNurseSignature("Nurse Sign");
		data.setNurseSignDate("2026-08-04");
		data.setPhysicianSignDate("2026-08-04");
		data.setIsAgree(true);

		StringBuilder modifiedTemplateRet = new StringBuilder();
		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHIDTPdfFileDetails(data, mainHtmlRet, templateFile.toString());

		assertTrue(result);

		assertNotNull(mainHtmlRet.toString());

		assertTrue(mainHtmlRet.toString().contains("John Doe"));

		assertTrue(mainHtmlRet.toString().contains("Approved"));

		assertTrue(mainHtmlRet.toString().contains("2026-08-04"));
	}

	@Test
	void testGetRHIDTPdfFileDetails_PhysicianNotSigned_AgreeFalse() throws Exception {

		Path templateFile = tempDir.resolve("template.html");

		String htmlTemplate = "{PHYSICIAN_SIGNATURE_START}{Physician Signature}{PHYSICIAN_SIGNATURE_END}{IS_AGREE_NOTCHECKED_START}Not Agree{IS_AGREE_NOTCHECKED_END}";

		Files.write(templateFile, htmlTemplate.getBytes(StandardCharsets.UTF_8));

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		data.setStudentName("Test Student");
		data.setPhysicianSignDate("");
		data.setPhysicianReview("");
		data.setIsAgree(false);

		StringBuilder modifiedTemplateRet = new StringBuilder();
		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHIDTPdfFileDetails(data, mainHtmlRet, templateFile.toString());

		assertTrue(result);

		assertNotNull(mainHtmlRet.toString());

		assertFalse(mainHtmlRet.toString().contains("{PHYSICIAN_SIGNATURE_START}"));

	}

	@Test
	void testGetRHIDTPdfFileDetails_FileNotFound_Exception() {

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		StringBuilder modifiedTemplateRet = new StringBuilder();
		StringBuilder mainHtmlRet = new StringBuilder();

		assertThrows(HomeInstructionException.class,
				() -> utility.getRHIDTPdfFileDetails(data, mainHtmlRet, "invalid-template.html"));
	}

	@Test
	void testGetForm2RHIDT_WithData() throws Exception {

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		when(formRepo.getForm2RHIDTData(1L, 1L)).thenReturn(Arrays.asList(data));

		Form2RHIDTResponseDTO response = formServiceImpl.getForm2RHIDT(1L, 1L, "CONFIG", "LOOKUP");

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(data, response.getform2RHIDTDataResp());

		verify(formRepo).getForm2RHIDTData(1L, 1L);

		verify(userDetailsRepo).getLookupValues("LOOKUP");
	}

	@Test
	void testGetForm2RHIDT_NoData() {

		when(formRepo.getForm2RHIDTData(1L, 1L)).thenReturn(Collections.emptyList());

		Form2RHIDTResponseDTO response = formServiceImpl.getForm2RHIDT(1L, 1L, null, null);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertNull(response.getform2RHIDTDataResp());
	}

	@Test
	void testGetForm3Rhilt_Success() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		String configKeys = "KEY1,KEY2";
		String lookupValues = "STATUS";

		List<LookupDetails> lookupTypeList = new ArrayList<>();
		LookupDetails lookupDetails = new LookupDetails();
		lookupTypeList.add(lookupDetails);

		Map<String, String> configKeyList = new HashMap<>();
		configKeyList.put("KEY1", "VALUE1");
		configKeyList.put("KEY2", "VALUE2");

		List<Form3RhiltDataResp> form3AphirDataResp = new ArrayList<>();
		Form3RhiltDataResp form3Data = Mockito.mock(Form3RhiltDataResp.class);
		form3AphirDataResp.add(form3Data);

		Mockito.when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupTypeList);

		Mockito.when(utility.getConfigList(configKeys)).thenReturn(configKeyList);

		Mockito.when(homeInstructionRepo.getForm3RhiltData(id, applicationId)).thenReturn(form3AphirDataResp);

		Mockito.when(utility.responseDate(Mockito.any(LocalDateTime.class))).thenReturn("2026-09-02");

		Form3RhiltResponseDTO result = formServiceImpl.getForm3Rhilt(id, applicationId, configKeys, lookupValues);

		assertNotNull(result);

		assertEquals(true, result.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GFC_RFS), result.getMessage());

		assertNotNull(result);

		Mockito.verify(userDetailsRepo, Mockito.times(1)).getLookupValues(lookupValues);

		Mockito.verify(utility, Mockito.times(1)).getConfigList(configKeys);

		Mockito.verify(homeInstructionRepo, Mockito.times(1)).getForm3RhiltData(id, applicationId);
	}

	@Test
	void testGetForm3Rhilt_EmptyResult() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		String configKeys = "KEY1,KEY2";
		String lookupValues = "STATUS";

		List<LookupDetails> lookupTypeList = new ArrayList<>();

		Map<String, String> configKeyList = new HashMap<>();
		configKeyList.put("KEY1", "VALUE1");

		Mockito.when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupTypeList);

		Mockito.when(utility.getConfigList(configKeys)).thenReturn(configKeyList);

		Mockito.when(homeInstructionRepo.getForm3RhiltData(id, applicationId)).thenReturn(new ArrayList<>());

		Mockito.when(utility.responseDate(Mockito.any(LocalDateTime.class))).thenReturn("2026-09-02");

		Form3RhiltResponseDTO result = formServiceImpl.getForm3Rhilt(id, applicationId, configKeys, lookupValues);

		assertNotNull(result);

		assertEquals(true, result.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GFC_RNF), result.getMessage());

		assertNull(result.getForm3RhiltDataResp());

		Mockito.verify(userDetailsRepo, Mockito.times(1)).getLookupValues(lookupValues);

		Mockito.verify(utility, Mockito.times(1)).getConfigList(configKeys);

		Mockito.verify(homeInstructionRepo, Mockito.times(1)).getForm3RhiltData(id, applicationId);
	}

	@Test
	void testGetForm3Rhilt_BlankConfigAndLookupValues() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		String configKeys = "";
		String lookupValues = "";

		List<Form3RhiltDataResp> form3AphirDataResp = new ArrayList<>();

		Form3RhiltDataResp form3Data = Mockito.mock(Form3RhiltDataResp.class);
		form3AphirDataResp.add(form3Data);

		Mockito.when(homeInstructionRepo.getForm3RhiltData(id, applicationId)).thenReturn(form3AphirDataResp);

		Mockito.when(utility.responseDate(Mockito.any(LocalDateTime.class))).thenReturn("2026-09-02");

		Form3RhiltResponseDTO result = formServiceImpl.getForm3Rhilt(id, applicationId, configKeys, lookupValues);

		assertNotNull(result);

		assertEquals(true, result.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GFC_RFS), result.getMessage());

		assertNotNull(result.getForm3RhiltDataResp());

		Mockito.verify(userDetailsRepo, Mockito.never()).getLookupValues(Mockito.anyString());

		Mockito.verify(utility, Mockito.never()).getConfigList(Mockito.anyString());

		Mockito.verify(homeInstructionRepo, Mockito.times(1)).getForm3RhiltData(id, applicationId);
	}

	@Test
	void testGetForm3Rhilt_Exception() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		String configKeys = "KEY1";
		String lookupValues = "STATUS";

		Mockito.when(userDetailsRepo.getLookupValues(lookupValues)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.getForm3Rhilt(id, applicationId, configKeys, lookupValues));

		Mockito.verify(userDetailsRepo, Mockito.times(1)).getLookupValues(lookupValues);

		Mockito.verify(homeInstructionRepo, Mockito.never()).getForm3RhiltData(Mockito.anyLong(), Mockito.anyLong());
	}

	@Test
	void testGetForm4Prthi_WithLookupAndConfigData() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;
		String configKeys = "KEY1,KEY2";
		String lookupValues = "LOOKUP1,LOOKUP2";

		List<LookupDetails> lookupTypeList = new ArrayList<>();
		lookupTypeList.add(mock(LookupDetails.class));

		Map<String, String> configKeyList = new HashMap<>();
		configKeyList.put("KEY1", "VALUE1");

		Form4PrthiDataResp formData = new Form4PrthiDataResp();

		List<Form4PrthiDataResp> formDataList = new ArrayList<>();
		formDataList.add(formData);

		doReturn(lookupTypeList).when(userDetailsRepo).getLookupValues(lookupValues);

		doReturn(configKeyList).when(utility).getConfigList(configKeys);

		doReturn(formDataList).when(homeInstructionRepo).getForm4PrthiData(id, applicationId);

		Form4PrthiResponseDTO result = formServiceImpl.getForm4Prthi(id, applicationId, configKeys, lookupValues);

		assertNotNull(result);

		verify(userDetailsRepo).getLookupValues(lookupValues);
		verify(utility).getConfigList(configKeys);
		verify(homeInstructionRepo).getForm4PrthiData(id, applicationId);
	}

	@Test
	void testGetForm4Prthi_WithBlankLookupAndConfigKeys() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;
		String configKeys = "";
		String lookupValues = "";

		List<Form4PrthiDataResp> formDataList = new ArrayList<>();

		doReturn(formDataList).when(homeInstructionRepo).getForm4PrthiData(id, applicationId);

		Form4PrthiResponseDTO result = formServiceImpl.getForm4Prthi(id, applicationId, configKeys, lookupValues);

		assertNotNull(result);

		verify(homeInstructionRepo).getForm4PrthiData(id, applicationId);

		verify(userDetailsRepo, never()).getLookupValues(anyString());
		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetForm4Prthi_WhenDataNotFound() {

		Long id = 1L;
		Long applicationId = 1L;
		String configKeys = "";
		String lookupValues = "";

		List<Form4PrthiDataResp> formDataList = new ArrayList<>();

		doReturn(formDataList).when(homeInstructionRepo).getForm4PrthiData(id, applicationId);

		Form4PrthiResponseDTO result = formServiceImpl.getForm4Prthi(id, applicationId, configKeys, lookupValues);

		assertNotNull(result);

		verify(homeInstructionRepo).getForm4PrthiData(id, applicationId);
	}

	@Test
	void testGetForm4Prthi_WhenLookupValuesProvided() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;
		String configKeys = "";
		String lookupValues = "LOOKUP1";

		List<LookupDetails> lookupTypeList = new ArrayList<>();
		lookupTypeList.add(mock(LookupDetails.class));

		List<Form4PrthiDataResp> formDataList = new ArrayList<>();
		formDataList.add(new Form4PrthiDataResp());

		doReturn(lookupTypeList).when(userDetailsRepo).getLookupValues(lookupValues);

		doReturn(formDataList).when(homeInstructionRepo).getForm4PrthiData(id, applicationId);

		Form4PrthiResponseDTO result = formServiceImpl.getForm4Prthi(id, applicationId, configKeys, lookupValues);

		assertNotNull(result);

		verify(userDetailsRepo).getLookupValues(lookupValues);
		verify(homeInstructionRepo).getForm4PrthiData(id, applicationId);

		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetForm4Prthi_WhenConfigKeysProvided() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;
		String configKeys = "KEY1,KEY2";
		String lookupValues = "";

		Map<String, String> configKeyList = new HashMap<>();
		configKeyList.put("KEY1", "VALUE1");

		List<Form4PrthiDataResp> formDataList = new ArrayList<>();
		formDataList.add(new Form4PrthiDataResp());

		doReturn(configKeyList).when(utility).getConfigList(configKeys);

		doReturn(formDataList).when(homeInstructionRepo).getForm4PrthiData(id, applicationId);

		Form4PrthiResponseDTO result = formServiceImpl.getForm4Prthi(id, applicationId, configKeys, lookupValues);

		assertNotNull(result);

		verify(utility).getConfigList(configKeys);
		verify(homeInstructionRepo).getForm4PrthiData(id, applicationId);

		verify(userDetailsRepo, never()).getLookupValues(anyString());
	}

	@Test
	void testGetForm4Prthi_Exception() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		String configKeys = "KEY1";
		String lookupValues = "STATUS";

		Mockito.when(userDetailsRepo.getLookupValues(lookupValues)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.getForm4Prthi(id, applicationId, configKeys, lookupValues));

		Mockito.verify(userDetailsRepo, Mockito.times(1)).getLookupValues(lookupValues);

		Mockito.verify(homeInstructionRepo, Mockito.never()).getForm4PrthiData(Mockito.anyLong(), Mockito.anyLong());
	}

	@Test
	void testGetForm630dhi_WhenDataExists() throws Exception {

		Long id = 1L;
		String configKeys = "KEY1,KEY2";
		String lookupValues = "LOOKUP1,LOOKUP2";

		LookupDetails lookupDetails = new LookupDetails();

		List<LookupDetails> lookupTypeList = new ArrayList<>();
		lookupTypeList.add(lookupDetails);

		Map<String, String> configKeyList = new HashMap<>();
		configKeyList.put("KEY1", "VALUE1");

		Form630DhiDataResp formData = new Form630DhiDataResp();

		List<Form630DhiDataResp> formDataList = new ArrayList<>();
		formDataList.add(formData);

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupTypeList);

		when(utility.getConfigList(configKeys)).thenReturn(configKeyList);

		when(homeInstructionRepo.getForm630dhiData(id)).thenReturn(formDataList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-14");

		Form630DhiResponseDTO result = formServiceImpl.getForm630dhi(id, configKeys, lookupValues);

		assertNotNull(result);

		assertEquals(Constant.getMessageMap().get(Constant.GFE_RFS), result.getMessage());

		assertEquals("2026-08-14", result.getAccessedOn());

		verify(userDetailsRepo).getLookupValues(lookupValues);

		verify(utility).getConfigList(configKeys);

		verify(utility).responseDate(any(LocalDateTime.class));

		verify(homeInstructionRepo).getForm630dhiData(id);
	}

	@Test
	void testGetForm630dhi_WhenDataNotFound() throws Exception {

		Long id = 1L;

		Form630DhiResponseDTO result = formServiceImpl.getForm630dhi(id, "", "");

		Form630DhiDataResp formData = new Form630DhiDataResp();

		List<Form630DhiDataResp> formDataList = Collections.singletonList(formData);

		when(homeInstructionRepo.getForm630dhiData(id)).thenReturn(formDataList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-14");

		assertNotNull(result);

		assertEquals(Constant.getMessageMap().get(Constant.GFE_RNF), result.getMessage());

		assertEquals("2026-08-14", result.getAccessedOn());

		verify(homeInstructionRepo).getForm630dhiData(id);

		verify(userDetailsRepo, never()).getLookupValues(anyString());

		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetForm630dhi_WhenLookupValuesProvided() throws Exception {

		Long id = 1L;
		String lookupValues = "LOOKUP1";

		List<LookupDetails> lookupList = Collections.singletonList(new LookupDetails());

		List<Form630DhiDataResp> formDataList = Collections.singletonList(new Form630DhiDataResp());

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupList);

		when(homeInstructionRepo.getForm630dhiData(id)).thenReturn(formDataList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-14");

		Form630DhiResponseDTO result = formServiceImpl.getForm630dhi(id, "", lookupValues);

		assertNotNull(result);

		assertEquals(Constant.getMessageMap().get(Constant.GFE_RFS), result.getMessage());

		verify(userDetailsRepo).getLookupValues(lookupValues);

		verify(homeInstructionRepo).getForm630dhiData(id);

		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetForm630dhi_WhenConfigKeysProvided() throws Exception {

		Long id = 1L;
		String configKeys = "KEY1,KEY2";

		Map<String, String> configMap = new HashMap<>();

		configMap.put("KEY1", "VALUE1");

		List<Form630DhiDataResp> formDataList = Collections.singletonList(new Form630DhiDataResp());

		when(utility.getConfigList(configKeys)).thenReturn(configMap);

		when(homeInstructionRepo.getForm630dhiData(id)).thenReturn(formDataList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-14");

		Form630DhiResponseDTO result = formServiceImpl.getForm630dhi(id, configKeys, "");

		assertNotNull(result);

		assertEquals(Constant.getMessageMap().get(Constant.GFE_RFS), result.getMessage());

		verify(utility).getConfigList(configKeys);

		verify(homeInstructionRepo).getForm630dhiData(id);

		verify(userDetailsRepo, never()).getLookupValues(anyString());
	}

	@Test
	void testGetForm630dhi_Exception() throws Exception {

		Long id = 1L;
		String configKeys = "KEY1";
		String lookupValues = "STATUS";

		Mockito.when(userDetailsRepo.getLookupValues(lookupValues)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.getForm630dhi(id, configKeys, lookupValues));

		Mockito.verify(userDetailsRepo, Mockito.times(1)).getLookupValues(lookupValues);

		Mockito.verify(homeInstructionRepo, Mockito.never()).getForm630dhiData(Mockito.anyLong());
	}

	@Test
	void testGetForm760Dhi_WhenDataExists() throws Exception {

		Long id = 1L;
		String configKeys = "KEY1,KEY2";
		String lookupValues = "LOOKUP1,LOOKUP2";

		LookupDetails lookupDetails = new LookupDetails();

		List<LookupDetails> lookupTypeList = Collections.singletonList(lookupDetails);

		Map<String, String> configKeyList = new HashMap<>();

		configKeyList.put("KEY1", "VALUE1");

		Form760DhiDataResp formData = new Form760DhiDataResp();

		List<Form760DhiDataResp> formDataList = Collections.singletonList(formData);

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupTypeList);

		when(utility.getConfigList(configKeys)).thenReturn(configKeyList);

		when(homeInstructionRepo.getForm760DhiData(id)).thenReturn(formDataList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-14");

		Form760DhiResp result = formServiceImpl.getForm760Dhi(id, configKeys, lookupValues);

		assertNotNull(result);

		assertEquals(Constant.getMessageMap().get(Constant.GFF_RFS), result.getMessage());

		assertEquals("2026-08-14", result.getAccessedOn());

		assertEquals(formData, result.getForm7AphirDataResp());

		verify(userDetailsRepo).getLookupValues(lookupValues);

		verify(utility).getConfigList(configKeys);

		verify(homeInstructionRepo).getForm760DhiData(id);

		verify(utility).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testGetForm760Dhi_WhenDataNotFound() throws Exception {

		Long id = 1L;

		when(homeInstructionRepo.getForm760DhiData(id)).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-14");

		Form760DhiResp result = formServiceImpl.getForm760Dhi(id, "", "");

		assertNotNull(result);

		assertEquals(Constant.getMessageMap().get(Constant.GFF_RNF), result.getMessage());

		assertEquals("2026-08-14", result.getAccessedOn());

		assertNull(result.getForm7AphirDataResp());

		verify(homeInstructionRepo).getForm760DhiData(id);

		verify(userDetailsRepo, never()).getLookupValues(anyString());

		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetForm760Dhi_WhenLookupValuesProvided() throws Exception {

		Long id = 1L;
		String lookupValues = "LOOKUP1";

		List<LookupDetails> lookupList = Collections.singletonList(new LookupDetails());

		List<Form760DhiDataResp> formDataList = Collections.singletonList(new Form760DhiDataResp());

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupList);

		when(homeInstructionRepo.getForm760DhiData(id)).thenReturn(formDataList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-14");

		Form760DhiResp result = formServiceImpl.getForm760Dhi(id, "", lookupValues);

		assertNotNull(result);

		assertEquals(Constant.getMessageMap().get(Constant.GFF_RFS), result.getMessage());

		verify(userDetailsRepo).getLookupValues(lookupValues);

		verify(homeInstructionRepo).getForm760DhiData(id);

		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetForm760Dhi_WhenConfigKeysProvided() throws Exception {

		Long id = 1L;
		String configKeys = "KEY1,KEY2";

		Map<String, String> configMap = new HashMap<>();

		configMap.put("KEY1", "VALUE1");

		List<Form760DhiDataResp> formDataList = Collections.singletonList(new Form760DhiDataResp());

		when(utility.getConfigList(configKeys)).thenReturn(configMap);

		when(homeInstructionRepo.getForm760DhiData(id)).thenReturn(formDataList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-14");

		Form760DhiResp result = formServiceImpl.getForm760Dhi(id, configKeys, "");

		assertNotNull(result);

		assertEquals(Constant.getMessageMap().get(Constant.GFF_RFS), result.getMessage());

		verify(utility).getConfigList(configKeys);

		verify(homeInstructionRepo).getForm760DhiData(id);

		verify(userDetailsRepo, never()).getLookupValues(anyString());
	}

	@Test
	void testGetForm760Dhi_WhenExceptionOccurs() {

		Long id = 1L;

		when(homeInstructionRepo.getForm760DhiData(id)).thenThrow(new RuntimeException("Database error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.getForm760Dhi(id, "", ""));

		assertNotNull(exception);

		verify(homeInstructionRepo).getForm760DhiData(id);
	}

	@Test
	void testGetForm760Dhi_Exception() throws Exception {

		Long id = 1L;
		String configKeys = "KEY1";
		String lookupValues = "STATUS";

		Mockito.when(userDetailsRepo.getLookupValues(lookupValues)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.getForm760Dhi(id, configKeys, lookupValues));

		Mockito.verify(userDetailsRepo, Mockito.times(1)).getLookupValues(lookupValues);

		Mockito.verify(homeInstructionRepo, Mockito.never()).getForm760DhiData(Mockito.anyLong());
	}

	@Test
	void testGenerateBlankScheduleList() {

		List<Form1AphirScheduleResp> scheduleList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {

			Form1AphirScheduleResp schedule = new Form1AphirScheduleResp();
			schedule.setId((long) i);
			schedule.setForm1APHIRDataId((long) i);
			schedule.setSubject("Sub" + i);
			schedule.setMp1("MP1-" + i);
			schedule.setMp2("MP2-" + i);
			schedule.setMp3("MP3-" + i);
			schedule.setMp4("MP4-" + i);

			scheduleList.add(schedule);
		}

		List<Form1AphirScheduleResp> result = utility.generateBlankScheduleList(scheduleList, 5);

		assertNotNull(result);
		assertEquals(5, result.size());

		assertEquals("Sub0", result.get(0).getSubject());
		assertEquals("MP1-0", result.get(0).getMp1());

		Form1AphirScheduleResp blankSchedule = result.get(3);

		assertNotNull(blankSchedule);
		assertEquals(0L, blankSchedule.getId());
		assertEquals(0L, blankSchedule.getForm1APHIRDataId());
		assertEquals("", blankSchedule.getSubject());
		assertEquals("", blankSchedule.getMp1());
		assertEquals("", blankSchedule.getMp2());
		assertEquals("", blankSchedule.getMp3());
		assertEquals("", blankSchedule.getMp4());

		Form1AphirScheduleResp secondBlankSchedule = result.get(4);

		assertEquals(0L, secondBlankSchedule.getId());
		assertEquals(0L, secondBlankSchedule.getForm1APHIRDataId());
		assertEquals("", secondBlankSchedule.getSubject());
		assertEquals("", secondBlankSchedule.getMp1());
		assertEquals("", secondBlankSchedule.getMp2());
		assertEquals("", secondBlankSchedule.getMp3());
		assertEquals("", secondBlankSchedule.getMp4());
	}

	@Test
	void testScheduleBodyReplace() {

		String html = "{ROW_START}" + "<tr>{subject_name_mp1_mp2}</tr>" + "{ROW_END}";

		List<Form1AphirScheduleResp> left = new ArrayList<>();
		List<Form1AphirScheduleResp> right = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			Form1AphirScheduleResp l = new Form1AphirScheduleResp();
			l.setSubject("Sub" + i);

			Form1AphirScheduleResp r = new Form1AphirScheduleResp();

			left.add(l);
			right.add(r);
		}

		when(utility.replaceString(any(), anyString())).thenAnswer(inv -> inv.getArgument(1));

		String result = utility.scheduleBodyReplace(html, left, right);

		assertNotNull(result);
	}

	@Test
	void testScheduleBodyReplace_NullHtml() {

		assertNull(utility.scheduleBodyReplace(null, new ArrayList<>(), new ArrayList<>()));
	}

	@Test
	void testScheduleBodyReplace_Exception() {
		String mainHtml = "";
		List<Form1AphirScheduleResp> leftScheduleList = new ArrayList<>();
		List<Form1AphirScheduleResp> rightScheduleList = new ArrayList<>();
		assertThrows(HomeInstructionException.class,
				() -> utility.scheduleBodyReplace(mainHtml, leftScheduleList, rightScheduleList));
	}

	@Test
	void testDownloadPdfForm_APHIM() {

		Form1AphirDataResp data = new Form1AphirDataResp();

		Utility spy = Mockito.spy(utility);

		doReturn(true).when(spy).getAPHIMPdfFileDetails(any(), any(), anyString(), null);

		boolean result = spy.downloadPdfForm(data, new StringBuilder(), "APHIM", "temp.html", null);

		assertTrue(result);
	}

	@Test
	void testDownloadPdfForm_RHIDT() {

		Utility spy = Mockito.spy(utility);

		doReturn(true).when(spy).getRHIDTPdfFileDetails(any(), any(), anyString());

		boolean result = spy.downloadPdfForm(new Form2RHIDTDataResp(), new StringBuilder(), "RHIDT", "temp.html", null);

		assertTrue(result);
	}

	@Test
	void testDownloadPdfForm_Default() {

		boolean result = utility.downloadPdfForm(new Object(), new StringBuilder(), "ABC", "temp", null);

		assertFalse(result);
	}

	@Test
	void testGetStudentInfoByStudentId_Success_WithConfig() {

		GetStudentInfoReqById req = new GetStudentInfoReqById();
		req.setStudentId("1001");
		req.setConfigKeys("FILETMPL,TEMPL_PATH");

		List<StudentDataResp> studentList = new ArrayList<>();
		studentList.add(new StudentDataResp());

		Map<String, String> configMap = new HashMap<>();
		configMap.put("FILETMPL", "/tmp");
		configMap.put("TEMPL_PATH", "/tmp");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(configMap);
		when(appConfigRepo.getStudentData("1001", null)).thenReturn(studentList);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-05");

		GetStudentParentInfoResp response = appConfigServiceImpl.getStudentInfoByStudentId(req);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(studentList, response.getStudentInfoList());
		assertEquals(configMap, response.getConfigList());

		verify(utility).getConfigList("FILETMPL,TEMPL_PATH");
	}

	@Test
	void testGetStudentInfoByStudentId_Success_NoConfig() {

		GetStudentInfoReqById req = new GetStudentInfoReqById();
		req.setStudentId("1001");

		List<StudentDataResp> studentList = new ArrayList<>();
		studentList.add(new StudentDataResp());

		when(utility.printJson(any())).thenReturn("{}");
		when(appConfigRepo.getStudentData("1001", null)).thenReturn(studentList);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-05");

		GetStudentParentInfoResp response = appConfigServiceImpl.getStudentInfoByStudentId(req);

		assertTrue(response.isSuccess());
		assertTrue(response.getConfigList().isEmpty());

		verify(utility, times(0)).getConfigList(anyString());
	}

	@Test
	void testGetStudentInfoByStudentId_NoData() {

		GetStudentInfoReqById req = new GetStudentInfoReqById();
		req.setStudentId("1001");

		when(utility.printJson(any())).thenReturn("{}");
		when(appConfigRepo.getStudentData("1001", null)).thenReturn(Collections.emptyList());
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-05");

		GetStudentParentInfoResp response = appConfigServiceImpl.getStudentInfoByStudentId(req);

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertTrue(response.getStudentInfoList().isEmpty());
	}

	@Test
	void testGetStudentInfoByStudentId_NullList() {

		GetStudentInfoReqById req = new GetStudentInfoReqById();
		req.setStudentId("1001");

		when(utility.printJson(any())).thenReturn("{}");
		when(appConfigRepo.getStudentData("1001", null)).thenReturn(null);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-05");

		GetStudentParentInfoResp response = appConfigServiceImpl.getStudentInfoByStudentId(req);

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertNull(response.getStudentInfoList());
	}

	@Test
	void testGetStudentInfoByStudentId_Exception() {

		GetStudentInfoReqById req = new GetStudentInfoReqById();
		req.setStudentId("1001");

		when(utility.printJson(any())).thenReturn("{}");
		when(appConfigRepo.getStudentData("1001", null)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> appConfigServiceImpl.getStudentInfoByStudentId(req));
	}

	@Test
	void testUpdateForm3Data_Success() throws Exception {

		Form3Request request = new Form3Request();
		request.setIndicator("I");
		request.setId(0L);
		request.setApplicationId(51L);
		request.setStudentId("STU001");
		request.setActivity("AMSBM");
		request.setStatus("ASBM");
		request.setComment("Teacher submitted");
		request.setFormMasterId(3L);
		request.setFormAbbreviation("RHILT");
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(formRepo.updateForm3RHILTdata(any(Form3Request.class))).thenReturn(Collections.singletonList(1L));

		Form3RhiltDataResp dataResp = new Form3RhiltDataResp();

		when(formRepo.getForm3RhiltData(1L, 1L)).thenReturn(Collections.singletonList(dataResp));

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		File pdf = File.createTempFile("form3", ".pdf");
		FileUtils.writeStringToFile(pdf, "dummy", StandardCharsets.UTF_8);

		doReturn(pdf).when(spyService).generateForm3Pdf(any(Form3RhiltDataResp.class), anyString(), anyString(),
				anyString(), anyString());

		MultipartFile multipartFile = new MockMultipartFile("file", "test.pdf", "application/pdf", "dummy".getBytes());

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(uploadResp);

		Constant.getMessageMap().put(Constant.RHID_RUS, "Record Updated Successfully");

		Form3RhiltResp response = spyService.updateForm3Data(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(formRepo).updateForm3RHILTdata(any(Form3Request.class));
		verify(formRepo).getForm3RhiltData(1L, 1L);
		verify(utility).convertFileToMultipartFile(any(File.class));
		verify(fileUploadService).uploadAndParseFile(any(), any());
	}

	@Test
	void testUpdateForm3Data_UploadFailed() throws Exception {

		Form3Request request = new Form3Request();
		request.setApplicationId(1001L);
		request.setFormAbbreviation("FORM3");

		Map<String, String> configMap = new HashMap<>();
		configMap.put("FILETMPL", System.getProperty("java.io.tmpdir"));
		configMap.put("TEMPL_PATH", System.getProperty("java.io.tmpdir"));

		when(utility.getConfigList(anyString())).thenReturn(configMap);

		when(formRepo.updateForm3RHILTdata(any())).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm3RhiltData(anyLong(), anyLong()))
				.thenReturn(Collections.singletonList(new Form3RhiltDataResp()));

		File pdf = File.createTempFile("test", ".pdf");

		MultipartFile multipartFile = mock(MultipartFile.class);

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(false);
		uploadResp.setMessage("Upload Failed");

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(uploadResp);

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm3Data(request));
	}

	@Test
	void testGenerateForm3Pdf_Success() throws Exception {

		Form3RhiltDataResp formData = new Form3RhiltDataResp();

		String formAbbr = "FORM3";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		String html = "<html><body>Test PDF</body></html>";

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append(html);

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> {

			String modifiedHtmlPath = invocation.getArgument(0);
			String pdfPath = invocation.getArgument(1);

			File modifiedHtmlFile = new File(modifiedHtmlPath);

			assertTrue(modifiedHtmlFile.exists());
			assertTrue(modifiedHtmlFile.length() > 0);

			File pdfFile = new File(pdfPath);

			FileUtils.writeByteArrayToFile(pdfFile, "PDF TEST CONTENT".getBytes(StandardCharsets.UTF_8));

			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		File result = formServiceImpl.generateForm3Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);

		assertNotNull(result);
		assertEquals(outputPdfPath, result.getAbsolutePath());

		assertTrue(result.exists());
		assertTrue(result.length() > 0);

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm3Pdf_ProcessReturnFalse() throws Exception {

		Form3RhiltDataResp formData = new Form3RhiltDataResp();

		String formAbbr = "FORM3";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		doAnswer(invocation -> false).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class),
				eq(formAbbr), eq(templatePath), isNull());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm3Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	void testGenerateForm3Pdf_PdfFileEmpty() throws Exception {

		Form3RhiltDataResp formData = new Form3RhiltDataResp();

		String formAbbr = "FORM3";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Test PDF</body></html>");

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> {

			// PDF file intentionally remains empty
			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		HomeInstructionException exception = assertThrows(HomeInstructionException.class, () -> formServiceImpl
				.generateForm3Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath));

		assertEquals("PDF generation failed.", exception.getMessage());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));
	}

	@Test
	void testGenerateForm3Pdf_Exception() {

		Form3RhiltDataResp formData = new Form3RhiltDataResp();

		String formAbbr = "";
		String templatePath = "";
		String modifiedTemplatePath = "";
		String outputPdfPath = "";

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm3Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));
	}

	@Test
	void testGetRHILTPdfFileDetails_Success_WhenApplicationGivenTrue() throws Exception {

		Form3RhiltDataResp data = new Form3RhiltDataResp();

		data.setStudentName("John Doe");
		data.setStudentSchool("ABC School");
		data.setStudentGrade("5");
		data.setInjuryType("Ankle Injury");
		data.setLengthOfAbsence("2 Days");
		data.setParentSignature("Parent");
		data.setParentSignDate("2026-08-05");
		data.setReceivedBy("School Nurse");
		data.setNurseSignature("Nurse");
		data.setNurseSignDate("2026-08-05");
		data.setIsApplicationGiven(true);

		File templateFile = File.createTempFile("template", ".html");
		FileUtils.writeStringToFile(templateFile, "{student_name}{school_name}{injury_type}", StandardCharsets.UTF_8);

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(invocation -> invocation.getArgument(1));

		StringBuilder modifiedTemplateRet = new StringBuilder();
		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHILTPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);
		assertNotNull(mainHtmlRet);
		assertTrue(mainHtmlRet.toString().contains("{student_name}"));

		verify(utility).replaceString(anyMap(), anyString());

		templateFile.delete();
	}

	@Test
	void testGetRHILTPdfFileDetails_Success_WhenApplicationGivenFalse() throws Exception {

		Form3RhiltDataResp data = new Form3RhiltDataResp();

		data.setStudentName("Test Student");
		data.setIsApplicationGiven(false);

		File templateFile = File.createTempFile("template", ".html");

		FileUtils.writeStringToFile(templateFile, "HTML CONTENT", StandardCharsets.UTF_8);

		when(utility.replaceString(anyMap(), anyString())).thenReturn("UPDATED HTML");

		StringBuilder modifiedTemplateRet = new StringBuilder();
		StringBuilder mainHtmlRet = new StringBuilder();

		boolean result = utility.getRHILTPdfFileDetails(data, mainHtmlRet, templateFile.getAbsolutePath());

		assertTrue(result);
		assertEquals("UPDATED HTML", mainHtmlRet.toString());

		templateFile.delete();
	}

	@Test
	void testGetRHILTPdfFileDetails_FileNotFound_Exception() {

		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		StringBuilder modifiedTemplateRet = new StringBuilder();
		StringBuilder mainHtmlRet = new StringBuilder();

		assertThrows(HomeInstructionException.class,
				() -> utility.getRHIDTPdfFileDetails(data, mainHtmlRet, "invalid-template.html"));
	}

	@Test
	void testGenerateForm2Pdf_Success() throws Exception {

		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();

		String formAbbr = "FORM2";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		String html = "<html><body>Test PDF</body></html>";

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append(html);

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> {

			String modifiedHtmlPath = invocation.getArgument(0);
			String pdfPath = invocation.getArgument(1);

			File modifiedHtmlFile = new File(modifiedHtmlPath);

			assertTrue(modifiedHtmlFile.exists());
			assertTrue(modifiedHtmlFile.length() > 0);

			File pdfFile = new File(pdfPath);

			FileUtils.writeByteArrayToFile(pdfFile, "PDF TEST CONTENT".getBytes(StandardCharsets.UTF_8));

			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		File result = formServiceImpl.generateForm2Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);

		assertNotNull(result);
		assertEquals(outputPdfPath, result.getAbsolutePath());

		assertTrue(result.exists());
		assertTrue(result.length() > 0);

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm2Pdf_DownloadPdfFormReturnsFalse() {

		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();

		String formAbbr = "FORM2";
		String templatePath = "template.html";
		String modifiedTemplatePath = "modified-template.html";
		String outputPdfPath = "output.pdf";

		doReturn(false).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr),
				eq(templatePath), isNull());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm2Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	void testGenerateForm2Pdf_PdfGenerationFails() throws Exception {

		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();

		String formAbbr = "FORM2";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Test PDF</body></html>");

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> null).when(utility).generatePDF(anyString(), anyString());

		// The output file is intentionally left empty.
		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm2Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm2Pdf_GeneratePdfThrowsException() throws Exception {

		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();

		String formAbbr = "FORM2";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Test PDF</body></html>");

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doThrow(new RuntimeException("PDF generation error")).when(utility).generatePDF(anyString(), anyString());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm2Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm2Pdf_Exception() {

		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();

		String formAbbr = "";
		String templatePath = "";
		String modifiedTemplatePath = "";
		String outputPdfPath = "";

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm2Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));
	}

	@Test
	void testGenerateForm2Pdf_EmptyPdf() throws Exception {

		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);

		doReturn(true).when(spy).downloadPdfForm(any(Form2RHIDTDataResp.class), any(StringBuilder.class), anyString(),
				anyString(), null);

		assertThrows(HomeInstructionException.class, () -> spyService.generateForm2Pdf(formData, "FORM2",
				"src/test/resources/template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testUpdateForm10Data_Success() throws Exception {

		HomeInstructionServiceImpl spy = Mockito.spy(formServiceImpl);

		Form10Request request = new Form10Request();
		request.setFormAbbreviation("HSAPP");
		request.setApplicationId(100L);
		request.setStudentId("KfftbXVM2qI3/V2Mhy3MKQ==");
		request.setActivity("SAVE");
		request.setStatus("ACTIVE");
		request.setComment("Test");
		request.setFormMasterId(10L);
		request.setLoggedInUserId("KfftbXVM2qI3/V2Mhy3MKQ==");
		request.setLoggedInUserPersonType("S");

		Map<String, String> configMap = new HashMap<>();
		configMap.put("FILETMPL", "C:\\Temp");
		configMap.put("TEMPL_PATH", "C:\\Template");

		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenReturn(configMap);

		when(formRepo.updateForm10HSAPPdata(request)).thenReturn(Arrays.asList(1L));

		Form10HSAPPDataResp dataResp = new Form10HSAPPDataResp();
		when(formRepo.getForm10HSAPPData(1L, 1l)).thenReturn(Arrays.asList(dataResp));

		File pdfFile = mock(File.class);

		doReturn(pdfFile).when(spy).generateForm10Pdf(any(Form10HSAPPDataResp.class), eq("HSAPP"), anyString(),
				anyString(), anyString());

		MultipartFile multipartFile = mock(MultipartFile.class);

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);

		when(fileUploadService.uploadAndParseFile(eq(multipartFile), new UploadFormDocumentReq()))
				.thenReturn(uploadResp);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/05/2026");

		Constant.getMessageMap().put(Constant.RHI_RUS, "Record submitted successfully.");

		Form10HSAPPResponseDTO response = spy.updateForm10Data(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(formRepo).updateForm10HSAPPdata(request);
		verify(formRepo).getForm10HSAPPData(1L, 1l);
		verify(fileUploadService).uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class));
	}

	@Test
	void testUpdateForm10Data_Exception() throws Exception {

		Form10Request request = new Form10Request();
		request.setFormAbbreviation("HSAPP");

		when(formRepo.updateForm10HSAPPdata(any(Form10Request.class))).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm10Data(request));

		verify(formRepo, times(1)).updateForm10HSAPPdata(any(Form10Request.class));
	}

	@Test
	void testGetHSAPPdfFileDetails_Success() throws Exception {

		Form10HSAPPDataResp data = new Form10HSAPPDataResp();
		data.setStudentName("John");
		data.setStudentId(100L);
		data.setStudentSchool("ABC School");
		data.setSubject("Math");
		data.setGradeInProgress("10");
		data.setTeacherName("Teacher");
		data.setTeacherEmail("teacher@test.com");
		data.setUnityOfStudy("Unit 1");
		data.setAssignments("Assignment");
		data.setIndependentWork("Independent Work");
		data.setAssessments("Assessment");
		data.setStandardsCovered("Standards");
		data.setOtherResources("Resources");
		data.setTeacherSignature("Signature");
		data.setTeacherSignDate("08/06/2026");
		data.setIsAdditionalTimeNeeded(true);

		Path template = tempDir.resolve("HSAPP.html");

		FileUtils.writeStringToFile(template.toFile(), "{student_name} {student_id}", StandardCharsets.UTF_8);

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(invocation -> invocation.getArgument(1));

		StringBuilder modifiedTemplate = new StringBuilder();
		StringBuilder mainHtml = new StringBuilder();

		boolean result = utility.getHSAPPdfFileDetails(data, mainHtml, template.toString());

		assertTrue(result);
		assertNotNull(mainHtml);

		verify(utility).replaceString(anyMap(), anyString());
	}

	@Test
	void testGetHSAPPdfFileDetails_AdditionalTimeFalse() throws Exception {

		Form10HSAPPDataResp data = new Form10HSAPPDataResp();
		data.setStudentName("John");
		data.setStudentId(100L);
		data.setIsAdditionalTimeNeeded(false);

		Path template = tempDir.resolve("HSAPP2.html");

		FileUtils.writeStringToFile(template.toFile(), "{student_name}", StandardCharsets.UTF_8);

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(invocation -> invocation.getArgument(1));

		boolean result = utility.getHSAPPdfFileDetails(data, new StringBuilder(), template.toString());

		assertTrue(result);

		verify(utility, times(1)).replaceString(anyMap(), anyString());
	}

	@Test
	void testGetHSAPPdfFileDetails_Exception() {

		Form10HSAPPDataResp data = new Form10HSAPPDataResp();

		assertThrows(HomeInstructionException.class,
				() -> utility.getHSAPPdfFileDetails(data, new StringBuilder(), "invalidTemplate.html"));
	}

	@Test
	void testGetForm9EAPP_Success() throws Exception {
		List<Form9EAPPDataResp> data = Arrays.asList(new Form9EAPPDataResp());
		Map<String, String> configMap = new HashMap<>();
		List<LookupDetails> lookupTypeList = Arrays.asList(new LookupDetails());
		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenReturn(configMap);

		when(formRepo.getForm9EAPPData(96L, 1l)).thenReturn(data);
		when(userDetailsRepo.getLookupValues("TYPE1")).thenReturn(lookupTypeList);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		Form9EAPPResponseDTO response = formServiceImpl.getForm9EAPP(96L, 1L, "", "");

	}

	@Test
	void testGetForm9EAPP_SQLException() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;
		String configKeys = "KEY1";
		String lookupValues = "STATUS";

		Mockito.when(userDetailsRepo.getLookupValues(lookupValues)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.getForm9EAPP(id, applicationId, configKeys, lookupValues));

		Mockito.verify(userDetailsRepo, Mockito.times(1)).getLookupValues(lookupValues);

		Mockito.verify(homeInstructionRepo, Mockito.never()).getForm9EAPPData(Mockito.anyLong(), Mockito.anyLong());
	}

	@Test
	void testUpdateForm8Data_Success() throws Exception {

		Form8Request request = new Form8Request();
		request.setIndicator("I");
		request.setId(0l);
		request.setApplicationId(51L);
		request.setStudentId("STU001");
		request.setActivity("AMSBM");
		request.setStatus("ASBM");
		request.setComment("Student requires home instruction.");
		request.setFormMasterId(8L);
		request.setFormAbbreviation("HISCP");
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "C:\\Temp");
		config.put("TEMPL_PATH", "C:\\Template");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(formRepo.updateForm8HISCPdata(any(Form8Request.class))).thenReturn(Collections.singletonList(1L));

		Form8HiscpDataResp dataResp = new Form8HiscpDataResp();

		when(formRepo.getForm8HiscpData(1L, 1L)).thenReturn(Collections.singletonList(dataResp));

		HomeInstructionServiceImpl spyService = spy(formServiceImpl);

		File pdf = File.createTempFile("form8", ".pdf");

		doReturn(pdf).when(spyService).generateForm8Pdf(any(Form8HiscpDataResp.class), anyString(), anyString(),
				anyString(), anyString());

		MultipartFile multipartFile = new MockMultipartFile("file", "test.pdf", "application/pdf", "dummy".getBytes());

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(uploadResp);

		Constant.getMessageMap().put(Constant.HISC_RUS, "Record submitted successfully.");

		Form8HiscpResp response = spyService.updateForm8Data(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

	}

	@Test
	void testUpdateForm8Data_Exception() {
		Form8Request request = new Form8Request();
		request.setIndicator("I");
		request.setId(0l);
		request.setApplicationId(51L);
		request.setStudentId("STU001");
		request.setActivity("AMSBM");
		request.setStatus("ASBM");
		request.setComment("Student requires home instruction.");
		request.setFormMasterId(8L);
		request.setFormAbbreviation("HISCP");
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");
		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm8Data(request));
	}

	@Test
	void testGetEAPPPdfFileDetails_Success() throws Exception {

		String htmlTemplate = "<html>" + "{student_name}" + "{student_id}" + "{teacher_name}" + "{ROW_START}" + "<tr>"
				+ "{plan_type}" + "{plan_1}" + "{plan_2}" + "</tr>" + "{ROW_END}" + "</html>";

		File tempFile = File.createTempFile("HI_APPLN_EAPP_", ".html");

		Files.write(tempFile.toPath(), htmlTemplate.getBytes(StandardCharsets.UTF_8));

		Form9EAPPDataResp data = new Form9EAPPDataResp();

		data.setStudentName("John Smith");
		data.setStudentId(1l);
		data.setTeacherName("Emily Carter");
		data.setTeacherEmail("emily@test.com");
		data.setTeacherSignature("Emily");
		data.setTeacherSignDate("08/06/2026");

		Form9EAPPPlanDataResp plan = new Form9EAPPPlanDataResp();

		plan.setPlanType("Academic");
		plan.setPlan1("Math");
		plan.setPlan2("Science");

		data.setForm9EappPlanData(Collections.singletonList(plan));

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(invocation -> {

			Map<String, String> replaceMap = invocation.getArgument(0);

			String html = invocation.getArgument(1);

			for (Map.Entry<String, String> entry : replaceMap.entrySet()) {

				html = html.replace(entry.getKey(), entry.getValue());
			}

			return html;
		});

		StringBuilder mainHtml = new StringBuilder();

		StringBuilder modifiedTemplate = new StringBuilder();

		boolean result = utility.getEAPPPdfFileDetails(data, mainHtml, tempFile.getAbsolutePath());

		assertTrue(result);

		assertNotNull(mainHtml);

		assertTrue(mainHtml.toString().contains("John Smith"));

		assertTrue(mainHtml.toString().contains("Emily Carter"));

		assertTrue(mainHtml.toString().contains("Academic"));

		verify(utility).replaceString(anyMap(), anyString());
	}

	@Test
	void testGetEAPPPdfFileDetails_FileReadException() {

		Form9EAPPDataResp data = new Form9EAPPDataResp();

		assertThrows(HomeInstructionException.class,
				() -> utility.getEAPPPdfFileDetails(data, new StringBuilder(), "template.html"));

	}

	@Test
	void testTableBodyReplace_Success() {

		String html = "{ROW_START}" + "<tr>" + "{plan_type}" + "{plan_1}" + "{plan_2}" + "</tr>" + "{ROW_END}";

		Form9EAPPPlanDataResp plan = new Form9EAPPPlanDataResp();

		plan.setPlanType("Academic");
		plan.setPlan1("Math");
		plan.setPlan2("Science");

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(invocation -> {

			Map<String, String> map = invocation.getArgument(0);

			String row = invocation.getArgument(1);

			return row.replace("{plan_type}", map.get("{plan_type}")).replace("{plan_1}", map.get("{plan_1}"))
					.replace("{plan_2}", map.get("{plan_2}"));
		});

		String result = formServiceImpl.tableBodyReplace(html, Collections.singletonList(plan));

		assertNotNull(result);

		assertTrue(result.contains("Academic"));
		assertTrue(result.contains("Math"));
		assertTrue(result.contains("Science"));
	}

	@Test
	void testUpdateForm630DHIData_Success() throws Exception {

		Form630DHIRequest request = new Form630DHIRequest();
		request.setApplicationId(1L);
		request.setStudentId("STU001");
		request.setFormAbbreviation("30DHI");
		request.setActivity("AMSBM");
		request.setStatus("Submitted");
		request.setComment("Comment");
		request.setFormMasterId(6L);
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "C:\\Temp");
		config.put("TEMPL_PATH", "C:\\Template");

		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(formRepo.updateForm30DHIdata(any(Form630DHIRequest.class), new ArrayList<>()))
				.thenReturn(Collections.singletonList(1L));

		Form630DhiDataResp dataResp = new Form630DhiDataResp();

		when(formRepo.getForm630dhiData(1L)).thenReturn(Collections.singletonList(dataResp));

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		File pdf = File.createTempFile("form630", ".pdf");

		doReturn(pdf).when(spyService).generateForm6Pdf(any(Form630DhiDataResp.class), anyString(), anyString(),
				anyString(), anyString());

		MultipartFile multipartFile = new MockMultipartFile("file", "test.pdf", "application/pdf", "dummy".getBytes());

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(uploadResp);

		spyService.updateForm630DHIData(request);

		verify(formRepo).updateForm30DHIdata(any(Form630DHIRequest.class), new ArrayList<>());
		verify(formRepo).getForm630dhiData(1L);
		verify(utility).convertFileToMultipartFile(any(File.class));
		verify(fileUploadService).uploadAndParseFile(any(), any());
	}

	@Test
	void testGenerateForm6Pdf_Success() throws Exception {

		Form630DhiDataResp formData = new Form630DhiDataResp();

		String formAbbr = "FORM6";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		String html = "<html><body>Test PDF</body></html>";

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append(html);

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> {

			String modifiedHtmlPath = invocation.getArgument(0);
			String pdfPath = invocation.getArgument(1);

			File modifiedHtmlFile = new File(modifiedHtmlPath);

			assertTrue(modifiedHtmlFile.exists());
			assertTrue(modifiedHtmlFile.length() > 0);

			File pdfFile = new File(pdfPath);

			FileUtils.writeByteArrayToFile(pdfFile, "PDF TEST CONTENT".getBytes(StandardCharsets.UTF_8));

			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		File result = formServiceImpl.generateForm6Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);

		assertNotNull(result);
		assertEquals(outputPdfPath, result.getAbsolutePath());

		assertTrue(result.exists());
		assertTrue(result.length() > 0);

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm6Pdf_Exception() {
		Form630DhiDataResp formData = new Form630DhiDataResp();
		String formAbbr = "";
		String templatePath = "";
		String modifiedTemplatePath = "";
		String outputPdfPath = "";
		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm6Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));
	}

	@Test
	void testGet30DHIPdfFileDetails_Success() throws Exception {

		Form630DhiDataResp data = new Form630DhiDataResp();
		data.setNurseName("Nurse");
		data.setStudentName("John Smith");
		data.setStudentId(100L);
		data.setStudentGrade("10");
		data.setNoticeDate("08/06/2026");
		data.setPhysicianVerifiedOn("08/06/2026");

		Path template = tempDir.resolve("HI_APPLN_30DHI.html");

		FileUtils.writeStringToFile(template.toFile(), "{student_name} {student_id} {grade}", StandardCharsets.UTF_8);

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(invocation -> invocation.getArgument(1));

		StringBuilder modifiedTemplate = new StringBuilder();
		StringBuilder mainHtml = new StringBuilder();

		boolean result = utility.get30DHIPdfFileDetails(data, modifiedTemplate, template.toString());

		assertTrue(result);
		assertNotNull(mainHtml);
		verify(utility).replaceString(anyMap(), anyString());
	}

	@Test
	void testGet30DHIPdfFileDetails_Exception() {

		Form630DhiDataResp data = new Form630DhiDataResp();

		assertThrows(HomeInstructionException.class,
				() -> utility.get30DHIPdfFileDetails(data, new StringBuilder(), "invalidTemplate.html"));
	}

	@Test
	void testUpdateForm2Data_Success() throws Exception {

		Form2Request request = new Form2Request();
		request.setIndicator("I");
		request.setId(0);
		request.setApplicationId(51L);
		request.setStudentId("STU001");
		request.setActivity("AMSBM");
		request.setStatus("ASBM");
		request.setComment("Teacher submitted");
		request.setFormMasterId(2L);
		request.setFormAbbreviation("RHIDT");
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(formRepo.updateForm2RHIDTdata(any(Form2Request.class))).thenReturn(Collections.singletonList(1L));

		Form2RHIDTDataResp dataResp = new Form2RHIDTDataResp();

		when(formRepo.getForm2RHIDTData(1L, 1L)).thenReturn(Collections.singletonList(dataResp));

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		File pdf = File.createTempFile("form2", ".pdf");
		FileUtils.writeStringToFile(pdf, "dummy", StandardCharsets.UTF_8);

		doReturn(pdf).when(spyService).generateForm2Pdf(any(Form2RHIDTDataResp.class), anyString(), anyString(),
				anyString(), anyString());

		MultipartFile multipartFile = new MockMultipartFile("file", "test.pdf", "application/pdf", "dummy".getBytes());

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);
		uploadResp.setMessage("Uploaded");

		when(fileUploadService.uploadAndParseFile(any(MultipartFile.class), any(UploadFormDocumentReq.class)))
				.thenReturn(uploadResp);

		Constant.getMessageMap().put(Constant.RHI_RUS, "Record Updated Successfully");

		Form2RhidtResp response = spyService.updateForm2Data(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(formRepo).updateForm2RHIDTdata(any(Form2Request.class));
		verify(formRepo).getForm2RHIDTData(1L, 1L);
		verify(utility).convertFileToMultipartFile(any(File.class));
		verify(fileUploadService).uploadAndParseFile(any(MultipartFile.class), any(UploadFormDocumentReq.class));
	}

	@Test
	void testUpdateForm2Data_Exception() throws Exception {

		Form2Request request = new Form2Request();
		request.setFormAbbreviation("RHIDT");
		request.setApplicationId(1L);

		when(utility.printJson(any())).thenReturn("{}");

		when(formRepo.updateForm2RHIDTdata(any(Form2Request.class))).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm2Data(request));

		verify(formRepo, times(1)).updateForm2RHIDTdata(any(Form2Request.class));
	}

	@Test
	void testUpdateForm4Data_Success() throws Exception {

		Form4Request request = new Form4Request();
		request.setIndicator("I");
		request.setId(0L);
		request.setApplicationId(51L);
		request.setStudentId("STU001");
		request.setActivity("AMSBM");
		request.setStatus("ASBM");
		request.setComment("Teacher submitted");
		request.setFormMasterId(4L);
		request.setFormAbbreviation("PRTHI");
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(formRepo.updateForm4PRTHIdata(any(Form4Request.class))).thenReturn(Collections.singletonList(1L));

		Form4PrthiDataResp dataResp = new Form4PrthiDataResp();

		when(formRepo.getForm4PrthiData(1L, 1L)).thenReturn(Collections.singletonList(dataResp));

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		File pdf = File.createTempFile("form4", ".pdf");
		FileUtils.writeStringToFile(pdf, "dummy", StandardCharsets.UTF_8);

		doReturn(pdf).when(spyService).generateForm4Pdf(any(Form4PrthiDataResp.class), anyString(), anyString(),
				anyString(), anyString());

		MultipartFile multipartFile = new MockMultipartFile("file", "test.pdf", "application/pdf", "dummy".getBytes());

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(uploadResp);

		Constant.getMessageMap().put(Constant.PRIT_RUS, "Record Updated Successfully");

		Form4PrthiResp response = spyService.updateForm4Data(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(formRepo).updateForm4PRTHIdata(any(Form4Request.class));
		verify(formRepo).getForm4PrthiData(1L, 1L);
		verify(fileUploadService).uploadAndParseFile(any(), any());
	}

	@Test
	void testUpdateForm4Data_UpdateFailed() throws Exception {

		Form4Request request = new Form4Request();

		when(utility.printJson(any())).thenReturn("{}");

		when(formRepo.updateForm4PRTHIdata(any())).thenReturn(Collections.singletonList(0L));

		Constant.getMessageMap().put(Constant.PRIT_UUR, "Unable to update");

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		Form4PrthiResp response = formServiceImpl.updateForm4Data(request);

		assertFalse(response.isSuccess());
		assertEquals("Unable to update", response.getMessage());
	}

	@Test
	void testUpdateForm4Data_NoDataFound() throws Exception {

		Form4Request request = new Form4Request();
		request.setFormAbbreviation("PRTHI");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);

		when(formRepo.updateForm4PRTHIdata(any())).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm4PrthiData(1L, 1L)).thenReturn(Collections.emptyList());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm4Data(request));
	}

	@Test
	void testUpdateForm4Data_UploadFailed() throws Exception {

		Form4Request request = new Form4Request();
		request.setApplicationId(1L);
		request.setStudentId("STU001");
		request.setFormAbbreviation("PRTHI");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);

		when(formRepo.updateForm4PRTHIdata(any())).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm4PrthiData(1L, 1L)).thenReturn(Collections.singletonList(new Form4PrthiDataResp()));

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		File pdf = File.createTempFile("form4", ".pdf");
		FileUtils.writeStringToFile(pdf, "dummy", StandardCharsets.UTF_8);

		doReturn(pdf).when(spyService).generateForm4Pdf(any(), anyString(), anyString(), anyString(), anyString());

		MultipartFile multipartFile = new MockMultipartFile("file", "test.pdf", "application/pdf", "dummy".getBytes());

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(false);
		uploadResp.setMessage("Upload Failed");

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(uploadResp);

		assertThrows(HomeInstructionException.class, () -> spyService.updateForm4Data(request));
	}

	@Test
	void testUpdateForm4Data_Exception() throws Exception {

		Form4Request request = new Form4Request();

		when(utility.printJson(any())).thenReturn("{}");

		when(formRepo.updateForm4PRTHIdata(any())).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm4Data(request));

		verify(formRepo).updateForm4PRTHIdata(any(Form4Request.class));
	}

	@Test
	void testGetPRTHIPdfFileDetails_Success() throws Exception {

		File html = tempDir.resolve("template.html").toFile();

		FileUtils.writeStringToFile(html, "{student_name}{teacher_name}{teacher_area_1}", StandardCharsets.UTF_8);

		Form4PrthiDataResp data = new Form4PrthiDataResp();
		data.setStudentName("John");
		data.setStudentId(100L);
		data.setStudentDob("01/01/2010");
		data.setStudentSchool("ABC School");
		data.setStudentGrade("10");
		data.setTeacherName("Teacher");
		data.setTeacherSchool("School");
		data.setTeacherHomePhone("111");
		data.setTeacherWorkPhone("222");
		data.setTeacherSignature("Sign");
		data.setTeacherSignDate("01/01/2026");
		data.setPrincipalSignature("Principal");
		data.setPrincipalSignDate("01/02/2026");

		data.setIsTeacherAccept(true);
		data.setIsTeacherRecommend(true);
		data.setIsTeacherCertified(true);

		data.setTeacherArea1("Math");
		data.setTeacherArea2("Science");
		data.setTeacherArea3("English");
		data.setTeacherArea4("History");

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(invocation -> invocation.getArgument(1));

		StringBuilder modified = new StringBuilder();
		StringBuilder htmlBuilder = new StringBuilder();

		assertTrue(utility.getPRTHIPdfFileDetails(data, htmlBuilder, html.getAbsolutePath()));

		verify(utility).replaceString(anyMap(), anyString());
	}

	@Test
	void testGetPRTHIPdfFileDetails_Exception() {

		Form4PrthiDataResp data = new Form4PrthiDataResp();

		assertThrows(HomeInstructionException.class,
				() -> utility.getPRTHIPdfFileDetails(data, new StringBuilder(), "invalid.html"));
	}

	@Test
	void testUpdateForm1Data_Success() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(1L);
		request.setFormAbbreviation("APHIR");
		request.setStudentId("STU001");
		request.setActivity("SAVE");
		request.setStatus("A");
		request.setFormMasterId(1L);
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(formRepo.updateForm1APHIRdata(any())).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm1AphirData(1L, 1L, null)).thenReturn(Collections.singletonList(new Form1AphirDataResp()));

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		File pdf = File.createTempFile("form1", ".pdf");
		FileUtils.writeStringToFile(pdf, "dummy", StandardCharsets.UTF_8);

		doReturn(pdf).when(spyService).generateForm1Pdf(any(), anyString(), anyString(), anyString(), anyString(),
				null);

		when(utility.convertFileToMultipartFile(any(File.class)))
				.thenReturn(new MockMultipartFile("file", "a.pdf", "application/pdf", "abc".getBytes()));

		FileUploadResp upload = new FileUploadResp();
		upload.setSuccess(true);

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(upload);

		Constant.getMessageMap().put(Constant.UCF_RUS, "Success");

		Form1AphirResp response = spyService.updateForm1Data(request);

		assertTrue(response.isSuccess());
	}

	@Test
	void testUpdateForm1Data_APHIA_NewApplication() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(null);
		request.setFormAbbreviation("APHIA");
		request.setStudentId("STU001");
		request.setActivity("SAVE");
		request.setStatus("DRFT");
		request.setIndicator("U");
		request.setFormMasterId(1L);
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		// Covers applicationId == null branch
		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(100L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm1AphirData(1L, 1L, null)).thenReturn(Collections.singletonList(new Form1AphirDataResp()));

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.emptyList());

		Constant.getMessageMap().put(Constant.UCF_FSD, "Form saved successfully");

		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		assertNotNull(response);

		verify(applicationListRepo).updateHIApplication(any(UpdateHIApplicationReq.class));

		verify(formRepo).updateForm1APHIRdata(request);

		verify(request).getApplicationId();

		assertEquals(100L, request.getApplicationId());
	}

	@Test
	void testUpdateForm1Data_ApplicationIdZero() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(0L);
		request.setFormAbbreviation("APHIR");
		request.setStudentId("STU001");
		request.setActivity("SAVE");
		request.setStatus("DRFT");
		request.setIndicator("U");
		request.setFormMasterId(1L);
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(200L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm1AphirData(1L, 1L, null)).thenReturn(Collections.singletonList(new Form1AphirDataResp()));

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.emptyList());

		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		assertNotNull(response);
		assertEquals(200L, request.getApplicationId());

		ArgumentCaptor<UpdateHIApplicationReq> captor = ArgumentCaptor.forClass(UpdateHIApplicationReq.class);

		verify(applicationListRepo).updateHIApplication(captor.capture());

		assertEquals("I", captor.getValue().getIndicator());
	}

	@Test
	void testUpdateForm1Data_ExistingApplication() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(1L);
		request.setFormAbbreviation("APHIR");
		request.setStudentId("STU001");
		request.setActivity("SAVE");
		request.setStatus("DRFT");
		request.setIndicator("U");
		request.setFormMasterId(1L);
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(1L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm1AphirData(1L, 1L, null)).thenReturn(Collections.singletonList(new Form1AphirDataResp()));

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.emptyList());

		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		assertNotNull(response);

		ArgumentCaptor<UpdateHIApplicationReq> captor = ArgumentCaptor.forClass(UpdateHIApplicationReq.class);

		verify(applicationListRepo).updateHIApplication(captor.capture());

		assertEquals("U", captor.getValue().getIndicator());
	}

	@Test
	void testUpdateForm1Data_EmptyUpdateList() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(1L);
		request.setFormAbbreviation("APHIR");
		request.setStatus("DRFT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(1L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.emptyList());

		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(formRepo).updateForm1APHIRdata(request);

		verify(formRepo, never()).getForm1AphirData(anyLong(), anyLong(), null);
	}

	@Test
	void testUpdateForm1Data_UpdateListZero() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(1L);
		request.setFormAbbreviation("APHIR");
		request.setStatus("DRFT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(1L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.singletonList(0L));

		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(formRepo, never()).getForm1AphirData(anyLong(), anyLong(), null);
	}

	@Test
	void testUpdateForm1Data_EmptyDataList() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(1L);
		request.setFormAbbreviation("APHIR");
		request.setStatus("DRFT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);

		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(1L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm1AphirData(1L, 1L, null)).thenReturn(Collections.emptyList());

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.emptyList());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm1Data(request));
	}

	@Test
	void testUpdateForm1Data_Draft_IndicatorI() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(1L);
		request.setFormAbbreviation("APHIR");
		request.setStudentId("STU001");
		request.setActivity("SAVE");
		request.setStatus("DRFT");
		request.setIndicator("I");
		request.setFormMasterId(1L);
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(1L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm1AphirData(1L, 1L, null)).thenReturn(Collections.singletonList(new Form1AphirDataResp()));

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.emptyList());

		UpdateHIActivityResp activityResp = new UpdateHIActivityResp();
		activityResp.setApplicationNo("APP001");
		activityResp.setApplicationStatus("DRAFT");
		activityResp.setApplicationStatusAbbrev("DRFT");

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Collections.singletonList(activityResp));

		Constant.getMessageMap().put(Constant.UCF_FSD, "Form saved successfully");

		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		assertTrue(response.isSuccess());

		verify(applicationListRepo).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateForm1Data_Draft_IndicatorNotI() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(1L);
		request.setFormAbbreviation("APHIR");
		request.setStatus("DRFT");
		request.setIndicator("U");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/06/2026");

		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(1L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.singletonList(1L));

		Form1AphirDataResp data = new Form1AphirDataResp();
		data.setApplicationNo("APP001");
		data.setApplicationStatus("DRAFT");
		data.setApplicationStatusAbbrev("DRFT");

		when(formRepo.getForm1AphirData(1L, 1L, null)).thenReturn(Collections.singletonList(data));

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.emptyList());

		Constant.getMessageMap().put(Constant.UCF_FSD, "Form saved successfully");

		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		assertTrue(response.isSuccess());

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateForm1Data_UploadFailure() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(1L);
		request.setFormAbbreviation("APHIR");
		request.setStudentId("STU001");
		request.setActivity("SAVE");
		request.setStatus("A");
		request.setIndicator("U");
		request.setFormMasterId(1L);
		request.setLoggedInUserId("USER1");
		request.setLoggedInUserPersonType("PRNT");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", tempDir.toString());
		config.put("TEMPL_PATH", tempDir.toString());
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList(anyString())).thenReturn(config);

		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(1L));

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm1AphirData(1L, 1L, null)).thenReturn(Collections.singletonList(new Form1AphirDataResp()));

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.emptyList());

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		File pdf = File.createTempFile("form1", ".pdf");
		FileUtils.writeStringToFile(pdf, "dummy", StandardCharsets.UTF_8);

		doReturn(pdf).when(spyService).generateForm1Pdf(any(), anyString(), anyString(), anyString(), anyString(),
				anyList());

		when(utility.convertFileToMultipartFile(any(File.class)))
				.thenReturn(new MockMultipartFile("file", "a.pdf", "application/pdf", "abc".getBytes()));

		FileUploadResp upload = new FileUploadResp();
		upload.setSuccess(false);
		upload.setMessage("Upload failed");

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(upload);

		assertThrows(HomeInstructionException.class, () -> spyService.updateForm1Data(request));
	}

	@Test
	void testUpdateForm1Data_Exception() throws Exception {

		Form1Request request = new Form1Request();
		request.setFormAbbreviation("APHIR");
		request.setApplicationId(1L);

		when(utility.printJson(any())).thenReturn("{}");

		when(formRepo.updateForm1APHIRdata(any(Form1Request.class))).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm1Data(request));

		verify(formRepo).updateForm1APHIRdata(any(Form1Request.class));
	}

	@Test
	void testGenerateForm1Pdf_Success() throws Exception {

		Form1AphirDataResp formData = new Form1AphirDataResp();

		String formAbbr = "APHIR";

		File templateFile = File.createTempFile("template", ".html");
		File modifiedTemplateFile = new File(tempDir.toFile(), "modified_template.html");

		File outputPdfFile = new File(tempDir.toFile(), "output.pdf");

		List<Form1AphirScheduleResp> scheduleData = Collections.emptyList();

		when(utility.downloadPdfForm(any(Form1AphirDataResp.class), any(StringBuilder.class), eq(formAbbr),
				eq(templateFile.getAbsolutePath()), eq(scheduleData))).thenAnswer(invocation -> {

					StringBuilder html = invocation.getArgument(1);

					html.append("<html><body>Test PDF</body></html>");

					return true;
				});

		doAnswer(invocation -> {

			String outputPath = invocation.getArgument(1);

			File pdf = new File(outputPath);

			FileUtils.writeStringToFile(pdf, "dummy pdf content", StandardCharsets.UTF_8);

			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		File result = formServiceImpl.generateForm1Pdf(formData, formAbbr, templateFile.getAbsolutePath(),
				modifiedTemplateFile.getAbsolutePath(), outputPdfFile.getAbsolutePath(), scheduleData);

		assertNotNull(result);
		assertEquals(outputPdfFile.getAbsolutePath(), result.getAbsolutePath());

		assertTrue(result.exists());
		assertTrue(result.length() > 0);

		verify(utility).downloadPdfForm(any(Form1AphirDataResp.class), any(StringBuilder.class), eq(formAbbr),
				eq(templateFile.getAbsolutePath()), eq(scheduleData));

		verify(utility).generatePDF(eq(modifiedTemplateFile.getAbsolutePath()), eq(outputPdfFile.getAbsolutePath()));

		// Modified HTML should have been deleted
		assertFalse(modifiedTemplateFile.exists());
	}

	@Test
	void testGenerateForm1Pdf_DownloadPdfFormReturnsFalse() throws Exception {

		Form1AphirDataResp formData = new Form1AphirDataResp();

		String formAbbr = "APHIR";

		File templateFile = File.createTempFile("template", ".html");

		File modifiedTemplateFile = new File(tempDir.toFile(), "modified_template.html");

		File outputPdfFile = new File(tempDir.toFile(), "output.pdf");

		List<Form1AphirScheduleResp> scheduleData = Collections.emptyList();

		when(utility.downloadPdfForm(any(Form1AphirDataResp.class), any(StringBuilder.class), eq(formAbbr),
				eq(templateFile.getAbsolutePath()), eq(scheduleData))).thenReturn(false);

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm1Pdf(formData, formAbbr, templateFile.getAbsolutePath(),
						modifiedTemplateFile.getAbsolutePath(), outputPdfFile.getAbsolutePath(), scheduleData));

		verify(utility).downloadPdfForm(any(Form1AphirDataResp.class), any(StringBuilder.class), eq(formAbbr),
				eq(templateFile.getAbsolutePath()), eq(scheduleData));

		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	void testGenerateForm1Pdf_PdfFileDoesNotExist() throws Exception {

		Form1AphirDataResp formData = new Form1AphirDataResp();

		String formAbbr = "APHIR";

		File templateFile = File.createTempFile("template", ".html");

		File modifiedTemplateFile = new File(tempDir.toFile(), "modified_template.html");

		File outputPdfFile = new File(tempDir.toFile(), "does_not_exist.pdf");

		List<Form1AphirScheduleResp> scheduleData = Collections.emptyList();

		when(utility.downloadPdfForm(any(Form1AphirDataResp.class), any(StringBuilder.class), eq(formAbbr),
				eq(templateFile.getAbsolutePath()), eq(scheduleData))).thenAnswer(invocation -> {

					StringBuilder html = invocation.getArgument(1);

					html.append("<html>Test</html>");

					return true;
				});

		// generatePDF does nothing, so output PDF is never created
		doNothing().when(utility).generatePDF(anyString(), anyString());

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm1Pdf(formData, formAbbr, templateFile.getAbsolutePath(),
						modifiedTemplateFile.getAbsolutePath(), outputPdfFile.getAbsolutePath(), scheduleData));

		verify(utility).generatePDF(eq(modifiedTemplateFile.getAbsolutePath()), eq(outputPdfFile.getAbsolutePath()));
	}

	@Test
	void testGenerateForm1Pdf_PdfFileEmpty() throws Exception {

		Form1AphirDataResp formData = new Form1AphirDataResp();

		String formAbbr = "APHIR";

		File templateFile = File.createTempFile("template", ".html");

		File modifiedTemplateFile = new File(tempDir.toFile(), "modified_template.html");

		File outputPdfFile = new File(tempDir.toFile(), "empty.pdf");

		List<Form1AphirScheduleResp> scheduleData = Collections.emptyList();

		when(utility.downloadPdfForm(any(Form1AphirDataResp.class), any(StringBuilder.class), eq(formAbbr),
				eq(templateFile.getAbsolutePath()), eq(scheduleData))).thenAnswer(invocation -> {

					StringBuilder html = invocation.getArgument(1);

					html.append("<html>Test</html>");

					return true;
				});

		// Create the PDF file but leave it empty
		doAnswer(invocation -> {

			String outputPath = invocation.getArgument(1);

			File pdf = new File(outputPath);

			pdf.createNewFile();

			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm1Pdf(formData, formAbbr, templateFile.getAbsolutePath(),
						modifiedTemplateFile.getAbsolutePath(), outputPdfFile.getAbsolutePath(), scheduleData));

		assertTrue(outputPdfFile.exists());
		assertEquals(0, outputPdfFile.length());

		verify(utility).generatePDF(eq(modifiedTemplateFile.getAbsolutePath()), eq(outputPdfFile.getAbsolutePath()));
	}

	@Test
	void testGenerateForm1Pdf_Exception() {

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doThrow(new RuntimeException("PDF Error")).when(utility).generatePDF(anyString(), anyString());

		doReturn(true).when(spy).downloadPdfForm(any(Form1AphirDataResp.class), any(StringBuilder.class), anyString(),
				anyString(), null);

		assertThrows(HomeInstructionException.class, () -> spyService.generateForm1Pdf(new Form1AphirDataResp(),
				"APHIR", "template.html", "modified.html", "output.pdf", null));
	}

	@Test
	void testGenerateForm10Pdf_Success() throws Exception {

		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();

		String formAbbr = "FORM10";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		String html = "<html><body>Test PDF</body></html>";

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append(html);

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> {

			String modifiedHtmlPath = invocation.getArgument(0);
			String pdfPath = invocation.getArgument(1);

			File modifiedHtmlFile = new File(modifiedHtmlPath);

			assertTrue(modifiedHtmlFile.exists());
			assertTrue(modifiedHtmlFile.length() > 0);

			File pdfFile = new File(pdfPath);

			FileUtils.writeByteArrayToFile(pdfFile, "PDF TEST CONTENT".getBytes(StandardCharsets.UTF_8));

			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		File result = formServiceImpl.generateForm10Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);

		assertNotNull(result);
		assertEquals(outputPdfPath, result.getAbsolutePath());

		assertTrue(result.exists());
		assertTrue(result.length() > 0);

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm10Pdf_ProcessReturnFalse() throws Exception {

		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();

		String formAbbr = "FORM10";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		doAnswer(invocation -> false).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class),
				eq(formAbbr), eq(templatePath), isNull());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm10Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	void testGenerateForm10Pdf_PdfFileEmpty() throws Exception {

		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();

		String formAbbr = "FORM10";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Test PDF</body></html>");

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> {

			// PDF file intentionally remains empty
			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		HomeInstructionException exception = assertThrows(HomeInstructionException.class, () -> formServiceImpl
				.generateForm10Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath));

		assertEquals("PDF generation failed.", exception.getMessage());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));
	}

	@Test
	void testGenerateForm10Pdf_Exception() {

		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();

		String formAbbr = "";
		String templatePath = "";
		String modifiedTemplatePath = "";
		String outputPdfPath = "";

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm10Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));
	}

	@Test
	void testGetAPHIMPdfFileDetails_Success() throws Exception {

		File template = File.createTempFile("aphim", ".html");
		FileUtils.writeStringToFile(template, "{student_name}{student_id}{student_dob}", StandardCharsets.UTF_8);

		Form1AphirDataResp data = new Form1AphirDataResp();
		data.setId(1L);
		data.setStudentId(1001L);
		data.setStudentName("John");
		data.setStudentGender("M");
		data.setPhysicianSignature("SIGN");
		data.setIsApprove(true);
		data.setApplicationType("MI");

		Form1AphirScheduleResp schedule = new Form1AphirScheduleResp();
		schedule.setMp1("X");

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.singletonList(schedule));

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(i -> i.getArgument(1));

		HomeInstructionServiceImpl spy = spy(formServiceImpl);
		Utility spyUility = spy(utility);

		doReturn("HTML").when(spyUility).scheduleBodyReplace(anyString(), anyList(), anyList());

		StringBuilder modified = new StringBuilder();
		StringBuilder html = new StringBuilder();

		assertTrue(spyUility.getAPHIMPdfFileDetails(data, html, template.getAbsolutePath(), null));

		assertEquals("HTML", html.toString());
	}

	@Test
	void testGetAPHIMPdfFileDetails_Female_NotApproved() throws Exception {

		File template = File.createTempFile("aphim", ".html");
		FileUtils.writeStringToFile(template, "TEST", StandardCharsets.UTF_8);

		Form1AphirDataResp data = new Form1AphirDataResp();
		data.setId(1L);
		data.setStudentId(1001L);
		data.setStudentGender("F");
		data.setIsApprove(false);
		data.setApplicationType("");
		data.setPhysicianSignature("");

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Collections.emptyList());

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(i -> i.getArgument(1));

		HomeInstructionServiceImpl spy = spy(formServiceImpl);
		Utility spyUility = spy(utility);

		doReturn("TEST").when(spyUility).scheduleBodyReplace(anyString(), anyList(), anyList());

		assertTrue(spyUility.getAPHIMPdfFileDetails(data, new StringBuilder(), template.getAbsolutePath(), null));
	}

	@Test
	void testGetAPHIMPdfFileDetails_Exception() {

		assertThrows(HomeInstructionException.class, () -> utility.getAPHIMPdfFileDetails(new Form1AphirDataResp(),
				new StringBuilder(), "invalid.html", null));
	}

	@Test
	void testGetAPHIMPdfFileDetails_ScheduleCoverage() throws Exception {

		File template = File.createTempFile("aphim", ".html");
		FileUtils.writeStringToFile(template, "TEST", StandardCharsets.UTF_8);

		Form1AphirDataResp data = new Form1AphirDataResp();
		data.setId(1L);

		Form1AphirScheduleResp left = new Form1AphirScheduleResp();
		left.setSubject("Math");
		left.setMp1("Y");

		Form1AphirScheduleResp right = new Form1AphirScheduleResp();
		right.setSubject("Science");
		right.setMp3("Y");

		when(formRepo.getForm1AphirScheduleData(1L)).thenReturn(Arrays.asList(left, right));

		when(utility.replaceString(anyMap(), anyString())).thenAnswer(i -> i.getArgument(1));

		HomeInstructionServiceImpl spy = spy(formServiceImpl);
		Utility spyUility = spy(utility);

		doCallRealMethod().when(spyUility).generateBlankScheduleList(anyList(), anyInt());

		doCallRealMethod().when(spyUility).scheduleBodyReplace(anyString(), anyList(), anyList());

		assertTrue(spyUility.getAPHIMPdfFileDetails(data,

				new StringBuilder(), template.getAbsolutePath(), null));
	}

	@Test
	void testUpdateForm760DHIData_Success() throws Exception {

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		Form760DHIRequest request = new Form760DHIRequest();
		request.setFormAbbreviation("760DHI");
		request.setApplicationId(1L);
		request.setStudentId("10001");
		request.setActivity("Submit");
		request.setStatus("A");
		request.setComment("Test");
		request.setFormMasterId(1L);
		request.setLoggedInUserId("KfftbXVM2qI3/V2Mhy3MKQ==");
		request.setLoggedInUserPersonType("P");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "src/test/resources");
		config.put("TEMPL_PATH", "src/test/resources");

		when(utility.getConfigList(anyString())).thenReturn(config);
		when(utility.printJson(any())).thenReturn("{}");
		when(utility.responseDate(any())).thenReturn("01/01/2026");

		List<Long> ids = Collections.singletonList(1L);
		when(formRepo.updateForm760DHIdata(any(), null)).thenReturn(ids);

		Form760DhiDataResp data = new Form760DhiDataResp();
		data.setStudentName("John");
		data.setStudentId(10001L);

		when(formRepo.getForm760DhiData(1L)).thenReturn(Collections.singletonList(data));

		File pdf = File.createTempFile("test", ".pdf");
		FileUtils.write(pdf, "PDF", StandardCharsets.UTF_8);

		doReturn(pdf).when(spyService).generateForm7Pdf(any(), anyString(), anyString(), anyString(), anyString());

		MultipartFile multipartFile = mock(MultipartFile.class);

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);

		when(fileUploadService.uploadAndParseFile(any(), any())).thenReturn(uploadResp);

		Constant.getMessageMap().put(Constant.RHI_RUS, "Success");

		Form760DhiResponseDTO response = spyService.updateForm760DHIData(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());

		verify(formRepo).updateForm760DHIdata(any(), null);
		verify(formRepo).getForm760DhiData(1L);
		verify(fileUploadService).uploadAndParseFile(any(), any());
	}

	@Test
	void testUpdateForm760DHIData_UpdateFailed() throws Exception {

		Form760DHIRequest request = new Form760DHIRequest();

		when(formRepo.updateForm760DHIdata(any(), null)).thenReturn(Collections.emptyList());

		Constant.getMessageMap().put(Constant.RHI_UUR, "Unable to update");

		when(utility.responseDate(any())).thenReturn("01/01/2026");

		Form760DhiResponseDTO response = formServiceImpl.updateForm760DHIData(request);

		assertFalse(response.isSuccess());
		assertEquals("Unable to update", response.getMessage());
	}

	@Test
	void testUpdateForm760DHIData_NoDataFound() throws Exception {

		Form760DHIRequest request = new Form760DHIRequest();
		request.setFormAbbreviation("760DHI");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "src/test/resources");
		config.put("TEMPL_PATH", "src/test/resources");

		when(utility.getConfigList(anyString())).thenReturn(config);
		when(formRepo.updateForm760DHIdata(any(), null)).thenReturn(Collections.singletonList(1L));

		when(formRepo.getForm760DhiData(1L)).thenReturn(Collections.emptyList());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm760DHIData(request));
	}

	@Test
	void testGet760DHIPdfFileDetails() throws Exception {

		Form760DhiDataResp data = new Form760DhiDataResp();

		data.setNurseName("Nurse Name");
		data.setStudentName("Student Name");
		data.setStudentId(123L);
		data.setStudentGrade("Grade 5");
		data.setNoticeDate("01/01/2026");
		data.setPhysicianName("Dr. Smith");
		data.setPhysicianVerifiedOn("01/02/2026");

		String html = "<html>{nurse_name}{student_name}{student_id}</html>";

		File tempFile = File.createTempFile("760DHI", ".html");
		tempFile.deleteOnExit();

		FileUtils.writeStringToFile(tempFile, html, StandardCharsets.UTF_8);

		StringBuilder mainHtmlRet = new StringBuilder();

		when(utility.replaceString(any(), anyString())).thenReturn("<html>Nurse NameStudent Name123</html>");

		boolean result = utility.get760DHIPdfFileDetails(data, mainHtmlRet, tempFile.getAbsolutePath());

		assertTrue(result);
		assertNotNull(mainHtmlRet);

		assertEquals("<html>Nurse NameStudent Name123</html>", mainHtmlRet.toString());

		verify(utility, times(1)).replaceString(any(), eq(html));
	}

	@Test
	void testGet760DHIPdfFileDetails_Exception() {

		Form760DhiDataResp data = new Form760DhiDataResp();

		StringBuilder html = new StringBuilder();

		assertThrows(HomeInstructionException.class,
				() -> utility.get760DHIPdfFileDetails(data, html, "InvalidPath.html"));
	}

	@Test
	void testGenerateForm7Pdf_Success() throws Exception {

		Form760DhiDataResp formData = new Form760DhiDataResp();

		String formAbbr = "FORM7";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		String html = "<html><body>Test PDF</body></html>";

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append(html);

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> {

			String modifiedHtmlPath = invocation.getArgument(0);
			String pdfPath = invocation.getArgument(1);

			File modifiedHtmlFile = new File(modifiedHtmlPath);

			assertTrue(modifiedHtmlFile.exists());
			assertTrue(modifiedHtmlFile.length() > 0);

			File pdfFile = new File(pdfPath);

			FileUtils.writeByteArrayToFile(pdfFile, "PDF TEST CONTENT".getBytes(StandardCharsets.UTF_8));

			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		File result = formServiceImpl.generateForm7Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);

		assertNotNull(result);
		assertEquals(outputPdfPath, result.getAbsolutePath());

		assertTrue(result.exists());
		assertTrue(result.length() > 0);

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm7Pdf_DownloadPdfFormReturnsFalse() {

		Form760DhiDataResp formData = new Form760DhiDataResp();

		String formAbbr = "FORM7";
		String templatePath = "template.html";
		String modifiedTemplatePath = "modified-template.html";
		String outputPdfPath = "output.pdf";

		doReturn(false).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr),
				eq(templatePath), isNull());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm7Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	void testGenerateForm7Pdf_PdfGenerationFails() throws Exception {

		Form760DhiDataResp formData = new Form760DhiDataResp();

		String formAbbr = "FORM7";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Test PDF</body></html>");

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> null).when(utility).generatePDF(anyString(), anyString());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm7Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm7Pdf_GeneratePdfThrowsException() throws Exception {

		Form760DhiDataResp formData = new Form760DhiDataResp();

		String formAbbr = "FORM7";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Test PDF</body></html>");

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doThrow(new RuntimeException("PDF generation error")).when(utility).generatePDF(anyString(), anyString());

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm7Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm7Pdf_Exception() {

		Form760DhiDataResp formData = new Form760DhiDataResp();

		String formAbbr = "";
		String templatePath = "";
		String modifiedTemplatePath = "";
		String outputPdfPath = "";

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm7Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));
	}

	@Test
	void getForm10HSAPP_shouldReturnData_whenDataExists() throws Exception {

		// Arrange
		Long id = 100L;
		Long applicationId = 100L;
		String configKeys = "CONFIG_1,CONFIG_2";
		String lookupValues = "LOOKUP_1,LOOKUP_2";

		List<LookupDetails> lookupTypeList = new ArrayList<>();
		Map<String, String> configKeyList = new HashMap<>();

		Form10HSAPPDataResp dataResp = new Form10HSAPPDataResp();

		List<Form10HSAPPDataResp> dataList = new ArrayList<>();
		dataList.add(dataResp);

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupTypeList);

		when(utility.getConfigList(configKeys)).thenReturn(configKeyList);

		when(formRepo.getForm10HSAPPData(id, applicationId)).thenReturn(dataList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-08 15:00:00");

		// Act
		Form10HSAPPResponseDTO response = formServiceImpl.getForm10HSAPP(id, applicationId, configKeys, lookupValues);

		// Assert
		assertNotNull(response);

		verify(userDetailsRepo, times(1)).getLookupValues(lookupValues);

		verify(utility, times(1)).getConfigList(configKeys);

		verify(formRepo, times(1)).getForm10HSAPPData(id, applicationId);

		verify(utility, times(1)).responseDate(any(LocalDateTime.class));
	}

	@Test
	void getForm10HSAPP_shouldReturnNullData_whenDataDoesNotExist() throws Exception {

		// Arrange
		Long id = 100L;
		Long applicationId = 100L;
		String configKeys = "CONFIG_1";
		String lookupValues = "LOOKUP_1";

		List<LookupDetails> lookupTypeList = new ArrayList<>();
		Map<String, String> configKeyList = new HashMap<>();

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupTypeList);

		when(utility.getConfigList(configKeys)).thenReturn(configKeyList);

		when(formRepo.getForm10HSAPPData(id, applicationId)).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-08 15:00:00");

		// Act
		Form10HSAPPResponseDTO response = formServiceImpl.getForm10HSAPP(id, applicationId, configKeys, lookupValues);

		// Assert
		assertNotNull(response);

		verify(userDetailsRepo, times(1)).getLookupValues(lookupValues);

		verify(utility, times(1)).getConfigList(configKeys);

		verify(formRepo, times(1)).getForm10HSAPPData(id, applicationId);
	}

	@Test
	void getForm10HSAPP_shouldNotCallLookupOrConfig_whenParametersAreBlank() throws Exception {

		// Arrange
		Long id = 100L;
		Long applicationId = 100L;

		when(formRepo.getForm10HSAPPData(id, applicationId)).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-08 15:00:00");

		// Act
		Form10HSAPPResponseDTO response = formServiceImpl.getForm10HSAPP(id, applicationId, "", "");

		// Assert
		assertNotNull(response);

		verify(formRepo, times(1)).getForm10HSAPPData(id, applicationId);

		verify(userDetailsRepo, never()).getLookupValues(anyString());

		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void getForm10HSAPP_shouldThrowHomeInstructionException_whenRepositoryThrowsException() {

		// Arrange
		Long id = 100L;
		Long applicationId = 100L;

		when(formRepo.getForm10HSAPPData(id, applicationId)).thenThrow(new RuntimeException("Database error"));

		// Act & Assert
		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.getForm10HSAPP(id, applicationId, "", ""));

		assertEquals("Database error", exception.getMessage());

		verify(formRepo, times(1)).getForm10HSAPPData(id, applicationId);
	}

	@Test
	public void generateForm1Pdf_shouldGeneratePdfSuccessfully() throws Exception {
		Form1AphirDataResp formData = new Form1AphirDataResp();
		String formAbbr = "FORM1";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		List<Form1AphirScheduleResp> scheduleData = Collections.emptyList();
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html>").append("<body>Test PDF</body>").append("</html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), "", eq(scheduleData));

		doAnswer(invocation -> {
			String pdfPath = invocation.getArgument(1);
			File pdfFile = new File(pdfPath);
			FileUtils.writeByteArrayToFile(pdfFile, "dummy pdf content".getBytes(StandardCharsets.UTF_8));
			return null;
		}).when(utility).generatePDF(anyString(), anyString());
		File result = spyService.generateForm1Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath,
				scheduleData);
		assertNotNull(result);
		assertTrue(result.exists());
		assertTrue(result.length() > 0);
		assertEquals(outputPdfPath, result.getAbsolutePath());
		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));
		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	public void generateForm1Pdf_shouldThrowExceptionWhenDownloadFails() throws Exception {
		Form1AphirDataResp formData = new Form1AphirDataResp();
		String formAbbr = "FORM1";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		List<Form1AphirScheduleResp> scheduleData = Collections.emptyList();
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doReturn(false).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr),
				eq(templatePath), eq(scheduleData));
		try {
			spyService.generateForm1Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath,
					scheduleData);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	public void generateForm1Pdf_shouldThrowExceptionWhenPdfIsNotCreated() throws Exception {
		Form1AphirDataResp formData = new Form1AphirDataResp();
		String formAbbr = "FORM1";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		List<Form1AphirScheduleResp> scheduleData = Collections.emptyList();
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Test</body></html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				eq(scheduleData));
		/* * Do not create the PDF. */ doNothing().when(utility).generatePDF(anyString(), eq(outputPdfPath));
		try {
			spyService.generateForm1Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath,
					scheduleData);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));
	}

	@Test
	public void generateForm1Pdf_shouldWrapExceptionFromPdfGenerator() throws Exception {
		Form1AphirDataResp formData = new Form1AphirDataResp();
		String formAbbr = "FORM1";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		List<Form1AphirScheduleResp> scheduleData = Collections.emptyList();
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Test</body></html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				eq(scheduleData));
		doThrow(new RuntimeException("PDF generator failed")).when(utility).generatePDF(anyString(), eq(outputPdfPath));
		try {
			spyService.generateForm1Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath,
					scheduleData);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
			assertEquals("PDF generator failed", e.getCause().getMessage());
		}
	}

	@Test
	public void generateForm2Pdf_shouldGeneratePdfSuccessfully() throws Exception {
		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();
		String formAbbr = "FORM2";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html>").append("<body>Form 2 Test</body>").append("</html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), eq(null));
		doAnswer(invocation -> {
			String pdfPath = invocation.getArgument(1);
			File pdfFile = new File(pdfPath);
			FileUtils.writeByteArrayToFile(pdfFile, "dummy pdf content".getBytes(StandardCharsets.UTF_8));
			return null;
		}).when(utility).generatePDF(anyString(), eq(outputPdfPath));
		File result = spyService.generateForm2Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);
		assertNotNull(result);
		assertTrue(result.exists());
		assertTrue(result.length() > 0);
		assertEquals(outputPdfPath, result.getAbsolutePath());
		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));
		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	public void generateForm2Pdf_shouldThrowExceptionWhenDownloadFails() throws Exception {
		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();
		String formAbbr = "FORM2";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doReturn(false).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr),
				eq(templatePath), eq(null));
		try {
			spyService.generateForm2Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	public void generateForm2Pdf_shouldThrowExceptionWhenPdfDoesNotExist() throws Exception {
		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();
		String formAbbr = "FORM2";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Form 2</body></html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), eq(null));
		doNothing().when(utility).generatePDF(anyString(), eq(outputPdfPath));
		try {
			spyService.generateForm2Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));
	}

	@Test
	public void generateForm2Pdf_shouldThrowExceptionWhenPdfIsEmpty() throws Exception {
		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();
		String formAbbr = "FORM2";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Form 2</body></html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), eq(null));
		doAnswer(invocation -> {
			String pdfPath = invocation.getArgument(1);
			File pdfFile = new File(pdfPath);
			if (!pdfFile.exists()) {
				assertTrue(pdfFile.createNewFile());
			}
			return null;
		}).when(utility).generatePDF(anyString(), eq(outputPdfPath));
		try {
			spyService.generateForm2Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
	}

	@Test
	public void generateForm2Pdf_shouldWrapPdfGeneratorException() throws Exception {
		Form2RHIDTDataResp formData = new Form2RHIDTDataResp();
		String formAbbr = "FORM2";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Form 2</body></html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), eq(null));
		doThrow(new RuntimeException("PDF generator failed")).when(utility).generatePDF(anyString(), eq(outputPdfPath));
		try {
			spyService.generateForm2Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
			assertNotNull(e.getCause());
			assertEquals("PDF generator failed", e.getCause().getMessage());
		}
	}

	@Test
	public void generateForm10Pdf_shouldGeneratePdfSuccessfully() throws Exception {
		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();
		String formAbbr = "FORM10";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html>").append("<body>Form 10 Test</body>").append("</html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), eq(null));
		doAnswer(invocation -> {
			String pdfPath = invocation.getArgument(1);
			File pdfFile = new File(pdfPath);
			FileUtils.writeByteArrayToFile(pdfFile, "dummy pdf content".getBytes(StandardCharsets.UTF_8));
			return null;
		}).when(utility).generatePDF(anyString(), eq(outputPdfPath));
		File result = spyService.generateForm10Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);
		assertNotNull(result);
		assertTrue(result.exists());
		assertTrue(result.length() > 0);
		assertEquals(outputPdfPath, result.getAbsolutePath());
		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));
		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	public void generateForm10Pdf_shouldThrowExceptionWhenDownloadFails() throws Exception {
		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();
		String formAbbr = "FORM10";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doReturn(false).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr),
				eq(templatePath), eq(null));
		try {
			spyService.generateForm10Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	public void generateForm10Pdf_shouldThrowExceptionWhenPdfDoesNotExist() throws Exception {
		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();
		String formAbbr = "FORM10";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Form 10</body></html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), eq(null));
		doNothing().when(utility).generatePDF(anyString(), eq(outputPdfPath));
		try {
			spyService.generateForm10Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));
	}

	@Test
	public void generateForm10Pdf_shouldThrowExceptionWhenPdfIsEmpty() throws Exception {
		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();
		String formAbbr = "FORM10";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Form 10</body></html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), eq(null));
		/* * Create an empty PDF file. */ doAnswer(invocation -> {
			String pdfPath = invocation.getArgument(1);
			File pdfFile = new File(pdfPath);
			if (!pdfFile.exists()) {
				assertTrue(pdfFile.createNewFile());
			}
			return null;
		}).when(utility).generatePDF(anyString(), eq(outputPdfPath));
		try {
			spyService.generateForm10Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
	}

	@Test
	public void generateForm10Pdf_shouldWrapPdfGeneratorException() throws Exception {
		Form10HSAPPDataResp formData = new Form10HSAPPDataResp();
		String formAbbr = "FORM10";
		String templatePath = "New Path";
		String modifiedTemplatePath = "Test Path";
		String outputPdfPath = "Test output path";
		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);
		Utility spy = Mockito.spy(utility);
		doAnswer(invocation -> {
			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append("<html><body>Form 10</body></html>");
			return true;
		}).when(spy).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), eq(null));
		doThrow(new RuntimeException("PDF generator failed")).when(utility).generatePDF(anyString(), eq(outputPdfPath));
		try {
			spyService.generateForm10Pdf(formData, formAbbr, templatePath, modifiedTemplatePath, outputPdfPath);
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
			assertNotNull(e.getCause());
			assertEquals("PDF generator failed", e.getCause().getMessage());
		}
	}

	@Test
	void testUpdateActivity_Success() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();
		request.setApplicationId(100L);
		request.setActionTakenByPersonType("P");

		List<UpdateHIActivityResp> activityId = Collections.singletonList(new UpdateHIActivityResp());

		List<NotificationList> notificationList = Collections.singletonList(new NotificationList());

		when(utility.printJson(any())).thenReturn("{}");
		when(applicationListRepo.updateHIActivity(request)).thenReturn(activityId);
		when(homeInstructionRepo.getNotificationList(100L, "P")).thenReturn(notificationList);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-12");

		Constant.getMessageMap().put(Constant.UHA_RUS, "Activity updated successfully");

		HIActivityResponseDTO response = applicationListServiceImpl.updateActivity(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals("Activity updated successfully", response.getMessage());

		verify(applicationListRepo).updateHIActivity(request);
		verify(homeInstructionRepo).getNotificationList(100L, "P");
		verify(utility).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testUpdateActivity_UpdateFailed() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();
		request.setApplicationId(100L);
		request.setActionTakenByPersonType("P");

		when(utility.printJson(any())).thenReturn("{}");
		when(applicationListRepo.updateHIActivity(request)).thenReturn(Collections.emptyList());

		when(homeInstructionRepo.getNotificationList(100L, "P")).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-12");

		Constant.getMessageMap().put(Constant.UHA_UUR, "Unable to update");

		HIActivityResponseDTO response = applicationListServiceImpl.updateActivity(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertEquals("Unable to update", response.getMessage());

		verify(applicationListRepo).updateHIActivity(request);
		verify(homeInstructionRepo).getNotificationList(100L, "P");
		verify(utility).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testUpdateActivity_NullActivityId() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();
		request.setApplicationId(100L);
		request.setActionTakenByPersonType("P");

		when(utility.printJson(any())).thenReturn("{}");
		when(applicationListRepo.updateHIActivity(request)).thenReturn(null);

		when(homeInstructionRepo.getNotificationList(100L, "P")).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-12");

		Constant.getMessageMap().put(Constant.UHA_UUR, "Unable to update");

		HIActivityResponseDTO response = applicationListServiceImpl.updateActivity(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertEquals("Unable to update", response.getMessage());

		verify(applicationListRepo).updateHIActivity(request);
		verify(homeInstructionRepo).getNotificationList(100L, "P");
	}

	@Test
	void testUpdateActivity_Exception() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();
		request.setApplicationId(100L);
		request.setActionTakenByPersonType("P");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIActivity(request)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> applicationListServiceImpl.updateActivity(request));

		verify(applicationListRepo).updateHIActivity(request);

		verify(homeInstructionRepo, never()).getNotificationList(anyLong(), anyString());
	}

	@Test
	void testGenerateForm4Pdf_Success() throws Exception {

		Form4PrthiDataResp formData = new Form4PrthiDataResp();

		String formAbbr = "PRTHI";
		String templatePath = tempDir.resolve("template.html").toString();
		String modifiedTemplatePath = tempDir.resolve("modified.html").toString();
		String outputPdfPath = tempDir.resolve("form4.pdf").toString();

		FileUtils.writeStringToFile(new File(templatePath), "<html><body>Test Form 4</body></html>",
				StandardCharsets.UTF_8);

		when(utility.downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), isNull()))
				.thenAnswer(invocation -> {
					StringBuilder mainHtml = invocation.getArgument(1);
					mainHtml.append("<html><body>Generated Form 4</body></html>");
					return true;
				});

		doAnswer(invocation -> {
			String outputPath = invocation.getArgument(1);
			File pdfFile = new File(outputPath);
			FileUtils.writeByteArrayToFile(pdfFile, "dummy pdf content".getBytes(StandardCharsets.UTF_8));
			return null;
		}).when(utility).generatePDF(anyString(), eq(outputPdfPath));

		File response = formServiceImpl.generateForm4Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);

		assertNotNull(response);
		assertTrue(response.exists());
		assertTrue(response.length() > 0);
		assertEquals(outputPdfPath, response.getAbsolutePath());

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm4Pdf_DownloadPdfFormFailure() throws Exception {

		Form4PrthiDataResp formData = new Form4PrthiDataResp();

		String formAbbr = "PRTHI";
		String templatePath = tempDir.resolve("template.html").toString();
		String modifiedTemplatePath = tempDir.resolve("modified.html").toString();
		String outputPdfPath = tempDir.resolve("form4.pdf").toString();

		when(utility.downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm4Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	void testGenerateForm4Pdf_EmptyPdf() throws Exception {

		Form4PrthiDataResp formData = new Form4PrthiDataResp();

		String formAbbr = "PRTHI";
		String templatePath = tempDir.resolve("template.html").toString();
		String modifiedTemplatePath = tempDir.resolve("modified.html").toString();
		String outputPdfPath = tempDir.resolve("form4.pdf").toString();

		when(utility.downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), isNull()))
				.thenAnswer(invocation -> {
					StringBuilder mainHtml = invocation.getArgument(1);
					mainHtml.append("<html><body>Test</body></html>");
					return true;
				});

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm4Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm8Pdf_Success() throws Exception {

		Form8HiscpDataResp formData = new Form8HiscpDataResp();

		String formAbbr = "HISCP";
		String templatePath = tempDir.resolve("template.html").toString();
		String modifiedTemplatePath = tempDir.resolve("modified.html").toString();
		String outputPdfPath = tempDir.resolve("form8.pdf").toString();

		when(utility.downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), isNull()))
				.thenAnswer(invocation -> {
					StringBuilder mainHtml = invocation.getArgument(1);
					mainHtml.append("<html><body>Generated Form 8</body></html>");
					return true;
				});

		doAnswer(invocation -> {
			String outputPath = invocation.getArgument(1);

			File pdfFile = new File(outputPath);
			FileUtils.writeByteArrayToFile(pdfFile, "dummy pdf content".getBytes(StandardCharsets.UTF_8));

			return null;
		}).when(utility).generatePDF(anyString(), eq(outputPdfPath));

		File response = formServiceImpl.generateForm8Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);

		assertNotNull(response);
		assertTrue(response.exists());
		assertTrue(response.length() > 0);
		assertEquals(outputPdfPath, response.getAbsolutePath());

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm8Pdf_DownloadPdfFormFailure() throws Exception {

		Form8HiscpDataResp formData = new Form8HiscpDataResp();

		String formAbbr = "HISCP";
		String templatePath = tempDir.resolve("template.html").toString();
		String modifiedTemplatePath = tempDir.resolve("modified.html").toString();
		String outputPdfPath = tempDir.resolve("form8.pdf").toString();

		when(utility.downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm8Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	void testGenerateForm8Pdf_Exception() throws Exception {

		Form8HiscpDataResp formData = new Form8HiscpDataResp();

		String formAbbr = "HISCP";
		String templatePath = tempDir.resolve("template.html").toString();
		String modifiedTemplatePath = tempDir.resolve("modified.html").toString();
		String outputPdfPath = tempDir.resolve("form8.pdf").toString();

		when(utility.downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath), isNull()))
				.thenThrow(new RuntimeException("PDF generation error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm8Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));

		verify(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		verify(utility, never()).generatePDF(anyString(), anyString());
	}

	@Test
	void testUpdateForm9DataWhenUpdateListIsEmpty() throws Exception {

		Form9Request form9ERequest = new Form9Request();
		form9ERequest.setFormAbbreviation("EAPP");

		Map<String, String> configKeyValuesForF = new HashMap<>();
		configKeyValuesForF.put("FILETMPL", "/tmp");
		configKeyValuesForF.put("TEMPL_PATH", "/templates");

		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenReturn(configKeyValuesForF);
		when(homeInstructionRepo.updateForm9EAPPData(form9ERequest)).thenReturn(Collections.emptyList());

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.updateForm9Data(form9ERequest));

		assertNotNull(exception);
		verify(homeInstructionRepo).updateForm9EAPPData(form9ERequest);
	}

	@Test
	void testUpdateForm9DataWhenUpdateIdIsZero() throws Exception {

		Form9Request form9ERequest = new Form9Request();
		form9ERequest.setFormAbbreviation("EAPP");

		Map<String, String> configKeyValuesForF = new HashMap<>();
		configKeyValuesForF.put("FILETMPL", "/tmp");
		configKeyValuesForF.put("TEMPL_PATH", "/templates");

		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenReturn(configKeyValuesForF);
		when(homeInstructionRepo.updateForm9EAPPData(form9ERequest)).thenReturn(Collections.singletonList(0L));

		Form9EAPPResp response = formServiceImpl.updateForm9Data(form9ERequest);

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertEquals(0L, response.getId());

		verify(homeInstructionRepo).updateForm9EAPPData(form9ERequest);
		verify(homeInstructionRepo, never()).getForm9EAPPData(anyLong(), anyLong());
	}

	@Test
	void testUpdateForm9DataWhenUpdatedDataIsEmpty() throws Exception {

		Form9Request form9ERequest = new Form9Request();
		form9ERequest.setFormAbbreviation("EAPP");

		Map<String, String> configKeyValuesForF = new HashMap<>();
		configKeyValuesForF.put("FILETMPL", "/tmp");
		configKeyValuesForF.put("TEMPL_PATH", "/templates");

		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenReturn(configKeyValuesForF);
		when(homeInstructionRepo.updateForm9EAPPData(form9ERequest)).thenReturn(Collections.singletonList(123L));

		when(homeInstructionRepo.getForm9EAPPData(123L, 1L)).thenReturn(Collections.emptyList());

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.updateForm9Data(form9ERequest));

		assertNotNull(exception);
		verify(homeInstructionRepo).updateForm9EAPPData(form9ERequest);
		verify(homeInstructionRepo).getForm9EAPPData(123L, 1L);
	}

	@Test
	void testUpdateForm9DataSuccess() throws Exception {

		Form9Request form9ERequest = new Form9Request();
		form9ERequest.setFormAbbreviation("EAPP");
		form9ERequest.setApplicationId(123L);
		form9ERequest.setStudentId("1001L");

		Map<String, String> configKeyValuesForF = new HashMap<>();
		configKeyValuesForF.put("FILETMPL", "/tmp");
		configKeyValuesForF.put("TEMPL_PATH", "/templates");

		Form9EAPPDataResp form9Data = new Form9EAPPDataResp();

		File pdfFile = mock(File.class);
		MultipartFile multipartFile = mock(MultipartFile.class);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenReturn(configKeyValuesForF);

		when(homeInstructionRepo.updateForm9EAPPData(form9ERequest)).thenReturn(Collections.singletonList(123L));

		when(homeInstructionRepo.getForm9EAPPData(123L, 1L)).thenReturn(Collections.singletonList(form9Data));

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		when(fileUploadService.uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class)))
				.thenReturn(uploadResp);

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		doReturn(pdfFile).when(spyService).generateForm9Pdf(eq(form9Data), eq("EAPP"), anyString(), anyString(),
				anyString());

		Form9EAPPResp response = spyService.updateForm9Data(form9ERequest);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(123L, response.getId());

		verify(homeInstructionRepo).updateForm9EAPPData(form9ERequest);
		verify(homeInstructionRepo).getForm9EAPPData(123L, 1L);
		verify(spyService).generateForm9Pdf(eq(form9Data), eq("EAPP"), anyString(), anyString(), anyString());
		verify(utility).convertFileToMultipartFile(any(File.class));
		verify(fileUploadService).uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class));
	}

	@Test
	void testUpdateForm9DataWhenUploadFails() throws Exception {

		Form9Request form9ERequest = new Form9Request();
		form9ERequest.setFormAbbreviation("EAPP");
		form9ERequest.setApplicationId(123L);

		Map<String, String> configKeyValuesForF = new HashMap<>();
		configKeyValuesForF.put("FILETMPL", "/tmp");
		configKeyValuesForF.put("TEMPL_PATH", "/templates");

		Form9EAPPDataResp form9Data = new Form9EAPPDataResp();

		File pdfFile = mock(File.class);
		MultipartFile multipartFile = mock(MultipartFile.class);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(false);
		uploadResp.setMessage("Upload failed");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenReturn(configKeyValuesForF);

		when(homeInstructionRepo.updateForm9EAPPData(form9ERequest)).thenReturn(Collections.singletonList(123L));

		when(homeInstructionRepo.getForm9EAPPData(123L, 1L)).thenReturn(Collections.singletonList(form9Data));

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		when(fileUploadService.uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class)))
				.thenReturn(uploadResp);

		HomeInstructionServiceImpl spyService = Mockito.spy(formServiceImpl);

		doReturn(pdfFile).when(spyService).generateForm9Pdf(eq(form9Data), eq("EAPP"), anyString(), anyString(),
				anyString());

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> spyService.updateForm9Data(form9ERequest));

		assertNotNull(exception);

		verify(fileUploadService).uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class));
	}

	@Test
	void testUpdateForm9DataException() {

		Form9Request form9ERequest = new Form9Request();
		form9ERequest.setFormAbbreviation("EAPP");

		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenThrow(new RuntimeException("Test Exception"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.updateForm9Data(form9ERequest));

		assertNotNull(exception);
	}

	@Test
	void testGenerateForm9Pdf_Success() throws Exception {

		Form9EAPPDataResp formData = new Form9EAPPDataResp();

		String formAbbr = "FORM9";
		String templatePath = "template.html";

		File modifiedTemplateFile = File.createTempFile("modified-template", ".html");
		modifiedTemplateFile.deleteOnExit();

		File outputPdfFile = File.createTempFile("output", ".pdf");
		outputPdfFile.deleteOnExit();

		String modifiedTemplatePath = modifiedTemplateFile.getAbsolutePath();
		String outputPdfPath = outputPdfFile.getAbsolutePath();

		String html = "<html><body>Test PDF</body></html>";

		doAnswer(invocation -> {

			StringBuilder mainHtml = invocation.getArgument(1);
			mainHtml.append(html);

			return true;

		}).when(utility).downloadPdfForm(eq(formData), any(StringBuilder.class), eq(formAbbr), eq(templatePath),
				isNull());

		doAnswer(invocation -> {

			String modifiedHtmlPath = invocation.getArgument(0);
			String pdfPath = invocation.getArgument(1);

			File modifiedHtmlFile = new File(modifiedHtmlPath);

			assertTrue(modifiedHtmlFile.exists());
			assertTrue(modifiedHtmlFile.length() > 0);

			File pdfFile = new File(pdfPath);

			FileUtils.writeByteArrayToFile(pdfFile, "PDF TEST CONTENT".getBytes(StandardCharsets.UTF_8));

			return null;

		}).when(utility).generatePDF(anyString(), anyString());

		File result = formServiceImpl.generateForm9Pdf(formData, formAbbr, templatePath, modifiedTemplatePath,
				outputPdfPath);

		assertNotNull(result);
		assertEquals(outputPdfPath, result.getAbsolutePath());

		assertTrue(result.exists());
		assertTrue(result.length() > 0);

		verify(utility).generatePDF(eq(modifiedTemplatePath), eq(outputPdfPath));

		assertFalse(new File(modifiedTemplatePath).exists());
	}

	@Test
	void testGenerateForm9Pdf_Exception() {

		Form9EAPPDataResp formData = new Form9EAPPDataResp();

		String formAbbr = "";
		String templatePath = "";
		String modifiedTemplatePath = "";
		String outputPdfPath = "";

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm9Pdf(formData, formAbbr,
				templatePath, modifiedTemplatePath, outputPdfPath));
	}

	@Test
	void testUpdateForm1APHIRData_Success() throws Exception {

		// Arrange
		Form1Request request = new Form1Request();
		request.setApplicationId(100L);

		List<Long> updateForm1DataList = new ArrayList<>();
		updateForm1DataList.add(500L);

		File pdfFile = File.createTempFile("test-form1", ".pdf");
		pdfFile.deleteOnExit();

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setApplicationNo("APP123");
		uploadResp.setApplicationStatus("SUBMITTED");
		uploadResp.setApplicationStatusAbbrev("SUB");
		uploadResp.setTransactionId(999L);
		uploadResp.setSuccess(true);

		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(updateForm1DataList);

		// If your method calls generateForm1Pdf(), mock the dependencies
		// required to reach the upload section.

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(mock(MultipartFile.class));

		when(fileUploadService.uploadAndParseFile(any(MultipartFile.class), any(UploadFormDocumentReq.class)))
				.thenReturn(uploadResp);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-20");

		// Act
		Form1AphirResp result = formServiceImpl.updateForm1Data(request);

		// Assert
		assertNotNull(result);
		assertTrue(result.isSuccess());

		assertEquals(500L, result.getFormTransactionId());
		assertEquals(100L, result.getApplicationId());

		assertEquals("APP123", result.getApplicationNumber());
		assertEquals("SUBMITTED", result.getApplicationStatus());
		assertEquals("SUB", result.getApplicationStatusAbbrev());

		assertEquals("2026-08-20", result.getAccessedOn());

		verify(utility).responseDate(any(LocalDateTime.class));

		verify(fileUploadService).uploadAndParseFile(any(MultipartFile.class), any(UploadFormDocumentReq.class));
	}

	@Test
	void testUpdateForm1AphirData_Success() throws Exception {

		// Arrange
		Form1Request form1Request = new Form1Request();
		form1Request.setApplicationId(100L);

		List<Long> updateForm1DataList = new ArrayList<>();
		updateForm1DataList.add(500L);
		Form1AphirDataResp response = new Form1AphirDataResp();

		Form1AphirResp form1DataResp = new Form1AphirResp();

		List<Form1AphirDataResp> formDataList = new ArrayList<>();

		Form1AphirResp expectedResponse = new Form1AphirResp(true, "Record submitted successfully", "2026-08-20", 500L,
				100L, "APP123", "SUBMITTED", "SUB", 999L);

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);
		uploadResp.setApplicationNo("APP123");
		uploadResp.setApplicationStatus("SUBMITTED");
		uploadResp.setApplicationStatusAbbrev("SUB");
		uploadResp.setTransactionId(999L);

		File pdfFile = File.createTempFile("form1", ".pdf");

		MultipartFile multipartFile = mock(MultipartFile.class);

		// Repository update succeeds
//		when(homeInstructionRepo.getForm1AphirData(form1Request.getApplicationId())).thenReturn(response);

		// Repository returns form data
		when(homeInstructionRepo.getForm1AphirData(500L, 1L, null)).thenReturn(formDataList);

		// PDF generation / file conversion
		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		// File upload succeeds
		when(fileUploadService.uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class)))
				.thenReturn(uploadResp);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-20");

		// Message
		Constant.getMessageMap().put(Constant.UCF_RUS, "Record submitted successfully");

		// Act
		Form1AphirResp result = formServiceImpl.updateForm1Data(form1Request);

		// Assert
		assertNotNull(result);
		assertTrue(result.isSuccess());

		assertEquals(100L, result.getApplicationId());

		assertEquals("APP123", result.getApplicationNumber());
		assertEquals("SUBMITTED", result.getApplicationStatus());
		assertEquals("SUB", result.getApplicationStatusAbbrev());
		assertEquals(999L, result.getFormTransactionId());

		assertEquals("Record submitted successfully", result.getMessage());

		assertEquals("2026-08-20", result.getAccessedOn());

		verify(homeInstructionRepo).updateForm1APHIRdata(form1Request);

		verify(fileUploadService).uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class));

		verify(utility).responseDate(any(LocalDateTime.class));

		// Cleanup
		FileUtils.deleteQuietly(pdfFile);
	}

	@Test
	void testGetForm10HSAPP_WithData() throws Exception {
		Long id = 1L;
		Long applicationId = 2L;

		Form10HSAPPDataResp data = new Form10HSAPPDataResp();

		when(userDetailsRepo.getLookupValues("LOOKUP")).thenReturn(new ArrayList<>());
		when(utility.getConfigList("CONFIG")).thenReturn(new HashMap<>());
		when(homeInstructionRepo.getForm10HSAPPData(id, applicationId)).thenReturn(Collections.singletonList(data));

		Form10HSAPPResponseDTO response = formServiceImpl.getForm10HSAPP(id, applicationId, "CONFIG", "LOOKUP");

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(data, response.getForm10HSAPPDataResp());

		verify(userDetailsRepo).getLookupValues("LOOKUP");
		verify(utility).getConfigList("CONFIG");
		verify(homeInstructionRepo).getForm10HSAPPData(id, applicationId);
	}

	@Test
	void testGetForm10HSAPP_NoData() {
	    when(homeInstructionRepo.getForm10HSAPPData(1L, 2L))
	            .thenReturn(Collections.emptyList());

	    Form10HSAPPResponseDTO response =
	            formServiceImpl.getForm10HSAPP(1L, 2L, null, null);

	    assertNotNull(response);
	    assertTrue(response.isSuccess());
	    assertNull(response.getForm10HSAPPDataResp());

	    verify(homeInstructionRepo).getForm10HSAPPData(1L, 2L);
	}

	@Test
	void testGetForm10HSAPP_Exception() {
	    when(homeInstructionRepo.getForm10HSAPPData(anyLong(), anyLong()))
	            .thenThrow(new RuntimeException("DB Error"));

	    assertThrows(HomeInstructionException.class,
	            () -> formServiceImpl.getForm10HSAPP(
	                    1L, 2L, null, null));
	}

	@Test
	void testGetForm9EAPP_WithData() throws Exception {
		Form9EAPPDataResp data = new Form9EAPPDataResp();

		when(userDetailsRepo.getLookupValues("LOOKUP")).thenReturn(new ArrayList<>());
		when(utility.getConfigList("CONFIG")).thenReturn(new HashMap<>());
		when(homeInstructionRepo.getForm9EAPPData(1L, 2L)).thenReturn(Collections.singletonList(data));

		Form9EAPPResponseDTO response = formServiceImpl.getForm9EAPP(1L, 2L, "CONFIG", "LOOKUP");

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(data, response.getForm9EAPPDataResp());

		verify(userDetailsRepo).getLookupValues("LOOKUP");
		verify(utility).getConfigList("CONFIG");
		verify(homeInstructionRepo).getForm9EAPPData(1L, 2L);
	}

	@Test
	void testGetForm9EAPP_NoData() {
	    when(homeInstructionRepo.getForm9EAPPData(1L, 2L))
	            .thenReturn(Collections.emptyList());

	    Form9EAPPResponseDTO response =
	            formServiceImpl.getForm9EAPP(1L, 2L, null, null);

	    assertNotNull(response);
	    assertTrue(response.isSuccess());
	    assertNull(response.getForm9EAPPDataResp());

	    verify(homeInstructionRepo).getForm9EAPPData(1L, 2L);
	}

	@Test
	void testGetForm9EAPP_Exception() {
	    when(homeInstructionRepo.getForm9EAPPData(anyLong(), anyLong()))
	            .thenThrow(new RuntimeException("DB Error"));

	    assertThrows(HomeInstructionException.class,
	            () -> formServiceImpl.getForm9EAPP(
	                    1L, 2L, null, null));
	}

	@Test
	void testGenerateForm6Pdf_DownloadReturnsFalse() {
		Form630DhiDataResp data = new Form630DhiDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM6"), eq("template.html"), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm6Pdf(data, "FORM6", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testGenerateForm6Pdf_PdfGenerationFails() throws Exception {
		Form630DhiDataResp data = new Form630DhiDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM6"), eq("template.html"), isNull()))
				.thenAnswer(invocation -> {
					StringBuilder html = invocation.getArgument(1);
					html.append("<html>FORM6</html>");
					return true;
				});

		doNothing().when(utility).generatePDF(anyString(), anyString());

		try {
			formServiceImpl.generateForm6Pdf(data, "FORM6", "template.html", "modified.html", "output.pdf");
			fail("Expected HomeInstructionException");
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
	}

	@Test
	void testGenerateForm1Pdf_DownloadReturnsFalse() {
		Form1AphirDataResp data = new Form1AphirDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM1"), eq("template.html"), anyList()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.generateForm1Pdf(data, "FORM1",
				"template.html", "modified.html", "output.pdf", new ArrayList<>()));
	}

	@Test
	void testGenerateForm2Pdf_DownloadReturnsFalse() {
		Form2RHIDTDataResp data = new Form2RHIDTDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM2"), eq("template.html"), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm2Pdf(data, "FORM2", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testGenerateForm3Pdf_DownloadReturnsFalse() {
		Form3RhiltDataResp data = new Form3RhiltDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM3"), eq("template.html"), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm3Pdf(data, "FORM3", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testGenerateForm7Pdf_DownloadReturnsFalse() {
		Form760DhiDataResp data = new Form760DhiDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM7"), eq("template.html"), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm7Pdf(data, "FORM7", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testUpdateForm630DHIData_UpdateFailed() throws Exception {
		Form630DHIRequest request = new Form630DHIRequest();
		request.setApplicationId(100L);
		request.setFormAbbreviation("630DHI");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "src/test/resources");
		config.put("TEMPL_PATH", "src/test/resources");

		when(utility.getConfigList(anyString())).thenReturn(config);
		when(homeInstructionRepo.getApplicationInfoData(100L, null))
				.thenReturn(Collections.singletonList(new ApplicationInfoResp()));
		when(homeInstructionRepo.getPhysicianInfoData(100L))
				.thenReturn(Collections.singletonList(new GetPhysicianInfoResp()));
		when(homeInstructionRepo.updateForm30DHIdata(any(), anyList())).thenReturn(Collections.emptyList());

		Form630DHIResp response = formServiceImpl.updateForm630DHIData(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void testUpdateForm630DHIData_Exception() {
		Form630DHIRequest request = new Form630DHIRequest();

		when(utility.getConfigList(anyString())).thenThrow(new RuntimeException("Config Error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl.updateForm630DHIData(request));
	}

	@Test
	void testGetForm760Dhi_WithData() throws Exception {
		Form760DhiDataResp data = new Form760DhiDataResp();

		when(userDetailsRepo.getLookupValues("LOOKUP")).thenReturn(new ArrayList<>());
		when(utility.getConfigList("CONFIG")).thenReturn(new HashMap<>());
		when(homeInstructionRepo.getForm760DhiData(1L)).thenReturn(Collections.singletonList(data));

		Form760DhiResp response = formServiceImpl.getForm760Dhi(1L, "CONFIG", "LOOKUP");

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertFalse(response.getForm7AphirDataResp().isEmpty());

		verify(userDetailsRepo).getLookupValues("LOOKUP");
		verify(utility).getConfigList("CONFIG");
		verify(homeInstructionRepo).getForm760DhiData(1L);
	}

	@Test
	void testGetForm760Dhi_NoData() {
	    when(homeInstructionRepo.getForm760DhiData(1L))
	            .thenReturn(Collections.emptyList());

	    Form760DhiResp response =
	            formServiceImpl.getForm760Dhi(1L, null, null);

	    assertNotNull(response);
	    assertTrue(response.isSuccess());
	    assertTrue(response.getForm7AphirDataResp().isEmpty());
	}

	@Test
	void testGetForm630dhi_NoData() {
	    when(homeInstructionRepo.getForm630dhiData(1L))
	            .thenReturn(Collections.emptyList());

	    Form630DhiResponseDTO response =
	            formServiceImpl.getForm630dhi(1L, null, null);

	    assertNotNull(response);
	    assertTrue(response.isSuccess());
	}

	@Test
	void testGetForm2RHIDT_Exception() {
	    when(homeInstructionRepo.getForm2RHIDTData(anyLong(), anyLong()))
	            .thenThrow(new RuntimeException("DB Error"));

	    assertThrows(HomeInstructionException.class,
	            () -> formServiceImpl.getForm2RHIDT(1L, 2L, null, null));
	}

	@Test
	void testGetForm8Hiscp_WithData() {
		Form8HiscpDataResp data = new Form8HiscpDataResp();

		when(homeInstructionRepo.getForm8HiscpData(1L, 2L)).thenReturn(Collections.singletonList(data));

		Form8HiscpResponseDTO response = formServiceImpl.getForm8Hiscp(1L, 2L, null, null);

		assertNotNull(response);
		assertTrue(response.isSuccess());
	}

	@Test
	void testGetForm8Hiscp_NoData() {
	    when(homeInstructionRepo.getForm8HiscpData(1L, 2L))
	            .thenReturn(Collections.emptyList());

	    Form8HiscpResponseDTO response =
	            formServiceImpl.getForm8Hiscp(1L, 2L, null, null);

	    assertNotNull(response);
	    assertTrue(response.isSuccess());
	}

	@Test
	void testGetForm8Hiscp_Exception() throws Exception {

		Long id = 1L;
		Long applicationId = 1L;
		String configKeys = "KEY1";
		String lookupValues = "STATUS";

		Mockito.when(userDetailsRepo.getLookupValues(lookupValues)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.getForm8Hiscp(id, applicationId, configKeys, lookupValues));

		Mockito.verify(userDetailsRepo, Mockito.times(1)).getLookupValues(lookupValues);

		Mockito.verify(homeInstructionRepo, Mockito.never()).getForm8HiscpData(Mockito.anyLong(), Mockito.anyLong());
	}

	@Test
	void testTableBodyReplace_NullHtml() {
		assertNull(formServiceImpl.tableBodyReplace(null, Collections.emptyList()));
	}

	@Test
	void testTableBodyReplace_EmptyPlanList() {
		String html = "<table>{ROW_START}<tr>{plan_type}</tr>{ROW_END}</table>";

		String result = formServiceImpl.tableBodyReplace(html, Collections.emptyList());

		assertNotNull(result);
		assertTrue(result.contains("<table>"));
	}

	@Test
	void testTableBodyReplace_WithPlanData() {
		String html = "<table>{ROW_START}<tr>{plan_type}-{plan_1}-{plan_2}</tr>{ROW_END}</table>";

		Form9EAPPPlanDataResp plan = new Form9EAPPPlanDataResp();
		plan.setPlanType("TYPE");
		plan.setPlan1("PLAN1");
		plan.setPlan2("PLAN2");

		when(utility.replaceString(anyMap(), anyString())).thenReturn("<tr>TYPE-PLAN1-PLAN2</tr>");

		String result = formServiceImpl.tableBodyReplace(html, Collections.singletonList(plan));

		assertNotNull(result);
		verify(utility).replaceString(anyMap(), anyString());
	}

	@Test
	void testTableBodyReplace_Exception() {
		Form9EAPPPlanDataResp plan = new Form9EAPPPlanDataResp();

		when(utility.replaceString(anyMap(), anyString())).thenThrow(new RuntimeException("Replace error"));

		assertThrows(HomeInstructionException.class, () -> formServiceImpl
				.tableBodyReplace("{ROW_START}<tr>{plan_type}</tr>{ROW_END}", Collections.singletonList(plan)));
	}

	@Test
	void testGenerateForm4Pdf_DownloadFails() {
		Form4PrthiDataResp data = new Form4PrthiDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM4"), eq("template.html"), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm4Pdf(data, "FORM4", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testGenerateForm8Pdf_DownloadFails() {
		Form8HiscpDataResp data = new Form8HiscpDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM8"), eq("template.html"), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm8Pdf(data, "FORM8", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testGenerateForm9Pdf_DownloadFails() {
		Form9EAPPDataResp data = new Form9EAPPDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM9"), eq("template.html"), isNull()))
				.thenReturn(false);

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm9Pdf(data, "FORM9", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testGenerateForm4Pdf_GeneratePdfThrowsException() {
		Form4PrthiDataResp data = new Form4PrthiDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM4"), eq("template.html"), isNull()))
				.thenAnswer(invocation -> {
					StringBuilder html = invocation.getArgument(1);
					html.append("<html>FORM4</html>");
					return true;
				});

		doThrow(new RuntimeException("PDF Error")).when(utility).generatePDF(anyString(), anyString());

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm4Pdf(data, "FORM4", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testGenerateForm8Pdf_GeneratePdfThrowsException() {
		Form8HiscpDataResp data = new Form8HiscpDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM8"), eq("template.html"), isNull()))
				.thenAnswer(invocation -> {
					StringBuilder html = invocation.getArgument(1);
					html.append("<html>FORM8</html>");
					return true;
				});

		doThrow(new RuntimeException("PDF Error")).when(utility).generatePDF(anyString(), anyString());

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm8Pdf(data, "FORM8", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testGenerateForm9Pdf_GeneratePdfThrowsException() {
		Form9EAPPDataResp data = new Form9EAPPDataResp();

		when(utility.downloadPdfForm(eq(data), any(StringBuilder.class), eq("FORM9"), eq("template.html"), isNull()))
				.thenAnswer(invocation -> {
					StringBuilder html = invocation.getArgument(1);
					html.append("<html>FORM9</html>");
					return true;
				});

		doThrow(new RuntimeException("PDF Error")).when(utility).generatePDF(anyString(), anyString());

		assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.generateForm9Pdf(data, "FORM9", "template.html", "modified.html", "output.pdf"));
	}

	@Test
	void testUpdateForm1PhysicianInfo_EmptyUpdateList() throws Exception {

		Form1Request request = new Form1Request();

		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(Collections.emptyList());

		Form1AphirResp response = formServiceImpl.updateForm1APHIRPhysicianInfo(request);

		assertNotNull(response);

		verify(homeInstructionRepo, times(1)).updateForm1APHIRdata(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateForm1PhysicianInfo_InvalidUpdateId() throws Exception {

		Form1Request request = new Form1Request();

		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(Arrays.asList(0L));

		Form1AphirResp response = formServiceImpl.updateForm1APHIRPhysicianInfo(request);

		assertNotNull(response);

		verify(homeInstructionRepo, times(1)).updateForm1APHIRdata(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateForm1PhysicianInfo_Success() throws Exception {

		Form1Request request = new Form1Request();

		request.setApplicationId(100L);
		request.setActivity("UPDATE");
		request.setStatus("SUBMITTED");
		request.setComment("Physician information updated");
		request.setLoggedInUserId("USER123");
		request.setLoggedInUserPersonType("STAFF");

		List<Long> updateForm1DataList = Arrays.asList(123L);

		UpdateHIActivityResp activityResp = new UpdateHIActivityResp();
		activityResp.setApplicationNo("APP001");
		activityResp.setApplicationStatus("SUBMITTED");
		activityResp.setApplicationStatusAbbrev("SUB");

		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(updateForm1DataList);

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Arrays.asList(activityResp));

		// IMPORTANT:
		// Replace the value below with the actual return type of responseDate().
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(null/* actual responseDate return value */);

		Constant.getMessageMap().put(Constant.UCF_FSD, "Form 1 submitted successfully");

		ArgumentCaptor<UpdateHIActivityReq> captor = ArgumentCaptor.forClass(UpdateHIActivityReq.class);

		Form1AphirResp response = formServiceImpl.updateForm1APHIRPhysicianInfo(request);

		assertNotNull(response);

		verify(homeInstructionRepo, times(1)).updateForm1APHIRdata(request);

		verify(applicationListRepo, times(1)).updateHIActivity(captor.capture());

		UpdateHIActivityReq actualRequest = captor.getValue();

		assertEquals(100L, actualRequest.getApplicationId());
		assertEquals("UPDATE", actualRequest.getActivity());
		assertEquals("SUBMITTED", actualRequest.getStatus());
		assertEquals("Physician information updated", actualRequest.getComment());
		assertEquals("USER123", actualRequest.getActionTakenBy());
		assertEquals("STAFF", actualRequest.getActionTakenByPersonType());

		verify(utility, times(1)).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testUpdateForm1PhysicianInfo_Exception() throws Exception {

		// Arrange
		Form1Request request = new Form1Request();

		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenThrow(new RuntimeException("Database error"));

		// Act
		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.updateForm1APHIRPhysicianInfo(request));

		// Assert
		assertNotNull(exception);
		assertEquals("Database error", exception.getMessage());

		verify(homeInstructionRepo, times(1)).updateForm1APHIRdata(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateForm1PhysicianInfo_ExceptionFromActivityUpdate() throws Exception {

		Form1Request request = new Form1Request();

		request.setApplicationId(100L);
		request.setActivity("UPDATE");
		request.setStatus("SUBMITTED");
		request.setComment("Test");
		request.setLoggedInUserId("USER123");
		request.setLoggedInUserPersonType("STAFF");

		// Must be positive so execution reaches updateHIActivity()
		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(Arrays.asList(123L));

		// Force exception inside try block
		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenThrow(new RuntimeException("Activity update failed"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.updateForm1APHIRPhysicianInfo(request));

		assertNotNull(exception);
		assertEquals("Activity update failed", exception.getMessage());

		verify(homeInstructionRepo, times(1)).updateForm1APHIRdata(request);

		verify(applicationListRepo, times(1)).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateForm1PhycianInfoSuccess() throws Exception {
		Form1Request form1Request = new Form1Request();
		form1Request.setApplicationId(100L);
		form1Request.setActivity("UPDATE");
		form1Request.setStatus("APPROVED");
		form1Request.setComment("Updated successfully");
		form1Request.setLoggedInUserId("USER001");
		form1Request.setLoggedInUserPersonType("STAFF");

		Form1AphirResp form1Data = new Form1AphirResp();

		UpdateHIActivityResp activityResp = new UpdateHIActivityResp();
		activityResp.setApplicationNo("APP001");
		activityResp.setApplicationStatus("Approved");
		activityResp.setApplicationStatusAbbrev("A");

		List<UpdateHIActivityResp> activityRespList = Arrays.asList(activityResp);

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class))).thenReturn(activityRespList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-29");

		// Mock the list returned by the method/repository used before these lines.
		List<Form1AphirResp> updateForm1DataList = Arrays.asList(form1Data);

		// Example:
		// when(applicationListRepo.updateForm1Data(any(...)))
		// .thenReturn(updateForm1DataList);

		Form1AphirResp result = formServiceImpl.updateForm1APHIRPhysicianInfo(form1Request);

		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertEquals(100L, result.getApplicationId());
		assertEquals("APP001", result.getApplicationNumber());
		assertEquals("Approved", result.getApplicationStatus());
		assertEquals("A", result.getApplicationStatusAbbrev());

		verify(applicationListRepo).updateHIActivity(any(UpdateHIActivityReq.class));
		verify(utility).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testUpdateForm1PhycianInfoUpdateHIActivity() throws Exception {
		Form1Request form1Request = new Form1Request();

		form1Request.setApplicationId(100L);
		form1Request.setActivity("UPDATE");
		form1Request.setStatus("APPROVED");
		form1Request.setComment("Test comment");
		form1Request.setLoggedInUserId("USER001");
		form1Request.setLoggedInUserPersonType("STAFF");

		UpdateHIActivityResp activityResp = new UpdateHIActivityResp();
		activityResp.setApplicationNo("APP001");
		activityResp.setApplicationStatus("Approved");
		activityResp.setApplicationStatusAbbrev("A");

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Arrays.asList(activityResp));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-08-29");

		// Mock whatever returns updateForm1DataList in your actual method.
		// It must contain at least one element because the production code
		// calls updateForm1DataList.get(0).

		Form1AphirResp data = new Form1AphirResp();

		// Example:
		// when(...).thenReturn(List.of(data));

		ArgumentCaptor<UpdateHIActivityReq> captor = ArgumentCaptor.forClass(UpdateHIActivityReq.class);

		Form1AphirResp result = formServiceImpl.updateForm1APHIRPhysicianInfo(form1Request);

		verify(applicationListRepo).updateHIActivity(captor.capture());

		UpdateHIActivityReq capturedRequest = captor.getValue();

		assertEquals(100L, capturedRequest.getApplicationId());
		assertEquals("UPDATE", capturedRequest.getActivity());
		assertEquals("APPROVED", capturedRequest.getStatus());
		assertEquals("Test comment", capturedRequest.getComment());
		assertEquals("USER001", capturedRequest.getActionTakenBy());
		assertEquals("STAFF", capturedRequest.getActionTakenByPersonType());

		assertNotNull(result);
	}

	@Test
	void updateForm760DHIData_success() throws Exception {

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "/tmp");
		config.put("TEMPL_PATH", "/template");

		GetPhysicianInfoResp physician = new GetPhysicianInfoResp();
		physician.setPhysicianName("Dr. Test");
		physician.setPhysicianSignDate("08/30/2026");

		ApplicationInfoResp applicationInfo = new ApplicationInfoResp();
		applicationInfo.setStudentId(200L);
		applicationInfo.setStudentName("John Doe");
		applicationInfo.setStudentGrade("5");

		File pdfFile = new File("/tmp/HI_APPLN_760DHI_100.pdf");

		List<Long> updateResult = Collections.singletonList(1L);

		UploadFormDocumentReq uploadReq = new UploadFormDocumentReq();

		FileUploadResp uploadResp = new FileUploadResp();
		uploadResp.setSuccess(true);

		HIFormTransactionResp transaction = new HIFormTransactionResp();

		when(utility.printJson(request)).thenReturn("{\"applicationId\":100}");
		when(utility.getConfigList("FILETMPL,TEMPL_PATH")).thenReturn(config);

		when(homeInstructionRepo.getPhysicianInfoData(100L)).thenReturn(Collections.singletonList(physician));

		when(homeInstructionRepo.updateForm760DHIdata(request, physician)).thenReturn(updateResult);

		when(homeInstructionRepo.getApplicationInfoData(100L, "SCHOOL"))
				.thenReturn(Collections.singletonList(applicationInfo));

		doReturn(pdfFile).when(formServiceImpl).generateForm7Pdf(any(Form760DhiDataResp.class), eq("760DHI"),
				anyString(), anyString(), anyString());

		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		when(fileUploadService.uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class)))
				.thenReturn(uploadResp);

		when(homeInstructionRepo.getHIFormTransactionData(0L, 100L, 0L, "SCHOOL"))
				.thenReturn(Collections.singletonList(transaction));

		Form760DhiResponseDTO response = formServiceImpl.updateForm760DHIData(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(homeInstructionRepo).getPhysicianInfoData(100L);

		verify(homeInstructionRepo).updateForm760DHIdata(request, physician);

		verify(homeInstructionRepo).getApplicationInfoData(100L, "SCHOOL");

		verify(formServiceImpl).generateForm7Pdf(any(Form760DhiDataResp.class), eq("760DHI"), anyString(), anyString(),
				anyString());

		verify(utility).convertFileToMultipartFile(any(File.class));

		verify(fileUploadService).uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class));

		verify(homeInstructionRepo).getHIFormTransactionData(0L, 100L, 0L, "SCHOOL");
	}

	@Test
	void updateForm1Data_whenStatusDraftAndIndicatorInsert_updatesHIActivity() throws Exception {

		// Arrange
		Form1Request request = new Form1Request();

		request.setApplicationId(100L);
		request.setStudentId("");
		request.setSchoolYear("2025");
		request.setApplicationType("HI");
		request.setSchoolCode("SCH001");
		request.setGradeId(5);
		request.setRequestDate("08/31/2026");
		request.setClassification("A");
		request.setLoggedInUserId("");
		request.setLoggedInUserPersonType("SCHOOL");

		request.setFormAbbreviation("APHIR");

		// THIS IS IMPORTANT FOR THE UNCOVERED BRANCH
		request.setStatus("DRFT");
		request.setIndicator("I");

		request.setActivity("SAVE");
		request.setComment("Draft application");
		request.setFormMasterId(400L);

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "/tmp");
		config.put("TEMPL_PATH", "/template");
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any(Form1Request.class))).thenReturn("{}");

		when(utility.getConfigList("FILETMPL,TEMPL_PATH,HI_APPLN_HTML_APHIA")).thenReturn(config);

		// Since applicationId is already present, this should be U
		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(100L));

		// updateForm1APHIRdata must return a positive value
		when(homeInstructionRepo.updateForm1APHIRdata(any(Form1Request.class)))
				.thenReturn(Collections.singletonList(500L));

		// getForm1AphirData must NOT be empty
		Form1AphirDataResp formData = new Form1AphirDataResp();

		formData.setApplicationNo("APP-100");
		formData.setApplicationStatus("DRAFT");
		formData.setApplicationStatusAbbrev("DRFT");

		when(homeInstructionRepo.getForm1AphirData(eq(500L), eq(100L), eq("SCHOOL")))
				.thenReturn(Collections.singletonList(formData));

		// Schedule data can be empty because the DRFT branch doesn't use it
		when(homeInstructionRepo.getForm1AphirScheduleData(500L)).thenReturn(Collections.emptyList());

		// THIS MOCK IS REQUIRED FOR THE UNCOVERED BRANCH
		UpdateHIActivityResp activityResp = new UpdateHIActivityResp();

		activityResp.setApplicationNo("APP-100");
		activityResp.setApplicationStatus("DRAFT");
		activityResp.setApplicationStatusAbbrev("DRFT");

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Collections.singletonList(activityResp));

		// Act
		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		// Assert
		assertNotNull(response);
		assertTrue(response.isSuccess());

		// Verify that the uncovered branch was executed
		verify(applicationListRepo).updateHIActivity(any(UpdateHIActivityReq.class));

		// Verify request values passed to updateHIActivity
		ArgumentCaptor<UpdateHIActivityReq> captor = ArgumentCaptor.forClass(UpdateHIActivityReq.class);

		verify(applicationListRepo).updateHIActivity(captor.capture());

		UpdateHIActivityReq activityReq = captor.getValue();

		assertEquals(100L, activityReq.getApplicationId());
		assertEquals("SAVE", activityReq.getActivity());
		assertEquals("DRFT", activityReq.getStatus());
		assertEquals("Draft application", activityReq.getComment());
		assertEquals(300L, activityReq.getActionTakenBy());
		assertEquals("SCHOOL", activityReq.getActionTakenByPersonType());

		// Verify response values came from updateHIActivity()
		assertEquals("APP-100", response.getApplicationNumber());
		assertEquals("DRAFT", response.getApplicationStatus());
		assertEquals("DRFT", response.getApplicationStatusAbbrev());

		// PDF/upload path must NOT execute for DRFT
		verify(fileUploadService, never()).uploadAndParseFile(any(), any());
	}

	@Test
	void updateForm1Data_whenStatusNotDraft_generatesPdfAndUploadsSuccessfully() throws Exception {

		// Arrange
		Form1Request request = new Form1Request();

		request.setApplicationId(100L);
		request.setStudentId("");
		request.setSchoolYear("2025");
		request.setApplicationType("HI");
		request.setSchoolCode("SCH001");
		request.setGradeId(5);
		request.setRequestDate("08/31/2026");
		request.setClassification("A");
		request.setLoggedInUserId("");
		request.setLoggedInUserPersonType("SCHOOL");

		request.setFormAbbreviation("APHIR");
		request.setStatus("SUBMITTED"); // IMPORTANT: NOT DRFT
		request.setIndicator("I");
		request.setActivity("SUBMIT");
		request.setComment("Submit application");
		request.setFormMasterId(400L);
		request.setOtherDocumentName("Test Document");

		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "/tmp");
		config.put("TEMPL_PATH", "/template");
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.printJson(any(Form1Request.class))).thenReturn("{}");

		when(utility.getConfigList("FILETMPL,TEMPL_PATH,HI_APPLN_HTML_APHIA")).thenReturn(config);

		// application update
		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(100L));

		// Form1 update
		when(homeInstructionRepo.updateForm1APHIRdata(any(Form1Request.class)))
				.thenReturn(Collections.singletonList(500L));

		// Form data
		Form1AphirDataResp formData = new Form1AphirDataResp();

		formData.setApplicationNo("APP-100");
		formData.setApplicationStatus("SUBMITTED");
		formData.setApplicationStatusAbbrev("SUB");

		when(homeInstructionRepo.getForm1AphirData(eq(500L), eq(100L), eq("SCHOOL")))
				.thenReturn(Collections.singletonList(formData));

		// Schedule data
		List<Form1AphirScheduleResp> scheduleData = new ArrayList<>();

		when(homeInstructionRepo.getForm1AphirScheduleData(500L)).thenReturn(scheduleData);

		// Mock generated PDF
		File pdfFile = new File("/tmp/HI_APPLN_APHIR_100.pdf");

		doReturn(pdfFile).when(formServiceImpl).generateForm1Pdf(eq(formData), eq("APHIR"), anyString(), anyString(),
				anyString(), eq(scheduleData));

		// Multipart conversion
		when(utility.convertFileToMultipartFile(any(File.class))).thenReturn(multipartFile);

		// Successful upload
		FileUploadResp uploadResp = new FileUploadResp();

		uploadResp.setSuccess(true);
		uploadResp.setApplicationNo("APP-100");
		uploadResp.setApplicationStatus("SUBMITTED");
		uploadResp.setApplicationStatusAbbrev("SUB");
		uploadResp.setTransactionId(999L);

		when(fileUploadService.uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class)))
				.thenReturn(uploadResp);

		// Act
		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		// Assert
		assertNotNull(response);
		assertTrue(response.isSuccess());

		assertEquals(100L, response.getApplicationId());
		assertEquals("APP-100", response.getApplicationNumber());
		assertEquals("SUBMITTED", response.getApplicationStatus());
		assertEquals("SUB", response.getApplicationStatusAbbrev());
		assertEquals(999L, response.getFormTransactionId());

		// Verify PDF generation
		verify(formServiceImpl).generateForm1Pdf(eq(formData), eq("APHIR"), anyString(), anyString(), anyString(),
				eq(scheduleData));

		// Verify multipart conversion
		verify(utility).convertFileToMultipartFile(any(File.class));

		// Verify upload
		verify(fileUploadService).uploadAndParseFile(eq(multipartFile), any(UploadFormDocumentReq.class));

		// updateHIActivity should NOT be called because status isn't DRFT
		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void updateForm1APHIRPhysicianInfo_success() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(100L);
		request.setActivity("SUBMIT");
		request.setStatus("DRFT");
		request.setComment("Physician information updated");
		request.setLoggedInUserId("");
		request.setLoggedInUserPersonType("PHYSICIAN");

		// updateForm1APHIRdata() succeeds
		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(Collections.singletonList(500L));

		// updateHIActivity() response
		UpdateHIActivityResp activityResp = new UpdateHIActivityResp();
		activityResp.setApplicationNo("APP-100");
		activityResp.setApplicationStatus("DRAFT");
		activityResp.setApplicationStatusAbbrev("DRFT");

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Collections.singletonList(activityResp));

		Form1AphirResp response = formServiceImpl.updateForm1APHIRPhysicianInfo(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		assertEquals(100L, response.getApplicationId());
		assertEquals("APP-100", response.getApplicationNumber());
		assertEquals("DRAFT", response.getApplicationStatus());
		assertEquals("DRFT", response.getApplicationStatusAbbrev());

		verify(homeInstructionRepo).updateForm1APHIRdata(request);

		verify(applicationListRepo).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void updateForm1APHIRPhysicianInfo_success_verifyActivityRequest() throws Exception {

		Form1Request request = new Form1Request();

		request.setApplicationId(100L);
		request.setActivity("UPDATE");
		request.setStatus("DRFT");
		request.setComment("Physician updated");
		request.setLoggedInUserId("");
		request.setLoggedInUserPersonType("PHYSICIAN");

		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(Collections.singletonList(500L));

		UpdateHIActivityResp activityResp = new UpdateHIActivityResp();
		activityResp.setApplicationNo("APP-100");
		activityResp.setApplicationStatus("DRAFT");
		activityResp.setApplicationStatusAbbrev("DRFT");

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Collections.singletonList(activityResp));

		Form1AphirResp response = formServiceImpl.updateForm1APHIRPhysicianInfo(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		ArgumentCaptor<UpdateHIActivityReq> captor = ArgumentCaptor.forClass(UpdateHIActivityReq.class);

		verify(applicationListRepo).updateHIActivity(captor.capture());

		UpdateHIActivityReq activityReq = captor.getValue();

		assertEquals(100L, activityReq.getApplicationId());
		assertEquals("UPDATE", activityReq.getActivity());
		assertEquals("DRFT", activityReq.getStatus());
		assertEquals("Physician updated", activityReq.getComment());
		assertEquals(200L, activityReq.getActionTakenBy());
		assertEquals("PHYSICIAN", activityReq.getActionTakenByPersonType());
	}

	@Test
	void updateForm1APHIRPhysicianInfo_updateFails() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(100L);

		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(Collections.singletonList(0L));

		Form1AphirResp response = formServiceImpl.updateForm1APHIRPhysicianInfo(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(homeInstructionRepo).updateForm1APHIRdata(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void updateForm1APHIRPhysicianInfo_emptyUpdateResult() throws Exception {

		Form1Request request = new Form1Request();
		request.setApplicationId(100L);

		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(Collections.emptyList());

		Form1AphirResp response = formServiceImpl.updateForm1APHIRPhysicianInfo(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void updateForm1Data_whenDraftAndIndicatorI_shouldUpdateActivityAndReturnResponse() throws Exception {

		Form1Request request = new Form1Request();

		request.setApplicationId(100L);
		request.setStudentId("");
		request.setSchoolYear("2025");
		request.setApplicationType("APHIR");
		request.setSchoolCode("SCH001");
		request.setGradeId(5);
		request.setRequestDate("08/31/2026");
		request.setClassification("CLASS");
		request.setLoggedInUserId("");
		request.setLoggedInUserPersonType("HIAP");

		request.setFormAbbreviation("APHIA");
		request.setStatus("DRFT");
		request.setIndicator("I");
		request.setActivity("SAVE");
		request.setComment("Draft saved");

		// Config required before reaching the branch
		Map<String, String> config = new HashMap<>();
		config.put("FILETMPL", "/tmp");
		config.put("TEMPL_PATH", "/templates");
		config.put("HI_APPLN_HTML_APHIA", "HI_APPLN_APHIA.html");

		when(utility.getConfigList("FILETMPL,TEMPL_PATH,HI_APPLN_HTML_APHIA")).thenReturn(config);

		// updateHIApplication() must return a valid application ID
		when(applicationListRepo.updateHIApplication(any(UpdateHIApplicationReq.class)))
				.thenReturn(Collections.singletonList(100L));

		// updateForm1APHIRdata() must return a positive ID
		when(homeInstructionRepo.updateForm1APHIRdata(request)).thenReturn(Collections.singletonList(500L));

		// dataList must NOT be empty
		Form1AphirDataResp data = new Form1AphirDataResp();

		data.setApplicationNo("2025_0100");
		data.setApplicationStatus("Draft");
		data.setApplicationStatusAbbrev("DRFT");

		when(homeInstructionRepo.getForm1AphirData(500L, 100L, "HIAP")).thenReturn(Collections.singletonList(data));

		// scheduleData is called before reaching the branch
		when(homeInstructionRepo.getForm1AphirScheduleData(500L)).thenReturn(new ArrayList<>());

		// updateHIActivity() response
		UpdateHIActivityResp activityResp = new UpdateHIActivityResp();

		activityResp.setApplicationNo("2025_0100");
		activityResp.setApplicationStatus("Draft");
		activityResp.setApplicationStatusAbbrev("DRFT");

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Collections.singletonList(activityResp));

		// Execute
		Form1AphirResp response = formServiceImpl.updateForm1Data(request);

		// Verify response
		assertNotNull(response);

		// Verify updateHIActivity was called
		ArgumentCaptor<UpdateHIActivityReq> captor = ArgumentCaptor.forClass(UpdateHIActivityReq.class);

		verify(applicationListRepo).updateHIActivity(captor.capture());

		UpdateHIActivityReq activityReq = captor.getValue();

		assertEquals(100L, activityReq.getApplicationId());
		assertEquals("SAVE", activityReq.getActivity());
		assertEquals("DRFT", activityReq.getStatus());
		assertEquals("Draft saved", activityReq.getComment());
		assertEquals(999L, activityReq.getActionTakenBy());
		assertEquals("HIAP", activityReq.getActionTakenByPersonType());

		// PDF/upload path must NOT execute
		verify(fileUploadService, never()).uploadAndParseFile(any(MultipartFile.class),
				any(UploadFormDocumentReq.class));
	}

	@Test
	void getForm4Prthi_whenRepositoryThrowsException_shouldThrowHomeInstructionException() {

		Long id = 100L;
		Long applicationId = 200L;

		when(homeInstructionRepo.getForm4PrthiData(id, applicationId))
				.thenThrow(new RuntimeException("Database error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> formServiceImpl.getForm4Prthi(id, applicationId, "", ""));

		assertNotNull(exception);
		assertEquals("Database error", exception.getMessage());

		verify(homeInstructionRepo).getForm4PrthiData(id, applicationId);
	}

}
