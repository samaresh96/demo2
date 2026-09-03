package com.jcboe.home.instruction.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jcboe.home.instruction.model.request.GetStudentInfoReqById;
import com.jcboe.home.instruction.response.GetStudentParentInfoResp;
import com.jcboe.home.instruction.response.ScreenTextResponse;
import com.jcboe.home.instruction.service.IAppConfigServiceImpl;
import com.jcboe.home.instruction.service.IMessageService;
import com.jcboe.home.instruction.utilities.Constant;

@ExtendWith(MockitoExtension.class)
class AppControllerTest {

	@Mock
	private IAppConfigServiceImpl appCofigService;

	@Mock
	private IMessageService iMessageService;

	@InjectMocks
	private AppController appController;

	@Test
	void testConstructor() {
		AppController controller = new AppController(appCofigService, iMessageService);

		assertNotNull(controller);
	}

	@Test
	void testGetScreenTextValues() {

		int screenId = 10;
		int languageId = 1;

		ScreenTextResponse responseDTO = new ScreenTextResponse();

		when(appCofigService.getScreenTextValues(screenId, languageId)).thenReturn(responseDTO);

		ResponseEntity<ScreenTextResponse> response = appController.getScreenTextValues(screenId, languageId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(responseDTO, response.getBody());

		verify(iMessageService).getMessage(Constant.APP_CONFIG_API_REF);
		verify(appCofigService).getScreenTextValues(screenId, languageId);

		assertNotNull(Constant.getMessageMap());
	}
	
	@Test
	void testGetStudentInfoByStudentId() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();
		GetStudentParentInfoResp responseDTO = new GetStudentParentInfoResp();

		when(appCofigService.getStudentInfoByStudentId(request)).thenReturn(responseDTO);

		ResponseEntity<GetStudentParentInfoResp> response = appController
				.getStudentInfoByStudentId(request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(responseDTO, response.getBody());

		verify(iMessageService).getMessage(Constant.AFC_GSF);
		verify(appCofigService).getStudentInfoByStudentId(request);

		assertNotNull(Constant.getMessageMap());
	}
}