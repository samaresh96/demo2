package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GetAppListReqTest {

	@Test
	void testDefaultConstructor() {
		GetAppListReq request = new GetAppListReq();

		assertNotNull(request);
	}

	@Test
	void testParameterizedConstructor() {
		String configKeys = "CONFIG_KEY_001";
		String lookupType = "APPLICATION";
		String schoolYear = "2026-2027";
		String status = "ACTIVE";
		String student = "STUDENT001";
		String schoolCode = "SCH001";
		Integer gradeId = 5;
		String applicationNo = "APP001";
		String applicationDate = "2026-08-17";
		Boolean allApplication = true;
		int pagesize = 10;
		int pagenumber = 1;
		String loggedInUserId = "USER001";
		String loggedInUserPersonType = "PRNT";

		GetAppListReq request = new GetAppListReq(configKeys, lookupType, schoolYear, status, student, schoolCode,
				gradeId, applicationNo, applicationDate, allApplication, pagesize, pagenumber, loggedInUserId,
				loggedInUserPersonType);

		assertEquals(configKeys, request.getConfigKeys());
		assertEquals(lookupType, request.getLookupType());
		assertEquals(schoolYear, request.getSchoolYear());
		assertEquals(status, request.getStatus());
		assertEquals(student, request.getstudent());
		assertEquals(schoolCode, request.getSchoolCode());
		assertEquals(gradeId, request.getGradeId());
		assertEquals(applicationNo, request.getApplicationNo());
		assertEquals(applicationDate, request.getApplicationDate());
		assertEquals(allApplication, request.getAllApplication());
		assertEquals(pagesize, request.getPagesize());
		assertEquals(pagenumber, request.getPagenumber());
		assertEquals(loggedInUserId, request.getLoggedInUserId());
		assertEquals(loggedInUserPersonType, request.getLoggedInUserPersonType());

		// These fields are not part of the parameterized constructor.
		assertEquals(null, request.getIsSummery());
		assertEquals(null, request.getIsFilteredList());
	}

	@Test
	void testSettersAndGetters() {
		GetAppListReq request = new GetAppListReq();

		request.setConfigKeys("CONFIG_KEY_002");
		request.setLookupType("STUDENT");
		request.setSchoolYear("2025-2026");
		request.setStatus("PENDING");
		request.setstudent("STUDENT002");
		request.setSchoolCode("SCH002");
		request.setGradeId(8);
		request.setApplicationNo("APP002");
		request.setApplicationDate("2026-08-18");
		request.setAllApplication(false);
		request.setPagesize(20);
		request.setPagenumber(2);
		request.setLoggedInUserId("USER002");
		request.setLoggedInUserPersonType("NURSE");
		request.setIsSummery(true);
		request.setIsFilteredList(false);

		assertEquals("CONFIG_KEY_002", request.getConfigKeys());
		assertEquals("STUDENT", request.getLookupType());
		assertEquals("2025-2026", request.getSchoolYear());
		assertEquals("PENDING", request.getStatus());
		assertEquals("STUDENT002", request.getstudent());
		assertEquals("SCH002", request.getSchoolCode());
		assertEquals(Integer.valueOf(8), request.getGradeId());
		assertEquals("APP002", request.getApplicationNo());
		assertEquals("2026-08-18", request.getApplicationDate());
		assertEquals(Boolean.FALSE, request.getAllApplication());
		assertEquals(20, request.getPagesize());
		assertEquals(2, request.getPagenumber());
		assertEquals("USER002", request.getLoggedInUserId());
		assertEquals("NURSE", request.getLoggedInUserPersonType());
		assertEquals(Boolean.TRUE, request.getIsSummery());
		assertEquals(Boolean.FALSE, request.getIsFilteredList());
	}

	@Test
	void testToString() {
		GetAppListReq request = new GetAppListReq("CONFIG_KEY_001", "APPLICATION", "2026-2027", "ACTIVE", "STUDENT001",
				"SCH001", 5, "APP001", "2026-08-17", true, 10, 1, "USER001", "PRNT");

		String expectedString = "GetAppListReq [configKeys=CONFIG_KEY_001" + ", lookupType=APPLICATION"
				+ ", schoolYear=2026-2027" + ", status=ACTIVE" + ", student=STUDENT001" + ", schoolCode=SCH001"
				+ ", gradeId=5" + ", applicationNo=APP001" + ", applicationDate=2026-08-17" + ", allApplication=true"
				+ ", pagesize=10" + ", pagenumber=1" + ", loggedInUserId=USER001" + ", loggedInUserPersonType=PRNT"
				+ ", isSummery=null" + ", isFilteredList=null]";

		assertEquals(expectedString, request.toString());
	}
}
