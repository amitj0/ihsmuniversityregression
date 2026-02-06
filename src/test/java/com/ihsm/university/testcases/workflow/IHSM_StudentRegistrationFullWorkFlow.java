package com.ihsm.university.testcases.workflow;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ihsm.university.base.BaseClass;
import com.ihsm.university.navigation.Student_Search;
import com.ihsm.university.testcases.flows.student.*;
import com.ihsm.university.utilities.ExtentListener;
import com.ihsm.university.utilities.RetryAnalyzer;

public class IHSM_StudentRegistrationFullWorkFlow extends BaseClass {

	@Test(retryAnalyzer = RetryAnalyzer.class, groups = "regression", description = "Verify Full Student Registration Flow in IHSM University", dataProvider = "studentData", dataProviderClass = StudentFullRegistrationDataProvider.class)
	public void verifyStudentRegistrationFullFlow(StudentFullRegistrationDataVariables student) throws Exception {

		logger.info("==== STARTING FULL STUDENT REGISTRATION FLOW ======");

		// ---------------- Basic Information ----------------
		new IHSM_FullBasicInformationFlow(getDriver()).execute(student);
		logger.info("Basic Information filled successfully");
		ExtentListener.getNode().pass("Student Full Basic Information Flow Passed");

		// ---------------- Documents ----------------
		new IHSM_FullDocumentsFlow(getDriver()).execute(student);
		logger.info("Documents Information filled successfully");
		ExtentListener.getNode().pass("Student Full Documents Information Flow Passed");

		// ---------------- Academics ----------------
		new IHSM_FullAcademicsFlow(getDriver()).execute(student);
		logger.info("Academics Information filled successfully");
		ExtentListener.getNode().pass("Student Full Academics Information Flow Passed");

		// ---------------- Status ----------------
		new IHSM_FullStatusFlow(getDriver()).execute(student);
		logger.info("Status Information filled successfully");
		ExtentListener.getNode().pass("Student Full Status Information Flow Passed");

		logger.info("===== FULL STUDENT REGISTRATION FLOW COMPLETED SUCCESSFULLY =====");
	}
}
