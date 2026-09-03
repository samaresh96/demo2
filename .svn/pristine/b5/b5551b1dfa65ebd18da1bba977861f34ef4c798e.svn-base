package com.jcboe.home.instruction.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.ApplicationTrackingRequest;
import com.jcboe.home.instruction.model.request.GetAppListReq;
import com.jcboe.home.instruction.model.request.UpdateAssignTeacherReq;
import com.jcboe.home.instruction.model.request.UpdateHIActivityReq;
import com.jcboe.home.instruction.model.request.UpdateHIApplicationReq;
import com.jcboe.home.instruction.repo.AppConfigRepo;
import com.jcboe.home.instruction.repo.ApplicationListRepo;
import com.jcboe.home.instruction.repo.HomeInstructionRepo;
import com.jcboe.home.instruction.repo.UserDetailsRepo;
import com.jcboe.home.instruction.response.ApplicationInfoResp;
import com.jcboe.home.instruction.response.ApplicationList;
import com.jcboe.home.instruction.response.ApplicationListResponseDTO;
import com.jcboe.home.instruction.response.ApplicationSummaryResp;
import com.jcboe.home.instruction.response.ApplicationTrackingResp;
import com.jcboe.home.instruction.response.ApplicationTrackingResponseDTO;
import com.jcboe.home.instruction.response.AssignTeacherResponse;
import com.jcboe.home.instruction.response.GetApplicationInfoResp;
import com.jcboe.home.instruction.response.GetApplicationTrackingResp;
import com.jcboe.home.instruction.response.GradeListResp;
import com.jcboe.home.instruction.response.HIActivityResponseDTO;
import com.jcboe.home.instruction.response.HIFormMasterResp;
import com.jcboe.home.instruction.response.HIFormTransactionResp;
import com.jcboe.home.instruction.response.LookupDetails;
import com.jcboe.home.instruction.response.NotificationList;
import com.jcboe.home.instruction.response.SchoolResp;
import com.jcboe.home.instruction.response.StudentDataResp;
import com.jcboe.home.instruction.response.UpdateApplicationResp;
import com.jcboe.home.instruction.response.UpdateHIActivityResp;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@ExtendWith(MockitoExtension.class)
class ApplicationListServiceImplTest {

	@Mock
	private Utility utility;

	@Mock
	private ApplicationListRepo applicationListRepo;

	@Mock
	private UserDetailsRepo userDetailsRepo;

	@Mock
	private HomeInstructionRepo homeInstructionRepo;

	@Mock
	private FileUploadServiceImpl uploadService;

	@Mock
	private AppConfigRepo appConfigRepo;

	private ApplicationListServiceImpl service;

	@BeforeEach
	void setUp() {

		service = new ApplicationListServiceImpl(utility, applicationListRepo, userDetailsRepo, homeInstructionRepo,
				uploadService, appConfigRepo);

		Constant.getMessageMap().put(Constant.GAL_RFS, "Records Found");
		Constant.getMessageMap().put(Constant.GAL_RNF, "No Records Found");
		Constant.getMessageMap().put(Constant.GFI_RFS, "Application information found");
		Constant.getMessageMap().put(Constant.GFI_RNF, "Application information not found");
		Constant.getMessageMap().put(Constant.RHID_RUS, "Record updated successfully");
		Constant.getMessageMap().put(Constant.RHID_RDS, "Record deleted successfully");
		Constant.getMessageMap().put(Constant.RHID_UUR, "Unable to update record");
		Constant.getMessageMap().put(Constant.HSA_RFS, "Application tracking data fetched successfully");
		Constant.getMessageMap().put(Constant.HSA_RNF, "Application tracking data not found");
		Constant.getMessageMap().put(Constant.UHA_RUS, "Activity updated successfully");
		Constant.getMessageMap().put(Constant.UHA_UUR, "Unable to update activity");
	}

	@Test
	void testGetAppListRecordsFound() throws Exception {

		GetAppListReq req = new GetAppListReq();
		req.setSchoolYear("2025");

		ApplicationList app = new ApplicationList();

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2025-01-01");

		when(applicationListRepo.getApplicationDetails(req)).thenReturn(Arrays.asList(app));

		when(applicationListRepo.getAppDetailsCount(req)).thenReturn(Arrays.asList(10L));

		when(applicationListRepo.applicationStatusList(req.getLoggedInUserPersonType()))
				.thenReturn(Collections.emptyList());

		ApplicationListResponseDTO response = service.getAppList(req);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(10L, response.getCount());
		assertNotNull(response.getApplicationList());

		verify(applicationListRepo).getApplicationDetails(req);
		verify(applicationListRepo).getAppDetailsCount(req);
		verify(applicationListRepo).applicationStatusList(req.getLoggedInUserPersonType());
	}

	@Test
	void testGetAppListNoRecords() throws Exception {

		GetAppListReq req = new GetAppListReq();

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2025-01-01");

		when(applicationListRepo.getApplicationDetails(req)).thenReturn(Collections.emptyList());

		when(applicationListRepo.getAppDetailsCount(req)).thenReturn(Arrays.asList(0L));

		when(applicationListRepo.applicationStatusList(req.getLoggedInUserPersonType()))
				.thenReturn(Collections.emptyList());

		ApplicationListResponseDTO response = service.getAppList(req);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(0L, response.getCount());
		assertTrue(response.getApplicationList().isEmpty());
	}

	@Test
	void testGetAppListWithConfigKeysAndLookup() throws Exception {

		GetAppListReq req = new GetAppListReq();
		req.setConfigKeys("A,B");
		req.setLookupType("STATUS");

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		Map<String, String> config = new HashMap<>();
		config.put("A", "1");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2025-01-01");

		when(applicationListRepo.getApplicationDetails(req)).thenReturn(Arrays.asList(new ApplicationList()));

		when(applicationListRepo.getAppDetailsCount(req)).thenReturn(Arrays.asList(1L));

		when(applicationListRepo.applicationStatusList(req.getLoggedInUserPersonType()))
				.thenReturn(Collections.emptyList());

		when(userDetailsRepo.getLookupValues("STATUS")).thenReturn(lookupList);

		when(utility.getConfigList("A,B")).thenReturn(config);

		ApplicationListResponseDTO response = service.getAppList(req);

		assertNotNull(response);
		assertEquals(config, response.getConfigList());
		assertEquals(lookupList, response.getLookupList());

		verify(userDetailsRepo).getLookupValues("STATUS");
		verify(utility).getConfigList("A,B");
	}

	@Test
	void testGetAppListSummary() throws Exception {

		GetAppListReq req = new GetAppListReq();
		req.setSchoolYear("2025");
		req.setLoggedInUserId("1001");
		req.setLoggedInUserPersonType("STAFF");
		req.setIsSummery(true);

		List<ApplicationSummaryResp> summaryList = Arrays.asList(new ApplicationSummaryResp());

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2025-01-01");

		when(applicationListRepo.getApplicationDetails(req)).thenReturn(Arrays.asList(new ApplicationList()));

		when(applicationListRepo.getAppDetailsCount(req)).thenReturn(Arrays.asList(1L));

		when(applicationListRepo.applicationStatusList("STAFF")).thenReturn(Collections.emptyList());

		when(applicationListRepo.applicationSummary("2025", "1001", "STAFF")).thenReturn(summaryList);

		ApplicationListResponseDTO response = service.getAppList(req);

		assertNotNull(response);
		assertEquals(summaryList, response.getApplicationSummaryList());

		verify(applicationListRepo).applicationSummary("2025", "1001", "STAFF");
	}

	@Test
	void testGetAppListFilteredList() throws Exception {

		GetAppListReq req = new GetAppListReq();
		req.setIsFilteredList(true);

		List<SchoolResp> schoolList = Arrays.asList(new SchoolResp());

		List<GradeListResp> gradeList = Arrays.asList(new GradeListResp());

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2025-01-01");

		when(applicationListRepo.getApplicationDetails(req)).thenReturn(Arrays.asList(new ApplicationList()));

		when(applicationListRepo.getAppDetailsCount(req)).thenReturn(Arrays.asList(1L));

		when(applicationListRepo.applicationStatusList(req.getLoggedInUserPersonType()))
				.thenReturn(Collections.emptyList());

		when(applicationListRepo.getSchoolResp()).thenReturn(schoolList);

		when(applicationListRepo.getGradeList()).thenReturn(gradeList);

		ApplicationListResponseDTO response = service.getAppList(req);

		assertNotNull(response);
		assertEquals(schoolList, response.getSchoolList());
		assertEquals(gradeList, response.getGradeList());

		verify(applicationListRepo).getSchoolResp();
		verify(applicationListRepo).getGradeList();
	}

	@Test
	void testGetAppListWithoutSummaryAndFilter() throws Exception {

		GetAppListReq req = new GetAppListReq();

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2025-01-01");

		when(applicationListRepo.getApplicationDetails(req)).thenReturn(Arrays.asList(new ApplicationList()));

		when(applicationListRepo.getAppDetailsCount(req)).thenReturn(Arrays.asList(1L));

		when(applicationListRepo.applicationStatusList(req.getLoggedInUserPersonType()))
				.thenReturn(Collections.emptyList());

		ApplicationListResponseDTO response = service.getAppList(req);

		assertNotNull(response);

		verify(applicationListRepo, never()).applicationSummary(anyString(), anyString(), anyString());

		verify(applicationListRepo, never()).getSchoolResp();
		verify(applicationListRepo, never()).getGradeList();
	}

	@Test
	void testGetAppListException() throws Exception {

		GetAppListReq req = new GetAppListReq();

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.getApplicationDetails(req)).thenThrow(new RuntimeException("DB Error"));

		assertThrows(HomeInstructionException.class, () -> service.getAppList(req));
	}

	@Test
	void testGetApplicationInfoSuccess() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		Long formMasterId = 10L;
		String userType = "STAFF";

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		when(homeInstructionRepo.getApplicationInfoData(applicationId, userType))
				.thenReturn(Collections.singletonList(appInfo));

		GetApplicationInfoResp response = service.getApplicationInfo(id, applicationId, formMasterId, userType, null,
				null, userType, false, false, false, false, false);

		assertNotNull(response);

		verify(homeInstructionRepo).getApplicationInfoData(applicationId, userType);
	}

	@Test
	void testGetApplicationInfoWithConfigKeysAndLookupValues() throws Exception {

		Long id = 45L;
		Long applicationId = 56L;
		Long formMasterId = 78L;

		String userType = "PRNT";
		String configKeys = "A,B";
		String lookupValues = "STATUS";

		Map<String, String> config = new HashMap<>();

		config.put("A", "1");

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2025-01-01");

		when(homeInstructionRepo.getApplicationInfoData(applicationId, lookupValues))
				.thenReturn(Collections.singletonList(appInfo));

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupList);

		when(utility.getConfigList(configKeys)).thenReturn(config);

		GetApplicationInfoResp response = service.getApplicationInfo(id, applicationId, formMasterId, userType,
				configKeys, lookupValues, lookupValues, false, false, false, false, false);

		assertNotNull(response);
		assertEquals(config, response.getConfigList());

		verify(userDetailsRepo).getLookupValues(lookupValues);

		verify(utility).getConfigList(configKeys);
	}

	@Test
	void testGetApplicationInfoLookupValuesNotBlank() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		when(userDetailsRepo.getLookupValues("ABC")).thenReturn(new ArrayList<LookupDetails>());

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, "ABC", null, false, false, false, false,
				false);

		verify(userDetailsRepo).getLookupValues("ABC");
	}

	@Test
	void testGetApplicationInfoLookupValuesBlank() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null, false, false, false, false,
				false);

		verify(userDetailsRepo, never()).getLookupValues(anyString());
	}

	@Test
	void testGetApplicationInfoConfigKeysNotBlank() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		Map<String, String> configMap = new HashMap<>();

		configMap.put("ABC", "VALUE");

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		when(utility.getConfigList("ABC")).thenReturn(configMap);

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", "ABC", null, null, false, false, false, false,
				false);

		verify(utility).getConfigList("ABC");
	}

	@Test
	void testGetApplicationInfoConfigKeysBlank() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null, false, false, false, false,
				false);

		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetApplicationInfoFormMasterTrue() throws Exception {

		Long applicationId = 100L;
		String userType = "STAFF";

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, userType))
				.thenReturn(Collections.singletonList(appInfo));

		when(homeInstructionRepo.getHIFormMasterData(userType)).thenReturn(new ArrayList<HIFormMasterResp>());

		service.getApplicationInfo(1L, applicationId, 10L, userType, null, null, userType, true, false, false, false,
				false);

		verify(homeInstructionRepo).getHIFormMasterData(userType);
	}

	@Test
	void testGetApplicationInfoFormMasterFalse() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null, false, false, false, false,
				false);

		verify(homeInstructionRepo, never()).getHIFormMasterData(anyString());
	}

	@SuppressWarnings("deprecation")
	@Test
	void testGetApplicationInfoPdfDetailTrue() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		Long formMasterId = 10L;
		String userType = "STAFF";

		ApplicationInfoResp appInfo = mock(ApplicationInfoResp.class);

		when(appInfo.getSchoolYear()).thenReturn("2025-2026");

		when(homeInstructionRepo.getApplicationInfoData(applicationId, userType))
				.thenReturn(Collections.singletonList(appInfo));

		HttpServletResponse pdfResponse = (HttpServletResponse) ResponseEntity.ok("PDF");

		when(uploadService.getPdfFileDetails(eq(id), eq(applicationId), eq(formMasterId), eq(userType), eq("2025-2026"),
				isNull(HttpServletResponse.class))).thenReturn(pdfResponse);

		service.getApplicationInfo(id, applicationId, formMasterId, userType, null, null, userType, false, true, false,
				false, false);

		verify(uploadService).getPdfFileDetails(eq(id), eq(applicationId), eq(formMasterId), eq(userType),
				eq("2025-2026"), isNull(HttpServletResponse.class));
	}

	@Test
	void testGetApplicationInfoPdfDetailFalse() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null, false, false, false, false,
				false);

		verify(uploadService, never()).getPdfFileDetails(anyLong(), anyLong(), anyLong(), anyString(), anyString(),
				any(HttpServletResponse.class));
	}

	@Test
	void testGetApplicationInfoAttachmentTrue() throws Exception {

		Long applicationId = 100L;
		String userType = "STAFF";

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, userType))
				.thenReturn(Collections.singletonList(appInfo));

		when(homeInstructionRepo.getHIFormTransactionData(0L, applicationId, 0L, userType))
				.thenReturn(new ArrayList<HIFormTransactionResp>());

		service.getApplicationInfo(1L, applicationId, 10L, userType, null, null, userType, false, false, true, false,
				false);

		verify(homeInstructionRepo).getHIFormTransactionData(0L, applicationId, 0L, userType);
	}

	@Test
	void testGetApplicationInfoAttachmentFalse() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null, false, false, false, false,
				false);

		verify(homeInstructionRepo, never()).getHIFormTransactionData(anyLong(), anyLong(), anyLong(), anyString());
	}

	@Test
	void testGetApplicationInfoNotificationTrue() throws Exception {

		Long applicationId = 100L;
		String userType = "STAFF";

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, userType))
				.thenReturn(Collections.singletonList(appInfo));

		when(homeInstructionRepo.getNotificationList(applicationId, userType))
				.thenReturn(new ArrayList<NotificationList>());

		service.getApplicationInfo(1L, applicationId, 10L, userType, null, null, userType, false, false, false, true,
				false);

		verify(homeInstructionRepo).getNotificationList(applicationId, userType);
	}

	@Test
	void testGetApplicationInfoNotificationFalse() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null, false, false, false, false,
				false);

		verify(homeInstructionRepo, never()).getNotificationList(anyLong(), anyString());
	}

	@Test
	void testGetApplicationInfoStudentTrue() throws Exception {

		Long applicationId = 100L;
		String loggedInUserId = "USER001";

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		List<StudentDataResp> studentList = Arrays.asList(new StudentDataResp());

		when(homeInstructionRepo.getApplicationInfoData(applicationId, loggedInUserId))
				.thenReturn(Collections.singletonList(appInfo));

		when(appConfigRepo.getStudentData("", loggedInUserId)).thenReturn(studentList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		GetApplicationInfoResp response = service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null,
				loggedInUserId, false, false, false, false, true);

		assertNotNull(response);

		verify(appConfigRepo).getStudentData("", loggedInUserId);
	}

	@Test
	void testGetApplicationInfoStudentFalse() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null, false, false, false, false,
				false);

		verify(appConfigRepo, never()).getStudentData(anyString(), anyString());
	}

	@Test
	void testGetApplicationInfoNoData() throws Exception {

		Long applicationId = 100L;

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null)).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		GetApplicationInfoResp response = service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null,
				false, false, false, false, false);

		assertNotNull(response);

		verify(homeInstructionRepo).getApplicationInfoData(applicationId, null);
	}

	@Test
	void testGetApplicationInfoException() throws Exception {

		Long applicationId = 100L;

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenThrow(new RuntimeException("DB error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null, null, false, false, false,
						false, false));

		assertEquals("DB error", exception.getMessage());
	}

	@Test
	void testUpdateApplicationSuccess() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("U");
		request.setActivity("Application Updated");
		request.setComment("Test comment");
		request.setStatus("APPROVED");
		request.setSubmittedBy("testUser");
		request.setSubmittedByPersonType("STAFF");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenReturn(Arrays.asList(100L));

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Arrays.asList(new UpdateHIActivityResp()));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertTrue(response.getSuccess());

		verify(applicationListRepo).updateHIApplication(request);

		verify(applicationListRepo).updateHIActivity(any(UpdateHIActivityReq.class));

		verify(utility).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testUpdateApplicationDeleteSuccess() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("D");
		request.setActivity("Delete Application");
		request.setComment("Delete test");
		request.setStatus("DELETED");
		request.setSubmittedBy("testUser");
		request.setSubmittedByPersonType("STAFF");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenReturn(Arrays.asList(100L));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertTrue(response.getSuccess());

		verify(applicationListRepo).updateHIApplication(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateApplicationEmptyResponse() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("U");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertFalse(response.getSuccess());

		verify(applicationListRepo).updateHIApplication(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateApplicationUpdateFailed() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("U");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenReturn(Arrays.asList(0L));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertFalse(response.getSuccess());

		verify(applicationListRepo).updateHIApplication(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateApplicationNullResponse() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("U");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenReturn(null);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertFalse(response.getSuccess());

		verify(applicationListRepo).updateHIApplication(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateApplicationException() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("U");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenThrow(new RuntimeException("Database error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> service.updateApplication(request));

		assertEquals("Database error", exception.getMessage());

		verify(applicationListRepo).updateHIApplication(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateApplicationActivityRequestMapping() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("U");
		request.setActivity("UPDATE_ACTIVITY");
		request.setComment("Test Comment");
		request.setStatus("APPROVED");
		request.setSubmittedBy("john");
		request.setSubmittedByPersonType("STAFF");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenReturn(Arrays.asList(123L));

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenReturn(Arrays.asList(new UpdateHIActivityResp()));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertTrue(response.getSuccess());

		ArgumentCaptor<UpdateHIActivityReq> captor = ArgumentCaptor.forClass(UpdateHIActivityReq.class);

		verify(applicationListRepo).updateHIActivity(captor.capture());

		UpdateHIActivityReq activityRequest = captor.getValue();

		assertEquals(Long.valueOf(123L), activityRequest.getApplicationId());

		assertEquals("UPDATE_ACTIVITY", activityRequest.getActivity());

		assertEquals("Test Comment", activityRequest.getComment());

		assertEquals("APPROVED", activityRequest.getStatus());

		assertEquals("john", activityRequest.getActionTakenBy());

		assertEquals("STAFF", activityRequest.getActionTakenByPersonType());
	}

	@Test
	void testUpdateApplicationTrackingDataSuccess() throws Exception {

		ApplicationTrackingRequest request = new ApplicationTrackingRequest();

		request.setLoggedInUserId("1001");
		request.setLoggedInUserPersonType("STAFF");

		when(utility.printJson(request)).thenReturn("{}");

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/18/2026");

		ApplicationTrackingResp response = service.updateApplicationTrackingData(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(homeInstructionRepo, times(1)).updateApplicationTrackingData(request, "1001", "STAFF");

		verify(utility, times(1)).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testUpdateApplicationTrackingDataException() throws Exception {

		ApplicationTrackingRequest request = new ApplicationTrackingRequest();

		request.setLoggedInUserId("1001");
		request.setLoggedInUserPersonType("STAFF");

		when(utility.printJson(request)).thenReturn("{}");

		doThrow(new RuntimeException("Database error")).when(homeInstructionRepo).updateApplicationTrackingData(request,
				"1001", "STAFF");

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> service.updateApplicationTrackingData(request));

		assertEquals("Database error", exception.getMessage());

		verify(homeInstructionRepo, times(1)).updateApplicationTrackingData(request, "1001", "STAFF");
	}

	@Test
	void testGetApplicationTrackingDataSuccess() throws Exception {

		String applicationIds = "100";
		String schoolYear = "2026";
		String loggedInUser = "KfftbXVM2qI3/V2Mhy3MKQ==";
		String loggedInUserPersonType = "PRNT";
		String configKeys = "KEY1,KEY2";
		String lookupValues = "LOOKUP1";

		List<GetApplicationTrackingResp> trackingList = Arrays.asList(new GetApplicationTrackingResp());

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		Map<String, String> configMap = new HashMap<>();

		configMap.put("KEY1", "VALUE1");

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(lookupList);

		when(utility.getConfigList(configKeys)).thenReturn(configMap);

		when(homeInstructionRepo.getApplicationTrackingData(applicationIds, schoolYear, loggedInUser,
				loggedInUserPersonType)).thenReturn(trackingList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/18/2026");

		ApplicationTrackingResponseDTO response = service.getApplicationTrackingData(applicationIds, schoolYear,
				loggedInUser, loggedInUserPersonType, configKeys, lookupValues);

		assertNotNull(response);

		verify(userDetailsRepo).getLookupValues(lookupValues);

		verify(utility).getConfigList(configKeys);

		verify(homeInstructionRepo).getApplicationTrackingData(applicationIds, schoolYear, loggedInUser,
				loggedInUserPersonType);

		verify(utility).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testGetApplicationTrackingDataNoData() throws Exception {

		String applicationIds = "100";
		String schoolYear = "2026";
		String loggedInUser = "KfftbXVM2qI3/V2Mhy3MKQ==";
		String loggedInUserPersonType = "PRNT";
		String configKeys = "KEY1,KEY2";
		String lookupValues = "LOOKUP1";

		when(userDetailsRepo.getLookupValues(lookupValues)).thenReturn(new ArrayList<LookupDetails>());

		when(utility.getConfigList(configKeys)).thenReturn(new HashMap<String, String>());

		when(homeInstructionRepo.getApplicationTrackingData(applicationIds, schoolYear, loggedInUser,
				loggedInUserPersonType)).thenReturn(new ArrayList<GetApplicationTrackingResp>());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/18/2026");

		ApplicationTrackingResponseDTO response = service.getApplicationTrackingData(applicationIds, schoolYear,
				loggedInUser, loggedInUserPersonType, configKeys, lookupValues);

		assertNotNull(response);

		verify(homeInstructionRepo).getApplicationTrackingData(applicationIds, schoolYear, loggedInUser,
				loggedInUserPersonType);
	}

	@Test
	void testGetApplicationTrackingDataWithoutConfigAndLookup() throws Exception {

		String applicationIds = "100";
		String schoolYear = "2026";
		String loggedInUser = "USER001";
		String loggedInUserPersonType = "STAFF";

		List<GetApplicationTrackingResp> trackingList = Arrays.asList(new GetApplicationTrackingResp());

		when(homeInstructionRepo.getApplicationTrackingData(applicationIds, schoolYear, loggedInUser,
				loggedInUserPersonType)).thenReturn(trackingList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/18/2026");

		ApplicationTrackingResponseDTO response = service.getApplicationTrackingData(applicationIds, schoolYear,
				loggedInUser, loggedInUserPersonType, null, null);

		assertNotNull(response);

		verify(userDetailsRepo, never()).getLookupValues(anyString());

		verify(utility, never()).getConfigList(anyString());

		verify(homeInstructionRepo).getApplicationTrackingData(applicationIds, schoolYear, loggedInUser,
				loggedInUserPersonType);
	}

	@Test
	void testGetApplicationTrackingDataException() throws Exception {

		String applicationIds = "100";
		String schoolYear = "2026";
		String loggedInUser = "USER001";
		String loggedInUserPersonType = "PRNT";
		String configKeys = "KEY1";
		String lookupValues = "LOOKUP1";

		when(userDetailsRepo.getLookupValues(lookupValues)).thenThrow(new RuntimeException("Lookup database error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> service.getApplicationTrackingData(applicationIds, schoolYear, loggedInUser,
						loggedInUserPersonType, configKeys, lookupValues));

		assertEquals("Lookup database error", exception.getMessage());

		verify(userDetailsRepo).getLookupValues(lookupValues);

		verify(homeInstructionRepo, never()).getApplicationTrackingData(anyString(), anyString(), anyString(),
				anyString());
	}

	@Test
	void testUpdateActivitySuccess() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();

		request.setApplicationId(100L);
		request.setActionTakenBy("USER001");
		request.setActionTakenByPersonType("STAFF");
		request.setActivity("APPROVED");
		request.setComment("Approved successfully");
		request.setStatus("APPROVED");

		List<UpdateHIActivityResp> activityResponse = Arrays.asList(new UpdateHIActivityResp());

		List<NotificationList> notificationList = Arrays.asList(new NotificationList());

		when(utility.printJson(request)).thenReturn("{}");

		when(applicationListRepo.updateHIActivity(request)).thenReturn(activityResponse);

		when(homeInstructionRepo.getNotificationList(100L, "STAFF")).thenReturn(notificationList);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		HIActivityResponseDTO response = service.updateActivity(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(applicationListRepo).updateHIActivity(request);

		verify(homeInstructionRepo).getNotificationList(100L, "STAFF");

		verify(utility).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testUpdateActivityEmptyResponse() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();

		request.setApplicationId(100L);
		request.setActionTakenByPersonType("STAFF");

		when(utility.printJson(request)).thenReturn("{}");

		when(applicationListRepo.updateHIActivity(request)).thenReturn(Collections.emptyList());

		when(homeInstructionRepo.getNotificationList(100L, "STAFF")).thenReturn(new ArrayList<NotificationList>());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		HIActivityResponseDTO response = service.updateActivity(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(applicationListRepo).updateHIActivity(request);

		verify(homeInstructionRepo).getNotificationList(100L, "STAFF");
	}

	@Test
	void testUpdateActivityNullResponse() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();

		request.setApplicationId(100L);
		request.setActionTakenByPersonType("STAFF");

		when(utility.printJson(request)).thenReturn("{}");

		when(applicationListRepo.updateHIActivity(request)).thenReturn(null);

		when(homeInstructionRepo.getNotificationList(100L, "STAFF")).thenReturn(new ArrayList<NotificationList>());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		HIActivityResponseDTO response = service.updateActivity(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(applicationListRepo).updateHIActivity(request);

		verify(homeInstructionRepo).getNotificationList(100L, "STAFF");
	}

	@Test
	void testUpdateActivityException() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();

		request.setApplicationId(100L);
		request.setActionTakenByPersonType("STAFF");

		when(utility.printJson(request)).thenReturn("{}");

		when(applicationListRepo.updateHIActivity(request)).thenThrow(new RuntimeException("Activity DB error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> service.updateActivity(request));

		assertEquals("Activity DB error", exception.getMessage());

		verify(applicationListRepo).updateHIActivity(request);

		verify(homeInstructionRepo, never()).getNotificationList(anyLong(), anyString());
	}

	@Test
	void testGetAppListBlankLookupAndConfigKeys() throws Exception {

		GetAppListReq req = new GetAppListReq();
		req.setLookupType("");
		req.setConfigKeys("");

		when(utility.printJson(any())).thenReturn("{}");
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		when(applicationListRepo.getApplicationDetails(req)).thenReturn(Arrays.asList(new ApplicationList()));

		when(applicationListRepo.getAppDetailsCount(req)).thenReturn(Arrays.asList(1L));

		when(applicationListRepo.applicationStatusList(req.getLoggedInUserPersonType()))
				.thenReturn(Collections.emptyList());

		ApplicationListResponseDTO response = service.getAppList(req);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(userDetailsRepo, never()).getLookupValues(anyString());
		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetAppListPrintJsonReturnsNull() throws Exception {

		GetAppListReq req = new GetAppListReq();

		when(utility.printJson(any())).thenReturn(null);
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		when(applicationListRepo.getApplicationDetails(req)).thenReturn(Collections.emptyList());

		when(applicationListRepo.getAppDetailsCount(req)).thenReturn(Arrays.asList(0L));

		when(applicationListRepo.applicationStatusList(req.getLoggedInUserPersonType()))
				.thenReturn(Collections.emptyList());

		ApplicationListResponseDTO response = service.getAppList(req);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals(0L, response.getCount());
	}

	@Test
	void testGetApplicationInfoPdfDetailReturnsNull() throws Exception {

		Long id = 1L;
		Long applicationId = 100L;
		Long formMasterId = 10L;
		String userType = "STAFF";

		ApplicationInfoResp appInfo = mock(ApplicationInfoResp.class);

		when(appInfo.getSchoolYear()).thenReturn("2025-2026");

		when(homeInstructionRepo.getApplicationInfoData(applicationId, userType))
				.thenReturn(Collections.singletonList(appInfo));

		when(uploadService.getPdfFileDetails(eq(id), eq(applicationId), eq(formMasterId), eq(userType), eq("2025-2026"),
				isNull(HttpServletResponse.class))).thenReturn(null);

		GetApplicationInfoResp response = service.getApplicationInfo(id, applicationId, formMasterId, userType, null,
				null, userType, false, true, false, false, false);

		assertNotNull(response);

		verify(uploadService).getPdfFileDetails(eq(id), eq(applicationId), eq(formMasterId), eq(userType),
				eq("2025-2026"), isNull(HttpServletResponse.class));
	}

	@Test
	void testGetApplicationInfoBlankConfigAndLookup() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		GetApplicationInfoResp response = service.getApplicationInfo(1L, applicationId, 10L, "STAFF", "", "", null,
				false, false, false, false, false);

		assertNotNull(response);

		verify(userDetailsRepo, never()).getLookupValues(anyString());
		verify(utility, never()).getConfigList(anyString());
	}

	@Test
	void testGetApplicationInfoStudentReturnsNull() throws Exception {

		Long applicationId = 100L;

		ApplicationInfoResp appInfo = new ApplicationInfoResp();

		when(homeInstructionRepo.getApplicationInfoData(applicationId, null))
				.thenReturn(Collections.singletonList(appInfo));

		when(appConfigRepo.getStudentData("", "USER001")).thenReturn(null);

		GetApplicationInfoResp response = service.getApplicationInfo(1L, applicationId, 10L, "STAFF", null, null,
				"USER001", false, false, false, false, true);

		assertNotNull(response);

		verify(appConfigRepo).getStudentData("", "USER001");
	}

	@Test
	void testUpdateApplicationDeleteLowerCaseIndicator() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("d");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenReturn(Arrays.asList(100L));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertTrue(response.getSuccess());

		verify(applicationListRepo).updateHIApplication(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateApplicationActivityReturnsNull() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setIndicator("U");
		request.setActivity("UPDATE");
		request.setComment("Test");
		request.setStatus("APPROVED");
		request.setSubmittedBy("john");
		request.setSubmittedByPersonType("STAFF");

		when(utility.printJson(any())).thenReturn("{}");

		when(applicationListRepo.updateHIApplication(request)).thenReturn(Arrays.asList(100L));

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class))).thenReturn(null);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertTrue(response.getSuccess());

		verify(applicationListRepo).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateApplicationPrintJsonReturnsNull() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();
		request.setIndicator("D");

		when(utility.printJson(any())).thenReturn(null);

		when(applicationListRepo.updateHIApplication(request)).thenReturn(Arrays.asList(100L));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		UpdateApplicationResp response = service.updateApplication(request);

		assertNotNull(response);
		assertTrue(response.getSuccess());

		verify(applicationListRepo).updateHIApplication(request);
	}

	@Test
	void testUpdateApplicationTrackingDataPrintJsonNull() throws Exception {

		ApplicationTrackingRequest request = new ApplicationTrackingRequest();

		request.setLoggedInUserId("1001");
		request.setLoggedInUserPersonType("STAFF");

		when(utility.printJson(request)).thenReturn(null);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/18/2026");

		ApplicationTrackingResp response = service.updateApplicationTrackingData(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(homeInstructionRepo).updateApplicationTrackingData(request, "1001", "STAFF");
	}

	@Test
	void testGetApplicationTrackingDataBlankConfigAndLookup() throws Exception {

		String applicationIds = "100";
		String schoolYear = "2026";
		String loggedInUser = "USER001";
		String personType = "STAFF";

		when(homeInstructionRepo.getApplicationTrackingData(applicationIds, schoolYear, loggedInUser, personType))
				.thenReturn(Arrays.asList(new GetApplicationTrackingResp()));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("08/18/2026");

		ApplicationTrackingResponseDTO response = service.getApplicationTrackingData(applicationIds, schoolYear,
				loggedInUser, personType, "", "");

		assertNotNull(response);

		verify(userDetailsRepo, never()).getLookupValues(anyString());
		verify(utility, never()).getConfigList(anyString());

		verify(homeInstructionRepo).getApplicationTrackingData(applicationIds, schoolYear, loggedInUser, personType);
	}

	@Test
	void testUpdateActivityPrintJsonReturnsNull() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();

		request.setApplicationId(100L);
		request.setActionTakenByPersonType("STAFF");

		when(utility.printJson(request)).thenReturn(null);

		when(applicationListRepo.updateHIActivity(request)).thenReturn(Arrays.asList(new UpdateHIActivityResp()));

		when(homeInstructionRepo.getNotificationList(100L, "STAFF")).thenReturn(new ArrayList<NotificationList>());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("2026-01-01");

		HIActivityResponseDTO response = service.updateActivity(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(applicationListRepo).updateHIActivity(request);
		verify(homeInstructionRepo).getNotificationList(100L, "STAFF");
	}

	@Test
	void testUpdateAssignTeacher_EmptyUpdateList() throws Exception {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		when(applicationListRepo.updateAssignTeacher(request)).thenReturn(Collections.emptyList());

		AssignTeacherResponse response = service.updateAssignTeacher(request);

		assertNotNull(response);

		verify(applicationListRepo, times(1)).updateAssignTeacher(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateAssignTeacher_InvalidUpdateId() throws Exception {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		when(applicationListRepo.updateAssignTeacher(request)).thenReturn(Arrays.asList(0L));

		AssignTeacherResponse response = service.updateAssignTeacher(request);

		assertNotNull(response);

		verify(applicationListRepo, times(1)).updateAssignTeacher(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateAssignTeacher_EmptyUpdateList1() throws Exception {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		when(applicationListRepo.updateAssignTeacher(request)).thenReturn(Collections.emptyList());

		AssignTeacherResponse response = service.updateAssignTeacher(request);

		assertNotNull(response);

		verify(applicationListRepo, times(1)).updateAssignTeacher(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateAssignTeacher_InvalidUpdateId1() throws Exception {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		when(applicationListRepo.updateAssignTeacher(request)).thenReturn(Arrays.asList(0L));

		AssignTeacherResponse response = service.updateAssignTeacher(request);

		assertNotNull(response);

		verify(applicationListRepo, times(1)).updateAssignTeacher(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateAssignTeacher_Success() throws Exception {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		request.setApplicationId(100L);
		request.setActivity("UPDATE");
		request.setStatus("SUBMITTED");
		request.setComment("Teacher assigned");
		request.setActionTakenBy("USER123");
		request.setActionTakenByPersonType("STAFF");

		List<Long> updateAssignTeacherDataList = Arrays.asList(123L);

		when(applicationListRepo.updateAssignTeacher(request)).thenReturn(updateAssignTeacherDataList);

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class))).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(null);

		Constant.getMessageMap().put(Constant.UAT_TAS, "Assign Teacher updated successfully");

		ArgumentCaptor<UpdateHIActivityReq> captor = ArgumentCaptor.forClass(UpdateHIActivityReq.class);

		AssignTeacherResponse response = service.updateAssignTeacher(request);

		assertNotNull(response);

		verify(applicationListRepo, times(1)).updateAssignTeacher(request);

		verify(applicationListRepo, times(1)).updateHIActivity(captor.capture());

		UpdateHIActivityReq actualRequest = captor.getValue();

		assertEquals(100L, actualRequest.getApplicationId());
		assertEquals("UPDATE", actualRequest.getActivity());
		assertEquals("SUBMITTED", actualRequest.getStatus());
		assertEquals("Teacher assigned", actualRequest.getComment());
		assertEquals("USER123", actualRequest.getActionTakenBy());
		assertEquals("STAFF", actualRequest.getActionTakenByPersonType());

		verify(utility, times(1)).responseDate(any(LocalDateTime.class));
	}

	@Test
	void testUpdateAssignTeacher_Exception() throws Exception {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		when(applicationListRepo.updateAssignTeacher(request)).thenThrow(new RuntimeException("Database error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> service.updateAssignTeacher(request));

		assertNotNull(exception);
		assertEquals("Database error", exception.getMessage());

		verify(applicationListRepo, times(1)).updateAssignTeacher(request);

		verify(applicationListRepo, never()).updateHIActivity(any(UpdateHIActivityReq.class));
	}

	@Test
	void testUpdateAssignTeacher_ExceptionFromActivityUpdate() throws Exception {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		request.setApplicationId(100L);
		request.setActivity("UPDATE");
		request.setStatus("SUBMITTED");
		request.setComment("Test");
		request.setActionTakenBy("USER123");
		request.setActionTakenByPersonType("STAFF");

		// Positive ID so execution reaches updateHIActivity()
		when(applicationListRepo.updateAssignTeacher(request)).thenReturn(Arrays.asList(123L));

		when(applicationListRepo.updateHIActivity(any(UpdateHIActivityReq.class)))
				.thenThrow(new RuntimeException("Activity update failed"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> service.updateAssignTeacher(request));

		assertNotNull(exception);
		assertEquals("Activity update failed", exception.getMessage());

		verify(applicationListRepo, times(1)).updateAssignTeacher(request);

		verify(applicationListRepo, times(1)).updateHIActivity(any(UpdateHIActivityReq.class));
	}

}
