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
import com.jcboe.home.instruction.response.HomeInstructionConfig;

@SpringBootTest
class ConfigRepoTest {
	@MockBean
	private NamedParameterJdbcTemplate jdbcTemplate;

	@InjectMocks
	private ConfigRepo configRepo;

	@BeforeEach
	void setUp() {
		configRepo = new ConfigRepo(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetApplicationDetails() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<HomeInstructionConfig>>any())).thenAnswer((invocation) -> {

					RowMapper<HomeInstructionConfig> rowMapper = (RowMapper<HomeInstructionConfig>) invocation
							.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("configurationkey"))).thenReturn("abd");

					List<HomeInstructionConfig> users = new ArrayList<HomeInstructionConfig>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		configRepo.getMgmtConfigValuesByKey("");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetApplicationDetailsExcp() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<HomeInstructionConfig>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		configRepo.getMgmtConfigValuesByKey("");
	}

}
