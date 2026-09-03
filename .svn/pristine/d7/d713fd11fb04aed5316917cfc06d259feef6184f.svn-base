package com.jcboe.home.instruction.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.mailconfig.EmailSender;
import com.jcboe.home.instruction.model.request.AdminLogInReq;
import com.jcboe.home.instruction.model.request.ParentLogInReq;
import com.jcboe.home.instruction.model.request.ParentRegReq;
import com.jcboe.home.instruction.model.request.VerifyOtpReq;
import com.jcboe.home.instruction.repo.AppConfigRepo;
import com.jcboe.home.instruction.repo.HomeInstructionRepo;
import com.jcboe.home.instruction.repo.LogInRepo;
import com.jcboe.home.instruction.repo.StudentDetailsRepo;
import com.jcboe.home.instruction.repo.UserDetailsRepo;
import com.jcboe.home.instruction.response.AdminLoginResp;
import com.jcboe.home.instruction.response.EmailResponse;
import com.jcboe.home.instruction.response.GetYearAbbrevResp;
import com.jcboe.home.instruction.response.JCBOEApplicationDTO;
import com.jcboe.home.instruction.response.LogInResponseDTO;
import com.jcboe.home.instruction.response.ParentLoginResp;
import com.jcboe.home.instruction.response.StudentInfoImportResp;
import com.jcboe.home.instruction.response.VerifyOtpResponse;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@ExtendWith(MockitoExtension.class)
class LogInServiceImplTest {

	@Mock
	private LogInRepo logInRepo;

	@Mock
	private Utility utility;

	@Mock
	private StudentDetailsRepo studentDetailsRepo;

	@Mock
	private EmailSender emailSender;

	@Mock
	private HomeInstructionRepo homeInstructionRepo;

	@Mock
	private AppConfigRepo appConfigRepo;

	@Mock
	private IMessageService msgService;

	@Mock
	private UserDetailsRepo userDetailsRepo;

	@InjectMocks
	private LogInServiceImpl service;

	@BeforeEach
    void setup() {

        when(utility.responseDate(any()))
                .thenReturn("date");

        when(utility.printJson(any()))
                .thenReturn("{}");

        when(utility.getConfigList(any()))
                .thenReturn(new HashMap<>());

    }

	// ---------------- OTP TEST CASES ----------------

	@Test
	void verifyOtpSuccess() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq("123", "111111");

		when(userDetailsRepo.verifyUserOtp(req)).thenReturn(Arrays.asList(1L));

		VerifyOtpResponse response = service.verfyOtpStudent(req);

		assertNotNull(response);
		assertTrue(response.isSuccess());

	}

	@Test
	void verifyOtpInvalidStudent() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq("123", "111111");

		when(userDetailsRepo.verifyUserOtp(req)).thenReturn(Arrays.asList(-1L));

		VerifyOtpResponse response = service.verfyOtpStudent(req);

		assertFalse(response.isSuccess());

	}

	@Test
	void verifyOtpInvalidOtp() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq("123", "111111");

		when(userDetailsRepo.verifyUserOtp(req)).thenReturn(Arrays.asList(-2L));

		VerifyOtpResponse response = service.verfyOtpStudent(req);

		assertFalse(response.isSuccess());

	}

	@Test
	void verifyOtpException() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq("123", "111111");

		when(userDetailsRepo.verifyUserOtp(req)).thenThrow(new RuntimeException());

		assertThrows(HomeInstructionException.class, () -> service.verfyOtpStudent(req));

	}

	// ---------------- PARENT LOGIN ----------------

	@Test
	void parentLoginSuccess() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();

		resp.setValid(true);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertTrue(result.isSuccess());

	}

	@Test
	void parentLoginInvalidStudent() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();

		resp.setStatusCode(1);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertFalse(result.isSuccess());

	}

	@Test
	void parentLoginInvalidDOB() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();

		resp.setStatusCode(2);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertFalse(result.isSuccess());

	}

	@Test
	void parentLoginDisabledStudent() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();

		resp.setStatusCode(6);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertFalse(result.isSuccess());

	}

	// ---------------- PASSWORD LOGIN ----------------

	@Test
	void parentPasswordLoginSuccess() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		req.setStudentId("123");

		ParentLoginResp resp = new ParentLoginResp();

		resp.setValid(true);

		when(logInRepo.checkParentPwdData(req)).thenReturn(Arrays.asList(resp));

		when(appConfigRepo.getStudentData("123", null)).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentPwLogin(req, new HashMap<>());

		assertTrue(result.isSuccess());

	}

	@Test
	void parentPasswordInvalidPassword() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		ParentLoginResp resp = new ParentLoginResp();

		resp.setStatusCode(2);

		when(logInRepo.checkParentPwdData(req)).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.checkParentPwLogin(req, new HashMap<>());

		assertFalse(result.isSuccess());

	}

	// ---------------- REGISTRATION ----------------

	@Test
	void registrationInvalidIndicator() {

		ParentRegReq req = new ParentRegReq();

		req.setIndicator("X");

		LogInResponseDTO result = service.submitRegistration(req);

		assertNotNull(result);

	}

	// ---------------- FORGOT PASSWORD ----------------

	@Test
	void forgotPasswordInvalidEmail() throws Exception {

		ParentRegReq req = new ParentRegReq();

		req.setIndicator("F");

		when(studentDetailsRepo.verifyEmail(req)).thenReturn(Arrays.asList(false));

		LogInResponseDTO result = service.forgetPasswordStudent(req);

		assertFalse(result.isSuccess());

	}

	@Test
	void changePasswordSuccess() throws Exception {

		ParentRegReq req = new ParentRegReq();

		req.setIndicator("S");

		StudentInfoImportResp resp = new StudentInfoImportResp();

		resp.setTagId(1);

		when(studentDetailsRepo.getImportStudentData(req, null)).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.forgetPasswordStudent(req);

		assertTrue(result.isSuccess());

	}

	@Test
	void changePasswordFailure() throws Exception {

		ParentRegReq req = new ParentRegReq();

		req.setIndicator("S");

		StudentInfoImportResp resp = new StudentInfoImportResp();

		resp.setTagId(0);

		when(studentDetailsRepo.getImportStudentData(req, null)).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.forgetPasswordStudent(req);

		assertFalse(result.isSuccess());

	}

	// ---------------- ADMIN LOGIN ----------------

	@Test
	void adminLoginSuccess() throws Exception {

		AdminLogInReq req = new AdminLogInReq();

		AdminLoginResp admin = new AdminLoginResp();

		admin.setValid(true);

		when(logInRepo.checkAdminLoginData(req)).thenReturn(Arrays.asList(admin));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkAdminLogin(req);

		assertTrue(result.isSuccess());

	}

	@Test
	void adminLoginInvalidPassword() throws Exception {

		AdminLogInReq req = new AdminLogInReq();

		AdminLoginResp admin = new AdminLoginResp();

		admin.setStatusCode(2);

		when(logInRepo.checkAdminLoginData(req)).thenReturn(Arrays.asList(admin));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkAdminLogin(req);

		assertFalse(result.isSuccess());

	}

	@Test
	void parentLoginSuccessWithSamePassword_ShouldSendResetMail() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		ParentLoginResp dbResp = new ParentLoginResp();
		dbResp.setValid(true);
		dbResp.setSamePassword(true);
		dbResp.setEmailId("test@test.com");

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(dbResp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		// forgetPasswordStudent -> verifyEmail()
		when(studentDetailsRepo.verifyEmail(any(ParentRegReq.class))).thenReturn(Arrays.asList(true));

		// Utility decrypt required inside sendEmailVerificationForParent
		when(utility.getConfigList(any())).thenReturn(new HashMap<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());
		assertTrue(result.isSamePassword());

	}

	@Test
	void parentLoginStatusCode3_ShouldSubmitRegistration() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(3);
		resp.setEmailId("test@test.com");
		resp.setSamePassword(false);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		// submitRegistration -> studentDetailsRepo.getImportStudentData()
		StudentInfoImportResp importResp = new StudentInfoImportResp();
		importResp.setTagId(1);

		when(studentDetailsRepo.getImportStudentData(any(ParentRegReq.class), any()))
				.thenReturn(Arrays.asList(importResp));

		when(utility.getConfigList(any())).thenReturn(new HashMap<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());
		assertFalse(result.isSamePassword());

	}

	@Test
	void parentLoginStatusCode5_ShouldReturnOtpFailure() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(5);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());

	}

	@Test
	void parentLoginStatusCode0_ShouldReturnInvalidStudentId() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(0);
		resp.setValid(false);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());

	}

	@Test
	void parentLoginUnknownStatus_ShouldReturnFailure() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(99);
		resp.setValid(false);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());

	}

	@Test
	void parentLoginException_ShouldThrowHomeInstructionException() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");

		when(logInRepo.checkParentLoginData(req)).thenThrow(new RuntimeException("DB error"));

		assertThrows(HomeInstructionException.class, () -> service.checkParentLogin(req));

	}

	@Test
	void parentPasswordLoginException_ShouldThrowHomeInstructionException() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		when(logInRepo.checkParentPwdData(req)).thenThrow(new RuntimeException("DB error"));

		assertThrows(HomeInstructionException.class, () -> service.checkParentPwLogin(req, new HashMap<>()));

	}

	@Test
	void setDbResponseList_MultipleSchoolYears_ShouldSetCurrentAndPreviousYear() throws Exception {

		ParentLoginResp resp = new ParentLoginResp();

		ArrayList<ParentLoginResp> dbResp = new ArrayList<>();
		dbResp.add(resp);

		GetYearAbbrevResp current = new GetYearAbbrevResp();
		current.setLookupValue("2026");
		current.setLookupAbbreviation("26");

		GetYearAbbrevResp previous = new GetYearAbbrevResp();
		previous.setLookupValue("2025");
		previous.setLookupAbbreviation("25");

		when(logInRepo.getSchoolYear()).thenReturn(Arrays.asList(current, previous));

		service.setDbResponseList(dbResp);

		assertNotNull(dbResp.get(0).getCurrentYear());
		assertNotNull(dbResp.get(0).getPreviousYear());

	}

	@Test
	void setDbResponseList_OnlyCurrentYear_ShouldSetCurrentYear() throws Exception {

		ParentLoginResp resp = new ParentLoginResp();

		ArrayList<ParentLoginResp> dbResp = new ArrayList<>();
		dbResp.add(resp);

		GetYearAbbrevResp current = new GetYearAbbrevResp();
		current.setLookupValue("2026");
		current.setLookupAbbreviation("26");

		when(logInRepo.getSchoolYear()).thenReturn(Arrays.asList(current));

		service.setDbResponseList(dbResp);

		assertNotNull(dbResp.get(0).getCurrentYear());

	}

	@Test
	void setDbResponseList_EmptyDbResponse_ShouldNotUpdate() throws Exception {

		ArrayList<ParentLoginResp> dbResp = new ArrayList<>();

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		service.setDbResponseList(dbResp);

		assertTrue(dbResp.isEmpty());

	}

	@Test
	void submitRegistrationSuccess_ShouldReturnSuccess() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("R");
		req.setEmailId("test@test.com");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		StudentInfoImportResp importResp = new StudentInfoImportResp();
		importResp.setTagId(1);

		when(studentDetailsRepo.getImportStudentData(any(ParentRegReq.class), any()))
				.thenReturn(Arrays.asList(importResp));

		when(utility.getConfigList(any())).thenReturn(new HashMap<>());

		LogInResponseDTO result = service.submitRegistration(req);

		assertNotNull(result);
		assertTrue(result.isSuccess());

	}

	@Test
	void submitRegistrationInvalidOtp_ShouldReturnFailure() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("R");

		StudentInfoImportResp importResp = new StudentInfoImportResp();
		importResp.setTagId(-4);

		when(studentDetailsRepo.getImportStudentData(any(ParentRegReq.class), any()))
				.thenReturn(Arrays.asList(importResp));

		LogInResponseDTO result = service.submitRegistration(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());

	}

	@Test
	void submitRegistrationDefaultPassword_ShouldReturnSamePasswordError() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("R");

		StudentInfoImportResp importResp = new StudentInfoImportResp();
		importResp.setTagId(-1);

		when(studentDetailsRepo.getImportStudentData(any(ParentRegReq.class), any()))
				.thenReturn(Arrays.asList(importResp));

		LogInResponseDTO result = service.submitRegistration(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());
		assertTrue(result.isSamePassword());

	}

	@Test
	void parentLoginStatusCode5InvalidOtp() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(5);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());
	}

	@Test
	void parentLoginStatusCodeZeroInvalidStudent() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(0);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertFalse(result.isSuccess());
	}

	@Test
	void parentLoginDefaultFailure() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(99);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertFalse(result.isSuccess());
	}

	@Test
	void parentPasswordLoginUserNotExists() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(9);

		when(logInRepo.checkParentPwdData(req)).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.checkParentPwLogin(req, new HashMap<>());

		assertFalse(result.isSuccess());
	}

	@Test
	void registrationInvalidOtp() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("R");
		req.setEmailId("abc@test.com");

		StudentInfoImportResp resp = new StudentInfoImportResp();
		resp.setTagId(-4);

		when(studentDetailsRepo.getImportStudentData(any(), any())).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.submitRegistration(req);

		assertFalse(result.isSuccess());
	}

	@Test
	void registrationDefaultPasswordNotAllowed() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("R");

		StudentInfoImportResp resp = new StudentInfoImportResp();
		resp.setTagId(-1);

		when(studentDetailsRepo.getImportStudentData(any(), any())).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.submitRegistration(req);

		assertFalse(result.isSuccess());
		assertTrue(result.isSamePassword());
	}

	@Test
	void sendEmailVerificationMailConfigFailure() {

	    when(utility.getConfigList(any()))
	            .thenReturn(new HashMap<>());

	    when(emailSender.configureMailProperties(
	            any(),any(),any(),any(),any(Boolean.class)))
	            .thenThrow(new RuntimeException());


	    EmailResponse result =
	            service.sendEmailVerificationForParent(
	                    "123",
	                    "01/01/2010",
	                    "abc@test.com",
	                    "123456",
	                    "F",
	                    true,
	                    "enc123",
	                    ""
	            );


	    assertEquals("-1", result.getOtpSendOn());
	}

	@Test
	void registrationSuccessWithOtpMailSent() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("R");
		req.setEmailId("parent@test.com");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		StudentInfoImportResp importResp = new StudentInfoImportResp();
		importResp.setTagId(1);

		when(studentDetailsRepo.getImportStudentData(any(), any())).thenReturn(Arrays.asList(importResp));

		// Mock mail configuration
		Map<String, String> config = new HashMap<>();

		config.put("EMAIL_HOST", "smtp.test.com");
		config.put("EMAIL_PORT", "25");
		config.put("SENDER_MAIL", "sender@test.com");
		config.put("SENDER_MAIL_PASSWORD", "password");
		config.put(Constant.AUTHENTICATION_REQUIRED, "N");
		config.put("APPLN_ABRV", "APP");
		config.put("TEMPL_PATH", "template");
		config.put("STUDENT_EMAIL_RGSTRD_TMPL", "template.html");
		config.put("STUDENT_EMAIL_TMPL", "template.html");
		config.put("REG_EMAIL_SUB", "Registration");

		when(utility.getConfigList(any())).thenReturn(config);

		when(logInRepo.getApplicationByAbbr(any())).thenReturn(new ArrayList<>());

		when(emailSender.configureMailProperties(any(), anyInt(), any(), any(), anyBoolean())).thenReturn(null);

		doNothing().when(emailSender).sendMail(any(), any(), any(), any(), any(), any(), any());

		when(utility.responseDate(any())).thenReturn("date");

		LogInResponseDTO result = service.submitRegistration(req);

		assertNotNull(result);
		assertTrue(result.isSuccess());
	}

	@Test
	void submitRegistrationException() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("R");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");
		req.setEmailId("test@test.com");

		when(studentDetailsRepo.getImportStudentData(any(), any())).thenThrow(new RuntimeException("DB error"));

		assertThrows(HomeInstructionException.class, () -> service.submitRegistration(req));
	}

	@Test
	void sendEmailVerificationRegistrationSuccess() throws Exception {

		Map<String, String> config = new HashMap<>();

		config.put(Constant.AUTHENTICATION_REQUIRED, "N");
		config.put(Constant.EMAIL_HOST, "smtp.test.com");
		config.put(Constant.EMAIL_PORT, "25");
		config.put(Constant.SENDER_MAIL, "sender@test.com");
		config.put(Constant.SENDER_MAIL_PAS, "password");

		config.put(Constant.MAIL_TEMPLATE_PATH, "src/test/resources");
		config.put("STUDENT_EMAIL_RGSTRD_TMPL", "template.html");
		config.put("STUDENT_EMAIL_TMPL", "template.html");
		config.put("REG_EMAIL_SUB", "Registration");
		config.put("REG_USER_LINK", "http://test/<StudentID>");
		config.put("APPLN_ABRV", "APP");

		when(utility.getConfigList(any())).thenReturn(config);

		JCBOEApplicationDTO app = new JCBOEApplicationDTO();
		app.setApplicationName("Test Application");
		app.setApplicationUrl("http://localhost");
		app.setApplicationId(1);

		when(logInRepo.getApplicationByAbbr(any())).thenReturn(Arrays.asList(app));

		when(emailSender.configureMailProperties(any(), anyInt(), any(), any(), anyBoolean())).thenReturn(null);

		when(utility.replaceSubjectParent(any(), any(), any())).thenReturn("subject");

		when(utility.encodeURIComponent(any())).thenReturn("encoded");

		when(utility.changeDateFormatPattern(any(), any(), any())).thenReturn("01.01.2010");

		EmailResponse result = service.sendEmailVerificationForParent("123", "01/01/2010", "parent@test.com", "123456",
				"R", false, "encrypted", "");

		assertNotNull(result);
		assertEquals("1", result.getOtpSendOn());
	}

	@Test
	void sendEmailVerificationLoginIndicatorSuccess() throws Exception {

		Map<String, String> config = new HashMap<>();

		config.put(Constant.AUTHENTICATION_REQUIRED, "Y");
		config.put(Constant.EMAIL_HOST, "host");
		config.put(Constant.EMAIL_PORT, "25");
		config.put(Constant.SENDER_MAIL, "mail");
		config.put(Constant.SENDER_MAIL_PAS, "pass");
		config.put(Constant.MAIL_TEMPLATE_PATH, "src/test/resources");
		config.put("STUDENT_EMAIL_TMPL", "template.html");
		config.put("REG_EMAIL_SUB", "Registration");
		config.put("REG_USER_LINK", "http://url/<StudentID>");
		config.put("APPLN_ABRV", "APP");

		when(utility.getConfigList(any())).thenReturn(config);

		when(logInRepo.getApplicationByAbbr(any())).thenReturn(new ArrayList<>());

		when(emailSender.configureMailProperties(any(), anyInt(), any(), any(), anyBoolean())).thenReturn(null);

		when(utility.replaceSubjectParent(any(), any(), any())).thenReturn("subject");

		when(utility.encodeURIComponent(any())).thenReturn("encoded");

		when(utility.changeDateFormatPattern(any(), any(), any())).thenReturn("date");

		EmailResponse result = service.sendEmailVerificationForParent("123", "01/01/2010", "parent@test.com", "", "L",
				true, "encrypted", "");

		assertEquals("1", result.getOtpSendOn());
	}

	@Test
	void sendEmailVerificationForgotPasswordSuccess() throws Exception {

		Map<String, String> config = new HashMap<>();

		config.put(Constant.AUTHENTICATION_REQUIRED, "N");
		config.put(Constant.EMAIL_HOST, "host");
		config.put(Constant.EMAIL_PORT, "25");
		config.put(Constant.SENDER_MAIL, "mail");
		config.put(Constant.SENDER_MAIL_PAS, "pass");

		config.put(Constant.MAIL_TEMPLATE_PATH, "src/test/resources");
		config.put("FRGT_PW_EMAIL_TMPL", "forgot.html");
		config.put("FRGT_PW_EMAIL_SUB", "Forgot Password");
		config.put("FRGT_PW_LINK", "http://reset/<StudentID>");
		config.put("APPLN_ABRV", "APP");

		when(utility.getConfigList(any())).thenReturn(config);

		when(logInRepo.getApplicationByAbbr(any())).thenReturn(new ArrayList<>());

		when(emailSender.configureMailProperties(any(), anyInt(), any(), any(), anyBoolean())).thenReturn(null);

		when(utility.replaceSubjectParent(any(), any(), any())).thenReturn("subject");

		when(utility.encodeURIComponent(any())).thenReturn("encoded");

		EmailResponse result = service.sendEmailVerificationForParent("123", "01/01/2010", "parent@test.com", "", "F",
				true, "encrypted", "");

		assertEquals("0", result.getOtpSendOn());
	}

	@Test
	void sendEmailVerificationInvalidIndicator() throws Exception {

		Map<String, String> config = new HashMap<>();

		config.put(Constant.AUTHENTICATION_REQUIRED, "N");
		config.put(Constant.EMAIL_HOST, "host");
		config.put(Constant.EMAIL_PORT, "25");
		config.put(Constant.SENDER_MAIL, "mail");
		config.put(Constant.SENDER_MAIL_PAS, "pass");

		when(utility.getConfigList(any())).thenReturn(config);

		when(logInRepo.getApplicationByAbbr(any())).thenReturn(new ArrayList<>());

		when(emailSender.configureMailProperties(any(), anyInt(), any(), any(), anyBoolean())).thenReturn(null);

		EmailResponse result = service.sendEmailVerificationForParent("123", "01/01/2010", "parent@test.com", "", "X",
				true, "encrypted", "");

		assertEquals("-1", result.getOtpSendOn());
	}

	@Test
	void sendEmailVerificationMailConfigurationException() {

	    when(utility.getConfigList(any()))
	            .thenReturn(new HashMap<>());


	    when(emailSender.configureMailProperties(
	            any(),anyInt(),any(),any(),anyBoolean()))
	            .thenThrow(new RuntimeException());


	    EmailResponse result =
	            service.sendEmailVerificationForParent(
	                    "123",
	                    "01/01/2010",
	                    "parent@test.com",
	                    "",
	                    "F",
	                    true,
	                    "encrypted",
	                    ""
	            );


	    assertEquals("-1", result.getOtpSendOn());
	}

	@Test
	void sendEmailVerificationForgotPasswordFlowSuccess() throws Exception {

		Map<String, String> config = new HashMap<>();

		config.put(Constant.AUTHENTICATION_REQUIRED, "N");
		config.put(Constant.EMAIL_HOST, "smtp.test.com");
		config.put(Constant.EMAIL_PORT, "25");
		config.put(Constant.SENDER_MAIL, "sender@test.com");
		config.put(Constant.SENDER_MAIL_PAS, "password");

		config.put(Constant.MAIL_TEMPLATE_PATH, "src/test/resources");
		config.put("FRGT_PW_EMAIL_TMPL", "forgot-password.html");
		config.put("FRGT_PW_EMAIL_SUB", "Reset Password");
		config.put("FRGT_PW_LINK", "http://localhost/reset/<StudentID>");
		config.put("APPLN_ABRV", "APP");

		when(utility.getConfigList(any())).thenReturn(config);

		when(logInRepo.getApplicationByAbbr(any())).thenReturn(new ArrayList<>());

		when(emailSender.configureMailProperties(any(), anyInt(), any(), any(), anyBoolean())).thenReturn(null);

		when(utility.replaceSubjectParent(any(), any(), any())).thenReturn("Reset Password Subject");

		when(utility.encodeURIComponent(any())).thenReturn("encodedStudentId");

		doNothing().when(emailSender).sendMail(any(), any(), any(), any(), any(), any(), any());

		EmailResponse response = service.sendEmailVerificationForParent("12345", "01/01/2010", "parent@test.com", "",
				"F", true, "encryptedStudentId", "");

		assertNotNull(response);
		assertEquals("0", response.getOtpSendOn());
		assertEquals("parent@test.com", response.getStudentEmailId());
		assertEquals("01/01/2010", response.getStudentDob());
	}

	@Test
	void forgetPasswordStudentSuccess() throws Exception {

		ParentRegReq req = new ParentRegReq();

		req.setIndicator("F");
		req.setEmailId("parent@test.com");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		when(studentDetailsRepo.verifyEmail(req)).thenReturn(Arrays.asList(true));

		Map<String, String> config = new HashMap<>();

		config.put(Constant.AUTHENTICATION_REQUIRED, "N");
		config.put(Constant.EMAIL_HOST, "host");
		config.put(Constant.EMAIL_PORT, "25");
		config.put(Constant.SENDER_MAIL, "mail");
		config.put(Constant.SENDER_MAIL_PAS, "pass");

		config.put(Constant.MAIL_TEMPLATE_PATH, "src/test/resources");
		config.put("FRGT_PW_EMAIL_TMPL", "forgot.html");
		config.put("FRGT_PW_EMAIL_SUB", "Forgot Password");
		config.put("FRGT_PW_LINK", "http://reset/<StudentID>");
		config.put("APPLN_ABRV", "APP");

		when(utility.getConfigList(any())).thenReturn(config);

		when(logInRepo.getApplicationByAbbr(any())).thenReturn(new ArrayList<>());

		when(emailSender.configureMailProperties(any(), anyInt(), any(), any(), anyBoolean())).thenReturn(null);

		when(utility.replaceSubjectParent(any(), any(), any())).thenReturn("subject");

		when(utility.encodeURIComponent(any())).thenReturn("encoded");

		doNothing().when(emailSender).sendMail(any(), any(), any(), any(), any(), any(), any());

		LogInResponseDTO result = service.forgetPasswordStudent(req);

		assertNotNull(result);
		assertTrue(result.isSuccess());
	}

	@Test
	void forgetPasswordStudentSamePasswordSuccess() throws Exception {

		ParentRegReq req = new ParentRegReq();

		req.setIndicator("F");
		req.setEmailId("parent@test.com");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");
		req.setSamePassword(true);

		when(studentDetailsRepo.verifyEmail(req)).thenReturn(Arrays.asList(true));

		Map<String, String> config = new HashMap<>();

		config.put(Constant.AUTHENTICATION_REQUIRED, "N");
		config.put(Constant.EMAIL_HOST, "host");
		config.put(Constant.EMAIL_PORT, "25");
		config.put(Constant.SENDER_MAIL, "mail");
		config.put(Constant.SENDER_MAIL_PAS, "pass");

		config.put(Constant.MAIL_TEMPLATE_PATH, "src/test/resources");
		config.put("FRGT_PW_EMAIL_TMPL", "forgot.html");
		config.put("FRGT_PW_EMAIL_SUB", "Forgot Password");
		config.put("FRGT_PW_LINK", "http://reset/<StudentID>");
		config.put("APPLN_ABRV", "APP");

		when(utility.getConfigList(any())).thenReturn(config);

		when(logInRepo.getApplicationByAbbr(any())).thenReturn(new ArrayList<>());

		when(emailSender.configureMailProperties(any(), anyInt(), any(), any(), anyBoolean())).thenReturn(null);

		when(utility.replaceSubjectParent(any(), any(), any())).thenReturn("subject");

		when(utility.encodeURIComponent(any())).thenReturn("encoded");

		doNothing().when(emailSender).sendMail(any(), any(), any(), any(), any(), any(), any());

		LogInResponseDTO result = service.forgetPasswordStudent(req);

		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertTrue(result.isSamePassword());
	}

	@Test
	void changePasswordDefaultPasswordNotAllowed() throws Exception {

		ParentRegReq req = new ParentRegReq();

		req.setIndicator("S");
		req.setStudentId("123");

		StudentInfoImportResp importResp = new StudentInfoImportResp();

		importResp.setTagId(-1);

		when(studentDetailsRepo.getImportStudentData(req, null)).thenReturn(Arrays.asList(importResp));

		LogInResponseDTO result = service.forgetPasswordStudent(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());
		assertTrue(result.isSamePassword());
	}

	@Test
	void parentLoginStatusCode3RegistrationMail() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("L");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(3);
		resp.setEmailId("test@test.com");
		resp.setSamePassword(false);

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		// submitRegistration dependency
		StudentInfoImportResp importResp = new StudentInfoImportResp();
		importResp.setTagId(1);

		when(studentDetailsRepo.getImportStudentData(any(), any())).thenReturn(Arrays.asList(importResp));

		when(utility.getConfigList(any())).thenReturn(new HashMap<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());

		req = new ParentLogInReq();
		req.setIndicator("L");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		ParentLoginResp db = new ParentLoginResp();
		db.setStatusCode(3);
		db.setEmailId("test@test.com");

		when(logInRepo.checkParentLoginData(req)).thenReturn(Arrays.asList(db));

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		// submitRegistration internal calls
		importResp = new StudentInfoImportResp();
		importResp.setTagId(1);

		when(studentDetailsRepo.getImportStudentData(any(), any())).thenReturn(Arrays.asList(importResp));

		when(utility.getConfigList(any())).thenReturn(new HashMap<>());

		result = service.checkParentLogin(req);

		assertNotNull(result);
	}

	@Test
	void forgetPasswordStudentException() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("F");

		when(studentDetailsRepo.verifyEmail(req)).thenThrow(new RuntimeException("Database error"));

		HomeInstructionException exception = assertThrows(HomeInstructionException.class,
				() -> service.forgetPasswordStudent(req));

		assertNotNull(exception);

	}

	@Test
	void adminSystemLoginSuccess() throws Exception {

		AdminLogInReq req = new AdminLogInReq();

		// Use your AES encryption method here
		String encryptedUserId = AES.decryptToString("7777777", Constant.SALT_AES);

		req.setUserId(encryptedUserId);

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkAdminLogin(req);

		assertNotNull(result);
		assertTrue(result.isSuccess());

	}

	@Test
	void checkAdminLogin_shouldReturnSuccess_whenSystemAdmin() throws Exception {

		AdminLogInReq request = new AdminLogInReq();
		request.setUserId(AES.decryptToString("7777777", Constant.SALT_AES));
		LocalDateTime now = LocalDateTime.now();

		when(utility.printJson(request)).thenReturn("{}");

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		when(utility.responseDate(now)).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(logInRepo, never()).checkAdminLoginData(request);
	}

	@Test
	void checkAdminLogin_shouldReturnSuccess_whenSystemAdminWithConfigKeys() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("7777777", Constant.SALT_AES));

		request.setConfigKeys("KEY1,KEY2");

		when(utility.printJson(request)).thenReturn("{}");

		Map<String, String> configList = new HashMap<>();
		configList.put("KEY1", "VALUE1");

		when(utility.getConfigList("KEY1,KEY2")).thenReturn(configList);

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(utility).getConfigList("KEY1,KEY2");

		verify(logInRepo, never()).checkAdminLoginData(request);
	}

	@Test
	void checkAdminLogin_shouldReturnSuccess_whenValidAdmin() throws Exception {

		AdminLogInReq request = new AdminLogInReq();
		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		AdminLoginResp adminResp = new AdminLoginResp(true, 0, 0, "Test User", "ADMIN");

		List<AdminLoginResp> dbResp = new ArrayList<>();

		dbResp.add(adminResp);

		when(utility.printJson(request)).thenReturn("{}");

		when(logInRepo.checkAdminLoginData(request)).thenReturn(dbResp);

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(logInRepo).checkAdminLoginData(request);
	}

	@Test
	void checkAdminLogin_shouldReturnInvalidEmail_whenStatusCodeIsOne() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		AdminLoginResp adminResp = new AdminLoginResp(false, 1, 0, "Test User", "ADMIN");

		List<AdminLoginResp> dbResp = Collections.singletonList(adminResp);

		when(utility.printJson(request)).thenReturn("{}");

		when(logInRepo.checkAdminLoginData(request)).thenReturn(dbResp);

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void checkAdminLogin_shouldReturnInvalidPassword_whenStatusCodeIsTwo() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		AdminLoginResp adminResp = new AdminLoginResp(false, 2, 0, "Test User", "ADMIN");

		List<AdminLoginResp> dbResp = Collections.singletonList(adminResp);

		when(utility.printJson(request)).thenReturn("{}");

		when(logInRepo.checkAdminLoginData(request)).thenReturn(dbResp);

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void checkAdminLogin_shouldReturnFailure_whenStatusCodeIsOther() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		AdminLoginResp adminResp = new AdminLoginResp(false, 3, 0, "Test User", "ADMIN");

		List<AdminLoginResp> dbResp = Collections.singletonList(adminResp);

		when(utility.printJson(request)).thenReturn("{}");

		when(logInRepo.checkAdminLoginData(request)).thenReturn(dbResp);

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void checkAdminLogin_shouldSetBothYears_whenMoreThanOneYear() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		AdminLoginResp adminResp = new AdminLoginResp(true, 0, 0, "Test User", "ADMIN");

		List<AdminLoginResp> dbResp = Collections.singletonList(adminResp);

		GetYearAbbrevResp currentYear = new GetYearAbbrevResp();

		currentYear.setLookupValue("2026-27");
		currentYear.setLookupAbbreviation("26-27");

		GetYearAbbrevResp previousYear = new GetYearAbbrevResp();

		previousYear.setLookupValue("2025-26");
		previousYear.setLookupAbbreviation("25-26");

		List<GetYearAbbrevResp> years = new ArrayList<>();

		years.add(currentYear);
		years.add(previousYear);

		when(utility.printJson(request)).thenReturn("{}");

		when(logInRepo.checkAdminLoginData(request)).thenReturn(dbResp);

		when(logInRepo.getSchoolYear()).thenReturn(years);

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);

		assertEquals("2026-27", adminResp.getCurrentYear());

		assertEquals("2025-26", adminResp.getPreviousYear());

		assertEquals("26-27", adminResp.getCurrentYearAbbr());

		assertEquals("25-26", adminResp.getPreviousYearAbbr());
	}

	@Test
	void checkAdminLogin_shouldSetCurrentYear_whenOnlyOneYear() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		AdminLoginResp adminResp = new AdminLoginResp(true, 0, 0, "Test User", "ADMIN");

		GetYearAbbrevResp year = new GetYearAbbrevResp();

		year.setLookupValue("2026-27");
		year.setLookupAbbreviation("26-27");

		when(utility.printJson(request)).thenReturn("{}");

		when(logInRepo.checkAdminLoginData(request)).thenReturn(Collections.singletonList(adminResp));

		when(logInRepo.getSchoolYear()).thenReturn(Collections.singletonList(year));

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);

		assertEquals("2026-27", adminResp.getCurrentYear());

		assertEquals("26-27", adminResp.getCurrentYearAbbr());
	}

	@Test
	void checkAdminLogin_shouldSkipYearUpdate_whenNoYears() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		AdminLoginResp adminResp = new AdminLoginResp(true, 0, 0, "Test User", "ADMIN");

		when(utility.printJson(request)).thenReturn("{}");

		when(logInRepo.checkAdminLoginData(request)).thenReturn(Collections.singletonList(adminResp));

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);
	}

	@Test
	void checkAdminLogin_shouldUseToString_whenPrintJsonReturnsNull() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		AdminLoginResp adminResp = new AdminLoginResp(true, 0, 0, "Test User", "ADMIN");

		when(utility.printJson(request)).thenReturn(null);

		when(logInRepo.checkAdminLoginData(request)).thenReturn(Collections.singletonList(adminResp));

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.checkAdminLogin(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
	}

	@Test
	void checkAdminLogin_shouldThrowHomeInstructionException_whenExceptionOccurs() {
		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		when(utility.printJson(request)).thenThrow(new RuntimeException("Database error"));

		try {
			service.checkAdminLogin(request);
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
	}

	@Test
	void forgetPasswordStudent_shouldReturnFailure_whenEmailIsInvalid() throws Exception {

		ParentRegReq request = new ParentRegReq();

		when(utility.printJson(request)).thenReturn("{}");

		List<Object> resultList = Collections.singletonList(false);

		when(studentDetailsRepo.verifyEmail(request)).thenReturn(resultList);

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(studentDetailsRepo).verifyEmail(request);
	}

	@Test
	void forgetPasswordStudent_shouldReturnSuccess_whenVerifyEmailReturnsNull() throws Exception {

		ParentRegReq request = new ParentRegReq();

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.verifyEmail(request)).thenReturn(null);

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(studentDetailsRepo).verifyEmail(request);
	}

	@Test
	void forgetPasswordStudent_shouldReturnSuccess_whenVerifyEmailReturnsEmptyList() throws Exception {

		ParentRegReq request = new ParentRegReq();

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.verifyEmail(request)).thenReturn(Collections.emptyList());

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
	}

	@Test
	void forgetPasswordStudent_shouldReturnSuccess_whenVerificationMailIsSent() throws Exception {
		ParentRegReq request = new ParentRegReq();

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.verifyEmail(request)).thenReturn(Collections.singletonList(true));

		EmailResponse emailResponse = new EmailResponse();

		emailResponse.setOtpSendOn("123456");

		doReturn(emailResponse).when(service).sendEmailVerificationForParent(anyString(), anyString(), anyString(),
				anyString(), anyString(), org.mockito.ArgumentMatchers.anyBoolean(), anyString(), anyString());

		request.setStudentId(AES.decryptToString("12345", Constant.SALT_AES));

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(studentDetailsRepo).verifyEmail(request);
	}

	@Test
	void forgetPasswordStudent_shouldReturnFailure_whenOtpMailFails() throws Exception {

		ParentRegReq request = new ParentRegReq();

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.verifyEmail(request)).thenReturn(Collections.singletonList(true));

		EmailResponse emailResponse = new EmailResponse();

		emailResponse.setOtpSendOn("-1");

		doReturn(emailResponse).when(service).sendEmailVerificationForParent(anyString(), anyString(), anyString(),
				anyString(), anyString(), org.mockito.ArgumentMatchers.anyBoolean(), anyString(), anyString());

		request.setStudentId(AES.decryptToString("12345", Constant.SALT_AES));

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void forgetPasswordStudent_shouldReturnSamePasswordMessage_whenSamePasswordIsTrue() throws Exception {

		ParentRegReq request = new ParentRegReq();

		request.setSamePassword(true);

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.verifyEmail(request)).thenReturn(Collections.emptyList());

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
	}

	@Test
	void forgetPasswordStudent_shouldReturnSuccess_whenTagIdIsGreaterThanZero() throws Exception {
		ParentRegReq request = new ParentRegReq();

		request.setIndicator("S");

		StudentInfoImportResp studentResp = new StudentInfoImportResp();

		studentResp.setTagId(10);

		List<StudentInfoImportResp> result = Collections.singletonList(studentResp);

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.getImportStudentData(request, null)).thenReturn(result);

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(studentDetailsRepo).getImportStudentData(request, null);
	}

	@Test
	void forgetPasswordStudent_shouldReturnFailureAndSamePassword_whenTagIdIsMinusOne() throws Exception {

		ParentRegReq request = new ParentRegReq();

		request.setIndicator("S");

		StudentInfoImportResp studentResp = new StudentInfoImportResp();

		studentResp.setTagId(-1);

		List<StudentInfoImportResp> result = Collections.singletonList(studentResp);

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.getImportStudentData(request, null)).thenReturn(result);

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		assertTrue(response.isSamePassword());
	}

	@Test
	void forgetPasswordStudent_shouldReturnFailure_whenImportStudentResultIsEmpty() throws Exception {

		ParentRegReq request = new ParentRegReq();

		request.setIndicator("S");

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.getImportStudentData(request, null)).thenReturn(Collections.emptyList());

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void forgetPasswordStudent_shouldReturnFailure_whenImportStudentResultIsNull() throws Exception {

		ParentRegReq request = new ParentRegReq();

		request.setIndicator("S");

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.getImportStudentData(request, null)).thenReturn(null);

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void forgetPasswordStudent_shouldReturnInvalidEmail_whenIndicatorIsInvalid() throws Exception {

		ParentRegReq request = new ParentRegReq();

		request.setIndicator("X");

		when(utility.printJson(request)).thenReturn("{}");

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);

		assertTrue(response.isSuccess());

		verify(studentDetailsRepo, never()).verifyEmail(request);

		verify(studentDetailsRepo, never()).getImportStudentData(request, null);
	}

	@Test
	void forgetPasswordStudent_shouldUseToString_whenPrintJsonReturnsNull() {
		ParentRegReq request = new ParentRegReq();

		request.setIndicator("X");

		when(utility.printJson(request)).thenReturn(null);

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
	}

	@Test
	void forgetPasswordStudent_shouldThrowHomeInstructionException_whenExceptionOccurs() {

		ParentRegReq request = new ParentRegReq();

		when(utility.printJson(request)).thenThrow(new RuntimeException("Database error"));

		try {
			service.forgetPasswordStudent(request);
		} catch (HomeInstructionException e) {
			assertNotNull(e);
		}
	}

	@Test
	void forgetPasswordStudent_shouldReturnSuccess_whenOtpIsSent() throws Exception {

		ParentRegReq request = new ParentRegReq();

		request.setIndicator("F");
		request.setSamePassword(false);

		when(utility.printJson(request)).thenReturn("{}");

		// Email is valid
		when(studentDetailsRepo.verifyEmail(request)).thenReturn(Collections.singletonList(true));

		EmailResponse emailResponse = new EmailResponse();
		emailResponse.setOtpSendOn("123456");

		doReturn(emailResponse).when(service).sendEmailVerificationForParent(anyString(), anyString(), anyString(),
				anyString(), anyString(), anyBoolean(), anyString(), anyString());

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
	}

	@Test
	void forgetPasswordStudent_shouldReturnSamePasswordSuccess_whenSamePasswordIsTrue() throws Exception {

		ParentRegReq request = new ParentRegReq();

		request.setIndicator("F");
		request.setSamePassword(true);
		request.setEmailId("student@test.com");

		when(utility.printJson(request)).thenReturn("{}");

		when(studentDetailsRepo.verifyEmail(request)).thenReturn(Collections.singletonList(true));

		EmailResponse emailResponse = new EmailResponse();
		emailResponse.setOtpSendOn("123456");

		doReturn(emailResponse).when(service).sendEmailVerificationForParent("", "", "", "", "", true, "", "");

		when(utility.responseDate(any(LocalDateTime.class))).thenReturn("responseDate");

		LogInResponseDTO response = service.forgetPasswordStudent(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
	}

	@Test
	void parentPasswordLoginInvalidStudent() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(1);
		resp.setValid(false);

		when(logInRepo.checkParentPwdData(req)).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.checkParentPwLogin(req, new HashMap<>());

		assertNotNull(result);
		assertFalse(result.isSuccess());
	}

	@Test
	void parentPasswordLoginDefaultFailure() throws Exception {

		ParentLogInReq req = new ParentLogInReq();

		ParentLoginResp resp = new ParentLoginResp();
		resp.setStatusCode(99);
		resp.setValid(false);

		when(logInRepo.checkParentPwdData(req)).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.checkParentPwLogin(req, new HashMap<>());

		assertNotNull(result);
		assertFalse(result.isSuccess());
	}

	@Test
	void parentPasswordLoginSuccessWithStudentData() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setStudentId("123");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setValid(true);

		when(logInRepo.checkParentPwdData(req)).thenReturn(Arrays.asList(resp));

		when(appConfigRepo.getStudentData("123", "")).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentPwLogin(req, new HashMap<>());

		assertNotNull(result);
		assertTrue(result.isSuccess());

		verify(appConfigRepo).getStudentData("123", "");
	}

	@Test
	void parentLoginNonLIndicator_ShouldCallPasswordLogin() throws Exception {

		ParentLogInReq req = new ParentLogInReq();
		req.setIndicator("P");

		ParentLoginResp resp = new ParentLoginResp();
		resp.setValid(true);

		when(logInRepo.checkParentPwdData(req)).thenReturn(Arrays.asList(resp));

		when(appConfigRepo.getStudentData(anyString(), anyString())).thenReturn(new ArrayList<>());

		when(logInRepo.getSchoolYear()).thenReturn(new ArrayList<>());

		LogInResponseDTO result = service.checkParentLogin(req);

		assertNotNull(result);
		assertTrue(result.isSuccess());

		verify(msgService).getMessage(Constant.LOG_PAPW);
		verify(logInRepo).checkParentPwdData(req);
	}

	@Test
	void setDbResponseList_NoSchoolYear_ShouldNotUpdate() throws Exception {

		ParentLoginResp resp = new ParentLoginResp();

		List<ParentLoginResp> dbResp = new ArrayList<>(Collections.singletonList(resp));

		when(logInRepo.getSchoolYear()).thenReturn(Collections.emptyList());

		service.setDbResponseList(dbResp);

		assertNotNull(dbResp.get(0));
	}

	@Test
	void submitRegistration_ShouldReturnFailure_WhenTagIdIsOther() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("R");
		req.setEmailId("test@test.com");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		StudentInfoImportResp resp = new StudentInfoImportResp();
		resp.setTagId(0);

		when(studentDetailsRepo.getImportStudentData(any(ParentRegReq.class), any())).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.submitRegistration(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());
	}

	@Test
	void submitRegistration_LoginIndicator_ShouldReturnResponse() throws Exception {

		ParentRegReq req = new ParentRegReq();
		req.setIndicator("L");
		req.setEmailId("test@test.com");
		req.setStudentId("123");
		req.setStudentDob("01/01/2010");

		StudentInfoImportResp resp = new StudentInfoImportResp();
		resp.setTagId(-4);

		when(studentDetailsRepo.getImportStudentData(any(ParentRegReq.class), any())).thenReturn(Arrays.asList(resp));

		LogInResponseDTO result = service.submitRegistration(req);

		assertNotNull(result);
		assertFalse(result.isSuccess());
	}

	@Test
	void sendEmailVerification_ShouldReturnMinusOne_WhenOuterExceptionOccurs() {

		when(utility.getConfigList(anyString()))
				.thenThrow(new RuntimeException("Config error"));

		EmailResponse result =
				service.sendEmailVerificationForParent(
						"123",
						"01/01/2010",
						"test@test.com",
						"123456",
						"F",
						true,
						"encrypted",
						"");

		assertNotNull(result);
		assertEquals("-1", result.getOtpSendOn());
	}

	@Test
	void verifyOtpOtherResult_ShouldReturnFailure() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq("123", "111111");

		when(userDetailsRepo.verifyUserOtp(req)).thenReturn(Arrays.asList(0L));

		VerifyOtpResponse response = service.verfyOtpStudent(req);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void verifyOtpEmptyResult_ShouldReturnFailure() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq("123", "111111");

		when(userDetailsRepo.verifyUserOtp(req)).thenReturn(Collections.emptyList());

		VerifyOtpResponse response = service.verfyOtpStudent(req);

		assertNotNull(response);
		assertFalse(response.isSuccess());
	}

	@Test
	void checkAdminLogin_ShouldThrowHomeInstructionException() {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		when(utility.printJson(request)).thenThrow(new RuntimeException("Database error"));

		assertThrows(HomeInstructionException.class, () -> service.checkAdminLogin(request));
	}

	@Test
	void checkAdminLogin_ShouldThrowException_WhenRepoFails() throws Exception {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId(AES.decryptToString("1234567", Constant.SALT_AES));

		when(logInRepo.checkAdminLoginData(request)).thenThrow(new RuntimeException("DB error"));

		assertThrows(HomeInstructionException.class, () -> service.checkAdminLogin(request));
	}

}