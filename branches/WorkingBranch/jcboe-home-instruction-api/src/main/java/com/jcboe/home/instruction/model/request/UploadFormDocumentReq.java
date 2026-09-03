/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadFormDocumentReq {

	private String indicator;
	private long id;
	private String studentId;
	@JsonProperty("schoolYear")
	private String schoolYear;
	private String applicationType;
	private String schoolCode;
	private int gradeId;
	private String requestDate;
	private String classification;
	private String activity;
	private String status;
	private String comment;
	private Long applicationId;
	private Long formMasterId;
	private String otherDocumentName;
	private String uploadedGeneratedTag;
	private String originalFileName;
	private String originalFileExtension;
	@JsonIgnore
	private String originalFileSize;
	@JsonIgnore
	private String encryptedFileGuid;
	@JsonIgnore
	private String fileStorageInd;
	private String uploadedBy;
	private String uploadPersonType;

	public UploadFormDocumentReq() {
	}

	public UploadFormDocumentReq(String indicator, long id, String studentId, String schoolYear, String applicationType,
			String schoolCode, int gradeId, String requestDate, String classification, String activity, String status,
			String comment, Long applicationId, Long formMasterId, String otherDocumentName,
			String uploadedGeneratedTag, String originalFileName, String originalFileExtension, String originalFileSize,
			String encryptedFileGuid, String fileStorageInd, String uploadedBy, String uploadPersonType) {
		this.indicator = indicator;
		this.id = id;
		this.studentId = studentId;
		this.schoolYear = schoolYear;
		this.applicationType = applicationType;
		this.schoolCode = schoolCode;
		this.gradeId = gradeId;
		this.requestDate = requestDate;
		this.classification = classification;
		this.activity = activity;
		this.status = status;
		this.comment = comment;
		this.applicationId = applicationId;
		this.formMasterId = formMasterId;
		this.otherDocumentName = otherDocumentName;
		this.uploadedGeneratedTag = uploadedGeneratedTag;
		this.originalFileName = originalFileName;
		this.originalFileExtension = originalFileExtension;
		this.originalFileSize = originalFileSize;
		this.encryptedFileGuid = encryptedFileGuid;
		this.fileStorageInd = fileStorageInd;
		this.uploadedBy = uploadedBy;
		this.uploadPersonType = uploadPersonType;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getFormMasterId() {
		return formMasterId;
	}

	public void setFormMasterId(Long formMasterId) {
		this.formMasterId = formMasterId;
	}

	public String getOtherDocumentName() {
		return otherDocumentName;
	}

	public void setOtherDocumentName(String otherDocumentName) {
		this.otherDocumentName = otherDocumentName;
	}

	public String getUploadedGeneratedTag() {
		return uploadedGeneratedTag;
	}

	public void setUploadedGeneratedTag(String uploadedGeneratedTag) {
		this.uploadedGeneratedTag = uploadedGeneratedTag;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getOriginalFileExtension() {
		return originalFileExtension;
	}

	public void setOriginalFileExtension(String originalFileExtension) {
		this.originalFileExtension = originalFileExtension;
	}

	public String getOriginalFileSize() {
		return originalFileSize;
	}

	public void setOriginalFileSize(String originalFileSize) {
		this.originalFileSize = originalFileSize;
	}

	public String getEncryptedFileGuid() {
		return encryptedFileGuid;
	}

	public void setEncryptedFileGuid(String encryptedFileGuid) {
		this.encryptedFileGuid = encryptedFileGuid;
	}

	public String getFileStorageInd() {
		return fileStorageInd;
	}

	public void setFileStorageInd(String fileStorageInd) {
		this.fileStorageInd = fileStorageInd;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getUploadPersonType() {
		return uploadPersonType;
	}

	public void setUploadPersonType(String uploadPersonType) {
		this.uploadPersonType = uploadPersonType;
	}

	@Override
	public String toString() {
		return "UploadFormDocumentReq [indicator=" + indicator + ", id=" + id + ", studentId=" + studentId
				+ ", schoolYear=" + schoolYear + ", applicationType=" + applicationType + ", schoolCode=" + schoolCode
				+ ", gradeId=" + gradeId + ", requestDate=" + requestDate + ", classification=" + classification
				+ ", activity=" + activity + ", status=" + status + ", comment=" + comment + ", applicationId="
				+ applicationId + ", formMasterId=" + formMasterId + ", otherDocumentName=" + otherDocumentName
				+ ", uploadedGeneratedTag=" + uploadedGeneratedTag + ", originalFileName=" + originalFileName
				+ ", originalFileExtension=" + originalFileExtension + ", originalFileSize=" + originalFileSize
				+ ", encryptedFileGuid=" + encryptedFileGuid + ", fileStorageInd=" + fileStorageInd + ", uploadedBy="
				+ uploadedBy + ", uploadPersonType=" + uploadPersonType + "]";
	}

}