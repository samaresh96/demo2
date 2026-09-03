/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.repo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jcboe.home.instruction.model.request.UploadFormDocumentReq;
import com.jcboe.home.instruction.response.DocumentUpdateResp;
import com.jcboe.home.instruction.response.FormSubFolderResp;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;

@Repository
public class FileUploadRepo {

	private NamedParameterJdbcTemplate jdbcTemplate;
	private final Logger logger = LogManager.getLogger(FileUploadRepo.class);

	@Autowired
	public FileUploadRepo(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<FormSubFolderResp> getFormSubfolder(long formTypeId) throws Exception {
		logger.debug("Calling db function fn_get_form_subfolder with parameter(s): -{}", formTypeId);

		final String query = "SELECT * FROM fn_get_form_subfolder(:p_forminfo_id)";

		Map<String, Object> params = new HashMap<>();
		params.put("p_forminfo_id", formTypeId);

		try {
			List<FormSubFolderResp> formSubFolder = jdbcTemplate.query(query, params, // NOSONAR
					(rs, rowNum) -> new FormSubFolderResp(rs.getLong("forminfo_id"),

							rs.getString("subfolder"),

							rs.getString("description")));
			logger.debug("Record fetched successfully.");
			return formSubFolder;

		} catch (Exception e) {
			logger.error("Exception occurred while calling database function fn_get_form_subfolder: {} {}",
					e.getMessage(), e);
			throw e;
		}
	}

	public List<DocumentUpdateResp> updateHITransactionData(UploadFormDocumentReq formDocReq) throws Exception {
		logger.debug("Calling db function fn_update_hi_form_transaction with parameter(s): -{}", formDocReq);

		final String query = "SELECT * FROM fn_update_hi_form_transaction(:p_indicator,:p_id,:p_student_id,:p_school_year,:p_application_type,:p_school_code,:p_grade_id,:p_request_date,:p_activity,:p_status,:p_comment,:p_hi_application_id,:p_hi_activity_id,:p_hi_form_master_id,:p_other_document_name,:p_uploaded_generated_tag,:p_original_file_name,:p_original_file_extn,:p_original_file_size,:p_encrypted_file_guid,:p_file_storage_ind,:p_uploaded_by,:p_uploaded_by_person_type)";

		Map<String, Object> params = new HashMap<>();
		params.put("p_indicator", formDocReq.getIndicator());
		params.put("p_id", formDocReq.getId());
		if (StringUtils.isEmpty(formDocReq.getStudentId())) {
			params.put("p_student_id", formDocReq.getStudentId());
		} else {
			params.put("p_student_id", AES.decrypt(formDocReq.getStudentId(), Constant.SALT_AES));
		}
		params.put("p_school_year", formDocReq.getSchoolYear());
		params.put("p_application_type", formDocReq.getApplicationType());
		params.put("p_school_code", formDocReq.getSchoolCode());
		params.put("p_grade_id", formDocReq.getGradeId());
		params.put("p_request_date", formDocReq.getRequestDate());
		params.put("p_activity", formDocReq.getActivity());
		params.put("p_status", formDocReq.getStatus());
		params.put("p_comment", formDocReq.getComment());
		params.put("p_hi_application_id", formDocReq.getApplicationId());
		params.put("p_hi_activity_id", 0L);
		params.put("p_hi_form_master_id", formDocReq.getFormMasterId());
		params.put("p_other_document_name", formDocReq.getOtherDocumentName());
		params.put("p_uploaded_generated_tag", formDocReq.getUploadedGeneratedTag());
		params.put("p_original_file_name", formDocReq.getOriginalFileName());
		params.put("p_original_file_extn", formDocReq.getOriginalFileExtension());
		if (StringUtils.isNotEmpty(formDocReq.getOriginalFileSize())) {
			params.put("p_original_file_size", new BigDecimal(String.valueOf(formDocReq.getOriginalFileSize())));
		} else {
			params.put("p_original_file_size", 0);
		}
		params.put("p_encrypted_file_guid", formDocReq.getEncryptedFileGuid());
		params.put("p_file_storage_ind", formDocReq.getFileStorageInd());
		if (StringUtils.isNotEmpty(formDocReq.getUploadedBy())) {
			params.put("p_uploaded_by", AES.decrypt(formDocReq.getUploadedBy(), Constant.SALT_AES));
		} else {
			params.put("p_uploaded_by", 0);
		}
		params.put("p_uploaded_by_person_type", formDocReq.getUploadPersonType());

		try {
			List<DocumentUpdateResp> updatedList = jdbcTemplate.query(query, params,
					(rs, rowNum) -> new DocumentUpdateResp(rs.getLong("tag_id"), rs.getString("updated_on"),
							rs.getString("application_no"), rs.getString("application_status"),
							rs.getString("application_status_abbrev")));

			logger.debug("Record updated successfully.");

			return updatedList;

		} catch (Exception e) {
			logger.error("Exception occurred while calling database function fn_update_hi_form_transaction: {} {}",
					e.getMessage(), e);
			throw e;
		}
	}

}
