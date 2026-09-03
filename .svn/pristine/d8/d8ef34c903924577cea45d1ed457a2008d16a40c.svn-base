package com.jcboe.home.instruction.repo;

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

import com.jcboe.home.instruction.response.IdsKeyValue;
import com.jcboe.home.instruction.response.StudentDataResp;

@SpringBootTest
class AppConfigRepoTest {
	@MockBean
	private NamedParameterJdbcTemplate jdbcTemplate;

	@InjectMocks
	private AppConfigRepo appConfigRepo;

	@BeforeEach
	void setUp() {
		appConfigRepo = new AppConfigRepo(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetScreenTextDetails() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<IdsKeyValue>>any())).thenAnswer((invocation) -> {

					RowMapper<IdsKeyValue> rowMapper = (RowMapper<IdsKeyValue>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("p_student_id"))).thenReturn("NEW");

					List<IdsKeyValue> users = new ArrayList<IdsKeyValue>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		appConfigRepo.getScreenTextDetails(0, 0);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetScreenTextDetailsExcp() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<IdsKeyValue>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;

				});
		appConfigRepo.getScreenTextDetails(0, 0);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetStudentData() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentDataResp>>any())).thenAnswer((invocation) -> {

					RowMapper<StudentDataResp> rowMapper = (RowMapper<StudentDataResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("p_student_id"))).thenReturn("NEW");

					List<StudentDataResp> users = new ArrayList<StudentDataResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		appConfigRepo.getStudentData("", "");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetStudentData_elseBranches() throws Exception {

		String studentId = "0f06KVmiMuG/nQrPJpnrxg==";
		String employeeId = "0f06KVmiMuG/nQrPJpnrxg==";

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentDataResp>>any())).thenAnswer((invocation) -> {

					RowMapper<StudentDataResp> rowMapper = (RowMapper<StudentDataResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getBoolean("is_valid")).thenReturn(true);
					Mockito.when(rs.getInt("result_code")).thenReturn(0);
					Mockito.when(rs.getLong("logged_in_user_id")).thenReturn(1L);
					Mockito.when(rs.getString("logged_in_user_name")).thenReturn("John Doe");
					Mockito.when(rs.getString("email_id")).thenReturn("john@example.com");

					List<StudentDataResp> users = new ArrayList<StudentDataResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		appConfigRepo.getStudentData(studentId, employeeId);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetStudentDataExcp() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<StudentDataResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;

				});
		appConfigRepo.getStudentData("", "");
	}

}
