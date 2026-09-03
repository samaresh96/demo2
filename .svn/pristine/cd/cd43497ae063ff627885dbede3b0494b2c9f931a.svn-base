/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.controller;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.ApplicationTrackingRequest;
import com.jcboe.home.instruction.model.request.DHIRequest;
import com.jcboe.home.instruction.model.request.DeleteDocumentReq;
import com.jcboe.home.instruction.model.request.UploadFormDocumentReq;
import com.jcboe.home.instruction.response.DeleteDocResponse;
import com.jcboe.home.instruction.response.FileUploadResp;
import com.jcboe.home.instruction.response.GetAttachmentListResp;
import com.jcboe.home.instruction.service.IFileUploadService;
import com.jcboe.home.instruction.service.MessageServiceImpl;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

@RestController
public class FileUploadController {

	private final Logger logger = LogManager.getLogger(FileUploadController.class);

	private final IFileUploadService uploadService;
	private final MessageServiceImpl messageService;
	private Utility utility;

	@Autowired
	public FileUploadController(IFileUploadService uploadService, MessageServiceImpl messageService, Utility utility) {
		this.uploadService = uploadService;
		this.messageService = messageService;
		this.utility = utility;
	}

	@PostMapping(path = "/UploadFormDocument", produces = "application/json")
	public ResponseEntity<FileUploadResp> uploadFormDocument(@RequestParam("file") MultipartFile file,
			@RequestParam("indicator") String indicator, @RequestParam("id") Long id,
			@RequestParam(name = "studentId", required = true) String studentId,
			@RequestParam("schoolYear") String schoolYear, @RequestParam("applicationType") String applicationType,
			@RequestParam("schoolCode") String schoolCode, @RequestParam("gradeId") int gradeId,
			@RequestParam("requestDate") String requestDate, @RequestParam("classification") String classification,
			@RequestParam("activity") String activity, @RequestParam("status") String status,
			@RequestParam(name = "comment", required = false) String comment,
			@RequestParam(name = "applicationId", required = false) Long applicationId,
			@RequestParam(name = "formMasterId", required = true) Long formMasterId,
			@RequestParam(name = "otherDocumentName", required = true) String otherDocumentName,
			@RequestParam("originalFileName") String originalFileName,
			@RequestParam(name = "loggedInUserId", required = true) String loggedInUserId,
			@RequestParam(name = "loggedInUserPersonType", required = true) String loggedInUserPersonType

	) {
		try {
			messageService.getMessage(Constant.FUA_API);

			UploadFormDocumentReq formDocReq = new UploadFormDocumentReq();
			formDocReq.setIndicator(indicator);
			formDocReq.setId(id);
			formDocReq.setStudentId(studentId);
			formDocReq.setSchoolYear(schoolYear);
			formDocReq.setApplicationType(applicationType);
			formDocReq.setSchoolCode(schoolCode);
			formDocReq.setGradeId(gradeId);
			formDocReq.setRequestDate(requestDate);
			formDocReq.setClassification(classification);
			formDocReq.setActivity(activity);
			formDocReq.setStatus(status);
			formDocReq.setComment(comment);
			formDocReq.setApplicationId(applicationId);
			formDocReq.setFormMasterId(formMasterId);
			formDocReq.setOtherDocumentName(otherDocumentName);
			formDocReq.setUploadedGeneratedTag("U");
			formDocReq.setOriginalFileName(originalFileName);
			formDocReq.setUploadedBy(loggedInUserId);
			formDocReq.setUploadPersonType(loggedInUserPersonType);

			FileUploadResp response = uploadService.uploadAndParseFile(file, formDocReq);

			return new ResponseEntity<FileUploadResp>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 19-June-2026 Method: getPdfFileDetails Purpose: fetch pdf file details
	 * 
	 *
	 */
	@GetMapping(value = "/GetPDFDetails", produces = "application/json")
	public ResponseEntity<String> getPdfFileDetails(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "applicationId", required = false) Long applicationId,
			@RequestParam(name = "formMasterId", required = false) Long formMasterId,
			@RequestParam(name = "loggedInUserPersonType", required = false) String loggedInUserPersonType,
			@RequestParam(name = "schoolYear", required = false) String schoolYear, HttpServletResponse response) {

		uploadService.getPdfFileDetails(id, applicationId, formMasterId, loggedInUserPersonType, schoolYear, response);

		return new ResponseEntity<>(null, HttpStatus.OK);// NOSONAR

	}

	@GetMapping(path = "/DownloadFormDocument", produces = "application/json")
	public ResponseEntity<String> downloadFormDocument(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "applicationId", required = false) Long applicationId,
			@RequestParam(name = "formMasterId", required = false) Long formMasterId,
			@RequestParam(name = "loggedInUserPersonType", required = false) String loggedInUserPersonType,
			@RequestParam(name = "schoolYear", required = false) String schoolYear,
			@RequestParam(name = "studentId", required = true) String studentId, HttpServletResponse response) {

		try {
			Resource resource = uploadService.getDownloadSubmittedForm(id, applicationId, formMasterId,
					loggedInUserPersonType, schoolYear, studentId);

			if (resource != null) {

				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", String.format("inline; filename=\"%s\"",
						StringUtils.replace(resource.getFilename(), "%20", " ")));

				response.setContentLength((int) resource.getFile().length());

				InputStream inputStream = resource.getInputStream();

				FileCopyUtils.copy(inputStream, response.getOutputStream());

				try {
					IOUtils.close(inputStream);
					IOUtils.close(response.getOutputStream());
					utility.permitFileAndFolder(resource.getFile());
				} catch (Exception e) {// NOSONAR
					logger.error("Exception occurred while closing resources or permitting file/folder {}",
							e.getMessage());
				}

				FileUtils.deleteQuietly(resource.getFile());

			} else {
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition",
						String.format("inline; filename=\"" + "Document_Not_Found.pdf" + "\""));

				ClassLoader classLoader = getClass().getClassLoader();
				InputStream is = classLoader.getResourceAsStream("Document_Not_Found.pdf");

				FileCopyUtils.copy(is, response.getOutputStream());

				try {
					IOUtils.close(is);
					IOUtils.close(response.getOutputStream());
				} catch (Exception e1) {// NOSONAR
					logger.error("Exception occurred while closing resources or permitting file/folder {}",
							e1.getMessage());
				}
			}

			return null;// NOSONAR

		} catch (Exception e) {// NOSONAR
			throw new HomeInstructionException(e.getMessage(), "Internal server error", e);
		}
	}

	@GetMapping(value = "/GetAttachmentList", produces = "application/json")
	public ResponseEntity<GetAttachmentListResp> getAttachmentList(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "formMasterId", required = true) Long formMasterId,
			@RequestParam(name = "userType", required = false) String userType) {
		try {
			messageService.getMessage(Constant.FUC_GAT);
			GetAttachmentListResp response = uploadService.getAttachmentList(id, applicationId, formMasterId, userType);

			return new ResponseEntity<GetAttachmentListResp>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	@PostMapping(path = "/DeleteFormDocument", produces = "application/json")
	public ResponseEntity<DeleteDocResponse> fileDelete(@RequestBody DeleteDocumentReq deleteDocumentReq) {
		try {
			messageService.getMessage(Constant.FDE_API);

			DeleteDocResponse response = uploadService.deleteFormDocument(deleteDocumentReq);

			return new ResponseEntity<DeleteDocResponse>(response, HttpStatus.OK);
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 19-June-2026 Method: getPdfFileDetails Purpose: fetch pdf file details
	 * 
	 *
	 */
	@GetMapping(value = "/GetFormPDFDetail", produces = "application/json")
	public ResponseEntity<String> getFormPDFDetail(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "applicationId", required = true) Long applicationId,
			@RequestParam(name = "loggedInUserPersonType", required = true) String loggedInUserPersonType,
			@RequestParam(name = "formAbbreviation", required = true) String formAbbreviation,
			HttpServletResponse response) {

		uploadService.getFormPdfDetails(id, applicationId, loggedInUserPersonType, formAbbreviation, response);

		return new ResponseEntity<>(null, HttpStatus.OK);// NOSONAR

	}

	/*
	 * 
	 * Date: 18-Aug-2026 Method: GetApplicationTrackingPdfDetails Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/GetApplicationTrackingPdfDetails", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getApplicationTrackingPdfDetails(
			@RequestBody ApplicationTrackingRequest applicationTrackingRequest, HttpServletResponse response) {

		try {
			uploadService.getApplicationTrackingPdfDetails(applicationTrackingRequest, response);

			return new ResponseEntity<>(null, HttpStatus.OK); // NOSONAR
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 19-Aug-2026 Method: Get30DHIPDFDetails Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/GetForm30DHIPDFDetails", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getForm30DHIPDFDetails(@RequestBody DHIRequest dHIRequest,
			HttpServletResponse response) {
		try {
			uploadService.get30DHIPDFDetails(dHIRequest, response);
			return ResponseEntity.status(HttpStatus.OK).build();
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 19-Aug-2026 Method: GetForm630DHIPDFDetails Purpose: For
	 * 
	 * 
	 */
	@PostMapping(path = "/GetForm760DHIPDFDetails", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getForm760DHIPDFDetails(@RequestBody DHIRequest dHIRequest,
			HttpServletResponse response) {
		try {
			uploadService.getForm760DHIPDFDetails(dHIRequest, response);
			return ResponseEntity.status(HttpStatus.OK).build();
		} finally {
			Constant.getMessageMap().clear();
		}
	}

	/*
	 * 
	 * Date: 20-Aug-2026 Method: GetTemplatePDFDetails Purpose: For
	 * 
	 * 
	 */
	@GetMapping(path = "/GetTemplatePDFDetails", produces = "application/json")
	public ResponseEntity<String> getTemplatePDFDetails(
			@RequestParam(name = "formAbbreviation", required = true) String formAbbreviation,
			HttpServletResponse response) {
		try {
			uploadService.getTemplatePDFDetails(formAbbreviation, response);
			return ResponseEntity.status(HttpStatus.OK).build();
		} finally {
			Constant.getMessageMap().clear();
		}
	}

}