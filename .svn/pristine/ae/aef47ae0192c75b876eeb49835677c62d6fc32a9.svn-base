package com.jcboe.home.instruction.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jcboe.home.instruction.model.request.GetAppListReq;
import com.jcboe.home.instruction.model.request.UpdateAssignTeacherReq;
import com.jcboe.home.instruction.model.request.UpdateHIActivityReq;
import com.jcboe.home.instruction.model.request.UpdateHIApplicationReq;
import com.jcboe.home.instruction.response.AppStatusListResp;
import com.jcboe.home.instruction.response.ApplicationList;
import com.jcboe.home.instruction.response.ApplicationSummaryResp;
import com.jcboe.home.instruction.response.GradeListResp;
import com.jcboe.home.instruction.response.SchoolResp;
import com.jcboe.home.instruction.response.UpdateHIActivityResp;

@ExtendWith(MockitoExtension.class)
class ApplicationListRepoTest {

	@Mock
	private NamedParameterJdbcTemplate jdbcTemplate;

	private ApplicationListRepo repo;

	@BeforeEach
	void setUp() {
		repo = new ApplicationListRepo(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetApplicationDetails() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ApplicationList>>any())).thenAnswer(invocation -> {

					RowMapper<ApplicationList> rowMapper = (RowMapper<ApplicationList>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("hi_application_id")).thenReturn(1L);
					Mockito.when(rs.getLong("hi_form_transaction_id")).thenReturn(2L);
					Mockito.when(rs.getLong("form1_aphir_data_id")).thenReturn(3L);
					Mockito.when(rs.getLong("student_id")).thenReturn(4L);
					Mockito.when(rs.getString("student_name")).thenReturn("John Doe");
					Mockito.when(rs.getString("school_year")).thenReturn("2026-2027");
					Mockito.when(rs.getString("application_no")).thenReturn("APP001");
					Mockito.when(rs.getString("application_type")).thenReturn("HI");
					Mockito.when(rs.getString("application_type_abbr")).thenReturn("HI");
					Mockito.when(rs.getString("student_school")).thenReturn("School 1");
					Mockito.when(rs.getString("student_grade")).thenReturn("5");
					Mockito.when(rs.getString("application_status")).thenReturn("Submitted");
					Mockito.when(rs.getString("application_status_abbr")).thenReturn("SUB");
					Mockito.when(rs.getString("application_date")).thenReturn("2026-01-01");
					Mockito.when(rs.getString("classification")).thenReturn("Regular");
					Mockito.when(rs.getString("hi_period")).thenReturn("2026");
					Mockito.when(rs.getString("updated_on")).thenReturn("2026-01-02");
					Mockito.when(rs.getBoolean("is_active")).thenReturn(true);
					Mockito.when(rs.getString("uploaded_generated_tag")).thenReturn("TAG001");

					List<ApplicationList> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<ApplicationList> result = repo.getApplicationDetails(new GetAppListReq());

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetApplicationDetailsWithLoggedInUser() throws Exception {

		GetAppListReq request = new GetAppListReq();
		request.setSchoolYear("2026-2027");
		request.setStatus("SUBMITTED");
		request.setstudent("John");
		request.setSchoolCode("SCH001");
		request.setGradeId(5);
		request.setApplicationNo("APP001");
		request.setApplicationDate("2026-01-01");
		request.setAllApplication(true);
		request.setPagesize(10);
		request.setPagenumber(1);
		request.setLoggedInUserId("0f06KVmiMuG/nQrPJpnrxg==");
		request.setLoggedInUserPersonType("STAFF");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ApplicationList>>any())).thenAnswer(invocation -> {

					RowMapper<ApplicationList> rowMapper = (RowMapper<ApplicationList>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("hi_application_id")).thenReturn(10L);
					Mockito.when(rs.getLong("hi_form_transaction_id")).thenReturn(20L);
					Mockito.when(rs.getLong("form1_aphir_data_id")).thenReturn(30L);
					Mockito.when(rs.getLong("student_id")).thenReturn(40L);
					Mockito.when(rs.getString("student_name")).thenReturn("John Doe");
					Mockito.when(rs.getString("school_year")).thenReturn("2026-2027");
					Mockito.when(rs.getString("application_no")).thenReturn("APP001");
					Mockito.when(rs.getString("application_type")).thenReturn("HI");
					Mockito.when(rs.getString("application_type_abbr")).thenReturn("HI");
					Mockito.when(rs.getString("student_school")).thenReturn("School 1");
					Mockito.when(rs.getString("student_grade")).thenReturn("5");
					Mockito.when(rs.getString("application_status")).thenReturn("Submitted");
					Mockito.when(rs.getString("application_status_abbr")).thenReturn("SUB");
					Mockito.when(rs.getString("application_date")).thenReturn("2026-01-01");
					Mockito.when(rs.getString("classification")).thenReturn("Regular");
					Mockito.when(rs.getString("hi_period")).thenReturn("2026");
					Mockito.when(rs.getString("updated_on")).thenReturn("2026-01-02");
					Mockito.when(rs.getBoolean("is_active")).thenReturn(true);
					Mockito.when(rs.getString("uploaded_generated_tag")).thenReturn("TAG001");

					List<ApplicationList> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<ApplicationList> result = repo.getApplicationDetails(request);

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetApplicationDetailsException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ApplicationList>>any()))
				.thenThrow(new DataAccessException("Database error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.getApplicationDetails(new GetAppListReq());
		} catch (Exception e) {
			assertEquals("Database error", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetAppDetailsCount() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);
					Mockito.when(rs.getLong("count")).thenReturn(5L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = repo.getAppDetailsCount(new GetAppListReq());

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(5L, result.get(0));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetAppDetailsCountWithLoggedInUser() throws Exception {

		GetAppListReq request = new GetAppListReq();
		request.setSchoolYear("2026-2027");
		request.setStatus("SUBMITTED");
		request.setstudent("John");
		request.setSchoolCode("SCH001");
		request.setGradeId(5);
		request.setApplicationNo("APP001");
		request.setApplicationDate("2026-01-01");
		request.setAllApplication(true);
		request.setLoggedInUserId("0f06KVmiMuG/nQrPJpnrxg==");
		request.setLoggedInUserPersonType("STAFF");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);
					Mockito.when(rs.getLong("count")).thenReturn(10L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = repo.getAppDetailsCount(request);

		assertNotNull(result);
		assertEquals(10L, result.get(0));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetAppDetailsCountException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenThrow(new DataAccessException("Count error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.getAppDetailsCount(new GetAppListReq());
		} catch (Exception e) {
			assertEquals("Count error", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIActivity() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UpdateHIActivityResp>>any())).thenAnswer(invocation -> {

					RowMapper<UpdateHIActivityResp> rowMapper = (RowMapper<UpdateHIActivityResp>) invocation
							.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(123L);
					Mockito.when(rs.getString("application_no")).thenReturn("APP001");
					Mockito.when(rs.getString("application_status")).thenReturn("Completed");
					Mockito.when(rs.getString("application_status_abbrev")).thenReturn("COM");

					List<UpdateHIActivityResp> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<UpdateHIActivityResp> result = repo.updateHIActivity(new UpdateHIActivityReq());

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIActivityWithActionTakenBy() throws Exception {

		UpdateHIActivityReq request = new UpdateHIActivityReq();
		request.setApplicationId(123L);
		request.setActivity("SUBMIT");
		request.setStatus("COMPLETED");
		request.setComment("Completed successfully");
		request.setActionTakenBy("0f06KVmiMuG/nQrPJpnrxg==");
		request.setActionTakenByPersonType("STAFF");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UpdateHIActivityResp>>any())).thenAnswer(invocation -> {

					RowMapper<UpdateHIActivityResp> rowMapper = (RowMapper<UpdateHIActivityResp>) invocation
							.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(1L);
					Mockito.when(rs.getString("application_no")).thenReturn("APP001");
					Mockito.when(rs.getString("application_status")).thenReturn("Completed");
					Mockito.when(rs.getString("application_status_abbrev")).thenReturn("COM");

					List<UpdateHIActivityResp> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<UpdateHIActivityResp> result = repo.updateHIActivity(request);

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIActivityException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<UpdateHIActivityResp>>any()))
				.thenThrow(new DataAccessException("Activity error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.updateHIActivity(new UpdateHIActivityReq());
		} catch (Exception e) {
			assertEquals("Activity error", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIApplication() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);
					Mockito.when(rs.getLong("tag_id")).thenReturn(100L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = repo.updateHIApplication(new UpdateHIApplicationReq());

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(100L, result.get(0));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIApplicationWithEncryptedValues() throws Exception {

		UpdateHIApplicationReq request = new UpdateHIApplicationReq();

		request.setId(565L);
		request.setIndicator("UPDATE");
		request.setSchoolYear("2026-2027");
		request.setStudentId("0f06KVmiMuG/nQrPJpnrxg==");
		request.setApplicationType("HI");
		request.setSchoolCode("SCH001");
		request.setGradeId(5);
		request.setRequestDate("2026-01-01");
		request.setClassification("Regular");
		request.setSubmittedBy("0f06KVmiMuG/nQrPJpnrxg==");
		request.setSubmittedByPersonType("STAFF");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);
					Mockito.when(rs.getLong("tag_id")).thenReturn(200L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = repo.updateHIApplication(request);

		assertNotNull(result);
		assertEquals(200L, result.get(0));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIApplicationException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any()))
				.thenThrow(new DataAccessException("Application update error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.updateHIApplication(new UpdateHIApplicationReq());
		} catch (Exception e) {
			assertEquals("Application update error", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	void testApplicationStatusList() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<AppStatusListResp>>any())).thenAnswer(invocation -> {

					RowMapper<AppStatusListResp> rowMapper = (RowMapper<AppStatusListResp>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString("applnsts_abbvrs")).thenReturn("SUB");
					Mockito.when(rs.getString("status_text")).thenReturn("Submitted");

					List<AppStatusListResp> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<AppStatusListResp> result = repo.applicationStatusList("STAFF");

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testApplicationStatusListException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<AppStatusListResp>>any()))
				.thenThrow(new DataAccessException("Status error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.applicationStatusList("STAFF");
		} catch (Exception e) {
			assertEquals("Status error", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	void testApplicationSummary() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ApplicationSummaryResp>>any())).thenAnswer(invocation -> {

					RowMapper<ApplicationSummaryResp> rowMapper = (RowMapper<ApplicationSummaryResp>) invocation
							.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString("status_abbreviation")).thenReturn("SUB");
					Mockito.when(rs.getString("status_name")).thenReturn("Submitted");
					Mockito.when(rs.getLong("application_count")).thenReturn(5L);

					List<ApplicationSummaryResp> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<ApplicationSummaryResp> result = repo.applicationSummary("2026-2027", "", "STAFF");

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testApplicationSummaryWithLoggedInUser() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ApplicationSummaryResp>>any())).thenAnswer(invocation -> {

					RowMapper<ApplicationSummaryResp> rowMapper = (RowMapper<ApplicationSummaryResp>) invocation
							.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString("status_abbreviation")).thenReturn("SUB");
					Mockito.when(rs.getString("status_name")).thenReturn("Submitted");
					Mockito.when(rs.getLong("application_count")).thenReturn(10L);

					List<ApplicationSummaryResp> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<ApplicationSummaryResp> result = repo.applicationSummary("2026-2027", "0f06KVmiMuG/nQrPJpnrxg==", "STAFF");

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testApplicationSummaryException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<ApplicationSummaryResp>>any()))
				.thenThrow(new DataAccessException("Summary error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.applicationSummary("2026-2027", "", "STAFF");
		} catch (Exception e) {
			assertEquals("Summary error", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetSchoolResp() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<SchoolResp>>any())).thenAnswer(invocation -> {

					RowMapper<SchoolResp> rowMapper = (RowMapper<SchoolResp>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("school_id")).thenReturn(1L);
					Mockito.when(rs.getString("school_code")).thenReturn("SCH001");
					Mockito.when(rs.getString("school_name")).thenReturn("Test School");

					List<SchoolResp> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<SchoolResp> result = repo.getSchoolResp();

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetSchoolRespException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<SchoolResp>>any())).thenThrow(new DataAccessException("School error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.getSchoolResp();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("School error"));
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetGradeList() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<GradeListResp>>any())).thenAnswer(invocation -> {

					RowMapper<GradeListResp> rowMapper = (RowMapper<GradeListResp>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getInt("grade_id")).thenReturn(5);
					Mockito.when(rs.getString("grade")).thenReturn("V");

					List<GradeListResp> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<GradeListResp> result = repo.getGradeList();

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetGradeListException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<GradeListResp>>any())).thenThrow(new DataAccessException("Grade error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.getGradeList();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Grade error"));
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateAssignTeacher() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(123L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = repo.updateAssignTeacher(new UpdateAssignTeacherReq());

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(123L, result.get(0));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateAssignTeacherWithActionTakenBy() throws Exception {

		UpdateAssignTeacherReq request = new UpdateAssignTeacherReq();

		request.setApplicationId(565L);
		request.setEmployeeIds("101,102");
		request.setActionTakenBy("0f06KVmiMuG/nQrPJpnrxg==");
		request.setActionTakenByPersonType("STAFF");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(456L);

					List<Long> result = new ArrayList<>();
					result.add(rowMapper.mapRow(rs, 0));

					return result;
				});

		List<Long> result = repo.updateAssignTeacher(request);

		assertNotNull(result);
		assertEquals(456L, result.get(0));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateAssignTeacherException() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenThrow(new DataAccessException("Teacher update error") {
					private static final long serialVersionUID = 1L;
				});

		try {
			repo.updateAssignTeacher(new UpdateAssignTeacherReq());
		} catch (Exception e) {
			assertEquals("Teacher update error", e.getMessage());
		}
	}

	@Test
	void testRepositoryIsCreated() {
		assertNotNull(repo);
	}
}
