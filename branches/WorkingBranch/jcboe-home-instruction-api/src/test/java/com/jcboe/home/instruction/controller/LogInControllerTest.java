package com.jcboe.home.instruction.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jcboe.home.instruction.model.request.ParentRegReq;
import com.jcboe.home.instruction.model.request.VerifyOtpReq;
import com.jcboe.home.instruction.response.LogInResponseDTO;
import com.jcboe.home.instruction.response.VerifyOtpResponse;
import com.jcboe.home.instruction.service.LogInServiceImpl;
import com.jcboe.home.instruction.service.MessageServiceImpl;


@SpringBootTest
class LogInControllerTest {
	@InjectMocks
	private LogInController logInController;
	@MockBean
	private LogInServiceImpl logInServiceImpl;
	@MockBean
	private MessageServiceImpl msgService;

	@BeforeEach
	void setUp() {
		logInController = new LogInController(logInServiceImpl, msgService);
	}

	@Test
	void testparentLogInCheck() {
		when(logInServiceImpl.checkParentLogin(null)).thenReturn(new LogInResponseDTO());
		logInController.parentLogInCheck(null);
	}

	@Test
	void testadminLogInCheck() {
		when(logInServiceImpl.checkAdminLogin(null)).thenReturn(new LogInResponseDTO());
		logInController.adminLogInCheck(null);
	}

	@Test
	void testregisterStudent() {
		when(logInServiceImpl.submitRegistration(null)).thenReturn(new LogInResponseDTO());
		logInController.registerStudent(null);
	}

	@Test
	void testVerifyOtp() {
		VerifyOtpReq req = new VerifyOtpReq();

		when(logInServiceImpl.verfyOtpStudent(req)).thenReturn(new VerifyOtpResponse());

		logInController.verifyOtp(req);

		verify(logInServiceImpl).verfyOtpStudent(req);
	}

	@Test
	void testForgetPasswordStudent() {
		ParentRegReq req = new ParentRegReq();

		when(logInServiceImpl.forgetPasswordStudent(req)).thenReturn(new LogInResponseDTO());

		logInController.forgetPasswordStudent(req);

		verify(logInServiceImpl).forgetPasswordStudent(req);
	}
}
