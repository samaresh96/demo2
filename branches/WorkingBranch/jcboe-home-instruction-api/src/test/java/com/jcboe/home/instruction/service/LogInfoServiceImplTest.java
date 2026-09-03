package com.jcboe.home.instruction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jcboe.home.instruction.model.request.GetLogDataReq;
import com.jcboe.home.instruction.response.GetLogDataResp;

@ExtendWith(MockitoExtension.class)
class LogInfoServiceImplTest {

	@InjectMocks
	private LogInfoServiceImpl logInfoServiceImpl;

	@Test
	void testGetLogData_NullRequest() {

		GetLogDataResp response = logInfoServiceImpl.getLogData(null);

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertEquals("Log not found", response.getMessage());
	}

	@Test
	void testGetLogData_WithError() {

		GetLogDataReq request = new GetLogDataReq();
		request.setFunctionName("TestFunction");
		request.setError("Something went wrong");
		request.setDateTime("2026-01-01");
		request.setErrorFrom("UnitTest");

		GetLogDataResp response = logInfoServiceImpl.getLogData(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals("Record found successful.", response.getMessage());
	}

	@Test
	void testGetLogData_NoError() {

		GetLogDataReq request = new GetLogDataReq();
		request.setFunctionName("TestFunction");
		request.setError(null);
		request.setDateTime("2026-01-01");
		request.setErrorFrom("UnitTest");

		GetLogDataResp response = logInfoServiceImpl.getLogData(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals("Record found successful.", response.getMessage());
	}

	@Test
	void testGetLogData_BlankError() {

		GetLogDataReq request = new GetLogDataReq();
		request.setFunctionName("TestFunction");
		request.setError("   ");
		request.setDateTime("2026-01-01");
		request.setErrorFrom("UnitTest");

		GetLogDataResp response = logInfoServiceImpl.getLogData(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals("Record found successful.", response.getMessage());
	}

	@Test
	void testGetLogData_EmptyError() {

		GetLogDataReq request = new GetLogDataReq();
		request.setFunctionName("TestFunction");
		request.setError("");
		request.setDateTime("2026-01-01");
		request.setErrorFrom("UnitTest");

		GetLogDataResp response = logInfoServiceImpl.getLogData(request);

		assertNotNull(response);
		assertTrue(response.isSuccess());
		assertEquals("Record found successful.", response.getMessage());
	}
}
