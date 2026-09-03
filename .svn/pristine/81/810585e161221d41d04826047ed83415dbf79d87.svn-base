/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.model.request.ApplicationTrackingDataList;
import com.jcboe.home.instruction.model.request.ApplicationTrackingRequest;
import com.jcboe.home.instruction.model.request.DHIRequest;
import com.jcboe.home.instruction.model.request.DeleteDocumentReq;
import com.jcboe.home.instruction.model.request.UpdateHIApplicationReq;
import com.jcboe.home.instruction.model.request.UploadFormDocumentReq;
import com.jcboe.home.instruction.repo.ApplicationListRepo;
import com.jcboe.home.instruction.repo.FileUploadRepo;
import com.jcboe.home.instruction.repo.HomeInstructionRepo;
import com.jcboe.home.instruction.response.ApplicationInfoResp;
import com.jcboe.home.instruction.response.DeleteDocResponse;
import com.jcboe.home.instruction.response.DocumentUpdateResp;
import com.jcboe.home.instruction.response.FileUploadResp;
import com.jcboe.home.instruction.response.Form10HSAPPDataResp;
import com.jcboe.home.instruction.response.Form1AphirDataResp;
import com.jcboe.home.instruction.response.Form1AphirScheduleResp;
import com.jcboe.home.instruction.response.Form2RHIDTDataResp;
import com.jcboe.home.instruction.response.Form3RhiltDataResp;
import com.jcboe.home.instruction.response.Form4PrthiDataResp;
import com.jcboe.home.instruction.response.Form630DhiDataResp;
import com.jcboe.home.instruction.response.Form760DhiDataResp;
import com.jcboe.home.instruction.response.Form8HiscpDataResp;
import com.jcboe.home.instruction.response.Form9EAPPDataResp;
import com.jcboe.home.instruction.response.FormSubFolderResp;
import com.jcboe.home.instruction.response.GetAttachmentListResp;
import com.jcboe.home.instruction.response.GetPhysicianInfoResp;
import com.jcboe.home.instruction.response.HIFormTransactionResp;
import com.jcboe.home.instruction.response.S3UploadResponse;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;
import com.jcboe.home.instruction.utilities.Zip4jUtility;

@Service
public class FileUploadServiceImpl implements IFileUploadService {
	private final Logger logger = LogManager.getLogger(FileUploadServiceImpl.class);
	private Utility utility;
	private FileUploadRepo fileUploadRepo;
	private HomeInstructionRepo homeInstructionRepo;
	private Zip4jUtility zip4jUtility;
	private ApplicationListRepo applicationListRepo;

	@Autowired
	public FileUploadServiceImpl(final Utility utility, FileUploadRepo fileUploadRepo,
			HomeInstructionRepo homeInstructionRepo, Zip4jUtility zip4jUtility,
			ApplicationListRepo applicationListRepo) {
		this.utility = utility;
		this.fileUploadRepo = fileUploadRepo;
		this.homeInstructionRepo = homeInstructionRepo;
		this.zip4jUtility = zip4jUtility;
		this.applicationListRepo = applicationListRepo;

	}

	@Override
	@Transactional
	public FileUploadResp uploadAndParseFile(MultipartFile file, UploadFormDocumentReq formDocReq) {// NOSONAR

		logger.debug("Request for uploadAndParseFile API: \n{}",
				utility.printJson(formDocReq) != null ? utility.printJson(formDocReq) : formDocReq);

		FileUploadResp response = new FileUploadResp();

		String uplodedFileName = "";
		String fileStorageInd = "";
		String formSubfolder = "";
		boolean isCompressed = false;
		FormSubFolderResp subObj = new FormSubFolderResp();
		try {
			if (Objects.isNull(file) || file.isEmpty()) {
				response.setMessage(Constant.getMessageMap().get(Constant.FUA_FSE));
				response.setSuccess(false);
				logger.info("Failed to store empty file.");
				return response;
			}

			Map<String, String> configKeyValuesForF = utility
					.getConfigList("FPATH,S3LIBBKTNAME,S3ACCESSKEY,S3SECRETKEY,S3BUCKETREGION,S3BUCKETFOLDER,"
							+ "FILEUPLOAD,FILEEXTN,FILEMSZ,FILECOM,FILETMPL,FORM_SUB_FOLDER");

			configKeyValuesForF.put("FILECOM", "false");
			String fileUploadType = configKeyValuesForF.get("FILEEXTN");
			formSubfolder = configKeyValuesForF.get("FORM_SUB_FOLDER");

			String extension = FilenameUtils.getExtension(file.getOriginalFilename());

			if (StringUtils.isNotEmpty(StringUtils.strip(fileUploadType))
					&& !StringUtils.containsIgnoreCase(fileUploadType, extension)) {

				String msg = StringUtils.replace(Constant.getMessageMap().get(Constant.FUA_CUF), "<FILE_TYPES>",
						fileUploadType);
				logger.info("Supported formats for upload are {}.", fileUploadType);
				return new FileUploadResp(false, msg);

			}

			long fileSizeByte = file.getSize();
			long maxPermissibleSize = DataSize.parse(configKeyValuesForF.get("FILEMSZ")).toBytes();
			if (maxPermissibleSize > 0 && fileSizeByte > maxPermissibleSize) {
				return new FileUploadResp(false, StringUtils.replace(Constant.getMessageMap().get(Constant.FUA_FSEX),
						"{size}", String.valueOf(configKeyValuesForF.get("FILEMSZ"))));
			}

			UUID guid = UUID.randomUUID();
			uplodedFileName = StringUtils.replace(guid.toString(), "-", "") + ".txt";

			fileStorageInd = configKeyValuesForF.get("FILEUPLOAD");
			formDocReq.setEncryptedFileGuid(uplodedFileName);
			formDocReq.setFileStorageInd(fileStorageInd);
			formDocReq.setOriginalFileExtension(extension);
			formDocReq.setOriginalFileSize(String.valueOf(fileSizeByte));

			UpdateHIApplicationReq updateHiApplicationReq = new UpdateHIApplicationReq();

			updateHiApplicationReq.setId(formDocReq.getApplicationId());
			updateHiApplicationReq.setStudentId(formDocReq.getStudentId());
			updateHiApplicationReq.setSchoolYear(formDocReq.getSchoolYear());
			updateHiApplicationReq.setApplicationType(formDocReq.getApplicationType());
			updateHiApplicationReq.setSchoolCode(formDocReq.getSchoolCode());
			updateHiApplicationReq.setGradeId(formDocReq.getGradeId());
			updateHiApplicationReq.setRequestDate(formDocReq.getRequestDate());
			if (StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "AMDFT")
					|| StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "AMSBM")
					|| StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "RESBM")) {
				updateHiApplicationReq.setClassification(formDocReq.getClassification());
			} else {
				updateHiApplicationReq.setClassification("GENOT");
			}
			updateHiApplicationReq.setSubmittedBy(formDocReq.getUploadedBy());
			updateHiApplicationReq.setSubmittedByPersonType(formDocReq.getUploadPersonType());

			if (formDocReq.getApplicationId() == null || formDocReq.getApplicationId() == 0L) {
				updateHiApplicationReq.setIndicator("I");
				List<Long> applicationId = applicationListRepo.updateHIApplication(updateHiApplicationReq);
				formDocReq.setApplicationId(applicationId.get(0));
			} else {
				updateHiApplicationReq.setIndicator("U");
				List<Long> applicationId = applicationListRepo.updateHIApplication(updateHiApplicationReq);
				formDocReq.setApplicationId(applicationId.get(0));
			}

			String encryptionPass = utility.getDocEncPass(String.valueOf(formDocReq.getApplicationId()));
			List<DocumentUpdateResp> updateHITransactionResp;

			if (StringUtils.equalsIgnoreCase(fileStorageInd, "S")) {

				String s3SubFolder = configKeyValuesForF.get("S3BUCKETFOLDER");

				if (StringUtils.isNotEmpty(StringUtils.strip(formSubfolder))) {
					s3SubFolder += "/" + formSubfolder;
				}

				if (StringUtils.isNotEmpty(StringUtils.strip(formDocReq.getSchoolYear()))) {
					s3SubFolder += "/" + formDocReq.getSchoolYear();
				}

				S3UploadResponse responseS3 = utility.uploadBase64FileToS3(file, configKeyValuesForF.get("S3ACCESSKEY"),
						configKeyValuesForF.get("S3SECRETKEY"), configKeyValuesForF.get("S3LIBBKTNAME"), s3SubFolder,
						configKeyValuesForF.get("S3BUCKETREGION"), uplodedFileName, isCompressed, encryptionPass,
						guid.toString(), configKeyValuesForF.get("FILETMPL"));

				if (responseS3.isSuccess()) {
					formDocReq.setEncryptedFileGuid(responseS3.getGuid());

					updateHITransactionResp = fileUploadRepo.updateHITransactionData(formDocReq);

					if (updateHITransactionResp != null && !updateHITransactionResp.isEmpty()) {
						response.setTransactionId(updateHITransactionResp.get(0).getId());
						response.setUpdatedOn(updateHITransactionResp.get(0).getUpdatedOn());
						response.setApplicationId(formDocReq.getApplicationId());
						response.setApplicationNo(updateHITransactionResp.get(0).getApplicationNo());
						response.setApplicationStatus(updateHITransactionResp.get(0).getApplicationStatus());
						response.setApplicationStatusAbbrev(
								updateHITransactionResp.get(0).getApplicationStatusAbbrev());
					}

				}

				List<HIFormTransactionResp> attachmentList = homeInstructionRepo.getHIFormTransactionData(0L,
						formDocReq.getApplicationId(), 0L, formDocReq.getUploadPersonType());

				response.setAttachmentList(attachmentList);
				response.setSuccess(responseS3.isSuccess());
				if (StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "AMSBM")) {
					response.setMessage(responseS3.isSuccess() ? Constant.getMessageMap().get(Constant.FUA_AUS)
							: Constant.getMessageMap().get(Constant.FUA_UUF));
				} else if (StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "FILBCN")) {
					response.setMessage(responseS3.isSuccess() ? Constant.getMessageMap().get(Constant.FUA_SCUS)
							: Constant.getMessageMap().get(Constant.FUA_UUF));
				} else if (StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "APC")) {
					response.setMessage(responseS3.isSuccess() ? Constant.getMessageMap().get(Constant.FUA_APC)
							: Constant.getMessageMap().get(Constant.FUA_UUF));
				} else {
					response.setMessage(responseS3.isSuccess() ? Constant.getMessageMap().get(Constant.FUA_FUS)
							: Constant.getMessageMap().get(Constant.FUA_UUF));
				}

				if (responseS3.isSuccess()) {
					logger.info("File uploaded successfully.");
				} else {
					logger.info("Unable to upload file.");
				}
				return response;
			} else {
				String s3SubFolder = configKeyValuesForF.get("FPATH");
				if (StringUtils.isNotEmpty(StringUtils.strip(formSubfolder))) {
					s3SubFolder += "/" + formSubfolder;
				}

				if (StringUtils.isNotEmpty(StringUtils.strip(formDocReq.getSchoolYear()))) {
					s3SubFolder += "/" + formDocReq.getSchoolYear();
				}
				File localFile = new File(s3SubFolder + File.separator + uplodedFileName);

				File encryptedFile = utility.getProtectedZipFile(file, encryptionPass, guid.toString(),
						configKeyValuesForF.get("FILETMPL"));

				String base64Doc = utility.getBase64EncDoc(encryptedFile);

				utility.createDirIfNotExists(localFile.getParentFile());

				FileUtils.writeStringToFile(localFile, base64Doc, StandardCharsets.UTF_8);

				utility.permitFileAndFolder(localFile);

				FileUtils.deleteQuietly(encryptedFile);

				updateHITransactionResp = fileUploadRepo.updateHITransactionData(formDocReq);

				if (updateHITransactionResp != null && !updateHITransactionResp.isEmpty()) {
					response.setTransactionId(updateHITransactionResp.get(0).getId());
					response.setUpdatedOn(updateHITransactionResp.get(0).getUpdatedOn());
					response.setApplicationId(formDocReq.getApplicationId());
					response.setApplicationNo(updateHITransactionResp.get(0).getApplicationNo());
					response.setApplicationStatus(updateHITransactionResp.get(0).getApplicationStatus());
					response.setApplicationStatusAbbrev(updateHITransactionResp.get(0).getApplicationStatusAbbrev());
				}

				List<HIFormTransactionResp> attachmentList = homeInstructionRepo.getHIFormTransactionData(0L,
						formDocReq.getApplicationId(), 0L, formDocReq.getUploadPersonType());

				response.setAttachmentList(attachmentList);
				response.setSuccess(true);
				if (StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "AMSBM")) {
					response.setMessage(Constant.getMessageMap().get(Constant.FUA_AUS));
				} else if (StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "FILBCN")) {
					response.setMessage(Constant.getMessageMap().get(Constant.FUA_SCUS));
				} else if (StringUtils.equalsIgnoreCase(formDocReq.getActivity(), "APC")) {
					response.setMessage(Constant.getMessageMap().get(Constant.FUA_APC));
				} else {
					response.setMessage(Constant.getMessageMap().get(Constant.FUA_FUS));
				}
				logger.info("File uploaded successfully.");
			}
		} catch (Exception e) {
			logger.error("Request for uploadAndParseFile: fileName>> {},  Form id>> {}",
					!Objects.isNull(file) ? file.getOriginalFilename() : "",
					String.valueOf(formDocReq.getApplicationId()));

			logger.error("Exception occured while uploading file: {}", e.getMessage());

			response.setSuccess(false);
			response.setMessage(Constant.getMessageMap().get(Constant.FUA_UUF));

			try {// NOSONAR
				deleteDocumentData((int) formDocReq.getId(), uplodedFileName, fileStorageInd, subObj.getDescription(),
						formDocReq.getOriginalFileName(), formSubfolder, true);
				logger.info(
						"File deleted successfully for exception on file upload : uplodedFileName-> {},fileStorageInd->{} , form id->{} ,description ->{}",
						uplodedFileName, fileStorageInd, formDocReq.getApplicationId(), subObj.getDescription());
			} catch (Exception e1) {
				logger.error("Exception occured while deleting file: {}", e1.getMessage());
			}

		}
		logger.debug(response.getMessage());
		return response;
	}

	public DeleteDocResponse deleteDocumentData(int actionFormDocId, String fileGuid, String fileStorageInd, // NOSONAR
			String description, String attachFileName, String formSubfolder, boolean isDeleteFromDB) {
		logger.debug("Request for deleteDocumentData: \n{}",
				utility.printJson(actionFormDocId) != null ? utility.printJson(actionFormDocId) : actionFormDocId);
		DeleteDocResponse response = new DeleteDocResponse();
		boolean success = false;

		try {

			Map<String, String> configKeyValuesForF = utility
					.getConfigList("FPATH,S3LIBBKTNAME,S3ACCESSKEY,S3SECRETKEY,S3BUCKETREGION,S3BUCKETFOLDER,FILECOM");
			// zip facility withdrawn in file upload/download
			configKeyValuesForF.put("FILECOM", "false");
			if (isDeleteFromDB) {
				UploadFormDocumentReq formDocReq = new UploadFormDocumentReq();
				formDocReq.setId(actionFormDocId);
				formDocReq.setIndicator("D");

				List<DocumentUpdateResp> updateId;

				updateId = fileUploadRepo.updateHITransactionData(formDocReq);

				success = updateId.get(0).getId() > 0;

			}
			String fileName = StringUtils.replace(fileGuid, ".txt", "") + ".txt";
			/**
			 * do not delete if
			 * (StringUtils.equalsIgnoreCase(configKeyValuesForF.get("FILECOM"), "true")) {
			 * fileName += ".gz"; }
			 */

			if (StringUtils.equalsIgnoreCase(fileStorageInd, "S")) {

				String s3SubFolder = configKeyValuesForF.get("S3BUCKETFOLDER");

				if (StringUtils.isNotEmpty(StringUtils.strip(formSubfolder))) {
					s3SubFolder += "/" + formSubfolder;
				}

				utility.deleteS3File(configKeyValuesForF.get("S3ACCESSKEY"), configKeyValuesForF.get("S3SECRETKEY"),
						configKeyValuesForF.get("S3BUCKETREGION"), configKeyValuesForF.get("S3LIBBKTNAME"), s3SubFolder,
						fileName);

			} else {

				if (StringUtils.isNotEmpty(StringUtils.strip(formSubfolder))) {
					formSubfolder = File.separator + formSubfolder;
				}

				File localFile = new File(configKeyValuesForF.get("FPATH") + formSubfolder + File.separator + fileName);
				try {
					if (localFile.exists()) {
						FileUtils.forceDelete(localFile);
					}
				} catch (Exception e) {
					logger.error("Exception occured for file delete: {}", e.getMessage());
				}

			}
			if (success) {
				response.setSuccess(success);
				response.setMessage(Constant.getMessageMap().get(Constant.FUA_FDS));
				logger.info("File deleted successfully.");

			} else {
				response.setSuccess(success);
				response.setMessage(Constant.getMessageMap().get(Constant.FUA_FDN));
				logger.info("File deleted not successfully.");

			}

		} catch (Exception e) {
			logger.info(
					"Request for deleteDocumentData:  studentRegnDocId>> {} , fileStorageInd>> {}, fileGuid>> {}, description {} , attachFileName>> {}",
					String.valueOf(actionFormDocId), fileStorageInd, fileGuid, description, attachFileName);
			logger.error("Exception occured for deleteDocumentData: {}", e.getMessage());
			throw new HomeInstructionException(e.getMessage(), "Internal Server error", e);

		}

		return response;
	}

	@Override
	public HttpServletResponse getPdfFileDetails(Long id, Long applicationId, Long formMasterId, // NOSONAR
			String loggedInUserPersonType, String schoolYear, HttpServletResponse response) {// NOSONAR

		logger.debug(
				"Parameters  for getPdfFileDetails: \n id {}, applicationId {}, formMasterId {},loggedInUserPersonType {}, schoolYear {}, ",
				id, applicationId, formMasterId, loggedInUserPersonType, schoolYear);

		Map<String, String> configKeyValuesForF = utility.getConfigList("FPATH,"
				+ "S3LIBBKTNAME,S3ACCESSKEY,S3SECRETKEY,S3BUCKETREGION,S3BUCKETFOLDER," + "FILEUPLOAD,"
				+ "FILEEXTN,FILEMSZ,FILECOM,FILETMPL,FORMSUBFOLDER,PHSC_ATCH_RPT_NAME,PHSC_ATCH_RPT_NAME,PHSC_ATCH_SUB_FOLDER,PARNT_ATCH_RPT_NAME,PARNT_ATCH_SUB_FOLDER,IncludeFolder,ParentFolder,TEMPL_PATH,FORM_SUB_FOLDER");

		List<File> downloadableFiles = new ArrayList<>();

		String temporaryPath = configKeyValuesForF.get("FILETMPL");

		try {

			List<HIFormTransactionResp> fileDetails = homeInstructionRepo.getHIFormTransactionData(id, applicationId,
					formMasterId, "");

			for (HIFormTransactionResp file : fileDetails) {

				String storageInd = file.getFileStorageIndicator();
				String originalExt = file.getOriginalFileExtension();
				String fileGuid = file.getEncryptedFileGuid();
				String originalName = file.getOriginalFileName();
				String encryptionPass = utility.getDocEncPass(String.valueOf(file.getApplicationId()));

				if (StringUtils.isNotEmpty(StringUtils.strip(storageInd))
						&& StringUtils.isNotEmpty(StringUtils.strip(originalExt))
						&& StringUtils.isNotEmpty(StringUtils.strip(fileGuid))
						&& StringUtils.isNotEmpty(StringUtils.strip(originalName))) {

					fileGuid = fileGuid.replace(".txt", "");

					String formSubfolder = configKeyValuesForF.get("FORM_SUB_FOLDER");

					if (StringUtils.equalsIgnoreCase(storageInd, "S")) {

						String s3SubFolder = configKeyValuesForF.get("S3BUCKETFOLDER");

						if (StringUtils.isNotEmpty(StringUtils.strip(formSubfolder))) {
							s3SubFolder += "/" + formSubfolder;
						}
						if (StringUtils.isNotEmpty(StringUtils.strip(schoolYear))) {
							s3SubFolder += "/" + schoolYear;
						}
						File decodedFile = utility.downloadFromS3AsStream(configKeyValuesForF.get("S3ACCESSKEY"),
								configKeyValuesForF.get("S3SECRETKEY"), configKeyValuesForF.get("S3LIBBKTNAME"),
								s3SubFolder, configKeyValuesForF.get("S3BUCKETREGION"), fileGuid,
								file.getOriginalFileName(), false,
								FilenameUtils.removeExtension(file.getEncryptedFileGuid()) + "." + originalExt,
								originalExt, encryptionPass, temporaryPath);

						if (decodedFile != null && decodedFile.exists()) {
							downloadableFiles.add(decodedFile);
						} else {
							logger.info("File not decoded: {}", originalName);
						}

					} else {

						String fileSubFolder = configKeyValuesForF.get("FPATH");

						if (StringUtils.isNotEmpty(StringUtils.strip(formSubfolder))) {
							fileSubFolder += "/" + formSubfolder;
						}
						if (StringUtils.isNotEmpty(StringUtils.strip(schoolYear))) {
							fileSubFolder += "/" + schoolYear;
						}

						File fPath = new File(fileSubFolder + File.separator + fileGuid + ".txt");

						File decodedFile = utility.decodeAndSaveFile(fPath, temporaryPath, file.getEncryptedFileGuid()
								+ "." + FilenameUtils.getExtension(file.getOriginalFileName()));

						if (decodedFile != null) {

							File unzippedFile = utility.getUnzippedFile(decodedFile,
									StringUtils.replace(file.getEncryptedFileGuid(), ".txt", "") + "."
											+ FilenameUtils.getExtension(file.getOriginalFileName()),
									file.getOriginalFileName(), originalExt, encryptionPass, temporaryPath);

							downloadableFiles.add(unzippedFile);

							try {
								utility.permitFileAndFolder(decodedFile);
								FileUtils.forceDelete(decodedFile);
							} catch (Exception e) {// NOSONAR
								logger.info("File not deleted due to : {} ", e.getMessage());
							}
						} else {
							logger.info("File not decoded: {} ", originalName);
						}

					}

				}

			}
		} catch (Exception e) {
			logger.error("Exception occured while downloading file: {}{}", e.getMessage(), e);
		}

		Resource resource = null;

		try {
			if (CollectionUtils.isNotEmpty(downloadableFiles)) {
				resource = new UrlResource(downloadableFiles.get(0).toURI());
			}
		} catch (Exception e) {
			logger.error("Exception occured while downloading file: {} {}", downloadableFiles.get(0), e.getMessage());
			throw new HomeInstructionException(e.getMessage(), "Internal server error", e);
		}

		utility.bindTheHttpServletResponse(resource, response);

		return response;

	}

	@Override
	public Resource getDownloadSubmittedForm(Long id, Long applicationId, Long formMasterId, // NOSONAR
			String loggedInUserPersonType, String schoolYear, String studentId) {// NOSONAR

		logger.debug(
				"Parameters  for getPdfFileDetails: \n id {}, applicationId {}, formMasterId {},loggedInUserPersonType {}, schoolYear {}, studentId {} ",
				id, applicationId, formMasterId, loggedInUserPersonType, schoolYear, studentId);
		Map<String, String> configKeyValuesForF = utility.getConfigList("FPATH,"
				+ "S3LIBBKTNAME,S3ACCESSKEY,S3SECRETKEY,S3BUCKETREGION,S3BUCKETFOLDER," + "FILEUPLOAD,"
				+ "FILEEXTN,FILEMSZ,FILECOM,FILETMPL,FORMSUBFOLDER,PHSC_ATCH_RPT_NAME,PHSC_ATCH_RPT_NAME,PHSC_ATCH_SUB_FOLDER,PARNT_ATCH_RPT_NAME,PARNT_ATCH_SUB_FOLDER,IncludeFolder,ParentFolder,TEMPL_PATH,FORM_SUB_FOLDER");

		List<HIFormTransactionResp> downloadableFiles = new ArrayList<>();

		String temporaryPath = configKeyValuesForF.get("FILETMPL");

		String zipFileName = "";
		String zipSubfolderName = "";
		try {

			List<HIFormTransactionResp> fileDetails = homeInstructionRepo.getHIFormTransactionData(id, applicationId,
					formMasterId, loggedInUserPersonType);

			Long studentIdDecrypted = AES.decrypt(studentId, Constant.SALT_AES);
			zipFileName = studentIdDecrypted + "_forms" + ".zip";
			zipSubfolderName = "uploads";
			for (HIFormTransactionResp file : fileDetails) {

				String storageInd = file.getFileStorageIndicator();
				String originalExt = file.getOriginalFileExtension();
				String fileGuid = file.getEncryptedFileGuid();
				String originalName = file.getOriginalFileName();
				String encryptionPass = utility.getDocEncPass(String.valueOf(file.getApplicationId()));

				if (StringUtils.isNotEmpty(StringUtils.strip(storageInd))
						&& StringUtils.isNotEmpty(StringUtils.strip(originalExt))
						&& StringUtils.isNotEmpty(StringUtils.strip(fileGuid))
						&& StringUtils.isNotEmpty(StringUtils.strip(originalName))) {

					fileGuid = fileGuid.replace(".txt", "");

					String formSubfolder = configKeyValuesForF.get("FORM_SUB_FOLDER");

					if (StringUtils.equalsIgnoreCase(storageInd, "S")) {

						String s3SubFolder = configKeyValuesForF.get("S3BUCKETFOLDER");

						if (StringUtils.isNotEmpty(StringUtils.strip(formSubfolder))) {
							s3SubFolder += "/" + formSubfolder;
						}
						File decodedFile = utility.downloadFromS3AsStream(configKeyValuesForF.get("S3ACCESSKEY"),
								configKeyValuesForF.get("S3SECRETKEY"), configKeyValuesForF.get("S3LIBBKTNAME"),
								s3SubFolder, configKeyValuesForF.get("S3BUCKETREGION"), fileGuid,
								file.getOriginalFileName(), false,
								FilenameUtils.removeExtension(file.getEncryptedFileGuid()) + "." + originalExt,
								originalExt, encryptionPass, temporaryPath);

						if (decodedFile != null && decodedFile.exists()) {
							File renameFile;

							renameFile = new File(temporaryPath + File.separator + file.getOriginalFileName());

							decodedFile.renameTo(renameFile); // NOSONAR
							file.setDownloadedFile(renameFile);
							downloadableFiles.add(file);
						} else {
							logger.info("File not decoded: {}", originalName);
						}

					} else {

						String fileSubFolder = configKeyValuesForF.get("FPATH");

						if (StringUtils.isNotEmpty(StringUtils.strip(formSubfolder))) {
							fileSubFolder += "/" + formSubfolder;
						}

						File fPath = new File(fileSubFolder + File.separator + StringUtils.defaultString(schoolYear)
								+ File.separator + fileGuid + ".txt");

						File decodedFile = utility.decodeAndSaveFile(fPath, temporaryPath, file.getEncryptedFileGuid()
								+ "." + FilenameUtils.getExtension(file.getOriginalFileName()));

						if (decodedFile != null) {

							File unzippedFile = utility.getUnzippedFile(decodedFile,
									StringUtils.replace(file.getEncryptedFileGuid(), ".txt", "") + "."
											+ FilenameUtils.getExtension(file.getOriginalFileName()),
									file.getOriginalFileName(), originalExt, encryptionPass, temporaryPath);

							File renameFile = new File(temporaryPath + File.separator + file.getOriginalFileName());

							unzippedFile.renameTo(renameFile);// NOSONAR

							file.setDownloadedFile(renameFile);
							downloadableFiles.add(file);

							try {
								utility.permitFileAndFolder(decodedFile);
								FileUtils.forceDelete(decodedFile);
							} catch (Exception e) {// NOSONAR
								logger.info("File not deleted due to : {} ", e.getMessage());
							}
						} else {
							logger.info("File not decoded: {} ", originalName);
						}

					}

				}
			}
		} catch (Exception e) {
			logger.error("Exception occured while downloading file: {}{}", "", e);
		}

		Resource r = null;

		try {

			if (!downloadableFiles.isEmpty()) {

				if (downloadableFiles.size() == 1) {
					// Only one file - download the original PDF directly
					File downloadedFile = downloadableFiles.get(0).getDownloadedFile();

					if (downloadedFile != null && downloadedFile.exists()) {
						r = new UrlResource(downloadedFile.toURI());
					}

				} else {
					try {
						String zipfilePath = temporaryPath + File.separator;

						File zipFilePath = zip4jUtility.zipMultipleFiles(downloadableFiles, zipfilePath, zipFileName,
								zipSubfolderName);

						r = new UrlResource(zipFilePath.toURI());

					} catch (Exception e) {
						logger.error("Exception occured while creating zip file: {} {}", downloadableFiles.get(0),
								e.getMessage());
					}
				}
			}

		} catch (Exception e) {// NOSONAR
			logger.error("Exception occured while downloading file: {} {}", downloadableFiles.get(0), e.getMessage());
			throw new HomeInstructionException(e.getMessage(), "Internal server error", e);
		}

		return r;

	}

	@Override
	public GetAttachmentListResp getAttachmentList(Long id, Long applicationId, Long formMasterId, String userType) {

		logger.info("Parameter for getAttachmentList API :id :{},applicationId :{},formMasterId :{}", id, applicationId,
				formMasterId);

		try {

			List<HIFormTransactionResp> attachmentList = homeInstructionRepo.getHIFormTransactionData(id, applicationId,
					formMasterId, userType);
			GetAttachmentListResp commonResponse = null;

			if (!attachmentList.isEmpty()) {

				commonResponse = new GetAttachmentListResp(true, Constant.getMessageMap().get(Constant.GAT_RFS),
						utility.responseDate(LocalDateTime.now()), attachmentList);

			} else {
				commonResponse = new GetAttachmentListResp(true, Constant.getMessageMap().get(Constant.GAT_RNF),
						utility.responseDate(LocalDateTime.now()), new ArrayList<>());

			}

			return commonResponse;

		} catch (Exception e) {
			logger.error("Exception occured while calling getAttachmentList data:{} ", e.getMessage());
			throw new HomeInstructionException(e.getMessage(), Constant.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional
	public DeleteDocResponse deleteFormDocument(DeleteDocumentReq deleteDocumentReq) {
		logger.debug("Request for deleteFormDocument: \n{}",
				utility.printJson(deleteDocumentReq) != null ? utility.printJson(deleteDocumentReq)
						: deleteDocumentReq);
		try {
			DeleteDocResponse commonResponse = new DeleteDocResponse();

			UploadFormDocumentReq uploadFormDocumentReq = new UploadFormDocumentReq();
			uploadFormDocumentReq.setIndicator(deleteDocumentReq.getIndicator());
			uploadFormDocumentReq.setId(deleteDocumentReq.getId());
			uploadFormDocumentReq.setActivity(deleteDocumentReq.getActivity());
			uploadFormDocumentReq.setStatus(deleteDocumentReq.getStatus());
			uploadFormDocumentReq.setComment(deleteDocumentReq.getComment());
			uploadFormDocumentReq.setUploadedBy(deleteDocumentReq.getLoggedInUserId());
			uploadFormDocumentReq.setUploadPersonType(deleteDocumentReq.getLoggedInUserPersonType());
			uploadFormDocumentReq.setApplicationId(deleteDocumentReq.getApplicationId());
			uploadFormDocumentReq.setStudentId(null);
			uploadFormDocumentReq.setSchoolYear("");
			uploadFormDocumentReq.setSchoolCode("");
			uploadFormDocumentReq.setApplicationType("");
			uploadFormDocumentReq.setGradeId(0);
			uploadFormDocumentReq.setRequestDate("");
			uploadFormDocumentReq.setFormMasterId(0L);
			uploadFormDocumentReq.setOtherDocumentName("");
			uploadFormDocumentReq.setUploadedGeneratedTag("");
			uploadFormDocumentReq.setOriginalFileName("");
			uploadFormDocumentReq.setOriginalFileExtension("");
			uploadFormDocumentReq.setOriginalFileSize("");
			uploadFormDocumentReq.setEncryptedFileGuid("");
			uploadFormDocumentReq.setFileStorageInd("");

			List<DocumentUpdateResp> updateHITransactionResp = fileUploadRepo
					.updateHITransactionData(uploadFormDocumentReq);

			List<HIFormTransactionResp> attachmentList = homeInstructionRepo.getHIFormTransactionData(0L,
					deleteDocumentReq.getApplicationId(), 0L, deleteDocumentReq.getLoggedInUserPersonType());

			if (CollectionUtils.isNotEmpty(updateHITransactionResp) && updateHITransactionResp.get(0).getId() > 0) {
				commonResponse.setSuccess(true);
				commonResponse.setMessage(Constant.getMessageMap().get(Constant.FDE_FDS));
				commonResponse.setAccessedOn(utility.responseDate(LocalDateTime.now()));
				commonResponse.setAttachmentList(attachmentList);
			} else {
				commonResponse.setAccessedOn(utility.responseDate(LocalDateTime.now()));
				commonResponse.setSuccess(false);
				commonResponse.setMessage(Constant.getMessageMap().get(Constant.FDE_FDN));
				commonResponse.setAttachmentList(null);
			}
			return commonResponse;

		} catch (Exception e) {
			logger.error("Exception occured for delete deleteFormDocument Document : {}", e.getMessage());
			throw new HomeInstructionException(e.getMessage(), "Internal Server error", e);
		}
	}

	@Override
	public HttpServletResponse getFormPdfDetails(Long id, Long applicationId, String loggedInUserPersonType,
			String formAbbreviation, HttpServletResponse response) {// NOSONAR
		logger.debug("Parameters for getFormPdfDetails: \\n  id {},formAbbreviation {}", id, formAbbreviation);
		Map<String, String> configKeyValuesForF = utility
				.getConfigList("TEMPL_PATH,FORM_SUB_FOLDER,HI_APPLN_HTML_APHIA,FILETMPL");

		String templatePath;

		if (StringUtils.equalsIgnoreCase(formAbbreviation, "APHIA")) {

			templatePath = configKeyValuesForF.get("TEMPL_PATH") + File.separator
					+ configKeyValuesForF.get("HI_APPLN_HTML_APHIA");

		} else {

			templatePath = configKeyValuesForF.get("TEMPL_PATH") + File.separator + "HI_APPLN_" + formAbbreviation
					+ ".html";
		}

		try {

			List<Form1AphirDataResp> dataList = homeInstructionRepo.getForm1AphirData(id, applicationId,
					loggedInUserPersonType);

			List<Form1AphirScheduleResp> scheduleData = homeInstructionRepo.getForm1AphirScheduleData(id); // NOSONAR

			if (CollectionUtils.isEmpty(dataList)) {
				throw new HomeInstructionException("Unable to fetch updated Form1 APHIR data.",
						Constant.DATABASE_ERROR_CODE);
			}

			String temporaryPath = configKeyValuesForF.get("FILETMPL");

			String modifiedTemplatePath = temporaryPath + File.separator + "ModiFied_HI_APPLN_" + formAbbreviation // NOSONAR
					+ ".html";

			String temporaryPdfPath = temporaryPath + File.separator + "HI_APPLN_" + formAbbreviation + ".pdf"; // NOSONAR

			StringBuilder mainHtml = new StringBuilder();

			boolean processReturn = utility.downloadPdfForm(dataList.get(0), mainHtml, formAbbreviation, templatePath,
					scheduleData);

			if (!processReturn) {
				throw new HomeInstructionException("Unable to generate PDF for form : " + formAbbreviation,
						Constant.DATABASE_ERROR_CODE);
			}

			File modifiedHtmlFile = new File(modifiedTemplatePath);

			FileUtils.writeStringToFile(modifiedHtmlFile, mainHtml.toString(), StandardCharsets.UTF_8);

			File pdfFile = new File(temporaryPdfPath);

			utility.generatePDF(modifiedHtmlFile.getAbsolutePath(), pdfFile.getAbsolutePath());

			if (!pdfFile.exists() || pdfFile.length() == 0) {

				throw new HomeInstructionException("PDF file was not generated for form: " + formAbbreviation,
						Constant.DATABASE_ERROR_CODE);
			}

			Resource resource = new UrlResource(pdfFile.toURI());

			utility.bindTheHttpServletResponse(resource, response);

			FileUtils.deleteQuietly(modifiedHtmlFile);

			return response;

		} catch (Exception e) {

			logger.error("Exception occurred while generating PDF for form {}: {}", formAbbreviation, e.getMessage(),
					e);

			throw new HomeInstructionException("Unable to generate PDF for form: " + formAbbreviation,
					Constant.DATABASE_ERROR_CODE, e);
		}
	}

	@Override
	public HttpServletResponse getApplicationTrackingPdfDetails(ApplicationTrackingRequest applicationTrackingRequest,
			HttpServletResponse response) {

		Map<String, String> configKeyValuesForF = utility.getConfigList("FILETMPL,TEMPL_PATH,HI_APPLN_TRACKING_HTML");

		String templatePath = configKeyValuesForF.get("TEMPL_PATH") + File.separator
				+ configKeyValuesForF.get("HI_APPLN_TRACKING_HTML");

		String templateFileName = configKeyValuesForF.get("HI_APPLN_TRACKING_HTML");
		String abbreviation = "LAHIT";

		File modifiedHtmlFile = null;
		File pdfFile = null;

		try {
			List<ApplicationTrackingDataList> dataList = applicationTrackingRequest.getApplicationTrackingDataList();

			if (CollectionUtils.isEmpty(dataList)) {
				throw new HomeInstructionException("Unable to fetch Application Tracking data.",
						Constant.DATABASE_ERROR_CODE);
			}

			StringBuilder mainHtml = new StringBuilder();

			boolean processReturn = utility.downloadPdfForm(dataList, mainHtml, abbreviation, templatePath, null);

			if (!processReturn) {
				throw new HomeInstructionException("Unable to generate PDF for form : " + abbreviation,
						Constant.DATABASE_ERROR_CODE);
			}

			String temporaryPath = configKeyValuesForF.get("FILETMPL");

			String temporaryPdfPath = temporaryPath + File.separator + templateFileName.replace(".html", ".pdf");

			String modifiedTemplatePath = temporaryPath + File.separator + "Modified" + templateFileName;

			modifiedHtmlFile = new File(modifiedTemplatePath);
			pdfFile = new File(temporaryPdfPath);

			FileUtils.writeStringToFile(modifiedHtmlFile, mainHtml.toString(), StandardCharsets.UTF_8);

			utility.generatePDF(modifiedHtmlFile.getAbsolutePath(), pdfFile.getAbsolutePath());

			if (!pdfFile.exists() || pdfFile.length() == 0) {
				throw new HomeInstructionException("PDF file was not generated for form: " + abbreviation,
						Constant.DATABASE_ERROR_CODE);
			}

			Resource resource = new UrlResource(pdfFile.toURI());

			utility.bindTheHttpServletResponse(resource, response);

			FileUtils.deleteQuietly(modifiedHtmlFile);

			return response;

		} catch (Exception e) {
			logger.error("Exception occurred while generating Application Tracking PDF for form {}: {}", abbreviation,
					e.getMessage(), e);

			throw new HomeInstructionException("Unable to generate PDF for form: " + abbreviation,
					Constant.DATABASE_ERROR_CODE, e);
		}
	}

	@Override
	public HttpServletResponse get30DHIPDFDetails(DHIRequest dHIRequest, HttpServletResponse response) {

		Map<String, String> configKeyValuesForF = utility.getConfigList("FILETMPL,TEMPL_PATH,HI_APPLN_TRACKING_HTML");

		String abbreviation = dHIRequest.getFormAbbreviation();
		String templateFileName = "HI_APPLN_" + abbreviation + ".html";
		String templatePath = configKeyValuesForF.get("TEMPL_PATH") + File.separator + templateFileName;

		File modifiedHtmlFile = null;
		File pdfFile = null;

		try {

			List<ApplicationInfoResp> appInfoData = homeInstructionRepo
					.getApplicationInfoData(dHIRequest.getApplicationId(), dHIRequest.getLoggedInUserPersonType());

			List<GetPhysicianInfoResp> physcData = homeInstructionRepo
					.getPhysicianInfoData(dHIRequest.getApplicationId());
			Form630DhiDataResp data = new Form630DhiDataResp();

			data.setStudentId(appInfoData.get(0).getStudentId());
			data.setStudentName(appInfoData.get(0).getStudentName());
			data.setNoticeDate(dHIRequest.getNoticeDate());
			data.setNurseName(dHIRequest.getNurseName());
			data.setStudentGrade(appInfoData.get(0).getStudentGrade());
			data.setPhysicianName(physcData.get(0).getPhysicianName());
			data.setPhysicianVerifiedOn(physcData.get(0).getPhysicianSignDate());
			if (CollectionUtils.isEmpty(appInfoData)) {
				throw new HomeInstructionException("Unable to fetch Application info  data.",
						Constant.DATABASE_ERROR_CODE);
			}

			StringBuilder mainHtml = new StringBuilder();

			boolean processReturn = utility.downloadPdfForm(data, mainHtml, abbreviation, templatePath, null);

			if (!processReturn) {
				throw new HomeInstructionException("Unable to generate PDF for form : " + abbreviation,
						Constant.DATABASE_ERROR_CODE);
			}

			String temporaryPath = configKeyValuesForF.get("FILETMPL");

			String temporaryPdfPath = temporaryPath + File.separator + templateFileName.replace(".html", ".pdf");

			String modifiedTemplatePath = temporaryPath + File.separator + "Modified" + templateFileName;

			modifiedHtmlFile = new File(modifiedTemplatePath);
			pdfFile = new File(temporaryPdfPath);

			FileUtils.writeStringToFile(modifiedHtmlFile, mainHtml.toString(), StandardCharsets.UTF_8);

			utility.generatePDF(modifiedHtmlFile.getAbsolutePath(), pdfFile.getAbsolutePath());

			if (!pdfFile.exists() || pdfFile.length() == 0) {
				throw new HomeInstructionException("PDF file was not generated for form: " + abbreviation,
						Constant.DATABASE_ERROR_CODE);
			}

			Resource resource = new UrlResource(pdfFile.toURI());

			utility.bindTheHttpServletResponse(resource, response);

			FileUtils.deleteQuietly(modifiedHtmlFile);

			return response;

		} catch (Exception e) {
			logger.error("Exception occurred while generating Application Tracking PDF for form {}: {}", abbreviation,
					e.getMessage(), e);

			throw new HomeInstructionException("Unable to generate PDF for form: " + abbreviation,
					Constant.DATABASE_ERROR_CODE, e);
		}
	}

	@Override
	public HttpServletResponse getForm760DHIPDFDetails(DHIRequest dHIRequest, HttpServletResponse response) {

		Map<String, String> configKeyValuesForF = utility.getConfigList("FILETMPL,TEMPL_PATH,HI_APPLN_TRACKING_HTML");

		String abbreviation = dHIRequest.getFormAbbreviation();
		String templateFileName = "HI_APPLN_" + abbreviation + ".html";
		String templatePath = configKeyValuesForF.get("TEMPL_PATH") + File.separator + templateFileName;

		File modifiedHtmlFile = null;
		File pdfFile = null;

		try {

			List<ApplicationInfoResp> appInfoData = homeInstructionRepo
					.getApplicationInfoData(dHIRequest.getApplicationId(), dHIRequest.getLoggedInUserPersonType());

			List<GetPhysicianInfoResp> physcData = homeInstructionRepo
					.getPhysicianInfoData(dHIRequest.getApplicationId());
			Form760DhiDataResp data = new Form760DhiDataResp();

			data.setStudentId(appInfoData.get(0).getStudentId());
			data.setStudentName(appInfoData.get(0).getStudentName());
			data.setNoticeDate(dHIRequest.getNoticeDate());
			data.setNurseName(dHIRequest.getNurseName());
			data.setStudentGrade(appInfoData.get(0).getStudentGrade());
			data.setPhysicianName(physcData.get(0).getPhysicianName());
			data.setPhysicianVerifiedOn(physcData.get(0).getPhysicianSignDate());
			if (CollectionUtils.isEmpty(appInfoData)) {
				throw new HomeInstructionException("Unable to fetch Application info  data.",
						Constant.DATABASE_ERROR_CODE);
			}

			StringBuilder mainHtml = new StringBuilder();

			boolean processReturn = utility.downloadPdfForm(data, mainHtml, abbreviation, templatePath, null);

			if (!processReturn) {
				throw new HomeInstructionException("Unable to generate PDF for form : " + abbreviation,
						Constant.DATABASE_ERROR_CODE);
			}

			String temporaryPath = configKeyValuesForF.get("FILETMPL");

			String temporaryPdfPath = temporaryPath + File.separator + templateFileName.replace(".html", ".pdf");

			String modifiedTemplatePath = temporaryPath + File.separator + "Modified" + templateFileName;

			modifiedHtmlFile = new File(modifiedTemplatePath);
			pdfFile = new File(temporaryPdfPath);

			FileUtils.writeStringToFile(modifiedHtmlFile, mainHtml.toString(), StandardCharsets.UTF_8);

			utility.generatePDF(modifiedHtmlFile.getAbsolutePath(), pdfFile.getAbsolutePath());

			if (!pdfFile.exists() || pdfFile.length() == 0) {
				throw new HomeInstructionException("PDF file was not generated for form: " + abbreviation,
						Constant.DATABASE_ERROR_CODE);
			}

			Resource resource = new UrlResource(pdfFile.toURI());

			utility.bindTheHttpServletResponse(resource, response);

			FileUtils.deleteQuietly(modifiedHtmlFile);

			return response;

		} catch (Exception e) {
			logger.error("Exception occurred while generating Application Tracking PDF for form {}: {}", abbreviation,
					e.getMessage(), e);

			throw new HomeInstructionException("Unable to generate PDF for form: " + abbreviation,
					Constant.DATABASE_ERROR_CODE, e);
		}
	}

	@Override
	public HttpServletResponse getTemplatePDFDetails(String formAbbreviation, HttpServletResponse response) {

		Map<String, String> configKeyValuesForF = utility
				.getConfigList("FILETMPL,TEMPL_PATH,HI_APPLN_TRACKING_HTML,HI_APPLN_HTML_APHIA");

		String abbreviation = formAbbreviation;
		String templateFileName;
		if (StringUtils.equalsIgnoreCase(formAbbreviation, "APHIA")) {
			templateFileName = configKeyValuesForF.get("HI_APPLN_HTML_APHIA");
		} else if (StringUtils.equalsIgnoreCase(formAbbreviation, "LAHIT")) {
			templateFileName = configKeyValuesForF.get("HI_APPLN_TRACKING_HTML");
		} else {
			templateFileName = "HI_APPLN_" + abbreviation + ".html";
		}

		String templatePath = configKeyValuesForF.get("TEMPL_PATH") + File.separator + templateFileName;
		File modifiedHtmlFile = null;
		File pdfFile = null;
		try {
			Object data = null;
			List<Form1AphirScheduleResp> sheduleData = null;
			switch (formAbbreviation) {
			case "APHIM":
			case "APHIA":
				Form1AphirDataResp aphimData = new Form1AphirDataResp();
				aphimData.setStudentId(0L);
				sheduleData = new ArrayList<>();
				sheduleData.add(new Form1AphirScheduleResp());
				data = aphimData;
				break;
			case "RHIDT":
				Form2RHIDTDataResp rhidtData = new Form2RHIDTDataResp();
				rhidtData.setStudentId(0L);
				data = rhidtData;
				break;
			case "RHILT":
				Form3RhiltDataResp rhiltData = new Form3RhiltDataResp();
				rhiltData.setStudentId(0L);
				data = rhiltData;
				break;
			case "PRTHI":
				Form4PrthiDataResp prthiData = new Form4PrthiDataResp();
				prthiData.setStudentId(0L);
				data = prthiData;
				break;
			case "LAHIT":
				ApplicationTrackingDataList lahitData = new ApplicationTrackingDataList();
				lahitData.setApplicationId(0L);
				List<ApplicationTrackingDataList> lahitDataList = new ArrayList<>();
				lahitDataList.add(lahitData);
				data = lahitDataList;
				break;
			case "30DHI":
				Form630DhiDataResp sixThirtydhiData = new Form630DhiDataResp();
				sixThirtydhiData.setStudentId(0L);
				data = sixThirtydhiData;
				break;
			case "60DHI":
				Form760DhiDataResp sevenSixtydhiData = new Form760DhiDataResp();
				sevenSixtydhiData.setStudentId(0L);
				data = sevenSixtydhiData;
				break;
			case "HISCP":
				Form8HiscpDataResp hiscpData = new Form8HiscpDataResp();
				hiscpData.setStudentId(0L);
				data = hiscpData;
				break;
			case "EAPP":
				Form9EAPPDataResp eappData = new Form9EAPPDataResp();
				eappData.setStudentId(0L);
				data = eappData;
				break;
			case "HSAPP":
				Form10HSAPPDataResp hsappData = new Form10HSAPPDataResp();
				hsappData.setStudentId(0L);
				data = hsappData;
				break;
			default:
				break;
			}
			StringBuilder mainHtml = new StringBuilder();
			boolean processReturn = utility.downloadPdfForm(data, mainHtml, abbreviation, templatePath, sheduleData);
			if (!processReturn) {
				throw new HomeInstructionException("Unable to generate PDF for form : " + abbreviation,
						Constant.DATABASE_ERROR_CODE);
			}
			String temporaryPath = configKeyValuesForF.get("FILETMPL");
			String temporaryPdfPath = temporaryPath + File.separator + templateFileName.replace(".html", ".pdf");
			String modifiedTemplatePath = temporaryPath + File.separator + "Modified" + templateFileName;
			modifiedHtmlFile = new File(modifiedTemplatePath);
			pdfFile = new File(temporaryPdfPath);

			FileUtils.writeStringToFile(modifiedHtmlFile, mainHtml.toString(), StandardCharsets.UTF_8);

			utility.generatePDF(modifiedHtmlFile.getAbsolutePath(), pdfFile.getAbsolutePath());

			if (!pdfFile.exists() || pdfFile.length() == 0) {

				throw new HomeInstructionException("PDF file was not generated for form: " + abbreviation,
						Constant.DATABASE_ERROR_CODE);
			}
			Resource resource = new UrlResource(pdfFile.toURI());
			utility.bindTheHttpServletResponse(resource, response);
			FileUtils.deleteQuietly(modifiedHtmlFile);
			return response;
		} catch (Exception e) {

			logger.error("Exception occurred while generating Application Tracking PDF for form {}: {}", abbreviation,
					e.getMessage(), e);

			throw new HomeInstructionException("Unable to generate PDF for form: " + abbreviation,
					Constant.DATABASE_ERROR_CODE, e);
		}
	}

}
