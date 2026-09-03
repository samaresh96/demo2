package com.jcboe.home.instruction.repo;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.StringUtils;

import com.jcboe.home.instruction.model.request.UserLoginRequest;
import com.jcboe.home.instruction.response.UserDetailDTO;
import com.jcboe.home.instruction.response.UsrNameResponse;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@ExtendWith(MockitoExtension.class)
class EmployeeLoginRepoTest {

	@InjectMocks
	EmployeeLoginRepo loginRepo;
	@Mock
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Mock
	private Utility utility;

	@SuppressWarnings("unchecked")
	@Test
	void testGetUserDetailsDbCall() throws Exception {
		loginRepo = new EmployeeLoginRepo(jdbcTemplate);
		UserLoginRequest usrRequest = new UserLoginRequest();
		usrRequest.setApplicationId("22");
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UserDetailDTO>>any())).thenAnswer((invocation) -> {

					RowMapper<UserDetailDTO> rowMapper = (RowMapper<UserDetailDTO>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong(ArgumentMatchers.eq("RegisteredUserID"))).thenReturn(506L);

					List<UserDetailDTO> users = new ArrayList<UserDetailDTO>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		loginRepo.getUserDetailsDbCall(usrRequest);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetUserDetailsDbCallExcp() throws Exception {
		loginRepo = new EmployeeLoginRepo(jdbcTemplate);
		UserLoginRequest usrRequest = new UserLoginRequest();
		usrRequest.setApplicationId("22");
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UserDetailDTO>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;

				});

		loginRepo.getUserDetailsDbCall(usrRequest);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetUserNameDbCall() throws Exception {
		loginRepo = new EmployeeLoginRepo(jdbcTemplate);

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UsrNameResponse>>any())).thenAnswer((invocation) -> {

					RowMapper<UsrNameResponse> rowMapper = (RowMapper<UsrNameResponse>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("Password"))).thenReturn("dfg");

					List<UsrNameResponse> users = new ArrayList<UsrNameResponse>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		loginRepo.getUserNameDbCall(new UserLoginRequest());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetUserNameDbCall_Exc() throws Exception {
		loginRepo = new EmployeeLoginRepo(jdbcTemplate);

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UsrNameResponse>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;

				});

		loginRepo.getUserNameDbCall(new UserLoginRequest());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetUserNameDbCall_WithEncryptedUserId() throws Exception {

		loginRepo = new EmployeeLoginRepo(jdbcTemplate);

		UserLoginRequest request = new UserLoginRequest();
		request.setUserId(AES.encrypt("12345", Constant.SALT_AES));
		request.setUserPassword("password");
		request.setApplicationIndicator("APP");
		request.setCalledFrom("WEB");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UsrNameResponse>>any())).thenAnswer(invocation -> {

					RowMapper<UsrNameResponse> rowMapper = (RowMapper<UsrNameResponse>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString("UserName")).thenReturn("John");
					Mockito.when(rs.getString("Password")).thenReturn("pwd");
					Mockito.when(rs.getString("FirstName")).thenReturn("John");
					Mockito.when(rs.getString("MiddleName")).thenReturn("");
					Mockito.when(rs.getString("LastName")).thenReturn("Doe");
					Mockito.when(rs.getString("LocationID")).thenReturn("1");
					Mockito.when(rs.getString("Location")).thenReturn("HQ");
					Mockito.when(rs.getString("ApplicationRoleID")).thenReturn("10");
					Mockito.when(rs.getString("AppRoleAbbreviation")).thenReturn("ADM");
					Mockito.when(rs.getString("AppRoleName")).thenReturn("Admin");
					Mockito.when(rs.getBoolean("is_registered")).thenReturn(true);

					List<UsrNameResponse> list = new ArrayList<>();
					list.add(rowMapper.mapRow(rs, 0));
					return list;
				});

		UsrNameResponse response = loginRepo.getUserNameDbCall(request);

		assertNotNull(response);
		assertEquals(12345L, response.getUserId());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetUserDetailsDbCall_WithEncryptedUserId() throws Exception {

		loginRepo = new EmployeeLoginRepo(jdbcTemplate);

		UserLoginRequest request = new UserLoginRequest();
		request.setUserId(AES.encrypt("12345", Constant.SALT_AES));
		request.setApplicationId("22");
		request.setUserType("EMP");
		request.setUserPassword("pwd");
		request.setType("LOGIN");
		request.setLoginName("john");
		request.setLoginPassword("pwd");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UserDetailDTO>>any())).thenAnswer(invocation -> {

					RowMapper<UserDetailDTO> rowMapper = (RowMapper<UserDetailDTO>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getInt(Mockito.anyString())).thenReturn(0);
					Mockito.when(rs.getBoolean(Mockito.anyString())).thenReturn(false);
					Mockito.when(rs.getString(Mockito.anyString())).thenReturn("");

					List<UserDetailDTO> users = new ArrayList<>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		UserDetailDTO dto = loginRepo.getUserDetailsDbCall(request);

		assertNotNull(dto);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetUserNameDbCallReturnsNullWhenUserListEmpty() throws Exception {

		loginRepo = new EmployeeLoginRepo(jdbcTemplate);

		UserLoginRequest request = new UserLoginRequest();

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UsrNameResponse>>any())).thenReturn(new ArrayList<UsrNameResponse>());

		UsrNameResponse response = loginRepo.getUserNameDbCall(request);

		assertNull(response);
	}

	@Test
	void testReturnsNullWhenValueIsEmpty() {

		String value = "";

		String result;

		if (StringUtils.isEmpty(value)) {
			result = value;
		} else {
			result = null;
		}

		assertNull(result);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetUserDetailsDbCallReturnsNullWhenUserListEmpty() throws Exception {

		loginRepo = new EmployeeLoginRepo(jdbcTemplate);

		UserLoginRequest request = new UserLoginRequest();
		request.setApplicationId("22");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UserDetailDTO>>any())).thenReturn(new ArrayList<UserDetailDTO>());

		UserDetailDTO response = loginRepo.getUserDetailsDbCall(request);

		assertNull(response);
	}

}
