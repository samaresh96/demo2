/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import java.util.Map;

import com.jcboe.home.instruction.model.request.AdminLogInReq;
import com.jcboe.home.instruction.model.request.ParentLogInReq;
import com.jcboe.home.instruction.model.request.ParentRegReq;
import com.jcboe.home.instruction.model.request.VerifyOtpReq;
import com.jcboe.home.instruction.response.LogInResponseDTO;
import com.jcboe.home.instruction.response.VerifyOtpResponse;

public interface ILogInServiceImpl {

	LogInResponseDTO checkParentLogin(ParentLogInReq parentLogInReq);

	LogInResponseDTO checkParentPwLogin(ParentLogInReq parentPwChkReq, Map<String, String> configList);

	LogInResponseDTO submitRegistration(ParentRegReq parentRegReq);

	VerifyOtpResponse verfyOtpStudent(VerifyOtpReq verifyOtpReq);

	LogInResponseDTO forgetPasswordStudent(ParentRegReq parentRegReq);

	LogInResponseDTO checkAdminLogin(AdminLogInReq adminLogInReq);

}
