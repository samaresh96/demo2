/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.io.File;

public class HIFormTransactionResp {
	private Long id;
	private Long applicationId;
	private Long activityId;
	private Long formMasterId;
	private String formName;
	private String otherDocumentName;
	private String uploadedGeneratedTag;
	private Long dataRecordId;
	private String originalFileName;
	private String uploadedFileName;
	private String originalFileExtension;
	private Double originalFileSize;
	private String fileSize;
	private String encryptedFileGuid;
	private String fileStorageIndicator;
	private Long uploadedBy;
	private String uploadedOn;
	private String uploadedByPersonType;
	private File downloadedFile;

	public HIFormTransactionResp() {
	}

	public HIFormTransactionResp(Long id, Long applicationId, Long activityId, Long formMasterId, String formName,
			String otherDocumentName, String uploadedGeneratedTag, Long dataRecordId, String originalFileName,
			String uploadedFileName, String originalFileExtension, Double originalFileSize, String fileSize,
			String encryptedFileGuid, String fileStorageIndicator, Long uploadedBy, String uploadedOn,
			String uploadedByPersonType) {
		this.id = id;
		this.applicationId = applicationId;
		this.activityId = activityId;
		this.formMasterId = formMasterId;
		this.formName = formName;
		this.otherDocumentName = otherDocumentName;
		this.uploadedGeneratedTag = uploadedGeneratedTag;
		this.dataRecordId = dataRecordId;
		this.originalFileName = originalFileName;
		this.uploadedFileName = uploadedFileName;
		this.originalFileExtension = originalFileExtension;
		this.originalFileSize = originalFileSize;
		this.fileSize = fileSize;
		this.encryptedFileGuid = encryptedFileGuid;
		this.fileStorageIndicator = fileStorageIndicator;
		this.uploadedBy = uploadedBy;
		this.uploadedOn = uploadedOn;
		this.uploadedByPersonType = uploadedByPersonType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getFormMasterId() {
		return formMasterId;
	}

	public void setFormMasterId(Long formMasterId) {
		this.formMasterId = formMasterId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
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

	public Long getDataRecordId() {
		return dataRecordId;
	}

	public void setDataRecordId(Long dataRecordId) {
		this.dataRecordId = dataRecordId;
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

	public String getUploadedFileName() {
		return uploadedFileName;
	}

	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}

	public void setOriginalFileExtension(String originalFileExtension) {
		this.originalFileExtension = originalFileExtension;
	}

	public Double getOriginalFileSize() {
		return originalFileSize;
	}

	public void setOriginalFileSize(Double originalFileSize) {
		this.originalFileSize = originalFileSize;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getEncryptedFileGuid() {
		return encryptedFileGuid;
	}

	public void setEncryptedFileGuid(String encryptedFileGuid) {
		this.encryptedFileGuid = encryptedFileGuid;
	}

	public String getFileStorageIndicator() {
		return fileStorageIndicator;
	}

	public void setFileStorageIndicator(String fileStorageIndicator) {
		this.fileStorageIndicator = fileStorageIndicator;
	}

	public Long getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(Long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(String uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public String getUploadedByPersonType() {
		return uploadedByPersonType;
	}

	public void setUploadedByPersonType(String uploadedByPersonType) {
		this.uploadedByPersonType = uploadedByPersonType;
	}

	public File getDownloadedFile() {
		return downloadedFile;
	}

	public void setDownloadedFile(File downloadedFile) {
		this.downloadedFile = downloadedFile;
	}

	@Override
	public String toString() {
		return "HIFormTransactionResp [id=" + id + ", applicationId=" + applicationId + ", activityId=" + activityId
				+ ", formMasterId=" + formMasterId + ", formName=" + formName + ", otherDocumentName="
				+ otherDocumentName + ", uploadedGeneratedTag=" + uploadedGeneratedTag + ", dataRecordId="
				+ dataRecordId + ", originalFileName=" + originalFileName + ", uploadedFileName=" + uploadedFileName
				+ ", originalFileExtension=" + originalFileExtension + ", originalFileSize=" + originalFileSize
				+ ", fileSize=" + fileSize + ", encryptedFileGuid=" + encryptedFileGuid + ", fileStorageIndicator="
				+ fileStorageIndicator + ", uploadedBy=" + uploadedBy + ", uploadedOn=" + uploadedOn
				+ ", uploadedByPersonType=" + uploadedByPersonType + ", downloadedFile=" + downloadedFile + "]";
	}

}
