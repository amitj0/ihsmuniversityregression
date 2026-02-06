package com.ihsm.university.testcases.workflow;

import org.testng.annotations.Test;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.testcases.flows.exammanage.IHSM_ExamManage;
import com.ihsm.university.utilities.RetryAnalyzer;

public class IHSM_ExamScheduling extends BaseClass {

	@Test(retryAnalyzer = RetryAnalyzer.class, groups = "regression", description = "Verify Full EXAM Scheduling Work Flow in IHSM University")
	public void verifyExamManage() {

		IHSM_ExamManage exam = new IHSM_ExamManage(getDriver());
		exam.verifyExamManage();
		logger.info("Exam Scheduled Successfully");

	}

}
