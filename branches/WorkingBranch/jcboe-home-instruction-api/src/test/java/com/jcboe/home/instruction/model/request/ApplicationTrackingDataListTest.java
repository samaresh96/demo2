package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ApplicationTrackingDataListTest {

	 @Test
	    void testNoArgsConstructor() {
	        ApplicationTrackingDataList data = new ApplicationTrackingDataList();

	        assertNotNull(data);
	    }

	    @Test
	    void testAllArgsConstructorAndGetters() {
	        Long applicationTrackingId = 1L;
	        String verificationDate = "01/01/2026";
	        String studentName = "John Doe";
	        String noticeDate30Day = "01/30/2026";
	        String noticeDate60Day = "03/01/2026";
	        String cstAction = "Approved";
	        String returnDate = "03/15/2026";
	        Long applicationId = 100L;
	        String schoolYear = "2025-2026";
	        String school = "ABC School";
	        String grade = "5";
	        String indicator = "Y";

	        ApplicationTrackingDataList data = new ApplicationTrackingDataList(
	                applicationTrackingId,
	                verificationDate,
	                studentName,
	                noticeDate30Day,
	                noticeDate60Day,
	                cstAction,
	                returnDate,
	                applicationId,
	                schoolYear,
	                school,
	                grade,
	                indicator
	        );

	        assertEquals(applicationTrackingId, data.getApplicationTrackingId());
	        assertEquals(verificationDate, data.getVerificationDate());
	        assertEquals(studentName, data.getStudentName());
	        assertEquals(noticeDate30Day, data.getNoticeDate30Day());
	        assertEquals(noticeDate60Day, data.getNoticeDate60Day());
	        assertEquals(cstAction, data.getCstAction());
	        assertEquals(returnDate, data.getReturnDate());
	        assertEquals(applicationId, data.getApplicationId());
	        assertEquals(schoolYear, data.getSchoolYear());
	        assertEquals(school, data.getSchool());
	        assertEquals(grade, data.getGrade());
	        assertEquals(indicator, data.getIndicator());
	    }

	    @Test
	    void testSettersAndGetters() {
	        ApplicationTrackingDataList data = new ApplicationTrackingDataList();

	        data.setApplicationTrackingId(1L);
	        data.setVerificationDate("01/01/2026");
	        data.setStudentName("John Doe");
	        data.setNoticeDate30Day("01/30/2026");
	        data.setNoticeDate60Day("03/01/2026");
	        data.setCstAction("Approved");
	        data.setReturnDate("03/15/2026");
	        data.setApplicationId(100L);
	        data.setSchoolYear("2025-2026");
	        data.setSchool("ABC School");
	        data.setGrade("5");
	        data.setIndicator("Y");

	        assertEquals(1L, data.getApplicationTrackingId());
	        assertEquals("01/01/2026", data.getVerificationDate());
	        assertEquals("John Doe", data.getStudentName());
	        assertEquals("01/30/2026", data.getNoticeDate30Day());
	        assertEquals("03/01/2026", data.getNoticeDate60Day());
	        assertEquals("Approved", data.getCstAction());
	        assertEquals("03/15/2026", data.getReturnDate());
	        assertEquals(100L, data.getApplicationId());
	        assertEquals("2025-2026", data.getSchoolYear());
	        assertEquals("ABC School", data.getSchool());
	        assertEquals("5", data.getGrade());
	        assertEquals("Y", data.getIndicator());
	    }
	
	@Test
	void testToString() {

		AdminLogInReq request = new AdminLogInReq("admin001", "password123", "CONFIG_KEY", "ADMIN");

		String result = request.toString();

	}

}
