package com.ihsm.university.testcases.workflow;

import org.testng.annotations.Test;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule_SubjectHours;
import com.ihsm.university.pageobjects.classchedule.IHSM_FacultyGroupAssignment;
import com.ihsm.university.testcases.flows.classschedule.IHSM_ClassSchedulingInformationTest;
import com.ihsm.university.testcases.flows.classschedule.IHSM_ClassSubjectCreditTest;
import com.ihsm.university.testcases.flows.classschedule.IHSM_ShowDataGroupAssignTest;
import com.ihsm.university.testcases.flows.classschedule.IHSM_SubjectCreditHoursTest;
import com.ihsm.university.testcases.flows.classschedule.IHSM_VerifyGroupAssignment;
import com.ihsm.university.utilities.RetryAnalyzer;

public class IHSM_ClassScheduling extends BaseClass {

	@Test(retryAnalyzer = RetryAnalyzer.class, groups = "regression", description = "Verify full Subject Credit on IHSM University")
	public void verifyClassSubjectCredit() throws InterruptedException {

		IHSM_ClassSubjectCreditTest credit = new IHSM_ClassSubjectCreditTest(getDriver());
		credit.verifySubjectCredit();
		logger.info("Subject credit added successfully");

		IHSM_SubjectCreditHoursTest hours = new IHSM_SubjectCreditHoursTest(getDriver());
		hours.verifySubjectCredit();
		logger.info("Class Subject Hours added successfully");

	}

}
