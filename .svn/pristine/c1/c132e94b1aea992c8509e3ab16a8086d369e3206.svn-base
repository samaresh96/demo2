package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ApplicationListResponseDTOTest {

	@Test
	void testNoArgsConstructor() {
		ApplicationListResponseDTO dto = new ApplicationListResponseDTO();

		assertNotNull(dto);
	}

	@Test
	void testParameterizedConstructor() {
		boolean success = true;
		String message = "Success";
		String accessedOn = "2026-08-21";

		Map<String, Object> configList = new HashMap<>();
		configList.put("key", "value");

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		List<ApplicationList> applicationList = Arrays.asList(new ApplicationList());

		long count = 10L;

		List<AppStatusListResp> statusList = Arrays.asList(new AppStatusListResp());

		ApplicationListResponseDTO dto = new ApplicationListResponseDTO(success, message, accessedOn, configList,
				lookupList, applicationList, count, statusList, null, null, null);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
		assertEquals(applicationList, dto.getApplicationList());
		assertEquals(count, dto.getCount());
		assertEquals(statusList, dto.getStatusList());
	}

	@Test
	void testGettersAndSetters() {
		ApplicationListResponseDTO dto = new ApplicationListResponseDTO();

		boolean success = true;
		String message = "Application list retrieved successfully";
		String accessedOn = "2026-08-21T19:00:00";

		Map<String, Object> configList = new HashMap<>();
		configList.put("status", "ACTIVE");

		List<LookupDetails> lookupList = Arrays.asList(new LookupDetails());

		List<ApplicationList> applicationList = Arrays.asList(new ApplicationList());

		long count = 25L;

		List<AppStatusListResp> statusList = Arrays.asList(new AppStatusListResp());

		List<ApplicationSummaryResp> applicationSummaryList = Arrays
				.asList(new ApplicationSummaryResp("APP", "Approved", 5L));

		List<SchoolResp> schoolList = Arrays.asList(new SchoolResp(101L, "SCH001", "ABC High School"));

		List<GradeListResp> gradeList = Arrays.asList(new GradeListResp(10, "Grade 10"));

		dto.setSuccess(success);
		dto.setMessage(message);
		dto.setAccessedOn(accessedOn);
		dto.setConfigList(configList);
		dto.setLookupList(lookupList);
		dto.setApplicationList(applicationList);
		dto.setCount(count);
		dto.setStatusList(statusList);
		dto.setApplicationSummaryList(applicationSummaryList);
		dto.setSchoolList(schoolList);
		dto.setGradeList(gradeList);

		assertEquals(success, dto.isSuccess());
		assertEquals(message, dto.getMessage());
		assertEquals(accessedOn, dto.getAccessedOn());
		assertEquals(configList, dto.getConfigList());
		assertEquals(lookupList, dto.getLookupList());
		assertEquals(applicationList, dto.getApplicationList());
		assertEquals(count, dto.getCount());
		assertEquals(statusList, dto.getStatusList());
		assertEquals(applicationSummaryList, dto.getApplicationSummaryList());
		assertEquals(schoolList, dto.getSchoolList());
		assertEquals(gradeList, dto.getGradeList());
	}

	@Test
	void testToString() {
		ApplicationListResponseDTO dto = new ApplicationListResponseDTO();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, dto.toString());
	}
}