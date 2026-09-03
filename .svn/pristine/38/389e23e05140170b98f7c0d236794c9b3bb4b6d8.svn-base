package com.jcboe.home.instruction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.GetStudentInfoReqById;
import com.jcboe.home.instruction.repo.AppConfigRepo;
import com.jcboe.home.instruction.response.GetStudentParentInfoResp;
import com.jcboe.home.instruction.response.IdsKeyValue;
import com.jcboe.home.instruction.response.ScreenTextResponse;
import com.jcboe.home.instruction.response.StudentDataResp;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@ExtendWith(MockitoExtension.class)
class AppConfigServiceImplTest {

	@Mock
	private Utility utility;

	@Mock
	private AppConfigRepo appConfigRepo;

	@InjectMocks
	private AppConfigServiceImpl appConfigService;

	@Test
	void testGetScreenTextValues_screenIdZero() {

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		ScreenTextResponse response = appConfigService.getScreenTextValues(0, 1);

		assertFalse(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.APP_SIM), response.getMessage());

		assertEquals(new HashMap<String, String>(), response.getScreenTexts());

		assertEquals(now, response.getAccessedOn());
	}

	@Test
	void testGetScreenTextValues_success() throws Exception {

		IdsKeyValue kv1 = new IdsKeyValue("key1", "value1");

		IdsKeyValue kv2 = new IdsKeyValue("key2", "value2");

		List<IdsKeyValue> list = Arrays.asList(kv1, kv2);

		when(appConfigRepo.getScreenTextDetails(1, 1)).thenReturn(list);

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		ScreenTextResponse response = appConfigService.getScreenTextValues(1, 1);

		assertTrue(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.APP_RFS), response.getMessage());

		assertNotNull(response.getScreenTexts());

		assertEquals(2, response.getScreenTexts().size());

		assertEquals("value1", response.getScreenTexts().get("key1"));

		assertEquals("value2", response.getScreenTexts().get("key2"));

		assertEquals(now, response.getAccessedOn());
	}

	@Test
	void testGetScreenTextValues_invalidKeyMinusOne() throws Exception {

		IdsKeyValue kv = new IdsKeyValue("-1", "value");

		List<IdsKeyValue> list = Collections.singletonList(kv);

		when(appConfigRepo.getScreenTextDetails(1, 1)).thenReturn(list);

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		ScreenTextResponse response = appConfigService.getScreenTextValues(1, 1);

		assertFalse(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.APP_NRF), response.getMessage());

		assertEquals(new HashMap<String, String>(), response.getScreenTexts());
	}

	@Test
	void testGetScreenTextValues_invalidKeyMinusTwo() throws Exception {

		IdsKeyValue kv = new IdsKeyValue("-2", "value");

		List<IdsKeyValue> list = Collections.singletonList(kv);

		when(appConfigRepo.getScreenTextDetails(1, 1)).thenReturn(list);

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		ScreenTextResponse response = appConfigService.getScreenTextValues(1, 1);

		assertFalse(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.APP_NRF), response.getMessage());

		assertEquals(new HashMap<String, String>(), response.getScreenTexts());
	}

	@Test
    void testGetScreenTextValues_emptyList() throws Exception {

        when(appConfigRepo.getScreenTextDetails(1, 1))
                .thenReturn(Collections.emptyList());

        String now = String.valueOf(LocalDateTime.now());

        when(utility.responseDate(any(LocalDateTime.class)))
                .thenReturn(now);

        ScreenTextResponse response =
                appConfigService.getScreenTextValues(1, 1);

        assertFalse(response.isSuccess());

        assertEquals(
                Constant.getMessageMap().get(Constant.APP_NRF),
                response.getMessage()
        );

        assertEquals(
                new HashMap<String, String>(),
                response.getScreenTexts()
        );
    }

	@Test
    void testGetScreenTextValues_nullList() throws Exception {

        when(appConfigRepo.getScreenTextDetails(1, 1))
                .thenReturn(null);

        String now = String.valueOf(LocalDateTime.now());

        when(utility.responseDate(any(LocalDateTime.class)))
                .thenReturn(now);

        ScreenTextResponse response =
                appConfigService.getScreenTextValues(1, 1);

        assertFalse(response.isSuccess());

        assertEquals(
                Constant.getMessageMap().get(Constant.APP_NRF),
                response.getMessage()
        );

        assertEquals(
                new HashMap<String, String>(),
                response.getScreenTexts()
        );
    }

	@Test
    void testGetScreenTextValues_sqlException() throws Exception {

        when(appConfigRepo.getScreenTextDetails(1, 1))
                .thenThrow(new SQLException("DB error"));

        HomeInstructionException exception =
                assertThrows(
                        HomeInstructionException.class,
                        () -> appConfigService.getScreenTextValues(1, 1)
                );

        assertNotNull(exception);
    }

	@Test
	void testGetStudentInfoByStudentId_successWithConfigKeys() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("KEY1,KEY2");

		StudentDataResp studentData = new StudentDataResp();

		List<StudentDataResp> studentDataList = Collections.singletonList(studentData);

		Map<String, String> configList = new HashMap<>();

		configList.put("KEY1", "VALUE1");
		configList.put("KEY2", "VALUE2");

		when(utility.getConfigList("KEY1,KEY2")).thenReturn(configList);

		when(appConfigRepo.getStudentData("123", "")).thenReturn(studentDataList);

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		GetStudentParentInfoResp response = appConfigService.getStudentInfoByStudentId(request);

		assertNotNull(response);

		assertTrue(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GSF_RFS), response.getMessage());

		assertEquals(now, response.getAccessedOn());

		assertEquals(configList, response.getConfigList());
	}

	@Test
	void testGetStudentInfoByStudentId_successWithoutConfigKeys() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("");

		StudentDataResp studentData = new StudentDataResp();

		List<StudentDataResp> studentDataList = Collections.singletonList(studentData);

		when(appConfigRepo.getStudentData("123", "")).thenReturn(studentDataList);

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		GetStudentParentInfoResp response = appConfigService.getStudentInfoByStudentId(request);

		assertNotNull(response);

		assertTrue(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GSF_RFS), response.getMessage());

		assertEquals(now, response.getAccessedOn());

		assertEquals(Collections.emptyMap(), response.getConfigList());
	}

	@Test
	void testGetStudentInfoByStudentId_blankConfigKeys() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("   ");

		StudentDataResp studentData = new StudentDataResp();

		List<StudentDataResp> studentDataList = Collections.singletonList(studentData);

		when(appConfigRepo.getStudentData("123", "")).thenReturn(studentDataList);

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		GetStudentParentInfoResp response = appConfigService.getStudentInfoByStudentId(request);

		assertNotNull(response);

		assertTrue(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GSF_RFS), response.getMessage());

		assertEquals(Collections.emptyMap(), response.getConfigList());
	}

	@Test
	void testGetStudentInfoByStudentId_noStudentData() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("");

		when(appConfigRepo.getStudentData("123", "")).thenReturn(Collections.emptyList());

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		GetStudentParentInfoResp response = appConfigService.getStudentInfoByStudentId(request);

		assertNotNull(response);

		assertFalse(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GSF_RNS), response.getMessage());

		assertEquals(Collections.emptyMap(), response.getConfigList());
	}

	@Test
	void testGetStudentInfoByStudentId_nullStudentData() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("");

		when(appConfigRepo.getStudentData("123", "")).thenReturn(null);

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		GetStudentParentInfoResp response = appConfigService.getStudentInfoByStudentId(request);

		assertNotNull(response);

		assertFalse(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GSF_RNS), response.getMessage());

		assertEquals(Collections.emptyMap(), response.getConfigList());
	}

	@Test
	void testGetStudentInfoByStudentId_repositoryException() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("");

		when(appConfigRepo.getStudentData("123", "")).thenThrow(new RuntimeException("Database error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> appConfigService.getStudentInfoByStudentId(request));

		assertNotNull(exception);
	}

	@Test
	void testGetStudentInfoByStudentId_printJsonReturnsValue() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("");

		StudentDataResp studentData = new StudentDataResp();
		List<StudentDataResp> studentDataList = Collections.singletonList(studentData);

		when(utility.printJson(request)).thenReturn("{\"studentId\":\"123\"}");

		when(appConfigRepo.getStudentData("123", "")).thenReturn(studentDataList);

		String now = String.valueOf(LocalDateTime.now());
		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		GetStudentParentInfoResp response = appConfigService.getStudentInfoByStudentId(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		assertEquals(Constant.getMessageMap().get(Constant.GSF_RFS), response.getMessage());

		assertEquals(now, response.getAccessedOn());

		assertEquals(Collections.emptyMap(), response.getConfigList());
	}

	@Test
	void testGetStudentInfoByStudentId_configListException() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("KEY1,KEY2");

		when(utility.getConfigList("KEY1,KEY2")).thenThrow(new RuntimeException("Config error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> appConfigService.getStudentInfoByStudentId(request));

		assertNotNull(exception);
		assertEquals("Config error", exception.getMessage());
	}

	@Test
	void testGetStudentInfoByStudentId_printJsonException() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		request.setStudentId("123");
		request.setCalledFrom("TEST");
		request.setConfigKeys("");

		when(utility.printJson(request)).thenThrow(new RuntimeException("JSON error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> appConfigService.getStudentInfoByStudentId(request));

		assertNotNull(exception);
		assertEquals("JSON error", exception.getMessage());

	}

	@Test
	void testGetScreenTextValues_duplicateKeys() throws Exception {

		IdsKeyValue kv1 = new IdsKeyValue("key1", "value1");
		IdsKeyValue kv2 = new IdsKeyValue("key1", "value2");

		List<IdsKeyValue> list = Arrays.asList(kv1, kv2);

		when(appConfigRepo.getScreenTextDetails(1, 1)).thenReturn(list);

		String now = String.valueOf(LocalDateTime.now());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn(now);

		ScreenTextResponse response = appConfigService.getScreenTextValues(1, 1);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		assertEquals(1, response.getScreenTexts().size());

		assertEquals("value2", response.getScreenTexts().get("key1"));

		assertEquals(now, response.getAccessedOn());
	}

	@Test
	void testGetStudentInfoByStudentId_nullRequest() {

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> appConfigService.getStudentInfoByStudentId(null));

		assertNotNull(exception);
	}

}