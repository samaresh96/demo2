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

import com.jcboe.home.instruction.response.Message;


@SpringBootTest
class MessageRepoTest {

	@MockBean
	private NamedParameterJdbcTemplate jdbcTemplate;

	@InjectMocks
	private MessageRepo messageRepo;

	@BeforeEach
	void setUp() {
		messageRepo = new MessageRepo(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testgetMessages() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Message>>any())).thenAnswer((invocation) -> {

					RowMapper<Message> rowMapper = (RowMapper<Message>) invocation.getArgument(2);
					ResultSet rs = Mockito.mock(ResultSet.class);

					Mockito.when(rs.getString(ArgumentMatchers.eq("apiref"))).thenReturn("506");

					List<Message> users = new ArrayList<Message>();
					users.add(rowMapper.mapRow(rs, 0));
					return users;
				});

		messageRepo.getMessages("ffgh");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testgetMessagesExcp() throws Exception {
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Map.class),
				ArgumentMatchers.<RowMapper<Message>>any())).thenThrow(new DataAccessException(null) {
					private static final long serialVersionUID = 1L;
				});

		messageRepo.getMessages("ffgh");
	}

}
