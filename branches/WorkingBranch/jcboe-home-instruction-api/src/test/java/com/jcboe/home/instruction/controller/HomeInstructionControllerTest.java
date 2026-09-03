package com.jcboe.home.instruction.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jcboe.home.instruction.model.request.Form10Request;
import com.jcboe.home.instruction.model.request.Form1Request;
import com.jcboe.home.instruction.model.request.Form2Request;
import com.jcboe.home.instruction.model.request.Form3Request;
import com.jcboe.home.instruction.model.request.Form4Request;
import com.jcboe.home.instruction.model.request.Form630DHIRequest;
import com.jcboe.home.instruction.model.request.Form760DHIRequest;
import com.jcboe.home.instruction.model.request.Form8Request;
import com.jcboe.home.instruction.model.request.Form9Request;
import com.jcboe.home.instruction.response.Form10HSAPPResponseDTO;
import com.jcboe.home.instruction.response.Form1APHIRResponseDTO;
import com.jcboe.home.instruction.response.Form1AphirResp;
import com.jcboe.home.instruction.response.Form2RHIDTResponseDTO;
import com.jcboe.home.instruction.response.Form2RhidtResp;
import com.jcboe.home.instruction.response.Form3RhiltResp;
import com.jcboe.home.instruction.response.Form3RhiltResponseDTO;
import com.jcboe.home.instruction.response.Form4PrthiResp;
import com.jcboe.home.instruction.response.Form4PrthiResponseDTO;
import com.jcboe.home.instruction.response.Form630DHIResp;
import com.jcboe.home.instruction.response.Form630DhiResponseDTO;
import com.jcboe.home.instruction.response.Form760DhiResp;
import com.jcboe.home.instruction.response.Form760DhiResponseDTO;
import com.jcboe.home.instruction.response.Form8HiscpResp;
import com.jcboe.home.instruction.response.Form8HiscpResponseDTO;
import com.jcboe.home.instruction.response.Form9EAPPResp;
import com.jcboe.home.instruction.response.Form9EAPPResponseDTO;
import com.jcboe.home.instruction.service.IHomeInstructionService;
import com.jcboe.home.instruction.service.IMessageService;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@ExtendWith(MockitoExtension.class)
class HomeInstructionControllerTest {

	@Mock
	private IHomeInstructionService iHomeInstructionService;

	@Mock
	private IMessageService msgService;

	@Mock
	private Utility utility;

	@Mock
	private HttpServletResponse response;

	@Mock
	private Resource resource;

	@InjectMocks
	private HomeInstructionController homeInstructionController;

	@Test
	void testConstructor() {
		HomeInstructionController controller = new HomeInstructionController(iHomeInstructionService, msgService);

		assertNotNull(controller);
	}

	@Test
	void testUpdateForm1APHIR() {

		Form1Request request = new Form1Request();
		Form1AphirResp responseDTO = new Form1AphirResp();

		when(iHomeInstructionService.updateForm1Data(request)).thenReturn(responseDTO);

		ResponseEntity<Form1AphirResp> response = homeInstructionController.updateForm1APHIR(request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(responseDTO, response.getBody());

		verify(msgService).getMessage(Constant.AFC_UCF);
		verify(iHomeInstructionService).updateForm1Data(request);
	}

	@Test
	void testGetForm1APHIR() {

		when(iHomeInstructionService.getForm1ApiHir(null, null, null, null, null, null, null, false)).thenReturn(new Form1APHIRResponseDTO());
		homeInstructionController.getForm1APHIR(null, null, null, null, null, null, null, false);
	}

	@Test
	void testGetForm2RHIDT() {

		Form2RHIDTResponseDTO dto = new Form2RHIDTResponseDTO();

		when(iHomeInstructionService.getForm2RHIDT(1L, 1L, "config", "lookup")).thenReturn(dto);

		ResponseEntity<Form2RHIDTResponseDTO> response = homeInstructionController.getForm2RHIDT(1L, 1L, "config",
				"lookup");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_GFB);
		verify(iHomeInstructionService).getForm2RHIDT(1L, 1L, "config", "lookup");
	}

	@Test
	void testGetForm3Rhilt() {

		Form3RhiltResponseDTO dto = new Form3RhiltResponseDTO();

		when(iHomeInstructionService.getForm3Rhilt(1L, 1L, "config", "lookup")).thenReturn(dto);

		ResponseEntity<Form3RhiltResponseDTO> response = homeInstructionController.getForm3RHILT(1L, 1L, "config",
				"lookup");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_GFC);
		verify(iHomeInstructionService).getForm3Rhilt(1L, 1L, "config", "lookup");
	}

	@Test
	void testGetForm4Prthi() {

		Form4PrthiResponseDTO dto = new Form4PrthiResponseDTO();

		when(iHomeInstructionService.getForm4Prthi(1L, 1L, "config", "lookup")).thenReturn(dto);

		ResponseEntity<Form4PrthiResponseDTO> response = homeInstructionController.getForm4PRTHI(1L, 1L, "config",
				"lookup");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_GFD);
		verify(iHomeInstructionService).getForm4Prthi(1L, 1L, "config", "lookup");
	}

	@Test
	void testGetForm630Dhi() {

		Form630DhiResponseDTO dto = new Form630DhiResponseDTO();

		when(iHomeInstructionService.getForm630dhi(1L, "config", "lookup")).thenReturn(dto);

		ResponseEntity<Form630DhiResponseDTO> response = homeInstructionController.getForm630DHI(1L, "config",
				"lookup");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_GFE);
		verify(iHomeInstructionService).getForm630dhi(1L, "config", "lookup");
	}

	@Test
	void testGetForm760Dhi() {

		Form760DhiResp dto = new Form760DhiResp();

		when(iHomeInstructionService.getForm760Dhi(1L, "config", "lookup")).thenReturn(dto);

		ResponseEntity<Form760DhiResp> response = homeInstructionController.getform760DHI(1L, "config", "lookup");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_GFF);
		verify(iHomeInstructionService).getForm760Dhi(1L, "config", "lookup");
	}

	@Test
	void testGetForm8Hiscp() {

		Form8HiscpResponseDTO dto = new Form8HiscpResponseDTO();

		when(iHomeInstructionService.getForm8Hiscp(1L, 1L, "config", "lookup")).thenReturn(dto);

		ResponseEntity<Form8HiscpResponseDTO> response = homeInstructionController.getForm8HISCP(1L, 1L, "config",
				"lookup");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_GFG);
		verify(iHomeInstructionService).getForm8Hiscp(1L, 1L, "config", "lookup");
	}

	@Test
	void testUpdateForm2RHIDT() {

		Form2Request request = new Form2Request();
		Form2RhidtResp dto = new Form2RhidtResp();

		when(iHomeInstructionService.updateForm2Data(request)).thenReturn(dto);

		ResponseEntity<Form2RhidtResp> response = homeInstructionController.updateForm2RHIDT(request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_UCF);
		verify(iHomeInstructionService).updateForm2Data(request);
	}

	@Test
	void testUpdateForm3RHIDT() {

		Form3Request form3Request = new Form3Request();
		Form3RhiltResp dto = new Form3RhiltResp();

		when(iHomeInstructionService.updateForm3Data(form3Request)).thenReturn(dto);

		ResponseEntity<Form3RhiltResp> response = homeInstructionController.updateForm3RHILT(form3Request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_UCF);
	}

	@Test
	void testUpdateForm8HISCP() {

		Form8Request form8Request = new Form8Request();
		Form8HiscpResp dto = new Form8HiscpResp();

		when(iHomeInstructionService.updateForm8Data(form8Request)).thenReturn(dto);

		ResponseEntity<Form8HiscpResp> response = homeInstructionController.updateForm8HISCP(form8Request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.HISC_UCF_API_REF);
		verify(iHomeInstructionService).updateForm8Data(form8Request);
	}

	@Test
	void testUpdateForm9EAPP() {

		Form9Request form9Request = new Form9Request();
		Form9EAPPResp dto = new Form9EAPPResp();

		when(iHomeInstructionService.updateForm9Data(form9Request)).thenReturn(dto);

		ResponseEntity<Form9EAPPResp> response = homeInstructionController.updateForm9EAPP(form9Request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(dto, response.getBody());

		verify(msgService).getMessage(Constant.AFC_UCF);
	}

	@Test
	void testUpdateForm10HSAPP() {

		Form10Request request = new Form10Request();
		Form10HSAPPResponseDTO responseDTO = new Form10HSAPPResponseDTO();

		when(iHomeInstructionService.updateForm10Data(request)).thenReturn(responseDTO);

		ResponseEntity<Form10HSAPPResponseDTO> response = homeInstructionController.updateForm10HSAPP(request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(responseDTO, response.getBody());

		verify(iHomeInstructionService).updateForm10Data(request);
	}

	@Test
	void testUpdateForm10HSAPP_MessageMapCleared() {

		Form10Request request = new Form10Request();
		Form10HSAPPResponseDTO responseDTO = new Form10HSAPPResponseDTO();

		Constant.getMessageMap().put("TEST", "VALUE");

		when(iHomeInstructionService.updateForm10Data(request)).thenReturn(responseDTO);

		homeInstructionController.updateForm10HSAPP(request);

		assertTrue(Constant.getMessageMap().isEmpty());

		verify(iHomeInstructionService).updateForm10Data(request);
	}

	@Test
	void testgetForm9EAPP() throws Exception {
		when(iHomeInstructionService.getForm9EAPP(null, null, null, null)).thenReturn(new Form9EAPPResponseDTO());
		homeInstructionController.getForm9EAPP(null, null, null, null);
	}

	@Test
	void testUpdateForm630DHI() {

		// Arrange
		Form630DHIRequest request = new Form630DHIRequest();

		Form630DHIResp response = new Form630DHIResp();
		response.setMessage("Success");

		when(iHomeInstructionService.updateForm630DHIData(any(Form630DHIRequest.class))).thenReturn(response);

		// Act
		ResponseEntity<Form630DHIResp> result = homeInstructionController.updateForm630DHI(request);

		// Assert
		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNotNull(result.getBody());
		assertEquals("Success", result.getBody().getMessage());

		verify(msgService, times(1)).getMessage(Constant.RHI_UCF);
		verify(iHomeInstructionService, times(1)).updateForm630DHIData(any(Form630DHIRequest.class));
	}

	@Test
	void testgetForm10HSAPP() throws Exception {
		when(iHomeInstructionService.getForm10HSAPP(null, null, null, null)).thenReturn(new Form10HSAPPResponseDTO());
		homeInstructionController.getForm10HSAPP(null, null, null, null);
	}

	@Test
	void testUpdateForm760DHI() {

		Form760DHIRequest request = new Form760DHIRequest();
		Form760DhiResponseDTO response = new Form760DhiResponseDTO();

		doNothing().when(msgService).getMessage(Constant.RHI_UCF);
		when(iHomeInstructionService.updateForm760DHIData(any(Form760DHIRequest.class))).thenReturn(response);

		ResponseEntity<?> entity = homeInstructionController.updateForm760DHI(request);

		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(response, entity.getBody());

		verify(msgService).getMessage(Constant.RHI_UCF);
		verify(iHomeInstructionService).updateForm760DHIData(request);
	}

	@Test
	void testUpdateForm4PRTHI() {

		Form4Request request = new Form4Request();
		Form4PrthiResp responseDTO = new Form4PrthiResp();

		when(iHomeInstructionService.updateForm4Data(request)).thenReturn(responseDTO);

		ResponseEntity<Form4PrthiResp> response = homeInstructionController.updateForm4PRTHI(request);

		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(responseDTO, response.getBody());

		verify(msgService, times(1)).getMessage(Constant.PRIT_UCF);
		verify(iHomeInstructionService, times(1)).updateForm4Data(request);
	}

	@Test
	void testUpdateForm4PRTHI_MessageMapCleared() {

		Form4Request request = new Form4Request();
		Form4PrthiResp responseDTO = new Form4PrthiResp();

		Constant.getMessageMap().put("TEST", "VALUE");

		when(iHomeInstructionService.updateForm4Data(request)).thenReturn(responseDTO);

		ResponseEntity<Form4PrthiResp> response = homeInstructionController.updateForm4PRTHI(request);

		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(responseDTO, response.getBody());

		assertTrue(Constant.getMessageMap().isEmpty());

		verify(msgService, times(1)).getMessage(Constant.PRIT_UCF);
		verify(iHomeInstructionService, times(1)).updateForm4Data(request);
	}

	@Test
	void testUpdateForm4PRTHI_Exception_MessageMapCleared() {

		Form4Request request = new Form4Request();

		Constant.getMessageMap().put("TEST", "VALUE");

		when(iHomeInstructionService.updateForm4Data(request)).thenThrow(new RuntimeException("Update Form4 failed"));

		RuntimeException exception = assertThrows(RuntimeException.class,
				() -> homeInstructionController.updateForm4PRTHI(request));

		assertEquals("Update Form4 failed", exception.getMessage());
		assertTrue(Constant.getMessageMap().isEmpty());

		verify(msgService, times(1)).getMessage(Constant.PRIT_UCF);
		verify(iHomeInstructionService, times(1)).updateForm4Data(request);
	}

	@Test
	void testUpdateForm1PhysicianInfo() {

		Form1Request request = new Form1Request();
		Form1AphirResp responseDTO = new Form1AphirResp();

		when(iHomeInstructionService.updateForm1APHIRPhysicianInfo(request)).thenReturn(responseDTO);

		ResponseEntity<Form1AphirResp> response = homeInstructionController.UpdateForm1APHIRPhysicianInfo(request);

		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(responseDTO, response.getBody());

		verify(msgService, times(1)).getMessage(Constant.AFC_UCF);
		verify(iHomeInstructionService, times(1)).updateForm1APHIRPhysicianInfo(request);
	}

	@Test
	void testUpdateForm1PhysicianInfo_Exception_MessageMapCleared() {

		Form1Request request = new Form1Request();

		Constant.getMessageMap().put("TEST", "VALUE");

		when(iHomeInstructionService.updateForm1APHIRPhysicianInfo(request))
				.thenThrow(new RuntimeException("Update Physician Info failed"));

		RuntimeException exception = assertThrows(RuntimeException.class,
				() -> homeInstructionController.UpdateForm1APHIRPhysicianInfo(request));

		assertEquals("Update Physician Info failed", exception.getMessage());
		assertTrue(Constant.getMessageMap().isEmpty());

		verify(msgService, times(1)).getMessage(Constant.AFC_UCF);
		verify(iHomeInstructionService, times(1)).updateForm1APHIRPhysicianInfo(request);
	}

}