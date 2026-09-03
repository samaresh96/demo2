/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
public class HomeInstructionController {
	private IHomeInstructionService iHomeInstructionService;
	private IMessageService msgService;

	@Autowired
	HomeInstructionController(IHomeInstructionService iHomeInstructionService, IMessageService msgService) {
		this.iHomeInstructionService = iHomeInstructionService;
		this.msgService = msgService;
	}

	@GetMapping(value = "/GetForm1APHIR", produces = "application/json")
	public ResponseEntity<Form1APHIRResponseDTO> getForm1APHIR(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "formMasterId", required = true) Long formMasterId,
			@RequestParam(name = "loggedInUserId", required = true) String loggedInUserId,
			@RequestParam(name = "loggedInUserPersonType", required = true) String loggedInUserPersonType,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues,
			@RequestParam(name = "isStudent", required = false) boolean isStudent) {
		try {
			msgService.getMessage(Constant.AFC_GFA);
			Form1APHIRResponseDTO response = iHomeInstructionService.getForm1ApiHir(id, applicationId, formMasterId,
					loggedInUserId, loggedInUserPersonType, configKeys, lookupValues, isStudent);

			return new ResponseEntity<Form1APHIRResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 10-Feb-2026 Method: UpdateForm1APHIR Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm1APHIR", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form1AphirResp> updateForm1APHIR(@RequestBody Form1Request form1Request) {
		try {
			msgService.getMessage(Constant.AFC_UCF);

			Form1AphirResp response = iHomeInstructionService.updateForm1Data(form1Request);

			return new ResponseEntity<Form1AphirResp>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	@PostMapping(path = "/UpdateForm1APHIRPhysicianInfo", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form1AphirResp> UpdateForm1APHIRPhysicianInfo(@RequestBody Form1Request form1Request) { // NOSONAR
		try {
			msgService.getMessage(Constant.AFC_UCF);

			Form1AphirResp response = iHomeInstructionService.updateForm1APHIRPhysicianInfo(form1Request);

			return new ResponseEntity<Form1AphirResp>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	@GetMapping(value = "/GetForm2RHIDT", produces = "application/json")
	public ResponseEntity<Form2RHIDTResponseDTO> getForm2RHIDT(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues) {
		try {
			msgService.getMessage(Constant.AFC_GFB);
			Form2RHIDTResponseDTO response = iHomeInstructionService.getForm2RHIDT(id, applicationId, configKeys,
					lookupValues);

			return new ResponseEntity<Form2RHIDTResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 04-Aug-2026 Method: UpdateForm2RHIDT Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm2RHIDT", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form2RhidtResp> updateForm2RHIDT(@RequestBody Form2Request form2Request) {
		try {
			msgService.getMessage(Constant.RHI_UCF);

			Form2RhidtResp response = iHomeInstructionService.updateForm2Data(form2Request);

			return new ResponseEntity<Form2RhidtResp>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	@GetMapping(value = "/GetForm3RHILT", produces = "application/json")
	public ResponseEntity<Form3RhiltResponseDTO> getForm3RHILT(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues) {
		try {
			msgService.getMessage(Constant.AFC_GFC);
			Form3RhiltResponseDTO response = iHomeInstructionService.getForm3Rhilt(id, applicationId, configKeys,
					lookupValues);

			return new ResponseEntity<Form3RhiltResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 04-Aug-2026 Method: UpdateForm3RHIDT Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm3RHILT", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form3RhiltResp> updateForm3RHILT(@RequestBody Form3Request form3Request) {
		try {
			msgService.getMessage(Constant.RHID_UCF);

			Form3RhiltResp response = iHomeInstructionService.updateForm3Data(form3Request);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	@GetMapping(value = "/GetForm4PRTHI", produces = "application/json")
	public ResponseEntity<Form4PrthiResponseDTO> getForm4PRTHI(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues) {
		try {
			msgService.getMessage(Constant.AFC_GFD);
			Form4PrthiResponseDTO response = iHomeInstructionService.getForm4Prthi(id, applicationId, configKeys,
					lookupValues);

			return new ResponseEntity<Form4PrthiResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 04-Aug-2026 Method: UpdateForm4PRTHI Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm4PRTHI", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form4PrthiResp> updateForm4PRTHI(@RequestBody Form4Request form4Request) {
		try {
			msgService.getMessage(Constant.PRIT_UCF);

			Form4PrthiResp response = iHomeInstructionService.updateForm4Data(form4Request);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	@GetMapping(value = "/GetForm630DHI", produces = "application/json")
	public ResponseEntity<Form630DhiResponseDTO> getForm630DHI(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues) {
		try {
			msgService.getMessage(Constant.AFC_GFE);
			Form630DhiResponseDTO response = iHomeInstructionService.getForm630dhi(id, configKeys, lookupValues);

			return new ResponseEntity<Form630DhiResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 06-Aug-2026 Method: UpdateForm2RHIDT Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm630DHI", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form630DHIResp> updateForm630DHI(@RequestBody Form630DHIRequest form630DHIRequest) {
		try {
			msgService.getMessage(Constant.RHI_UCF);

			Form630DHIResp response = iHomeInstructionService.updateForm630DHIData(form630DHIRequest);

			return new ResponseEntity<Form630DHIResp>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	@GetMapping(value = "/GetForm760DHI", produces = "application/json")
	public ResponseEntity<Form760DhiResp> getform760DHI(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues) {
		try {
			msgService.getMessage(Constant.AFC_GFF);
			Form760DhiResp response = iHomeInstructionService.getForm760Dhi(id, configKeys, lookupValues);

			return new ResponseEntity<Form760DhiResp>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 07-Aug-2026 Method: UpdateForm760DHI Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm760DHI", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form760DhiResponseDTO> updateForm760DHI(@RequestBody Form760DHIRequest form760DHIRequest) {
		try {
			msgService.getMessage(Constant.RHI_UCF);

			Form760DhiResponseDTO response = iHomeInstructionService.updateForm760DHIData(form760DHIRequest);

			return new ResponseEntity<Form760DhiResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	@GetMapping(value = "/GetForm8HISCP", produces = "application/json")
	public ResponseEntity<Form8HiscpResponseDTO> getForm8HISCP(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues) {
		try {
			msgService.getMessage(Constant.AFC_GFG);
			Form8HiscpResponseDTO response = iHomeInstructionService.getForm8Hiscp(id, applicationId, configKeys,
					lookupValues);

			return new ResponseEntity<Form8HiscpResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 04-Aug-2026 Method: UpdateForm8HISCP Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm8HISCP", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form8HiscpResp> updateForm8HISCP(@RequestBody Form8Request form8Request) {
		try {
			msgService.getMessage(Constant.HISC_UCF_API_REF);

			Form8HiscpResp response = iHomeInstructionService.updateForm8Data(form8Request);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 06-Aug-2026 Method: GetForm9EAPP Purpose: For
	 * 
	 * 
	 */

	@GetMapping(value = "/GetForm9EAPP", produces = "application/json")
	public ResponseEntity<Form9EAPPResponseDTO> getForm9EAPP(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues) {
		try {
			msgService.getMessage(Constant.HIC_EAP);
			Form9EAPPResponseDTO response = iHomeInstructionService.getForm9EAPP(id, applicationId, configKeys,
					lookupValues);

			return new ResponseEntity<Form9EAPPResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 04-Aug-2026 Method: UpdateForm4PRTHI Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm9EAPP", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form9EAPPResp> updateForm9EAPP(@RequestBody Form9Request form9ERequest) {
		try {
			msgService.getMessage(Constant.EAPP_UCF_API_REF);

			Form9EAPPResp response = iHomeInstructionService.updateForm9Data(form9ERequest);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 06-Aug-2026 Method: GetForm10HSAPP Purpose: For
	 * 
	 * 
	 */

	@GetMapping(value = "/GetForm10HSAPP", produces = "application/json")
	public ResponseEntity<Form10HSAPPResponseDTO> getForm10HSAPP(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "configKeys", required = false) String configKeys,
			@RequestParam(name = "lookupValues", required = false) String lookupValues) {
		try {
			msgService.getMessage(Constant.HIC_HSA);
			Form10HSAPPResponseDTO response = iHomeInstructionService.getForm10HSAPP(id, applicationId, configKeys,
					lookupValues);

			return new ResponseEntity<Form10HSAPPResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 04-Aug-2026 Method: UpdateForm2RHIDT Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/UpdateForm10HSAPP", consumes = "application/json", produces = "application/json")
	ResponseEntity<Form10HSAPPResponseDTO> updateForm10HSAPP(@RequestBody Form10Request form10Request) {
		try {
			msgService.getMessage(Constant.RHI_UCF);

			Form10HSAPPResponseDTO response = iHomeInstructionService.updateForm10Data(form10Request);

			return new ResponseEntity<Form10HSAPPResponseDTO>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

}
