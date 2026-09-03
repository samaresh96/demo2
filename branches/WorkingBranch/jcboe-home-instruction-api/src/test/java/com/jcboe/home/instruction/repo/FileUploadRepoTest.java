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

import com.jcboe.home.instruction.model.request.UpdateHIApplicationReq;
import com.jcboe.home.instruction.model.request.UploadFormDocumentReq;
import com.jcboe.home.instruction.response.DocumentUpdateResp;
import com.jcboe.home.instruction.response.FormSubFolderResp;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

@SpringBootTest
class FileUploadRepoTest {

	@MockBean
	private NamedParameterJdbcTemplate jdbcTemplate;

	@InjectMocks
	private FileUploadRepo fileUploadRepo;

	@InjectMocks
	private ApplicationListRepo applicationListRepo;

	@BeforeEach
	void setUp() {
		fileUploadRepo = new FileUploadRepo(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetFormSubfolder() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<FormSubFolderResp>>any())).thenAnswer((invocation) -> {

					RowMapper<FormSubFolderResp> rowMapper = (RowMapper<FormSubFolderResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("form_short_name"))).thenReturn("506");

					List<FormSubFolderResp> users = new ArrayList<FormSubFolderResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		fileUploadRepo.getFormSubfolder(98L);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetFormSubfolderExcp() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<FormSubFolderResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		fileUploadRepo.getFormSubfolder(98L);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHITransactionData() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<DocumentUpdateResp>>any())).thenAnswer((invocation) -> {

					RowMapper<DocumentUpdateResp> rowMapper = (RowMapper<DocumentUpdateResp>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("form_short_name"))).thenReturn("506");

					List<DocumentUpdateResp> users = new ArrayList<DocumentUpdateResp>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		fileUploadRepo.updateHITransactionData(new UploadFormDocumentReq());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHITransactionDataExcp() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<DocumentUpdateResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		fileUploadRepo.updateHITransactionData(new UploadFormDocumentReq());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIApplication() throws Exception {

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer((invocation) -> {

					RowMapper<Long> rowMapper = (RowMapper<Long>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("form_short_name"))).thenReturn("506");

					List<Long> users = new ArrayList<Long>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		applicationListRepo.updateHIApplication(new UpdateHIApplicationReq());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIApplicationExcp() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<DocumentUpdateResp>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		applicationListRepo.updateHIApplication(new UpdateHIApplicationReq());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHITransactionData_WithEncryptedStudentId() throws Exception {

		UploadFormDocumentReq req = new UploadFormDocumentReq();

		req.setStudentId(AES.encrypt("12345", Constant.SALT_AES));
		req.setUploadedBy(AES.encrypt("999", Constant.SALT_AES));
		req.setOriginalFileSize("100");
		req.setIndicator("I");
		req.setSchoolYear("2025-2026");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<DocumentUpdateResp>>any())).thenAnswer(invocation -> {

					RowMapper<DocumentUpdateResp> mapper = (RowMapper<DocumentUpdateResp>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(1L);
					Mockito.when(rs.getString("updated_on")).thenReturn("01/01/2026");

					List<DocumentUpdateResp> list = new ArrayList<>();
					list.add(mapper.mapRow(rs, 0));
					return list;
				});

		fileUploadRepo.updateHITransactionData(req);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testUpdateHIApplication_WithEncryptedStudentId() throws Exception {

		UpdateHIApplicationReq req = new UpdateHIApplicationReq();

		req.setStudentId(AES.encrypt("12345", Constant.SALT_AES));
		req.setSubmittedBy(AES.encrypt("999", Constant.SALT_AES));
		req.setSchoolYear("2025-2026");
		req.setIndicator("I");

		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Long>>any())).thenAnswer(invocation -> {

					RowMapper<Long> mapper = (RowMapper<Long>) invocation.getArgument(2);

					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getLong("tag_id")).thenReturn(100L);

					List<Long> list = new ArrayList<>();
					list.add(mapper.mapRow(rs, 0));
					return list;
				});

		applicationListRepo.updateHIApplication(req);
	}

}
