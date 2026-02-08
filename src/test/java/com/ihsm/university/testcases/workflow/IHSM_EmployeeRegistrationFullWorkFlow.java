package com.ihsm.university.testcases.workflow;

import org.testng.annotations.Test;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.testcases.flows.employee.IHSM_FullBasicInformationFlow;
import com.ihsm.university.testcases.flows.employee.IHSM_FullDesignationFlow;
import com.ihsm.university.testcases.flows.employee.IHSM_FullDocumentsFlow;
import com.ihsm.university.testcases.flows.employee.IHSM_FullProfessionalInformation;
import com.ihsm.university.utilities.ExtentListener;
import com.ihsm.university.utilities.RetryAnalyzer;

public class IHSM_EmployeeRegistrationFullWorkFlow extends BaseClass {

	@Test(retryAnalyzer = RetryAnalyzer.class, groups = "regression", description = "Verify Full Employee Registration Flow in IHSM University")
	public void verifyEmployeeRegistrationFullFlow() throws Exception {
		System.out.println("==== STARTING FULL EMPLOYEE REGISTRATION FLOW ====== ");

		IHSM_FullBasicInformationFlow basicInformationFlow = new IHSM_FullBasicInformationFlow();
		basicInformationFlow.execute();
		logger.info("Basic Information filled successfully..........");
		ExtentListener.getNode().pass("Employee Full Basic Information Flow Passed");

//		IHSM_FullDesignationFlow designInformationFlow = new IHSM_FullDesignationFlow();
//		designInformationFlow.execute();
//		logger.info("Designation Information filled successfully.......");
//		ExtentListener.getNode().pass("Employee Full Designation Information Flow Passed");
//
//		IHSM_FullProfessionalInformation profInfoFlow = new IHSM_FullProfessionalInformation();
//		profInfoFlow.execute();
//		logger.info("Professional Information filled successfully.......");
//		ExtentListener.getNode().pass("Employee Full Professional Information Flow Passed");

		IHSM_FullDocumentsFlow docInfoFlow = new IHSM_FullDocumentsFlow();
		docInfoFlow.execute();
		logger.info("Documents Information filled successfully........");
		ExtentListener.getNode().pass("Employee Full Documents Information Flow Passed");

		System.out.println("===== FULL EMPLOYEE REGISTRATION FLOW COMPLETED SUCCESSFULLY =====");

	}

}
