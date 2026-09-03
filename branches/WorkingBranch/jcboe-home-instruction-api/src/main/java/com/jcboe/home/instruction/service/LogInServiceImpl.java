/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jcboe.home.instruction.exception.HomeInstructionException;
import com.jcboe.home.instruction.mailconfig.EmailSender;
import com.jcboe.home.instruction.model.request.AdminLogInReq;
import com.jcboe.home.instruction.model.request.ParentLogInReq;
import com.jcboe.home.instruction.model.request.ParentRegReq;
import com.jcboe.home.instruction.model.request.VerifyOtpReq;
import com.jcboe.home.instruction.repo.AppConfigRepo;
import com.jcboe.home.instruction.repo.HomeInstructionRepo;
import com.jcboe.home.instruction.repo.LogInRepo;
import com.jcboe.home.instruction.repo.StudentDetailsRepo;
import com.jcboe.home.instruction.repo.UserDetailsRepo;
import com.jcboe.home.instruction.response.AdminLoginResp;
import com.jcboe.home.instruction.response.EmailResponse;
import com.jcboe.home.instruction.response.GetYearAbbrevResp;
import com.jcboe.home.instruction.response.JCBOEApplicationDTO;
import com.jcboe.home.instruction.response.LogInResponseDTO;
import com.jcboe.home.instruction.response.ParentLoginResp;
import com.jcboe.home.instruction.response.StudentDataResp;
import com.jcboe.home.instruction.response.StudentInfoImportResp;
import com.jcboe.home.instruction.response.VerifyOtpResponse;
import com.jcboe.home.instruction.utilities.AES;
import com.jcboe.home.instruction.utilities.Constant;
import com.jcboe.home.instruction.utilities.Utility;

/*
 * 
 * Date: 30-July-2026
 * Class: LogInServiceImpl.java
 *
 */
@Service
public class LogInServiceImpl implements ILogInServiceImpl {

	private final Logger logger = LogManager.getLogger(LogInServiceImpl.class);

	private LogInRepo logInRepo;
	private Utility utility;
	private StudentDetailsRepo studentDetailsRepo;
	private EmailSender emailSender;
	private IMessageService msgService;
	private UserDetailsRepo userDetailsRepo;
	private AppConfigRepo appConfigRepo;

	@Autowired
	public LogInServiceImpl(LogInRepo logInRepo, Utility utility, StudentDetailsRepo studentDetailsRepo,
			EmailSender emailSender, HomeInstructionRepo homeInstructionRepo, IMessageService msgService,
			UserDetailsRepo userDetailsRepo, AppConfigRepo appConfigRepo) {
		this.logInRepo = logInRepo;
		this.utility = utility;
		this.studentDetailsRepo = studentDetailsRepo;
		this.emailSender = emailSender;
		this.msgService = msgService;
		this.userDetailsRepo = userDetailsRepo;
		this.appConfigRepo = appConfigRepo;
	}

	@Override
	public LogInResponseDTO checkParentLogin(ParentLogInReq parentLogInReq) {// NOSONAR
		try {
			logger.debug("Request for checkParentLogin API: \n{} ",
					utility.printJson(parentLogInReq) != null ? utility.printJson(parentLogInReq)
							: parentLogInReq.toString());

			Map<String, String> configList = Collections.emptyMap();
			if (StringUtils.isNotBlank(parentLogInReq.getConfigKeys())) {
				configList = utility.getConfigList(parentLogInReq.getConfigKeys());
			}

			List<ParentLoginResp> dbResp = null;
			if (StringUtils.equalsAnyIgnoreCase(parentLogInReq.getIndicator(), "L")) {
				dbResp = logInRepo.checkParentLoginData(parentLogInReq);
			} else {
				msgService.getMessage(Constant.LOG_PAPW);
				return checkParentPwLogin(parentLogInReq, configList);
			}

			setDbResponseList(dbResp);

			LogInResponseDTO resp = null;

			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).isValid()) {

				logger.info("Parent login successful. For student: {}", dbResp.get(0).getLoggedInUserName());

				resp = new LogInResponseDTO(true, Constant.getMessageMap().get(Constant.PARNT_SUC),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());

				if (dbResp.get(0).isSamePassword()) {
					ParentRegReq parentRegReq = new ParentRegReq();
					parentRegReq.setIndicator("F");
					parentRegReq.setEmailId(dbResp.get(0).getEmailId());
					parentRegReq.setStudentDob(parentLogInReq.getStudentDob());
					parentRegReq.setStudentId(parentLogInReq.getStudentId());
					parentRegReq.setSamePassword(dbResp.get(0).isSamePassword());
					msgService.getMessage(Constant.LOG_PAPW);
					LogInResponseDTO pswResp = forgetPasswordStudent(parentRegReq);
					resp.setMessage(pswResp.getMessage());
					resp.setSuccess(false);
					resp.setSamePassword(dbResp.get(0).isSamePassword());
				}

				return resp;
			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 1) {

				logger.info("Unable to login. Invalid student id.");

				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PARNT_FAL1),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());

			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 2) {

				logger.info("Unable to login. Invalid Date of Birth.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PARNT_FAL2),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());

			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 3) {

				resp = new LogInResponseDTO(false,
						StringUtils.replace(Constant.getMessageMap().get(Constant.PARNT_FAL3), "{EMAIL}",
								dbResp.get(0).getEmailId()),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());
				ParentRegReq parentRegReq = new ParentRegReq();
				parentRegReq.setIndicator("L");
				parentRegReq.setEmailId(dbResp.get(0).getEmailId());
				parentRegReq.setStudentDob(parentLogInReq.getStudentDob());
				parentRegReq.setStudentId(parentLogInReq.getStudentId());
				parentRegReq.setSamePassword(dbResp.get(0).isSamePassword());
				msgService.getMessage(Constant.LOG_PAPW);
				LogInResponseDTO pswResp = submitRegistration(parentRegReq);
				resp.setMessage(pswResp.getMessage());
				resp.setSamePassword(dbResp.get(0).isSamePassword());

				return resp;
			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 5) {

				logger.info("Unable to login. Enter correct otp.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PARNT_FAL5),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, false);
			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 6) {

				logger.info("Student is disabled.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PARNT_FAL6),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, false);
			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 0) {

				logger.info("Unable to login. Invalid student id.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PARNT_FAL1),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());

			} else {
				logger.info("Unable to login.");

				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PARNT_FAL4),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());

			}

		} catch (Exception e) {
			logger.error("Request for checkParentLogin: {}\n", utility.printJson(parentLogInReq));
			logger.error("Error while calling parent log in: {} {} ", e.getMessage(), e);
			throw new HomeInstructionException(e.getMessage(), Constant.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public LogInResponseDTO checkParentPwLogin(ParentLogInReq parentPwChkReq, Map<String, String> configList) {

		try {
			logger.debug("Request for checkParentPwLogin API: \n{} ",
					utility.printJson(parentPwChkReq) != null ? utility.printJson(parentPwChkReq)
							: parentPwChkReq.toString());

			List<ParentLoginResp> dbResp = logInRepo.checkParentPwdData(parentPwChkReq);

			setDbResponseList(dbResp);

			LogInResponseDTO resp = null;

			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).isValid()) {

				List<StudentDataResp> studentListResp = appConfigRepo
						.getStudentData(parentPwChkReq.getStudentId(), "");

				logger.info("Parent login successful. For student: {}", dbResp.get(0).getLoggedInUserName());

				resp = new LogInResponseDTO(true, Constant.getMessageMap().get(Constant.PAPW_SUC),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());
				resp.setStudentListResp(studentListResp);
				return resp;
			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 1) {

				logger.info("Unable to login. Invalid student ID.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_FAL1),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());

			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 2) {

				logger.info("Unable to login. Invalid password.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_FAL2),
						utility.responseDate(LocalDateTime.now()), null, dbResp, dbResp.get(0).isValid());

			} else {
				logger.info("Unable to register due to id does not exists.");

				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_FAL3),
						utility.responseDate(LocalDateTime.now()), null, dbResp, dbResp.get(0).isValid());

			}

		} catch (Exception e) {
			logger.error("Request for checkParentPwLogin: {}\n", utility.printJson(parentPwChkReq));
			logger.error("Error while calling parent password login: {} {} ", e.getMessage(), e);
			throw new HomeInstructionException(e.getMessage(), Constant.INTERNAL_SERVER_ERROR);
		}

	}

	void setDbResponseList(List<ParentLoginResp> dbResp) throws Exception {

		List<GetYearAbbrevResp> abbrevYear = logInRepo.getSchoolYear();

		if (CollectionUtils.size(dbResp) > 0) {

			if (CollectionUtils.size(abbrevYear) > 1) {
				dbResp.get(0).setCurrentYear(abbrevYear.get(0).getLookupValue());
				dbResp.get(0).setPreviousYear(abbrevYear.get(1).getLookupValue());
				dbResp.get(0).setCurrentYearAbbr(abbrevYear.get(0).getLookupAbbreviation());
				dbResp.get(0).setPreviousYearAbbr(abbrevYear.get(1).getLookupAbbreviation());
			} else if (CollectionUtils.size(abbrevYear) > 0) {
				dbResp.get(0).setCurrentYear(abbrevYear.get(0).getLookupValue());
				dbResp.get(0).setCurrentYearAbbr(abbrevYear.get(0).getLookupAbbreviation());
			}
		}
	}

	@Override
	public LogInResponseDTO submitRegistration(ParentRegReq parentRegReq) {// NOSONAR
		try {
			logger.debug("Request for checkParentLogin API: \n{} ",
					utility.printJson(parentRegReq) != null ? utility.printJson(parentRegReq)
							: parentRegReq.toString());
			LogInResponseDTO resp = null;
			if (StringUtils.contains(parentRegReq.getIndicator(), "R")
					|| StringUtils.contains(parentRegReq.getIndicator(), "L")) {

				String otp = String.valueOf(new DecimalFormat("000000").format(new Random().nextInt(999999)));// NOSONAR
				String regCode = parentRegReq.getRegCode();
				parentRegReq.setRegCode(StringUtils.isAllEmpty(regCode) ? otp : "");

				List<StudentInfoImportResp> importStdResp = studentDetailsRepo.getImportStudentData(parentRegReq,
						regCode);

				EmailResponse result = StringUtils.isAllEmpty(regCode) ? sendEmailVerificationForParent(
						AES.decryptToString(parentRegReq.getStudentId(), Constant.SALT_AES),
						parentRegReq.getStudentDob(), parentRegReq.getEmailId(), otp, parentRegReq.getIndicator(),
						StringUtils.isBlank(importStdResp.get(0).getVerifiedOn()), parentRegReq.getStudentId(), "")
						: new EmailResponse();
				if (CollectionUtils.isNotEmpty(importStdResp) && importStdResp.get(0).getTagId() > 0
						&& !StringUtils.equalsIgnoreCase(result.getOtpSendOn(), "-1")) {

					logger.info("Parent registration successful.");
					String message = "";
					if (StringUtils.isEmpty(regCode)) {
						message = StringUtils.replaceIgnoreCase(Constant.getMessageMap().get(Constant.PAPW_SUC1),
								"<RegisteredEmail>", parentRegReq.getEmailId());
					} else {
						message = StringUtils.replaceIgnoreCase(Constant.getMessageMap().get(Constant.PAPW_FOTS),
								"<RegisteredEmail>", parentRegReq.getEmailId());
					}

					resp = new LogInResponseDTO(true, message, utility.responseDate(LocalDateTime.now()),
							Collections.emptyMap(), importStdResp, true);
					logger.info(message);
				} else if (CollectionUtils.isNotEmpty(importStdResp) && importStdResp.get(0).getTagId() == -4) {
					logger.info("Invalid OTP");

					resp = new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_FOTP),
							utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), new ArrayList<>(),
							false);
				} else if (CollectionUtils.isNotEmpty(importStdResp) && importStdResp.get(0).getTagId() == -1) {
					logger.info("Password can not be set to defaut password.");
					resp = new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_CNCP),
							utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), importStdResp, true);
					resp.setSamePassword(true);
				} else {
					logger.info("Error while sending registration mail.");

					resp = new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_FAL4),
							utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), new ArrayList<>(),
							false);
				}

			} else {
				logger.info("Invalid Email ID.");
				resp = new LogInResponseDTO(true, Constant.getMessageMap().get(Constant.PAPW_FAL4),
						utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), new ArrayList<>(), false);
			}

			return resp;

		} catch (Exception e) {
			logger.error("Request for submitRegistration: {}\n", utility.printJson(parentRegReq));
			logger.error("Error while calling submit Registration: {} {} ", e.getMessage(), e);
			throw new HomeInstructionException(e.getMessage(), Constant.INTERNAL_SERVER_ERROR);
		}

	}

	public EmailResponse sendEmailVerificationForParent(String studentId, String studentDob, String parentEmail, // NOSONAR
			String otp, String indicator, boolean isVerifiedOn, String encryptedStudentId, String userFName) {// NOSONAR

		EmailResponse resp = new EmailResponse();

		try {
			// Required Config Keys
			String mailConfigkeys = "TEMPL_PATH,EMAIL_HOST,EMAIL_PORT,SENDER_MAIL,"
					+ "SNDMLREGAUTH,SENDER_MAIL_PASSWORD," + "STUDENT_EMAIL_TMPL,REG_EMAIL_SUB,"
					+ "REG_USER_LINK,USER_URL_SUFFIX,APPLN_ABRV,FRGT_PW_EMAIL_TMPL,FRGT_PW_EMAIL_SUB,FRGT_PW_LINK,STUDENT_EMAIL_RGSTRD_TMPL";

			Map<String, String> APP_CONFIG_MAP = new LinkedHashMap<>();// NOSONAR

			APP_CONFIG_MAP = utility.getConfigList(mailConfigkeys);

			String appUrl = "";
			String appName = "";
			int appId = 0;// NOSONAR
			JavaMailSender config = null;

			// Get Application Name
			List<JCBOEApplicationDTO> applications = logInRepo.getApplicationByAbbr(APP_CONFIG_MAP.get("APPLN_ABRV"));
			if (applications != null && !applications.isEmpty()) {
				appName = applications.get(0).getApplicationName();
				appUrl = applications.get(0).getApplicationUrl();
				appId = applications.get(0).getApplicationId();// NOSONAR
			}

			boolean auth = false;
			if (APP_CONFIG_MAP.get(Constant.AUTHENTICATION_REQUIRED).equalsIgnoreCase("N")) {
				auth = false;
			} else {
				auth = true;
			}
			try {
				logger.info("Configuring mail properties for sending email.");
				config = emailSender.configureMailProperties(APP_CONFIG_MAP.get(Constant.EMAIL_HOST),
						Integer.parseInt(APP_CONFIG_MAP.get(Constant.EMAIL_PORT)),
						APP_CONFIG_MAP.get(Constant.SENDER_MAIL), APP_CONFIG_MAP.get(Constant.SENDER_MAIL_PAS), auth);
			} catch (Exception e) {
				logger.error("Error while configuring mail properties: ", e);
				resp.setOtpSendOn("-1");
				return resp;
			}

			if (StringUtils.equalsIgnoreCase(indicator, "R") || StringUtils.equalsIgnoreCase(indicator, "L")) {

				String templatePath = (isVerifiedOn || StringUtils.equalsIgnoreCase(indicator, "L"))
						? APP_CONFIG_MAP.get(Constant.MAIL_TEMPLATE_PATH) + File.separator
								+ APP_CONFIG_MAP.get("STUDENT_EMAIL_TMPL")
						: APP_CONFIG_MAP.get(Constant.MAIL_TEMPLATE_PATH) + File.separator
								+ APP_CONFIG_MAP.get("STUDENT_EMAIL_RGSTRD_TMPL");

				String mailSubject = APP_CONFIG_MAP.get("REG_EMAIL_SUB");

				mailSubject = utility.replaceSubjectParent(mailSubject, studentId, studentDob);

				String urlSuffix = APP_CONFIG_MAP.get(Constant.UREG_URL_SUFFIX);// NOSONAR

				// Generate Verification Link
				String link = APP_CONFIG_MAP.get("REG_USER_LINK");
				link = StringUtils.replaceEach(link, new String[] { "<URL>", "<StudentID>" },
						new String[] { StringUtils.defaultString(appUrl),
								StringUtils.defaultString(utility.encodeURIComponent(encryptedStudentId)) });// NOSONAR

				String[] toMail = new String[] { parentEmail };

				Map<String, String> replacers = new HashMap<>();
				replacers.put("{STUDENT_ID}", studentId);
				replacers.put("{STUDENT_DOB}", utility.changeDateFormatPattern(studentDob, "MM/dd/yyyy", "MM.dd.yyyy"));
				replacers.put("{ONE_TIME_CODE}", otp);
				replacers.put("{APPLICATION_NAME}", appName);
				replacers.put("{APPLICATION_HYPER_LINK}",
						(isVerifiedOn || StringUtils.equalsIgnoreCase(indicator, "L")) ? link : "");

				File templateFile = new File(templatePath);
				emailSender.sendMail(config, toMail, new String[0], new String[0], mailSubject, replacers,
						templateFile.getAbsolutePath().replace("%20", " "));

				logger.info("Verification mail sent successfully to: {}", parentEmail);

				resp.setOtpSendOn("1");
				resp.setStudentEmailId(parentEmail);
				resp.setStudentDob(studentDob);

			} else if (StringUtils.equalsIgnoreCase(indicator, "F")) {

				String templatePath = APP_CONFIG_MAP.get(Constant.MAIL_TEMPLATE_PATH) + File.separator
						+ APP_CONFIG_MAP.get("FRGT_PW_EMAIL_TMPL");

				String mailSubject = APP_CONFIG_MAP.get("FRGT_PW_EMAIL_SUB");

				mailSubject = utility.replaceSubjectParent(mailSubject, studentId, studentDob);

				String urlSuffix = APP_CONFIG_MAP.get(Constant.UREG_URL_SUFFIX);// NOSONAR

				// Generate Verification Link
				String link = APP_CONFIG_MAP.get("FRGT_PW_LINK");
				link = StringUtils.replaceEach(link, new String[] { "<URL>", "<StudentID>" },
						new String[] { StringUtils.defaultString(appUrl),
								StringUtils.defaultString(utility.encodeURIComponent(encryptedStudentId)) });// NOSONAR
				String[] toMail = new String[] { parentEmail };

				Map<String, String> replacers = new HashMap<>();
				replacers.put("{STUDENT_ID}", studentId);
				replacers.put("{STUDENT_DOB}", studentDob);
				replacers.put("{APPLICATION_NAME}", appName);
				replacers.put("{APPLICATION_FORGOT_HYPER_LINK}", link);

				File templateFile = new File(templatePath);
				emailSender.sendMail(config, toMail, new String[0], new String[0], mailSubject, replacers,
						templateFile.getAbsolutePath().replace("%20", " "));

				logger.info("Password reset mail sent successfully to: {}", parentEmail);

				resp.setOtpSendOn("0");
				resp.setStudentEmailId(parentEmail);
				resp.setStudentDob(studentDob);
			} else {
				logger.info("Invalid indicator value provided: {}", indicator);
				resp.setOtpSendOn("-1");
			}

		} catch (Exception e) {
			logger.error("Error while sending verification mail: {}", e);// NOSONAR
			resp.setOtpSendOn("-1");
		}

		return resp;
	}

	@Override
	public VerifyOtpResponse verfyOtpStudent(VerifyOtpReq verifyOtpReq) {
		try {
			logger.debug("verfy studet Otp API: \n{} ",
					utility.printJson(verifyOtpReq) != null ? utility.printJson(verifyOtpReq)
							: verifyOtpReq.toString());

			List<Long> resultList = userDetailsRepo.verifyUserOtp(verifyOtpReq);

			VerifyOtpResponse resp = null;

			if (CollectionUtils.isNotEmpty(resultList) && resultList.get(0) > 0) {

				logger.info("OTP verify successfully");

				resp = new VerifyOtpResponse(true, Constant.getMessageMap().get(Constant.VFO_OVS),
						utility.responseDate(LocalDateTime.now()));
				return resp;
			} else if (CollectionUtils.isNotEmpty(resultList) && resultList.get(0) == -1) {

				logger.info("Invalid Student id");

				resp = new VerifyOtpResponse(false, Constant.getMessageMap().get(Constant.VFO_ISD),
						utility.responseDate(LocalDateTime.now()));
				return resp;
			} else if (CollectionUtils.isNotEmpty(resultList) && resultList.get(0) == -2) {

				logger.info("Invalid OTP");

				resp = new VerifyOtpResponse(false, Constant.getMessageMap().get(Constant.VFO_EVOP),
						utility.responseDate(LocalDateTime.now()));
				return resp;
			} else {
				logger.info("Error while validating the otp.");

				resp = new VerifyOtpResponse(false, "", utility.responseDate(LocalDateTime.now()));
				return resp;
			}

		} catch (Exception e) {
			logger.error("Request for forgetPasswordUser: {}\n", utility.printJson(verifyOtpReq));
			logger.error("Error while calling forget Password User: {} {} ", e.getMessage(), e);
			throw new HomeInstructionException(e.getMessage(), Constant.DATABASE_ERROR_CODE);
		}
	}

	@Override
	public LogInResponseDTO forgetPasswordStudent(ParentRegReq parentRegReq) {// NOSONAR
		try {
			logger.debug("Request for forgetPasswordStudent API: \n{} ",
					utility.printJson(parentRegReq) != null ? utility.printJson(parentRegReq)
							: parentRegReq.toString());
			LogInResponseDTO resp = null;
			if (StringUtils.contains(parentRegReq.getIndicator(), "F")) {

				List<Object> resultList = studentDetailsRepo.verifyEmail(parentRegReq);

				boolean checkValidMail = false;

				if (resultList != null && !resultList.isEmpty()) {
					checkValidMail = (boolean) resultList.get(0);
					if (!checkValidMail) {
						logger.info("Invalid Email ID.");
						resp = new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_FAL4),
								utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), new ArrayList<>(),
								false);
						return resp;
					}
				}

				EmailResponse result = checkValidMail
						? sendEmailVerificationForParent(
								AES.decryptToString(parentRegReq.getStudentId(), Constant.SALT_AES),
								parentRegReq.getStudentDob(), parentRegReq.getEmailId(), "",
								parentRegReq.getIndicator(), true, parentRegReq.getStudentId(), "")
						: new EmailResponse();
				if (!StringUtils.equalsIgnoreCase(result.getOtpSendOn(), "-1")) {

					logger.info("Password reset mail sent successfully.");
					String msg = Constant.getMessageMap().get(Constant.PAPW_SUC2);

					if (parentRegReq.isSamePassword()) {
						msg = StringUtils.replace(Constant.getMessageMap().get(Constant.PAPW_SUCS), "{EMAIL}",
								parentRegReq.getEmailId());
					}

					resp = new LogInResponseDTO(true, msg, utility.responseDate(LocalDateTime.now()),
							Collections.emptyMap(), new ArrayList<>(), true);
				} else {
					logger.info("Error while sending password reset mail.");

					resp = new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_FAL4),
							utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), new ArrayList<>(),
							false);
				}
			} else if (StringUtils.contains(parentRegReq.getIndicator(), "S")) {
				List<StudentInfoImportResp> importStdResp = studentDetailsRepo.getImportStudentData(parentRegReq, null);
				if (CollectionUtils.isNotEmpty(importStdResp) && importStdResp.get(0).getTagId() > 0) {

					logger.info("Password changed successfully.");
					resp = new LogInResponseDTO(true, Constant.getMessageMap().get(Constant.PAPW_FPRS),
							utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), importStdResp, true);
				} else if (CollectionUtils.isNotEmpty(importStdResp) && importStdResp.get(0).getTagId() == -1) {
					logger.info("Password can not be set to defaut password.");
					resp = new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_CNCP),
							utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), importStdResp, true);
					resp.setSamePassword(true);
				} else {
					logger.info("Error while changing password.");
					resp = new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.PAPW_FAL5),
							utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), new ArrayList<>(),
							false);
				}

			} else {
				logger.info("Invalid Email ID.");
				resp = new LogInResponseDTO(true, Constant.getMessageMap().get(Constant.PAPW_FAL4),
						utility.responseDate(LocalDateTime.now()), Collections.emptyMap(), new ArrayList<>(), false);
			}

			return resp;

		} catch (Exception e) {
			logger.error("Request for ForgetPasswordStudent: {}\n", utility.printJson(parentRegReq));
			logger.error("Error while calling forgetPasswordStudent : {} {} ", e.getMessage(), e);
			throw new HomeInstructionException(Constant.DATABASE_ERROR_MSG, Constant.DATABASE_ERROR_CODE);
		}

	}

	@Override
	public LogInResponseDTO checkAdminLogin(AdminLogInReq adminLogInReq) {
		try {
			logger.debug("Request for checkAdminLogin API: \n{} ",
					utility.printJson(adminLogInReq) != null ? utility.printJson(adminLogInReq)
							: adminLogInReq.toString());

			Map<String, String> configList = Collections.emptyMap();
			boolean isSystemAdmin = StringUtils
					.equalsIgnoreCase((AES.decryptToString(adminLogInReq.getUserId(), Constant.SALT_AES)), "7777777");
			if (StringUtils.isNotBlank(adminLogInReq.getConfigKeys())) {
				configList = utility.getConfigList(adminLogInReq.getConfigKeys());
			}

			List<AdminLoginResp> dbResp;

			if (isSystemAdmin) {
				dbResp = new ArrayList<>();
				dbResp.add(new AdminLoginResp(true, 4, 0, "System", "ADMN"));
				dbResp.get(0).setSystemAdmin(true);
			} else {
				dbResp = logInRepo.checkAdminLoginData(adminLogInReq);
			}

			List<GetYearAbbrevResp> abbrevYear = logInRepo.getSchoolYear();

			if (CollectionUtils.size(abbrevYear) > 1) {
				dbResp.get(0).setCurrentYear(abbrevYear.get(0).getLookupValue());
				dbResp.get(0).setPreviousYear(abbrevYear.get(1).getLookupValue());
				dbResp.get(0).setCurrentYearAbbr(abbrevYear.get(0).getLookupAbbreviation());
				dbResp.get(0).setPreviousYearAbbr(abbrevYear.get(1).getLookupAbbreviation());
			} else if (CollectionUtils.size(abbrevYear) > 0) {
				dbResp.get(0).setCurrentYear(abbrevYear.get(0).getLookupValue());
				dbResp.get(0).setCurrentYearAbbr(abbrevYear.get(0).getLookupAbbreviation());
			}
			if (isSystemAdmin) {
				return new LogInResponseDTO(true, Constant.getMessageMap().get(Constant.ADM_SUC),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, true);
			}
			LogInResponseDTO resp = null;

			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).isValid()) {

				logger.info("Admin Login successful. For user: {}", dbResp.get(0).getLoggedInUserName());

				resp = new LogInResponseDTO(true, Constant.getMessageMap().get(Constant.ADM_SUC),
						utility.responseDate(LocalDateTime.now()), configList, dbResp, dbResp.get(0).isValid());
				return resp;
			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 1) {

				logger.info("Unable to login. Invalid email ID.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.ADM_FAL1),
						utility.responseDate(LocalDateTime.now()), null, dbResp, dbResp.get(0).isValid());

			}
			if (CollectionUtils.isNotEmpty(dbResp) && dbResp.get(0).getStatusCode() == 2) {

				logger.info("Unable to login. Invalid password.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.ADM_FAL2),
						utility.responseDate(LocalDateTime.now()), null, dbResp, dbResp.get(0).isValid());

			} else {
				logger.info("Unable to register due to id does not exists.");
				return new LogInResponseDTO(false, Constant.getMessageMap().get(Constant.ADM_FAL3),
						utility.responseDate(LocalDateTime.now()), null, dbResp, dbResp.get(0).isValid());

			}

		} catch (Exception e) {
			logger.error("Request for checkAdminLogin: {}\n", utility.printJson(adminLogInReq));
			logger.error("Error while calling Admin Login: {} {} ", e.getMessage(), e);
			throw new HomeInstructionException(e.getMessage(), Constant.INTERNAL_SERVER_ERROR);
		}

	}
}
