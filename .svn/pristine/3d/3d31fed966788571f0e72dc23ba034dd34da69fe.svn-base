package com.jcboe.home.instruction.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jcboe.home.instruction.model.request.ParentRegReq;
import com.jcboe.home.instruction.response.StudentInfoImportResp;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

@SpringBootTest
class StudentDetailsRepoTest {

	@MockBean
	private NamedParameterJdbcTemplate jdbcTemplate;

	@InjectMocks
	private StudentDetailsRepo studentDetailsRepo;

	@BeforeEach
	void setUp() {
		studentDetailsRepo = new StudentDetailsRepo(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetImportStudentData() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any())).thenAnswer((invocation) -> {

					RowMapper<StudentInfoImportResp> rowMapper = (RowMapper<StudentInfoImportResp>) invocation
							.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong(ArgumentMatchers.eq("tag_id"))).thenReturn(56L);

					List<StudentInfoImportResp> users = new ArrayList<StudentInfoImportResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		studentDetailsRepo.getImportStudentData(new ParentRegReq(), "");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetImportStudentDataExcp() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;

				});
		studentDetailsRepo.getImportStudentData(new ParentRegReq(), "");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testVerifyEmail() throws Exception {
		ParentRegReq req = new ParentRegReq();
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Object>>any())).thenAnswer((invocation) -> {

					RowMapper<Object> rowMapper = (RowMapper<Object>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong(ArgumentMatchers.eq("tag_id"))).thenReturn(56L);

					List<Object> users = new ArrayList<Object>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		studentDetailsRepo.verifyEmail(req);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testVerifyEmailExcp() throws Exception {
		ParentRegReq req = new ParentRegReq();
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Object>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;

				});
		studentDetailsRepo.verifyEmail(req);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetImportStudentDataWithStudentIdAndPassword() throws Exception {

		ParentRegReq req = new ParentRegReq();

		/*
		 * Use valid encrypted values here. Replace these with the appropriate
		 * encryption methods available in your AES utility class.
		 */
		String encryptedStudentId = AES.encrypt("12345", Constant.SALT_AES);
		String encryptedPassword = AES.decryptToString("password123", Constant.SALT_AES);

		req.setStudentId(encryptedStudentId);
		req.setParentPw(encryptedPassword);
		req.setStudentDob("01/01/2010");
		req.setParentName("John Doe");
		req.setEmailId("john@test.com");
		req.setRegCode("REG001");
		req.setIndicator("WEB");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any())).thenAnswer((invocation) -> {

					RowMapper<StudentInfoImportResp> rowMapper = (RowMapper<StudentInfoImportResp>) invocation
							.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(56L);
					Mockito.when(rs.getString("v_db_email_verified_on")).thenReturn("2026-08-08");

					List<StudentInfoImportResp> response = new ArrayList<StudentInfoImportResp>();

					response.add(rowMapper.mapRow(rs, 0));

					return response;
				});

		List<StudentInfoImportResp> result = studentDetailsRepo.getImportStudentData(req, "");

		assertNotNull(result);
		assertEquals(1, result.size());

		/*
		 * Verify that the decrypted values were passed to the query.
		 */
		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> "12345".equals(params.get("p_student_id"))
						&& "password123".equals(params.get("p_password"))),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testVerifyEmailWithStudentId() throws Exception {

		ParentRegReq req = new ParentRegReq();

		String encryptedStudentId = AES.encrypt("12345", Constant.SALT_AES);

		req.setStudentId(encryptedStudentId);
		req.setEmailId("john@test.com");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Object>>any())).thenAnswer((invocation) -> {

					RowMapper<Object> rowMapper = (RowMapper<Object>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getBoolean("status")).thenReturn(true);

					List<Object> response = new ArrayList<Object>();
					response.add(rowMapper.mapRow(rs, 0));

					return response;
				});

		List<Object> result = studentDetailsRepo.verifyEmail(req);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(Boolean.TRUE, result.get(0));

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> "12345".equals(params.get("p_student_id"))
						&& "john@test.com".equals(params.get("p_email_id"))),
				ArgumentMatchers.<RowMapper<Object>>any());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetImportStudentDataWithStudentIdOnly() throws Exception {

		ParentRegReq req = new ParentRegReq();

		String encryptedStudentId = AES.encrypt("12345", Constant.SALT_AES);

		req.setStudentId(encryptedStudentId);

		// Leave parentPw empty to execute the other branch.
		req.setParentPw("");

		req.setStudentDob("01/01/2010");
		req.setParentName("John Doe");
		req.setEmailId("john@test.com");
		req.setRegCode("REG001");
		req.setIndicator("WEB");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any()))
				.thenReturn(new ArrayList<StudentInfoImportResp>());

		List<StudentInfoImportResp> result = studentDetailsRepo.getImportStudentData(req, "");

		assertNotNull(result);

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> "12345".equals(params.get("p_student_id"))),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetImportStudentDataWithParentPassword() throws Exception {

		ParentRegReq req = new ParentRegReq();

		/*
		 * This value must be encrypted using the same AES logic used by the
		 * application.
		 */
		String encryptedPassword = AES.decryptToString("password123", Constant.SALT_AES);

		req.setParentPw(encryptedPassword);

		// Keep studentId empty so the studentId if-branch is also tested.
		req.setStudentId("");

		req.setStudentDob("01/01/2010");
		req.setParentName("John Doe");
		req.setEmailId("john@test.com");
		req.setRegCode("REG001");
		req.setIndicator("WEB");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any())).thenAnswer((invocation) -> {

					RowMapper<StudentInfoImportResp> rowMapper = (RowMapper<StudentInfoImportResp>) invocation
							.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(56L);
					Mockito.when(rs.getString("v_db_email_verified_on")).thenReturn("2026-08-08");

					List<StudentInfoImportResp> response = new ArrayList<StudentInfoImportResp>();

					response.add(rowMapper.mapRow(rs, 0));

					return response;
				});

		List<StudentInfoImportResp> result = studentDetailsRepo.getImportStudentData(req, "");

		assertNotNull(result);
		assertEquals(1, result.size());

		/*
		 * Verify that AES.decryptToString() result was placed into p_password.
		 */
		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> "password123".equals(params.get("p_password"))),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetImportStudentData_elseBranches() throws Exception {
		ParentRegReq parentRegReq = new ParentRegReq();
		parentRegReq.setParentPw("0f06KVmiMuG/nQrPJpnrxg==");
		parentRegReq.setStudentId("2000-01-01");
		parentRegReq.setIndicator("encryptedOtp");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any())).thenAnswer((invocation) -> {

					RowMapper<StudentInfoImportResp> rowMapper = (RowMapper<StudentInfoImportResp>) invocation
							.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getBoolean("is_valid")).thenReturn(true);
					Mockito.when(rs.getInt("result_code")).thenReturn(0);
					Mockito.when(rs.getLong("logged_in_user_id")).thenReturn(1L);
					Mockito.when(rs.getString("logged_in_user_name")).thenReturn("John Doe");
					Mockito.when(rs.getString("email_id")).thenReturn("john@example.com");

					List<StudentInfoImportResp> users = new ArrayList<StudentInfoImportResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		studentDetailsRepo.getImportStudentData(parentRegReq, "");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetImportStudentDataWithRegCodeParameter() throws Exception {

		ParentRegReq req = new ParentRegReq();

		// Keep these empty so no AES decryption is required
		req.setStudentId("");
		req.setParentPw("");

		req.setStudentDob("01/01/2010");
		req.setParentName("John Doe");
		req.setEmailId("john@test.com");
		req.setRegCode("PARENT_REG_CODE");
		req.setIndicator("WEB");

		String regCode = "PARAM_REG_CODE";

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any()))
				.thenReturn(new ArrayList<StudentInfoImportResp>());

		studentDetailsRepo.getImportStudentData(req, regCode);

		Mockito.verify(jdbcTemplate).query(Mockito.anyString(),
				Mockito.argThat((Map<String, Object> params) -> regCode.equals(params.get("p_reg_code"))),
				ArgumentMatchers.<RowMapper<StudentInfoImportResp>>any());
	}

}
