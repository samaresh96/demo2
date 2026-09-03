/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.service;

import com.jcboe.home.instruction.model.request.GetStudentInfoReqById;
import com.jcboe.home.instruction.response.GetStudentParentInfoResp;
import com.jcboe.home.instruction.response.ScreenTextResponse;

public interface IAppConfigServiceImpl {

	ScreenTextResponse getScreenTextValues(int screenId, int languageId);

	GetStudentParentInfoResp getStudentInfoByStudentId(GetStudentInfoReqById submittedFormReq);

}
