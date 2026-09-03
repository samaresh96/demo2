package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class GetApplicationInfoRespTest {

	@Test
	void testDefaultConstructorAndGettersSetters() {

		GetApplicationInfoResp resp = new GetApplicationInfoResp();

		Map<String, String> configList = new HashMap<>();
		configList.put("KEY1", "VALUE1");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		List<HIFormTransactionResp> attachmentList = new ArrayList<>();
		attachmentList.add(new HIFormTransactionResp());

		List<HIFormMasterResp> formMasterList = new ArrayList<>();
		formMasterList.add(new HIFormMasterResp());

		ApplicationInfoResp applicationInfo = new ApplicationInfoResp();

		List<NotificationList> notificationList = new ArrayList<>();
		notificationList.add(new NotificationList());

		List<StudentDataResp> studentList = new ArrayList<>();

		List<TeacherListResp> teacherList = new ArrayList<>();
		teacherList.add(new TeacherListResp());

		GetPhysicianInfoResp physicianData = new GetPhysicianInfoResp();

		ResponseEntity<String> pdfContent = ResponseEntity.ok("PDF Content");

		resp.setSuccess(true);
		resp.setMessage("Success");
		resp.setAccessedOn("2024-01-01");
		resp.setConfigList(configList);
		resp.setLookupList(lookupList);
		resp.setAttachmentList(attachmentList);
		resp.setFormMasterList(formMasterList);
		resp.setApplicationInfo(applicationInfo);
		resp.setPdfContent(pdfContent);
		resp.setNotificationList(notificationList);
		resp.setStudentList(studentList);
		resp.setTeacherList(teacherList);
		resp.setPhysicianData(physicianData);

		assertEquals(true, resp.isSuccess());
		assertEquals("Success", resp.getMessage());
		assertEquals("2024-01-01", resp.getAccessedOn());
		assertEquals(configList, resp.getConfigList());
		assertEquals(lookupList, resp.getLookupList());
		assertEquals(attachmentList, resp.getAttachmentList());
		assertEquals(formMasterList, resp.getFormMasterList());
		assertEquals(applicationInfo, resp.getApplicationInfo());
		assertEquals(pdfContent, resp.getPdfContent());
		assertEquals(notificationList, resp.getNotificationList());
		assertEquals(studentList, resp.getStudentList());
		assertEquals(teacherList, resp.getTeacherList());
		assertEquals(physicianData, resp.getPhysicianData());
	}

	@Test
	void testParameterizedConstructor() {

		Map<String, String> configList = new HashMap<>();
		configList.put("KEY1", "VALUE1");

		List<LookupDetails> lookupList = new ArrayList<>();
		lookupList.add(new LookupDetails());

		List<HIFormTransactionResp> attachmentList = new ArrayList<>();
		attachmentList.add(new HIFormTransactionResp());

		List<HIFormMasterResp> formMasterList = new ArrayList<>();
		formMasterList.add(new HIFormMasterResp());

		ApplicationInfoResp applicationInfo = new ApplicationInfoResp();

		ResponseEntity<String> pdfContent = ResponseEntity.ok("PDF Content");

		List<NotificationList> notificationList = new ArrayList<>();
		notificationList.add(new NotificationList());

		List<StudentDataResp> studentList = new ArrayList<>();

		List<TeacherListResp> teacherList = new ArrayList<>();
		teacherList.add(new TeacherListResp());

		GetPhysicianInfoResp physicianData = new GetPhysicianInfoResp();

		GetApplicationInfoResp resp = new GetApplicationInfoResp(true, "Success", "2024-01-01", configList, lookupList,
				attachmentList, formMasterList, applicationInfo, pdfContent, notificationList, studentList, teacherList,
				physicianData);

		assertEquals(true, resp.isSuccess());
		assertEquals("Success", resp.getMessage());
		assertEquals("2024-01-01", resp.getAccessedOn());
		assertEquals(configList, resp.getConfigList());
		assertEquals(lookupList, resp.getLookupList());
		assertEquals(attachmentList, resp.getAttachmentList());
		assertEquals(formMasterList, resp.getFormMasterList());
		assertEquals(applicationInfo, resp.getApplicationInfo());
		assertEquals(pdfContent, resp.getPdfContent());
		assertEquals(notificationList, resp.getNotificationList());
		assertEquals(studentList, resp.getStudentList());
		assertEquals(teacherList, resp.getTeacherList());
		assertEquals(physicianData, resp.getPhysicianData());
	}

	@Test
	void testToString() {

		GetApplicationInfoResp resp = new GetApplicationInfoResp();

		resp.setSuccess(true);
		resp.setMessage("Success");
		resp.setAccessedOn("2024-01-01");

		String expectedString = "GetApplicationInfoResp [success=true, message=Success, accessedOn=2024-01-01, "
				+ "configList=null, lookupList=null, attachmentList=null, formMasterList=null, "
				+ "applicationInfo=null, pdfContent=null, notificationList=null, studentList=null, "
				+ "teacherList=null, physicianData=null]";

		assertEquals(expectedString, resp.toString());
	}
}
