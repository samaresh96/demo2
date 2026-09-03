package com.jcboe.home.instruction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.UserLoginRequest;
import com.jcboe.home.instruction.repo.EmployeeLoginRepo;
import com.jcboe.home.instruction.response.ParentLoginResp;
import com.jcboe.home.instruction.response.UserDetailDTO;
import com.jcboe.home.instruction.response.UsrLoginResponse;
import com.jcboe.home.instruction.response.UsrNameResponse;
import com.jcboe.home.instruction.utilities.Utility;

@ExtendWith(MockitoExtension.class)
class EmployeeLoginServiceImplTest {

	@InjectMocks
	private EmployeeLoginServiceImpl employeeLoginServiceImpl;

	@Mock
	private EmployeeLoginRepo loginRepo;

	@Mock
	private Utility utility;

	@Mock
	private LogInServiceImpl logInServiceImpl;

	@BeforeEach
	void setUp() {
		employeeLoginServiceImpl = new EmployeeLoginServiceImpl(loginRepo, utility, logInServiceImpl);
	}

	@Test
	void userName_shouldReturnSuccess_whenUserNameExists() throws Exception {

		UserLoginRequest request = new UserLoginRequest();

		UsrNameResponse dbResponse = new UsrNameResponse();
		dbResponse.setUserName("John");

		when(loginRepo.getUserNameDbCall(request)).thenReturn(dbResponse);

		UsrNameResponse response = employeeLoginServiceImpl.userName(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals("John", response.getUserName());

		verify(loginRepo).getUserNameDbCall(request);
	}

	@Test
	void userName_shouldReturnFailure_whenUserNameIsEmpty() throws Exception {

		UserLoginRequest request = new UserLoginRequest();

		UsrNameResponse dbResponse = new UsrNameResponse();
		dbResponse.setUserName("");

		when(loginRepo.getUserNameDbCall(request)).thenReturn(dbResponse);

		UsrNameResponse response = employeeLoginServiceImpl.userName(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserNameDbCall(request);
	}

	@Test
	void userName_shouldReturnFailure_whenUserNameIsNull() throws Exception {

		UserLoginRequest request = new UserLoginRequest();

		UsrNameResponse dbResponse = new UsrNameResponse();
		dbResponse.setUserName(null);

		when(loginRepo.getUserNameDbCall(request)).thenReturn(dbResponse);

		UsrNameResponse response = employeeLoginServiceImpl.userName(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserNameDbCall(request);
	}

	@Test
	void userName_shouldReturnFailure_whenDatabaseResponseIsNull() throws Exception {

		UserLoginRequest request = new UserLoginRequest();

		when(loginRepo.getUserNameDbCall(request)).thenReturn(null);

		UsrNameResponse response = employeeLoginServiceImpl.userName(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserNameDbCall(request);
	}

	@Test
	void userName_shouldThrowHomeInstructionException_whenDatabaseThrowsException() throws Exception {

		UserLoginRequest request = new UserLoginRequest();

		when(loginRepo.getUserNameDbCall(request)).thenThrow(new SQLException("Mock SQL Exception"));

		assertThrows(HomeInstructionException.class, () -> employeeLoginServiceImpl.userName(request));

		verify(loginRepo).getUserNameDbCall(request);
	}

	@Test
	void userName_shouldLoadConfig_whenConfigKeysAreProvided() throws Exception {

		UserLoginRequest request = new UserLoginRequest();
		request.setConfigKeys("KEY1,KEY2");

		UsrNameResponse dbResponse = new UsrNameResponse();
		dbResponse.setUserName("John");

		when(loginRepo.getUserNameDbCall(request)).thenReturn(dbResponse);

		when(utility.getConfigList("KEY1,KEY2")).thenReturn(java.util.Collections.singletonMap("KEY1", "VALUE1"));

		UsrNameResponse response = employeeLoginServiceImpl.userName(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		verify(utility).getConfigList("KEY1,KEY2");
		verify(loginRepo).getUserNameDbCall(request);
	}

	@Test
	void userLogin_shouldReturnValidationError_whenApplicationIdIsEmpty() throws Exception {

		UserLoginRequest request = new UserLoginRequest();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo, never()).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnValidationError_whenUserIdIsEmpty() throws Exception {

		UserLoginRequest request = new UserLoginRequest();
		request.setApplicationId("22");

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo, never()).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnValidationError_whenPasswordIsEmpty() throws Exception {

		UserLoginRequest request = new UserLoginRequest();
		request.setApplicationId("22");
		request.setUserId("123");

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo, never()).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnInvalidUserType_whenUserTypeIsEmpty() throws Exception {

		UserLoginRequest request = new UserLoginRequest();

		request.setApplicationId("22");
		request.setUserId("123");
		request.setUserPassword("password");
		request.setUserType("");

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo, never()).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnInvalidUserType_whenUserTypeIsNull() throws Exception {

		UserLoginRequest request = new UserLoginRequest();

		request.setApplicationId("22");
		request.setUserId("123");
		request.setUserPassword("password");
		request.setUserType(null);

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo, never()).getUserDetailsDbCall(request);
	}

	private UserLoginRequest validUserRequest() {

		UserLoginRequest request = new UserLoginRequest();

		request.setApplicationId("22");
		request.setUserId("123");
		request.setUserPassword("password");
		request.setUserType("e");
		request.setApplicationIndicator("TIMEMGMT");

		return request;
	}

	private UserDetailDTO mockUserDetails(int status) {

		UserDetailDTO dto = new UserDetailDTO();

		dto.setStatus(status);
		dto.setUserID(13);

		return dto;
	}

	private void mockSchoolYearData() throws Exception {

		ParentLoginResp parentLoginResp = new ParentLoginResp();

		ArrayList<ParentLoginResp> dbResponse = new ArrayList<>();
		dbResponse.add(parentLoginResp);

		doNothing().when(logInServiceImpl).setDbResponseList(dbResponse);
	}

	@Test
	void userLogin_shouldReturnSuccess_whenStatusIsOne() throws Exception {

		UserLoginRequest request = validUserRequest();

		UserDetailDTO dbResponse = mockUserDetails(1);

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(dbResponse);

		mockSchoolYearData();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertNotNull(response.getUserDetail());

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnEmployeeNotExist_whenStatusIsMinusOne() throws Exception {

		UserLoginRequest request = validUserRequest();

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(mockUserDetails(-1));

		mockSchoolYearData();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnEmployeeNotRegistered_whenStatusIsMinusTwo() throws Exception {

		UserLoginRequest request = validUserRequest();

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(mockUserDetails(-2));

		mockSchoolYearData();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnIncorrectPassword_whenStatusIsMinusThree() throws Exception {

		UserLoginRequest request = validUserRequest();

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(mockUserDetails(-3));

		mockSchoolYearData();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnInvalidFacilitator_whenStatusIsMinusFour() throws Exception {

		UserLoginRequest request = validUserRequest();

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(mockUserDetails(-4));

		mockSchoolYearData();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnInvalidPassword_whenStatusIsMinusFive() throws Exception {

		UserLoginRequest request = validUserRequest();

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(mockUserDetails(-5));

		mockSchoolYearData();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnNotAuthorized_whenStatusIsMinusSix() throws Exception {

		UserLoginRequest request = validUserRequest();

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(mockUserDetails(-6));

		mockSchoolYearData();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldReturnDataNotFound_whenStatusIsUnknown() throws Exception {

		UserLoginRequest request = validUserRequest();

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(mockUserDetails(99));

		mockSchoolYearData();

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertFalse(response.isSuccess());

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldThrowHomeInstructionException_whenRepositoryFails() throws Exception {

		UserLoginRequest request = validUserRequest();

		when(loginRepo.getUserDetailsDbCall(request)).thenThrow(new RuntimeException("Database error"));

		assertThrows(HomeInstructionException.class, () -> employeeLoginServiceImpl.userLogin(request));

		verify(loginRepo).getUserDetailsDbCall(request);
	}

	@Test
	void userLogin_shouldThrowHomeInstructionException_whenSetDbResponseListFails() throws Exception {

		UserLoginRequest request = validUserRequest();
		UserDetailDTO dto = mockUserDetails(1);

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(dto);

		doThrow(new RuntimeException("Year lookup failed")).when(logInServiceImpl).setDbResponseList(anyList());

		assertThrows(HomeInstructionException.class, () -> employeeLoginServiceImpl.userLogin(request));

		verify(loginRepo).getUserDetailsDbCall(request);
		verify(logInServiceImpl).setDbResponseList(anyList());
	}

	@Test
	void userLogin_shouldCopySchoolYearDetails_whenAvailable() throws Exception {

		UserLoginRequest request = validUserRequest();
		UserDetailDTO dto = mockUserDetails(1);

		when(loginRepo.getUserDetailsDbCall(request)).thenReturn(dto);

		doAnswer(invocation -> {

			@SuppressWarnings("unchecked")
			List<ParentLoginResp> list = invocation.getArgument(0);

			ParentLoginResp yearResponse = list.get(0);

			yearResponse.setCurrentYear("2026");
			yearResponse.setPreviousYear("2025");
			yearResponse.setCurrentYearAbbr("26");
			yearResponse.setPreviousYearAbbr("25");

			return null;

		}).when(logInServiceImpl).setDbResponseList(anyList());

		UsrLoginResponse response = employeeLoginServiceImpl.userLogin(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());

		assertEquals("2026", dto.getCurrentYear());
		assertEquals("2025", dto.getPreviousYear());
		assertEquals("26", dto.getCurrentYearAbbr());
		assertEquals("25", dto.getPreviousYearAbbr());

		verify(loginRepo).getUserDetailsDbCall(request);
		verify(logInServiceImpl).setDbResponseList(anyList());
	}

}
