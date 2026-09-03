package com.jcboe.home.instruction.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jcboe.home.instruction.model.request.UserLoginRequest;
import com.jcboe.home.instruction.response.UsrLoginResponse;
import com.jcboe.home.instruction.response.UsrNameResponse;
import com.jcboe.home.instruction.service.IEmployeeLoginService;
import com.jcboe.home.instruction.service.IMessageService;

@ExtendWith(MockitoExtension.class)
class EmployeeRegisterControllerTest {

	@InjectMocks
	private EmployeeRegisterController employeeRegisterController;

	@Mock
	private IEmployeeLoginService employeeLoginService;
	@Mock
	private IMessageService iMessageService;

	@Test
	void testUserLogin() {
		employeeRegisterController = new EmployeeRegisterController(employeeLoginService, iMessageService);
		UserLoginRequest usrRequest = new UserLoginRequest();
		when(employeeLoginService.userLogin(usrRequest)).thenReturn(new UsrLoginResponse());
		employeeRegisterController.employeeLogInCheck(usrRequest);
	}

	@Test
	void testUserName() {
		employeeRegisterController = new EmployeeRegisterController(employeeLoginService, iMessageService);
		when(employeeLoginService.userName(null)).thenReturn(new UsrNameResponse());
		employeeRegisterController.getUserName(null);
	}
}
