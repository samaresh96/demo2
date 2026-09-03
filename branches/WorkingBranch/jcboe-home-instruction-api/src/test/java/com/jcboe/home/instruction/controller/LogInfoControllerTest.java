package com.jcboe.home.instruction.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jcboe.home.instruction.model.request.GetLogDataReq;
import com.jcboe.home.instruction.response.GetLogDataResp;
import com.jcboe.home.instruction.service.IMessageService;
import com.jcboe.home.instruction.service.LogInfoServiceImpl;

@ExtendWith(MockitoExtension.class)
class LogInfoControllerTest {

	@Mock
	private LogInfoServiceImpl iogInfoServiceImpl;

	@Mock
	private IMessageService msgService;

	@InjectMocks
	private LogInfoController logInfoController;

	@Test
	void testGetLogData() {

		GetLogDataReq request = new GetLogDataReq();
		GetLogDataResp responseDTO = new GetLogDataResp(true, "Success");

		when(iogInfoServiceImpl.getLogData(request)).thenReturn(responseDTO);

		ResponseEntity<GetLogDataResp> response = logInfoController.getLogData(request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(responseDTO, response.getBody());

		verify(msgService).getMessage("");
		verify(iogInfoServiceImpl).getLogData(request);
	}
}