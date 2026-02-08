package com.ihsm.university.testcases.workflow;

import org.testng.annotations.Test;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.testcases.flows.student.*;

public class IHSM_StudentMasterFlowTest extends BaseClass {

	@Test(dataProvider = "studentData", dataProviderClass = StudentFullRegistrationDataProvider.class)
	public void fullStudentRegistrationFlow(StudentFullRegistrationDataVariables student) throws Exception {

		// ================= BASIC INFO FLOW =================
		IHSM_BasicFullFlowTest basicFlow = new IHSM_BasicFullFlowTest();

		basicFlow.enrollmentInformation(student);
		basicFlow.personalInformation();
		basicFlow.biometricsInformation();
		basicFlow.familyInformation();
		basicFlow.languageInformation();
		basicFlow.preRightsInformation();
		basicFlow.socialStatusInformation();
		basicFlow.workLocationInformation();
		basicFlow.medicalVaccinationInformation();
		basicFlow.medicalAtPolyInformation();
		basicFlow.medicalInsuranceInformation();
		basicFlow.medicalDisabilityInformation();

		// ================= DOCUMENTS FLOW =================
		IHSM_DocumentFullFlowTest docFlow = new IHSM_DocumentFullFlowTest();

		docFlow.otherDocumentsInformation(student);
		docFlow.identificationInformation();
		docFlow.visaOfflineInformation();
		docFlow.visaOnlineInformation();
		docFlow.visaRegisterInformation();
		docFlow.passportLocationInformation();
		docFlow.passportInformation();
	}
}
