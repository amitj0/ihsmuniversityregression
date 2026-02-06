package com.ihsm.university.testcases.flows.exammanage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule_SubjectCredits;
import com.ihsm.university.pageobjects.exammanagement.IHSM_ManageExam;
import com.ihsm.university.pageobjects.student.status.Status_Status;
import com.ihsm.university.testcases.flows.student.StudentFullRegistrationDataVariables;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_ExamManage extends BaseClass {

	private WebDriver driver;

	public IHSM_ExamManage(WebDriver driver) {
		this.driver = driver;
	}

	@Test()
	public void verifyExamManage() {
		ExtentListener.createNode("Exam Manage Information");
		logger.info("Filling Exam Manage Information...");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;
		try {
			IHSM_ManageExam exam = new IHSM_ManageExam(getDriver());
			exam.fillExamManageInfo("CENTRAL / Bachelor / MBBS", "1", "01012026", "02012026");
			logger.info("Exam Managed Successfully");
			ExtentListener.getNode().pass("Exam Managed Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Exam Manage Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("Exam Manage INFORMATION");

		if (failCount == 0) {
			ExtentListener.getNode().pass("All Exam Manage Information sections executed successfully.");
		} else {
			ExtentListener.getNode().fail("Total Failed Sections in Exam Manage Information Flow: " + failCount);
		}

		soft.assertAll();

	}

}
