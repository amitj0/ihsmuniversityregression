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

public class IHSM_ClassScheduling2 extends BaseClass {

	@Test(retryAnalyzer = RetryAnalyzer.class, groups = "regression", description = "Verify Full Group Assignment on IHSM University")
	public void verifyClassGroupAssignment() throws InterruptedException {

		IHSM_VerifyGroupAssignment group = new IHSM_VerifyGroupAssignment(getDriver());
		group.verifyGroupAssignment();
		logger.info("Group Assigned Successfully");

		IHSM_ShowDataGroupAssignTest data = new IHSM_ShowDataGroupAssignTest(getDriver());
		data.showDataofGroupAssignment();
		logger.info("Data Showed Successfully");

	}

}
