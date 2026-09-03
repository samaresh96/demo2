package com.jcboe.home.instruction.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

import com.jcboe.home.instruction.model.request.UserInfoReq;
import com.jcboe.home.instruction.model.request.VerifyOtpReq;
import com.jcboe.home.instruction.response.LookupDetails;
import com.jcboe.home.instruction.response.TeacherListResp;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

@SpringBootTest
class UserDetailsRepoTest {

	@MockBean
	private NamedParameterJdbcTemplate jdbcTemplate;

	private UserDetailsRepo userDetailsRepo;

	@BeforeEach
	void setUp() {
		userDetailsRepo = new UserDetailsRepo(jdbcTemplate);
	}

	/**
	 * ============================================================ verifyUserOtp()
	 * ============================================================
	 */

	@Test
	@SuppressWarnings("unchecked")
	void testVerifyUserOtp_EmptyStudentId_Success() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq();
		req.setStudentId("");
		req.setOtp("123456");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getInt("status_code")).thenReturn(1);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = userDetailsRepo.verifyUserOtp(req);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(Long.valueOf(1L), result.get(0));

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> Long.valueOf(0L).equals(params.get("p_student_id"))
						&& "123456".equals(params.get("p_otp"))),
				ArgumentMatchers.<RowMapper<Long>>any());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testVerifyUserOtp_NullStudentId_Success() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq();
		req.setStudentId(null);
		req.setOtp("111111");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getInt("status_code")).thenReturn(2);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = userDetailsRepo.verifyUserOtp(req);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(Long.valueOf(2L), result.get(0));

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> Long.valueOf(0L).equals(params.get("p_student_id"))
						&& "111111".equals(params.get("p_otp"))),
				ArgumentMatchers.<RowMapper<Long>>any());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testVerifyUserOtp_EncryptedStudentId_Success() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq();

		String encryptedStudentId = AES.encrypt("12345", Constant.SALT_AES);

		req.setStudentId(encryptedStudentId);
		req.setOtp("123456");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getInt("status_code")).thenReturn(1);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = userDetailsRepo.verifyUserOtp(req);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(Long.valueOf(1L), result.get(0));

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> Long.valueOf(12345L).equals(params.get("p_student_id"))
						&& "123456".equals(params.get("p_otp"))),
				ArgumentMatchers.<RowMapper<Long>>any());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testVerifyUserOtp_Exception() throws Exception {

		VerifyOtpReq req = new VerifyOtpReq();
		req.setStudentId("");
		req.setOtp("123456");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenThrow(new DataAccessException("DB Error") {
					private static final long serialVersionUID = 1L;
				});

		assertThrows(DataAccessException.class, () -> userDetailsRepo.verifyUserOtp(req));
	}

	@Test
	void testVerifyUserOtp_InvalidEncryptedStudentId() {

		VerifyOtpReq req = new VerifyOtpReq();

		req.setStudentId("invalid-encrypted-value");
		req.setOtp("123456");

		assertThrows(Exception.class, () -> userDetailsRepo.verifyUserOtp(req));
	}

	/**
	 * ============================================================
	 * getLookupValues()
	 * ============================================================
	 */

	@Test
	@SuppressWarnings("unchecked")
	void testGetLookupValues_Success() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<LookupDetails>>any())).thenAnswer(invocation -> {

					RowMapper<LookupDetails> rowMapper = (RowMapper<LookupDetails>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString("lookup_type")).thenReturn("STATUS");

					Mockito.when(rs.getInt("lookup_value_id")).thenReturn(1);

					Mockito.when(rs.getString("lookup_value")).thenReturn("Approved");

					Mockito.when(rs.getString("lookup_abbreviation")).thenReturn("APR");

					Mockito.when(rs.getBoolean("is_active")).thenReturn(true);

					List<LookupDetails> result = new ArrayList<>();

					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<LookupDetails> result = userDetailsRepo.getLookupValues("STATUS");

		assertNotNull(result);
		assertEquals(1, result.size());

		assertEquals("STATUS", result.get(0).getLookuptype());

		assertEquals("Approved", result.get(0).getLookupvalue());

		assertEquals(1, result.get(0).getLookupvalueid());

		assertEquals("APR", result.get(0).getLookupabbreviation());

		assertEquals(true, result.get(0).isActive());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testGetLookupValues_EmptyResult() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<LookupDetails>>any())).thenReturn(new ArrayList<>());

		List<LookupDetails> result = userDetailsRepo.getLookupValues("STATUS");

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testGetLookupValues_Exception() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<LookupDetails>>any())).thenThrow(new DataAccessException("DB Error") {
					private static final long serialVersionUID = 1L;
				});

		assertThrows(DataAccessException.class, () -> userDetailsRepo.getLookupValues("STATUS"));
	}

	/**
	 * ============================================================
	 * updateuserInfoData()
	 * ============================================================
	 */

	@Test
	@SuppressWarnings("unchecked")
	void testUpdateUserInfoData_EmptyEmployeeId_Success() throws Exception {

		UserInfoReq req = new UserInfoReq();

		req.setIndicator("I");
		req.setEmployeeId("");
		req.setUserType("USER");
		req.setPhoneNumber1("1111111111");
		req.setPhoneNumber2("2222222222");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(100L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = userDetailsRepo.updateuserInfoData(req);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(Long.valueOf(100L), result.get(0));

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> "I".equals(params.get("p_indicator"))
						&& Long.valueOf(0L).equals(params.get("p_employee_id"))
						&& "USER".equals(params.get("p_user_type"))
						&& "1111111111".equals(params.get("p_phone_number_1"))
						&& "2222222222".equals(params.get("p_phone_number_2"))),
				ArgumentMatchers.<RowMapper<Long>>any());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testUpdateUserInfoData_NullEmployeeId_Success() throws Exception {

		UserInfoReq req = new UserInfoReq();

		req.setIndicator("U");
		req.setEmployeeId(null);
		req.setUserType("ADMIN");
		req.setPhoneNumber1("111");
		req.setPhoneNumber2("222");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(200L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = userDetailsRepo.updateuserInfoData(req);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(Long.valueOf(200L), result.get(0));

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> Long.valueOf(0L).equals(params.get("p_employee_id"))),
				ArgumentMatchers.<RowMapper<Long>>any());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testUpdateUserInfoData_EncryptedEmployeeId_Success() throws Exception {

		UserInfoReq req = new UserInfoReq();

		String encryptedEmployeeId = AES.encrypt("54321", Constant.SALT_AES);

		req.setIndicator("U");
		req.setEmployeeId(encryptedEmployeeId);
		req.setUserType("EMPLOYEE");
		req.setPhoneNumber1("123456");
		req.setPhoneNumber2("654321");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(300L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = userDetailsRepo.updateuserInfoData(req);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(Long.valueOf(300L), result.get(0));

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> Long.valueOf(54321L).equals(params.get("p_employee_id"))
						&& "U".equals(params.get("p_indicator")) && "EMPLOYEE".equals(params.get("p_user_type"))),
				ArgumentMatchers.<RowMapper<Long>>any());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testUpdateUserInfoData_InvalidEncryptedEmployeeId() throws Exception {

		UserInfoReq req = new UserInfoReq();

		req.setEmployeeId("invalid-encrypted-value");

		assertThrows(Exception.class, () -> userDetailsRepo.updateuserInfoData(req));
	}

	@Test
	@SuppressWarnings("unchecked")
	void testUpdateUserInfoData_Exception() throws Exception {

		UserInfoReq req = new UserInfoReq();

		req.setEmployeeId("");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenThrow(new DataAccessException("DB Error") {
					private static final long serialVersionUID = 1L;
				});

		assertThrows(DataAccessException.class, () -> userDetailsRepo.updateuserInfoData(req));
	}

	@Test
	@SuppressWarnings("unchecked")
	void testGetTeacherData_Success() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), ArgumentMatchers.<RowMapper<TeacherListResp>>any()))
				.thenAnswer(invocation -> {

					RowMapper<TeacherListResp> rowMapper = (RowMapper<TeacherListResp>) invocation.getArgument(1);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("employee_id")).thenReturn(1001L);

					Mockito.when(rs.getString("employee_name")).thenReturn("John Doe");

					List<TeacherListResp> result = new ArrayList<>();

					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<TeacherListResp> result = userDetailsRepo.getTeacherData();

		assertNotNull(result);
		assertEquals(1, result.size());

		assertEquals(1001L, result.get(0).getEmployeeId());

		assertEquals("John Doe", result.get(0).getEmployeeName());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testGetTeacherData_EmptyResult() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), ArgumentMatchers.<RowMapper<TeacherListResp>>any()))
				.thenReturn(new ArrayList<>());

		List<TeacherListResp> result = userDetailsRepo.getTeacherData();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	@SuppressWarnings("unchecked")
	void testGetTeacherData_Exception() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), ArgumentMatchers.<RowMapper<TeacherListResp>>any()))
				.thenThrow(new DataAccessException("DB Error") {
					private static final long serialVersionUID = 1L;
				});

		assertThrows(DataAccessException.class, () -> userDetailsRepo.getTeacherData());
	}

}
