/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.jcboe.home.instruction.model.request.ApplicationTrackingRequest;
import com.jcboe.home.instruction.model.request.DHIRequest;
import com.jcboe.home.instruction.model.request.DeleteDocumentReq;
import com.jcboe.home.instruction.model.request.UploadFormDocumentReq;
import com.jcboe.home.instruction.response.DeleteDocResponse;
import com.jcboe.home.instruction.response.FileUploadResp;
import com.jcboe.home.instruction.response.GetAttachmentListResp;

public interface IFileUploadService {

	FileUploadResp uploadAndParseFile(MultipartFile file, UploadFormDocumentReq formDocReq);

	HttpServletResponse getPdfFileDetails(Long id, Long applicationId, Long formMasterId, String loggedInUserPersonType,
			String schoolYear, HttpServletResponse response);

	Resource getDownloadSubmittedForm(Long id, Long applicationId, Long formMasterId, String loggedInUserPersonType,
			String schoolYear, String studentId);

	GetAttachmentListResp getAttachmentList(Long id, Long applicationId, Long formMasterId, String userType);

	DeleteDocResponse deleteFormDocument(DeleteDocumentReq deleteDocumentReq);

	HttpServletResponse getFormPdfDetails(Long id, Long applicationId, String loggedInUserPersonType,
			String formAbbreviation, HttpServletResponse response);

	HttpServletResponse getApplicationTrackingPdfDetails(ApplicationTrackingRequest applicationTrackingRequest,
			HttpServletResponse response);

	HttpServletResponse get30DHIPDFDetails(DHIRequest dHIRequest, HttpServletResponse response);

	HttpServletResponse getForm760DHIPDFDetails(DHIRequest dHIRequest, HttpServletResponse response);

	HttpServletResponse getTemplatePDFDetails(String formAbbreviation, HttpServletResponse response);

}
