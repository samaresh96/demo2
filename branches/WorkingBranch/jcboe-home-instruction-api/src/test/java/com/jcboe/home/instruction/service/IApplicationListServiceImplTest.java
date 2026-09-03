package com.jcboe.home.instruction.service;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.jcboe.home.instruction.model.request.ApplicationTrackingRequest;
import com.jcboe.home.instruction.model.request.GetAppListReq;
import com.jcboe.home.instruction.model.request.UpdateAssignTeacherReq;
import com.jcboe.home.instruction.model.request.UpdateHIActivityReq;
import com.jcboe.home.instruction.model.request.UpdateHIApplicationReq;
import com.jcboe.home.instruction.response.ApplicationListResponseDTO;
import com.jcboe.home.instruction.response.ApplicationTrackingResp;
import com.jcboe.home.instruction.response.ApplicationTrackingResponseDTO;
import com.jcboe.home.instruction.response.AssignTeacherResponse;
import com.jcboe.home.instruction.response.GetApplicationInfoResp;
import com.jcboe.home.instruction.response.HIActivityResponseDTO;
import com.jcboe.home.instruction.response.UpdateApplicationResp;

class IApplicationListServiceImplTest {

	@Test
	void testInterfaceImplementation() {

		IApplicationListServiceImpl service = new IApplicationListServiceImpl() {

			@Override
			public ApplicationListResponseDTO getAppList(GetAppListReq req) {
				return null;
			}

			@Override
			public GetApplicationInfoResp getApplicationInfo(Long id, Long applicationId, Long formMasterId,
					String loggedInUserId, String loggedInUserPersonType, String configKeys, String lookupValues,
					boolean isFormMaster, boolean isPdfDetail, boolean isAttchment, boolean isNotification,
					boolean isStudent) {
				return null;
			}

			@Override
			public UpdateApplicationResp updateApplication(UpdateHIApplicationReq updateHIApplicationReq) {
				return null;
			}

			@Override
			public ApplicationTrackingResp updateApplicationTrackingData(
					ApplicationTrackingRequest applicationTrackingRequest) {
				return null;
			}

			@Override
			public ApplicationTrackingResponseDTO getApplicationTrackingData(String applicationIds, String schoolYear,
					String loggedInUser, String loggedInUserPersonType, String configKeys, String lookupValues) {
				return null;
			}

			@Override
			public HIActivityResponseDTO updateActivity(UpdateHIActivityReq hIActivityRequest) {
				return null;
			}

			@Override
			public AssignTeacherResponse updateAssignTeacher(UpdateAssignTeacherReq updateAssignTeacherReq) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		assertNull(service.getAppList(new GetAppListReq()));

		assertNull(service.getApplicationInfo(1L, 2L, 3L, "userId", "userType", "configKeys", "lookupValues", true,
				false, false, false, true));

		assertNull(service.updateApplication(new UpdateHIApplicationReq()));

		assertNull(service.updateApplicationTrackingData(new ApplicationTrackingRequest()));

		assertNull(service.getApplicationTrackingData("1", "2026", "userId", "userType", "configKeys", "lookupValues"));

		assertNull(service.updateActivity(new UpdateHIActivityReq()));
	}
}
