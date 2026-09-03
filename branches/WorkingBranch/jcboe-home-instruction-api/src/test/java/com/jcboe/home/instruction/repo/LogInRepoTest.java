package com.jcboe.home.instruction.repo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jcboe.home.instruction.model.request.AdminLogInReq;
import com.jcboe.home.instruction.model.request.ParentLogInReq;
import com.jcboe.home.instruction.response.AdminLoginResp;
import com.jcboe.home.instruction.response.GetYearAbbrevResp;
import com.jcboe.home.instruction.response.JCBOEApplicationDTO;
import com.jcboe.home.instruction.response.ParentLoginResp;
import com.jcboe.home.instruction.utilities.AES;

@SpringBootTest
class LogInRepoTest {

	@MockBean
	private NamedParameterJdbcTemplate jdbcTemplate;

	@MockBean
	private LogInRepo logInRepo;

	@MockBean
	private AES aesUtil;

	@BeforeEach
	void setUp() {
		logInRepo = new LogInRepo(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testCheckParentLoginData() throws Exception {
		ParentLogInReq parentLogInReq = new ParentLogInReq();
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ParentLoginResp>>any())).thenAnswer((invocation) -> {

					RowMapper<ParentLoginResp> rowMapper = (RowMapper<ParentLoginResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("p_student_id"))).thenReturn("506");

					List<ParentLoginResp> users = new ArrayList<ParentLoginResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		logInRepo.checkParentLoginData(parentLogInReq);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testCheckParentLoginData_elseBranches() throws Exception {
		ParentLogInReq parentLogInReq = new ParentLogInReq();
		parentLogInReq.setStudentId("0f06KVmiMuG/nQrPJpnrxg==");
		parentLogInReq.setStudentDob("2000-01-01");
		parentLogInReq.setOtpCode("encryptedOtp");
		parentLogInReq.setIndicator("I");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ParentLoginResp>>any())).thenAnswer((invocation) -> {

					RowMapper<ParentLoginResp> rowMapper = (RowMapper<ParentLoginResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getBoolean("is_valid")).thenReturn(true);
					Mockito.when(rs.getInt("result_code")).thenReturn(0);
					Mockito.when(rs.getLong("logged_in_user_id")).thenReturn(1L);
					Mockito.when(rs.getString("logged_in_user_name")).thenReturn("John Doe");
					Mockito.when(rs.getString("email_id")).thenReturn("john@example.com");

					List<ParentLoginResp> users = new ArrayList<ParentLoginResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		logInRepo.checkParentLoginData(parentLogInReq);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testCheckParentLoginDataExcp() throws Exception {
		ParentLogInReq parentLogInReq = new ParentLogInReq();
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ParentLoginResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		logInRepo.checkParentLoginData(parentLogInReq);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testcheckAdminLoginData() throws Exception {
		AdminLogInReq adminLogInReq = new AdminLogInReq();
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<AdminLoginResp>>any())).thenAnswer((invocation) -> {

					RowMapper<AdminLoginResp> rowMapper = (RowMapper<AdminLoginResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("p_password"))).thenReturn("506");

					List<AdminLoginResp> users = new ArrayList<AdminLoginResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		logInRepo.checkAdminLoginData(adminLogInReq);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testcheckAdminLoginDataExcp() throws Exception {
		AdminLogInReq adminLogInReq = new AdminLogInReq();
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<AdminLoginResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		logInRepo.checkAdminLoginData(adminLogInReq);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testCheckAdminLoginData_elseBranches() throws Exception {
		AdminLogInReq adminLogInReq = new AdminLogInReq();
		adminLogInReq.setPassword("0f06KVmiMuG/nQrPJpnrxg==");
		adminLogInReq.setUserId("2000-01-01");
		adminLogInReq.setUserType("encryptedOtp");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<AdminLoginResp>>any())).thenAnswer((invocation) -> {

					RowMapper<AdminLoginResp> rowMapper = (RowMapper<AdminLoginResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getBoolean("is_valid")).thenReturn(true);
					Mockito.when(rs.getInt("result_code")).thenReturn(0);
					Mockito.when(rs.getLong("logged_in_user_id")).thenReturn(1L);
					Mockito.when(rs.getString("logged_in_user_name")).thenReturn("John Doe");
					Mockito.when(rs.getString("email_id")).thenReturn("john@example.com");

					List<AdminLoginResp> users = new ArrayList<AdminLoginResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		logInRepo.checkAdminLoginData(adminLogInReq);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testcheckParentPwdData() throws Exception {
		ParentLogInReq req = new ParentLogInReq();
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ParentLoginResp>>any())).thenAnswer((invocation) -> {

					RowMapper<ParentLoginResp> rowMapper = (RowMapper<ParentLoginResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("p_password"))).thenReturn("506");

					List<ParentLoginResp> users = new ArrayList<ParentLoginResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		logInRepo.checkParentPwdData(req);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testCheckParentPwdData_elseBranches() throws Exception {
		ParentLogInReq parentLogInReq = new ParentLogInReq();
		parentLogInReq.setStudentPw("0f06KVmiMuG/nQrPJpnrxg==");
		parentLogInReq.setStudentId("2000-01-01");
		parentLogInReq.setIndicator("encryptedOtp");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ParentLoginResp>>any())).thenAnswer((invocation) -> {

					RowMapper<ParentLoginResp> rowMapper = (RowMapper<ParentLoginResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getBoolean("is_valid")).thenReturn(true);
					Mockito.when(rs.getInt("result_code")).thenReturn(0);
					Mockito.when(rs.getLong("logged_in_user_id")).thenReturn(1L);
					Mockito.when(rs.getString("logged_in_user_name")).thenReturn("John Doe");
					Mockito.when(rs.getString("email_id")).thenReturn("john@example.com");

					List<ParentLoginResp> users = new ArrayList<ParentLoginResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		logInRepo.checkParentPwdData(parentLogInReq);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testcheckParentPwdDataExcp() throws Exception {
		ParentLogInReq req = new ParentLogInReq();
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ParentLoginResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		logInRepo.checkParentPwdData(req);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testgetYearAbbrevData() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<GetYearAbbrevResp>>any())).thenAnswer((invocation) -> {

					RowMapper<GetYearAbbrevResp> rowMapper = (RowMapper<GetYearAbbrevResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("lookup_value"))).thenReturn("506");

					List<GetYearAbbrevResp> users = new ArrayList<GetYearAbbrevResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		logInRepo.getSchoolYear();
	}

	@SuppressWarnings("unchecked")
	@Test
	void testgetYearAbbrevDataExcp() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<GetYearAbbrevResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		logInRepo.getSchoolYear();
	}

	@SuppressWarnings("unchecked")
	@Test
	void testgetApplicationByAbbr() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<JCBOEApplicationDTO>>any())).thenAnswer((invocation) -> {

					RowMapper<JCBOEApplicationDTO> rowMapper = (RowMapper<JCBOEApplicationDTO>) invocation
							.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong(ArgumentMatchers.eq("status_code"))).thenReturn(506l);

					List<JCBOEApplicationDTO> users = new ArrayList<JCBOEApplicationDTO>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		logInRepo.getApplicationByAbbr("54");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testgetApplicationByAbbrExcp() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<JCBOEApplicationDTO>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		logInRepo.getApplicationByAbbr("54");
	}

}
